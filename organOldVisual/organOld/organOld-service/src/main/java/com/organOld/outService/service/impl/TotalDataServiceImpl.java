package com.organOld.outService.service.impl;

import com.organOld.dao.entity.SysRole;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.OldmanDao;
import com.organOld.dao.repository.SystemDao;
import com.organOld.outService.constant.SysVar;
import com.organOld.outService.constant.ValueConstant;
import com.organOld.outService.contract.Result;
import com.organOld.outService.enumModel.AutoValueEnum;
import com.organOld.outService.enumModel.OrganFirEnum;
import com.organOld.outService.model.*;
import com.organOld.outService.service.*;
import com.organOld.outService.wrapper.OldmanWrapper;
import com.organOld.outService.wrapper.OrganOldmanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by netlab606 on 2018/8/9.
 */
@Service
public class TotalDataServiceImpl implements TotalDataService{


    @Autowired
    OldmanService oldmanService;
    @Autowired
    OldmanWrapper oldmanWrapper;
    @Autowired
    OrganOldmanWrapper organOldmanWrapper;
    @Autowired
    SystemDao systemDao;
    @Autowired
    CommonService commonService;
    @Autowired
    OrganService organService;
    @Autowired
    MessageService messageService;
    @Autowired
    AutoValueService autoValueService;

    @Override
    public TotalDataNum getNum(String role) {
//        List<Integer> oldmanIds=systemDao.getfeijw();
//        systemDao.ser(oldmanIds);
        TotalDataNum totalDataNum=new TotalDataNum();
        totalDataNum.setMessageNum(Long.valueOf(messageService.getNoReadNum()));
        totalDataNum.setOldmanNum(oldmanService.getOldmanNum(null));
        totalDataNum.setNum80(oldmanService.getOldmanNum(CommonService.AgeTobirthday(80)));
        DecimalFormat df = new DecimalFormat("#.00");
        switch (role){
            case "admin":
                Integer num1=organService.getPeopleNum();
                if(num1!=null && num1!=0){
                    totalDataNum.setBl(df.format(Double.parseDouble(totalDataNum.getOldmanNum()+"")/num1*100)+"%");
                }
                totalDataNum.setOrganNum(organService.getOldmanSize());
                break;
            case "jw":
                Organ organ=organService.getByUserName(commonService.getUserNameBySession());
                if(organ==null)
                    break;
                Integer peopleNum=organ.getPeopleNum();
                if(peopleNum!=null && peopleNum!=0)
                    totalDataNum.setBl(df.format(Double.parseDouble(totalDataNum.getOldmanNum()+"")/peopleNum*100)+"%");
                break;
            case "pq":
                Integer num=organService.getPeopleNumByPqId();
                if(num!=null && num!=0){
                    totalDataNum.setBl(df.format(Double.parseDouble(totalDataNum.getOldmanNum()+"")/num*100)+"%");
                }
                break;
        }
        return totalDataNum;
    }

    @Override
    public Result getOldStatus() {
        List<Integer> xqIds=commonService.getOrganXqs();
        TotalData totalAdminOldStatus=oldmanWrapper.wrapTotalData(oldmanService.getOldStatusNum(xqIds),new TotalDataOldStatus());
        if(totalAdminOldStatus==null)
            return new Result(false);
        return new Result(true,totalAdminOldStatus);
    }


    @Override
    public String getRoleBySession() throws Exception {
        int trytimes=0;
        SysRole role=null;
        while(trytimes<3) {
            try {
                role = systemDao.getRoleByUsername(commonService.getUserNameBySession());
                if(role!=null)
                    return role.getName();
                else return "";
            }catch (Exception e){
                trytimes++;
            }
        }
        throw new Exception();
    }

    @Override
    public Result getIntegralSort() {
        List<Integer> xqIds=commonService.getOrganXqs();
        List<Oldman> oldmanList=oldmanService.getIntegralSort(xqIds);
        return new Result(true,oldmanList);
    }

    @Override
    public Result getOldmanNum() {
        List<Integer> xqIds=commonService.getOrganXqs();
        Date start60=CommonService.AgeTobirthday(60);
        Date start80=CommonService.AgeTobirthday(80);
        TotalData totalAdminOldStatus=oldmanWrapper.wrapTotalData(oldmanService.getOldmanNum(xqIds,start60,start80),new TotalDataOldNum());
        if(totalAdminOldStatus==null)
            return new Result(false);
        return new Result(true,totalAdminOldStatus);
    }

    @Override
    public Result getKeyNum() {
        List<Integer> xqIds=commonService.getOrganXqs();
        TotalData totalAdminOldStatus=oldmanWrapper.wrapTotalData(oldmanService.getKeyNum(xqIds, ValueConstant.OLDMAN_KEY_GOAL_BASE),new TotalDataKey());
        if(totalAdminOldStatus==null)
            return new Result(false);
        return new Result(true,totalAdminOldStatus);
    }

    @Override
    public Result getHealthNum() {
        List<Integer> xqIds=commonService.getOrganXqs();
        TotalData totalAdminOldStatus=oldmanWrapper.wrapTotalData(oldmanService.getHealthNum(xqIds),new TotalDataHealth());
        if(totalAdminOldStatus==null)
            return new Result(false);
        return new Result(true,totalAdminOldStatus);
    }

    @Override
    public Result getOrganNum() {
        TotalData totalAdminOldStatus=oldmanWrapper.wrapTotalData(organService.getOrganNum(),new TotalDataOrgan());
        if(totalAdminOldStatus==null)
            return new Result(false);
        return new Result(true,totalAdminOldStatus);
    }

    @Override
    public Result getOrganBedNum() {
        TotalData totalAdminOldStatus=oldmanWrapper.wrapTotalData(organService.getOrganBedNum(),new TotalDataOrganBedNum());
        if(totalAdminOldStatus==null)
            return new Result(false);
        return new Result(true,totalAdminOldStatus);
    }

    @Override
    public Result getOrganOldmanHisNum() {
        Map<String,Long> data=organOldmanWrapper.wrapTotalData(organService.getOrganOldmanHisNum());
        if(data==null)
            return new Result(false);
        return new Result(true,data);
    }

    @Override
    public Result getOrganOldmanNum() {
        TotalData totalAdminOldStatus=oldmanWrapper.wrapTotalData(organService.getOrganOldmanNum(),new TotalDataOrganOldmanNum());
        if(totalAdminOldStatus==null)
            return new Result(false);
        return new Result(true,totalAdminOldStatus);
    }

}
