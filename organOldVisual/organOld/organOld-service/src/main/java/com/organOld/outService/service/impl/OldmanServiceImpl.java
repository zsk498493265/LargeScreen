package com.organOld.outService.service.impl;

import com.organOld.dao.entity.*;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.*;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.entity.record.Record;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.outService.constant.TimeConstant;
import com.organOld.outService.constant.ValueConstant;
import com.organOld.outService.dwr.Remote;
import com.organOld.outService.enumModel.*;
import com.organOld.outService.model.*;
import com.organOld.outService.service.AutoValueService;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.OldmanService;
import com.organOld.outService.service.RecordService;
import com.organOld.outService.thread.OldStatusOrganUpdate;
import com.organOld.outService.tool.ExcelUtil;
import com.organOld.outService.tool.Tool;
import com.organOld.outService.wrapper.*;
import com.organOld.outService.contract.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by netlab606 on 2018/4/1.
 */
@Service
public class OldmanServiceImpl implements OldmanService {

    @Autowired
    OldmanDao oldmanBaseDao;
    @Autowired
    OldmanHealthDao oldmanHealthDao;
    @Autowired
    LinkmanDao linkmanDao;
    @Autowired
    OrganOldmanDao organOldmanDao;
    @Autowired
    CommonService commonService;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    OrganDao organDao;
    @Autowired
    HomeOldmanDao homeOldmanDao;
    @Autowired
    OldmanKeyDao oldmanKeyDao;
    @Autowired
    LabelDao labelDao;
    @Autowired
    HealthAddDao healthAddDao;
    @Autowired
    HealthSelectManDao healthSelectManDao;
    @Autowired
    HealthSelectDao healthSelectDao;
    @Autowired
    CardDao cardDao;
    @Autowired
    OldmanWrapper oldmanWrapper;
    @Autowired
    OldmanHealthWrapper oldmanHealthWrapper;
    @Autowired
    LinkmanWrapper linkmanWrapper;
    @Autowired
    OrganOldmanWrapper organOldmanWrapper;
    @Autowired
    HomeOldmanWrapper homeOldmanWrapper;
    @Autowired
    OldmanKeyWrapper oldmanKeyWrapper;
    @Autowired
    AutoValueService autoValueService;
    @Autowired
    OldmanKeyHandleDao oldmanKeyHandleDao;
    @Autowired
    RecordService recordService;
    @Autowired
            UserDao userDao;
    @Autowired
            MessageDao messageDao;

    /**
     * 用于导入 提前获得auto_value,health_select数据
     */
    static Map<String,String> mapAutoValue=new HashMap<>();
    static Map<String,Integer> mapHealthSelect=new HashMap<>();

    @Override
    public String getOldmanByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_base");
        Oldman oldman= oldmanWrapper.unwrap(oldmanRequest);
        commonService.fillXq(oldmanRequest,oldman);
        page.setEntity(oldman);
        List<OldmanModel> oldmanList=oldmanBaseDao.getByPage(page).stream().map(oldmanWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanBaseDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanList);
    }



    @Override
    public void export(HttpServletResponse response, ExportTableThRequest exportTableThRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Oldman oldman= oldmanWrapper.unwrapAll(exportTableThRequest);
        commonService.fillXq(exportTableThRequest,oldman);
        List<ExportOldmanModel> exportOldmanList=oldmanBaseDao.getAll(oldman).stream().map(oldmanWrapper::wrapAll).collect(Collectors.toList());

        //excel标题
        String[] title =new String[exportTableThRequest.getTh().size()];
        String[] engTitle=new String[exportTableThRequest.getTh().size()];
        int i=0,j=0,k;
        for(String t:exportTableThRequest.getTh()){
            String ct=t.split("#")[1];
            String engt=t.split("#")[0];
            title[i]=ct;
            engTitle[i]=engt;
            i++;
        }
        //excel文件名
        String fileName = "oldman.xls";
        String sheetName = "老人信息表";
        String[][] content=new String[exportOldmanList.size()][];
        for(ExportOldmanModel exportOldman:exportOldmanList){
            k=0;
            content[j]=new String[exportTableThRequest.getTh().size()];
            for(String eng:engTitle){
                if(eng.equals("getSqzw")){
//                    fillExportAutoValue(exportOldman,AutoValueEnum.SQZW.getIndex(),eng);
                    content[j][k++]=  StringUtils.collectionToDelimitedString(exportOldman.getSqzw(), ",");
                }else if(eng.equals("getFamilyType")){
                    content[j][k++]=  StringUtils.collectionToDelimitedString(exportOldman.getFamilyType(), ",");
                }else if(eng.equals("getFamily")){
                    content[j][k++]=  StringUtils.collectionToDelimitedString(exportOldman.getFamily(), ",");
                }else if(eng.equals("getEconomic")){
                    content[j][k++]=  StringUtils.collectionToDelimitedString(exportOldman.getEconomic(), ",");
                }else{
                    Method method = exportOldman.getClass().getMethod(eng, null);
                    content[j][k++] = (String) method.invoke(exportOldman, null);
                }
            }
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
            Remote.noticeByfunction("finishOldmanExport",commonService.getIdBySession());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    @Override
    public String getHealthByPage(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest) {
        Page<OldmanHealth> page=commonService.getPage(bTableRequest,"oldman_health");
        OldmanHealth oldmanHealth=oldmanHealthWrapper.unwrap(oldmanHealthRequest);
        commonService.fillXq(null,oldmanHealth);
        page.setEntity(oldmanHealth);
        List<OldmanHealthModel> oldmanHealthModelList=oldmanHealthDao.getByPage(page).stream().map(oldmanHealthWrapper::wrap).collect(Collectors.toList());
        Long size=oldmanHealthDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanHealthModelList);
    }

    @Override
    public String getHealthSelectByPage(HealthSelectRequest healthSelectRequest, BTableRequest bTableRequest) {
        Page<HealthSelect> page=commonService.getPage(bTableRequest,"health_select");
        HealthSelect healthSelect=oldmanHealthWrapper.unwrapHealthSelect(healthSelectRequest);
        page.setEntity(healthSelect);
        List<HealthSelectModel> healthSelectModelList=healthSelectDao.getByPage(page).stream().map(oldmanHealthWrapper::wrapHealthSelect).collect(Collectors.toList());
        Long size=healthSelectDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,healthSelectModelList);
    }

    @Override
    public void addOrUpdateHealthSelect(HealthSelect healthSelect, String type) {
        if(type.equals("add"))
            healthSelectDao.save(healthSelect);
        else
            healthSelectDao.updateById(healthSelect);
        OldmanServiceImpl.mapHealthSelect.clear();
    }


    //    @Override
//    public String getEconomyByPage(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest) {
//        Page<OldmanEconomic> page=commonService.getPage(bTableRequest,"oldman_economy");
//        OldmanEconomic economic=economicWrapper.unwrap(economicRequest);
//        commonService.checkIsOrgan(economic);
//        page.setEntity(economic);
//        List<OldmanEconomicModel> economicModelList=economicDao.getByPage(page).stream().map(economicWrapper::wrap).collect(Collectors.toList());
//        Long size=economicDao.getSizeByPage(page);
//        return commonService.tableReturn(bTableRequest.getsEcho(),size,economicModelList);
//    }


    @Override
    public String getIntegralByPage(OldmanIntegralRequest oldmanIntegralRequest, BTableRequest bTableRequest) {
        Page<OldmanIntegral> page=commonService.getPage(bTableRequest,"oldman_integral");
        OldmanIntegral integral=oldmanWrapper.unwrapIntegral(oldmanIntegralRequest);
        commonService.checkIsOrgan(integral);
        page.setEntity(integral);
        List<OldmanIntegralModel> oldmanIntegralModelList=oldmanBaseDao.getIntegralByPage(page).stream().map(oldmanWrapper::wrapIntegral).collect(Collectors.toList());
        Long size=oldmanBaseDao.getIntegralSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanIntegralModelList);
    }

