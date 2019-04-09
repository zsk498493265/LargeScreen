package com.organOld.outService.wrapper;

import com.organOld.dao.entity.SysUser;
import com.organOld.outService.constant.TimeConstant;
import com.organOld.outService.contract.UserRequest;
import com.organOld.outService.model.UserModel;
import com.organOld.outService.tool.Tool;
import org.springframework.stereotype.Service;

@Service
public class UserWrapper implements Wrapper<SysUser,UserModel,UserRequest> {

    @Override
    public UserModel wrap(SysUser sysUser) {
        UserModel userModel=new UserModel();
        userModel.setId(sysUser.getId());
        userModel.setPassword(sysUser.getPassword());
        userModel.setUsername(sysUser.getUsername());
        userModel.setRoleDesc(sysUser.getDesc());
        userModel.setOrganName(sysUser.getOrganName());
        userModel.setTime(Tool.dateToString(sysUser.getTime(), TimeConstant.DATA_FORMAT_YMD));
        userModel.setStatus((sysUser.getDisable()==0)?"正常":"禁用");
        return userModel;
    }

    @Override
    public SysUser unwrap(UserRequest userRequest) {
        SysUser sysUser=new SysUser();
        sysUser.setRoleId(userRequest.getRole());
        sysUser.setSearch(userRequest.getSearch());
        sysUser.setDisable(userRequest.getDisable());
        return sysUser;
    }
}
