package com.organOld.web.controller;

import com.organOld.dao.entity.AutoValue;
import com.organOld.outService.contract.AutoValueRequest;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.Result;
import com.organOld.outService.enumModel.AutoValueEnum;
import com.organOld.outService.service.AutoValueService;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/autoValue")
public class AutoVolueController {

    @Autowired
    AutoValueService autoValueService;
    @Autowired
    OrganService organService;
    @Autowired
    CommonService commonService;

    @RequestMapping(value = "/{type}",method = RequestMethod.GET)
    public ModelAndView index(@PathVariable int type){
        ModelAndView mv=new ModelAndView("oldman/auto_value");
        mv.addObject("type",type);
        mv.addObject("typeName", AutoValueEnum.getValue(type));
        mv.addObject("autoValue",AutoValueEnum.values());
        if(type==2){
            Integer organId=commonService.getIdBySession();
            if (organId==null || organId==0)
                mv.addObject("jw",organService.getByType(2));
            else
                mv.addObject("organId",organId);
        }
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(AutoValueRequest autoValueRequest, BTableRequest bTableRequest){
        return autoValueService.getByPage(autoValueRequest,bTableRequest);
    }


    @ResponseBody
    @RequestMapping(value = "/{id}/getById",method = RequestMethod.GET)
    public Result getById(@PathVariable int id){
        return autoValueService.getById(id);
    }

    @RequestMapping(value = "/{typeId}/{typeHandle}",method = RequestMethod.POST)
    public ModelAndView handle(@PathVariable String typeHandle, @PathVariable int typeId, AutoValue autoValue){
        ModelAndView mv=new ModelAndView("redirect:/autoValue/"+typeId);
        autoValue.setType(typeId);
        autoValueService.handle(typeHandle,autoValue);
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Result del(@RequestParam("ids[]") String ids[]){
        try {
            autoValueService.delByIds(ids);
            return new Result(true);
        }catch (Exception e)
        {
            return new Result(false);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/select/s/getXqByJwIds",method = RequestMethod.POST)
    public Result getXq(@RequestParam(value = "jwIds[]",required = false) String[] jwIds){
        return autoValueService.getXqByJwIds(jwIds);
    }

    @ResponseBody
    @RequestMapping(value = "/select/s/getXqByPqIds",method = RequestMethod.POST)
    public Result getXqPq(@RequestParam(value = "pqIds[]",required = false) String[] pqIds){
        return autoValueService.getXqByPqIds(pqIds);
    }
}
