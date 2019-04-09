package com.organOld.web.controller;

import com.organOld.dao.entity.AutoValue;
import com.organOld.outService.contract.*;
import com.organOld.outService.enumModel.AutoValueEnum;
import com.organOld.outService.enumModel.RecordTypeEnum;
import com.organOld.outService.contract.Result;
import com.organOld.outService.service.AutoValueService;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.OrganService;
import com.organOld.outService.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;
    @Autowired
    OrganService organService;
    @Autowired
    CommonService commonService;
    @Autowired
    AutoValueService autoValueService;

    /**
     *type  看RecordTypeEnum
     * organId 有值不为0 表示从管理页面过来
     * @return
     */

    @RequestMapping(value = "/{type}",method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(required = false) Integer organId, @PathVariable int type){
        ModelAndView mv;
        Boolean result=organService.checkHaveAuthByAuthType(type,organId);
        if(organId==null || organId==0)
            organId=commonService.getIdBySession();
        if(result) {
            mv = new ModelAndView("record/record");
            mv.addObject("organId", organId);
            mv.addObject("type", type);
            mv.addObject("typeDesc", RecordTypeEnum.getValue(type));
            mv.addObject("organs",organService.getOrganByAuthType(type));
            if(type==1){
                mv.addObject("moneySum",recordService.getMoneySum(null,null,organId));
            }
//            if(type==2){
//                mv.addObject("hdType",autoValueService.getByType(AutoValueEnum.YJBQ.getIndex()));
//            }
        }else{
            //没有权限
            mv = new ModelAndView("error/message");
            mv.addObject("message","抱歉！您没有权限");
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/getMoneySum",method = RequestMethod.GET)
    public Result getMoneySum(String start, String end, Integer organId){
        Result result=recordService.getMoneySum(start,end,organId);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(RecordRequest recordRequest, BTableRequest bTableRequest,@RequestParam(value = "organ[]",required = false) String[] organIds){
        recordRequest.setOrganIds(organIds);
        return recordService.getByPage(recordRequest,bTableRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public void export(HttpServletResponse response, RecordRequest recordRequest,@RequestParam(value = "organ[]",required = false) String[] organIds){
        recordRequest.setOrganIds(organIds);
        recordService.export(response,recordRequest);
    }
    @ResponseBody
    @RequestMapping(value = "/sign/getHdNameLike",method = RequestMethod.POST)
    public Result getHdNameLike(String name){
        return recordService.getHdNameLike(name);
    }
}
