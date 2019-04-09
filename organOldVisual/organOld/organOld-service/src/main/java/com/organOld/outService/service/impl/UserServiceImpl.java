package com.organOld.outService.service.impl;

import com.organOld.dao.entity.SysAuthority;
import com.organOld.dao.entity.SysRole;
import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.repository.UserDao;
import com.organOld.dao.entity.SysUser;
import com.organOld.dao.util.Page;
import com.organOld.outService.contract.*;
import com.organOld.outService.model.OrganAuth;
import com.organOld.outService.contract.Result;
import com.organOld.outService.model.UserModel;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.UserService;
import com.organOld.outService.wrapper.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by netlab606 on 2018/4/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    CommonService commonService;
    @Autowired
    OrganDao organDao;
    @Autowired
    UserWrapper userWrapper;


    @Override
    public SysUser getByUsername(String username) {
        SysUser s=userDao.getByUsername(username);
        return s;
    }

    /**
     * 根据用户名获取到用户的权限并封装成GrantedAuthority集合
     * @param username
     */
    @Override
    public Collection<GrantedAuthority> loadUserAuthorities(String username) {
        List<SysAuthority> list = userDao.getSysAuthoritiesByUsername(username);

        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

        for (SysAuthority authority : list) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuName());
            auths.add(grantedAuthority);
        }

        return auths;
    }


    @Override
    public void save(SysUser user) {
        userDao.save(user);
    }

    @Override
    public void setUserRole(int id, int i) {
        userDao.setUserRole(id,i);
    }

    @Override
    public void setUserOrgan(int id, int organId) {
        userDao.setUserOrgan(id,organId);
    }


    @Override
    public String getByPage(UserRequest userRequest, BTableRequest bTableRequest) {
        Page<SysUser> page=commonService.getPage(bTableRequest,"user");
        SysUser sysUser= userWrapper.unwrap(userRequest);
        page.setEntity(sysUser);
        List<UserModel> userModelList=userDao.getByPage(page).stream().map( userWrapper::wrap).collect(Collectors.toList());
        Long size=userDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,userModelList);
    }


    @Override
    public List<SysRole> getAllRole() {
        return userDao.getAllRole();
    }


    @Override
    @Transactional

    public void save(UserAddRequest userAddRequest) {
        SysUser sysUser=new SysUser();
        sysUser.setUsername(userAddRequest.getUsername());
        sysUser.setPassword(userAddRequest.getPassword());
        userDao.save(sysUser);
        if(userAddRequest.getOrganId()!=null && !userAddRequest.getOrganId().equals(""))
            userDao.setUserOrgan(sysUser.getId(),userAddRequest.getOrganId());
        userDao.setUserRole(sysUser.getId(),Integer.parseInt(userAddRequest.getRoleId()));
        // 更新organ 的权限
        if(userAddRequest.getOrganId()!=null && userAddRequest.getOrganId()!=0) {
            Organ organ = authSet(userAddRequest);
            organDao.updateById(organ);
        }
    }

    private Organ authSet(UserAddRequest userAddRequest) {
        Organ organ=new Organ();
        organ.setId(userAddRequest.getOrganId());
        if(userAddRequest.getAuth()!=null && userAddRequest.getAuth().length>0){
            List<String> auths= Arrays.asList(userAddRequest.getAuth());
            if(auths.contains("sign"))organ.setAuthSign(1);else organ.setAuthSign(0);
            if(auths.contains("product"))organ.setAuthProduct(1);else organ.setAuthProduct(0);
            if(auths.contains("consume"))organ.setAuthConsume(1);else organ.setAuthConsume(0);
            if(auths.contains("info"))organ.setAuthQueryInfo(1);else organ.setAuthQueryInfo(0);
            if(auths.contains("integral"))organ.setAuthQueryIntegral(1);else organ.setAuthQueryIntegral(0);
        }else{
            organ.setAuthSign(0);
            organ.setAuthProduct(0);
            organ.setAuthConsume(0);
            organ.setAuthQueryInfo(0);
            organ.setAuthQueryIntegral(0);
        }
        return organ;
    }

    @Override
    public Result ckeckOrganLogin(SysUser sysUser) {
        Organ organ=userDao.ckeckOrganLogin(sysUser);
        if(organ==null) {
            return new Result(false, "账号密码错误");
        }else{
            OrganAuth organAuth=new OrganAuth();
            organAuth.setOrganId(organ.getId());
            organAuth.setAuthConsume(organ.getAuthConsume());
            organAuth.setAuthSign(organ.getAuthSign());
            organAuth.setAuthQueryInfo(organ.getAuthQueryInfo());
            organAuth.setAuthQueryIntegral(organ.getAuthQueryIntegral());
            return new Result(true, organAuth);
        }
    }

    @Override
    public void delByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        userDao.delByIds(id);
    }

    @Override
    public void unDelByIds(String[] ids) {
        userDao.updateProps("disable","0",ids);
    }

    @Override
    public Result getById(int id) {
        return new Result(true,userDao.getById(id));
    }

    @Override
    @Transactional
    public void update(UserAddRequest userAddRequest) {
        SysUser sysUser=new SysUser();
        sysUser.setId(userAddRequest.getId());
        sysUser.setUsername(userAddRequest.getUsername());
        sysUser.setPassword(userAddRequest.getPassword());
        sysUser.setRoleId(Integer.parseInt(userAddRequest.getRoleId()));
        sysUser.setOrganId(userAddRequest.getOrganId());
        if(userAddRequest.getAuth()!=null && userAddRequest.getAuth().length>0){
            List<String> auths= Arrays.asList(userAddRequest.getAuth());
            if(auths.contains("sign"))sysUser.setAuthSign(1);else sysUser.setAuthSign(0);
            if(auths.contains("product"))sysUser.setAuthProduct(1);else sysUser.setAuthProduct(0);
            if(auths.contains("consume"))sysUser.setAuthConsume(1);else sysUser.setAuthConsume(0);
            if(auths.contains("info"))sysUser.setAuthQueryInfo(1);else sysUser.setAuthQueryInfo(0);
            if(auths.contains("integral"))sysUser.setAuthQueryIntegral(1);else sysUser.setAuthQueryIntegral(0);
        }else{
            sysUser.setAuthSign(0);
            sysUser.setAuthProduct(0);
            sysUser.setAuthConsume(0);
            sysUser.setAuthQueryInfo(0);
            sysUser.setAuthQueryIntegral(0);
        }
        userDao.updateById(sysUser);
        organDao.updateAuth(sysUser.getOrganId(),sysUser.getAuthConsume(),sysUser.getAuthProduct(),sysUser.getAuthSign(),sysUser.getAuthQueryInfo(),sysUser.getAuthQueryIntegral());
    }

    @Override
    public SysUser getBySession() {
        SysUser user=null;
            Integer organId=commonService.getIdBySession();
        if(organId==null || organId==0){
            user=userDao.getByUsername(commonService.getUserNameBySession());
        }else {
            user = userDao.getByOrganId(organId);
        }
        return user;
    }

    @Override
    public void updatePassowrd(SysUser sysUser) {
        userDao.updateProp("password",sysUser.getPassword(),sysUser.getId());
    }

    @Override
    public Result check(SysUser user) {
        if(commonService.checkAddUser(user.getPassword())){
            SysUser sysUser_exist=userDao.getByUsername(user.getUsername());
            if(sysUser_exist==null || sysUser_exist.getUsername().equals(user.getUsername())){
                Integer id_other=null;
                if(user.getOrganId()!=null && user.getOrganId()!=0) {
                    id_other = userDao.checkOrganIdHasAcoount(user.getOrganId());
                }
                if(id_other==null || id_other==user.getId()){
                    return new Result(true);
                }else{
                    return new Result(false,"该机构已有账号");
                }
            }else{
                return new Result(false,"用户名已存在");
            }
        }else{
            return new Result(false,"密码只能由6-18位大小写字母、数字和特殊符号组成");
        }
    }
}