//    @Override
//    public String getFamilyByPage(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest) {
//        Page<OldmanFamily> page=commonService.getPage(bTableRequest,"oldman_family");
//        OldmanFamily family=familyWrapper.unwrap(familyRequest);
//        commonService.checkIsOrgan(family);
//        page.setEntity(family);
//        List<OldmanFamilyModel> familyModelList=familyDao.getByPage(page).stream().map(familyWrapper::wrap).collect(Collectors.toList());
//        Long size=familyDao.getSizeByPage(page);
//        try {
//            fillAutoValue(familyModelList,AutoValueEnum.JTLB.getIndex(),"FamilyType");
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return commonService.tableReturn(bTableRequest.getsEcho(),size,familyModelList);
//    }

    @Override
    public String getOrganOldmanByPage(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest) {
        Page<OrganOldman> page=commonService.getPage(bTableRequest,"oldman_organOldman");
        OrganOldman organOldman=organOldmanWrapper.unwrap(organOldmanRequest);
        commonService.fillXq(null,organOldman);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(organOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=organOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

//    @Override
//    public String getLinkmanByPage(LinkmanRequest linkmanRequest, BTableRequest bTableRequest) {
//        Page<Linkman> page=commonService.getPage(bTableRequest,"oldman_linkman");
//        Linkman linkman=linkmanWrapper.unwrap(linkmanRequest);
//        commonService.checkIsOrgan(linkman);
//        page.setEntity(linkman);
//        List<LinkmanModel> linkmanModelList=linkmanDao.getByPage(page).stream().map(linkmanWrapper::wrap).collect(Collectors.toList());
//        Long size=linkmanDao.getSizeByPage(page);
//        return commonService.tableReturn(bTableRequest.getsEcho(),size,linkmanModelList);
//    }



    @Override
    @Transactional
    public void delById(int id) {
        //TODO 删除老人的其他信息
        linkmanDao.delByOid(id);
        oldmanBaseDao.delById(id);
    }


    //TODO
    @Override
    @Transactional
    public void save(OldmanAddRequest oldmanAddRequest) {
//        oldmanBaseDao.save(oldmanAddRequest.getOldman());
//        Linkman linkman=oldmanAddRequest.getLinkman();
//        linkman.setOldmanId(oldmanAddRequest.getOldman().getId());
//        linkmanDao.save(linkman);
//        OldmanHealth oldmanHealth=oldmanAddRequest.getOldmanHealth();
//        oldmanHealth.setOldmanId(oldmanAddRequest.getOldman().getId());
//        oldmanHealthDao.save(oldmanAddRequest.getOldmanHealth());
    }


    @Override
    public OldmanAddInfoModel getAddInfo() {
        SysRole sysRole=userDao.getRoleByUserName(commonService.getUserNameBySession());
        List<Integer> typeList=commonService.getAutoValueTypes("oldman_add_"+sysRole.getName());
        List<AutoValue> autoValueList=autoValueDao.getByTypeList(typeList);
        List<AutoValue> autoValueUseList=new ArrayList<>();
        List<Integer> xqIds = autoValueService.getXqIdsByUsername(commonService.getUserNameBySession());
        if(!sysRole.getName().equals("admin")) {
            for (AutoValue autoValue : autoValueList) {
                if (autoValue.getType() == 2 && !xqIds.contains(autoValue.getId())) {
                } else {
                    autoValueUseList.add(autoValue);
                }
            }
        }
        Integer organId=commonService.getIdBySession();
        List<Organ> jwList=null;
        if(!sysRole.getName().equals("jw")){
            jwList=organDao.getSimpleByType(2,organId);
        }
        List<HealthSelect> healthSelectList=oldmanHealthDao.getAllHealthSelect();
        if(!sysRole.getName().equals("admin")) {
            OldmanAddInfoModel oldmanAddInfoModel=oldmanWrapper.wrapAddInfo(autoValueUseList,jwList,healthSelectList);
            return oldmanAddInfoModel;
        }else{
            OldmanAddInfoModel oldmanAddInfoModel=oldmanWrapper.wrapAddInfo(autoValueList,jwList,healthSelectList);
            return oldmanAddInfoModel;
        }
    }


    @Override
    public HealthSelectInfoModel getAllHealthInfo() {
        List<Integer> typeList=commonService.getAutoValueTypes("health_add");
        List<AutoValue> autoValueList=autoValueDao.getByTypeList(typeList);
        List<HealthSelect> healthSelectList=oldmanHealthDao.getAllHealthSelect();
        HealthSelectInfoModel healthSelectInfoModel=oldmanWrapper.wrapHealthSelectInfo(autoValueList,healthSelectList);
        return healthSelectInfoModel;
    }

    @Override
    public String getHomeOldmanByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest) {
        Page<HomeOldman> page=commonService.getPage(bTableRequest,"oldman_homeOldman");
        HomeOldman homeOldman=homeOldmanWrapper.unwrap(homeOldmanRequest);
        commonService.fillXq(null,homeOldman);
        homeOldman.setNy(commonService.getPrevNy());
        page.setEntity(homeOldman);
        List<HomeOldmanModel> organOldmanModelList=homeOldmanDao.getByPage(page).stream().map(homeOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=homeOldmanDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public OldmanAllInfoModel getOldmanInfo(int oldmanId) {
        OldmanAllInfoModel oldmanAllInfoModel=new OldmanAllInfoModel();
        Page<DBEntity> page=new Page<>();
        page.setLength(1);
        page.setStart(0);

        Oldman oldman=new Oldman();
        oldman.setId(oldmanId);


        OldmanModel oldmanModel=oldmanWrapper.wrapInfo(oldmanBaseDao.getById(oldmanId));
        if(oldmanModel==null)
            return null;
        oldmanAllInfoModel.setOldman(oldmanModel);

        oldman.setKeyGoalBase(ValueConstant.OLDMAN_KEY_GOAL_BASE);
        page.setEntity(oldman);
        List<OldmanKeyModel> oldmanKeyModelList=oldmanKeyDao.getByPage(page).stream().map(oldmanKeyWrapper::wrap).collect(Collectors.toList());
        if(oldmanKeyModelList!=null && oldmanKeyModelList.size()>0)
            oldmanAllInfoModel.setKey(oldmanKeyModelList.get(0));

        OldmanHealthModel oldmanHealthModel=oldmanHealthWrapper.wrap(oldmanHealthDao.getByOldmanId(oldmanId));
        oldmanAllInfoModel.setHealth(oldmanHealthModel);


        Linkman linkman=new Linkman();
        linkman.setOldman(oldman);
        page.setEntity(linkman);
        List<LinkmanModel> linkmanModelList=linkmanDao.getByPage(page).stream().map(linkmanWrapper::wrap).collect(Collectors.toList());
        if(linkmanModelList!=null && linkmanModelList.size()>0)
            oldmanAllInfoModel.setLinkman(linkmanModelList.get(0));

        OrganOldman organOldman=new OrganOldman();
        organOldman.setFirType(21);
        organOldman.setOldman(oldman);
        organOldman.setNy(commonService.getPrevNy());
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getByPage(page).stream().map(organOldmanWrapper::wrap).collect(Collectors.toList());
        if(organOldmanModelList!=null && organOldmanModelList.size()>0)
            oldmanAllInfoModel.setOrgan(organOldmanModelList.get(0));

        OrganOldman communityOldman=new OrganOldman();
        communityOldman.setFirType(22);
        communityOldman.setOldman(oldman);
        organOldman.setNy(commonService.getPrevNy());
        page.setEntity(communityOldman);
        List<OrganOldmanModel> communityOldmanModelList=organOldmanDao.getByPage(page).stream().map(organOldmanWrapper::wrap).collect(Collectors.toList());
        oldmanAllInfoModel.setCommunity(communityOldmanModelList);

        HomeOldman homeOldman=new HomeOldman();
        homeOldman.setOldman(oldman);
        homeOldman.setNy(commonService.getPrevNy());
        page.setEntity(homeOldman);
        List<HomeOldmanModel> homeOldmanModelList=homeOldmanDao.getByPage(page).stream().map(homeOldmanWrapper::wrap).collect(Collectors.toList());
        oldmanAllInfoModel.setHome(homeOldmanModelList);

        return oldmanAllInfoModel;
    }


    //TODO 标签 绑定人员更新
    @Override
    @Transactional
    public Result importExcel(MultipartFile file, HttpSession session) throws IOException {


//        Integer organId=commonService.getIdBySession();

        //导入规则  已有的则进行更新 没有的今天添加   数据库有的 表没有的  则“删除” 设置老人状态为不可用
        List<Integer> existOldmanIds=new ArrayList<>();//存储 本次更新 中已存在的老人ID 用于得到需要“删除”的老人ID


        //批量插入  HealthSelect只进行批量插入 在这之前将已有信息删除 由于恶性肿瘤史、骨折史 等 每次都只写当次更新的内容 历史不用写进来  所以直接进行批量更新

        List<Linkman> linkmanList_add=new ArrayList<>();
        List<OldmanHealth> healthList_add=new ArrayList<>();
        List<HealthSelectMan> healthSelectManList_add=new ArrayList<>();
        List<HealthAdd> healthAddList_add=new ArrayList<>();
        List<Oldman> oldmanList_add=new ArrayList<>();
        List<Card> cardList_add=new ArrayList<>();

        //批量更新
        List<Linkman> linkmanList_update=new ArrayList<>();
        List<OldmanHealth> healthList_update=new ArrayList<>();
        List<Oldman> oldmanList_update=new ArrayList<>();//对已存在的老人进行批量更新


        String  fix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        Workbook wb0;
        if(fix.equals("xls"))
            wb0= new HSSFWorkbook(file.getInputStream());
        else
            wb0=new XSSFWorkbook(file.getInputStream());

        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successUpdate=0;//导入数量中  更新的个数
        int successAdd=0;//导入数量中  增加的个数
        int numFail=0;
//        int successDel=0;//删除的个数


        int start=2;

        List<Integer> xqIds=null;
        Integer organId = commonService.getIdBySession();
        if (organId == null || organId == 0) {
            //管理员
        } else {
            xqIds = autoValueService.getXqIdsByUsername(commonService.getUserNameBySession());
            if(xqIds.size()==0)
                xqIds.add(0);
        }
        Map<String,Oldman> allOldmans=new HashMap<>();
        Set<String> addPids=new HashSet<>();//防止 同时添加 身份证号一样的老人
        allOldmans=oldmanBaseDao.getAllOldman();
        Set<Integer> orgOldmanIds=oldmanBaseDao.getOrganOldmansMap(xqIds);

        if(mapAutoValue.size()==0){
            List<Integer> autoIds=commonService.getAutoValueTypes("importOldman");
            List<AutoValue> autoValueList=autoValueService.getByTypeList(autoIds);
            autoValueList.forEach(s->mapAutoValue.put(s.getType()+s.getValue(),s.getId()+""));//key 是type+value
        }
        if(mapHealthSelect.size()==0){
            List<HealthSelect> healthSelectList=oldmanHealthDao.getAllHealthSelect();
            healthSelectList.forEach(s->mapHealthSelect.put(s.getSecTypeName(),s.getId()));//key 是type+value
        }

        Row rt=null;//表头
        Row rt1=null;//第一列
        //对Sheet中的每一行进行迭代
        for (Row r : sht0) {
            if(r.getRowNum()==0)
                rt1=r;
            if(r.getRowNum()==start-1){
              rt=r;
            }

            Oldman oldman = new Oldman();
            try {
                if (r.getRowNum() >= start) {
                    //遍历 cell  将单元格 格式 全都转换成String 类型
                    Iterator<Cell> cells = r.cellIterator();    //获得第一行的迭代器
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    if(!commonService.excelIsNotNull(r.getCell(0))){
                        continue;
                    }

                    //创建实体类
                    if(commonService.excelIsNotNull(r.getCell(3)))
                    oldman.setName(r.getCell(3).getStringCellValue());

                        if (commonService.excelIsNotNull(r.getCell(4))) {
                            String sex = r.getCell(4).getStringCellValue();
                            sex = sex.replace("性", "");
                            oldman.setSex((sex.equals("男")) ? 2 : 1);
                        }
//                    if(commonService.excelIsNotNull(r.getCell(5)))
//                    oldman.setBirthday(Tool.stringToDate((r.getCell(5).getStringCellValue())));
                    if(commonService.excelIsNotNull(r.getCell(6))) {
                        if(addPids.contains(Tool.trim(r.getCell(6).getStringCellValue()))){
                            if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.REPEAT.getName())) {
                                excelReturnModel.getFail_detail().get(ImportFailEnum.REPEAT.getName()).add(r.getRowNum() + 1);
                            } else {
                                List<Integer> list = new ArrayList<>();
                                list.add(r.getRowNum() + 1);
                                excelReturnModel.getFail_detail().put(ImportFailEnum.REPEAT.getName(), list);
                            }
                            numFail++;
                            continue;
                        }else{
                            addPids.add(r.getCell(6).getStringCellValue());
                        }
                        oldman.setPid(Tool.trim(r.getCell(6).getStringCellValue()));
                        if(oldman.getPid().length()!=15 && oldman.getPid().length()!=18){
                            if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.PID.getName())) {
                                excelReturnModel.getFail_detail().get(ImportFailEnum.PID.getName()).add(r.getRowNum() + 1);
                            } else {
                                List<Integer> list = new ArrayList<>();
                                list.add(r.getRowNum() + 1);
                                excelReturnModel.getFail_detail().put(ImportFailEnum.PID.getName(), list);
                            }
                            numFail++;
                            continue;
                        }
                        if(oldman.getBirthday()==null){
                            oldman.setBirthday(Tool.stringToDate(
                                    oldman.getPid().substring(6,10)+"-"
                                            +oldman.getPid().substring(10,12)+"-"
                                            +oldman.getPid().substring(12,14)));
                        }
                        if(oldman.getBirthday()==null || CommonService.birthdayToAge(oldman.getBirthday())<60 || CommonService.birthdayToAge(oldman.getBirthday())>150){
                            if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.AGE.getName())) {
                                excelReturnModel.getFail_detail().get(ImportFailEnum.AGE.getName()).add(r.getRowNum() + 1);
                            } else {
                                List<Integer> list = new ArrayList<>();
                                list.add(r.getRowNum() + 1);
                                excelReturnModel.getFail_detail().put(ImportFailEnum.AGE.getName(), list);
                            }
                            numFail++;
                            continue;
                        }
                    }else{
                        excelReturnModel.getFail().add(r.getRowNum()+1);
                        continue;
                    }
                    if(commonService.excelIsNotNull(r.getCell(7)))
                    oldman.setAddress(r.getCell(7).getStringCellValue());

                    if(commonService.excelIsNotNull(r.getCell(8)))
                    oldman.setPhone(r.getCell(8).getStringCellValue());



                    if(rt1.getCell(1).getStringCellValue().indexOf("小区")>=0){
                        //新版本
                        if(commonService.excelIsNotNull(r.getCell(1))){
                            String xqIndex=mapAutoValue.get(AutoValueEnum.XQ.getIndex()+r.getCell(1).getStringCellValue());
                            if(xqIndex!=null)
                                oldman.setXqId(Integer.parseInt(xqIndex));
                            else {
//                                AutoValue autoValue=new AutoValue();
//                                autoValue.setValue(r.getCell(2).getStringCellValue());
//                                autoValue.setType(AutoValueEnum.XQ.getIndex());
//                                autoValue.setParentIndex(organId);
//                                autoValueDao.save(autoValue);
//                                mapAutoValue.put(AutoValueEnum.XQ.getIndex()+r.getCell(2).getStringCellValue(),autoValue.getId()+"");
//                                oldman.setXqId(autoValue.getId());
                                if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.XQ.getName())) {
                                    excelReturnModel.getFail_detail().get(ImportFailEnum.XQ.getName()).add(r.getRowNum() + 1);
                                } else {
                                    List<Integer> list = new ArrayList<>();
                                    list.add(r.getRowNum() + 1);
                                    excelReturnModel.getFail_detail().put(ImportFailEnum.XQ.getName(), list);
                                }
                                numFail++;
                                continue;
                            }
                        }else{
                            if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.XQ.getName())) {
                                excelReturnModel.getFail_detail().get(ImportFailEnum.XQ.getName()).add(r.getRowNum() + 1);
                            } else {
                                List<Integer> list = new ArrayList<>();
                                list.add(r.getRowNum() + 1);
                                excelReturnModel.getFail_detail().put(ImportFailEnum.XQ.getName(), list);
                            }
                            numFail++;
                            continue;
                        }
                        if(commonService.excelIsNotNull(r.getCell(2))){
                            if(Tool.isNumber(r.getCell(2).getStringCellValue()))
                                oldman.setLouNum(Integer.parseInt(r.getCell(2).getStringCellValue()));
                        }
                    }else{
                        //旧版本  先把 居委的 当成小区
                        if(commonService.excelIsNotNull(r.getCell(2))){
                            String xqIndex=mapAutoValue.get(AutoValueEnum.XQ.getIndex()+r.getCell(2).getStringCellValue());
                            if(xqIndex!=null)
                                oldman.setXqId(Integer.parseInt(xqIndex));
                            else {
//                                AutoValue autoValue=new AutoValue();
//                                autoValue.setValue(r.getCell(2).getStringCellValue());
//                                autoValue.setType(AutoValueEnum.XQ.getIndex());
//                                autoValue.setParentIndex(organId);
//                                autoValueDao.save(autoValue);
//                                mapAutoValue.put(AutoValueEnum.XQ.getIndex()+r.getCell(2).getStringCellValue(),autoValue.getId()+"");
//                                oldman.setXqId(autoValue.getId());
                                if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.XQ.getName())) {
                                    excelReturnModel.getFail_detail().get(ImportFailEnum.XQ.getName()).add(r.getRowNum() + 1);
                                } else {
                                    List<Integer> list = new ArrayList<>();
                                    list.add(r.getRowNum() + 1);
                                    excelReturnModel.getFail_detail().put(ImportFailEnum.XQ.getName(), list);
                                }
                                numFail++;
                                continue;
                            }
                        }else{
                            if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.XQ.getName())) {
                                excelReturnModel.getFail_detail().get(ImportFailEnum.XQ.getName()).add(r.getRowNum() + 1);
                            } else {
                                List<Integer> list = new ArrayList<>();
                                list.add(r.getRowNum() + 1);
                                excelReturnModel.getFail_detail().put(ImportFailEnum.XQ.getName(), list);
                            }
                            numFail++;
                            continue;
                        }
                    }

