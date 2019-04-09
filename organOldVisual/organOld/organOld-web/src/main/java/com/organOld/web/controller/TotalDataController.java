package com.organOld.web.controller;

import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.organ.OrganOldman;
import com.organOld.dao.repository.*;
import com.organOld.outService.contract.Result;
import com.organOld.outService.service.*;
import com.organOld.outService.tool.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * 汇总导览 数据
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/total/data")
public class TotalDataController {

    @Autowired
    TotalDataService totalDataService;
    @Autowired
    MessageService messageService;
    @Autowired
    SystemService systemService;
    @Autowired
    CommonService commonService;
    @Autowired
    OrganService organService;

    @Transactional
    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv = null;
        try {
            String role = totalDataService.getRoleBySession();
            if (role.equals("admin") || role.equals("pq") || role.equals("jw")) {
                mv = new ModelAndView("total/out");
                mv.addObject("username", commonService.getUserNameBySession());
                mv.addObject("role", role);
                mv.addObject("roleDesc", systemService.getRole().getDesc());
                mv.addObject("num", totalDataService.getNum(role));
                mv.addObject("organ", organService.getByUserName(commonService.getUserNameBySession()));
            } else {
                mv = new ModelAndView("redirect:/");
            }
        }catch (Exception e){
            e.printStackTrace();
            mv = new ModelAndView("redirect:/login");
        }
        return mv;

    }

    @ResponseBody
    @RequestMapping(value = "/getOldStatus",method = RequestMethod.GET)
    public Result getOldStatus(){
        Result result=null;
        try {
            result=totalDataService.getOldStatus();
        }catch (Exception e){
            result=new Result(false);
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/getIntegralSort",method = RequestMethod.GET)
    public Result getIntegralSort(){
        Result result=null;
        try {
            result=totalDataService.getIntegralSort();
        }catch (Exception e){
            result=new Result(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getOldmanNum",method = RequestMethod.GET)
    public Result getOldmanNum(){
        Result result=null;
        try {
            result=totalDataService.getOldmanNum();
        }catch (Exception e){
            result=new Result(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getHealthNum",method = RequestMethod.GET)
    public Result getHealthNum(){
        Result result=null;
        try {
            result=totalDataService.getHealthNum();
        }catch (Exception e){
            result=new Result(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getKeyNum",method = RequestMethod.GET)
    public Result getKeyNum(){
        Result result=null;
        try {
            result=totalDataService.getKeyNum();
        }catch (Exception e){
            result=new Result(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getOrganNum",method = RequestMethod.GET)
    public Result getOrganNum(){
        Result result=null;
        try {
            result=totalDataService.getOrganNum();
        }catch (Exception e){
            result=new Result(false);
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/getOrganBedNum",method = RequestMethod.GET)
    public Result getOrganBedNum(){
        Result result=null;
        try {
            result=totalDataService.getOrganBedNum();
        }catch (Exception e){
            result=new Result(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getOrganOldmanHisNum",method = RequestMethod.GET)
    public Result getOrganOldmanNum(){
        Result result=null;
        try {
            result=totalDataService.getOrganOldmanHisNum();
        }catch (Exception e){
            result=new Result(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getOrganOldmanNum",method = RequestMethod.GET)
    public Result getOrganOldmanInOutNum(){
        Result result=null;
        try {
            result=totalDataService.getOrganOldmanNum();
        }catch (Exception e){
            result=new Result(false);
        }
        return result;
    }


}
