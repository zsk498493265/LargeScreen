package com.organOld.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.organOld.visualService.service.model.OldmanService;
import com.organOld.visualService.service.model.Result;
import com.organOld.visualService.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.organOld.visualService.util.Tool.*;

/**
 * 可视化 数据
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/visual/data")
public class OrganInfoController {
    @Autowired
    OldmanService oldmanService;
    @ResponseBody
    @RequestMapping(value = "/getOrganInfo",method = RequestMethod.GET)
    public Result admin_getOldNum1(){

        List<Map<String,String>> dataMap=oldmanService.getOrganInfo();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("InfoGuMeiPianQu",dataMap.get(0).get("InfoGuMeiPianQu"));
        jsonObject.put("InfoGuLongPianQu",dataMap.get(0).get("InfoPingNanPianQu"));
        jsonObject.put("InfoPingNanPianQu",dataMap.get(0).get("InfoPingNanPianQu"));
        jsonObject.put("InfoPingJiPianQu",dataMap.get(0).get("InfoPingJiPianQu"));
        jsonObject.put("InfoPingYangPianQu",dataMap.get(0).get("InfoPingYangPianQu"));
        jsonObject.put("InfoLianHuaJingLaoYuan",dataMap.get(0).get("InfoLianHuaJingLaoYuan"));
        jsonObject.put("InfoGuMeiJingLaoYuan",dataMap.get(0).get("InfoGuMeiJingLaoYuan"));
        jsonObject.put("InfoPingYangJingLaoYuan",dataMap.get(0).get("InfoPingYangJingLaoYuan"));
        jsonObject.put("InfoLeJianZhangZheZhaoHuZhiJia",dataMap.get(0).get("InfoLeJianZhangZheZhaoHuZhiJia"));
        jsonObject.put("InfoAiWeiKangZhangZheZhaoHuZhiJia",dataMap.get(0).get("InfoAiWeiKangZhangZheZhaoHuZhiJia"));
        jsonObject.put("InfoZhiHuiFangZhangZheZhaoHuZhiJia",dataMap.get(0).get("InfoZhiHuiFangZhangZheZhaoHuZhiJia"));
        jsonObject.put("InfoDongLanYiJu",dataMap.get(0).get("InfoDongLanYiJu"));
        jsonObject.put("InfoGuLongYiJu",dataMap.get(0).get("InfoGuLongYiJu"));
        jsonObject.put("InfoGuMeiYiCun",dataMap.get(0).get("InfoGuMeiYiCun"));
        jsonObject.put("InfoGuLongErJu",dataMap.get(0).get("InfoGuLongErJu"));
        jsonObject.put("InfoGuLongSanJu",dataMap.get(0).get("InfoGuLongSanJu"));
        jsonObject.put("InfoDongLanSanJu",dataMap.get(0).get("InfoDongLanSanJu"));
        jsonObject.put("InfoDongLanSiJu",dataMap.get(0).get("InfoDongLanSiJu"));
        jsonObject.put("InfoPingJiSanCun",dataMap.get(0).get("InfoPingJiSanCun"));
        jsonObject.put("InfoGuLongLiuJu",dataMap.get(0).get("InfoGuLongLiuJu"));
        jsonObject.put("InfoGuMeiJiuCun",dataMap.get(0).get("InfoGuMeiJiuCun"));
        jsonObject.put("InfoGuMeiQiCun",dataMap.get(0).get("InfoGuMeiQiCun"));
        jsonObject.put("InfoHuaMeiHuaYuan",dataMap.get(0).get("InfoHuaMeiHuaYuan"));
        jsonObject.put("InfoMeiLianYuan",dataMap.get(0).get("InfoMeiLianYuan"));
        jsonObject.put("InfoPingYangErCun",dataMap.get(0).get("InfoPingYangErCun"));
        jsonObject.put("InfoPingYangSanCun",dataMap.get(0).get("InfoPingYangSanCun"));
        jsonObject.put("InfoWanYuanSiJu",dataMap.get(0).get("InfoWanYuanSiJu"));
        jsonObject.put("InfoWanYuanYiJu",dataMap.get(0).get("InfoWanYuanYiJu"));
        jsonObject.put("InfoDongLanErJu",dataMap.get(0).get("InfoDongLanErJu"));
        jsonObject.put("InfoPingJiSiCun",dataMap.get(0).get("InfoPingJiSiCun"));
        jsonObject.put("InfoGuLongSiJu",dataMap.get(0).get("InfoGuLongSiJu"));
        jsonObject.put("InfoGuMeiBaCun",dataMap.get(0).get("InfoGuMeiBaCun"));
        jsonObject.put("InfoGuMeiSiCun",dataMap.get(0).get("InfoGuMeiSiCun"));
        jsonObject.put("InfoPingNanSanJu",dataMap.get(0).get("InfoPingNanSanJu"));
        jsonObject.put("InfoPingNanYiJu",dataMap.get(0).get("InfoPingNanYiJu"));
        jsonObject.put("InfoPingYangLiuCun",dataMap.get(0).get("InfoPingYangLiuCun"));
        jsonObject.put("InfoPingYangSiCun",dataMap.get(0).get("InfoPingYangSiCun"));
        jsonObject.put("InfoPingYangYiCun",dataMap.get(0).get("InfoPingYangYiCun"));
        jsonObject.put("InfoWanYuanSanJu",dataMap.get(0).get("InfoWanYuanSanJu"));
        jsonObject.put("InfoGuLongWuCun",dataMap.get(0).get("InfoGuLongWuCun"));
        jsonObject.put("InfoPingJiLiuCun",dataMap.get(0).get("InfoPingJiLiuCun"));
        jsonObject.put("InfoHuaYiXinCheng",dataMap.get(0).get("InfoHuaYiXinCheng"));
        jsonObject.put("InfoPingJiErCun",dataMap.get(0).get("InfoPingJiErCun"));
        jsonObject.put("InfoPingJiWuCun",dataMap.get(0).get("InfoPingJiWuCun"));
        jsonObject.put("InfoGuMeiSanCun",dataMap.get(0).get("InfoGuMeiSanCun"));
        jsonObject.put("InfoGuMeiShiCun",dataMap.get(0).get("InfoGuMeiShiCun"));
        jsonObject.put("InfoPingNanErJu",dataMap.get(0).get("InfoPingNanErJu"));
        jsonObject.put("InfoPingYangWuCun",dataMap.get(0).get("InfoPingYangWuCun"));
        jsonObject.put("InfoPingJiYiCun",dataMap.get(0).get("InfoPingJiYiCun"));
        jsonObject.put("InfoWanYuanErJu",dataMap.get(0).get("InfoWanYuanErJu"));
        jsonObject.put("InfoGuMeiLuJieDaoBanShiChu",dataMap.get(0).get("InfoGuMeiLuJieDaoBanShiChu"));

        Result result =new Result(true,jsonObject);
        return result;

    }




}