//                    String politicalStatus = r.getCell(9).getStringCellValue().equals("") ? "群众" : r.getCell(9).getStringCellValue();
                    if(commonService.excelIsNotNull(r.getCell(9)))
                        oldman.setPoliticalStatus(mapAutoValue.get(AutoValueEnum.ZZMM.getIndex()+r.getCell(9).getStringCellValue()));
//                        oldman.setPoliticalStatus(autoValueDao.getStringLikeIndex(r.getCell(9).getStringCellValue(), AutoValueEnum.ZZMM.getIndex(), "like")+"");

                    if (commonService.excelIsNotNullOne(r.getCell(11))) {
                        if(rt.getCell(11).getStringCellValue().equals("古美路街道户籍")){
                           oldman.setCensus(mapAutoValue.get(AutoValueEnum.HJ.getIndex() + "户籍"));
                        }else {
                            oldman.setCensus(mapAutoValue.get(AutoValueEnum.HJ.getIndex() + rt.getCell(11).getStringCellValue()));
//                        Integer hjIndex = autoValueDao.getStringLikeIndex("户籍", AutoValueEnum.HJ.getIndex(), "equals");
//                        oldman.setCensus(hjIndex + "");
                        }
                    } else if (commonService.excelIsNotNullOne(r.getCell(12))) {
                        oldman.setCensus(mapAutoValue.get(AutoValueEnum.HJ.getIndex()+rt.getCell(12).getStringCellValue()));
//                        Integer hjIndex = autoValueDao.getStringLikeIndex("非户籍", AutoValueEnum.HJ.getIndex(), "equals");
//                        oldman.setCensus(hjIndex + "");
                    } else if (commonService.excelIsNotNullOne(r.getCell(13))) {
                        oldman.setCensus(mapAutoValue.get(AutoValueEnum.HJ.getIndex()+rt.getCell(13).getStringCellValue()));
//                        Integer hjIndex = autoValueDao.getStringLikeIndex("人户分离", AutoValueEnum.HJ.getIndex(), "equals");
//                        oldman.setCensus(hjIndex + "");
                    }

                    if (commonService.excelIsNotNullOne(r.getCell(14))) {
                        oldman.setZc(mapAutoValue.get(AutoValueEnum.ZC.getIndex()+rt.getCell(14).getStringCellValue()));
//                        Integer zcIndex = autoValueDao.getStringLikeIndex("高级", AutoValueEnum.ZC.getIndex(), "equals");
//                        oldman.setZc(zcIndex + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(15))) {
                        oldman.setZc(mapAutoValue.get(AutoValueEnum.ZC.getIndex()+rt.getCell(15).getStringCellValue()));
//                        Integer zcIndex = autoValueDao.getStringLikeIndex("副高级", AutoValueEnum.ZC.getIndex(), "equals");
//                        oldman.setZc(zcIndex + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(16))) {
                        oldman.setZc(mapAutoValue.get(AutoValueEnum.ZC.getIndex()+rt.getCell(16).getStringCellValue()));
//                        Integer zcIndex = autoValueDao.getStringLikeIndex("中级", AutoValueEnum.ZC.getIndex(), "equals");
//                        oldman.setZc(zcIndex + "");
                    }
                    String sqzw="";
                    if (commonService.excelIsNotNullOne(r.getCell(17))) {
                        sqzw=mapAutoValue.get(AutoValueEnum.SQZW.getIndex()+rt.getCell(17).getStringCellValue());
//                        Integer szIndex = autoValueDao.getStringLikeIndex("三长", AutoValueEnum.SQZW.getIndex(), "equals");
//                        sqzw=szIndex+"";
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(18))) {
                        String sqIndex=mapAutoValue.get(AutoValueEnum.SQZW.getIndex()+rt.getCell(18).getStringCellValue());
//                        Integer sqIndex = autoValueDao.getStringLikeIndex("社区团队负责人", AutoValueEnum.SQZW.getIndex(), "equals");
                        if(sqzw.length()>1){
                            sqzw+="#"+sqIndex;
                        }
                    }
                    oldman.setSqzw(sqzw);


                    Linkman linkman = new Linkman();
                    if(commonService.excelIsNotNull(r.getCell(25)))
                    linkman.setName(r.getCell(25).getStringCellValue());
                    if(commonService.excelIsNotNull(r.getCell(26)))
                    linkman.setRelation(r.getCell(26).getStringCellValue());
                    if(commonService.excelIsNotNull(r.getCell(27)))
                    linkman.setPhone(r.getCell(27).getStringCellValue());


                    //is  字段中的  healthadd 只有在 insert时进行添加  update不改变
                    OldmanHealth health = new OldmanHealth();
                    if(commonService.excelIsNotNull(r.getCell(10)))
                    health.setBloodType(r.getCell(10).getStringCellValue());
