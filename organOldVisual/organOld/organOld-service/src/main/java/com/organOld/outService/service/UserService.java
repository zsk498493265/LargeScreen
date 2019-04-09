package com.organOld.outService.service;

import com.organOld.dao.entity.SysRole;
import com.organOld.dao.entity.SysUser;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.Result;
import com.organOld.outService.contract.UserAddRequest;
import com.organOld.outService.contract.UserRequest;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * Created by netlab606 on 2018/4/8.
 */
public interface UserService {
    SysUser getByUsername(String username);

    Collection<GrantedAuthority> loadUserAuthorities(String username);

    void setUserRole(int id, int i);

    void setUserOrgan(int id, int organId);

    void save(SysUser user);

    String getByPage(UserRequest userRequest, BTableRequest bTableRequest);

    List<SysRole> getAllRole();


    void save(UserAddRequest userAddRequest);

    Result ckeckOrganLogin(SysUser sysUser);

    void delByIds(String[] ids);

    Result getById(int id);

    void update(UserAddRequest sysUser);

    SysUser getBySession();

    void updatePassowrd(SysUser sysUser);

    void unDelByIds(String[] ids);

    Result check(SysUser user);
}
