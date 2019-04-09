package com.organOld.outService.wrapper;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.outService.enumModel.OldStatusEnum;
import com.organOld.outService.enumModel.OrganFirEnum;
import com.organOld.outService.model.OrganOldmanModel;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.tool.Tool;
import com.organOld.outService.contract.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@Service
public class OrganOldmanWrapper implements Wrapper<OrganOldman,OrganOldmanModel,OrganOldmanRequest> {

    @Autowired
    CommonService commonService;

    @Override
    public OrganOldmanModel wrap(OrganOldman organOldman) {
        OrganOldmanModel organOldmanModel=new OrganOldmanModel();
        organOldmanModel.setId(organOldman.getId()+"");
        if(!StringUtils.isEmpty(organOldman.getOrgan())){
            organOldmanModel.setOrganId(organOldman.getOrgan().getId());
            organOldmanModel.setOrganName(organOldman.getOrgan().getName());
            organOldmanModel.setOrgan(organOldman.getOrgan());
        }
        if(!StringUtils.isEmpty(organOldman.getOldman())){
            organOldmanModel.setOldmanId(organOldman.getOldman().getId());
            organOldmanModel.setOldmanName(organOldman.getOldman().getName());
            if(organOldman.getOldman()!=null && organOldman.getOldman().getDisable()!=null) {
                if (organOldman.getOldman().getDisable() == 0) {
                    organOldmanModel.setOldmanStatus("正常");
                } else if(organOldman.getOldman().getDisable() == 1){
                    organOldmanModel.setOldmanStatus("被删除");
                } else{
                    organOldmanModel.setOldmanStatus("未录入资料");
                }
            }
        }
//        if(!StringUtils.isEmpty(organOldman.getNoExistName())){
//            organOldmanModel.setOldmanId(null);
//            organOldmanModel.setOldmanName(organOldman.getNoExistName());
//            organOldmanModel.setOldmanStatus("不在当前老人集中");
//        }
        organOldmanModel.setNy(organOldman.getNy());
        organOldmanModel.setNum(organOldman.getNum());
        organOldmanModel.setTimeIn(Tool.dateToString(organOldman.getTimeIn(),"yyyy-MM-dd"));
        organOldmanModel.setTimeOut(Tool.dateToString(organOldman.getTimeOut(),"yyyy-MM-dd"));
        organOldmanModel.setTime(Tool.dateToString(organOldman.getTime(),"yyyy-MM-dd"));
        organOldmanModel.setApplyTime(Tool.dateToString(organOldman.getApplyTime(),"yyyy-MM-dd"));
        return organOldmanModel;
    }

    @Override
    public OrganOldman unwrap(OrganOldmanRequest organOldmanRequest) {
        OrganOldman organOldman=new OrganOldman();
        Organ organ=new Organ();
        organ.setId(organOldmanRequest.getOrganId());
        organOldman.setSearch(organOldmanRequest.getSearch());
        if(organOldmanRequest.getOldmanId()!=null && organOldmanRequest.getOldmanId()!=0){
            Oldman oldman=new Oldman();
            oldman.setId(organOldmanRequest.getOldmanId());
            organOldman.setOldman(oldman);
        }
        organOldman.setNy(organOldmanRequest.getNy());
        organOldman.setOrgan(organ);
        organOldman.setIsPd(organOldmanRequest.getIsPd());
        organOldman.setIsExist(organOldmanRequest.getIsExist());

        if(!StringUtils.isEmpty(organOldmanRequest.getFirType())){
            //养老状态
            if(organOldmanRequest.getFirType().equals("organ")){
                organOldman.setFirType(OrganFirEnum.JGYL.getIndex());
                organOldman.setOldStatus(OldStatusEnum.JG.getIndex());
            }else{
                organOldman.setFirType(OrganFirEnum.SQYL.getIndex());
                organOldman.setOldStatus(OldStatusEnum.SQ.getIndex());
            }
            organOldman.setNy(commonService.getPrevNy());
        }
        return organOldman;
    }


    public Map<String,Long> wrapTotalData(Map<String, Long> organOldmanNum) {
        return null;
    }
}