//                    health.setIntelligence("");
//                    health.setEyesight("");

                    if (commonService.excelIsNotNullOne(r.getCell(55))) {
                        health.setIntelligence(mapAutoValue.get(AutoValueEnum.SZ.getIndex()+rt.getCell(55).getStringCellValue()));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("痴呆", AutoValueEnum.SZ.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(56))) {
                        health.setIntelligence(mapAutoValue.get(AutoValueEnum.SZ.getIndex()+rt.getCell(56).getStringCellValue()));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("智障", AutoValueEnum.SZ.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(57))) {
                        health.setIntelligence(mapAutoValue.get(AutoValueEnum.SZ.getIndex()+rt.getCell(57).getStringCellValue()));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("正常", AutoValueEnum.SZ.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }

                    if (commonService.excelIsNotNullOne(r.getCell(58))) {
                        health.setEyesight(mapAutoValue.get(AutoValueEnum.SL.getIndex()+rt.getCell(58).getStringCellValue()));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("失明", AutoValueEnum.SL.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(59))) {
                        health.setEyesight(mapAutoValue.get(AutoValueEnum.SL.getIndex()+rt.getCell(59).getStringCellValue()));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("一般障碍", AutoValueEnum.SL.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(60))) {
                        health.setEyesight(mapAutoValue.get(AutoValueEnum.SL.getIndex()+rt.getCell(60).getStringCellValue()));
//                        Integer IndexSZ = autoValueDao.getStringLikeIndex("正常", AutoValueEnum.SL.getIndex(), "like");
//                        health.setIntelligence(IndexSZ + "");
                    }



                    List<Integer> selectIdList = new ArrayList<>();
                    if (commonService.excelIsNotNullOne(r.getCell(28))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(28).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("青霉素", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(29))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(29).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("磺胺", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(30))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(30).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("四环素", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(31))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(31).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("其他", HealthEnum.YW.getIndex()));
                        health.setIsYwfy(HealthEnum.YW.getIndex());
                    }

                    if (commonService.excelIsNotNullOne(r.getCell(32))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(32).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("高血压", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(33))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(33).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("糖尿病", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(34))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(34).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("脑卒中", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(35))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(35).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("帕金森", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(36))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(36).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("癫痫", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(37))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(37).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("肺炎", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(38))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(38).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("慢阻肺", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(39))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(39).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("冠心病", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(40))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(40).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("甲亢/甲减", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(41))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(41).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("慢性肾功能障碍", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(42))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(42).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("肝炎/肝硬化", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(43))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(43).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("恶性肿瘤", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(44))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(44).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("骨折", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(45))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(45).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("其他消化道疾病", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(46))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(46).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("类风关", HealthEnum.MB.getIndex()));
                        health.setIsMb(HealthEnum.MB.getIndex());
                    }

                    if (commonService.excelIsNotNullOne(r.getCell(49))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(49).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("上厕所", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(50))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(50).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("洗澡", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(51))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(51).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("穿衣", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(52))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(52).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("上下床", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(53))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(53).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("室内行走", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(54))) {
                        selectIdList.add(mapHealthSelect.get(rt.getCell(54).getStringCellValue()));
//                        selectIdList.add(oldmanHealthDao.getSelectStringLikeIndex("吃饭", HealthEnum.SN.getIndex()));
                        health.setIsSn(HealthEnum.SN.getIndex());
                    }


                    List<HealthAdd> healthAddList = new ArrayList<>();
                    if (commonService.excelIsNotNull(r.getCell(47))) {
                        health.setIsExzl(HealthEnum.EXZL.getIndex());
                        String[] add = r.getCell(47).getStringCellValue().split("#");
                        for (int i = 0; i < add.length; i++) {
                            HealthAdd healthAdd = new HealthAdd();
                            healthAdd.setDesc(add[i]);
                            healthAdd.setType(HealthEnum.EXZL.getIndex());
                            healthAddList.add(healthAdd);
                        }
                    }
                    if (commonService.excelIsNotNull(r.getCell(48))) {
                        health.setIsGz(HealthEnum.GZ.getIndex());
                        String[] add = r.getCell(48).getStringCellValue().split("#");
                        for (int i = 0; i < add.length; i++) {
                            HealthAdd healthAdd = new HealthAdd();
                            healthAdd.setDesc(add[i]);
                            healthAdd.setType(HealthEnum.GZ.getIndex());
                            healthAddList.add(healthAdd);
                        }
                    }

                    if (commonService.excelIsNotNull(r.getCell(61))) {
                        health.setIsCj(HealthEnum.CJQK.getIndex());
                        String[] add = r.getCell(61).getStringCellValue().split("#");
                        for (int i = 0; i < add.length; i++) {
                            HealthAdd healthAdd = new HealthAdd();
                            healthAdd.setDesc(add[i]);
                            healthAdd.setType(HealthEnum.CJQK.getIndex());
                            healthAddList.add(healthAdd);
                        }
                    }


                    String family="";
                    if (commonService.excelIsNotNullOne(r.getCell(62))) {
                        family+=mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+rt.getCell(62).getStringCellValue())+"#";
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("纯老", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(63))) {
                        family+=mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+rt.getCell(63).getStringCellValue())+"#";
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("独居", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(64))) {
                        family+=mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+rt.getCell(64).getStringCellValue())+"#";
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("失独", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(65))) {
                        family+=mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+rt.getCell(65).getStringCellValue())+"#";
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("一老养", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(66))) {
                        family+=mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+rt.getCell(66).getStringCellValue())+"#";
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("孤老", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(67))) {
                        family+=mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+rt.getCell(67).getStringCellValue())+"#";
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("三支人员", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(68))) {
                        family+=mapAutoValue.get( AutoValueEnum.JJJG.getIndex()+rt.getCell(68).getStringCellValue())+"#";
//                        oldman.setFamily(autoValueDao.getStringLikeIndex("其他", AutoValueEnum.JJJG.getIndex(), "like")+"");
                    }
                    if(!family.equals("")){
                        family=family.substring(0,family.length()-1);
                        oldman.setFamily(family);
                    }

                    String familyType="";
                    if (commonService.excelIsNotNullOne(r.getCell(20))) {
                        familyType+=mapAutoValue.get(AutoValueEnum.JTLB.getIndex()+rt.getCell(20).getStringCellValue())+"#";
//                       familyType+=autoValueDao.getStringLikeIndex("独生子女家庭", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(21))) {
                        familyType+=mapAutoValue.get(AutoValueEnum.JTLB.getIndex()+rt.getCell(21).getStringCellValue())+"#";
//                        familyType+=autoValueDao.getStringLikeIndex("军属", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(22))) {
                        familyType+=mapAutoValue.get(AutoValueEnum.JTLB.getIndex()+rt.getCell(22).getStringCellValue())+"#";
//                        familyType+=autoValueDao.getStringLikeIndex("烈士家庭", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(23))) {
                        familyType+=mapAutoValue.get(AutoValueEnum.JTLB.getIndex()+rt.getCell(23).getStringCellValue())+"#";
//                        familyType+=autoValueDao.getStringLikeIndex("离休干部", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(24))) {
                        familyType+=mapAutoValue.get(AutoValueEnum.JTLB.getIndex()+rt.getCell(24).getStringCellValue())+"#";
//                        familyType+=autoValueDao.getStringLikeIndex("侨属", AutoValueEnum.JTLB.getIndex(), "like")+"#";
                    }
                    if(!familyType.equals("")){
                        familyType=familyType.substring(0,familyType.length()-1);
                        oldman.setFamilyType(familyType);
                    }


                    String economic="";
                    if (commonService.excelIsNotNullOne(r.getCell(69))) {
                        economic+=mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+rt.getCell(69).getStringCellValue())+"#";
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("帮困", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(70))) {
                        economic+=mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+rt.getCell(70).getStringCellValue())+"#";
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("低保", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(71))) {
                        economic+=mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+rt.getCell(71).getStringCellValue())+"#";
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("养老保险", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(72))) {
                        economic+=mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+rt.getCell(72).getStringCellValue())+"#";
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("医疗救助金", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(73))) {
                        economic+=mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+rt.getCell(73).getStringCellValue())+"#";
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("城镇医保", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(74))) {
                        economic+=mapAutoValue.get(AutoValueEnum.JJTJ.getIndex()+rt.getCell(74).getStringCellValue())+"#";
//                        oldman.setEconomic(autoValueDao.getStringLikeIndex("其他", AutoValueEnum.JJTJ.getIndex(), "like")+"");
                    }

                    if(!economic.equals("")){
                        economic=economic.substring(0,economic.length()-1);
                        oldman.setEconomic(economic);
                    }

                    if(commonService.excelIsNotNullOne(r.getCell(19))){
                        oldman.setIsVolunteer("1");
                    }else {
                        oldman.setIsVolunteer("0");
                    }

                    Boolean exist=allOldmans.containsKey(oldman.getPid());

                    if(exist){
                        //更新
                        successUpdate++;
                        Integer oldmanId=allOldmans.get(oldman.getPid()).getId();

                        if(orgOldmanIds.contains(oldmanId)){
                            orgOldmanIds.remove(oldmanId);
                        }

                        oldman.setId(oldmanId);
                        existOldmanIds.add(oldmanId);

                        oldmanList_update.add(oldman);

                        linkman.setOldmanId(oldmanId);
                        linkmanList_update.add(linkman);

                        health.setOldmanId(oldmanId);
                        healthList_update.add(health);

                    }else{
                        //添加
                        successAdd++;
                        oldmanList_add.add(oldman);

                        existOldmanIds.add(oldman.getId());

                        linkman.setOldman(oldman);
//                        linkman.setOldmanId(oldman.getId());
                        linkmanList_add.add(linkman);

                        health.setOldman(oldman);
//                        health.setOldmanId(oldman.getId());
                        healthList_add.add(health);


//                        Card card=new Card();
//                        card.setOldmanId(oldman.getId());
//                        card.setCid(oldman.getPid().substring(oldman.getPid().length()-8));
//                        card.setPassword("123456");
//                        cardList_add.add(card);


                    }

                    if(selectIdList!=null && selectIdList.size()>0) {
                        for (Integer index : selectIdList) {
                            HealthSelectMan healthSelectMan = new HealthSelectMan();
                            healthSelectMan.setOldmanId(oldman.getId());
                            healthSelectMan.setHealthSelectId(index);
                            healthSelectManList_add.add(healthSelectMan);
                        }
                    }
                    if(healthAddList!=null && healthAddList.size()>0) {
                        for (HealthAdd healthAdd : healthAddList) {
                            if(!healthAdd.getDesc().trim().equals("")) {
                                HealthAdd add = new HealthAdd();
                                add.setOldmanId(oldman.getId());
                                add.setType(healthAdd.getType());
                                add.setDesc(healthAdd.getDesc());
                                healthAddList_add.add(add);
                            }
                        }
                    }
                    numSuccess++;
                }
            }catch (Exception e){
                //检测 是否已经把改老人信息加到表里
//                oldmanBaseDao.delById(oldman.getId());
                e.printStackTrace();
                if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.NONE.getName())) {
                    excelReturnModel.getFail_detail().get(ImportFailEnum.NONE.getName()).add(r.getRowNum() + 1);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(r.getRowNum() + 1);
                    excelReturnModel.getFail_detail().put(ImportFailEnum.NONE.getName(), list);
                }
                numFail++;
            }
        }

        //老人不可用  机构范围
