package com.organOld.outService.service.impl;

import com.organOld.dao.entity.record.Record;
import com.organOld.dao.repository.OldmanDao;
import com.organOld.dao.repository.RecordDao;
import com.organOld.dao.util.Page;
import com.organOld.outService.constant.TimeConstant;
import com.organOld.outService.contract.*;
import com.organOld.outService.dwr.Remote;
import com.organOld.outService.enumModel.RecordTypeEnum;
import com.organOld.outService.model.RecordModel;
import com.organOld.outService.contract.Result;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.RecordService;
import com.organOld.outService.tool.ExcelUtil;
import com.organOld.outService.tool.Tool;
import com.organOld.outService.wrapper.RecordWrapper;
import com.sun.org.apache.bcel.internal.classfile.Constant;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    CommonService commonService;
    @Autowired
    RecordDao recordDao;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    RecordWrapper recordWrapper;

    @Override
    public String getByPage(RecordRequest recordRequest, BTableRequest bTableRequest) {
        Page<Record> page=commonService.getPage(bTableRequest,"record");
        Record record=  recordWrapper.unwrap(recordRequest);
        if(record.getOrganId()==null || record.getOrganId()==0){
            //机构账号页面
            commonService.checkIsOrgan(record);
        }
        page.setEntity(record);
        List<RecordModel> productModelList=recordDao.getByPage(page).stream().map( recordWrapper::wrap).collect(Collectors.toList());
        Long size=recordDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,productModelList);
    }

    @Override
    public String getByCardPage(BTableRequest bTableRequest, CardRecordRequest cardRecordRequest) {
        Page<Record> page=commonService.getPage(bTableRequest,"record");
        Record record=  recordWrapper.unwrapCard(cardRecordRequest);
        page.setEntity(record);
        List<RecordModel> productModelList=recordDao.getByCardPage(page).stream().map( recordWrapper::wrap).collect(Collectors.toList());
        Long size=recordDao.getSizeByCardPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,productModelList);
    }

//    @Override
//    public void save(int oldmanId, int organId, int type) {
////        if(type== RecordTypeEnum.SIGN.getIndex()){
////            //签到 增加积分
////            int integral=1;
////            oldmanDao.addInregral(oldmanId,integral);
////        }
//        Record record=new Record();
//        record.setOrganId(organId);
//        record.setType(type);
//        record.setOrganId(organId);
//        recordDao.save(record);
//    }


    @Override
    public void saveEntity(Record record) {
        recordDao.save(record);
    }

    @Override
    public Result getMoneySum(String start, String end, Integer organId) {
        return new Result(true,recordDao.getMoneySum(Tool.stringToDate(start),Tool.stringToDate(end),organId));
    }

    @Override
    public Integer getCountByOldmanIdToday(int oldmanId, int type, int organId) {
//        String today=commonService.getToday();
        return recordDao.getCountByOldmanIdToday(oldmanId,type,organId);
    }

    @Override
    public void export(HttpServletResponse response, RecordRequest recordRequest)  {

        Record record=recordWrapper.unwrap(recordRequest);
        List<Record> exportRecordList=recordDao.getAll(record);

        //excel标题
        String[] title =new String[3];
        title[0]="老人姓名";
        title[1]="时间";
        title[2]="机构";
        int j=0;

        //excel文件名
//        String fileName = "一卡通"+RecordTypeEnum.getValue(recordRequest.getType())+".xls";

        String fileName="record_"+((recordRequest.getType()==2)?"sign":(recordRequest.getType()==3)?"info":"integral")+".xls";
        String sheetName = "刷卡记录表";
        String[][] content=new String[exportRecordList.size()][];
        for(Record re:exportRecordList){
            content[j]=new String[3];
            content[j][0]=re.getOldman().getName();
            content[j][1]=Tool.dateToString(re.getTime(), TimeConstant.DATA_FORMAT_YMDHMS);
            content[j][2]=re.getOrgan().getName();
            j++;
        }

//创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

//响应到客户端
        try {
            commonService.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
            Remote.noticeByfunction("finshRecordExport",commonService.getIdBySession());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEntitys(List<Record> recordList) {
        recordDao.saveAll(recordList);
    }

    @Override
    public Result getHdNameLike(String name) {
        return new Result(true,recordDao.getHdNameLike(name));
    }
}
