package com.organOld.outService.service.impl;

import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.Message;
import com.organOld.dao.entity.home.Doctor;
import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanKey;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.HomeOldmanRequest;
import com.organOld.outService.contract.HomeRequest;
import com.organOld.outService.contract.Result;
import com.organOld.outService.enumModel.HomeEnum;
import com.organOld.outService.enumModel.ImportFailEnum;
import com.organOld.outService.enumModel.MessageTypeEnum;
import com.organOld.outService.model.ExcelReturnModel;
import com.organOld.outService.model.HomeModel;
import com.organOld.outService.model.HomeOldmanAddInfo;
import com.organOld.outService.model.HomeOldmanModel;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.HomeService;
import com.organOld.outService.service.OldmanService;
import com.organOld.outService.service.OrganService;
import com.organOld.outService.tool.Tool;
import com.organOld.outService.wrapper.HomeOldmanWrapper;
import com.organOld.outService.wrapper.HomeWrapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService{

    @Autowired
    CommonService commonService;
    @Autowired
    HomeDao homeDao;
    @Autowired
    HomeOldmanDao homeOldmanDao;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    OrganDao organDao;
    @Autowired
    OldmanKeyHandleDao oldmanKeyHandleDao;
    @Autowired
    ChxDao chxDao;
    @Autowired
    HomeDoctorDao homeDoctorDao;
    @Autowired
    HomeWrapper homeWrapper;
    @Autowired
    HomeOldmanWrapper homeOldmanWrapper;
    @Autowired
    OldmanService oldmanService;
    @Autowired
    OrganService organService;
    @Autowired
    CardDao cardDao;
    @Autowired
    UserDao userDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    OldmanHealthDao oldmanHealthDao;
    @Autowired
    LinkmanDao linkmanDao;


    @Override
    public String getManAllByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest) {
        Page<HomeOldman> page=commonService.getPage(bTableRequest,"oldman_homeOldman");
        HomeOldman homeOldman=homeOldmanWrapper.unwrap(homeOldmanRequest);
        page.setEntity(homeOldman);
        List<HomeOldmanModel> organOldmanModelList=homeOldmanDao.getManAllByPage(page).stream().map(homeOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=homeOldmanDao.getManAllSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public String getByPage(HomeRequest homeRequest, BTableRequest bTableRequest) {
        Page<Home> page=commonService.getPage(bTableRequest,"home");
        Home home= homeWrapper.unwrap(homeRequest);
        page.setEntity(home);
        List<HomeModel> homeModelList=homeDao.getByPage(page).stream().map(homeWrapper::wrap).collect(Collectors.toList());
        Long size=homeDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,homeModelList);
    }

    @Override
    public String getManByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest) {
        Page<HomeOldman> page=commonService.getPage(bTableRequest,"home_man");
        HomeOldman homeOldman= homeOldmanWrapper.unwrap(homeOldmanRequest);
        page.setEntity(homeOldman);
        List<HomeOldmanModel> organOldmanModelList=homeOldmanDao.getManAllByPage(page).stream().map(homeOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=homeOldmanDao.getManAllSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    //现在的
    @Override
    @Transactional
    public Result importManExcel(MultipartFile file, String ny,String type) throws IOException {
        List<HomeOldman> homeOldmanList=new ArrayList<>();

        String  fix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        Workbook wb0;
        if(fix.equals("xls"))
            wb0= new HSSFWorkbook(file.getInputStream());
        else
            wb0=new XSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        int start=2;

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int numFail=0;
//        excelReturnModel.setTotal(sht0.getLastRowNum()-(start-1));//一共

//        Integer jwId=commonService.getIdBySession();


//        List<Oldman> oldmanList=new ArrayList<>();//用于当前导入的老人 养老状态

        Map<String,Oldman> existOldmanMap=oldmanService.getAllOldman();
        List<Oldman> oldmanList_add=new ArrayList<>();
        Map<String,Oldman> oldmanList_add_map=new HashMap<>();
        List<Home> homeList=homeDao.getAll();
        Map<String,Integer> homeMap=new HashMap<>();
        homeList.forEach(s->homeMap.put(s.getSecType(),s.getId()));
        List<Organ> organList=organService.getAll();
        Map<String,Integer> organMap=new HashMap<>();
        organList.forEach(s->organMap.put(s.getName(),s.getId()));

        Row rt=null;//表头
        for (Row r : sht0) {
            if(r.getRowNum()==start-1){
                rt=r;
            }
            try {
                if (r.getRowNum() >= start) {
                    Iterator<Cell> cells = r.cellIterator();    //获得第一行的迭代器
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    List<HomeOldman> homeOldmanList_tmp=new ArrayList<>();

//                    int oldStatus= OldStatusEnum.JJ.getIndex();//养老状态
                    Integer oldmanId=0;
                    Integer jjfwOrg=0,chxOrg=0,znOrg=0;

                    Oldman oldman=new Oldman();
                    if (commonService.excelIsNotNull(r.getCell(0))) {
                    }else{
                        continue;
                    }

                    if (commonService.excelIsNotNull(r.getCell(12))) {
                        // 机构必须 先录入到系统中
                        jjfwOrg=organMap.get(r.getCell(12).getStringCellValue());
                        if(jjfwOrg==null || jjfwOrg==0){
                            if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.JGNO.getName())) {
                                excelReturnModel.getFail_detail().get(ImportFailEnum.PID.getName()).add(r.getRowNum() + 1);
                            } else {
                                List<Integer> list = new ArrayList<>();
                                list.add(r.getRowNum() + 1);
                                excelReturnModel.getFail_detail().put(ImportFailEnum.JGNO.getName(), list);
                            }
                            numFail++;
                            continue;
                        }
                    }
                    if (commonService.excelIsNotNull(r.getCell(15))) {
                        chxOrg=organMap.get(r.getCell(15).getStringCellValue());
                        if(chxOrg==null || chxOrg==0){
                            if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.JGNO.getName())) {
                                excelReturnModel.getFail_detail().get(ImportFailEnum.PID.getName()).add(r.getRowNum() + 1);
                            } else {
                                List<Integer> list = new ArrayList<>();
                                list.add(r.getRowNum() + 1);
                                excelReturnModel.getFail_detail().put(ImportFailEnum.JGNO.getName(), list);
                            }
                            numFail++;
                            continue;
                        }
                    }
                    if (commonService.excelIsNotNull(r.getCell(19))) {
                        znOrg=organMap.get(r.getCell(19).getStringCellValue());
                        if(znOrg==null || znOrg==0){
                            if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.JGNO.getName())) {
                                excelReturnModel.getFail_detail().get(ImportFailEnum.PID.getName()).add(r.getRowNum() + 1);
                            } else {
                                List<Integer> list = new ArrayList<>();
                                list.add(r.getRowNum() + 1);
                                excelReturnModel.getFail_detail().put(ImportFailEnum.JGNO.getName(), list);
                            }
                            numFail++;
                            continue;
                        }
                    }


                    if (commonService.excelIsNotNull(r.getCell(1))) {
                        Oldman existOldman=existOldmanMap.get(r.getCell(1).getStringCellValue());
                        if(existOldman!=null){
                            oldmanId=existOldman.getId();
                        }else{
                            oldman.setName(r.getCell(0).getStringCellValue());
                            oldman.setPid(r.getCell(1).getStringCellValue());
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
                            //去重
                            if(oldmanList_add_map.containsKey(oldman)){
                                oldman=oldmanList_add_map.get(oldman.getPid());
                            }else{
                                oldmanList_add.add(oldman);
                                oldmanList_add_map.put(oldman.getPid(),oldman);
                            }
                        }
                    }else{
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

                    /**
                     * 家庭服务
                     */


                    if (commonService.excelIsNotNullOne(r.getCell(2))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setHomeId(homeMap.get(rt.getCell(2).getStringCellValue()));
                        homeOldman.setNy(ny);
                        homeOldman.setOrganId(jjfwOrg);
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            excelReturnModel.getFail().add(r.getRowNum() + 1);
                            continue;
                        }
                    }

                    if (commonService.excelIsNotNullOne(r.getCell(3))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setHomeId(homeMap.get(rt.getCell(3).getStringCellValue()));
                        homeOldman.setNy(ny);
                        homeOldman.setOrganId(jjfwOrg);
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            excelReturnModel.getFail().add(r.getRowNum() + 1);
                            continue;
                        }
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(4))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setHomeId((homeMap.get(rt.getCell(4).getStringCellValue())));
                        homeOldman.setNy(ny);
                        homeOldman.setOrganId(jjfwOrg);
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            excelReturnModel.getFail().add(r.getRowNum() + 1);
                            continue;
                        }
                    }


                    if (commonService.excelIsNotNullOne(r.getCell(5))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setHomeId(homeMap.get(rt.getCell(5).getStringCellValue()));
                        homeOldman.setNy(ny);
                        homeOldman.setOrganId(jjfwOrg);
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            excelReturnModel.getFail().add(r.getRowNum() + 1);
                            continue;
                        }
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(6))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setHomeId(homeMap.get(rt.getCell(6).getStringCellValue()));
                        homeOldman.setNy(ny);
                        homeOldman.setOrganId(jjfwOrg);
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            excelReturnModel.getFail().add(r.getRowNum() + 1);
                            continue;
                        }
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(7))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setHomeId(homeMap.get(rt.getCell(7).getStringCellValue()));
                        homeOldman.setNy(ny);
                        homeOldman.setOrganId(jjfwOrg);
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            excelReturnModel.getFail().add(r.getRowNum() + 1);
                            continue;
                        }
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(8))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setHomeId(homeMap.get(rt.getCell(8).getStringCellValue()));
                        homeOldman.setNy(ny);
                        homeOldman.setOrganId(jjfwOrg);
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            excelReturnModel.getFail().add(r.getRowNum() + 1);
                            continue;
                        }
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(9))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setHomeId(homeMap.get(rt.getCell(9).getStringCellValue()));
                        homeOldman.setNy(ny);
                        homeOldman.setOrganId(jjfwOrg);
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            excelReturnModel.getFail().add(r.getRowNum() + 1);
                            continue;
                        }
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(10))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setHomeId(homeMap.get(rt.getCell(10).getStringCellValue()));
                        homeOldman.setNy(ny);
                        homeOldman.setOrganId(jjfwOrg);
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            excelReturnModel.getFail().add(r.getRowNum() + 1);
                            continue;
                        }
                    }
                    if (commonService.excelIsNotNullOne(r.getCell(11))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setHomeId(homeMap.get(rt.getCell(11).getStringCellValue()));
                        homeOldman.setNy(ny);
                        homeOldman.setOrganId(jjfwOrg);
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            excelReturnModel.getFail().add(r.getRowNum() + 1);
                            continue;
                        }
                    }

                    /**
                     * 长护险
                     */


                    if (commonService.excelIsNotNull(r.getCell(13))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setOrganId(chxOrg);
                        homeOldman.setNy(ny);
                        homeOldman.setHomeId(homeMap.get(r.getCell(13).getStringCellValue().replaceAll("级","")));
                        if (commonService.excelIsNotNullOne(r.getCell(14))) {
                            homeOldman.setIsService(1);
                        }
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            excelReturnModel.getFail().add(r.getRowNum() + 1);
                            continue;
                        }
                    }


                    /**
                     * 智能设备
                     */


                    if (commonService.excelIsNotNull(r.getCell(16))) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setOrganId(znOrg);
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setNy(ny);
                        homeOldman.setHomeId(homeMap.get(r.getCell(16).getStringCellValue()));
                        if(commonService.excelIsNotNull(r.getCell(17))){
                            homeOldman.setTimeIn(Tool.stringToDate(r.getCell(17).getStringCellValue()));
                        }
                        if(commonService.excelIsNotNull(r.getCell(18))){
                            homeOldman.setTimeOut(Tool.stringToDate(r.getCell(18).getStringCellValue()));
                        }
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.ZNSB.getName())) {
                                excelReturnModel.getFail_detail().get(ImportFailEnum.ZNSB.getName()).add(r.getRowNum() + 1);
                            } else {
                                List<Integer> list = new ArrayList<>();
                                list.add(r.getRowNum() + 1);
                                excelReturnModel.getFail_detail().put(ImportFailEnum.ZNSB.getName(), list);
                            }
                            numFail++;
                            continue;
                        }
                    }


                    /**
                     * 家庭医生
                     */
                    if (commonService.excelIsNotNull(r.getCell(20))) {
                        HomeOldman homeOldman=new HomeOldman();
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        homeOldman.setNy(ny);
                        if(commonService.excelIsNotNull(r.getCell(21))){
                            homeOldman.setTimeIn(Tool.stringToDate(r.getCell(21).getStringCellValue()));
                        }
                        if(commonService.excelIsNotNull(r.getCell(22))){
                            homeOldman.setTimeOut(Tool.stringToDate(r.getCell(22).getStringCellValue()));
                        }
                        homeOldman.setHomeId(homeMap.get(r.getCell(20).getStringCellValue()));
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.JTYS.getName())) {
                                excelReturnModel.getFail_detail().get(ImportFailEnum.JTYS.getName()).add(r.getRowNum() + 1);
                            } else {
                                List<Integer> list = new ArrayList<>();
                                list.add(r.getRowNum() + 1);
                                excelReturnModel.getFail_detail().put(ImportFailEnum.JTYS.getName(), list);
                            }
                            numFail++;
                            continue;
                        }

                    }

                    /**
                     * 家庭病床
                     */
                    if (commonService.excelIsNotNull(r.getCell(23))) {
                        HomeOldman homeOldman=new HomeOldman();
                        homeOldman.setNy(ny);
                        if(oldmanId!=null && oldmanId!=0){
                            homeOldman.setOldmanId(oldmanId);
                        }else{
                            homeOldman.setOldman(oldman);
                        }
                        if(commonService.excelIsNotNull(r.getCell(24))){
                            homeOldman.setTimeIn(Tool.stringToDate(r.getCell(24).getStringCellValue()));
                        }
                        if(commonService.excelIsNotNull(r.getCell(25))){
                            homeOldman.setTimeOut(Tool.stringToDate(r.getCell(25).getStringCellValue()));
                        }
                        homeOldman.setHomeId(homeMap.get(r.getCell(23).getStringCellValue()));
                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0) {
                            homeOldmanList_tmp.add(homeOldman);
                        } else {
                            if (excelReturnModel.getFail_detail().containsKey(ImportFailEnum.JTBC.getName())) {
                                excelReturnModel.getFail_detail().get(ImportFailEnum.JTBC.getName()).add(r.getRowNum() + 1);
                            } else {
                                List<Integer> list = new ArrayList<>();
                                list.add(r.getRowNum() + 1);
                                excelReturnModel.getFail_detail().put(ImportFailEnum.JTBC.getName(), list);
                            }
                            numFail++;
                            continue;
                        }

                    }

                    numSuccess++;
                    homeOldmanList.addAll(homeOldmanList_tmp);
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
        excelReturnModel.setNumFail(numFail);
        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setTotal(excelReturnModel.getNumFail()+excelReturnModel.getNumSuccess());