//        excelReturnModel.setSuccessDel(oldmanBaseDao.setDisabled(existOldmanIds,xqIds));
        excelReturnModel.setSuccessDel(orgOldmanIds.size());
        if(orgOldmanIds.size()>0){
            String[] ids=new String[orgOldmanIds.size()];
            int i=0;
            for(Integer id:orgOldmanIds){
                ids[i++]=id+"";
            }
            oldmanBaseDao.updateProps("disable","1",ids);
        }

        //更新
        if(oldmanList_update.size()>0)
            oldmanBaseDao.updateByIds(oldmanList_update);
        if(linkmanList_update.size()>0)
            linkmanDao.updateByOldmanIds(linkmanList_update);
        if(healthList_update.size()>0)
            oldmanHealthDao.updateByOldmanIds(healthList_update);
        //添加
        if(oldmanList_add.size()>0){
            oldmanBaseDao.saveAll(oldmanList_add);
            for(Linkman linkman:linkmanList_add){
                if(linkman.getOldman()!=null){
                    linkman.setOldmanId(linkman.getOldman().getId());

                    Card card=new Card();
                    card.setOldmanId(linkman.getOldman().getId());
                    card.setCid(linkman.getOldman().getPid());
                    card.setPassword("123456");
                    cardList_add.add(card);

                    existOldmanIds.add(linkman.getOldman().getId());
                }
            }
            for(OldmanHealth health:healthList_add){
                if(health.getOldman()!=null){
                    health.setOldmanId(health.getOldman().getId());
                }
            }
        }
        if(linkmanList_add.size()>0)
            linkmanDao.saveAll(linkmanList_add);
        if(healthList_add.size()>0)
            oldmanHealthDao.saveAll(healthList_add);

        if(existOldmanIds.size()>0) {
            healthSelectManDao.delByOldmanIds(existOldmanIds);
            healthAddDao.delByOldmanIds(existOldmanIds);
        }
        if(healthSelectManList_add.size()>0) {
            //先把之前的记录删掉
            healthSelectManDao.saveAll(healthSelectManList_add);
        }
        if(healthAddList_add.size()>0)
            healthAddDao.saveAll(healthAddList_add);

