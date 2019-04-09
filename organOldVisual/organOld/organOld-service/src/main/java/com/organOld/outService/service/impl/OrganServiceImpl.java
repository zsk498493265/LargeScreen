package com.organOld.outService.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.Message;
import com.organOld.dao.entity.SysUser;
import com.organOld.dao.entity.oldman.Linkman;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanHealth;
import com.organOld.dao.entity.organ.*;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.outService.contract.*;
import com.organOld.outService.enumModel.AutoValueEnum;
import com.organOld.outService.enumModel.ImportFailEnum;
import com.organOld.outService.enumModel.MessageTypeEnum;
import com.organOld.outService.enumModel.OrganFirEnum;
import com.organOld.outService.model.*;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.OldmanService;
import com.organOld.outService.service.OrganService;
import com.organOld.outService.service.UserService;
import com.organOld.outService.tool.Email;
import com.organOld.outService.tool.ImgUpload;
import com.organOld.outService.tool.Tool;
import com.organOld.outService.wrapper.OrganOldmanWrapper;
import com.organOld.outService.wrapper.OrganWrapper;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

import java.util.stream.Collectors;

@Service
public class OrganServiceImpl implements OrganService{

    @Autowired
    OrganDao organDao;
    @Autowired
    CommonService commonService;
    @Autowired
    OrganOldmanDao organOldmanDao;
    @Autowired
    UserService userService;
    @Autowired
    OrganRegDao organRegDao;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    OrganTypeDao organTypeDao;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    UserDao userDao;
    @Autowired
    OldmanKeyHandleDao oldmanKeyHandleDao;
    @Autowired
    OrganServiceRecordDao organServiceRecordDao;
    @Autowired
    OrganWrapper organWrapper;
    @Autowired
    OrganOldmanWrapper organOldmanWrapper;
    @Autowired
    OldmanService oldmanService;
    @Autowired
    CardDao cardDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    OldmanHealthDao oldmanHealthDao;
    @Autowired
    LinkmanDao linkmanDao;

