package com.organOld.web.controller;

import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.SysUser;
import com.organOld.outService.contract.*;
import com.organOld.outService.model.OldmanAllInfoModel;
import com.organOld.outService.contract.Result;
import com.organOld.outService.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 一卡通
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;
    @Autowired
    UserService userService;
    @Autowired
    OldmanService oldmanService;
    @Autowired
    RecordService recordService;
    @Autowired
    CommonService commonService;

    @RequestMapping(value = "/sum",method = RequestMethod.GET)
    public ModelAndView sum(){
        ModelAndView mv=new ModelAndView("card/card_sum");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/sum/data",method = RequestMethod.POST)
    public String sum_data(BTableRequest bTableRequest){
        return cardService.getSumByPage(bTableRequest);
    }


    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView base(){
        ModelAndView mv=new ModelAndView("card/card");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/getById",method = RequestMethod.GET)
    public Result getById(@PathVariable Integer id){
        Result result=cardService.getById(id);
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView update(Card card){
        cardService.updateById(card);
        ModelAndView mv=new ModelAndView("redirect:/card");
        return mv;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView add(Card card){
        cardService.add(card);
        ModelAndView mv=new ModelAndView("redirect:/card");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Result del(@RequestParam("ids[]") String ids[]){
        cardService.delByIds(ids);
        return new Result(true);
    }



    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(CardRequest cardRequest, BTableRequest bTableRequest){
        return cardService.getByPage(cardRequest,bTableRequest);
    }

    @RequestMapping(value = "/{id}/record",method = RequestMethod.GET)
    public ModelAndView record(@PathVariable int id,@RequestParam(value = "type",required = false) Integer type){
        ModelAndView mv=new ModelAndView("card/record");
        mv.addObject("id",id);
        mv.addObject("type",type);
        return mv;
    }

    @RequestMapping(value = "/{oldmanId}/integral/record",method = RequestMethod.GET)
    public ModelAndView record(@PathVariable int oldmanId){
        Integer cid=cardService.getIdByOldmanId(oldmanId);
        ModelAndView mv;
        if(cid==null || cid==0 ){
            mv=new ModelAndView("error/message");
            mv.addObject("message","卡号不存在");
        }else{
            mv=new ModelAndView("redirect:/card/"+cid+"/record?type=9");
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/record/data",method = RequestMethod.POST)
    public String record_data(BTableRequest bTableRequest,CardRecordRequest cardRecordRequest){
        return recordService.getByCardPage(bTableRequest,cardRecordRequest);
    }

    /**
     * 充值
     * @param ids
     * @param money
     * @return
     */
    @ResponseBody
    @RequestMapping( value = "/addMoney",method = RequestMethod.POST)
    public Result addMoney(@RequestParam("ids[]") String ids[],Double money){
        return cardService.addMoney(ids,money);
    }
    @ResponseBody
    @RequestMapping( value = "/changeStatus/{status}",method = RequestMethod.POST)
    public Result changeStatus(@RequestParam("ids[]") String ids[],@PathVariable String status){
        return cardService.changeStatus(ids,status);
    }


    /**
     * 消费
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/consume",method = RequestMethod.GET)
    public Result consume(@RequestParam int cid,@RequestParam int organId,SysUser sysUser,String order,String oldmanPassword,String money){
        try {
            Result check = userService.ckeckOrganLogin(sysUser);
            if (check != null) {
                Result result = cardService.handleConsume(cid, organId, order, oldmanPassword, money);
                return result;
            } else {
                return new Result(false, "没有权限");
            }
        }catch (Exception e){
            return new Result(false,"服务器出错");
        }
    }


    /**
     * 登陆验证  返回具有的权限
     * @param sysUser
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Result login(SysUser sysUser){
        Result result=userService.ckeckOrganLogin(sysUser);
        return result;
    }

    /**
     * 老人信息查询  根据卡号
     * @param cid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/info",method = RequestMethod.POST)

    public Result info(@RequestParam String cid,@RequestParam int organId,SysUser sysUser){
        try {

//        Result check=userService.ckeckOrganLogin(sysUser);
//        if(check!=null){
            Result result = cardService.handleInfo(cid, organId);
            return result;
//        }else{
//            return new Result(false,"没有权限");
//        }
        }catch (Exception e){
            return new Result(false,"服务器出错");
        }
    }


    /**
     * 积分查询
     * type 0 查询 1 兑换
     * minus 减的积分
     * @param cid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/integral",method = RequestMethod.POST)
    public Result integral(@RequestParam int type,@RequestParam int minus,
                           @RequestParam String cid,@RequestParam int organId){
        try {
//        Result check=userService.ckeckOrganLogin(sysUser);
//        if(check!=null) {
            if (commonService.checkAuth("integral")) {
                Result result = cardService.handleIntegral(cid, organId, type, minus);
                return result;
            } else {
                return new Result(false, "没有权限");
            }
        }catch (Exception e){
            return new Result(false,"服务器出错");
        }
    }


    /**
     * 签到
     * @param type  0 日常签到  1活动签到
     * @param peopleType 1 活动参与者 2活动组织 3其他
     * @param name 活动名称
     * @param hdType 活动的类型 老有所养。。。  auto_value表
     * @param cid 卡号
     * @param organId  机构Id
     * @param hdTime 活动时间
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sign",method = RequestMethod.POST)
    public Result sign(@RequestParam int type,@RequestParam int peopleType,@RequestParam String name,
                       @RequestParam String hdTime,@RequestParam int hdType,@RequestParam String cid,@RequestParam int organId){
            try {
//        Result check=userService.ckeckOrganLogin(sysUser);
//        if(check!=null) {
                Result result = cardService.handleSign(cid, organId, type, peopleType, name, hdType, hdTime);
                return result;
//        }else{
//            return new Result(false,"没有权限");
//        }
            }catch (Exception e){
                return new Result(false,"服务器出错");
            }
    }



    /**
     * 生成二维码 压缩包
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void create_zip(@RequestParam("id") String ids[], HttpServletResponse response, HttpServletRequest request){
        cardService.createZip(ids,response,request);
    }

    /**
     * 激活
     * @param cid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/jh",method = RequestMethod.GET)
    public Result jh(@RequestParam String cid){
        try {
//        Result check=userService.ckeckOrganLogin(sysUser);
//        if(check!=null){
            Result result = cardService.handleJh(cid);
            return result;
//        }else{
//            return new Result(false,"没有权限");
//        }
        }catch (Exception e){
            return new Result(false,"服务器出错");
        }
    }
}
