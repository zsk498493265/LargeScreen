package com.organOld.outService.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.home.Chx;
import com.organOld.dao.entity.label.*;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.outService.constant.TimeConstant;
import com.organOld.outService.dwr.Remote;
import com.organOld.outService.enumModel.AutoValueEnum;
import com.organOld.outService.model.*;
import com.organOld.outService.service.AutoValueService;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.LabelService;
import com.organOld.outService.tool.ExcelUtil;
import com.organOld.outService.tool.Tool;
import com.organOld.outService.wrapper.LabelManWrapper;
import com.organOld.outService.wrapper.LabelWrapper;
import com.organOld.outService.wrapper.OldmanWrapper;
import com.organOld.outService.contract.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by netlab606 on 2018/6/7.
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    CommonService commonService;
    @Autowired
    LabelDao labelDao;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    OrganDao organDao;
    @Autowired
    ChxDao chxDao;
    @Autowired
    LabelManDao labelManDao;
    @Autowired
    LabelFeedbackDao labelFeedbackDao;
    @Autowired
    LabelSecDao labelSecDao;
    @Autowired
    LabelWrapper labelWrapper;
    @Autowired
    LabelManWrapper labelManWrapper;
    @Autowired
    OldmanWrapper oldmanWrapper;
    @Autowired
    AutoValueService autoValueService;

    @Override
    public String getByPage(LabelRequest labelRequest, BTableRequest bTableRequest) {
        Page<Label> page=commonService.getPage(bTableRequest,"label");
        Label label= labelWrapper.unwrap(labelRequest);
        commonService.checkIsOrgan(label);
        page.setEntity(label);
        List<LabelModel> labelList=labelDao.getByPage(page).stream().map(labelWrapper::wrap).collect(Collectors.toList());
        Long size=labelDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,labelList);
    }

    @Override
    public String getTypeByPage(int index, LabelTypeRequest labelTypeRequest, BTableRequest bTableRequest) {
        if(index==1){
            List<AutoValue> autoValueList=autoValueDao.getByType(AutoValueEnum.YJBQ.getIndex());
            autoValueList.forEach(s->s.setTimeFormat(Tool.dateToString(s.getTime(), TimeConstant.DATA_FORMAT_YMD)));
            Long size=(long)autoValueList.size();
            return commonService.tableReturn(bTableRequest.getsEcho(),size,autoValueList);
        }else{
            Page<LabelSec> page=commonService.getPage(bTableRequest,"label_type");
            LabelSec labelSec=labelWrapper.unwrapType(labelTypeRequest);
            page.setEntity(labelSec);
            List<LabelSecModel> labelList=labelSecDao.getByPage(page).stream().map(labelWrapper::wrapType).collect(Collectors.toList());
            Long size=labelSecDao.getSizeByPage(page);
            return commonService.tableReturn(bTableRequest.getsEcho(),size,labelList);
        }
    }

    @Override
    public String getBindManByPage(LabelManRequest labelManRequest, BTableRequest bTableRequest) {
        Page<LabelMan> page=commonService.getPage(bTableRequest,"label_man");
        LabelMan labelMan=labelManWrapper.unwrap(labelManRequest);
        commonService.fillXq(labelManRequest,labelMan);
        page.setEntity(labelMan);
        List<LabelManModel> labelManModelList= labelDao.getBindManByPage(page).stream().map(labelManWrapper::wrap).collect(Collectors.toList());
        Long size=labelDao.getBindManSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,labelManModelList);
    }

    private LabelRuleToDBSelectMan getLabelRuleToDB(LabelRule labelRule) {
        LabelRuleToDBSelectMan labelRuleToDB=new LabelRuleToDBSelectMan();
        if(labelRule.getAgeEnd()!=0 )
            labelRuleToDB.setBirStart(commonService.AgeTobirthday(labelRule.getAgeEnd()+1));
        if (labelRule.getAgeStart()!=0)
            labelRuleToDB.setBirEnd(commonService.AgeTobirthday(labelRule.getAgeStart()));
        if(!StringUtils.isEmpty(labelRule.getCensuses()))
            labelRuleToDB.setCensuses(Arrays.asList(labelRule.getCensuses().split("#")));
        List<Integer> xqIds=new ArrayList<>();
        if(!StringUtils.isEmpty(labelRule.getJwIds())){
            xqIds=autoValueService.getXqIdsByJwIds(labelRule.getJwIds().split("#"));
        }else if(!StringUtils.isEmpty(labelRule.getDistrictIds())){
            xqIds=autoValueService.getXqIdsByPqIds(labelRule.getDistrictIds().split("#"));
        }
        if(xqIds.size()>0){
            labelRuleToDB.setXqIds(xqIds);
        }
        if(!StringUtils.isEmpty(labelRule.getEyesights()))
            labelRuleToDB.setEyesights(Arrays.asList(labelRule.getEyesights().split("#")));
        if(!StringUtils.isEmpty(labelRule.getIntelligences()))
            labelRuleToDB.setIntelligences(Arrays.asList(labelRule.getIntelligences().split("#")));
        if(!StringUtils.isEmpty(labelRule.getPoliticalStatuses()))
            labelRuleToDB.setPoliticalStatuses(Arrays.asList(labelRule.getPoliticalStatuses().split("#")));
        if(!StringUtils.isEmpty(labelRule.getEconomics()))
            labelRuleToDB.setEconomics(Arrays.asList(labelRule.getEconomics().split("#")));
        if(!StringUtils.isEmpty(labelRule.getFamilies()))
            labelRuleToDB.setFamilies(Arrays.asList(labelRule.getFamilies().split("#")));
        if(!StringUtils.isEmpty(labelRule.getFamilyTypes()))
            labelRuleToDB.setFamilyTypes(Arrays.asList(labelRule.getFamilyTypes().split("#")));
        if(!StringUtils.isEmpty(labelRule.getIsHealths()))
            labelRuleToDB.setIsHealths(Arrays.asList(labelRule.getIsHealths().split("#")));
        if(!StringUtils.isEmpty(labelRule.getOldStatuses()))
            labelRuleToDB.setOldStatuses(Arrays.asList(labelRule.getOldStatuses().split("#")));
        if(!StringUtils.isEmpty(labelRule.getChxs()))
            labelRuleToDB.setChxs(Arrays.asList(labelRule.getChxs().split("#")));
        if(!StringUtils.isEmpty(labelRule.getZcs()))
            labelRuleToDB.setZcs(Arrays.asList(labelRule.getZcs().split("#")));
        if(!StringUtils.isEmpty(labelRule.getSqzws()))
            labelRuleToDB.setSqzws(Arrays.asList(labelRule.getSqzws().split("#")));
        labelRuleToDB.setSex(labelRule.getSex());
        labelRuleToDB.setIsKey(labelRule.getIsKey());
        return labelRuleToDB;
    }

    @Override
    public String getNoSelectManDataByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest, int labelId) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_base");
        Oldman oldman=oldmanWrapper.unwrap(oldmanRequest);
        commonService.fillXq(oldmanRequest,oldman);
        page.setEntity(oldman);
        List<OldmanModel> oldmanModelList=labelDao.getNoSelectManDataByPage(page,labelId).stream().map(oldmanWrapper::wrap).collect(Collectors.toList());
        Long size=labelDao.getNoSelectManDataSizeByPage(page,labelId);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanModelList);
    }

    @Override
    public LabelAllRuleModel getLabelRule() {
        List<Integer> typeList=commonService.getAutoValueTypes("label");
        List<AutoValue> autoValueList=autoValueDao.getByTypeList(typeList);
        Integer organId=commonService.getIdBySession();
        List<Organ> jwList=organDao.getSimpleByType(2, organId);

        List<Chx> chxList=chxDao.getSimple();

        LabelAllRuleModel labelRuleModel=labelWrapper.wrapLabelRule(autoValueList,jwList,chxList);

        return labelRuleModel;
    }

    @Override
    public LabelRuleModel getLabelRuleById(int labelId) {
        return labelWrapper.wrapSingleRule(labelDao.getLabelRuleByLid(labelId));
    }

    @Override
    @Transactional
    public void saveRule(LabelRuleRequest labelRuleRequest) {
        LabelRule labelRule=labelWrapper.unwrapLabelRule(labelRuleRequest);
        labelDao.saveLabelRule(labelRule);
//        LabelRule labelRule=labelDao.getLabelRuleByLid(labelId);
        labelDao.deleteLableManByLabelId(labelRule.getLabelId());
        LabelRuleToDBSelectMan labelRuleToDB=getLabelRuleToDB(labelRule);
        List<LabelMan> labelManList= labelDao.getRuleManIds(labelRuleToDB);
        if(labelManList.size()>0) {
            labelManList.stream().forEach(r -> r.setLabelId(labelRule.getLabelId()));
            labelManDao.saveAll(labelManList);
        }
        labelFeedbackDao.deleteByLabelId(labelRule.getLabelId());

        //通知 居委
        Label label=labelDao.getById(labelRule.getLabelId());

        String labelName=label.getName().replaceAll("\\s*", "");
        String content="您有新的规则制定标签："+label.getName()+"" +
                "<br>有效时间："+Tool.dateToString(label.getStart(),TimeConstant.DATA_FORMAT_YMD)+"-"+Tool.dateToString(label.getEnd(),TimeConstant.DATA_FORMAT_YMD)+"" +
                "<br><button class='btn btn-primary' onclick=newPage("+label.getId()+",'"+labelName+"','/oldman/label/rule/"+label.getId()+"/man')>查看人员</button>";
        commonService.informJwAndPq(content);

    }



    @Override
    public Result getByOldmanId(int oldmanId) {
        List<LabelManInfoModel> labels=labelDao.getManLabelByOldmanId(oldmanId).stream().map(labelWrapper::wrapManInfo).collect(Collectors.toList());

        //规则制定标签
//        List<LabelRule> labelRuleList=labelDao.getLabelRules();
//        for(LabelRule labelRule:labelRuleList){
//            LabelRuleToDBSelectMan labelRuleToDB=getLabelRuleToDB(labelRule);
//            List<Integer> oldmanIdList = labelDao.getRuleManIds(labelRuleToDB);
//            if(oldmanIdList.contains(oldmanId)){
//                labelNames.add(labelDao.getLabelNameByLabelRuleId(labelRule.getId()));
//            }
//        }

        return new Result(true,labels);
    }

    /**
     * 如果是人员绑定标签 则直接通知  居委会
     * 如果是规则制定标签  则提交规则时再通知 居委会
     * @param label
     */
    @Override
    @Transactional
    public void save(Label label) {
        label.setOrganId(0);
        commonService.checkIsOrgan(label);
        labelDao.save(label);
        if(label.getType()==2){
            //规则制定
            labelDao.addLabelRule(label.getId());
        }else{
            //人员绑定
            String labelName=label.getName().replaceAll("\\s*", "");
            String content="您有新的人员绑定标签："+label.getName()+"" +
                    "<br>有效时间："+Tool.dateToString(label.getStart(),TimeConstant.DATA_FORMAT_YMD)+"-"+Tool.dateToString(label.getEnd(),TimeConstant.DATA_FORMAT_YMD)+"" +
                    "<br><button class='btn btn-primary' onclick=newPage("+label.getId()+",'"+labelName+"','/oldman/label/bind/"+label.getId()+"/man')>查看人员</button>";
            commonService.informJwAndPq(content);
        }
    }

    @Override
    public Result saveLabelMan(int labelId, int[] oldmanIds) {
        Result result;
        labelDao.saveLabelMan(labelId,oldmanIds);
        result=new Result(true);
        return result;
    }

    @Override
    public Result implement(LabelMan labelMan) {
        Result result;
        labelManDao.implement(labelMan);
        result=new Result(true);
        return result;
    }

    @Override
    public String getFeedbackByPage(LabelFeedbackRequest labelFeedbackRequest, BTableRequest bTableRequest) {
        Page<LabelFeedback> page=commonService.getPage(bTableRequest,"label_feedback");
        LabelFeedback labelFeedback=labelWrapper.unwrapFeedback(labelFeedbackRequest);
        commonService.checkIsOrgan(labelFeedback);
        Label label=labelDao.getById(labelFeedback.getLabelId());
        labelFeedback.setLabelOrganId(label.getOrganId());
        page.setEntity(labelFeedback);
        List<LabelFeedbackModel> labelFeedbackModelList=labelFeedbackDao.getByPage(page).stream().map(labelWrapper::wrapFeedback).collect(Collectors.toList());
        Long size=labelFeedbackDao.getSizeByPage(page);
        labelFeedbackModelList.forEach(s->addProcess(s,labelFeedback.getLabelId()));
        return commonService.tableReturn(bTableRequest.getsEcho(),size,labelFeedbackModelList);
    }

    private void addProcess(LabelFeedbackModel labelFeedbackModel,Integer labelId) {
        labelFeedbackModel.setLabelManImplNum(labelManDao.getLabelManImplNum(labelFeedbackModel.getOrganId(),labelId));

    }


    @Override
    public void export(HttpServletResponse response, LabelManRequest labelManRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LabelMan labelMan= labelManWrapper.unwrap(labelManRequest);
        commonService.fillXq(labelManRequest,labelMan);
        List<LabelManModel> labelManModelList=labelManDao.getAll(labelMan).stream().map(labelManWrapper::wrap).collect(Collectors.toList());

        //excel标题
        String[] title =new String[6];
        title[0]="片区";
        title[1]="居委";
        title[2]="老人姓名";
        title[3]="性别";
        title[4]="年龄";
        title[5]="身份证";
        int j=0;
        Label label=labelDao.getById(labelMan.getLabelId());

        String fileName="labelMan.xls";
        String sheetName = label.getName();
        String[][] content=new String[labelManModelList.size()][];
        for(LabelManModel re:labelManModelList){
            content[j]=new String[6];
            content[j][0]=re.getdName();
            content[j][1]=re.getjName();
            content[j][2]=re.getOldmanName();
            content[j][3]=re.getSex();
            content[j][4]=re.getAge()+"";
            content[j][5]=re.getPid();
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
            Remote.noticeByfunction("finishExport",commonService.getIdBySession());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void feedbackAdd(LabelFeedbackAddRequest labelFeedbackAddRequest) {
        LabelFeedback labelFeedback=labelWrapper.unwrapFeedbackAdd(labelFeedbackAddRequest);
        labelFeedback.setOrganId(commonService.getIdBySession());
        labelFeedbackDao.save(labelFeedback);
    }

    @Override
    public Result getFeedbackByLabelId(int labelId) {
        Integer organId=commonService.getIdBySession();
        return new Result(true,labelWrapper.wrapFeedback(labelFeedbackDao.getByLabelIdOrganId(labelId,organId)));
    }


    @Override
    public Result checkCanChange(int labelId) {
        Label label=labelDao.getById(labelId);
        Integer organId=commonService.getIdBySession();
        if(organId==label.getOrganId()){
            return new Result(true);
        }else if(organId==null || organId==0){
            return new Result(true);
        }
        return new Result(false);
    }


    @Override
    public Result getSecLabelByFirType(int firType) {
        List<LabelSec> labelSecList=labelSecDao.getByFirType(firType);
        return new Result(true,labelSecList);
    }

    //1 是 人员绑定  2是规则制定
    @Override
    public LabelFilterModel getFilterLabelRule(int i) {
        LabelFilterModel labelFilterModel;
        List<Integer> typeIds = new ArrayList<>();
        typeIds.add(33);
        typeIds.add(2);
        List<Organ> belongOrgan = organDao.getByTypes(typeIds);
        List<LabelSec> labelSecList = labelSecDao.getByFirType(0);
        if(i==2) {
            List<Integer> typeList = commonService.getAutoValueTypes("labelFilter");
            List<AutoValue> autoValueList = autoValueDao.getByTypeList(typeList);
            Integer organId = commonService.getIdBySession();
            List<Organ> jwList = organDao.getSimpleByType(2, organId);
            List<Chx> chxList = chxDao.getSimple();
            labelFilterModel = labelWrapper.wrapFilterLabelRule(autoValueList, jwList, chxList, belongOrgan, labelSecList);
        }else{
            labelFilterModel=new LabelFilterModel();
            labelFilterModel.setBelongOrgan(belongOrgan);
            labelFilterModel.setSecLabel(labelSecList);
            labelFilterModel.setFirLabel(autoValueDao.getByType(9));
        }
        return labelFilterModel;
    }

    @Override
    public void addOrUpdateFirType(AutoValue firType, String type) {
        if(type.equals("add"))
            autoValueDao.save(firType);
        else
            autoValueDao.updateById(firType);
    }


    @Override
    public void addOrUpdateSecType(LabelSec labelSec, String type) {
        if(type.equals("add"))
            labelSecDao.save(labelSec);
        else
            labelSecDao.updateById(labelSec);
    }

    @Override
    public Result getById(int id) {
        Label label=labelDao.getById(id);
        label.setStartTime(Tool.dateToString(label.getStart(), TimeConstant.DATA_FORMAT_YMD));
        label.setEndTime(Tool.dateToString(label.getEnd(), TimeConstant.DATA_FORMAT_YMD));
        return new Result(true,label);
    }

    @Override
    public void updateById(Label label) {
        label.setStart(Tool.stringToDate(label.getStartTime()));
        label.setEnd(Tool.stringToDate(label.getEndTime()));
        labelDao.updateById(label);
    }

    @Override
    @Transactional
    public void delByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        labelDao.delByIds(id);
        labelManDao.delByLabelIds(id);
        labelFeedbackDao.delByLabelIds(id);
    }

    @Override
    public void delManByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        labelManDao.delByIds(id);
    }

    @Override
    public void delTypeByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        labelSecDao.delByIds(id);
    }
}