//        该居家 删除的老人 的养老状态   之前是社区居家养老 则变为2  其他为0
//        if(type.equals("update")){
//            //更新的方式
//            //删掉之前的所有数据
//            homeOldmanDao.delAll();
//            oldmanKeyHandleDao.delByOldman(oldmanList);
//            //将 养老状态为4 的改为 2
//            //将 养老状态为3 的改为 0 切 handle=0
//            oldmanDao.delHomeOldStatus();
//        }else{
//            if(oldmanList.size()>0)
//                oldmanKeyHandleDao.delByOldman(oldmanList);
//        }

        if(type.equals("update")){
            //某个年月的 更新  则进行覆盖 把之前的删掉
            homeOldmanDao.delByNy(ny);
        }

        List<Card> cardList_add=new ArrayList<>();


        if(oldmanList_add.size()>0){
            List<Integer> oldmanIds_health=new ArrayList<>();
            List<Integer> oldmanIds_linkman=new ArrayList<>();
            oldmanDao.saveAllNoExist(oldmanList_add);
            for(HomeOldman homeOldman:homeOldmanList){
                if(homeOldman.getOldman()!=null){
                    homeOldman.setOldmanId(homeOldman.getOldman().getId());
                    Card card=new Card();
                    card.setOldmanId(homeOldman.getOldman().getId());
                    card.setCid(homeOldman.getOldman().getPid());
                    card.setPassword("123456");
                    cardList_add.add(card);
                    oldmanIds_health.add(card.getOldmanId());
                    oldmanIds_linkman.add(card.getOldmanId());
                }
            }
            oldmanHealthDao.saveAllOldmanIds(oldmanIds_health);//添加老人时 同时添加应急联系人和 健康基础信息
            linkmanDao.saveAllOldmanIds(oldmanIds_linkman);
        }

        if(cardList_add.size()>0)
            cardDao.saveAll(cardList_add);

        if(homeOldmanList.size()>0){
            // 老人基本信息表  养老状态更新
//            if(oldmanList.size()>0)
//                oldmanDao.updateOrganExceLImportByIds(oldmanList);
            homeOldmanDao.saveAll(homeOldmanList);
        }

        Message message=new Message();
        message.setUserIds(userDao.getUserIdsByRole("admin"));
        message.setType(MessageTypeEnum.XT.getIndex());
        message.setContent("居家养老机构导入"+ny+"的老人数据，"+"共"+excelReturnModel.getNumSuccess()+"人");
        messageDao.saveAllBySame(message);

        return new Result(true,excelReturnModel);
    }



    //以前的
