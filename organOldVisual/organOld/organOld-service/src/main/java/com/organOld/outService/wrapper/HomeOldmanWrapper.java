package com.organOld.outService.wrapper;

import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.outService.contract.HomeOldmanRequest;
import com.organOld.outService.enumModel.HomeEnum;
import com.organOld.outService.model.HomeOldmanModel;
import com.organOld.outService.tool.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HomeOldmanWrapper implements Wrapper<HomeOldman,HomeOldmanModel,HomeOldmanRequest> {

    @Override
    public HomeOldmanModel wrap(HomeOldman homeOldman) {
        HomeOldmanModel homeOldmanModel=new HomeOldmanModel();
        homeOldmanModel.setHomeName(homeOldman.getHome().getSecType());
        homeOldmanModel.setHomeType(HomeEnum.getValue(homeOldman.getHome().getFirType()));
        homeOldmanModel.setId(homeOldman.getId());
        homeOldmanModel.setNy(homeOldman.getNy());
        if(!StringUtils.isEmpty(homeOldman.getOldman())){
            homeOldmanModel.setOldmanId(homeOldman.getOldman().getId());
            homeOldmanModel.setOldmanName(homeOldman.getOldman().getName());
            if(homeOldman.getOldman()!=null && homeOldman.getOldman().getDisable()!=null) {
                if (homeOldman.getOldman().getDisable() == 0) {
                    homeOldmanModel.setOldmanStatus("正常");
                } else if(homeOldman.getOldman().getDisable() == 1){
                    homeOldmanModel.setOldmanStatus("被删除");
                } else{
                    homeOldmanModel.setOldmanStatus("未录入资料");
                }
            }
        }
        if(homeOldman.getHome().getFirType()==HomeEnum.CHX.getIndex()){
            homeOldmanModel.setIsService((homeOldman.getIsService()==null || homeOldman.getIsService()==0)?"未获得":"已获得");
        }else{
            homeOldmanModel.setTimeIn(Tool.dateToString(homeOldman.getTimeIn(),"yyyy-MM-dd"));
            homeOldmanModel.setTimeOut(Tool.dateToString(homeOldman.getTimeOut(),"yyyy-MM-dd"));
        }
        homeOldmanModel.setTime(Tool.dateToString(homeOldman.getTime(),"yyyy-MM-dd"));
        homeOldmanModel.setOrgan(homeOldman.getOrgan());
        return homeOldmanModel;
    }

    @Override
    public HomeOldman unwrap(HomeOldmanRequest homeOldmanRequest) {
        HomeOldman homeOldman=new HomeOldman();
        BeanUtils.copyProperties(homeOldmanRequest,homeOldman);
        homeOldman.setOldStatus(3);
        return homeOldman;
    }


}
