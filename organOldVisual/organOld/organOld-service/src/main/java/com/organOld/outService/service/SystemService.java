package com.organOld.outService.service;


import com.organOld.dao.entity.SysRole;
import com.organOld.dao.util.MenuTree;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by netlab606 on 2018/3/25.
 */
public interface SystemService {
    List<MenuTree> getMenu();

    void importExcel(MultipartFile file, String cType, String pType) throws IOException;

    SysRole getRole();

    void appInstall(HttpServletResponse response, HttpServletRequest request);


}
