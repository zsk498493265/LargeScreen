package com.organOld.outService.wrapper;

import com.organOld.dao.entity.home.Home;
import com.organOld.outService.constant.TimeConstant;
import com.organOld.outService.contract.HomeRequest;
import com.organOld.outService.model.HomeModel;
import com.organOld.outService.tool.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class HomeWrapper implements Wrapper<Home,HomeModel,HomeRequest> {


    @Override
    public HomeModel wrap(Home home) {
        HomeModel homeModel=new HomeModel();
        homeModel.setId(home.getId());
        homeModel.setSecType(home.getSecType());
        homeModel.setTime(Tool.dateToString(home.getTime(), TimeConstant.DATA_FORMAT_YMD));
        if (home.getChx()!=null){
            homeModel.setLevel(home.getChx().getLevel());
            homeModel.setServiceTime(home.getChx().getServiceTime());
        }
        if(home.getDoctor()!=null){
            homeModel.setDoctorName(home.getDoctor().getName());
        }
        if(home.getOrgan()!=null){
            homeModel.setOrganName(home.getOrgan().getName());
        }
        homeModel.setOrgan(home.getOrgan());
        return homeModel;
    }

    @Override
    public Home unwrap(HomeRequest homeRequest) {
        Home home=new Home();
        BeanUtils.copyProperties(homeRequest,home);
        return home;
    }
}