//        oldmanBaseDao.delVolunteerByXqIds(existOldmanIds,xqIds);


//        cardDao.delByOldmanIds(existOldmanIds,xqIds);
//        cardDao.ableByOldmanIds(existOldmanIds,xqIds);
        if(cardList_add.size()>0){
            cardDao.saveAll(cardList_add);
        }



        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setSuccessAdd(successAdd);
        excelReturnModel.setSuccessUpdate(successUpdate);
        excelReturnModel.setNumFail(excelReturnModel.getFail().size());
        excelReturnModel.setTotal(numSuccess+numFail);//一共


        Organ organ=organDao.getById(organId);
        Message message=new Message();
        message.setUserIds(userDao.getUserIdsByRole("admin"));
        message.setType(MessageTypeEnum.XT.getIndex());
        message.setContent(organ.getName()+"居委导入"+excelReturnModel.getNumSuccess()+"个老人数据");
        messageDao.saveAllBySame(message);

        return new Result(true,excelReturnModel);
    }


    @Override
    public Result getIntegralByOldmanId(int oldmanId) {
        OrganQueryIntegralModel organQueryIntegralModel=oldmanWrapper.wrapInregral(oldmanBaseDao.getIntegralByOldmanId(oldmanId));
        if(organQueryIntegralModel!=null)
            return new Result(true,organQueryIntegralModel);
        else return new Result(false,"老人不在数据库中或已被删除");
    }

    @Override
    public Result getById(int id, String type) {
        switch (type){
            case "base":
                Oldman oldman=oldmanBaseDao.getById(id);
//                oldman.setSqzw(oldman.getSqzw().replace("s",""));
                oldman.setBirthdayTime(Tool.dateToString(oldman.getBirthday(), TimeConstant.DATA_FORMAT_YMD));
                return new Result(true,oldman);
            case "linkman":
                Linkman linkman=linkmanDao.getByOldmanId(id);
                return new Result(true,linkman);
            case "health":
                OldmanHealth oldmanHealth=oldmanHealthDao.getByOldmanId(id);
                return new Result(true,oldmanHealth);
        }
        return null;
    }

    @Override
    public Result updateById(DBEntity dbEntity, String type) {
        switch (type){
            case "base":
                Oldman oldman= (Oldman) dbEntity;
                oldman.setBirthday(Tool.stringToDate(oldman.getBirthdayTime()));
                if(oldman.getSqzw()!=null && !oldman.getSqzw().equals(""))
                    oldman.setSqzw(oldman.getSqzw().replace(",","#"));
                if(oldman.getFamily()!=null && !oldman.getFamily().equals(""))
                    oldman.setFamily(oldman.getFamily().replace(",","#"));
                if(oldman.getFamilyType()!=null && !oldman.getFamilyType().equals(""))
                    oldman.setFamilyType(oldman.getFamilyType().replace(",","#"));
                if(oldman.getEconomic()!=null && !oldman.getEconomic().equals(""))
                    oldman.setEconomic(oldman.getEconomic().replace(",","#"));
                oldmanBaseDao.updateById(oldman);
                break;
            case "linkman":
                Linkman linkman=(Linkman) dbEntity;
                linkmanDao.updateByOldmanId(linkman);
                break;
            case "health":
                OldmanHealth oldmanHealth=(OldmanHealth) dbEntity;
                healthSelectManDao.delByOldmanId(oldmanHealth.getOldmanId());
                List<HealthSelectMan> healthSelectManList=new ArrayList<>();
                if(oldmanHealth.getHealthSelectIds()!=null && oldmanHealth.getHealthSelectIds().size()>0){
                    for(Integer id:oldmanHealth.getHealthSelectIds()){
                        Integer firType=healthSelectDao.getFirTypeById(id);
                        if(firType==HealthEnum.MB.getIndex()){
                            oldmanHealth.setIsMb(1);
                        }
                        if(firType==HealthEnum.SN.getIndex()){
                            oldmanHealth.setIsSn(2);
                        }
                        if(firType==HealthEnum.YW.getIndex()){
                            oldmanHealth.setIsYwfy(3);
                        }
                        HealthSelectMan healthSelectMan=new HealthSelectMan();
                        healthSelectMan.setHealthSelectId(id);
                        healthSelectMan.setOldmanId(oldmanHealth.getOldmanId());
                        healthSelectManList.add(healthSelectMan);
                    }
                }
                if(healthSelectManList.size()>0)
                    healthSelectManDao.saveAll(healthSelectManList);
                healthAddDao.delByOldmanId(oldmanHealth.getOldmanId());
                List<HealthAdd> healthAddList=new ArrayList<>();
                if(oldmanHealth.getHealthAdd_exzl()!=null && oldmanHealth.getHealthAdd_exzl().size()>0){
                    oldmanHealth.setIsExzl(4);
                    for(String s:oldmanHealth.getHealthAdd_exzl()){
                        if(!s.trim().equals("")){
                            HealthAdd healthAdd=new HealthAdd();
                            healthAdd.setOldmanId(oldmanHealth.getOldmanId());
                            healthAdd.setType(HealthEnum.EXZL.getIndex());
                            healthAdd.setDesc(s);
                            healthAddList.add(healthAdd);
                        }
                    }
                }
                if(oldmanHealth.getHealthAdd_gz()!=null && oldmanHealth.getHealthAdd_gz().size()>0){
                    oldmanHealth.setIsGz(5);
                    for(String s:oldmanHealth.getHealthAdd_gz()){
                        if(!s.trim().equals("")) {
                            HealthAdd healthAdd = new HealthAdd();
                            healthAdd.setOldmanId(oldmanHealth.getOldmanId());
                            healthAdd.setType(HealthEnum.GZ.getIndex());
                            healthAdd.setDesc(s);
                            healthAddList.add(healthAdd);
                        }
                    }
                }
                if(oldmanHealth.getHealthAdd_cj()!=null && oldmanHealth.getHealthAdd_cj().size()>0){
                    oldmanHealth.setIsCj(6);
                    for(String s:oldmanHealth.getHealthAdd_cj()){
                        if(!s.trim().equals("")) {
                            HealthAdd healthAdd = new HealthAdd();
                            healthAdd.setOldmanId(oldmanHealth.getOldmanId());
                            healthAdd.setType(HealthEnum.CJQK.getIndex());
                            healthAdd.setDesc(s);
                            healthAddList.add(healthAdd);
                        }
                    }
                }
                if(healthAddList.size()>0)
                    healthAddDao.saveAll(healthAddList);

                oldmanHealthDao.updateByOldmanId(oldmanHealth);
        }
        return new Result(true);
    }

    @Override
    public void delByIds(String[] ids) {
        oldmanBaseDao.updateProps("disable","1",ids);
    }

    @Override
    public void delHealthSelectByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        healthSelectDao.delByIds(id);
        OldmanServiceImpl.mapHealthSelect.clear();
    }

    @Override
    public Result getIntegralRule() {
        IntegralRuleModel integralRuleModel=new IntegralRuleModel();
        integralRuleModel.setConsume(ValueConstant.INTEGRAL_RULE_CONSUME);
        integralRuleModel.setSignHdZz(ValueConstant.INTEGRAL_RULE_SIGN_HD_ZZ);
        integralRuleModel.setSignHdQt(ValueConstant.INTEGRAL_RULE_SIGN_HD_QT);
        integralRuleModel.setSignHdCy(ValueConstant.INTEGRAL_RULE_SIGN_HD_CY);
        integralRuleModel.setSignRc(ValueConstant.INTEGRAL_RULE_SIGN_RC);
        return new Result(true, integralRuleModel);
    }

    @Override
    public void updateIntegral(int signRc, int sign_zz, int sign_qt, int sign_cy, int consume) {
        ValueConstant.INTEGRAL_RULE_SIGN_HD_ZZ=sign_zz;
        ValueConstant.INTEGRAL_RULE_SIGN_HD_CY=sign_cy;
        ValueConstant.INTEGRAL_RULE_SIGN_HD_QT=sign_qt;
        ValueConstant.INTEGRAL_RULE_SIGN_RC=signRc;
        ValueConstant.INTEGRAL_RULE_CONSUME=consume;
    }

    @Override
    public Map<String,Long> getOldStatusNum(List<Integer> xqIds) {
        return oldmanBaseDao.getOldStatusNum(xqIds);
    }

    @Override
    public Map<String, Oldman> getAllOldman() {
        return oldmanBaseDao.getAllOldman();
    }

    @Override
    public Result getBySearch(String search) {
        return new Result(true,oldmanBaseDao.getBySearch(search));
    }

    @Override
    public Map<String, Long> getOldmanNum(List<Integer> xqIds, Date start60, Date start80) {
        return oldmanBaseDao.getOldmanNum(xqIds,start60,start80);
    }


    @Override
    public Map<String, Long> getKeyNum(List<Integer> xqIds,int baseGoal) {
        return oldmanBaseDao.getKeyNum(xqIds,baseGoal);
    }

    @Override
    public Map<String, Long> getHealthNum(List<Integer> xqIds) {
        return oldmanHealthDao.getHealthNum(xqIds);
    }

    @Override
    public List<Oldman> getIntegralSort(List<Integer> xqIds) {
        return oldmanBaseDao.getIntegralSort(xqIds);
    }

    @Override
    public Long getOldmanNum(Date date) {
        Page<Oldman> page=new Page<>();
        Oldman oldman= new Oldman();
        oldman.setBirthdayEnd(date);
        commonService.fillXq(null,oldman);
        page.setEntity(oldman);
        return oldmanBaseDao.getSizeByPage(page);
    }


    @Autowired
    OldStatusOrganUpdate oldStatusOrganUpdate;

    @Override
    public void updateOldStatus() {
        oldmanBaseDao.delAllOldStatusHandle();
        OldStatusOrganUpdate.DOING=true;
        OldStatusOrganUpdate.finish=false;
        oldStatusOrganUpdate.longPollingExecutor.execute(oldStatusOrganUpdate.updateRunner);
    }

    @Override
    @Transactional
    public void updateHomeOldStatusByOldmanIds(List<Integer> loadedData) {
        oldmanBaseDao.updateHomeOldStatusByOldmanIds(loadedData);
        String[] oldmanIds=new String[loadedData.size()];
        int i=0;
        for(Integer id:loadedData){
            oldmanIds[i++]=id+"";
        }
        oldmanKeyHandleDao.delByOldmanIds(oldmanIds);
    }

    @Override
    @Transactional
    public void updateOrganOldStatusByOldmanIds(List<Oldman> loadedData) {
        oldmanBaseDao.updateOrganOldStatusByOldmanIds(loadedData);
        String[] oldmanIds=new String[loadedData.size()];
        int i=0;
        for(Oldman oldman:loadedData){
            oldmanIds[i++]=oldman.getId()+"";
        }
        oldmanKeyHandleDao.delByOldmanIds(oldmanIds);
    }

    @Override
    @Transactional
    public Result changeIntegral(String[] oldmanIds, String type, Integer value) {
        List<Record> recordList=new ArrayList<>();
        String[] ids=new String[oldmanIds.length];
        int i=0;
        if(oldmanIds.length==0)
            return new Result(false);
        for (String id:oldmanIds){
            Record record = new Record();
            record.setOldmanId(Integer.parseInt(id.split("#")[0]));
            record.setOrder("6");
            record.setType(RecordTypeEnum.JF.getIndex());
            record.setData(value+"");
            record.setPrevMoney(Double.valueOf(id.split("#")[1]));
            record.setNowMoney(Double.valueOf(id.split("#")[1]) + value);
            if(!type.equals("add")) {
                record.setOrder("7");
            }
            recordList.add(record);
            ids[i++]=id.split("#")[0];
        }

        recordService.saveEntitys(recordList);

        if(!type.equals("add")) {
            value = 0 - value;
        }

        oldmanBaseDao.changeIntegralByOldmanIds(ids,value);
        return new Result(true);
    }

    @Override
    @Transactional
    public Result zeroIntegral(String[] oldmanIds) {
        List<Record> recordList=new ArrayList<>();
        if(oldmanIds.length==0)
            return new Result(false);
        String[] ids=new String[oldmanIds.length];
        int i=0;
        for (String id:oldmanIds){
            Record record = new Record();
            record.setOldmanId(Integer.parseInt(id.split("#")[0]));
            record.setOrder("5");
            record.setType(RecordTypeEnum.JF.getIndex());
            record.setData("");
            record.setPrevMoney(Double.valueOf(id.split("#")[1]));
            record.setNowMoney(0.0);
            recordList.add(record);
            ids[i++]=id.split("#")[0];
        }

        recordService.saveEntitys(recordList);
        oldmanBaseDao.zeroIntegralByOldmanIds(ids);
        return new Result(true);
    }

    @Override
    @Transactional
    public Result importExcelCunstom(MultipartFile file, String[] tables, Integer start) throws IOException {

        //批量插入  HealthSelect只进行批量插入 在这之前将已有信息删除 由于恶性肿瘤史、骨折史 等 每次都只写当次更新的内容 历史不用写进来  所以直接进行批量更新

        List<Linkman> linkmanList_add=new ArrayList<>();
        List<OldmanHealth> healthList_add=new ArrayList<>();
        List<HealthSelectMan> healthSelectManList_add=new ArrayList<>();
        List<Oldman> oldmanList_add=new ArrayList<>();

        //批量更新
        List<Linkman> linkmanList_update=new ArrayList<>();
        List<OldmanHealth> healthList_update=new ArrayList<>();
        List<Oldman> oldmanList_update=new ArrayList<>();//对已存在的老人进行批量更新


        String  fix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        Workbook wb0;
        if(fix.equals("xls"))
            wb0= new HSSFWorkbook(file.getInputStream());
        else
            wb0=new XSSFWorkbook(file.getInputStream());

        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successUpdate=0;//导入数量中  更新的个数
        int successAdd=0;//导入数量中  增加的个数
        int numFail=0;


        Map<String,Oldman> allOldmans=new HashMap<>();
        Set<String> addPids=new HashSet<>();//防止 同时添加 身份证号一样的老人
        allOldmans=oldmanBaseDao.getAllOldman();
        List<Integer> oldmanIds_delHealthSelect=new ArrayList<>();
        Set<Integer> healthSlectId=new HashSet<>();

        Set<String> oldmanfiledNames=new HashSet<>();
        Set<String> oldmanHealthfiledNames=new HashSet<>();
        Set<Oldman> snIds=new HashSet<>();
        Set<Oldman> mbIds=new HashSet<>();
//        List<Integer> HealthSelectfiledIds=new ArrayList<>();
        //对Sheet中的每一行进行迭代
        for (Row r : sht0) {

            try {
                if (r.getRowNum() >= (start-1)) {
                    //遍历 cell  将单元格 格式 全都转换成String 类型
                    Iterator<Cell> cells = r.cellIterator();    //获得第一行的迭代器
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    if (!commonService.excelIsNotNull(r.getCell(0))) {
                        continue;
                    }
                    Oldman oldman = null;
                    Linkman linkman = null;
                    OldmanHealth oldmanHealth = null;
                    HealthSelectMan healthSelectMan = null;
                    for (String str : tables) {

                        String[] array = str.split("#");
                        String className = array[0];
                        String filedName = array[1];
                        String value = null;
                        if (filedName.contains("@")) {
                            value = filedName.split("@")[1];
                            filedName = filedName.split("@")[0];
                        }
                        Integer colNum = Integer.parseInt(array[2]);

                        String setM = "set" + filedName;
                        Method method;
                        String data;
                        if (commonService.excelIsNotNull(r.getCell(colNum)))
                            data = r.getCell(colNum).getStringCellValue();
                        else
                            data = "";//用于标志  是空的   更新数据库时，只更新选定的内容
                        switch (className) {
                            case "Oldman":
                                if (oldman == null)
                                    oldman = new Oldman();
                                if (filedName.equals("Sex")) {
                                    data = data.replace("性", "");
                                    oldman.setSex((data.equals("男")) ? 2 : 1);
                                } else if (filedName.equals("Pid")) {
                                    oldman.setPid(data);
                                    oldman.setBirthday(Tool.stringToDate(
                                                oldman.getPid().substring(6,10)+"-"
                                                        +oldman.getPid().substring(10,12)+"-"
                                                        +oldman.getPid().substring(12,14)));
                                    if(oldman.getPid().length()!=15 && oldman.getPid().length()!=18){
                                        if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.PID.getName())) {
                                            excelReturnModel.getFail_detail().get(ImportFailEnum.PID.getName()).add(r.getRowNum() + 1);
                                        } else {
                                            List<Integer> list = new ArrayList<>();
                                            list.add(r.getRowNum() + 1);
                                            excelReturnModel.getFail_detail().put(ImportFailEnum.PID.getName(), list);
                                        }
                                        numFail++;
                                        continue;
                                    }
                                    if(oldman.getBirthday()==null || CommonService.birthdayToAge(oldman.getBirthday())<60 || CommonService.birthdayToAge(oldman.getBirthday())>150){
                                        if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.AGE.getName())) {
                                            excelReturnModel.getFail_detail().get(ImportFailEnum.AGE.getName()).add(r.getRowNum() + 1);
                                        } else {
                                            List<Integer> list = new ArrayList<>();
                                            list.add(r.getRowNum() + 1);
                                            excelReturnModel.getFail_detail().put(ImportFailEnum.AGE.getName(), list);
                                        }
                                        numFail++;
                                        continue;
                                    }
                                    if (addPids.contains(oldman.getPid())) {
                                        if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.REPEAT.getName())) {
                                            excelReturnModel.getFail_detail().get(ImportFailEnum.REPEAT.getName()).add(r.getRowNum() + 1);
                                        } else {
                                            List<Integer> list = new ArrayList<>();
                                            list.add(r.getRowNum() + 1);
                                            excelReturnModel.getFail_detail().put(ImportFailEnum.REPEAT.getName(), list);
                                        }
                                        numFail++;
                                        continue;
                                    } else {
                                        addPids.add(oldman.getPid());
                                    }
                                } else {
                                    method = oldman.getClass().getMethod(setM, String.class);
                                    method.invoke(oldman, data);
                                }
                                oldmanfiledNames.add(filedName);
                                oldmanfiledNames.add("Birthday");
                                break;
                            case "Linkman":
                                if (linkman == null)
                                    linkman = new Linkman();
                                method = linkman.getClass().getMethod(setM, String.class);
                                method.invoke(linkman, data);
                                break;
                            case "OldmanHealth":
                                if (oldmanHealth == null)
                                    oldmanHealth = new OldmanHealth();
                                method = oldmanHealth.getClass().getMethod(setM, String.class);
                                if (data.equals("1"))
                                    method.invoke(oldmanHealth, value);
                                oldmanHealthfiledNames.add(filedName);
                                break;
                            case "HealthSelectMan":
                                if (data.equals("1")) {
                                    healthSelectMan = new HealthSelectMan();
                                    healthSelectMan.setHealthSelectId(Integer.parseInt(value));
                                    if (healthSelectMan.getHealthSelectId() >= 20 && healthSelectMan.getHealthSelectId() <= 25) {
                                        //失能
                                        snIds.add(oldman);
                                    }
                                    if (healthSelectMan.getHealthSelectId() <= 15) {
                                        //慢病
                                        mbIds.add(oldman);
                                    }
                                }
                                healthSlectId.add(Integer.parseInt(value));


                        }
                        if (healthSelectMan != null) {
                            healthSelectManList_add.add(healthSelectMan);
                        }
                    }
                    if (oldman != null && allOldmans.containsKey(oldman.getPid())) {
                        //更新
                        oldman.setId(allOldmans.get(oldman.getPid()).getId());
                        oldmanIds_delHealthSelect.add(oldman.getId());
                        oldmanList_update.add(oldman);
                        if (linkman != null) {
                            linkman.setOldmanId(oldman.getId());
                            linkmanList_update.add(linkman);
                        }
                        if (oldmanHealth != null) {
                            oldmanHealth.setOldmanId(oldman.getId());
                            healthList_update.add(oldmanHealth);
                        }
                        if (healthSelectManList_add.size() > 0) {
                            Oldman finalOldman = oldman;
                            healthSelectManList_add.forEach(s -> s.setOldmanId(finalOldman.getId()));
                        }
                        successUpdate++;
                    } else {
                        //添加
                        oldman.setDisable(2);//非街道的
                        oldmanList_add.add(oldman);
                        if (linkman != null) {
                            linkman.setOldman(oldman);
                            linkmanList_update.add(linkman);
                        }
                        if (oldmanHealth != null) {
                            oldmanHealth.setOldman(oldman);
                            healthList_update.add(oldmanHealth);
                        }
                        if (healthSelectManList_add.size() > 0) {
                            Oldman finalOldman1 = oldman;
                            healthSelectManList_add.forEach(s -> s.setOldman(finalOldman1));
                        }
                        successAdd++;
                    }
                    numSuccess++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.NONE.getName())) {
                    excelReturnModel.getFail_detail().get(ImportFailEnum.NONE.getName()).add(r.getRowNum() + 1);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(r.getRowNum() + 1);
                    excelReturnModel.getFail_detail().put(ImportFailEnum.NONE.getName(), list);
                }
                numFail++;
            }
        }


        //更新
        if(oldmanList_update.size()>0)
            oldmanBaseDao.updateByIdsSelect(oldmanList_update,oldmanfiledNames);
        if(linkmanList_update.size()>0)
            linkmanDao.updateByOldmanIds(linkmanList_update);
         if(healthList_update.size()>0)
            oldmanHealthDao.updateByOldmanIdsSelect(healthList_update,oldmanHealthfiledNames);

