package com.organOld.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.organOld.visualService.service.model.OldmanService;
import com.organOld.visualService.service.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import static com.organOld.visualService.util.Tool.AgeTobirthday;
import static com.organOld.visualService.util.Tool.getNowYearAndMonth;
import static com.organOld.web.controller.VisualDataController2.add_code;

/**
 * 可视化 数据
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/visual/data")
public class VisualData2Controller {
    @Autowired
    OldmanService oldmanService;
    @ResponseBody
    @RequestMapping(value = "/getVisualData2",method = RequestMethod.GET)
    public Result admin_getOldNum2(){
        String str1=getNowYearAndMonth();
        List<Map<String,Long>> dataMap=oldmanService.getVisualData2(AgeTobirthday(60),AgeTobirthday(70),AgeTobirthday(80),AgeTobirthday(90),str1);
        //String s=AgeTobirthday(80).toString();

        JSONObject jsonObject = new JSONObject();
        //part fenge

        //pingyang
        jsonObject.put("NumPingYangZhuCanAndHuJi",dataMap.get(0).get("NumPingYangZhuCanAndHuJi"));
        jsonObject.put("NumPingYangZhuCanAndFeiHuJi",dataMap.get(0).get("NumPingYangZhuCanAndFeiHuJi"));
        jsonObject.put("NumPingYangZhuCanAndMale",dataMap.get(0).get("NumPingYangZhuCanAndMale"));
        jsonObject.put("NumPingYangZhuCanAndFemale",dataMap.get(0).get("NumPingYangZhuCanAndFemale"));
        jsonObject.put("NumPingYangZhuCanAnd60To70M",dataMap.get(0).get("NumPingYangZhuCanAnd60To70M"));
        jsonObject.put("NumPingYangZhuCanAnd70To80M",dataMap.get(0).get("NumPingYangZhuCanAnd70To80M"));
        jsonObject.put("NumPingYangZhuCanAnd80To90M",dataMap.get(0).get("NumPingYangZhuCanAnd80To90M"));
        jsonObject.put("NumPingYangZhuCanAnd90AboveM",dataMap.get(0).get("NumPingYangZhuCanAnd90AboveM"));
        jsonObject.put("NumPingYangZhuCanAnd60To70F",dataMap.get(0).get("NumPingYangZhuCanAnd60To70F"));
        jsonObject.put("NumPingYangZhuCanAnd70To80F",dataMap.get(0).get("NumPingYangZhuCanAnd70To80F"));
        jsonObject.put("NumPingYangZhuCanAnd80To90F",dataMap.get(0).get("NumPingYangZhuCanAnd80To90F"));
        jsonObject.put("NumPingYangZhuCanAnd90AboveF",dataMap.get(0).get("NumPingYangZhuCanAnd90AboveF"));

        jsonObject.put("NumPingYangZhuJieAndHuJi",dataMap.get(0).get("NumPingYangZhuJieAndHuJi"));
        jsonObject.put("NumPingYangZhuJieAndFeiHuJi",dataMap.get(0).get("NumPingYangZhuJieAndFeiHuJi"));
        jsonObject.put("NumPingYangZhuJieAndMale",dataMap.get(0).get("NumPingYangZhuJieAndMale"));
        jsonObject.put("NumPingYangZhuJieAndFemale",dataMap.get(0).get("NumPingYangZhuJieAndFemale"));
        jsonObject.put("NumPingYangZhuJieAnd60To70M",dataMap.get(0).get("NumPingYangZhuJieAnd60To70M"));
        jsonObject.put("NumPingYangZhuJieAnd70To80M",dataMap.get(0).get("NumPingYangZhuJieAnd70To80M"));
        jsonObject.put("NumPingYangZhuJieAnd80To90M",dataMap.get(0).get("NumPingYangZhuJieAnd80To90M"));
        jsonObject.put("NumPingYangZhuJieAnd90AboveM",dataMap.get(0).get("NumPingYangZhuJieAnd90AboveM"));
        jsonObject.put("NumPingYangZhuJieAnd60To70F",dataMap.get(0).get("NumPingYangZhuJieAnd60To70F"));
        jsonObject.put("NumPingYangZhuJieAnd70To80F",dataMap.get(0).get("NumPingYangZhuJieAnd70To80F"));
        jsonObject.put("NumPingYangZhuJieAnd80To90F",dataMap.get(0).get("NumPingYangZhuJieAnd80To90F"));
        jsonObject.put("NumPingYangZhuJieAnd90AboveF",dataMap.get(0).get("NumPingYangZhuJieAnd90AboveF"));

        jsonObject.put("NumPingYangZhuYuAndHuJi",dataMap.get(0).get("NumPingYangZhuYuAndHuJi"));
        jsonObject.put("NumPingYangZhuYuAndFeiHuJi",dataMap.get(0).get("NumPingYangZhuYuAndFeiHuJi"));
        jsonObject.put("NumPingYangZhuYuAndMale",dataMap.get(0).get("NumPingYangZhuYuAndMale"));
        jsonObject.put("NumPingYangZhuYuAndFemale",dataMap.get(0).get("NumPingYangZhuYuAndFemale"));
        jsonObject.put("NumPingYangZhuYuAnd60To70M",dataMap.get(0).get("NumPingYangZhuYuAnd60To70M"));
        jsonObject.put("NumPingYangZhuYuAnd70To80M",dataMap.get(0).get("NumPingYangZhuYuAnd70To80M"));
        jsonObject.put("NumPingYangZhuYuAnd80To90M",dataMap.get(0).get("NumPingYangZhuYuAnd80To90M"));
        jsonObject.put("NumPingYangZhuYuAnd90AboveM",dataMap.get(0).get("NumPingYangZhuYuAnd90AboveM"));
        jsonObject.put("NumPingYangZhuYuAnd60To70F",dataMap.get(0).get("NumPingYangZhuYuAnd60To70F"));
        jsonObject.put("NumPingYangZhuYuAnd70To80F",dataMap.get(0).get("NumPingYangZhuYuAnd70To80F"));
        jsonObject.put("NumPingYangZhuYuAnd80To90F",dataMap.get(0).get("NumPingYangZhuYuAnd80To90F"));
        jsonObject.put("NumPingYangZhuYuAnd90AboveF",dataMap.get(0).get("NumPingYangZhuYuAnd90AboveF"));

        jsonObject.put("NumPingYangZhuXingAndHuJi",dataMap.get(0).get("NumPingYangZhuXingAndHuJi"));
        jsonObject.put("NumPingYangZhuXingAndFeiHuJi",dataMap.get(0).get("NumPingYangZhuXingAndFeiHuJi"));
        jsonObject.put("NumPingYangZhuXingAndMale",dataMap.get(0).get("NumPingYangZhuXingAndMale"));
        jsonObject.put("NumPingYangZhuXingAndFemale",dataMap.get(0).get("NumPingYangZhuXingAndFemale"));
        jsonObject.put("NumPingYangZhuXingAnd60To70M",dataMap.get(0).get("NumPingYangZhuXingAnd60To70M"));
        jsonObject.put("NumPingYangZhuXingAnd70To80M",dataMap.get(0).get("NumPingYangZhuXingAnd70To80M"));
        jsonObject.put("NumPingYangZhuXingAnd80To90M",dataMap.get(0).get("NumPingYangZhuXingAnd80To90M"));
        jsonObject.put("NumPingYangZhuXingAnd90AboveM",dataMap.get(0).get("NumPingYangZhuXingAnd90AboveM"));
        jsonObject.put("NumPingYangZhuXingAnd60To70F",dataMap.get(0).get("NumPingYangZhuXingAnd60To70F"));
        jsonObject.put("NumPingYangZhuXingAnd70To80F",dataMap.get(0).get("NumPingYangZhuXingAnd70To80F"));
        jsonObject.put("NumPingYangZhuXingAnd80To90F",dataMap.get(0).get("NumPingYangZhuXingAnd80To90F"));
        jsonObject.put("NumPingYangZhuXingAnd90AboveF",dataMap.get(0).get("NumPingYangZhuXingAnd90AboveF"));

        jsonObject.put("NumPingYangZhuYiAndHuJi",dataMap.get(0).get("NumPingYangZhuYiAndHuJi"));
        jsonObject.put("NumPingYangZhuYiAndFeiHuJi",dataMap.get(0).get("NumPingYangZhuYiAndFeiHuJi"));
        jsonObject.put("NumPingYangZhuYiAndMale",dataMap.get(0).get("NumPingYangZhuYiAndMale"));
        jsonObject.put("NumPingYangZhuYiAndFemale",dataMap.get(0).get("NumPingYangZhuYiAndFemale"));
        jsonObject.put("NumPingYangZhuYiAnd60To70M",dataMap.get(0).get("NumPingYangZhuYiAnd60To70M"));
        jsonObject.put("NumPingYangZhuYiAnd70To80M",dataMap.get(0).get("NumPingYangZhuYiAnd70To80M"));
        jsonObject.put("NumPingYangZhuYiAnd80To90M",dataMap.get(0).get("NumPingYangZhuYiAnd80To90M"));
        jsonObject.put("NumPingYangZhuYiAnd90AboveM",dataMap.get(0).get("NumPingYangZhuYiAnd90AboveM"));
        jsonObject.put("NumPingYangZhuYiAnd60To70F",dataMap.get(0).get("NumPingYangZhuYiAnd60To70F"));
        jsonObject.put("NumPingYangZhuYiAnd70To80F",dataMap.get(0).get("NumPingYangZhuYiAnd70To80F"));
        jsonObject.put("NumPingYangZhuYiAnd80To90F",dataMap.get(0).get("NumPingYangZhuYiAnd80To90F"));
        jsonObject.put("NumPingYangZhuYiAnd90AboveF",dataMap.get(0).get("NumPingYangZhuYiAnd90AboveF"));

        jsonObject.put("NumPingYangXiYiAndHuJi",dataMap.get(0).get("NumPingYangXiYiAndHuJi"));
        jsonObject.put("NumPingYangXiYiAndFeiHuJi",dataMap.get(0).get("NumPingYangXiYiAndFeiHuJi"));
        jsonObject.put("NumPingYangXiYiAndMale",dataMap.get(0).get("NumPingYangXiYiAndMale"));
        jsonObject.put("NumPingYangXiYiAndFemale",dataMap.get(0).get("NumPingYangXiYiAndFemale"));
        jsonObject.put("NumPingYangXiYiAnd60To70M",dataMap.get(0).get("NumPingYangXiYiAnd60To70M"));
        jsonObject.put("NumPingYangXiYiAnd70To80M",dataMap.get(0).get("NumPingYangXiYiAnd70To80M"));
        jsonObject.put("NumPingYangXiYiAnd80To90M",dataMap.get(0).get("NumPingYangXiYiAnd80To90M"));
        jsonObject.put("NumPingYangXiYiAnd90AboveM",dataMap.get(0).get("NumPingYangXiYiAnd90AboveM"));
        jsonObject.put("NumPingYangXiYiAnd60To70F",dataMap.get(0).get("NumPingYangXiYiAnd60To70F"));
        jsonObject.put("NumPingYangXiYiAnd70To80F",dataMap.get(0).get("NumPingYangXiYiAnd70To80F"));
        jsonObject.put("NumPingYangXiYiAnd80To90F",dataMap.get(0).get("NumPingYangXiYiAnd80To90F"));
        jsonObject.put("NumPingYangXiYiAnd90AboveF",dataMap.get(0).get("NumPingYangXiYiAnd90AboveF"));

        jsonObject.put("NumPingYangXiangTanAndHuJi",dataMap.get(0).get("NumPingYangXiangTanAndHuJi"));
        jsonObject.put("NumPingYangXiangTanAndFeiHuJi",dataMap.get(0).get("NumPingYangXiangTanAndFeiHuJi"));
        jsonObject.put("NumPingYangXiangTanAndMale",dataMap.get(0).get("NumPingYangXiangTanAndMale"));
        jsonObject.put("NumPingYangXiangTanAndFemale",dataMap.get(0).get("NumPingYangXiangTanAndFemale"));
        jsonObject.put("NumPingYangXiangTanAnd60To70M",dataMap.get(0).get("NumPingYangXiangTanAnd60To70M"));
        jsonObject.put("NumPingYangXiangTanAnd70To80M",dataMap.get(0).get("NumPingYangXiangTanAnd70To80M"));
        jsonObject.put("NumPingYangXiangTanAnd80To90M",dataMap.get(0).get("NumPingYangXiangTanAnd80To90M"));
        jsonObject.put("NumPingYangXiangTanAnd90AboveM",dataMap.get(0).get("NumPingYangXiangTanAnd90AboveM"));
        jsonObject.put("NumPingYangXiangTanAnd60To70F",dataMap.get(0).get("NumPingYangXiangTanAnd60To70F"));
        jsonObject.put("NumPingYangXiangTanAnd70To80F",dataMap.get(0).get("NumPingYangXiangTanAnd70To80F"));
        jsonObject.put("NumPingYangXiangTanAnd80To90F",dataMap.get(0).get("NumPingYangXiangTanAnd80To90F"));
        jsonObject.put("NumPingYangXiangTanAnd90AboveF",dataMap.get(0).get("NumPingYangXiangTanAnd90AboveF"));

        jsonObject.put("NumPingYangKangFuAndHuJi",dataMap.get(0).get("NumPingYangKangFuAndHuJi"));
        jsonObject.put("NumPingYangKangFuAndFeiHuJi",dataMap.get(0).get("NumPingYangKangFuAndFeiHuJi"));
        jsonObject.put("NumPingYangKangFuAndMale",dataMap.get(0).get("NumPingYangKangFuAndMale"));
        jsonObject.put("NumPingYangKangFuAndFemale",dataMap.get(0).get("NumPingYangKangFuAndFemale"));
        jsonObject.put("NumPingYangKangFuAnd60To70M",dataMap.get(0).get("NumPingYangKangFuAnd60To70M"));
        jsonObject.put("NumPingYangKangFuAnd70To80M",dataMap.get(0).get("NumPingYangKangFuAnd70To80M"));
        jsonObject.put("NumPingYangKangFuAnd80To90M",dataMap.get(0).get("NumPingYangKangFuAnd80To90M"));
        jsonObject.put("NumPingYangKangFuAnd90AboveM",dataMap.get(0).get("NumPingYangKangFuAnd90AboveM"));
        jsonObject.put("NumPingYangKangFuAnd60To70F",dataMap.get(0).get("NumPingYangKangFuAnd60To70F"));
        jsonObject.put("NumPingYangKangFuAnd70To80F",dataMap.get(0).get("NumPingYangKangFuAnd70To80F"));
        jsonObject.put("NumPingYangKangFuAnd80To90F",dataMap.get(0).get("NumPingYangKangFuAnd80To90F"));
        jsonObject.put("NumPingYangKangFuAnd90AboveF",dataMap.get(0).get("NumPingYangKangFuAnd90AboveF"));

        jsonObject.put("NumPingYangShengHuoAndHuJi",dataMap.get(0).get("NumPingYangShengHuoAndHuJi"));
        jsonObject.put("NumPingYangShengHuoAndFeiHuJi",dataMap.get(0).get("NumPingYangShengHuoAndFeiHuJi"));
        jsonObject.put("NumPingYangShengHuoAndMale",dataMap.get(0).get("NumPingYangShengHuoAndMale"));
        jsonObject.put("NumPingYangShengHuoAndFemale",dataMap.get(0).get("NumPingYangShengHuoAndFemale"));
        jsonObject.put("NumPingYangShengHuoAnd60To70M",dataMap.get(0).get("NumPingYangShengHuoAnd60To70M"));
        jsonObject.put("NumPingYangShengHuoAnd70To80M",dataMap.get(0).get("NumPingYangShengHuoAnd70To80M"));
        jsonObject.put("NumPingYangShengHuoAnd80To90M",dataMap.get(0).get("NumPingYangShengHuoAnd80To90M"));
        jsonObject.put("NumPingYangShengHuoAnd90AboveM",dataMap.get(0).get("NumPingYangShengHuoAnd90AboveM"));
        jsonObject.put("NumPingYangShengHuoAnd60To70F",dataMap.get(0).get("NumPingYangShengHuoAnd60To70F"));
        jsonObject.put("NumPingYangShengHuoAnd70To80F",dataMap.get(0).get("NumPingYangShengHuoAnd70To80F"));
        jsonObject.put("NumPingYangShengHuoAnd80To90F",dataMap.get(0).get("NumPingYangShengHuoAnd80To90F"));
        jsonObject.put("NumPingYangShengHuoAnd90AboveF",dataMap.get(0).get("NumPingYangShengHuoAnd90AboveF"));

        jsonObject.put("NumPingYangFuWuQiTaAndHuJi",dataMap.get(0).get("NumPingYangFuWuQiTaAndHuJi"));
        jsonObject.put("NumPingYangFuWuQiTaAndFeiHuJi",dataMap.get(0).get("NumPingYangFuWuQiTaAndFeiHuJi"));
        jsonObject.put("NumPingYangFuWuQiTaAndMale",dataMap.get(0).get("NumPingYangFuWuQiTaAndMale"));
        jsonObject.put("NumPingYangFuWuQiTaAndFemale",dataMap.get(0).get("NumPingYangFuWuQiTaAndFemale"));
        jsonObject.put("NumPingYangFuWuQiTaAnd60To70M",dataMap.get(0).get("NumPingYangFuWuQiTaAnd60To70M"));
        jsonObject.put("NumPingYangFuWuQiTaAnd70To80M",dataMap.get(0).get("NumPingYangFuWuQiTaAnd70To80M"));
        jsonObject.put("NumPingYangFuWuQiTaAnd80To90M",dataMap.get(0).get("NumPingYangFuWuQiTaAnd80To90M"));
        jsonObject.put("NumPingYangFuWuQiTaAnd90AboveM",dataMap.get(0).get("NumPingYangFuWuQiTaAnd90AboveM"));
        jsonObject.put("NumPingYangFuWuQiTaAnd60To70F",dataMap.get(0).get("NumPingYangFuWuQiTaAnd60To70F"));
        jsonObject.put("NumPingYangFuWuQiTaAnd70To80F",dataMap.get(0).get("NumPingYangFuWuQiTaAnd70To80F"));
        jsonObject.put("NumPingYangFuWuQiTaAnd80To90F",dataMap.get(0).get("NumPingYangFuWuQiTaAnd80To90F"));
        jsonObject.put("NumPingYangFuWuQiTaAnd90AboveF",dataMap.get(0).get("NumPingYangFuWuQiTaAnd90AboveF"));

        //pingnan
        jsonObject.put("NumPingNanZhuCanAndHuJi",dataMap.get(0).get("NumPingNanZhuCanAndHuJi"));
        jsonObject.put("NumPingNanZhuCanAndFeiHuJi",dataMap.get(0).get("NumPingNanZhuCanAndFeiHuJi"));
        jsonObject.put("NumPingNanZhuCanAndMale",dataMap.get(0).get("NumPingNanZhuCanAndMale"));
        jsonObject.put("NumPingNanZhuCanAndFemale",dataMap.get(0).get("NumPingNanZhuCanAndFemale"));
        jsonObject.put("NumPingNanZhuCanAnd60To70M",dataMap.get(0).get("NumPingNanZhuCanAnd60To70M"));
        jsonObject.put("NumPingNanZhuCanAnd70To80M",dataMap.get(0).get("NumPingNanZhuCanAnd70To80M"));
        jsonObject.put("NumPingNanZhuCanAnd80To90M",dataMap.get(0).get("NumPingNanZhuCanAnd80To90M"));
        jsonObject.put("NumPingNanZhuCanAnd90AboveM",dataMap.get(0).get("NumPingNanZhuCanAnd90AboveM"));
        jsonObject.put("NumPingNanZhuCanAnd60To70F",dataMap.get(0).get("NumPingNanZhuCanAnd60To70F"));
        jsonObject.put("NumPingNanZhuCanAnd70To80F",dataMap.get(0).get("NumPingNanZhuCanAnd70To80F"));
        jsonObject.put("NumPingNanZhuCanAnd80To90F",dataMap.get(0).get("NumPingNanZhuCanAnd80To90F"));
        jsonObject.put("NumPingNanZhuCanAnd90AboveF",dataMap.get(0).get("NumPingNanZhuCanAnd90AboveF"));

        jsonObject.put("NumPingNanZhuJieAndHuJi",dataMap.get(0).get("NumPingNanZhuJieAndHuJi"));
        jsonObject.put("NumPingNanZhuJieAndFeiHuJi",dataMap.get(0).get("NumPingNanZhuJieAndFeiHuJi"));
        jsonObject.put("NumPingNanZhuJieAndMale",dataMap.get(0).get("NumPingNanZhuJieAndMale"));
        jsonObject.put("NumPingNanZhuJieAndFemale",dataMap.get(0).get("NumPingNanZhuJieAndFemale"));
        jsonObject.put("NumPingNanZhuJieAnd60To70M",dataMap.get(0).get("NumPingNanZhuJieAnd60To70M"));
        jsonObject.put("NumPingNanZhuJieAnd70To80M",dataMap.get(0).get("NumPingNanZhuJieAnd70To80M"));
        jsonObject.put("NumPingNanZhuJieAnd80To90M",dataMap.get(0).get("NumPingNanZhuJieAnd80To90M"));
        jsonObject.put("NumPingNanZhuJieAnd90AboveM",dataMap.get(0).get("NumPingNanZhuJieAnd90AboveM"));
        jsonObject.put("NumPingNanZhuJieAnd60To70F",dataMap.get(0).get("NumPingNanZhuJieAnd60To70F"));
        jsonObject.put("NumPingNanZhuJieAnd70To80F",dataMap.get(0).get("NumPingNanZhuJieAnd70To80F"));
        jsonObject.put("NumPingNanZhuJieAnd80To90F",dataMap.get(0).get("NumPingNanZhuJieAnd80To90F"));
        jsonObject.put("NumPingNanZhuJieAnd90AboveF",dataMap.get(0).get("NumPingNanZhuJieAnd90AboveF"));

        jsonObject.put("NumPingNanZhuYuAndHuJi",dataMap.get(0).get("NumPingNanZhuYuAndHuJi"));
        jsonObject.put("NumPingNanZhuYuAndFeiHuJi",dataMap.get(0).get("NumPingNanZhuYuAndFeiHuJi"));
        jsonObject.put("NumPingNanZhuYuAndMale",dataMap.get(0).get("NumPingNanZhuYuAndMale"));
        jsonObject.put("NumPingNanZhuYuAndFemale",dataMap.get(0).get("NumPingNanZhuYuAndFemale"));
        jsonObject.put("NumPingNanZhuYuAnd60To70M",dataMap.get(0).get("NumPingNanZhuYuAnd60To70M"));
        jsonObject.put("NumPingNanZhuYuAnd70To80M",dataMap.get(0).get("NumPingNanZhuYuAnd70To80M"));
        jsonObject.put("NumPingNanZhuYuAnd80To90M",dataMap.get(0).get("NumPingNanZhuYuAnd80To90M"));
        jsonObject.put("NumPingNanZhuYuAnd90AboveM",dataMap.get(0).get("NumPingNanZhuYuAnd90AboveM"));
        jsonObject.put("NumPingNanZhuYuAnd60To70F",dataMap.get(0).get("NumPingNanZhuYuAnd60To70F"));
        jsonObject.put("NumPingNanZhuYuAnd70To80F",dataMap.get(0).get("NumPingNanZhuYuAnd70To80F"));
        jsonObject.put("NumPingNanZhuYuAnd80To90F",dataMap.get(0).get("NumPingNanZhuYuAnd80To90F"));
        jsonObject.put("NumPingNanZhuYuAnd90AboveF",dataMap.get(0).get("NumPingNanZhuYuAnd90AboveF"));

        jsonObject.put("NumPingNanZhuXingAndHuJi",dataMap.get(0).get("NumPingNanZhuXingAndHuJi"));
        jsonObject.put("NumPingNanZhuXingAndFeiHuJi",dataMap.get(0).get("NumPingNanZhuXingAndFeiHuJi"));
        jsonObject.put("NumPingNanZhuXingAndMale",dataMap.get(0).get("NumPingNanZhuXingAndMale"));
        jsonObject.put("NumPingNanZhuXingAndFemale",dataMap.get(0).get("NumPingNanZhuXingAndFemale"));
        jsonObject.put("NumPingNanZhuXingAnd60To70M",dataMap.get(0).get("NumPingNanZhuXingAnd60To70M"));
        jsonObject.put("NumPingNanZhuXingAnd70To80M",dataMap.get(0).get("NumPingNanZhuXingAnd70To80M"));
        jsonObject.put("NumPingNanZhuXingAnd80To90M",dataMap.get(0).get("NumPingNanZhuXingAnd80To90M"));
        jsonObject.put("NumPingNanZhuXingAnd90AboveM",dataMap.get(0).get("NumPingNanZhuXingAnd90AboveM"));
        jsonObject.put("NumPingNanZhuXingAnd60To70F",dataMap.get(0).get("NumPingNanZhuXingAnd60To70F"));
        jsonObject.put("NumPingNanZhuXingAnd70To80F",dataMap.get(0).get("NumPingNanZhuXingAnd70To80F"));
        jsonObject.put("NumPingNanZhuXingAnd80To90F",dataMap.get(0).get("NumPingNanZhuXingAnd80To90F"));
        jsonObject.put("NumPingNanZhuXingAnd90AboveF",dataMap.get(0).get("NumPingNanZhuXingAnd90AboveF"));

        jsonObject.put("NumPingNanZhuYiAndHuJi",dataMap.get(0).get("NumPingNanZhuYiAndHuJi"));
        jsonObject.put("NumPingNanZhuYiAndFeiHuJi",dataMap.get(0).get("NumPingNanZhuYiAndFeiHuJi"));
        jsonObject.put("NumPingNanZhuYiAndMale",dataMap.get(0).get("NumPingNanZhuYiAndMale"));
        jsonObject.put("NumPingNanZhuYiAndFemale",dataMap.get(0).get("NumPingNanZhuYiAndFemale"));
        jsonObject.put("NumPingNanZhuYiAnd60To70M",dataMap.get(0).get("NumPingNanZhuYiAnd60To70M"));
        jsonObject.put("NumPingNanZhuYiAnd70To80M",dataMap.get(0).get("NumPingNanZhuYiAnd70To80M"));
        jsonObject.put("NumPingNanZhuYiAnd80To90M",dataMap.get(0).get("NumPingNanZhuYiAnd80To90M"));
        jsonObject.put("NumPingNanZhuYiAnd90AboveM",dataMap.get(0).get("NumPingNanZhuYiAnd90AboveM"));
        jsonObject.put("NumPingNanZhuYiAnd60To70F",dataMap.get(0).get("NumPingNanZhuYiAnd60To70F"));
        jsonObject.put("NumPingNanZhuYiAnd70To80F",dataMap.get(0).get("NumPingNanZhuYiAnd70To80F"));
        jsonObject.put("NumPingNanZhuYiAnd80To90F",dataMap.get(0).get("NumPingNanZhuYiAnd80To90F"));
        jsonObject.put("NumPingNanZhuYiAnd90AboveF",dataMap.get(0).get("NumPingNanZhuYiAnd90AboveF"));

        jsonObject.put("NumPingNanXiYiAndHuJi",dataMap.get(0).get("NumPingNanXiYiAndHuJi"));
        jsonObject.put("NumPingNanXiYiAndFeiHuJi",dataMap.get(0).get("NumPingNanXiYiAndFeiHuJi"));
        jsonObject.put("NumPingNanXiYiAndMale",dataMap.get(0).get("NumPingNanXiYiAndMale"));
        jsonObject.put("NumPingNanXiYiAndFemale",dataMap.get(0).get("NumPingNanXiYiAndFemale"));
        jsonObject.put("NumPingNanXiYiAnd60To70M",dataMap.get(0).get("NumPingNanXiYiAnd60To70M"));
        jsonObject.put("NumPingNanXiYiAnd70To80M",dataMap.get(0).get("NumPingNanXiYiAnd70To80M"));
        jsonObject.put("NumPingNanXiYiAnd80To90M",dataMap.get(0).get("NumPingNanXiYiAnd80To90M"));
        jsonObject.put("NumPingNanXiYiAnd90AboveM",dataMap.get(0).get("NumPingNanXiYiAnd90AboveM"));
        jsonObject.put("NumPingNanXiYiAnd60To70F",dataMap.get(0).get("NumPingNanXiYiAnd60To70F"));
        jsonObject.put("NumPingNanXiYiAnd70To80F",dataMap.get(0).get("NumPingNanXiYiAnd70To80F"));
        jsonObject.put("NumPingNanXiYiAnd80To90F",dataMap.get(0).get("NumPingNanXiYiAnd80To90F"));
        jsonObject.put("NumPingNanXiYiAnd90AboveF",dataMap.get(0).get("NumPingNanXiYiAnd90AboveF"));

        jsonObject.put("NumPingNanXiangTanAndHuJi",dataMap.get(0).get("NumPingNanXiangTanAndHuJi"));
        jsonObject.put("NumPingNanXiangTanAndFeiHuJi",dataMap.get(0).get("NumPingNanXiangTanAndFeiHuJi"));
        jsonObject.put("NumPingNanXiangTanAndMale",dataMap.get(0).get("NumPingNanXiangTanAndMale"));
        jsonObject.put("NumPingNanXiangTanAndFemale",dataMap.get(0).get("NumPingNanXiangTanAndFemale"));
        jsonObject.put("NumPingNanXiangTanAnd60To70M",dataMap.get(0).get("NumPingNanXiangTanAnd60To70M"));
        jsonObject.put("NumPingNanXiangTanAnd70To80M",dataMap.get(0).get("NumPingNanXiangTanAnd70To80M"));
        jsonObject.put("NumPingNanXiangTanAnd80To90M",dataMap.get(0).get("NumPingNanXiangTanAnd80To90M"));
        jsonObject.put("NumPingNanXiangTanAnd90AboveM",dataMap.get(0).get("NumPingNanXiangTanAnd90AboveM"));
        jsonObject.put("NumPingNanXiangTanAnd60To70F",dataMap.get(0).get("NumPingNanXiangTanAnd60To70F"));
        jsonObject.put("NumPingNanXiangTanAnd70To80F",dataMap.get(0).get("NumPingNanXiangTanAnd70To80F"));
        jsonObject.put("NumPingNanXiangTanAnd80To90F",dataMap.get(0).get("NumPingNanXiangTanAnd80To90F"));
        jsonObject.put("NumPingNanXiangTanAnd90AboveF",dataMap.get(0).get("NumPingNanXiangTanAnd90AboveF"));

        jsonObject.put("NumPingNanKangFuAndHuJi",dataMap.get(0).get("NumPingNanKangFuAndHuJi"));
        jsonObject.put("NumPingNanKangFuAndFeiHuJi",dataMap.get(0).get("NumPingNanKangFuAndFeiHuJi"));
        jsonObject.put("NumPingNanKangFuAndMale",dataMap.get(0).get("NumPingNanKangFuAndMale"));
        jsonObject.put("NumPingNanKangFuAndFemale",dataMap.get(0).get("NumPingNanKangFuAndFemale"));
        jsonObject.put("NumPingNanKangFuAnd60To70M",dataMap.get(0).get("NumPingNanKangFuAnd60To70M"));
        jsonObject.put("NumPingNanKangFuAnd70To80M",dataMap.get(0).get("NumPingNanKangFuAnd70To80M"));
        jsonObject.put("NumPingNanKangFuAnd80To90M",dataMap.get(0).get("NumPingNanKangFuAnd80To90M"));
        jsonObject.put("NumPingNanKangFuAnd90AboveM",dataMap.get(0).get("NumPingNanKangFuAnd90AboveM"));
        jsonObject.put("NumPingNanKangFuAnd60To70F",dataMap.get(0).get("NumPingNanKangFuAnd60To70F"));
        jsonObject.put("NumPingNanKangFuAnd70To80F",dataMap.get(0).get("NumPingNanKangFuAnd70To80F"));
        jsonObject.put("NumPingNanKangFuAnd80To90F",dataMap.get(0).get("NumPingNanKangFuAnd80To90F"));
        jsonObject.put("NumPingNanKangFuAnd90AboveF",dataMap.get(0).get("NumPingNanKangFuAnd90AboveF"));

        jsonObject.put("NumPingNanShengHuoAndHuJi",dataMap.get(0).get("NumPingNanShengHuoAndHuJi"));
        jsonObject.put("NumPingNanShengHuoAndFeiHuJi",dataMap.get(0).get("NumPingNanShengHuoAndFeiHuJi"));
        jsonObject.put("NumPingNanShengHuoAndMale",dataMap.get(0).get("NumPingNanShengHuoAndMale"));
        jsonObject.put("NumPingNanShengHuoAndFemale",dataMap.get(0).get("NumPingNanShengHuoAndFemale"));
        jsonObject.put("NumPingNanShengHuoAnd60To70M",dataMap.get(0).get("NumPingNanShengHuoAnd60To70M"));
        jsonObject.put("NumPingNanShengHuoAnd70To80M",dataMap.get(0).get("NumPingNanShengHuoAnd70To80M"));
        jsonObject.put("NumPingNanShengHuoAnd80To90M",dataMap.get(0).get("NumPingNanShengHuoAnd80To90M"));
        jsonObject.put("NumPingNanShengHuoAnd90AboveM",dataMap.get(0).get("NumPingNanShengHuoAnd90AboveM"));
        jsonObject.put("NumPingNanShengHuoAnd60To70F",dataMap.get(0).get("NumPingNanShengHuoAnd60To70F"));
        jsonObject.put("NumPingNanShengHuoAnd70To80F",dataMap.get(0).get("NumPingNanShengHuoAnd70To80F"));
        jsonObject.put("NumPingNanShengHuoAnd80To90F",dataMap.get(0).get("NumPingNanShengHuoAnd80To90F"));
        jsonObject.put("NumPingNanShengHuoAnd90AboveF",dataMap.get(0).get("NumPingNanShengHuoAnd90AboveF"));

        jsonObject.put("NumPingNanFuWuQiTaAndHuJi",dataMap.get(0).get("NumPingNanFuWuQiTaAndHuJi"));
        jsonObject.put("NumPingNanFuWuQiTaAndFeiHuJi",dataMap.get(0).get("NumPingNanFuWuQiTaAndFeiHuJi"));
        jsonObject.put("NumPingNanFuWuQiTaAndMale",dataMap.get(0).get("NumPingNanFuWuQiTaAndMale"));
        jsonObject.put("NumPingNanFuWuQiTaAndFemale",dataMap.get(0).get("NumPingNanFuWuQiTaAndFemale"));
        jsonObject.put("NumPingNanFuWuQiTaAnd60To70M",dataMap.get(0).get("NumPingNanFuWuQiTaAnd60To70M"));
        jsonObject.put("NumPingNanFuWuQiTaAnd70To80M",dataMap.get(0).get("NumPingNanFuWuQiTaAnd70To80M"));
        jsonObject.put("NumPingNanFuWuQiTaAnd80To90M",dataMap.get(0).get("NumPingNanFuWuQiTaAnd80To90M"));
        jsonObject.put("NumPingNanFuWuQiTaAnd90AboveM",dataMap.get(0).get("NumPingNanFuWuQiTaAnd90AboveM"));
        jsonObject.put("NumPingNanFuWuQiTaAnd60To70F",dataMap.get(0).get("NumPingNanFuWuQiTaAnd60To70F"));
        jsonObject.put("NumPingNanFuWuQiTaAnd70To80F",dataMap.get(0).get("NumPingNanFuWuQiTaAnd70To80F"));
        jsonObject.put("NumPingNanFuWuQiTaAnd80To90F",dataMap.get(0).get("NumPingNanFuWuQiTaAnd80To90F"));
        jsonObject.put("NumPingNanFuWuQiTaAnd90AboveF",dataMap.get(0).get("NumPingNanFuWuQiTaAnd90AboveF"));


        //all
        jsonObject.put("NumZhuCanAndHuJi",dataMap.get(0).get("NumZhuCanAndHuJi"));
        jsonObject.put("NumZhuCanAndFeiHuJi",dataMap.get(0).get("NumZhuCanAndFeiHuJi"));
        jsonObject.put("NumZhuCanAndMale",dataMap.get(0).get("NumZhuCanAndMale"));
        jsonObject.put("NumZhuCanAndFemale",dataMap.get(0).get("NumZhuCanAndFemale"));
        jsonObject.put("NumZhuCanAnd60To70M",dataMap.get(0).get("NumZhuCanAnd60To70M"));
        jsonObject.put("NumZhuCanAnd70To80M",dataMap.get(0).get("NumZhuCanAnd70To80M"));
        jsonObject.put("NumZhuCanAnd80To90M",dataMap.get(0).get("NumZhuCanAnd80To90M"));
        jsonObject.put("NumZhuCanAnd90AboveM",dataMap.get(0).get("NumZhuCanAnd90AboveM"));
        jsonObject.put("NumZhuCanAnd60To70F",dataMap.get(0).get("NumZhuCanAnd60To70F"));
        jsonObject.put("NumZhuCanAnd70To80F",dataMap.get(0).get("NumZhuCanAnd70To80F"));
        jsonObject.put("NumZhuCanAnd80To90F",dataMap.get(0).get("NumZhuCanAnd80To90F"));
        jsonObject.put("NumZhuCanAnd90AboveF",dataMap.get(0).get("NumZhuCanAnd90AboveF"));

        jsonObject.put("NumZhuJieAndHuJi",dataMap.get(0).get("NumZhuJieAndHuJi"));
        jsonObject.put("NumZhuJieAndFeiHuJi",dataMap.get(0).get("NumZhuJieAndFeiHuJi"));
        jsonObject.put("NumZhuJieAndMale",dataMap.get(0).get("NumZhuJieAndMale"));
        jsonObject.put("NumZhuJieAndFemale",dataMap.get(0).get("NumZhuJieAndFemale"));
        jsonObject.put("NumZhuJieAnd60To70M",dataMap.get(0).get("NumZhuJieAnd60To70M"));
        jsonObject.put("NumZhuJieAnd70To80M",dataMap.get(0).get("NumZhuJieAnd70To80M"));
        jsonObject.put("NumZhuJieAnd80To90M",dataMap.get(0).get("NumZhuJieAnd80To90M"));
        jsonObject.put("NumZhuJieAnd90AboveM",dataMap.get(0).get("NumZhuJieAnd90AboveM"));
        jsonObject.put("NumZhuJieAnd60To70F",dataMap.get(0).get("NumZhuJieAnd60To70F"));
        jsonObject.put("NumZhuJieAnd70To80F",dataMap.get(0).get("NumZhuJieAnd70To80F"));
        jsonObject.put("NumZhuJieAnd80To90F",dataMap.get(0).get("NumZhuJieAnd80To90F"));
        jsonObject.put("NumZhuJieAnd90AboveF",dataMap.get(0).get("NumZhuJieAnd90AboveF"));

        jsonObject.put("NumZhuYuAndHuJi",dataMap.get(0).get("NumZhuYuAndHuJi"));
        jsonObject.put("NumZhuYuAndFeiHuJi",dataMap.get(0).get("NumZhuYuAndFeiHuJi"));
        jsonObject.put("NumZhuYuAndMale",dataMap.get(0).get("NumZhuYuAndMale"));
        jsonObject.put("NumZhuYuAndFemale",dataMap.get(0).get("NumZhuYuAndFemale"));
        jsonObject.put("NumZhuYuAnd60To70M",dataMap.get(0).get("NumZhuYuAnd60To70M"));
        jsonObject.put("NumZhuYuAnd70To80M",dataMap.get(0).get("NumZhuYuAnd70To80M"));
        jsonObject.put("NumZhuYuAnd80To90M",dataMap.get(0).get("NumZhuYuAnd80To90M"));
        jsonObject.put("NumZhuYuAnd90AboveM",dataMap.get(0).get("NumZhuYuAnd90AboveM"));
        jsonObject.put("NumZhuYuAnd60To70F",dataMap.get(0).get("NumZhuYuAnd60To70F"));
        jsonObject.put("NumZhuYuAnd70To80F",dataMap.get(0).get("NumZhuYuAnd70To80F"));
        jsonObject.put("NumZhuYuAnd80To90F",dataMap.get(0).get("NumZhuYuAnd80To90F"));
        jsonObject.put("NumZhuYuAnd90AboveF",dataMap.get(0).get("NumZhuYuAnd90AboveF"));

        jsonObject.put("NumZhuXingAndHuJi",dataMap.get(0).get("NumZhuXingAndHuJi"));
        jsonObject.put("NumZhuXingAndFeiHuJi",dataMap.get(0).get("NumZhuXingAndFeiHuJi"));
        jsonObject.put("NumZhuXingAndMale",dataMap.get(0).get("NumZhuXingAndMale"));
        jsonObject.put("NumZhuXingAndFemale",dataMap.get(0).get("NumZhuXingAndFemale"));
        jsonObject.put("NumZhuXingAnd60To70M",dataMap.get(0).get("NumZhuXingAnd60To70M"));
        jsonObject.put("NumZhuXingAnd70To80M",dataMap.get(0).get("NumZhuXingAnd70To80M"));
        jsonObject.put("NumZhuXingAnd80To90M",dataMap.get(0).get("NumZhuXingAnd80To90M"));
        jsonObject.put("NumZhuXingAnd90AboveM",dataMap.get(0).get("NumZhuXingAnd90AboveM"));
        jsonObject.put("NumZhuXingAnd60To70F",dataMap.get(0).get("NumZhuXingAnd60To70F"));
        jsonObject.put("NumZhuXingAnd70To80F",dataMap.get(0).get("NumZhuXingAnd70To80F"));
        jsonObject.put("NumZhuXingAnd80To90F",dataMap.get(0).get("NumZhuXingAnd80To90F"));
        jsonObject.put("NumZhuXingAnd90AboveF",dataMap.get(0).get("NumZhuXingAnd90AboveF"));

        jsonObject.put("NumZhuYiAndHuJi",dataMap.get(0).get("NumZhuYiAndHuJi"));
        jsonObject.put("NumZhuYiAndFeiHuJi",dataMap.get(0).get("NumZhuYiAndFeiHuJi"));
        jsonObject.put("NumZhuYiAndMale",dataMap.get(0).get("NumZhuYiAndMale"));
        jsonObject.put("NumZhuYiAndFemale",dataMap.get(0).get("NumZhuYiAndFemale"));
        jsonObject.put("NumZhuYiAnd60To70M",dataMap.get(0).get("NumZhuYiAnd60To70M"));
        jsonObject.put("NumZhuYiAnd70To80M",dataMap.get(0).get("NumZhuYiAnd70To80M"));
        jsonObject.put("NumZhuYiAnd80To90M",dataMap.get(0).get("NumZhuYiAnd80To90M"));
        jsonObject.put("NumZhuYiAnd90AboveM",dataMap.get(0).get("NumZhuYiAnd90AboveM"));
        jsonObject.put("NumZhuYiAnd60To70F",dataMap.get(0).get("NumZhuYiAnd60To70F"));
        jsonObject.put("NumZhuYiAnd70To80F",dataMap.get(0).get("NumZhuYiAnd70To80F"));
        jsonObject.put("NumZhuYiAnd80To90F",dataMap.get(0).get("NumZhuYiAnd80To90F"));
        jsonObject.put("NumZhuYiAnd90AboveF",dataMap.get(0).get("NumZhuYiAnd90AboveF"));

        jsonObject.put("NumXiYiAndHuJi",dataMap.get(0).get("NumXiYiAndHuJi"));
        jsonObject.put("NumXiYiAndFeiHuJi",dataMap.get(0).get("NumXiYiAndFeiHuJi"));
        jsonObject.put("NumXiYiAndMale",dataMap.get(0).get("NumXiYiAndMale"));
        jsonObject.put("NumXiYiAndFemale",dataMap.get(0).get("NumXiYiAndFemale"));
        jsonObject.put("NumXiYiAnd60To70M",dataMap.get(0).get("NumXiYiAnd60To70M"));
        jsonObject.put("NumXiYiAnd70To80M",dataMap.get(0).get("NumXiYiAnd70To80M"));
        jsonObject.put("NumXiYiAnd80To90M",dataMap.get(0).get("NumXiYiAnd80To90M"));
        jsonObject.put("NumXiYiAnd90AboveM",dataMap.get(0).get("NumXiYiAnd90AboveM"));
        jsonObject.put("NumXiYiAnd60To70F",dataMap.get(0).get("NumXiYiAnd60To70F"));
        jsonObject.put("NumXiYiAnd70To80F",dataMap.get(0).get("NumXiYiAnd70To80F"));
        jsonObject.put("NumXiYiAnd80To90F",dataMap.get(0).get("NumXiYiAnd80To90F"));
        jsonObject.put("NumXiYiAnd90AboveF",dataMap.get(0).get("NumXiYiAnd90AboveF"));

        jsonObject.put("NumXiangTanAndHuJi",dataMap.get(0).get("NumXiangTanAndHuJi"));
        jsonObject.put("NumXiangTanAndFeiHuJi",dataMap.get(0).get("NumXiangTanAndFeiHuJi"));
        jsonObject.put("NumXiangTanAndMale",dataMap.get(0).get("NumXiangTanAndMale"));
        jsonObject.put("NumXiangTanAndFemale",dataMap.get(0).get("NumXiangTanAndFemale"));
        jsonObject.put("NumXiangTanAnd60To70M",dataMap.get(0).get("NumXiangTanAnd60To70M"));
        jsonObject.put("NumXiangTanAnd70To80M",dataMap.get(0).get("NumXiangTanAnd70To80M"));
        jsonObject.put("NumXiangTanAnd80To90M",dataMap.get(0).get("NumXiangTanAnd80To90M"));
        jsonObject.put("NumXiangTanAnd90AboveM",dataMap.get(0).get("NumXiangTanAnd90AboveM"));
        jsonObject.put("NumXiangTanAnd60To70F",dataMap.get(0).get("NumXiangTanAnd60To70F"));
        jsonObject.put("NumXiangTanAnd70To80F",dataMap.get(0).get("NumXiangTanAnd70To80F"));
        jsonObject.put("NumXiangTanAnd80To90F",dataMap.get(0).get("NumXiangTanAnd80To90F"));
        jsonObject.put("NumXiangTanAnd90AboveF",dataMap.get(0).get("NumXiangTanAnd90AboveF"));

        jsonObject.put("NumKangFuAndHuJi",dataMap.get(0).get("NumKangFuAndHuJi"));
        jsonObject.put("NumKangFuAndFeiHuJi",dataMap.get(0).get("NumKangFuAndFeiHuJi"));
        jsonObject.put("NumKangFuAndMale",dataMap.get(0).get("NumKangFuAndMale"));
        jsonObject.put("NumKangFuAndFemale",dataMap.get(0).get("NumKangFuAndFemale"));
        jsonObject.put("NumKangFuAnd60To70M",dataMap.get(0).get("NumKangFuAnd60To70M"));
        jsonObject.put("NumKangFuAnd70To80M",dataMap.get(0).get("NumKangFuAnd70To80M"));
        jsonObject.put("NumKangFuAnd80To90M",dataMap.get(0).get("NumKangFuAnd80To90M"));
        jsonObject.put("NumKangFuAnd90AboveM",dataMap.get(0).get("NumKangFuAnd90AboveM"));
        jsonObject.put("NumKangFuAnd60To70F",dataMap.get(0).get("NumKangFuAnd60To70F"));
        jsonObject.put("NumKangFuAnd70To80F",dataMap.get(0).get("NumKangFuAnd70To80F"));
        jsonObject.put("NumKangFuAnd80To90F",dataMap.get(0).get("NumKangFuAnd80To90F"));
        jsonObject.put("NumKangFuAnd90AboveF",dataMap.get(0).get("NumKangFuAnd90AboveF"));

        jsonObject.put("NumShengHuoAndHuJi",dataMap.get(0).get("NumShengHuoAndHuJi"));
        jsonObject.put("NumShengHuoAndFeiHuJi",dataMap.get(0).get("NumShengHuoAndFeiHuJi"));
        jsonObject.put("NumShengHuoAndMale",dataMap.get(0).get("NumShengHuoAndMale"));
        jsonObject.put("NumShengHuoAndFemale",dataMap.get(0).get("NumShengHuoAndFemale"));
        jsonObject.put("NumShengHuoAnd60To70M",dataMap.get(0).get("NumShengHuoAnd60To70M"));
        jsonObject.put("NumShengHuoAnd70To80M",dataMap.get(0).get("NumShengHuoAnd70To80M"));
        jsonObject.put("NumShengHuoAnd80To90M",dataMap.get(0).get("NumShengHuoAnd80To90M"));
        jsonObject.put("NumShengHuoAnd90AboveM",dataMap.get(0).get("NumShengHuoAnd90AboveM"));
        jsonObject.put("NumShengHuoAnd60To70F",dataMap.get(0).get("NumShengHuoAnd60To70F"));
        jsonObject.put("NumShengHuoAnd70To80F",dataMap.get(0).get("NumShengHuoAnd70To80F"));
        jsonObject.put("NumShengHuoAnd80To90F",dataMap.get(0).get("NumShengHuoAnd80To90F"));
        jsonObject.put("NumShengHuoAnd90AboveF",dataMap.get(0).get("NumShengHuoAnd90AboveF"));

        jsonObject.put("NumFuWuQiTaAndHuJi",dataMap.get(0).get("NumFuWuQiTaAndHuJi"));
        jsonObject.put("NumFuWuQiTaAndFeiHuJi",dataMap.get(0).get("NumFuWuQiTaAndFeiHuJi"));
        jsonObject.put("NumFuWuQiTaAndMale",dataMap.get(0).get("NumFuWuQiTaAndMale"));
        jsonObject.put("NumFuWuQiTaAndFemale",dataMap.get(0).get("NumFuWuQiTaAndFemale"));
        jsonObject.put("NumFuWuQiTaAnd60To70M",dataMap.get(0).get("NumFuWuQiTaAnd60To70M"));
        jsonObject.put("NumFuWuQiTaAnd70To80M",dataMap.get(0).get("NumFuWuQiTaAnd70To80M"));
        jsonObject.put("NumFuWuQiTaAnd80To90M",dataMap.get(0).get("NumFuWuQiTaAnd80To90M"));
        jsonObject.put("NumFuWuQiTaAnd90AboveM",dataMap.get(0).get("NumFuWuQiTaAnd90AboveM"));
        jsonObject.put("NumFuWuQiTaAnd60To70F",dataMap.get(0).get("NumFuWuQiTaAnd60To70F"));
        jsonObject.put("NumFuWuQiTaAnd70To80F",dataMap.get(0).get("NumFuWuQiTaAnd70To80F"));
        jsonObject.put("NumFuWuQiTaAnd80To90F",dataMap.get(0).get("NumFuWuQiTaAnd80To90F"));
        jsonObject.put("NumFuWuQiTaAnd90AboveF",dataMap.get(0).get("NumFuWuQiTaAnd90AboveF"));


        //ORGAN INFO
        jsonObject.put("NumPingYangJLRemain",dataMap.get(0).get("NumPingYangJLRemain"));
        jsonObject.put("NumPingYangJLLive",dataMap.get(0).get("NumPingYangJLLive"));
        jsonObject.put("NumPingYangJLFutureRemain",dataMap.get(0).get("NumPingYangJLFutureRemain"));
        jsonObject.put("NumPingYangJLAndMale",dataMap.get(0).get("NumPingYangJLAndMale"));
        jsonObject.put("NumPingYangJLAndFemale",dataMap.get(0).get("NumPingYangJLAndFemale"));
        jsonObject.put("NumPingYangJLAnd60To70M",dataMap.get(0).get("NumPingYangJLAnd60To70M"));
        jsonObject.put("NumPingYangJLAnd70To80M",dataMap.get(0).get("NumPingYangJLAnd70To80M"));
        jsonObject.put("NumPingYangJLAnd80To90M",dataMap.get(0).get("NumPingYangJLAnd80To90M"));
        jsonObject.put("NumPingYangJLAnd90AboveM",dataMap.get(0).get("NumPingYangJLAnd90AboveM"));
        jsonObject.put("NumPingYangJLAnd60To70F",dataMap.get(0).get("NumPingYangJLAnd60To70F"));
        jsonObject.put("NumPingYangJLAnd70To80F",dataMap.get(0).get("NumPingYangJLAnd70To80F"));
        jsonObject.put("NumPingYangJLAnd80To90F",dataMap.get(0).get("NumPingYangJLAnd80To90F"));
        jsonObject.put("NumPingYangJLAnd90AboveF",dataMap.get(0).get("NumPingYangJLAnd90AboveF"));

        jsonObject.put("NumGuMeiJLRemain",dataMap.get(0).get("NumGuMeiJLRemain"));
        jsonObject.put("NumGuMeiJLLive",dataMap.get(0).get("NumGuMeiJLLive"));
        jsonObject.put("NumGuMeiJLFutureRemain",dataMap.get(0).get("NumGuMeiJLFutureRemain"));
        jsonObject.put("NumGuMeiJLAndMale",dataMap.get(0).get("NumGuMeiJLAndMale"));
        jsonObject.put("NumGuMeiJLAndFemale",dataMap.get(0).get("NumGuMeiJLAndFemale"));
        jsonObject.put("NumGuMeiJLAnd60To70M",dataMap.get(0).get("NumGuMeiJLAnd60To70M"));
        jsonObject.put("NumGuMeiJLAnd70To80M",dataMap.get(0).get("NumGuMeiJLAnd70To80M"));
        jsonObject.put("NumGuMeiJLAnd80To90M",dataMap.get(0).get("NumGuMeiJLAnd80To90M"));
        jsonObject.put("NumGuMeiJLAnd90AboveM",dataMap.get(0).get("NumGuMeiJLAnd90AboveM"));
        jsonObject.put("NumGuMeiJLAnd60To70F",dataMap.get(0).get("NumGuMeiJLAnd60To70F"));
        jsonObject.put("NumGuMeiJLAnd70To80F",dataMap.get(0).get("NumGuMeiJLAnd70To80F"));
        jsonObject.put("NumGuMeiJLAnd80To90F",dataMap.get(0).get("NumGuMeiJLAnd80To90F"));
        jsonObject.put("NumGuMeiJLAnd90AboveF",dataMap.get(0).get("NumGuMeiJLAnd90AboveF"));

        jsonObject.put("NumLianHuaJLRemain",dataMap.get(0).get("NumLianHuaJLRemain"));
        jsonObject.put("NumLianHuaJLLive",dataMap.get(0).get("NumLianHuaJLLive"));
        jsonObject.put("NumLianHuaJLFutureRemain",dataMap.get(0).get("NumLianHuaJLFutureRemain"));
        jsonObject.put("NumLianHuaJLAndMale",dataMap.get(0).get("NumLianHuaJLAndMale"));
        jsonObject.put("NumLianHuaJLAndFemale",dataMap.get(0).get("NumLianHuaJLAndFemale"));
        jsonObject.put("NumLianHuaJLAnd60To70M",dataMap.get(0).get("NumLianHuaJLAnd60To70M"));
        jsonObject.put("NumLianHuaJLAnd70To80M",dataMap.get(0).get("NumLianHuaJLAnd70To80M"));
        jsonObject.put("NumLianHuaJLAnd80To90M",dataMap.get(0).get("NumLianHuaJLAnd80To90M"));
        jsonObject.put("NumLianHuaJLAnd90AboveM",dataMap.get(0).get("NumLianHuaJLAnd90AboveM"));
        jsonObject.put("NumLianHuaJLAnd60To70F",dataMap.get(0).get("NumLianHuaJLAnd60To70F"));
        jsonObject.put("NumLianHuaJLAnd70To80F",dataMap.get(0).get("NumLianHuaJLAnd70To80F"));
        jsonObject.put("NumLianHuaJLAnd80To90F",dataMap.get(0).get("NumLianHuaJLAnd80To90F"));
        jsonObject.put("NumLianHuaJLAnd90AboveF",dataMap.get(0).get("NumLianHuaJLAnd90AboveF"));

        jsonObject.put("NumZhiHuiZZRemain",dataMap.get(0).get("NumZhiHuiZZRemain"));
        jsonObject.put("NumZhiHuiZZLive",dataMap.get(0).get("NumZhiHuiZZLive"));
        jsonObject.put("NumZhiHuiZZFutureRemain",dataMap.get(0).get("NumZhiHuiZZFutureRemain"));
        jsonObject.put("NumZhiHuiZZAndMale",dataMap.get(0).get("NumZhiHuiZZAndMale"));
        jsonObject.put("NumZhiHuiZZAndFemale",dataMap.get(0).get("NumZhiHuiZZAndFemale"));
        jsonObject.put("NumZhiHuiZZAnd60To70M",dataMap.get(0).get("NumZhiHuiZZAnd60To70M"));
        jsonObject.put("NumZhiHuiZZAnd70To80M",dataMap.get(0).get("NumZhiHuiZZAnd70To80M"));
        jsonObject.put("NumZhiHuiZZAnd80To90M",dataMap.get(0).get("NumZhiHuiZZAnd80To90M"));
        jsonObject.put("NumZhiHuiZZAnd90AboveM",dataMap.get(0).get("NumZhiHuiZZAnd90AboveM"));
        jsonObject.put("NumZhiHuiZZAnd60To70F",dataMap.get(0).get("NumZhiHuiZZAnd60To70F"));
        jsonObject.put("NumZhiHuiZZAnd70To80F",dataMap.get(0).get("NumZhiHuiZZAnd70To80F"));
        jsonObject.put("NumZhiHuiZZAnd80To90F",dataMap.get(0).get("NumZhiHuiZZAnd80To90F"));
        jsonObject.put("NumZhiHuiZZAnd90AboveF",dataMap.get(0).get("NumZhiHuiZZAnd90AboveF"));

        jsonObject.put("NumPingNanRZRemain",dataMap.get(0).get("NumPingNanRZRemain"));
        jsonObject.put("NumPingNanRZLive",dataMap.get(0).get("NumPingNanRZLive"));
        jsonObject.put("NumPingNanRZFutureRemain",dataMap.get(0).get("NumPingNanRZFutureRemain"));
        jsonObject.put("NumPingNanRZAndMale",dataMap.get(0).get("NumPingNanRZAndMale"));
        jsonObject.put("NumPingNanRZAndFemale",dataMap.get(0).get("NumPingNanRZAndFemale"));
        jsonObject.put("NumPingNanRZAnd60To70M",dataMap.get(0).get("NumPingNanRZAnd60To70M"));
        jsonObject.put("NumPingNanRZAnd70To80M",dataMap.get(0).get("NumPingNanRZAnd70To80M"));
        jsonObject.put("NumPingNanRZAnd80To90M",dataMap.get(0).get("NumPingNanRZAnd80To90M"));
        jsonObject.put("NumPingNanRZAnd90AboveM",dataMap.get(0).get("NumPingNanRZAnd90AboveM"));
        jsonObject.put("NumPingNanRZAnd60To70F",dataMap.get(0).get("NumPingNanRZAnd60To70F"));
        jsonObject.put("NumPingNanRZAnd70To80F",dataMap.get(0).get("NumPingNanRZAnd70To80F"));
        jsonObject.put("NumPingNanRZAnd80To90F",dataMap.get(0).get("NumPingNanRZAnd80To90F"));
        jsonObject.put("NumPingNanRZAnd90AboveF",dataMap.get(0).get("NumPingNanRZAnd90AboveF"));

        //zcd
        jsonObject.put("NumPingJiZCRemain",dataMap.get(0).get("NumPingJiZCRemain"));
        jsonObject.put("NumPingJiZCLive",dataMap.get(0).get("NumPingJiZCLive"));
        jsonObject.put("NumPingJiZCFutureRemain",dataMap.get(0).get("NumPingJiZCFutureRemain"));
        jsonObject.put("NumPingJiZCAndMale",dataMap.get(0).get("NumPingJiZCAndMale"));
        jsonObject.put("NumPingJiZCAndFemale",dataMap.get(0).get("NumPingJiZCAndFemale"));
        jsonObject.put("NumPingJiZCAnd60To70M",dataMap.get(0).get("NumPingJiZCAnd60To70M"));
        jsonObject.put("NumPingJiZCAnd70To80M",dataMap.get(0).get("NumPingJiZCAnd70To80M"));
        jsonObject.put("NumPingJiZCAnd80To90M",dataMap.get(0).get("NumPingJiZCAnd80To90M"));
        jsonObject.put("NumPingJiZCAnd90AboveM",dataMap.get(0).get("NumPingJiZCAnd90AboveM"));
        jsonObject.put("NumPingJiZCAnd60To70F",dataMap.get(0).get("NumPingJiZCAnd60To70F"));
        jsonObject.put("NumPingJiZCAnd70To80F",dataMap.get(0).get("NumPingJiZCAnd70To80F"));
        jsonObject.put("NumPingJiZCAnd80To90F",dataMap.get(0).get("NumPingJiZCAnd80To90F"));
        jsonObject.put("NumPingJiZCAnd90AboveF",dataMap.get(0).get("NumPingJiZCAnd90AboveF"));

        jsonObject.put("NumPingNanZCRemain",dataMap.get(0).get("NumPingNanZCRemain"));
        jsonObject.put("NumPingNanZCLive",dataMap.get(0).get("NumPingNanZCLive"));
        jsonObject.put("NumPingNanZCFutureRemain",dataMap.get(0).get("NumPingNanZCFutureRemain"));
        jsonObject.put("NumPingNanZCAndMale",dataMap.get(0).get("NumPingNanZCAndMale"));
        jsonObject.put("NumPingNanZCAndFemale",dataMap.get(0).get("NumPingNanZCAndFemale"));
        jsonObject.put("NumPingNanZCAnd60To70M",dataMap.get(0).get("NumPingNanZCAnd60To70M"));
        jsonObject.put("NumPingNanZCAnd70To80M",dataMap.get(0).get("NumPingNanZCAnd70To80M"));
        jsonObject.put("NumPingNanZCAnd80To90M",dataMap.get(0).get("NumPingNanZCAnd80To90M"));
        jsonObject.put("NumPingNanZCAnd90AboveM",dataMap.get(0).get("NumPingNanZCAnd90AboveM"));
        jsonObject.put("NumPingNanZCAnd60To70F",dataMap.get(0).get("NumPingNanZCAnd60To70F"));
        jsonObject.put("NumPingNanZCAnd70To80F",dataMap.get(0).get("NumPingNanZCAnd70To80F"));
        jsonObject.put("NumPingNanZCAnd80To90F",dataMap.get(0).get("NumPingNanZCAnd80To90F"));
        jsonObject.put("NumPingNanZCAnd90AboveF",dataMap.get(0).get("NumPingNanZCAnd90AboveF"));

        jsonObject.put("NumGuMeiZCRemain",dataMap.get(0).get("NumGuMeiZCRemain"));
        jsonObject.put("NumGuMeiZCLive",dataMap.get(0).get("NumGuMeiZCLive"));
        jsonObject.put("NumGuMeiZCFutureRemain",dataMap.get(0).get("NumGuMeiZCFutureRemain"));
        jsonObject.put("NumGuMeiZCAndMale",dataMap.get(0).get("NumGuMeiZCAndMale"));
        jsonObject.put("NumGuMeiZCAndFemale",dataMap.get(0).get("NumGuMeiZCAndFemale"));
        jsonObject.put("NumGuMeiZCAnd60To70M",dataMap.get(0).get("NumGuMeiZCAnd60To70M"));
        jsonObject.put("NumGuMeiZCAnd70To80M",dataMap.get(0).get("NumGuMeiZCAnd70To80M"));
        jsonObject.put("NumGuMeiZCAnd80To90M",dataMap.get(0).get("NumGuMeiZCAnd80To90M"));
        jsonObject.put("NumGuMeiZCAnd90AboveM",dataMap.get(0).get("NumGuMeiZCAnd90AboveM"));
        jsonObject.put("NumGuMeiZCAnd60To70F",dataMap.get(0).get("NumGuMeiZCAnd60To70F"));
        jsonObject.put("NumGuMeiZCAnd70To80F",dataMap.get(0).get("NumGuMeiZCAnd70To80F"));
        jsonObject.put("NumGuMeiZCAnd80To90F",dataMap.get(0).get("NumGuMeiZCAnd80To90F"));
        jsonObject.put("NumGuMeiZCAnd90AboveF",dataMap.get(0).get("NumGuMeiZCAnd90AboveF"));

        //zhinenghua
        jsonObject.put("NumAnKang",dataMap.get(0).get("NumAnKang"));
        jsonObject.put("NumKangLe",dataMap.get(0).get("NumKangLe"));
        jsonObject.put("NumZhiNengAndHuJi",dataMap.get(0).get("NumZhiNengAndHuJi"));
        jsonObject.put("NumZhiNengAndFeiHuJi",dataMap.get(0).get("NumZhiNengAndFeiHuJi"));
        jsonObject.put("NumZhiNengAndMale",dataMap.get(0).get("NumZhiNengAndMale"));
        jsonObject.put("NumZhiNengAndFemale",dataMap.get(0).get("NumZhiNengAndFemale"));
        jsonObject.put("NumZhiNengAnd60To70M",dataMap.get(0).get("NumZhiNengAnd60To70M"));
        jsonObject.put("NumZhiNengAnd70To80M",dataMap.get(0).get("NumZhiNengAnd70To80M"));
        jsonObject.put("NumZhiNengAnd80To90M",dataMap.get(0).get("NumZhiNengAnd80To90M"));
        jsonObject.put("NumZhiNengAnd90AboveM",dataMap.get(0).get("NumZhiNengAnd90AboveM"));
        jsonObject.put("NumZhiNengAnd60To70F",dataMap.get(0).get("NumZhiNengAnd60To70F"));
        jsonObject.put("NumZhiNengAnd70To80F",dataMap.get(0).get("NumZhiNengAnd70To80F"));
        jsonObject.put("NumZhiNengAnd80To90F",dataMap.get(0).get("NumZhiNengAnd80To90F"));
        jsonObject.put("NumZhiNengAnd90AboveF",dataMap.get(0).get("NumZhiNengAnd90AboveF"));


        //gumei
        jsonObject.put("NumZhiNengAndGuMeiAndHuJi",dataMap.get(0).get("NumZhiNengAndGuMeiAndHuJi"));
        jsonObject.put("NumZhiNengAndGuMeiAndFeiHuJi",dataMap.get(0).get("NumZhiNengAndGuMeiAndFeiHuJi"));
        jsonObject.put("NumZhiNengAndGuMeiAndMale",dataMap.get(0).get("NumZhiNengAndGuMeiAndMale"));
        jsonObject.put("NumZhiNengAndGuMeiAndFemale",dataMap.get(0).get("NumZhiNengAndGuMeiAndFemale"));
        jsonObject.put("NumZhiNengAndGuMeiAnd60To70M",dataMap.get(0).get("NumZhiNengAndGuMeiAnd60To70M"));
        jsonObject.put("NumZhiNengAndGuMeiAnd70To80M",dataMap.get(0).get("NumZhiNengAndGuMeiAnd70To80M"));
        jsonObject.put("NumZhiNengAndGuMeiAnd80To90M",dataMap.get(0).get("NumZhiNengAndGuMeiAnd80To90M"));
        jsonObject.put("NumZhiNengAndGuMeiAnd90AboveM",dataMap.get(0).get("NumZhiNengAndGuMeiAnd90AboveM"));
        jsonObject.put("NumZhiNengAndGuMeiAnd60To70F",dataMap.get(0).get("NumZhiNengAndGuMeiAnd60To70F"));
        jsonObject.put("NumZhiNengAndGuMeiAnd70To80F",dataMap.get(0).get("NumZhiNengAndGuMeiAnd70To80F"));
        jsonObject.put("NumZhiNengAndGuMeiAnd80To90F",dataMap.get(0).get("NumZhiNengAndGuMeiAnd80To90F"));
        jsonObject.put("NumZhiNengAndGuMeiAnd90AboveF",dataMap.get(0).get("NumZhiNengAndGuMeiAnd90AboveF"));

        jsonObject.put("NumZhiNengAndGuLongAndHuJi",dataMap.get(0).get("NumZhiNengAndGuLongAndHuJi"));
        jsonObject.put("NumZhiNengAndGuLongAndFeiHuJi",dataMap.get(0).get("NumZhiNengAndGuLongAndFeiHuJi"));
        jsonObject.put("NumZhiNengAndGuLongAndMale",dataMap.get(0).get("NumZhiNengAndGuLongAndMale"));
        jsonObject.put("NumZhiNengAndGuLongAndFemale",dataMap.get(0).get("NumZhiNengAndGuLongAndFemale"));
        jsonObject.put("NumZhiNengAndGuLongAnd60To70M",dataMap.get(0).get("NumZhiNengAndGuLongAnd60To70M"));
        jsonObject.put("NumZhiNengAndGuLongAnd70To80M",dataMap.get(0).get("NumZhiNengAndGuLongAnd70To80M"));
        jsonObject.put("NumZhiNengAndGuLongAnd80To90M",dataMap.get(0).get("NumZhiNengAndGuLongAnd80To90M"));
        jsonObject.put("NumZhiNengAndGuLongAnd90AboveM",dataMap.get(0).get("NumZhiNengAndGuLongAnd90AboveM"));
        jsonObject.put("NumZhiNengAndGuLongAnd60To70F",dataMap.get(0).get("NumZhiNengAndGuLongAnd60To70F"));
        jsonObject.put("NumZhiNengAndGuLongAnd70To80F",dataMap.get(0).get("NumZhiNengAndGuLongAnd70To80F"));
        jsonObject.put("NumZhiNengAndGuLongAnd80To90F",dataMap.get(0).get("NumZhiNengAndGuLongAnd80To90F"));
        jsonObject.put("NumZhiNengAndGuLongAnd90AboveF",dataMap.get(0).get("NumZhiNengAndGuLongAnd90AboveF"));

        jsonObject.put("NumZhiNengAndDongLanAndHuJi",dataMap.get(0).get("NumZhiNengAndDongLanAndHuJi"));
        jsonObject.put("NumZhiNengAndDongLanAndFeiHuJi",dataMap.get(0).get("NumZhiNengAndDongLanAndFeiHuJi"));
        jsonObject.put("NumZhiNengAndDongLanAndMale",dataMap.get(0).get("NumZhiNengAndDongLanAndMale"));
        jsonObject.put("NumZhiNengAndDongLanAndFemale",dataMap.get(0).get("NumZhiNengAndDongLanAndFemale"));
        jsonObject.put("NumZhiNengAndDongLanAnd60To70M",dataMap.get(0).get("NumZhiNengAndDongLanAnd60To70M"));
        jsonObject.put("NumZhiNengAndDongLanAnd70To80M",dataMap.get(0).get("NumZhiNengAndDongLanAnd70To80M"));
        jsonObject.put("NumZhiNengAndDongLanAnd80To90M",dataMap.get(0).get("NumZhiNengAndDongLanAnd80To90M"));
        jsonObject.put("NumZhiNengAndDongLanAnd90AboveM",dataMap.get(0).get("NumZhiNengAndDongLanAnd90AboveM"));
        jsonObject.put("NumZhiNengAndDongLanAnd60To70F",dataMap.get(0).get("NumZhiNengAndDongLanAnd60To70F"));
        jsonObject.put("NumZhiNengAndDongLanAnd70To80F",dataMap.get(0).get("NumZhiNengAndDongLanAnd70To80F"));
        jsonObject.put("NumZhiNengAndDongLanAnd80To90F",dataMap.get(0).get("NumZhiNengAndDongLanAnd80To90F"));
        jsonObject.put("NumZhiNengAndDongLanAnd90AboveF",dataMap.get(0).get("NumZhiNengAndDongLanAnd90AboveF"));


        jsonObject.put("NumZhiNengAndPingJiAndHuJi",dataMap.get(0).get("NumZhiNengAndPingJiAndHuJi"));
        jsonObject.put("NumZhiNengAndPingJiAndFeiHuJi",dataMap.get(0).get("NumZhiNengAndPingJiAndFeiHuJi"));
        jsonObject.put("NumZhiNengAndPingJiAndMale",dataMap.get(0).get("NumZhiNengAndPingJiAndMale"));
        jsonObject.put("NumZhiNengAndPingJiAndFemale",dataMap.get(0).get("NumZhiNengAndPingJiAndFemale"));
        jsonObject.put("NumZhiNengAndPingJiAnd60To70M",dataMap.get(0).get("NumZhiNengAndPingJiAnd60To70M"));
        jsonObject.put("NumZhiNengAndPingJiAnd70To80M",dataMap.get(0).get("NumZhiNengAndPingJiAnd70To80M"));
        jsonObject.put("NumZhiNengAndPingJiAnd80To90M",dataMap.get(0).get("NumZhiNengAndPingJiAnd80To90M"));
        jsonObject.put("NumZhiNengAndPingJiAnd90AboveM",dataMap.get(0).get("NumZhiNengAndPingJiAnd90AboveM"));
        jsonObject.put("NumZhiNengAndPingJiAnd60To70F",dataMap.get(0).get("NumZhiNengAndPingJiAnd60To70F"));
        jsonObject.put("NumZhiNengAndPingJiAnd70To80F",dataMap.get(0).get("NumZhiNengAndPingJiAnd70To80F"));
        jsonObject.put("NumZhiNengAndPingJiAnd80To90F",dataMap.get(0).get("NumZhiNengAndPingJiAnd80To90F"));
        jsonObject.put("NumZhiNengAndPingJiAnd90AboveF",dataMap.get(0).get("NumZhiNengAndPingJiAnd90AboveF"));

        jsonObject.put("NumZhiNengAndPingYangAndHuJi",dataMap.get(0).get("NumZhiNengAndPingYangAndHuJi"));
        jsonObject.put("NumZhiNengAndPingYangAndFeiHuJi",dataMap.get(0).get("NumZhiNengAndPingYangAndFeiHuJi"));
        jsonObject.put("NumZhiNengAndPingYangAndMale",dataMap.get(0).get("NumZhiNengAndPingYangAndMale"));
        jsonObject.put("NumZhiNengAndPingYangAndFemale",dataMap.get(0).get("NumZhiNengAndPingYangAndFemale"));
        jsonObject.put("NumZhiNengAndPingYangAnd60To70M",dataMap.get(0).get("NumZhiNengAndPingYangAnd60To70M"));
        jsonObject.put("NumZhiNengAndPingYangAnd70To80M",dataMap.get(0).get("NumZhiNengAndPingYangAnd70To80M"));
        jsonObject.put("NumZhiNengAndPingYangAnd80To90M",dataMap.get(0).get("NumZhiNengAndPingYangAnd80To90M"));
        jsonObject.put("NumZhiNengAndPingYangAnd90AboveM",dataMap.get(0).get("NumZhiNengAndPingYangAnd90AboveM"));
        jsonObject.put("NumZhiNengAndPingYangAnd60To70F",dataMap.get(0).get("NumZhiNengAndPingYangAnd60To70F"));
        jsonObject.put("NumZhiNengAndPingYangAnd70To80F",dataMap.get(0).get("NumZhiNengAndPingYangAnd70To80F"));
        jsonObject.put("NumZhiNengAndPingYangAnd80To90F",dataMap.get(0).get("NumZhiNengAndPingYangAnd80To90F"));
        jsonObject.put("NumZhiNengAndPingYangAnd90AboveF",dataMap.get(0).get("NumZhiNengAndPingYangAnd90AboveF"));

        jsonObject.put("NumZhiNengAndPingNanAndHuJi",dataMap.get(0).get("NumZhiNengAndPingNanAndHuJi"));
        jsonObject.put("NumZhiNengAndPingNanAndFeiHuJi",dataMap.get(0).get("NumZhiNengAndPingNanAndFeiHuJi"));
        jsonObject.put("NumZhiNengAndPingNanAndMale",dataMap.get(0).get("NumZhiNengAndPingNanAndMale"));
        jsonObject.put("NumZhiNengAndPingNanAndFemale",dataMap.get(0).get("NumZhiNengAndPingNanAndFemale"));
        jsonObject.put("NumZhiNengAndPingNanAnd60To70M",dataMap.get(0).get("NumZhiNengAndPingNanAnd60To70M"));
        jsonObject.put("NumZhiNengAndPingNanAnd70To80M",dataMap.get(0).get("NumZhiNengAndPingNanAnd70To80M"));
        jsonObject.put("NumZhiNengAndPingNanAnd80To90M",dataMap.get(0).get("NumZhiNengAndPingNanAnd80To90M"));
        jsonObject.put("NumZhiNengAndPingNanAnd90AboveM",dataMap.get(0).get("NumZhiNengAndPingNanAnd90AboveM"));
        jsonObject.put("NumZhiNengAndPingNanAnd60To70F",dataMap.get(0).get("NumZhiNengAndPingNanAnd60To70F"));
        jsonObject.put("NumZhiNengAndPingNanAnd70To80F",dataMap.get(0).get("NumZhiNengAndPingNanAnd70To80F"));
        jsonObject.put("NumZhiNengAndPingNanAnd80To90F",dataMap.get(0).get("NumZhiNengAndPingNanAnd80To90F"));
        jsonObject.put("NumZhiNengAndPingNanAnd90AboveF",dataMap.get(0).get("NumZhiNengAndPingNanAnd90AboveF"));
//jiatingyisheng
        jsonObject.put("NumYiShengAndHuJi",dataMap.get(0).get("NumYiShengAndHuJi"));
        jsonObject.put("NumYiShengAndFeiHuJi",dataMap.get(0).get("NumYiShengAndFeiHuJi"));
        jsonObject.put("NumYiShengAndMale",dataMap.get(0).get("NumYiShengAndMale"));
        jsonObject.put("NumYiShengAndFemale",dataMap.get(0).get("NumYiShengAndFemale"));
        jsonObject.put("NumYiShengAnd60To70M",dataMap.get(0).get("NumYiShengAnd60To70M"));
        jsonObject.put("NumYiShengAnd70To80M",dataMap.get(0).get("NumYiShengAnd70To80M"));
        jsonObject.put("NumYiShengAnd80To90M",dataMap.get(0).get("NumYiShengAnd80To90M"));
        jsonObject.put("NumYiShengAnd90AboveM",dataMap.get(0).get("NumYiShengAnd90AboveM"));
        jsonObject.put("NumYiShengAnd60To70F",dataMap.get(0).get("NumYiShengAnd60To70F"));
        jsonObject.put("NumYiShengAnd70To80F",dataMap.get(0).get("NumYiShengAnd70To80F"));
        jsonObject.put("NumYiShengAnd80To90F",dataMap.get(0).get("NumYiShengAnd80To90F"));
        jsonObject.put("NumYiShengAnd90AboveF",dataMap.get(0).get("NumYiShengAnd90AboveF"));

        jsonObject.put("NumYiShengAndGuMeiAndHuJi",dataMap.get(0).get("NumYiShengAndGuMeiAndHuJi"));
        jsonObject.put("NumYiShengAndGuMeiAndFeiHuJi",dataMap.get(0).get("NumYiShengAndGuMeiAndFeiHuJi"));
        jsonObject.put("NumYiShengAndGuMeiAndMale",dataMap.get(0).get("NumYiShengAndGuMeiAndMale"));
        jsonObject.put("NumYiShengAndGuMeiAndFemale",dataMap.get(0).get("NumYiShengAndGuMeiAndFemale"));
        jsonObject.put("NumYiShengAndGuMeiAnd60To70M",dataMap.get(0).get("NumYiShengAndGuMeiAnd60To70M"));
        jsonObject.put("NumYiShengAndGuMeiAnd70To80M",dataMap.get(0).get("NumYiShengAndGuMeiAnd70To80M"));
        jsonObject.put("NumYiShengAndGuMeiAnd80To90M",dataMap.get(0).get("NumYiShengAndGuMeiAnd80To90M"));
        jsonObject.put("NumYiShengAndGuMeiAnd90AboveM",dataMap.get(0).get("NumYiShengAndGuMeiAnd90AboveM"));
        jsonObject.put("NumYiShengAndGuMeiAnd60To70F",dataMap.get(0).get("NumYiShengAndGuMeiAnd60To70F"));
        jsonObject.put("NumYiShengAndGuMeiAnd70To80F",dataMap.get(0).get("NumYiShengAndGuMeiAnd70To80F"));
        jsonObject.put("NumYiShengAndGuMeiAnd80To90F",dataMap.get(0).get("NumYiShengAndGuMeiAnd80To90F"));
        jsonObject.put("NumYiShengAndGuMeiAnd90AboveF",dataMap.get(0).get("NumYiShengAndGuMeiAnd90AboveF"));

        jsonObject.put("NumYiShengAndGuLongAndHuJi",dataMap.get(0).get("NumYiShengAndGuLongAndHuJi"));
        jsonObject.put("NumYiShengAndGuLongAndFeiHuJi",dataMap.get(0).get("NumYiShengAndGuLongAndFeiHuJi"));
        jsonObject.put("NumYiShengAndGuLongAndMale",dataMap.get(0).get("NumYiShengAndGuLongAndMale"));
        jsonObject.put("NumYiShengAndGuLongAndFemale",dataMap.get(0).get("NumYiShengAndGuLongAndFemale"));
        jsonObject.put("NumYiShengAndGuLongAnd60To70M",dataMap.get(0).get("NumYiShengAndGuLongAnd60To70M"));
        jsonObject.put("NumYiShengAndGuLongAnd70To80M",dataMap.get(0).get("NumYiShengAndGuLongAnd70To80M"));
        jsonObject.put("NumYiShengAndGuLongAnd80To90M",dataMap.get(0).get("NumYiShengAndGuLongAnd80To90M"));
        jsonObject.put("NumYiShengAndGuLongAnd90AboveM",dataMap.get(0).get("NumYiShengAndGuLongAnd90AboveM"));
        jsonObject.put("NumYiShengAndGuLongAnd60To70F",dataMap.get(0).get("NumYiShengAndGuLongAnd60To70F"));
        jsonObject.put("NumYiShengAndGuLongAnd70To80F",dataMap.get(0).get("NumYiShengAndGuLongAnd70To80F"));
        jsonObject.put("NumYiShengAndGuLongAnd80To90F",dataMap.get(0).get("NumYiShengAndGuLongAnd80To90F"));
        jsonObject.put("NumYiShengAndGuLongAnd90AboveF",dataMap.get(0).get("NumYiShengAndGuLongAnd90AboveF"));

        jsonObject.put("NumYiShengAndDongLanAndHuJi",dataMap.get(0).get("NumYiShengAndDongLanAndHuJi"));
        jsonObject.put("NumYiShengAndDongLanAndFeiHuJi",dataMap.get(0).get("NumYiShengAndDongLanAndFeiHuJi"));
        jsonObject.put("NumYiShengAndDongLanAndMale",dataMap.get(0).get("NumYiShengAndDongLanAndMale"));
        jsonObject.put("NumYiShengAndDongLanAndFemale",dataMap.get(0).get("NumYiShengAndDongLanAndFemale"));
        jsonObject.put("NumYiShengAndDongLanAnd60To70M",dataMap.get(0).get("NumYiShengAndDongLanAnd60To70M"));
        jsonObject.put("NumYiShengAndDongLanAnd70To80M",dataMap.get(0).get("NumYiShengAndDongLanAnd70To80M"));
        jsonObject.put("NumYiShengAndDongLanAnd80To90M",dataMap.get(0).get("NumYiShengAndDongLanAnd80To90M"));
        jsonObject.put("NumYiShengAndDongLanAnd90AboveM",dataMap.get(0).get("NumYiShengAndDongLanAnd90AboveM"));
        jsonObject.put("NumYiShengAndDongLanAnd60To70F",dataMap.get(0).get("NumYiShengAndDongLanAnd60To70F"));
        jsonObject.put("NumYiShengAndDongLanAnd70To80F",dataMap.get(0).get("NumYiShengAndDongLanAnd70To80F"));
        jsonObject.put("NumYiShengAndDongLanAnd80To90F",dataMap.get(0).get("NumYiShengAndDongLanAnd80To90F"));
        jsonObject.put("NumYiShengAndDongLanAnd90AboveF",dataMap.get(0).get("NumYiShengAndDongLanAnd90AboveF"));

        jsonObject.put("NumYiShengAndPingJiAndHuJi",dataMap.get(0).get("NumYiShengAndPingJiAndHuJi"));
        jsonObject.put("NumYiShengAndPingJiAndFeiHuJi",dataMap.get(0).get("NumYiShengAndPingJiAndFeiHuJi"));
        jsonObject.put("NumYiShengAndPingJiAndMale",dataMap.get(0).get("NumYiShengAndPingJiAndMale"));
        jsonObject.put("NumYiShengAndPingJiAndFemale",dataMap.get(0).get("NumYiShengAndPingJiAndFemale"));
        jsonObject.put("NumYiShengAndPingJiAnd60To70M",dataMap.get(0).get("NumYiShengAndPingJiAnd60To70M"));
        jsonObject.put("NumYiShengAndPingJiAnd70To80M",dataMap.get(0).get("NumYiShengAndPingJiAnd70To80M"));
        jsonObject.put("NumYiShengAndPingJiAnd80To90M",dataMap.get(0).get("NumYiShengAndPingJiAnd80To90M"));
        jsonObject.put("NumYiShengAndPingJiAnd90AboveM",dataMap.get(0).get("NumYiShengAndPingJiAnd90AboveM"));
        jsonObject.put("NumYiShengAndPingJiAnd60To70F",dataMap.get(0).get("NumYiShengAndPingJiAnd60To70F"));
        jsonObject.put("NumYiShengAndPingJiAnd70To80F",dataMap.get(0).get("NumYiShengAndPingJiAnd70To80F"));
        jsonObject.put("NumYiShengAndPingJiAnd80To90F",dataMap.get(0).get("NumYiShengAndPingJiAnd80To90F"));
        jsonObject.put("NumYiShengAndPingJiAnd90AboveF",dataMap.get(0).get("NumYiShengAndPingJiAnd90AboveF"));

        jsonObject.put("NumYiShengAndPingYangAndHuJi",dataMap.get(0).get("NumYiShengAndPingYangAndHuJi"));
        jsonObject.put("NumYiShengAndPingYangAndFeiHuJi",dataMap.get(0).get("NumYiShengAndPingYangAndFeiHuJi"));
        jsonObject.put("NumYiShengAndPingYangAndMale",dataMap.get(0).get("NumYiShengAndPingYangAndMale"));
        jsonObject.put("NumYiShengAndPingYangAndFemale",dataMap.get(0).get("NumYiShengAndPingYangAndFemale"));
        jsonObject.put("NumYiShengAndPingYangAnd60To70M",dataMap.get(0).get("NumYiShengAndPingYangAnd60To70M"));
        jsonObject.put("NumYiShengAndPingYangAnd70To80M",dataMap.get(0).get("NumYiShengAndPingYangAnd70To80M"));
        jsonObject.put("NumYiShengAndPingYangAnd80To90M",dataMap.get(0).get("NumYiShengAndPingYangAnd80To90M"));
        jsonObject.put("NumYiShengAndPingYangAnd90AboveM",dataMap.get(0).get("NumYiShengAndPingYangAnd90AboveM"));
        jsonObject.put("NumYiShengAndPingYangAnd60To70F",dataMap.get(0).get("NumYiShengAndPingYangAnd60To70F"));
        jsonObject.put("NumYiShengAndPingYangAnd70To80F",dataMap.get(0).get("NumYiShengAndPingYangAnd70To80F"));
        jsonObject.put("NumYiShengAndPingYangAnd80To90F",dataMap.get(0).get("NumYiShengAndPingYangAnd80To90F"));
        jsonObject.put("NumYiShengAndPingYangAnd90AboveF",dataMap.get(0).get("NumYiShengAndPingYangAnd90AboveF"));

        jsonObject.put("NumYiShengAndPingNanAndHuJi",dataMap.get(0).get("NumYiShengAndPingNanAndHuJi"));
        jsonObject.put("NumYiShengAndPingNanAndFeiHuJi",dataMap.get(0).get("NumYiShengAndPingNanAndFeiHuJi"));
        jsonObject.put("NumYiShengAndPingNanAndMale",dataMap.get(0).get("NumYiShengAndPingNanAndMale"));
        jsonObject.put("NumYiShengAndPingNanAndFemale",dataMap.get(0).get("NumYiShengAndPingNanAndFemale"));
        jsonObject.put("NumYiShengAndPingNanAnd60To70M",dataMap.get(0).get("NumYiShengAndPingNanAnd60To70M"));
        jsonObject.put("NumYiShengAndPingNanAnd70To80M",dataMap.get(0).get("NumYiShengAndPingNanAnd70To80M"));
        jsonObject.put("NumYiShengAndPingNanAnd80To90M",dataMap.get(0).get("NumYiShengAndPingNanAnd80To90M"));
        jsonObject.put("NumYiShengAndPingNanAnd90AboveM",dataMap.get(0).get("NumYiShengAndPingNanAnd90AboveM"));
        jsonObject.put("NumYiShengAndPingNanAnd60To70F",dataMap.get(0).get("NumYiShengAndPingNanAnd60To70F"));
        jsonObject.put("NumYiShengAndPingNanAnd70To80F",dataMap.get(0).get("NumYiShengAndPingNanAnd70To80F"));
        jsonObject.put("NumYiShengAndPingNanAnd80To90F",dataMap.get(0).get("NumYiShengAndPingNanAnd80To90F"));
        jsonObject.put("NumYiShengAndPingNanAnd90AboveF",dataMap.get(0).get("NumYiShengAndPingNanAnd90AboveF"));

        //jtbc
        jsonObject.put("NumBingChuangAndHuJi",dataMap.get(0).get("NumBingChuangAndHuJi"));
        jsonObject.put("NumBingChuangAndFeiHuJi",dataMap.get(0).get("NumBingChuangAndFeiHuJi"));
        jsonObject.put("NumBingChuangAndMale",dataMap.get(0).get("NumBingChuangAndMale"));
        jsonObject.put("NumBingChuangAndFemale",dataMap.get(0).get("NumBingChuangAndFemale"));
        jsonObject.put("NumBingChuangAnd60To70M",dataMap.get(0).get("NumBingChuangAnd60To70M"));
        jsonObject.put("NumBingChuangAnd70To80M",dataMap.get(0).get("NumBingChuangAnd70To80M"));
        jsonObject.put("NumBingChuangAnd80To90M",dataMap.get(0).get("NumBingChuangAnd80To90M"));
        jsonObject.put("NumBingChuangAnd90AboveM",dataMap.get(0).get("NumBingChuangAnd90AboveM"));
        jsonObject.put("NumBingChuangAnd60To70F",dataMap.get(0).get("NumBingChuangAnd60To70F"));
        jsonObject.put("NumBingChuangAnd70To80F",dataMap.get(0).get("NumBingChuangAnd70To80F"));
        jsonObject.put("NumBingChuangAnd80To90F",dataMap.get(0).get("NumBingChuangAnd80To90F"));
        jsonObject.put("NumBingChuangAnd90AboveF",dataMap.get(0).get("NumBingChuangAnd90AboveF"));

        jsonObject.put("NumBingChuangAndGuMeiAndHuJi",dataMap.get(0).get("NumBingChuangAndGuMeiAndHuJi"));
        jsonObject.put("NumBingChuangAndGuMeiAndFeiHuJi",dataMap.get(0).get("NumBingChuangAndGuMeiAndFeiHuJi"));
        jsonObject.put("NumBingChuangAndGuMeiAndMale",dataMap.get(0).get("NumBingChuangAndGuMeiAndMale"));
        jsonObject.put("NumBingChuangAndGuMeiAndFemale",dataMap.get(0).get("NumBingChuangAndGuMeiAndFemale"));
        jsonObject.put("NumBingChuangAndGuMeiAnd60To70M",dataMap.get(0).get("NumBingChuangAndGuMeiAnd60To70M"));
        jsonObject.put("NumBingChuangAndGuMeiAnd70To80M",dataMap.get(0).get("NumBingChuangAndGuMeiAnd70To80M"));
        jsonObject.put("NumBingChuangAndGuMeiAnd80To90M",dataMap.get(0).get("NumBingChuangAndGuMeiAnd80To90M"));
        jsonObject.put("NumBingChuangAndGuMeiAnd90AboveM",dataMap.get(0).get("NumBingChuangAndGuMeiAnd90AboveM"));
        jsonObject.put("NumBingChuangAndGuMeiAnd60To70F",dataMap.get(0).get("NumBingChuangAndGuMeiAnd60To70F"));
        jsonObject.put("NumBingChuangAndGuMeiAnd70To80F",dataMap.get(0).get("NumBingChuangAndGuMeiAnd70To80F"));
        jsonObject.put("NumBingChuangAndGuMeiAnd80To90F",dataMap.get(0).get("NumBingChuangAndGuMeiAnd80To90F"));
        jsonObject.put("NumBingChuangAndGuMeiAnd90AboveF",dataMap.get(0).get("NumBingChuangAndGuMeiAnd90AboveF"));

        jsonObject.put("NumBingChuangAndGuLongAndHuJi",dataMap.get(0).get("NumBingChuangAndGuLongAndHuJi"));
        jsonObject.put("NumBingChuangAndGuLongAndFeiHuJi",dataMap.get(0).get("NumBingChuangAndGuLongAndFeiHuJi"));
        jsonObject.put("NumBingChuangAndGuLongAndMale",dataMap.get(0).get("NumBingChuangAndGuLongAndMale"));
        jsonObject.put("NumBingChuangAndGuLongAndFemale",dataMap.get(0).get("NumBingChuangAndGuLongAndFemale"));
        jsonObject.put("NumBingChuangAndGuLongAnd60To70M",dataMap.get(0).get("NumBingChuangAndGuLongAnd60To70M"));
        jsonObject.put("NumBingChuangAndGuLongAnd70To80M",dataMap.get(0).get("NumBingChuangAndGuLongAnd70To80M"));
        jsonObject.put("NumBingChuangAndGuLongAnd80To90M",dataMap.get(0).get("NumBingChuangAndGuLongAnd80To90M"));
        jsonObject.put("NumBingChuangAndGuLongAnd90AboveM",dataMap.get(0).get("NumBingChuangAndGuLongAnd90AboveM"));
        jsonObject.put("NumBingChuangAndGuLongAnd60To70F",dataMap.get(0).get("NumBingChuangAndGuLongAnd60To70F"));
        jsonObject.put("NumBingChuangAndGuLongAnd70To80F",dataMap.get(0).get("NumBingChuangAndGuLongAnd70To80F"));
        jsonObject.put("NumBingChuangAndGuLongAnd80To90F",dataMap.get(0).get("NumBingChuangAndGuLongAnd80To90F"));
        jsonObject.put("NumBingChuangAndGuLongAnd90AboveF",dataMap.get(0).get("NumBingChuangAndGuLongAnd90AboveF"));

        jsonObject.put("NumBingChuangAndDongLanAndHuJi",dataMap.get(0).get("NumBingChuangAndDongLanAndHuJi"));
        jsonObject.put("NumBingChuangAndDongLanAndFeiHuJi",dataMap.get(0).get("NumBingChuangAndDongLanAndFeiHuJi"));
        jsonObject.put("NumBingChuangAndDongLanAndMale",dataMap.get(0).get("NumBingChuangAndDongLanAndMale"));
        jsonObject.put("NumBingChuangAndDongLanAndFemale",dataMap.get(0).get("NumBingChuangAndDongLanAndFemale"));
        jsonObject.put("NumBingChuangAndDongLanAnd60To70M",dataMap.get(0).get("NumBingChuangAndDongLanAnd60To70M"));
        jsonObject.put("NumBingChuangAndDongLanAnd70To80M",dataMap.get(0).get("NumBingChuangAndDongLanAnd70To80M"));
        jsonObject.put("NumBingChuangAndDongLanAnd80To90M",dataMap.get(0).get("NumBingChuangAndDongLanAnd80To90M"));
        jsonObject.put("NumBingChuangAndDongLanAnd90AboveM",dataMap.get(0).get("NumBingChuangAndDongLanAnd90AboveM"));
        jsonObject.put("NumBingChuangAndDongLanAnd60To70F",dataMap.get(0).get("NumBingChuangAndDongLanAnd60To70F"));
        jsonObject.put("NumBingChuangAndDongLanAnd70To80F",dataMap.get(0).get("NumBingChuangAndDongLanAnd70To80F"));
        jsonObject.put("NumBingChuangAndDongLanAnd80To90F",dataMap.get(0).get("NumBingChuangAndDongLanAnd80To90F"));
        jsonObject.put("NumBingChuangAndDongLanAnd90AboveF",dataMap.get(0).get("NumBingChuangAndDongLanAnd90AboveF"));

        jsonObject.put("NumBingChuangAndPingJiAndHuJi",dataMap.get(0).get("NumBingChuangAndPingJiAndHuJi"));
        jsonObject.put("NumBingChuangAndPingJiAndFeiHuJi",dataMap.get(0).get("NumBingChuangAndPingJiAndFeiHuJi"));
        jsonObject.put("NumBingChuangAndPingJiAndMale",dataMap.get(0).get("NumBingChuangAndPingJiAndMale"));
        jsonObject.put("NumBingChuangAndPingJiAndFemale",dataMap.get(0).get("NumBingChuangAndPingJiAndFemale"));
        jsonObject.put("NumBingChuangAndPingJiAnd60To70M",dataMap.get(0).get("NumBingChuangAndPingJiAnd60To70M"));
        jsonObject.put("NumBingChuangAndPingJiAnd70To80M",dataMap.get(0).get("NumBingChuangAndPingJiAnd70To80M"));
        jsonObject.put("NumBingChuangAndPingJiAnd80To90M",dataMap.get(0).get("NumBingChuangAndPingJiAnd80To90M"));
        jsonObject.put("NumBingChuangAndPingJiAnd90AboveM",dataMap.get(0).get("NumBingChuangAndPingJiAnd90AboveM"));
        jsonObject.put("NumBingChuangAndPingJiAnd60To70F",dataMap.get(0).get("NumBingChuangAndPingJiAnd60To70F"));
        jsonObject.put("NumBingChuangAndPingJiAnd70To80F",dataMap.get(0).get("NumBingChuangAndPingJiAnd70To80F"));
        jsonObject.put("NumBingChuangAndPingJiAnd80To90F",dataMap.get(0).get("NumBingChuangAndPingJiAnd80To90F"));
        jsonObject.put("NumBingChuangAndPingJiAnd90AboveF",dataMap.get(0).get("NumBingChuangAndPingJiAnd90AboveF"));

        jsonObject.put("NumBingChuangAndPingYangAndHuJi",dataMap.get(0).get("NumBingChuangAndPingYangAndHuJi"));
        jsonObject.put("NumBingChuangAndPingYangAndFeiHuJi",dataMap.get(0).get("NumBingChuangAndPingYangAndFeiHuJi"));
        jsonObject.put("NumBingChuangAndPingYangAndMale",dataMap.get(0).get("NumBingChuangAndPingYangAndMale"));
        jsonObject.put("NumBingChuangAndPingYangAndFemale",dataMap.get(0).get("NumBingChuangAndPingYangAndFemale"));
        jsonObject.put("NumBingChuangAndPingYangAnd60To70M",dataMap.get(0).get("NumBingChuangAndPingYangAnd60To70M"));
        jsonObject.put("NumBingChuangAndPingYangAnd70To80M",dataMap.get(0).get("NumBingChuangAndPingYangAnd70To80M"));
        jsonObject.put("NumBingChuangAndPingYangAnd80To90M",dataMap.get(0).get("NumBingChuangAndPingYangAnd80To90M"));
        jsonObject.put("NumBingChuangAndPingYangAnd90AboveM",dataMap.get(0).get("NumBingChuangAndPingYangAnd90AboveM"));
        jsonObject.put("NumBingChuangAndPingYangAnd60To70F",dataMap.get(0).get("NumBingChuangAndPingYangAnd60To70F"));
        jsonObject.put("NumBingChuangAndPingYangAnd70To80F",dataMap.get(0).get("NumBingChuangAndPingYangAnd70To80F"));
        jsonObject.put("NumBingChuangAndPingYangAnd80To90F",dataMap.get(0).get("NumBingChuangAndPingYangAnd80To90F"));
        jsonObject.put("NumBingChuangAndPingYangAnd90AboveF",dataMap.get(0).get("NumBingChuangAndPingYangAnd90AboveF"));

        jsonObject.put("NumBingChuangAndPingNanAndHuJi",dataMap.get(0).get("NumBingChuangAndPingNanAndHuJi"));
        jsonObject.put("NumBingChuangAndPingNanAndFeiHuJi",dataMap.get(0).get("NumBingChuangAndPingNanAndFeiHuJi"));
        jsonObject.put("NumBingChuangAndPingNanAndMale",dataMap.get(0).get("NumBingChuangAndPingNanAndMale"));
        jsonObject.put("NumBingChuangAndPingNanAndFemale",dataMap.get(0).get("NumBingChuangAndPingNanAndFemale"));
        jsonObject.put("NumBingChuangAndPingNanAnd60To70M",dataMap.get(0).get("NumBingChuangAndPingNanAnd60To70M"));
        jsonObject.put("NumBingChuangAndPingNanAnd70To80M",dataMap.get(0).get("NumBingChuangAndPingNanAnd70To80M"));
        jsonObject.put("NumBingChuangAndPingNanAnd80To90M",dataMap.get(0).get("NumBingChuangAndPingNanAnd80To90M"));
        jsonObject.put("NumBingChuangAndPingNanAnd90AboveM",dataMap.get(0).get("NumBingChuangAndPingNanAnd90AboveM"));
        jsonObject.put("NumBingChuangAndPingNanAnd60To70F",dataMap.get(0).get("NumBingChuangAndPingNanAnd60To70F"));
        jsonObject.put("NumBingChuangAndPingNanAnd70To80F",dataMap.get(0).get("NumBingChuangAndPingNanAnd70To80F"));
        jsonObject.put("NumBingChuangAndPingNanAnd80To90F",dataMap.get(0).get("NumBingChuangAndPingNanAnd80To90F"));
        jsonObject.put("NumBingChuangAndPingNanAnd90AboveF",dataMap.get(0).get("NumBingChuangAndPingNanAnd90AboveF"));
        Result result =new Result(true,jsonObject);
        return result;

    }


}