    @Override
    public String getByPage(OrganRequest organRequest, BTableRequest bTableRequest) {
        Page<Organ> page=commonService.getPage(bTableRequest,"organ");
        Organ organ= organWrapper.unwrap(organRequest);
        page.setEntity(organ);
        List<OrganModel> organModelList=organDao.getByPage(page).stream().map(organWrapper::wrap).collect(Collectors.toList());
        Long size=organDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organModelList);
    }

    @Override
    public String getManByPage(BTableRequest bTableRequest, OrganOldmanRequest organOrganManRequest) {
        Page<OrganOldman> page=commonService.getPage(bTableRequest,"organ_man");
        OrganOldman organOldman= organOldmanWrapper.unwrap(organOrganManRequest);
        page.setEntity(organOldman);
        List<OrganOldmanModel> organOldmanModelList=organOldmanDao.getManByPage(page).stream().map(organOldmanWrapper::wrap).collect(Collectors.toList());
        Long size=organOldmanDao.getManSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,organOldmanModelList);
    }

    @Override
    public OrganModel getBySession(HttpSession httpSession) {
        Integer organId=commonService.getIdBySession();
        return getById(organId);
    }

    @Override
    public OrganModel getById(int organId) {
        OrganModel organModel=organWrapper.wrap(organDao.getById(organId));
        List<AutoValue> districtList=autoValueDao.getByType(AutoValueEnum.PQ.getIndex());
        organModel.setDistrictList(districtList);
        List<OrganType> organTypeList=organTypeDao.getByFirType(organModel.getOrganFirTypeId());
        organModel.setOrganTypeList(organTypeList);
        List<Organ> parentOrganList=organDao.getByType(33);//针对居委
        organModel.setParentOrganList(parentOrganList);
        return organModel;

    }

    @Override
    public OrganAddModel getAddInfo(int firType) {
        OrganAddModel organAddModel=new OrganAddModel();
        List<AutoValue> districtList=autoValueDao.getByType(AutoValueEnum.PQ.getIndex());
        organAddModel.setDistrictList(districtList);
        List<OrganType> organTypeList=organTypeDao.getByFirType(firType);
        organAddModel.setOrganTypeList(organTypeList);
        List<Organ> parentOrganList=organDao.getByType(33);//针对居委
        organAddModel.setParentOrganList(parentOrganList);
        organAddModel.setOrganTypeId(firType);
        return organAddModel;
    }

    @Override
    @Transactional
    public Result pass(int organId) {
        Organ organ=new Organ();
        organ.setId(organId);
        organ.setStatus("2");
        organDao.updateById(organ);

        return new Result(true);
    }

    @Override
    public void sendEmail(String type, Integer organId) {
        switch (type){
            case "pass":
                OrganReg organReg=organRegDao.getByOrganId(organId);
                SysUser user=newAccount(organId);
                String content=String.format("您的账号:%s<br>密码：%s",user.getUsername(),user.getPassword());
                Email.send(organReg.getEmail(),content);
                break;
            case "reject":
                OrganReg organReg2=organRegDao.getByOrganId(organId);
                String content2=String.format("抱歉您的审核未通过");
                Email.send(organReg2.getEmail(),content2);
                break;
            case "cancel":
                OrganReg organReg3=organRegDao.getByOrganId(organId);
                String content3 = String.format("抱歉您被撤销了");
                Email.send(organReg3.getEmail(), content3);
        }
    }

    @Override
    @Transactional
    public Result reject(int organId) {
        Organ organ=new Organ();
        organ.setId(organId);
        organ.setStatus("3");
        organDao.updateById(organ);
        return new Result(true);
    }

    @Override
    @Transactional
    public void cancel(int organId) {
        Organ organ=new Organ();
        organ.setId(organId);
        organ.setStatus("4");
        organDao.updateById(organ);

        userDao.setDisableByOrganId(organId);
    }

    /**
     * 为机构注册新账号
     * @param organId
     */
    @Transactional
    SysUser newAccount(int organId) {
        SysUser user=createUser(organId);
        userService.save(user);
        userService.setUserOrgan(user.getId(),organId);
        userService.setUserRole(user.getId(),9);
        return user;
    }

    private SysUser createUser(int organId) {
        SysUser sysUser=new SysUser();
        String username="Organ"+organId;
        String password="123456";
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        return sysUser;
    }

    @Override
    public List<Organ> getByType(int type) {
        return organDao.getSimpleByType(2,0);
    }

    @Override
    public OrganRegInfoModel getRegInfo() {
        OrganRegInfoModel organRegInfoModel=new OrganRegInfoModel();
        List<Integer> typeList=commonService.getAutoValueTypes("organ_reg");
        List<AutoValue> district=autoValueDao.getByTypeList(typeList);
        organRegInfoModel.setDistrict(district);
        organRegInfoModel.setOrganTypeList(organTypeDao.getByFirType(OrganFirEnum.SH.getIndex()));
        return organRegInfoModel;
    }

    @Override
    @Transactional
    public Result reg(OrganRegRequest organRegRequest, HttpServletRequest request) {
        Organ organ=organWrapper.unwrapRegOrgan(organRegRequest,request);
        organ.setStatus("1");
        OrganReg organReg=organWrapper.unwrapRegOrganReg(organRegRequest);
        organDao.save(organ);
        organReg.setOrganId(organ.getId());
        organRegDao.save(organReg);
        return new Result(true,"注册成功！请等待审核");
    }

    @Override
    public Integer addOrUpdate(OrganRegRequest organRegRequest, HttpServletRequest request, String type) {
        Organ organ=organWrapper.unwrapRegOrgan(organRegRequest,request);
        if(type.equals("update")) organDao.updateById(organ);
        else organDao.save(organ);
        return organ.getId();
    }

    @Override
    public Result getRoleOrgan(int type, int typeIndex) {
        return new Result(true,organDao.getRoleOrgan(type,typeIndex));
    }

    @Override
    public List<OrganType> getAllOldmanType() {
        return organTypeDao.getAllOldmanType();
    }


    @Override
    public List<OrganType> getByFirType(int firType) {
        return organTypeDao.getByFirType(firType);
    }


    @Override
    public List<Organ> getByOrganFirType(int firType) {
        return organDao.getByFirType(firType);
    }

    @Override
    public Result importExcel(MultipartFile file, int type, HttpServletRequest request) throws IOException {
        List<Organ> organList=new ArrayList<>();
        String  fix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        Workbook wb0;
        if(fix.equals("xls"))
            wb0= new HSSFWorkbook(file.getInputStream());
        else
            wb0=new XSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        int start=0;
        if(type==21 || type==22){
            start=2;
        }else{
            start=1;
        }


        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successAdd=0;//导入数量中  增加的个数

        //得到所有的图片  一个机构一张图片  key是行号
        Map<Integer, PictureData> sheetIndexPicMap;
        if(fix.equals("xls"))
            sheetIndexPicMap = getSheetPictrues03XLS( (HSSFSheet) sht0, (HSSFWorkbook) wb0);
        else
            sheetIndexPicMap = getPicturesXlsx( (XSSFSheet) sht0);

        Map<Integer,String> picPath= ImgUpload.excelImg(sheetIndexPicMap,request,"organ");


        for (Row r : sht0) {
            try {
                if (r.getRowNum() >= start) {
                    //遍历 cell  将单元格 格式 全都转换成String 类型
                    Iterator<Cell> cells = r.cellIterator();    //获得第一行的迭代器
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    //创建实体类
                    Organ organ=new Organ();
                    if(type==21 || type==22) {
                        if (commonService.excelIsNotNull(r.getCell(0))) {
                            organ.setName(r.getCell(0).getStringCellValue());
                        }else{
                            continue;
                        }
                        if (commonService.excelIsNotNull(r.getCell(1))) {
                            organ.setIntro(r.getCell(1).getStringCellValue());
                        }
                        r.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        if (commonService.excelIsNotNull(r.getCell(2))) {
                            organ.setNum(Integer.parseInt(r.getCell(2).getStringCellValue()));
                        }
                        if (commonService.excelIsNotNull(r.getCell(3))) {
                            organ.setWork(r.getCell(3).getStringCellValue());
                        }
                        if (commonService.excelIsNotNull(r.getCell(4))) {
                            organ.setInstitution(r.getCell(4).getStringCellValue());
                        }
                        if (commonService.excelIsNotNull(r.getCell(5))) {
                            organ.setRequire(r.getCell(5).getStringCellValue());
                        }
                        if (commonService.excelIsNotNull(r.getCell(6))) {
                            organ.setServiceTime(r.getCell(6).getStringCellValue());
                        }
                        if (commonService.excelIsNotNull(r.getCell(7))) {
                            organ.setAddress(r.getCell(7).getStringCellValue());
                        }
                        r.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
                        if (commonService.excelIsNotNull(r.getCell(8))) {
                            organ.setPhone(r.getCell(8).getStringCellValue());
                        }
                        if (commonService.excelIsNotNull(r.getCell(9))) {
                            organ.setWebUrl(r.getCell(9).getStringCellValue());
                        }


                        int total = 0; //1养老院  2长者  3 日照  4日托  8为助餐点
                        if (commonService.excelIsNotNullOne(r.getCell(11))) {
                            total += 1;
                        }
                        if (commonService.excelIsNotNullOne(r.getCell(12))) {
                            total += 2;
                        }
                        if (commonService.excelIsNotNullOne(r.getCell(13))) {
                            total += 3;
                        }
                        if (commonService.excelIsNotNullOne(r.getCell(14))) {
                            total += 4;
                        }
                        if (commonService.excelIsNotNullOne(r.getCell(15))) {
                            total += 8;
                        }
                        switch (total) {
                            case 1:
                                organ.setOrganTypeId(26);
                                break;
                            case 2:
                                organ.setOrganTypeId(27);
                                break;
                            case 3:
                                organ.setOrganTypeId(28);
                                break;
                            case 8:
                                organ.setOrganTypeId(26);
                                break;
                            case 5:
                                organ.setOrganTypeId(34);
                                break;
                            case 4:
                                organ.setOrganTypeId(35);
                                break;
                        }
                    }else if(type==1){
                        if (r.getCell(1).getStringCellValue() != null && !r.getCell(1).getStringCellValue().equals("")) {
                            organ.setName(r.getCell(1).getStringCellValue());
                        }else{
                            continue;
                        }
                        if (r.getCell(2).getStringCellValue() != null && !r.getCell(2).getStringCellValue().equals("")) {
                            organ.setIntro(r.getCell(2).getStringCellValue());
                        }

                        if (r.getCell(3).getStringCellValue() != null && !r.getCell(3).getStringCellValue().equals("")) {
                            organ.setWork(r.getCell(3).getStringCellValue());
                        }
                        if (r.getCell(4).getStringCellValue() != null && !r.getCell(4).getStringCellValue().equals("")) {
                            organ.setServiceTime(r.getCell(4).getStringCellValue());
                        }
                        if (r.getCell(5).getStringCellValue() != null && !r.getCell(5).getStringCellValue().equals("")) {
                            organ.setAddress(r.getCell(5).getStringCellValue());
                        }
                        r.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                        if (r.getCell(6).getStringCellValue() != null && !r.getCell(6).getStringCellValue().equals("")) {
                            organ.setPhone(r.getCell(6).getStringCellValue());
                        }
                        if (r.getCell(7).getStringCellValue() != null && !r.getCell(7).getStringCellValue().equals("")) {
                            organ.setWebUrl(r.getCell(7).getStringCellValue());
                        }
                        organ.setOrganTypeId((int) r.getCell(9).getNumericCellValue());
                    }
                    organ.setImgUrl(picPath.get(r.getRowNum()));
                    organList.add(organ);
                    numSuccess++;
                    successAdd++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                excelReturnModel.getFail().add(r.getRowNum() + 1);
            }
        }
        excelReturnModel.setNumFail(excelReturnModel.getFail().size());
        excelReturnModel.setSuccessAdd(successAdd);
        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setTotal(numSuccess+excelReturnModel.getNumFail());//一共
        organDao.saveAll(organList);
        return new Result(true,excelReturnModel);
    }



    public static Map<Integer, PictureData> getSheetPictrues03XLS(HSSFSheet sheet, HSSFWorkbook workbook) {

        Map<Integer, PictureData> sheetIndexPicMap = new HashMap<Integer, PictureData>();
        List<HSSFPictureData> pictures = workbook.getAllPictures();
        if (pictures.size() != 0) {
            for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren()) {
                HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();
                if (shape instanceof HSSFPicture) {
                    HSSFPicture pic = (HSSFPicture) shape;
                    int pictureIndex = pic.getPictureIndex() - 1;
                    HSSFPictureData picData = pictures.get(pictureIndex);
                    int picIndex = anchor.getRow1();
                    sheetIndexPicMap.put(picIndex, picData);
                }
            }
            return sheetIndexPicMap;
        } else {
            return null;
        }
    }

    public static Map<Integer, PictureData> getPicturesXlsx (XSSFSheet sheet) throws IOException {
        Map<Integer, PictureData> map = new HashMap();
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture picture = (XSSFPicture) shape;
                    XSSFClientAnchor anchor = picture.getPreferredSize();
                    CTMarker marker = anchor.getFrom();
                    Integer row= marker.getRow();
                    map.put(row, picture.getPictureData());
                }
            }
        }
        return map;
    }


    @Override
    @Transactional
    public Result importManExcel(MultipartFile file,String ny,String type) throws IOException {
        List<OrganOldman> organOldmanList=new ArrayList<>();

        String  fix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        Workbook wb0;
        if(fix.equals("xls"))
            wb0= new HSSFWorkbook(file.getInputStream());
        else
            wb0=new XSSFWorkbook(file.getInputStream());
//        Workbook wb0 = new HSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        //TODO
        Sheet sht0 = wb0.getSheetAt(0);
        int start=1;

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successAdd=0;//导入数量中  增加的个数
        int noexistOldman=0;
        int numFail=0;
        Integer organId=commonService.getIdBySession();

        Map<String,Oldman> existOldmanMap=oldmanService.getAllOldman();
        List<Oldman> oldmanList_add=new ArrayList<>();//用于将不在数据库的老人存到老人表中，只有姓名和身份证号码
        Map<String,Oldman> oldmanList_add_map=new HashMap<>();//新增老人
        Set<String> addPids=new HashSet<>();//防止 同时添加 身份证号一样的老人

        for (Row r : sht0) {
            try {
                if (r.getRowNum() >= start) {

                    Iterator<Cell> cells = r.cellIterator();    //获得第一行的迭代器
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }

                    //创建实体类
                    OrganOldman organOldman=new OrganOldman();
                    organOldman.setOrganId(organId);
                    organOldman.setNy(ny);


                        if (commonService.excelIsNotNull(r.getCell(1))) {
                        }else{
                            continue;
                        }

                    if(addPids.contains(Tool.trim(r.getCell(2).getStringCellValue()))){
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
                        addPids.add(r.getCell(2).getStringCellValue());
                    }

                        if (commonService.excelIsNotNull(r.getCell(2))) {
                            Oldman existOldman=existOldmanMap.get(Tool.trim(r.getCell(2).getStringCellValue()));
//                            Integer oldmanId=commonService.checkOldmanExiest(r.getCell(2).getStringCellValue());
                            if(existOldman!=null){
//                                if(oldStatus==2) {
//                                    //社区养老
//                                    switch (existOldman.getOldStatus()) {
//                                        case 3:
//                                        case 4:
//                                            //之前是居家养老 或者社区居家
//                                            oldStatus = OldStatusEnum.SJ.getIndex();
//                                            break;
//                                    }
//                                }
                                Oldman oldman=new Oldman();
                                oldman.setId(existOldman.getId());
                                oldman.setPid(r.getCell(2).getStringCellValue());
//                                oldman.setIsHandle(2);
                                if (commonService.excelIsNotNull(r.getCell(5)) && r.getCell(5).getStringCellValue().equals("0")){
                                    //排队的  保持以前的养老状态
                                    organOldman.setNum(r.getCell(5).getStringCellValue());
//                                    oldman.setOldStatus(existOldman.getOldStatus());
                                    if (commonService.excelIsNotNull(r.getCell(6))){
                                        organOldman.setApplyTime(Tool.stringToDate(r.getCell(6).getStringCellValue()));
                                    }
                                    oldman.setIsHandle(existOldman.getIsHandle());
                                }else if(commonService.excelIsNotNull(r.getCell(5)) && !r.getCell(5).getStringCellValue().equals("0")){
//                                    oldman.setOldStatus(oldStatus);
                                    organOldman.setNum(r.getCell(5).getStringCellValue());
                                }

//                                if(organExistOldman.contains(oldman)){
//                                    organExistOldman.remove(oldman);
//                                }
//                                oldmanList.add(oldman);
                                organOldman.setOldman(oldman);
                            }else{
                                //该老人  不在当前数据库中
                                Oldman oldman=new Oldman();
                                oldman.setPid(r.getCell(2).getStringCellValue());
                                oldman.setName(r.getCell(1).getStringCellValue());
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
                                organOldman.setOldman(oldman);
                                if(commonService.excelIsNotNull(r.getCell(5))){
                                    organOldman.setNum(r.getCell(5).getStringCellValue());
                                }
                                if (commonService.excelIsNotNull(r.getCell(6))){
                                    organOldman.setApplyTime(Tool.stringToDate(r.getCell(6).getStringCellValue()));
                                }
                                noexistOldman++;
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

                        if (commonService.excelIsNotNull(r.getCell(3))) {
                            organOldman.setTimeIn(Tool.stringToDate(r.getCell(3).getStringCellValue()));
                        }
                        if (commonService.excelIsNotNull(r.getCell(4))) {
                            organOldman.setTimeOut(Tool.stringToDate(r.getCell(4).getStringCellValue()));
                        }

                    organOldmanList.add(organOldman);
                    numSuccess++;
                    successAdd++;
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
        excelReturnModel.setSuccessAdd(successAdd);
        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setNoexistOldman(noexistOldman);
        excelReturnModel.setTotal(numSuccess+excelReturnModel.getNumFail());//一共
        //该机构 删除的老人 的养老状态   之前是机构养老 则变为0 之前是社区养老的 看看之前的养老状态是不是居家社区 看看有没有在其他的社区养老机构
//        for(Oldman oldman:organExistOldman){
//            if(organ.getOrganFirTypeId()==21){
//                oldman.setOldStatus(0);
//                oldman.setIsHandle(0);
//            }else{
//                int orgNum=organOldmanDao.getNumByOldmanId(oldman.getId());
//                if(orgNum==1){
//                    没有其他家 社区机构
//                    if(oldman.getOldStatus()==4){
//                        之前是 社区居家
//                        oldman.setOldStatus(3);
//                        oldman.setIsHandle(2);
//                    }else if(oldman.getOldStatus()==2){
//                        oldman.setOldStatus(0);
//                        oldman.setIsHandle(0);
//                    }
//                }
//            }
//        }

        if(type.equals("update")){
            //某个年月的 更新  则进行覆盖 把之前的删掉
            OrganOldman organOldman=new OrganOldman();
            organOldman.setNy(ny);
            organOldman.setOrganId(organId);
            organOldmanDao.delByOrganOldman(organOldman);
        }

        List<Card> cardList_add=new ArrayList<>();
        if(oldmanList_add.size()>0) {
            List<Integer> oldmanIds_health=new ArrayList<>();
            List<Integer> oldmanIds_linkman=new ArrayList<>();

            oldmanDao.saveAllNoExist(oldmanList_add);
            for(Oldman oldman:oldmanList_add){
                Card card=new Card();
                card.setOldmanId(oldman.getId());
                card.setCid(oldman.getPid());
                card.setPassword("123456");
                cardList_add.add(card);

                oldmanIds_health.add(oldman.getId());
                oldmanIds_linkman.add(oldman.getId());
            }
            oldmanHealthDao.saveAllOldmanIds(oldmanIds_health);//添加老人时 同时添加应急联系人和 健康基础信息
            linkmanDao.saveAllOldmanIds(oldmanIds_linkman);
        }
        if(cardList_add.size()>0)
            cardDao.saveAll(cardList_add);

        /**
         * 不进行 老人状态更新
         */
//        organOldmanDao.delByOrganId(organId);
        if(organOldmanList.size()>0){
            // 老人基本信息表  养老状态更新
//            organExistOldman.addAll(oldmanList);//删除的老人 和 更新的 一起更新养老状态
//            oldmanDao.updateOrganExceLImportByIds(organExistOldman);
            organOldmanDao.saveAll(organOldmanList);
//            oldmanKeyHandleDao.delByOldman(oldmanList);
        }
        Organ organ=organDao.getById(organId);
        Message message=new Message();
        message.setUserIds(userDao.getUserIdsByRole("admin"));
        message.setType(MessageTypeEnum.XT.getIndex());
        message.setContent(organ.getName()+" 导入"+ny+"的老人数据，"+"共"+excelReturnModel.getNumSuccess()+"人，空余床位数："+(organ.getNum()-organOldmanDao.getNySizeNoPd(ny,organId)));
        messageDao.saveAllBySame(message);
        return new Result(true,excelReturnModel);
    }




    @Override
    public Boolean checkHaveAuthByAuthType(int type, Integer organId) {
        if(organId==null || organId==0){
            organId=commonService.getIdBySession();
        }
        if(organId==null || organId==0){
            return true;
        }
        Organ organ=organDao.getAuthById(organId);
        switch (type){
            case 1:if(organ.getAuthConsume()==1) return true;break;
            case 2:if(organ.getAuthSign()==1) return true;break;
            case 3:if(organ.getAuthQueryInfo()==1) return true;break;
            case 4:if(organ.getAuthQueryIntegral()==1) return true;break;
            case 5:if(organ.getAuthProduct()==1) return true;break;
        }
        return false;
    }

    @Override
    public String getRecordByPage(OrganServiceRecordRequest organServiceRecordRequest, BTableRequest bTableRequest) {
        Page<OrganServiceRecord> page=commonService.getPage(bTableRequest,"organ_service_record");
        OrganServiceRecord organServiceRecord= organWrapper.unwrapServiceRecord(organServiceRecordRequest);
        if(organServiceRecord.getOrganId()==null || organServiceRecord.getOrganId()==0){
            //机构账号页面
            commonService.checkIsOrgan(organServiceRecord);
        }
        page.setEntity(organServiceRecord);
        List<OrganServiceRecordModel> productModelList=organServiceRecordDao.getByPage(page).stream().map(organWrapper::wrapServiceRecord).collect(Collectors.toList());
        Long size=organServiceRecordDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,productModelList);
    }


    @Override
    public Result importRecordExcel(MultipartFile file) throws IOException {
        List<OrganServiceRecord> organServiceRecordList=new ArrayList<>();
        Workbook wb0 = new HSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        int start=1;

        ExcelReturnModel excelReturnModel=new ExcelReturnModel();
        int numSuccess=0;//成功导入的数量
        int successAdd=0;//导入数量中  增加的个数

        Integer organId=commonService.getIdBySession();

        for (Row r : sht0) {
            try {
                if (r.getRowNum() >= start) {
                    //创建实体类
                    OrganServiceRecord organServiceRecord=new OrganServiceRecord();
                    organServiceRecord.setOrganId(organId);

                    if (r.getCell(1).getStringCellValue() != null && !r.getCell(1).getStringCellValue().equals("")) {
                        Integer oldmanId=commonService.checkOldmanExiest(r.getCell(1).getStringCellValue());
                        if(oldmanId!=null && oldmanId!=0){
                            organServiceRecord.setOldmanId(oldmanId);
                        }else{
                            throw new Exception();
                        }
                    }else{
                        throw new Exception();
                    }

                    if (r.getCell(12).getStringCellValue() != null && !r.getCell(2).getStringCellValue().equals("")) {
                        organServiceRecord.setData(r.getCell(2).getStringCellValue());
                    }
                    if (r.getCell(3).getStringCellValue() != null && !r.getCell(3).getStringCellValue().equals("")) {
                        organServiceRecord.setTime(Tool.stringToDate(r.getCell(3).getStringCellValue()));
                    }
                    if (r.getCell(4).getStringCellValue() != null && !r.getCell(4).getStringCellValue().equals("")) {
                        organServiceRecord.setOrder(r.getCell(4).getStringCellValue());
                    }
                    organServiceRecordList.add(organServiceRecord);
                    numSuccess++;
                    successAdd++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                excelReturnModel.getFail().add(r.getRowNum() + 1);
            }
        }
        excelReturnModel.setNumFail(excelReturnModel.getFail().size());
        excelReturnModel.setSuccessAdd(successAdd);
        excelReturnModel.setNumSuccess(numSuccess);
        excelReturnModel.setTotal(numSuccess+excelReturnModel.getNumFail());//一共
        if(organServiceRecordList.size()>0){
            organServiceRecordDao.saveAll(organServiceRecordList);
        }
        return new Result(true,excelReturnModel);
    }


    @Override
    @Transactional
    public void delByIds(String[] ids) {
        organDao.updateProps("disable","1",ids);
        organOldmanDao.delByOrganIds(ids);
        String[] userIds=userDao.getIdByOrganIds(ids);
        if(userIds!=null && userIds.length>0)
        userDao.updateProps("disable","1",userIds);
    }

    @Override
    public List<Organ> getAll() {
        return organDao.getAll();
    }

    @Override
    @Transactional
    public void addOldman(OrganOldman organOldman) {
        Integer organId=commonService.getIdBySession();
        organOldman.setOrganId(organId);
        organOldmanDao.delByNyOldmanId(organOldman);
        organOldmanDao.save(organOldman);

            Organ organ = organDao.getById(organId);
            Message message = new Message();
            message.setUserIds(userDao.getUserIdsByRole("admin"));
            message.setType(MessageTypeEnum.XT.getIndex());
            message.setContent(organ.getName() + "添加一条" + organOldman.getNy() + "的老人数据，该月份空余床位数：" + (organ.getNum() - organOldmanDao.getNySizeNoPd(organOldman.getNy(),organId)));
            messageDao.saveAllBySame(message);
        /**
         * 先不改变 养老状态  统一同 更新养老状态操作
         */

        //不是排队
//        if(!organOldman.getNum().equals("0")) {
//            oldmanDao.updateProp("is_handle", "2", organOldman.getOldmanId());
//            Integer firType = organTypeDao.getFirTypeByOrganId(organId);
//            if (firType == 21) {
////            机构养老
//                oldmanDao.updateProp("old_status", "1", organOldman.getOldmanId());
//            } else {
//                //社区养老
//                oldmanDao.updateCommunityOldmanStatusById(organOldman.getOldmanId());
//            }
//        }
    }

    @Override
    public OrganOldman getOldmanById(Integer id) {
        return organOldmanDao.getById(id);
    }

    @Override
    public void updateOldman(OrganOldman organOldman) {
//        Integer organId=commonService.getIdBySession();
        organOldmanDao.updateById(organOldman);
    }

    @Override
    @Transactional
    public void delByOldmanIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        List<OrganOldman> delOldman=organOldmanDao.getDelOldmanIdsByOrganOldmanIds(id);

        String[] delOldmanIdsNoPd=new String[delOldman.size()];//非排队的
        int i=0;
        for(OrganOldman organOldman:delOldman){
            if(organOldman.getNum()!=null && !organOldman.getNum().equals("0"))
                delOldmanIdsNoPd[i++]=organOldman.getOldmanId()+"";
        }
        organOldmanDao.delByIds(id);
        Integer organId = commonService.getIdBySession();
        if(delOldmanIdsNoPd[0]!=null && !delOldmanIdsNoPd[0].equals("")) {

            Integer firType = organTypeDao.getFirTypeByOrganId(organId);

            if (firType == 21) {
//            机构养老
                oldmanDao.updateProps("old_status", "0", delOldmanIdsNoPd);
                oldmanDao.updateProps("is_handle", "0", delOldmanIdsNoPd);
            } else {
                //社区养老
                oldmanDao.delCommunityOldmanStatusByIds(delOldmanIdsNoPd);
            }
        }

        Organ organ = organDao.getById(commonService.getIdBySession());
        Set<String> nyy=new HashSet<>();
        for(OrganOldman organOldman:delOldman){
            nyy.add(organOldman.getNy());
        }
        Message message = new Message();
        message.setUserIds(userDao.getUserIdsByRole("admin"));
        message.setType(MessageTypeEnum.XT.getIndex());
        message.setContent(organ.getName() + "删除"+ids.length+"条数据，床位空余情况:<br>");
        for(String s:nyy){
            message.setContent(message.getContent()+s+"："+(organ.getNum()-organOldmanDao.getNySizeNoPd(s,organId))+"<br>");
        }
        messageDao.saveAllBySame(message);

    }

    @Override
    public Integer getIdByName(String name) {
        return organDao.getIdByName(name);
    }

    @Override
    public List<Organ> getALLNotInFirType(int firType) {
        return organDao.getALLNotInFirType(firType);
    }

    @Override
    public Map<String, Long> getOrganNum() {
        return organDao.getOrganNum();
    }

    @Override
    public Long getNumByType(int type) {
        Integer organId=commonService.getIdBySession();
        return organDao.getNumByType(type,organId);
    }

    @Override
    public Long getSize() {
        return organDao.getAllSize();
    }


    @Override
    public long getOrganOldmanOidSize() {
        return organOldmanDao.getOrganOldmanOidSize(commonService.getPrevNy());
    }

    @Override
    public List<OrganOldman> getOrganOldmanOidByRound(long round, long current) {
        return organOldmanDao.getOrganOldmanOidByRound(round,current,commonService.getPrevNy());
    }

    @Override
    public List<Organ> getOrganTypeMap() {
        return organDao.getOrganTypeMap();
    }

    @Override
    public Map<String, Long> getOrganBedNum() {
        Integer organId=commonService.getIdBySession();
        if(organId==null || organId==0)
            return null;
        return organDao.getOrganBedNumById(organId);
    }

    @Override
    public Map<String, Long> getOrganOldmanHisNum() {
        Integer organId=commonService.getIdBySession();
        if(organId==null || organId==0)
            return null;
        List<String> prevs=commonService.getPrevNys(6);
        return organOldmanDao.getOrganOldmanHisNum(organId,prevs);
    }

    @Override
    public Map<String, Long> getOrganOldmanNum() {
        Integer organId=commonService.getIdBySession();
        if(organId==null || organId==0)
            return null;
        return organOldmanDao.getOrganOldmanNum(commonService.getPrevNy(),organId);
    }

    @Override
    public String getProp(String prop, int organId) {
        return organDao.getProp(prop,organId);
    }

    @Override
    public Long getOldmanSize() {
        return organDao.getOldmanSize();
    }

    @Override
    public Result getJwByPqIds(String[] pqIds) {
        return new Result(true,organDao.getJwByPqIds(pqIds));
    }

    @Override
    public String[] getJwIdsByPqIds(String[] pqIds) {
        return organDao.getJwIdsByPqIds(pqIds);
    }

    @Override
    public List<Organ> getOrganByAuthType(int type) {
        String auth="";
        switch (type){
            case 2:
                auth="auth_sign";
                break;
            case 3:
                auth="auth_query_info";
                break;
            case 4:
                auth="auth_query_integral";
                break;
        }
        if (!auth.equals(""))
            return organDao.getByAuthType(auth);
        else
            return null;
    }

    @Override
    public Integer getPeopleNumByPqId() {
        return organDao.getPeopleNumByPqId(commonService.getIdBySession());
    }

    @Override
    public Integer getPeopleNum() {
        return organDao.getPeopleNum();
    }

    @Override
    public Organ getByUserName(String userNameBySession) {
        return organDao.getByUsername(userNameBySession);
    }
}
