package com.organOld.web.controller;


import com.organOld.outService.constant.SysVar;
import com.organOld.outService.contract.ExportTableThRequest;
import com.organOld.outService.enumModel.TotalTitleEnum;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.MessageService;
import com.organOld.outService.service.OrganService;
import com.organOld.outService.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by netlab606 on 2018/3/24.
 */
@Controller
public class SystemController {

    @Autowired
    SystemService systemService;
    @Autowired
    MessageService messageService;
    @Autowired
    OrganService organService;
    @Autowired
    CommonService commonService;
    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView home(@RequestParam(value = "url",required = false)String url,
                             @RequestParam(value = "title",required = false)Integer title) throws UnsupportedEncodingException {
        try {
            ModelAndView mv = new ModelAndView("home");
            mv.addObject("username", commonService.getUserNameBySession());
            mv.addObject("menus", systemService.getMenu());
            mv.addObject("messageNum", messageService.getNoReadNum());
            mv.addObject("url", url);
            mv.addObject("roleDesc", systemService.getRole().getDesc());
            mv.addObject("organ", organService.getByUserName(commonService.getUserNameBySession()));
            ;
            if (title != null && title != 0)
                mv.addObject("title", TotalTitleEnum.getValue(title));
            return mv;
        }catch (Exception e){
            ModelAndView mv = new ModelAndView("login");
            mv.addObject("message","登陆超时");
            return mv;
        }
    }


    /**
     * 导入 Excel表格
     * @param file
     * @param cType
     * @param pType
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/importExcel",method = RequestMethod.POST)
    public ModelAndView importExcel(@RequestParam MultipartFile file,String cType,String pType) throws IOException {
        ModelAndView mv=new ModelAndView("redirect:/oldman/base");
        systemService.importExcel(file,cType,pType);
        return mv;
    }


    @RequestMapping(value = "/var/edit",method = RequestMethod.POST)
    public ModelAndView var_edit(@RequestParam Long sumPeople){
        SysVar.SUM_PEOPLE=sumPeople;
        ModelAndView mv=new ModelAndView("redirect:/var");
        return mv;
    }
    @RequestMapping(value = "/var",method = RequestMethod.GET)
    public ModelAndView var(){
        ModelAndView mv=new ModelAndView("sys/var");
        mv.addObject("numPeople",SysVar.SUM_PEOPLE);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/app/install", method = RequestMethod.POST)
    public void export(HttpServletResponse response, HttpServletRequest request) {
        systemService.appInstall(response,request);
    }

    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public ModelAndView APP() {
        ModelAndView mv=new ModelAndView("app");
        return mv;
    }

}
