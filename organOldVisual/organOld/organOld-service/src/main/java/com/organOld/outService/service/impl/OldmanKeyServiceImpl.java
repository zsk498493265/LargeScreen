package com.organOld.outService.service.impl;

import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.*;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.repository.*;
import com.organOld.dao.util.Page;
import com.organOld.outService.constant.TimeConstant;
import com.organOld.outService.constant.ValueConstant;
import com.organOld.outService.contract.*;
import com.organOld.outService.dwr.Remote;
import com.organOld.outService.enumModel.KeyRuleTypeEnum;
import com.organOld.outService.enumModel.KeyStatusEnum;
import com.organOld.outService.model.HealthSelectModel;
import com.organOld.outService.model.KeyRuleTypeModel;
import com.organOld.outService.model.KeyRulelModel;
import com.organOld.outService.model.OldmanKeyModel;
import com.organOld.outService.contract.Result;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.thread.KeyAutoUpdate;
import com.organOld.outService.service.OldmanKeyService;
import com.organOld.outService.thread.KeyUpdate;
import com.organOld.outService.tool.Tool;
import com.organOld.outService.wrapper.OldmanKeyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OldmanKeyServiceImpl implements OldmanKeyService {

    @Autowired
    CommonService commonService;
    @Autowired
    OldmanKeyDao oldmanKeyDao;
    @Autowired
    KeyRuleDao keyRuleDao;
    @Autowired
    KeyAutoUpdate keyAutoUpdate;
    @Autowired
    KeyUpdate keyUpdate;
    @Autowired
    OldmanKeyHandleDao oldmanKeyHandleDao;
    @Autowired
    OldmanDao oldmanDao;
    @Autowired
    OrganDao organDao;
    @Autowired
    OldmanKeyWrapper oldmanKeyWrapper;
    @Autowired
    OrganOldmanDao organOldmanDao;
    @Autowired
    HealthSelectManDao healthSelectManDao;
    @Autowired
    HomeOldmanDao homeOldmanDao;

    public static List<KeyRule> keyRuleList;
    int num=0;
    //用于记录 健康状况的得分，  为后面的有长护险  减去健康得分
    public static Map<Integer,Integer> goalHealthMap=new HashMap<>();


    @Override
    public String getByPage(BTableRequest bTableRequest, OldmanKeyRequest oldmanKeyRequest) {
        Page<Oldman> page=commonService.getPage(bTableRequest,"oldman_key");
        Oldman oldman= oldmanKeyWrapper.unwrap(oldmanKeyRequest);
        commonService.fillXq(null,oldman);
        page.setEntity(oldman);
        List<OldmanKeyModel> oldmanKeyModelList=oldmanKeyDao.getByPage(page).stream().map(oldmanKeyWrapper::wrap).collect(Collectors.toList());
        fillApplyOrgan(oldmanKeyModelList);
        Long size=oldmanKeyDao.getSizeByPage(page);

        for(OldmanKeyModel oldmanKeyModel:oldmanKeyModelList){
            if(oldmanKeyModel.getOldmanKeyHandleModel()!=null && oldmanKeyModel.getOldmanKeyHandleModel().getOrgandIds()!=null && oldmanKeyModel.getOldmanKeyHandleModel().getOrgandIds().size()>0){
                oldmanKeyModel.getOldmanKeyHandleModel().setOrgan(organDao.getByIds(oldmanKeyModel.getOldmanKeyHandleModel().getOrgandIds()));
            }
        }

        return commonService.tableReturn(bTableRequest.getsEcho(),size,oldmanKeyModelList);
    }

    private void fillApplyOrgan(List<OldmanKeyModel> oldmanKeyModelList) {
        if(oldmanKeyModelList.size()==0)
            return;
        List<Integer> oldmanIds=new ArrayList<>();
        oldmanKeyModelList.forEach(s->oldmanIds.add(s.getOldmanId()));
        List<Organ> organList=organDao.getALLNotInFirType(1);
        Map<Integer,Organ> organMap=new HashMap<>();
        organList.forEach(s->organMap.put(s.getId(),s));
        List<OrganOldman> organOldmanList=organOldmanDao.getByOldmanIds(oldmanIds);
        for(OrganOldman organOldman:organOldmanList){
                for (OldmanKeyModel oldmanKeyModel : oldmanKeyModelList) {
                    if (organOldman.getOldmanId().intValue() == oldmanKeyModel.getOldmanId().intValue()) {
                        organMap.get(organOldman.getOrganId()).setApplyTime(Tool.dateToString(organOldman.getApplyTime(), TimeConstant.DATA_FORMAT_YMD));
                        oldmanKeyModel.getOrganActivity().add(organMap.get(organOldman.getOrganId()));
                    }
//                    oldmanKeyModel.getOrganAndHome().put(organ.getId()+"",organ.getName());
                }
        }

    }

    @Override
    public Result updateMan(String futureTime) {
        if(futureTime!=null && !futureTime.equals("")){
            futureKey(futureTime);
            return new Result(true,"future");
        }else{
            goalHealthMap.clear();
            keyRuleList=keyRuleDao.getAll();
            //去掉长护险和慢病的失能的
            for(KeyRule keyRule:keyRuleList){
                if(keyRule.getType()==3 || keyRule.getType()==7 || keyRule.getType()==4){
                    keyRuleList.remove(keyRule);
                }
            }
            KeyUpdate.DOING=true;
            KeyUpdate.finish=false;
            keyUpdate.longPollingExecutor.execute(keyUpdate.updateRunner);
            return new Result(true,"now");
        }
    }

    private void futureKey(String futureTime) {
        try {
            keyRuleList=keyRuleDao.getAll();
            for(KeyRule keyRule:keyRuleList){
                if(keyRule.getType()!=KeyRuleTypeEnum.NL.getIndex()){
                    keyRuleList.remove(keyRule);
                }
            }
            //将来预测的 只跟年龄有关系  默认当前重点老人是最新的
            List<Oldman> oldmanList=oldmanDao.getAllOldmanKey();
            List<Oldman> updateOldmanList=new ArrayList<>();//只更新分数有变化的
            for(Oldman oldman:oldmanList){
                for(KeyRule keyRule:keyRuleList){
                    int now_goal=0,future_goal=0;
                    int now_age=CommonService.birthdayToAge(oldman.getBirthday());
                    int future_age=CommonService.calculateTwoDateYears(futureTime,oldman.getBirthday());
                    int start=Integer.parseInt(keyRule.getValueName().split("-")[0]);
                    int end=keyRule.getValueName().split("-").length==1? Integer.MAX_VALUE:Integer.parseInt(keyRule.getValueName().split("-")[1]);
                    if(now_age>=start && now_age<=end){
                        now_goal=keyRule.getGoal();
                    }
                    if(future_age>=start && future_age<=end){
                        future_goal=keyRule.getGoal();
                    }
                    if(future_goal>now_goal){
                        oldman.setGoal(oldman.getGoal()+(future_goal-now_goal));
                        updateOldmanList.add(oldman);
                        checkKeyStatus(oldman);
                    }
                }
            }
            oldmanDao.updateKeyOldmanFuture(updateOldmanList);
            Remote.noticeByfunction("finishKey",commonService.getIdBySession());
        }catch(Exception e){

        }

    }

    @Override
    public Result autoUpdateMan(Boolean open) {
//        Result result;
        if(open){
            //开启
            keyRuleList=keyRuleDao.getAll();

            KeyAutoUpdate.OPEN_SWITCH=true;
            keyAutoUpdate.setCurrent(KeyAutoUpdate.REDIS_NULL_VALUE);
            keyAutoUpdate.setMax(KeyAutoUpdate.REDIS_NULL_VALUE);
            keyAutoUpdate.setExpiredTime(KeyAutoUpdate.REDIS_NULL_VALUE);
            keyAutoUpdate.longPollingExecutor.execute(keyAutoUpdate.updateRunner);
        }else{
            //关闭
            KeyAutoUpdate.OPEN_SWITCH=false;
        }
        return new Result(true);
    }


    @Override
    public void checkKeyStatus(Oldman oldman) {
        Boolean isKeyNow=false;
//        KeyUpdate.log.info(oldman.toString());
        if(oldman.getGoal()>= ValueConstant.OLDMAN_KEY_GOAL_BASE)
            isKeyNow=true;

        if(oldman.getKeyStatus()== KeyStatusEnum.NO.getIndex() || oldman.getKeyStatus()== KeyStatusEnum.DEL.getIndex()){
            if(isKeyNow){
                //上次不是 这次是
                oldman.setKeyStatus(KeyStatusEnum.ADD.getIndex());
            }else{
                //上次这次都不是
                oldman.setKeyStatus(KeyStatusEnum.NO.getIndex());
            }
        }else if(oldman.getKeyStatus()== KeyStatusEnum.YES.getIndex() || oldman.getKeyStatus()== KeyStatusEnum.ADD.getIndex()){
            if(isKeyNow){
                //上次这次都是
                oldman.setKeyStatus(KeyStatusEnum.YES.getIndex());
            }else{
                //上次是  这次不是
                oldman.setKeyStatus(KeyStatusEnum.DEL.getIndex());
            }
        }
//        KeyUpdate.log.info(oldman.toString());
    }

    //当前更新的第二遍
    public void checkKeyStatusSec(Oldman oldman) {
        Boolean isKeyNow=false;
//        KeyUpdate.log.info(oldman.toString());
        if(oldman.getGoal()>= ValueConstant.OLDMAN_KEY_GOAL_BASE)
            isKeyNow=true;
        if(oldman.getKeyStatus()== KeyStatusEnum.NO.getIndex()){
            if(isKeyNow) {
                oldman.setKeyStatus(KeyStatusEnum.ADD.getIndex());
            }else{
                oldman.setKeyStatus(KeyStatusEnum.NO.getIndex());
            }
        }
        if(oldman.getKeyStatus()== KeyStatusEnum.DEL.getIndex()){
            if(isKeyNow) {
                oldman.setKeyStatus(KeyStatusEnum.YES.getIndex());
            }else{
                oldman.setKeyStatus(KeyStatusEnum.DEL.getIndex());
            }
        }
        if(oldman.getKeyStatus()== KeyStatusEnum.YES.getIndex()){
            oldman.setKeyStatus(KeyStatusEnum.YES.getIndex());
        }
        if(oldman.getKeyStatus()== KeyStatusEnum.ADD.getIndex()){
            oldman.setKeyStatus(KeyStatusEnum.ADD.getIndex());
        }

    }


    @Override
    public int calculateKeyGoal(OldmanKey oldmanKey){
        int goal=0;//总分
//        int goalHealth=0;// 健康状态的分数  最后如果有长护险的话 总分减去这个

        int flagAge=0,flagLOU=0,flagJYLY=0; //避免重复计算  年龄、楼号、主动申请进养老院
        int flagCHX=0,flagSL=0,flagSZ=0;
        int flagSN=oldmanKey.getSnIds().size(),flagMB=oldmanKey.getMbIds().size();

        for (KeyRule keyRule:keyRuleList){
            //先去掉这个模型
//            if(keyRule.getType()== KeyRuleTypeEnum.JYLY.getIndex()){
                //是否主动进养老院
//                if(flagJYLY==0){
//                    if(keyRule.getValueIndex()==oldmanKey.getIsActivityOrgan()){
//                        flagJYLY=1;
//                        goal+=keyRule.getGoal();
//                    }
//                }
//                continue;
//            }


            if(keyRule.getType()== KeyRuleTypeEnum.NL.getIndex()){
                //年龄
                if(flagAge==0){
                    int start=Integer.parseInt(keyRule.getValueName().split("-")[0]);
                    int end=keyRule.getValueName().split("-").length==1? Integer.MAX_VALUE:Integer.parseInt(keyRule.getValueName().split("-")[1]);
                    if(oldmanKey.getAge()>=start && oldmanKey.getAge()<=end){
                        flagAge=1;
                        goal+=keyRule.getGoal();
                    }
                }
                continue;

            }
            if(keyRule.getType()== KeyRuleTypeEnum.JTJG.getIndex()){
                //家庭结构
//                if(flagJTJG==0){

                if(oldmanKey.getFamilyIndex()!=null) {
                    if (oldmanKey.getFamilyIndex().contains(keyRule.getValueIndex() + "")) {
//                        flagJTJG=1;
                        goal += keyRule.getGoal();
                    }
                }

//                }
                continue;
            }
//            if(keyRule.getType()== KeyRuleTypeEnum.CHX.getIndex()){
//                //长护险
//                if(flagCHX==0){
//                    if(keyRule.getValueIndex()==oldmanKey.getChxIndex()){
//                        flagCHX=1;
//                        goal+=keyRule.getGoal();
//                    }
//                }
//                continue;
//            }
            if(keyRule.getType()== KeyRuleTypeEnum.SN.getIndex()){
                //失能
                if(flagSN!=0 && flagCHX==0){
                    if(oldmanKey.getSnIds().contains(keyRule.getValueIndex())){
                        flagSN--;
//                        goal+=keyRule.getGoal();
                        if(!goalHealthMap.containsKey(oldmanKey.getOldmanId())){
                         goalHealthMap.put(oldmanKey.getOldmanId(),keyRule.getGoal());
                        }else{
                            goalHealthMap.put(oldmanKey.getOldmanId(),goalHealthMap.get(oldmanKey.getOldmanId())+keyRule.getGoal());
                        }
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.ZL.getIndex()){
                //失智
                if(flagSZ==0 && flagCHX==0){
                    if(oldmanKey.getIntelligence()==keyRule.getValueIndex()){
                        flagSZ=1;
//                        goal+=keyRule.getGoal();
                        if(!goalHealthMap.containsKey(oldmanKey.getOldmanId())){
                            goalHealthMap.put(oldmanKey.getOldmanId(),keyRule.getGoal());
                        }else{
                            goalHealthMap.put(oldmanKey.getOldmanId(),goalHealthMap.get(oldmanKey.getOldmanId())+keyRule.getGoal());
                        }
                    }
                }
                continue;
            }
            if(keyRule.getType()== KeyRuleTypeEnum.SL.getIndex()){
                //视力
                if(flagSL==0 && flagCHX==0){
                    if(oldmanKey.getEyesight()==keyRule.getValueIndex()){
                        flagSL=1;
//                        goal+=keyRule.getGoal();
                        if(!goalHealthMap.containsKey(oldmanKey.getOldmanId())){
                            goalHealthMap.put(oldmanKey.getOldmanId(),keyRule.getGoal());
                        }else{
                            goalHealthMap.put(oldmanKey.getOldmanId(),goalHealthMap.get(oldmanKey.getOldmanId())+keyRule.getGoal());
                        }
                    }
                }
                continue;
            }
//            if(keyRule.getType()== KeyRuleTypeEnum.MB.getIndex()){
//                //慢病
//                if(flagMB!=0 && flagCHX==0){
//                    if(oldmanKey.getMbIds().contains(keyRule.getValueIndex())){
//                        flagMB--;
//                        goal+=keyRule.getGoal();
//                        goalHealth+=keyRule.getGoal();
//                    }
//                }
//                continue;
//            }
            if(keyRule.getType()== KeyRuleTypeEnum.JJTJ.getIndex()){
                //经济条件
//                if(flagJJTJ==0){

                if(oldmanKey.getEconomicIndex()!=null) {
                    if (oldmanKey.getEconomicIndex().contains(keyRule.getValueIndex() + "")) {
//                        flagJJTJ=1;
                        goal += keyRule.getGoal();

                    }
                }
//                }
                continue;
            }
//            if(keyRule.getType()== KeyRuleTypeEnum.LOU.getIndex()){
//                //无电梯楼层
//                if(flagLOU==0){
//                    if(keyRule.getValueIndex()==oldmanKey.getFloor()){
//                        flagLOU=1;
//                        goal+=keyRule.getGoal();
//                    }
//                }
//                continue;
//            }
        }
//        if(flagCHX==1){
//            goal-=goalHealth;
//        }
//        if(goal!=0) {
//            num+=1;
//            KeyUpdate.log.info(oldmanKey.toString());
//            KeyUpdate.log.info(num+"");
//        }
        return goal;
    }

    @Override
    @Transactional
    public void calculateChxHealthGoal() {
        int flagMbSn=0,flagChx=0;
        keyRuleList=keyRuleDao.getAll();
        //只留长护险和慢病的
        for(KeyRule keyRule:keyRuleList){
            if(keyRule.getType()!=3 && keyRule.getType()!=7 && keyRule.getType()==4){
                keyRuleList.remove(keyRule);
            }else if(keyRule.getType()==3){
                flagChx=1;
            }else{
                flagMbSn=1;
            }

        }
        if(flagMbSn!=0) {
            //处理慢病 失能
            List<HealthSelectMan> healthSelectManList = healthSelectManDao.getMbSn();
            for (HealthSelectMan healthSelectMan : healthSelectManList) {
                int goal = 0;
                for (KeyRule keyRule:keyRuleList){
                    if((keyRule.getType()==KeyRuleTypeEnum.MB.getIndex() || keyRule.getType()==KeyRuleTypeEnum.SN.getIndex()) && keyRule.getValueIndex()==healthSelectMan.getHealthSelectId()){
                        goal=keyRule.getGoal();
                    }
                }
                if (goalHealthMap.containsKey(healthSelectMan.getOldmanId())) {
                    goalHealthMap.put(healthSelectMan.getOldmanId(),goalHealthMap.get(healthSelectMan.getOldmanId())+goal);
                } else {
                    goalHealthMap.put(healthSelectMan.getOldmanId(),goal );
                }
            }
        }
        //处理长护险
        if(flagChx!=0){
            //用homeoldman中的home_id 给chx的id赋值    规则的索引是chx表的索引
            List<HomeOldman> homeOldmanList=homeOldmanDao.getChx(commonService.getPrevNy());
            for(HomeOldman homeOldman:homeOldmanList){
                int goal=0;
                for (KeyRule keyRule:keyRuleList){
                    if(keyRule.getType()==KeyRuleTypeEnum.CHX.getIndex() && keyRule.getValueIndex()==homeOldman.getHomeId()){
                        goal=keyRule.getGoal();
                    }
                }
                //如果健康状况有得分，进行覆盖长护险得分
                goalHealthMap.put(homeOldman.getOldmanId(),goal);
            }
        }
//        //更新这些人的得分 和状态
//        oldmanDao.updateGoal(goalHealthMap);
        //更新这些人的状态 和得分
        List<Integer> oldmanIds=new ArrayList<>();
        for(Integer oldmanId:goalHealthMap.keySet()){
            oldmanIds.add(oldmanId);
        }
        if(oldmanIds.size()>0) {
            int totalcount=oldmanIds.size();
            int pagecount=0;
            int pagesize=1000;
            int m=totalcount%pagesize;
            if  (m>0){
                pagecount=totalcount/pagesize+1;
            }else{
                pagecount=totalcount/pagesize;
            }

            List<Oldman> oldmanList = new ArrayList<>();
            for(int i=1;i<=pagecount;i++){
                if (m==0){
                    List<Integer> subList= oldmanIds.subList((i-1)*pagesize,pagesize*(i));
                    oldmanList.addAll(oldmanDao.getKeyStatusByIds(subList));
                }else{
                    if (i==pagecount){
                        List<Integer> subList= oldmanIds.subList((i-1)*pagesize,totalcount);
                        oldmanList.addAll(oldmanDao.getKeyStatusByIds(subList));
                    }else{
                        List<Integer> subList= oldmanIds.subList((i-1)*pagesize,pagesize*(i));
                        oldmanList.addAll(oldmanDao.getKeyStatusByIds(subList));
                    }
                }
            }

            for (Oldman oldman : oldmanList) {
                oldman.setGoal(oldman.getGoal() + goalHealthMap.get(oldman.getId()));
                checkKeyStatusSec(oldman);
            }

            oldmanDao.updateKeyOldman(oldmanList);

        }
    }

    @Override
    public KeyRulelModel getRule() {
        KeyRulelModel keyGoalModel=new KeyRulelModel();
        List<KeyRule> keyRuleList=keyRuleDao.getAllRule();
        List<KeyRuleTypeModel> keyRuleTypeModelList=oldmanKeyWrapper.wrapKeyRule(keyRuleList);
//        keyRuleList.stream().forEach(r->r.setTypeDesc(KeyRuleTypeEnum.getValue(r.getType())));
        keyGoalModel.setBaseGoal(ValueConstant.OLDMAN_KEY_GOAL_BASE);
        keyGoalModel.setKeyRuleTypeList(keyRuleTypeModelList);
        return keyGoalModel;
    }


    @Override
    public void updateRule(KeyRuleRequest keyRuleRequest) {
        ValueConstant.OLDMAN_KEY_GOAL_BASE=keyRuleRequest.getBaseGoal();
        List<KeyRule> keyRuleList=oldmanKeyWrapper.unwrapKeyRule(keyRuleRequest);
        keyRuleDao.updateByIds(keyRuleList);
    }


    @Override
    @Transactional
    public Result handle(OldmanhKeyHandleRequest oldmanhKeyHandleRequest) {
        OldmanKeyHandle oldmanKeyHandle= oldmanKeyWrapper.unwrapKeyHandle(oldmanhKeyHandleRequest);
        if(oldmanhKeyHandleRequest.getHandle().equals("add")) {
            oldmanKeyHandleDao.save(oldmanKeyHandle);
            oldmanDao.updateProp("is_handle", "1", oldmanhKeyHandleRequest.getOldmanId());
        }else if(oldmanhKeyHandleRequest.getHandle().equals("update")){
            oldmanKeyHandleDao.updateByOldmanId(oldmanKeyHandle);
        }else{
            //删除
            oldmanDao.updateProp("is_handle", "0", oldmanhKeyHandleRequest.getOldmanId());
            oldmanKeyHandleDao.delByOldmanId(oldmanhKeyHandleRequest.getOldmanId());
        }
        return new Result(true);
    }

    @Override
    public Result getHandleByOldmanId(int oldmanId) {
        return new Result(true,oldmanKeyWrapper.wrapHandle(oldmanKeyHandleDao.getByOldmanId(oldmanId)));
    }

    @Override
    @Transactional
    public Result handleDel(String[] oldmanIds) {
        oldmanKeyHandleDao.delByOldmanIds(oldmanIds);
        oldmanDao.updateProps("is_handle","0",oldmanIds);
        return new Result(true);
    }
}
