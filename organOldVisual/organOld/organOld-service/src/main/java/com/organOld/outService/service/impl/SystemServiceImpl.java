package com.organOld.outService.service.impl;

import com.organOld.dao.entity.SysRole;
import com.organOld.dao.repository.MenuDao;
import com.organOld.dao.repository.SystemDao;
import com.organOld.dao.repository.UserDao;
import com.organOld.dao.util.MenuTree;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.SystemService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by netlab606 on 2018/3/25.
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    MenuDao menuDao;
    @Autowired
    SystemDao systemDao;
    @Autowired
    CommonService commonService;
    @Autowired
    UserDao userDao;

    @Override
    public List<MenuTree> getMenu() {
        UserDetails userDetails;
        List<String> authNameList=new ArrayList<>();
        try{
            if(SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal()!=null) {
                userDetails = (UserDetails) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();
                for (GrantedAuthority authority:userDetails.getAuthorities()) {
                    authNameList.add(authority.toString());
                }
            }
        }catch (Exception e){

        }finally {
            if(authNameList.size()==0)
                return new ArrayList<>();
            return menuDao.getMenuTreeByAuthentications(authNameList);
        }
    }

    @Override
    public void importExcel(MultipartFile file, String cType, String pType) throws IOException {
        List temp = new ArrayList();
        Workbook wb0 = new HSSFWorkbook(file.getInputStream());
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        //对Sheet中的每一行进行迭代
        for (Row r : sht0) {
            //如果当前行的行号（从0开始）未达到1（第二行）则从新循环
            if (r.getRowNum() == 0) {
                continue;
            }
            //创建实体类
//            if(pType.equals("oldman")){
//                Oldman oldman=new Oldman();
//                oldman.setName(r.getCell(0).getStringCellValue());
//                oldman.setSex((r.getCell(1).getStringCellValue().equals("男"))?"1":"0");
//                temp.add(oldman);
//            }
        }
        systemDao.importExcel(temp,cType,pType);
    }


    @Override
    public SysRole getRole() {
        return userDao.getRoleByUserName(commonService.getUserNameBySession());
    }

    @Override
    public void appInstall(HttpServletResponse response, HttpServletRequest request) {
        try {
            commonService.setResponseHeader(response, "app-android.apk");
                response.setHeader("Content-Type", "application/octet-stream");
                response.addHeader("Content-Disposition", "attachment;filename="
                        + "app-android.apk");

            Resource resource = new ClassPathResource("app.apk");
            InputStream in = new FileInputStream(resource.getFile());
            response.addHeader("Content-Length", "" + in.available());
                     int len = 0;
                     //5.创建数据缓冲区
                     byte[] buffer = new byte[1024];
                     //6.通过response对象获取OutputStream流
                     OutputStream out = response.getOutputStream();
                     //7.将FileInputStream流写入到buffer缓冲区
                     while ((len = in.read(buffer)) > 0) {
                        //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
                         out.write(buffer,0,len);
           }

            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