//        //添加
        if(oldmanList_add.size()>0){
            List<Integer> oldmanIds_health=new ArrayList<>();
            List<Integer> oldmanIds_linkman=new ArrayList<>();
            for (Oldman oldman:oldmanList_add){
                oldmanIds_health.add(oldman.getId());
                oldmanIds_linkman.add(oldman.getId());
                oldman.setDisable(2);
            }
            oldmanBaseDao.saveAll(oldmanList_add);
            for(Linkman linkman:linkmanList_add){
                if(linkman.getOldman()!=null){
                    linkman.setOldmanId(linkman.getOldman().getId());
                    oldmanIds_linkman.remove(linkman.getOldmanId());
                }
            }
            for(OldmanHealth health:healthList_add){
                if(health.getOldman()!=null){
                    health.setOldmanId(health.getOldman().getId());
                    oldmanIds_health.remove(health.getOldmanId());//不重复添加
                }
            }
            oldmanHealthDao.saveAllOldmanIds(oldmanIds_health);//添加老人时 同时添加应急联系人和 健康基础信息
            linkmanDao.saveAllOldmanIds(oldmanIds_linkman);
            for(HealthSelectMan healthSelectMan:healthSelectManList_add){
                if(healthSelectMan.getOldman()!=null){
                    healthSelectMan.setOldmanId(healthSelectMan.getOldman().getId());
                }
            }
        }
        if(linkmanList_add.size()>0)
            linkmanDao.saveAll(linkmanList_add);
        if(healthList_add.size()>0)
            oldmanHealthDao.saveAll(healthList_add);

        if(snIds.size()>0){
            String[] oldmanIds=new String[snIds.size()];
            int i=0;
            for(Oldman oldman:snIds){
                oldmanIds[i++]=oldman.getId()+"";
            }
            oldmanHealthDao.updatePropsByOldmanIds("is_sn","2",oldmanIds);
        }
        if(mbIds.size()>0){
            String[] oldmanIds=new String[mbIds.size()];
            int i=0;
            for(Oldman oldman:mbIds){
                oldmanIds[i++]=oldman.getId()+"";
            }
            oldmanHealthDao.updatePropsByOldmanIds("is_mb","1",oldmanIds);
        }
//先把之前的同类型的记录删掉  比如选了慢病肿瘤这一列 则把该老人之前的慢病肿瘤删掉
        if(oldmanIds_delHealthSelect.size()>0 && healthSlectId.size()>0){
            healthSelectManDao.del(oldmanIds_delHealthSelect,healthSlectId);
        }

        if(healthSelectManList_add.size()>0) {
            healthSelectManDao.saveAll(healthSelectManList_add);
        }

        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setSuccessAdd(successAdd);
        excelReturnModel.setSuccessUpdate(successUpdate);
        excelReturnModel.setNumFail(numFail);
        excelReturnModel.setTotal(numSuccess+numFail);//一共

        return new Result(true,excelReturnModel);
    }
}
