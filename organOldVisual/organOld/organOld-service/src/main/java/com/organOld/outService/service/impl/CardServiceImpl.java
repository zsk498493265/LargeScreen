package com.organOld.outService.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.CardSum;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.record.Record;
import com.organOld.dao.repository.CardDao;
import com.organOld.dao.repository.OldmanDao;
import com.organOld.dao.repository.RecordDao;
import com.organOld.dao.util.Page;
import com.organOld.outService.constant.ValueConstant;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.CardRequest;
import com.organOld.outService.contract.Result;
import com.organOld.outService.dwr.Remote;
import com.organOld.outService.enumModel.CardStatusEnum;
import com.organOld.outService.enumModel.RecordTypeEnum;
import com.organOld.outService.model.*;
import com.organOld.outService.service.*;
import com.organOld.dao.util.bean.QrCodeData;
import com.organOld.outService.wrapper.CardWrapper;
import com.swetake.util.Qrcode;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by netlab606 on 2018/6/25.
 */
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardDao cardDao;
    @Autowired
    CommonService commonService;
    @Autowired
    RecordDao recordDao;
    @Autowired
    OldmanService oldmanService;
    @Autowired
    RecordService recordService;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    CardWrapper cardWrapper;
    @Autowired
    OrganService organService;


    @Override
    public String getByPage(CardRequest cardRequest, BTableRequest bTableRequest) {
        Page<Card> page=commonService.getPage(bTableRequest,"card");
        Card card= cardWrapper.unwrap(cardRequest);
        page.setEntity(card);
        List<CardModel> cardModelList=cardDao.getByPage(page).stream().map(cardWrapper::wrap).collect(Collectors.toList());
        Long size=cardDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,cardModelList);
    }

    @Override
    public String getSumByPage(BTableRequest bTableRequest) {
        Page<Card> page=commonService.getPage(bTableRequest,"card");
        List<CardSum> cardList=cardDao.getAll(page);
        cardList.forEach(item->{
            if(item.getName()==null){
                item.setName("非本街道");
            }
        });
        Long size=cardDao.getAllSizeByPage(page);
        size++;//非本街道
        return commonService.tableReturn(bTableRequest.getsEcho(),size,cardList);
    }

    @Override
    @Transactional
    public Result addMoney(String[] ids, Double money) {
        List<Record> recordList=new ArrayList<>();
        for(String id:ids){
            Card card=cardDao.getById(Integer.parseInt(id));
            Record record=new Record();
            record.setOldmanId(card.getOldmanId());
            record.setType(RecordTypeEnum.CQ.getIndex());
            record.setData(money+"");
            record.setPrevMoney(card.getMoney());
            record.setNowMoney(card.getMoney()+money);
            recordList.add(record);
        }
        cardDao.addMoney(ids,money);
        recordDao.saveAll(recordList);
        return new Result(true);
    }

    @Override
    public Result changeStatus(String[] ids, String status) {
        cardDao.updateProps("status",status,ids);
        return new Result(true);
    }

    @Override
    public Integer getIdByOldmanId(int oldmanId) {
        Card card=cardDao.getByOldmanId(oldmanId);
        if(card==null) return null;
        return card.getId();
    }

    @Override
    public Result handleInfo(String cid, int organId) {
        OldmanAllInfoModel oldmanAllInfoModel = null;
        try {
            Card card=cardDao.getByCid(cid);
            if (card == null)
                return new Result(false, "卡号不存在");

            if(card.getStatus()!=4)
                return new Result(false,"该卡未激活，当前状态："+CardStatusEnum.getValue(card.getStatus()));
            oldmanAllInfoModel=oldmanService.getOldmanInfo(card.getOldmanId());
            if (oldmanAllInfoModel == null)
                return new Result(false, "老人不在数据库中或已被删除");

            Record record2=new Record();
            record2.setOldmanId(card.getOldmanId());
            record2.setType(RecordTypeEnum.INFO.getIndex());
            record2.setOrganId(organId);
            recordService.saveEntity(record2);

            Remote.noticeByfunction("finshRecord",organId);

        }catch (MyBatisSystemException e){
            e.printStackTrace();
            if(e.toString().contains("TooManyResultsException"))
                return new Result(false,"卡号重复，请修改卡号");
            else
                return new Result(false,"服务器错误");
        }catch (Exception e){
            e.printStackTrace();
        }

        return new Result(true,oldmanAllInfoModel);
    }

    @Override
    public Result handleIntegral(String cid, int organId, int type, int minus) {

        Result result=null;
        try {
            Card card=cardDao.getByCid(cid);
            if (card == null)
                return new Result(false, "卡号不存在");
            if(card.getStatus()!=4)
                return new Result(false,"该卡未激活，当前状态："+CardStatusEnum.getValue(card.getStatus()));
            Record record2=new Record();
            record2.setOldmanId(card.getOldmanId());
            record2.setType(RecordTypeEnum.IN.getIndex());
            record2.setOrganId(organId);

            result = oldmanService.getIntegralByOldmanId(card.getOldmanId());
            int nowIntegral=(int)((OrganQueryIntegralModel)result.getData()).getIntegral();

            if(type==1){
                record2.setOrder("2");
                if(nowIntegral<minus){
                    //兑换失败
                    record2.setData("0");
                    result=new Result(false,"兑换失败，积分不够用，当前积分："+nowIntegral);
                }else {
                    record2.setData(minus+"");
                    result=new Result(true,"兑换成功！扣除积分："+minus+"    剩余积分："+(nowIntegral-minus));
                    //积分变动记录
                    Record record = new Record();
                    record.setType(RecordTypeEnum.JF.getIndex());
                    record.setOldmanId(card.getOldmanId());
                    record.setOrder("4");
                    record.setData(minus+"");
                    record.setPrevMoney((double) nowIntegral);
                    record.setNowMoney((double) (nowIntegral-minus));
                    oldmanDao.addInregral(card.getOldmanId(), -minus);
                    recordService.saveEntity(record);
                }
            }else {
                result=new Result(true,"当前积分："+nowIntegral);
                record2.setOrder("1");
            }
            recordService.saveEntity(record2);
            Remote.noticeByfunction("finshRecord",organId);

        }catch (MyBatisSystemException e){
            e.printStackTrace();
            if(e.toString().contains("TooManyResultsException"))
                return new Result(false,"卡号重复，请修改卡号");
            else
                return new Result(false,"服务器错误");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public Result handleSign(String cid, int organId, int type, int peopleType, String name, int hdType, String hdTime) {

        try {
            Card card = cardDao.getByCid(cid);
            if (card == null)
                return new Result(false, "卡号不存在");

            if(card.getStatus()!=4)
                return new Result(false,"该卡未激活，当前状态："+CardStatusEnum.getValue(card.getStatus()));
            Oldman oldman = oldmanDao.getIntegralByOldmanId(card.getOldmanId());
            if (oldman == null)
                return new Result(false, "老人不存在或老人已被删除");
//            Integer signCount=Integer.parseInt(organService.getProp("sign_count",organId));
//            if(signCount!=null && signCount!=0) {
//                Integer oldmanSignCount = recordService.getCountByOldmanIdToday(card.getOldmanId(), RecordTypeEnum.SIGN.getIndex(),organId);
//                if(oldmanSignCount>=signCount)
//                    return new Result(false,"签到失败，今天签到次数已上限");
//            }
            Integer count=0;//活动签到  某个老人 签到次数 积分只积一次
            if(type!=0) {
                count= cardDao.getHdCount(organId,card.getOldmanId(),name,hdType,hdTime);

            }
            Record record2 = new Record();
            record2.setPeopleType(peopleType);
            record2.setOldmanId(card.getOldmanId());
            record2.setType(RecordTypeEnum.SIGN.getIndex());
            record2.setOrder("1");
            if(type!=0){
                record2.setOrder("2");
                record2.setName(name);
                record2.setHdType(hdType);
                record2.setHdTime(hdTime);
            }
            record2.setOrganId(organId);
            recordService.saveEntity(record2);

            int integral=0;
            String order="";
            if(type==0){
                order="2";
                integral=ValueConstant.INTEGRAL_RULE_SIGN_RC;
            }else{
                order="3";
                switch (peopleType){
                    case 0:
                        integral=ValueConstant.INTEGRAL_RULE_SIGN_HD_CY;
                        break;
                    case 1:
                        integral=ValueConstant.INTEGRAL_RULE_SIGN_HD_ZZ;
                        break;
                    case 2:
                        integral=ValueConstant.INTEGRAL_RULE_SIGN_HD_QT;
                        break;
                }
            }

            if(integral!=0) {
                if(type!=0 && count>0){
                    //同一活动 只积分一次
                }else {
                    //积分变动记录
                    Record record = new Record();
                    record.setType(RecordTypeEnum.JF.getIndex());
                    record.setOldmanId(card.getOldmanId());
                    record.setOrder(order);
                    record.setData(integral + "");
                    record.setPrevMoney(Double.valueOf(oldman.getIntegral()));
                    record.setNowMoney(Double.valueOf(oldman.getIntegral()) + integral);
                    oldmanDao.addInregral(card.getOldmanId(), integral);
                    recordService.saveEntity(record);
                }
            }
            Remote.noticeByfunction("finshRecord",organId);

        } catch (MyBatisSystemException e){
            e.printStackTrace();
            if(e.toString().contains("TooManyResultsException"))
                return new Result(false,"卡号重复，请修改卡号");
            else
                return new Result(false,"服务器错误");
        }catch (Exception e){
            e.printStackTrace();
        }

        Result result=new Result(true,"签到成功");
        return result;
    }

    @Override
    public Result handleConsume(int cid, int organId, String order, String oldmanPassword, String m) {
//        Double money=Double.parseDouble(m);
//        Result check=checkCanConsume(cid,oldmanPassword,money);
//        if(check.isSuccess()) {
//            Card card = cardDao.getByCid(cid);
//            Record record = new Record();
//            record.setType(RecordTypeEnum.CONSUME.getIndex());
//            record.setOrder(order);
//            record.setOldmanId(card.getOldmanId());
//            record.setData(money + "");
//            record.setOrganId(organId);
//            record.setPrevMoney(card.getMoney());
//            record.setNowMoney(card.getMoney() - money);
//            recordService.saveEntity(record);
//            cardDao.updateProp("money",record.getNowMoney()+"",card.getId());
//            Result result = new Result(true, "消费成功");
//            return result;
//        }else{
            Result result = new Result(false, "消费失败");
            return result;
//        }
    }

    //TODO 老人密码验证
    private Result checkCanConsume(String cid, String oldmanPassword, Double money) {
        Card card=cardDao.getByCid(cid);
        if(card.getMoney()<money){
            return new Result(false,"消费失败，余额不足");
        }else{
            return new Result(true);
        }
    }



    @Override
    public void createZip(String[] ids, HttpServletResponse response, HttpServletRequest request) {
        List<QrCodeData> qrCodeDataList=cardDao.getQrDataByIds(ids);
        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        excelReturnModel.setTotal(ids.length);
        int numSuccess=0;
//        excelReturnModel.setNumSuccess(qrCodeDataList.size());
//        int sucessAdd=0,failNum=0;
        try {
            String rela_path="img/";
            String root_path = request.getSession().getServletContext().getRealPath(rela_path);

            File zipFile = new File(root_path+"/qrCode.zip");
            byte[] buf = new byte[1024];
            int len;

            ZipOutputStream zout=new ZipOutputStream(new FileOutputStream(zipFile));

            for (QrCodeData qrCodeData : qrCodeDataList) {
                Qrcode qrcode = new Qrcode();
                qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）
                qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
                qrcode.setQrcodeVersion(7);//版本
                //生成二维码中要存储的信息
                String qrData = qrCodeData.getCid();
                //设置一下二维码的像素
                int width = 67 + 12 * (7 - 1);
                int height = 67 + 12 * (7 - 1);
                BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                //绘图
                Graphics2D gs = bufferedImage.createGraphics();
                gs.setBackground(Color.WHITE);
                gs.setColor(Color.BLACK);
                gs.clearRect(0, 0, width, height);//清除下画板内容

                //设置下偏移量,如果不加偏移量，有时会导致出错。
                int pixoff = 2;

                byte[] d = qrData.getBytes("gb2312");
                if (d.length > 0 && d.length < 120) {
                    boolean[][] s = qrcode.calQrcode(d);
                    for (int i = 0; i < s.length; i++) {
                        for (int j = 0; j < s.length; j++) {
                            if (s[j][i]) {
                                gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                            }
                        }
                    }
                }
                gs.dispose();
                bufferedImage.flush();

                File file=new File(root_path+"/qrCode/" + qrCodeData.getName()+qrCodeData.getCid() + ".png");
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }

                ImageIO.write(bufferedImage, "png", file);
                FileInputStream fileInputStream=new FileInputStream(file);

                zout.putNextEntry(new ZipEntry(qrCodeData.getName()+qrCodeData.getCid() + ".png"));
                while ((len = fileInputStream.read(buf)) > 0) {
                    zout.write(buf, 0, len);
                }
                zout.closeEntry();
                fileInputStream.close();

                numSuccess++;
//                sucessAdd++;
                cardDao.updateProp("is_create","1",qrCodeData.getId());
            }

            zout.close();
            //下载图片
            FileInputStream zipInput =new FileInputStream(zipFile);
            OutputStream out = response.getOutputStream();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=QRcode.zip");
            while ((len=zipInput.read(buf))!= -1){
                out.write(buf,0,len);
            }
            zipInput.close();
            out.flush();
            out.close();
            //删除压缩包
            zipFile.delete();

            excelReturnModel.setNumSuccess(numSuccess);
            Result result=new Result(true,excelReturnModel);
            Remote.noticeQrCode(result);
        }catch (Exception e){
            e.printStackTrace();
//            failNum++;
        }
//        excelReturnModel.setSuccessAdd(sucessAdd);
//        excelReturnModel.setNumFail(failNum);
    }

    @Override
    public Result getById(Integer id) {
        return new Result(true,cardDao.getById(id));
    }

    @Override
    public void updateById(Card card) {
        cardDao.updateById(card);
    }

    @Override
    public void delByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        cardDao.delByIds(id);
    }

    @Override
    public void add(Card card) {
        cardDao.save(card);
    }


    @Override
    public Result handleJh(String cid) {
        cardDao.updatePropByCid("status", CardStatusEnum.JH.getIndex()+"",cid);
        return new Result(true);
    }

}