//    @Override
//    @Transactional
//    public Result importManExcel_before(MultipartFile file, String ny,String type) throws IOException {
//        List<HomeOldman> homeOldmanList=new ArrayList<>();
//
//        String  fix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
//        Workbook wb0;
//        if(fix.equals("xls"))
//            wb0= new HSSFWorkbook(file.getInputStream());
//        else
//            wb0=new XSSFWorkbook(file.getInputStream());
//        //获取Excel文档中的第一个表单
//        Sheet sht0 = wb0.getSheetAt(0);
//        int start=4;
//
//        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
//        int numSuccess=0;//成功导入的数量
//        int successAdd=0;//导入数量中  增加的个数
//        excelReturnModel.setTotal(sht0.getLastRowNum()-(start-1));//一共
//
//        Map<String,Oldman> existOldmanMap=oldmanService.getAllOldman();
//        List<Home> homeList=homeDao.getAll();
//        Map<String,Integer> homeMap=new HashMap<>();
//        homeList.forEach(s->homeMap.put(s.getSecType(),s.getId()));
//        List<Organ> organList=organService.getAll();
//        Map<String,Integer> organMap=new HashMap<>();
//        organList.forEach(s->organMap.put(s.getName(),s.getId()));
//
//        List<Oldman> oldmanList_add=new ArrayList<>();
//
//        Row rt=null;//表头
//        for (Row r : sht0) {
//            if(r.getRowNum()==start-1){
//                rt=r;
//            }
//
//            try {
//                if (r.getRowNum() >= start) {
//                    Iterator<Cell> cells = r.cellIterator();    //获得第一行的迭代器
//                    while (cells.hasNext()) {
//                        Cell cell = cells.next();
//                        cell.setCellType(Cell.CELL_TYPE_STRING);
//                    }
//                    Integer oldmanId=0;
//
//                    Oldman oldman=new Oldman();
//
//                    if (commonService.excelIsNotNull(r.getCell(3))) {
//                        Oldman existOldman=existOldmanMap.get(r.getCell(3).getStringCellValue());
//                        if(existOldman!=null){
//                            oldmanId=existOldman.getId();
//                        }else{
//                            oldman.setName(r.getCell(2).getStringCellValue());
//                            oldman.setPid(r.getCell(3).getStringCellValue());
//                            oldmanList_add.add(oldman);
//                        }
//                    }else{
//                        continue;
//                    }
//
//                    /**
//                     * 家庭服务
//                     */
//
//                    if (commonService.excelIsNotNullOne(r.getCell(4))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setHomeId(7);
//                        homeOldman.setNy(ny);
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//                    }
//                    if (commonService.excelIsNotNullOne(r.getCell(5))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setHomeId(8);
//                        homeOldman.setNy(ny);
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//                    }
//                    if (commonService.excelIsNotNullOne(r.getCell(6))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setHomeId(9);
//                        homeOldman.setNy(ny);
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//                    }
//                    if (commonService.excelIsNotNullOne(r.getCell(7))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setHomeId(10);
//                        homeOldman.setNy(ny);
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//                    }
//                    if (commonService.excelIsNotNullOne(r.getCell(8))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setHomeId(11);
//                        homeOldman.setNy(ny);
//                        homeOldmanList.add(homeOldman);
//                    }
//                    if (commonService.excelIsNotNullOne(r.getCell(9))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setHomeId(12);
//                        homeOldman.setNy(ny);
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//                    }
//                    if (commonService.excelIsNotNullOne(r.getCell(10))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setHomeId(13);
//                        homeOldman.setNy(ny);
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//                    }
//                    if (commonService.excelIsNotNullOne(r.getCell(11))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setHomeId(14);
//                        homeOldman.setNy(ny);
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//                    }
//                    if (commonService.excelIsNotNullOne(r.getCell(12))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setHomeId(15);
//                        homeOldman.setNy(ny);
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//                    }
//                    if (commonService.excelIsNotNullOne(r.getCell(13))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setHomeId(16);
//                        homeOldman.setNy(ny);
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                            homeOldmanList.add(homeOldman);
//                    }
//
//                    /**
//                     * 长护险
//                     */
//                    if (commonService.excelIsNotNull(r.getCell(14))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setNy(ny);
//                        homeOldman.setHomeId(homeMap.get(r.getCell(14).getStringCellValue().replaceAll("级","")));
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//                    }
//
//                    /**
//                     * 智能设备
//                     */
//
//                    if (commonService.excelIsNotNullOne(r.getCell(15)) ) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setNy(ny);
//                        homeOldman.setHomeId(homeMap.get(rt.getCell(15).getStringCellValue()));
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//                    }
//                    if (commonService.excelIsNotNullOne(r.getCell(16)) ) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setNy(ny);
//                        homeOldman.setHomeId(homeMap.get(rt.getCell(16).getStringCellValue()));
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//                    }
//
//                    /**
//                     * 家庭医生
//                     */
//                    if (commonService.excelIsNotNull(r.getCell(17))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        homeOldman.setNy(ny);
//                        if(homeMap.get(r.getCell(17).getStringCellValue())!=null)
//                            homeOldman.setHomeId(homeMap.get(r.getCell(17).getStringCellValue()));
//                        else{
//                            Doctor doctor=new Doctor();
//                            doctor.setName(r.getCell(17).getStringCellValue());
//                            doctor.setOrganId(organMap.get(r.getCell(18).getStringCellValue()));
//                            homeDoctorDao.save(doctor);
//                            Home home=new Home();
//                            home.setFirType(4);
//                            home.setSecType(doctor.getId()+"");
//                            if(home.getSecType()!=null && !home.getSecType().equals(""))
//                            homeDao.save(home);
//                            homeOldman.setHomeId(home.getId());
//                            homeMap.put(doctor.getName(),home.getId());
//                        }
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//
//                    }
//
//                    /**
//                     * 家庭病床
//                     */
//                    if (commonService.excelIsNotNull(r.getCell(19))) {
//                        HomeOldman homeOldman=new HomeOldman();
//                        homeOldman.setNy(ny);
//                        if(oldmanId!=null && oldmanId!=0){
//                            homeOldman.setOldmanId(oldmanId);
//                        }else{
//                            homeOldman.setOldman(oldman);
//                        }
//                        if(homeMap.get(r.getCell(19).getStringCellValue())!=null)
//                            homeOldman.setHomeId(homeMap.get(r.getCell(19).getStringCellValue()));
//                        else{
//                            Home home=new Home();
//                            home.setFirType(5);
//                            home.setSecType(""+organMap.get(r.getCell(19).getStringCellValue()));
//                            homeOldman.setHomeId(home.getId());
//                            if(home.getSecType()!=null && !home.getSecType().equals(""))
//                            homeDao.save(home);
//                            homeMap.put(r.getCell(19).getStringCellValue(),home.getId());
//                        }
//                        if(homeOldman.getHomeId()!=null && homeOldman.getHomeId()!=0)
//                        homeOldmanList.add(homeOldman);
//
//                    }
//
//                    numSuccess++;
//                    successAdd++;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                excelReturnModel.getFail().add(r.getRowNum() + 1);
//            }
//        }
//        excelReturnModel.setNumFail(excelReturnModel.getFail().size());
//        excelReturnModel.setSuccessAdd(successAdd);
//        excelReturnModel.setNumSuccess(numSuccess);
//
//
//        if(type.equals("update")){
//            //某个年月的 更新  则进行覆盖 把之前的删掉
//            homeOldmanDao.delByNy(ny);
//        }
//
//        List<Card> cardList_add=new ArrayList<>();
//
//        if(oldmanList_add.size()>0){
//            oldmanDao.saveAllNoExist(oldmanList_add);
//            for(HomeOldman homeOldman:homeOldmanList){
//                if(homeOldman.getOldman()!=null){
//                    homeOldman.setOldmanId(homeOldman.getOldman().getId());
//                    Card card=new Card();
//                    card.setOldmanId(homeOldman.getOldman().getId());
//                    card.setCid(homeOldman.getOldman().getPid().substring(homeOldman.getOldman().getPid().length()-10));
//                    card.setPassword("123456");
//                    cardList_add.add(card);
//                }
//            }
//        }
//
//        if(cardList_add.size()>0)
//            cardDao.saveAll(cardList_add);
//
//        if(homeOldmanList.size()>0){
//            homeOldmanDao.saveAll(homeOldmanList);
//        }
//
//        Message message=new Message();
//        message.setUserIds(userDao.getUserIdsByRole("admin"));
//        message.setType(MessageTypeEnum.XT.getIndex());
//        message.setContent("导入"+ny+"的居家养老数据，"+"共"+excelReturnModel.getNumSuccess()+"条");
//        messageDao.saveAllBySame(message);
//        return new Result(true,excelReturnModel);
//    }


    private Integer getIdBySecType(String stringCellValue, int index) {
       return homeDao.getIdBySecType(stringCellValue,index);
    }

    @Override
    @Transactional
    public void addOrUpdate(Home home,String type) {
        if(type.equals("add")) {
            switch (home.getFirType()) {
                case 2:
                    chxDao.save(home.getChx());
                    home.setSecType(home.getChx().getId() + "");
                    break;
                case 4:
                    homeDoctorDao.save(home.getDoctor());
                    home.setSecType(home.getDoctor().getId() + "");
                    break;
            }
            homeDao.save(home);
        }else{
            switch (home.getFirType()) {
                case 1:
                case 3:
                case 5:
                    homeDao.updateById(home);
                    break;
                case 2:
                    home.getChx().setHomeId(home.getId());
                    chxDao.updateById(home.getChx());
                    break;
                case 4:
                    home.getDoctor().setHomeId(home.getId());
                    homeDoctorDao.updateById(home.getDoctor());
                    break;
            }
        }
    }

    @Override
    public Result getById(int id, int firType) {
        return new Result(true,homeDao.getByIdAndFirType(id,firType));
    }

    @Override
    @Transactional
    public void delByIds(String[] ids, int type) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        homeDao.delByIds(id);
        switch (type) {
            case 2:
                chxDao.delByIds(id);
                break;
            case 4:
                homeDoctorDao.delByIds(id);
                break;
        }

    }

    @Override
    public HomeOldman getOldmanById(Integer id) {
        return homeOldmanDao.getById(id);
    }

    @Override
    @Transactional
    public void delByOldmanIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        List<Integer> delOldmanId=homeOldmanDao.getDelOldmanIdsByHomeOldmanIds(id);
        homeOldmanDao.delByIds(id);
        //先将删掉的老人 默认去掉了 居家养老
        oldmanDao.delHomeOldStatusByIds(delOldmanId);
        //删掉之后 看还有 该老人其他的居家养老  回复 old_status和is_handle
        List<Oldman> oldmanList=oldmanDao.getByDelOldmanIds(delOldmanId);
        if(oldmanList.size()>0) {
            for (Oldman oldman : oldmanList) {
                if (oldman.getOldStatus() == 2) {
                    oldman.setOldStatus(4);
                } else if (oldman.getOldStatus() == 0) {
                    oldman.setOldStatus(3);
                }
                oldman.setIsHandle(2);
            }
            oldmanDao.updateOrganExceLImportByIds(oldmanList);
        }
        Message message=new Message();
        message.setUserIds(userDao.getUserIdsByRole("admin"));
        message.setType(MessageTypeEnum.XT.getIndex());
        message.setContent("居家养老机构删除"+ids.length+"条数据。");
        messageDao.saveAllBySame(message);
    }

    @Override
    public void updateOldman(HomeOldman homeOldman) {
        Integer firType=homeDao.getById(homeOldman.getHomeId()).getFirType();
        if(firType==4 || firType==5)
            homeOldman.setOrganId(null);
        if(firType!=2)
            homeOldman.setIsService(null);
        homeOldmanDao.updateById(homeOldman);
    }

    @Override
    @Transactional
    public void addOldman(HomeOldman homeOldman) {
        homeOldmanDao.save(homeOldman);
        Message message=new Message();
        message.setUserIds(userDao.getUserIdsByRole("admin"));
        message.setType(MessageTypeEnum.XT.getIndex());
        message.setContent("居家养老机构添加一条"+homeOldman.getNy()+"的老人数据。");
        messageDao.saveAllBySame(message);
//        oldmanDao.updateHomeOldStatusById(homeOldman.getOldmanId());
    }


    @Override
    public HomeOldmanAddInfo getAddInfo() {
        HomeOldmanAddInfo homeOldmanAddInfo=new HomeOldmanAddInfo();
        List<Organ> organList=organService.getALLNotInFirType(1);
        homeOldmanAddInfo.setOrganList(organList);
        List<Home> homeList=homeDao.getAll();
        homeList.forEach(s->s.setFirTypeDesc(HomeEnum.getValue(s.getFirType())));
        homeOldmanAddInfo.setHomeList(homeList);
        return homeOldmanAddInfo;
    }

    @Override
    public long getHomeOldmanOidSize() {
        return homeOldmanDao.getHomeOldmanOidSize(commonService.getPrevNy());
    }

    @Override
    public List<Integer> getHomeOldmanOidByRound(long round, long current) {
        return homeOldmanDao.getOidByRound(round,current,commonService.getPrevNy());
    }
}