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
import static com.organOld.visualService.util.Tool.getNowDate1;
import static com.organOld.web.controller.VisualDataController2.add_code;

/**
 * 可视化 数据
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/visual/data")
public class VisualData1Controller {
    @Autowired
    OldmanService oldmanService;
    @ResponseBody
    @RequestMapping(value = "/getVisualData1",method = RequestMethod.GET)
    public Result admin_getOldNum1(){
        List<Map<String,Long>> dataMap=oldmanService.getVisualData1(AgeTobirthday(60),AgeTobirthday(70),AgeTobirthday(80),AgeTobirthday(90),"2019-03");
        String s=AgeTobirthday(80).toString();
        String str=getNowDate1().toString();
        JSONObject jsonObject = new JSONObject();

//pingyang
        //family
        jsonObject.put("NumPingYangAndChunLaoAndHuJi",dataMap.get(0).get("NumPingYangAndChunLaoAndHuJi"));
        jsonObject.put("NumPingYangAndChunLaoAndFeiHuJi",dataMap.get(0).get("NumPingYangAndChunLaoAndFeiHuJi"));
        jsonObject.put("NumPingYangAndChunLaoAndMale",dataMap.get(0).get("NumPingYangAndChunLaoAndMale"));
        jsonObject.put("NumPingYangAndChunLaoAndFemale",dataMap.get(0).get("NumPingYangAndChunLaoAndFemale"));
        jsonObject.put("NumPingYangAndChunLaoAnd60To70M",dataMap.get(0).get("NumPingYangAndChunLaoAnd60To70M"));
        jsonObject.put("NumPingYangAndChunLaoAnd70To80M",dataMap.get(0).get("NumPingYangAndChunLaoAnd70To80M"));
        jsonObject.put("NumPingYangAndChunLaoAnd80To90M",dataMap.get(0).get("NumPingYangAndChunLaoAnd80To90M"));
        jsonObject.put("NumPingYangAndChunLaoAnd90AboveM",dataMap.get(0).get("NumPingYangAndChunLaoAnd90AboveM"));
        jsonObject.put("NumPingYangAndChunLaoAnd60To70F",dataMap.get(0).get("NumPingYangAndChunLaoAnd60To70F"));
        jsonObject.put("NumPingYangAndChunLaoAnd70To80F",dataMap.get(0).get("NumPingYangAndChunLaoAnd70To80F"));
        jsonObject.put("NumPingYangAndChunLaoAnd80To90F",dataMap.get(0).get("NumPingYangAndChunLaoAnd80To90F"));
        jsonObject.put("NumPingYangAndChunLaoAnd90AboveF",dataMap.get(0).get("NumPingYangAndChunLaoAnd90AboveF"));


        jsonObject.put("NumPingYangAndDuJuAndHuJi",dataMap.get(0).get("NumPingYangAndDuJuAndHuJi"));
        jsonObject.put("NumPingYangAndDuJuAndFeiHuJi",dataMap.get(0).get("NumPingYangAndDuJuAndFeiHuJi"));
        jsonObject.put("NumPingYangAndDuJuAndMale",dataMap.get(0).get("NumPingYangAndDuJuAndMale"));
        jsonObject.put("NumPingYangAndDuJuAndFemale",dataMap.get(0).get("NumPingYangAndDuJuAndFemale"));
        jsonObject.put("NumPingYangAndDuJuAnd60To70M",dataMap.get(0).get("NumPingYangAndDuJuAnd60To70M"));
        jsonObject.put("NumPingYangAndDuJuAnd70To80M",dataMap.get(0).get("NumPingYangAndDuJuAnd70To80M"));
        jsonObject.put("NumPingYangAndDuJuAnd80To90M",dataMap.get(0).get("NumPingYangAndDuJuAnd80To90M"));
        jsonObject.put("NumPingYangAndDuJuAnd90AboveM",dataMap.get(0).get("NumPingYangAndDuJuAnd90AboveM"));
        jsonObject.put("NumPingYangAndDuJuAnd60To70F",dataMap.get(0).get("NumPingYangAndDuJuAnd60To70F"));
        jsonObject.put("NumPingYangAndDuJuAnd70To80F",dataMap.get(0).get("NumPingYangAndDuJuAnd70To80F"));
        jsonObject.put("NumPingYangAndDuJuAnd80To90F",dataMap.get(0).get("NumPingYangAndDuJuAnd80To90F"));
        jsonObject.put("NumPingYangAndDuJuAnd90AboveF",dataMap.get(0).get("NumPingYangAndDuJuAnd90AboveF"));


        jsonObject.put("NumPingYangAndShiDuAndHuJi",dataMap.get(0).get("NumPingYangAndShiDuAndHuJi"));
        jsonObject.put("NumPingYangAndShiDuAndFeiHuJi",dataMap.get(0).get("NumPingYangAndShiDuAndFeiHuJi"));
        jsonObject.put("NumPingYangAndShiDuAndMale",dataMap.get(0).get("NumPingYangAndShiDuAndMale"));
        jsonObject.put("NumPingYangAndShiDuAndFemale",dataMap.get(0).get("NumPingYangAndShiDuAndFemale"));
        jsonObject.put("NumPingYangAndShiDuAnd60To70M",dataMap.get(0).get("NumPingYangAndShiDuAnd60To70M"));
        jsonObject.put("NumPingYangAndShiDuAnd70To80M",dataMap.get(0).get("NumPingYangAndShiDuAnd70To80M"));
        jsonObject.put("NumPingYangAndShiDuAnd80To90M",dataMap.get(0).get("NumPingYangAndShiDuAnd80To90M"));
        jsonObject.put("NumPingYangAndShiDuAnd90AboveM",dataMap.get(0).get("NumPingYangAndShiDuAnd90AboveM"));
        jsonObject.put("NumPingYangAndShiDuAnd60To70F",dataMap.get(0).get("NumPingYangAndShiDuAnd60To70F"));
        jsonObject.put("NumPingYangAndShiDuAnd70To80F",dataMap.get(0).get("NumPingYangAndShiDuAnd70To80F"));
        jsonObject.put("NumPingYangAndShiDuAnd80To90F",dataMap.get(0).get("NumPingYangAndShiDuAnd80To90F"));
        jsonObject.put("NumPingYangAndShiDuAnd90AboveF",dataMap.get(0).get("NumPingYangAndShiDuAnd90AboveF"));

        jsonObject.put("NumPingYangAndYiLaoAndHuJi",dataMap.get(0).get("NumPingYangAndYiLaoAndHuJi"));
        jsonObject.put("NumPingYangAndYiLaoAndFeiHuJi",dataMap.get(0).get("NumPingYangAndYiLaoAndFeiHuJi"));
        jsonObject.put("NumPingYangAndYiLaoAndMale",dataMap.get(0).get("NumPingYangAndYiLaoAndMale"));
        jsonObject.put("NumPingYangAndYiLaoAndFemale",dataMap.get(0).get("NumPingYangAndYiLaoAndFemale"));
        jsonObject.put("NumPingYangAndYiLaoAnd60To70M",dataMap.get(0).get("NumPingYangAndYiLaoAnd60To70M"));
        jsonObject.put("NumPingYangAndYiLaoAnd70To80M",dataMap.get(0).get("NumPingYangAndYiLaoAnd70To80M"));
        jsonObject.put("NumPingYangAndYiLaoAnd80To90M",dataMap.get(0).get("NumPingYangAndYiLaoAnd80To90M"));
        jsonObject.put("NumPingYangAndYiLaoAnd90AboveM",dataMap.get(0).get("NumPingYangAndYiLaoAnd90AboveM"));
        jsonObject.put("NumPingYangAndYiLaoAnd60To70F",dataMap.get(0).get("NumPingYangAndYiLaoAnd60To70F"));
        jsonObject.put("NumPingYangAndYiLaoAnd70To80F",dataMap.get(0).get("NumPingYangAndYiLaoAnd70To80F"));
        jsonObject.put("NumPingYangAndYiLaoAnd80To90F",dataMap.get(0).get("NumPingYangAndYiLaoAnd80To90F"));
        jsonObject.put("NumPingYangAndYiLaoAnd90AboveF",dataMap.get(0).get("NumPingYangAndYiLaoAnd90AboveF"));

        jsonObject.put("NumPingYangAndGuLaoAndHuJi",dataMap.get(0).get("NumPingYangAndGuLaoAndHuJi"));
        jsonObject.put("NumPingYangAndGuLaoAndFeiHuJi",dataMap.get(0).get("NumPingYangAndGuLaoAndFeiHuJi"));
        jsonObject.put("NumPingYangAndGuLaoAndMale",dataMap.get(0).get("NumPingYangAndGuLaoAndMale"));
        jsonObject.put("NumPingYangAndGuLaoAndFemale",dataMap.get(0).get("NumPingYangAndGuLaoAndFemale"));
        jsonObject.put("NumPingYangAndGuLaoAnd60To70M",dataMap.get(0).get("NumPingYangAndGuLaoAnd60To70M"));
        jsonObject.put("NumPingYangAndGuLaoAnd70To80M",dataMap.get(0).get("NumPingYangAndGuLaoAnd70To80M"));
        jsonObject.put("NumPingYangAndGuLaoAnd80To90M",dataMap.get(0).get("NumPingYangAndGuLaoAnd80To90M"));
        jsonObject.put("NumPingYangAndGuLaoAnd90AboveM",dataMap.get(0).get("NumPingYangAndGuLaoAnd90AboveM"));
        jsonObject.put("NumPingYangAndGuLaoAnd60To70F",dataMap.get(0).get("NumPingYangAndGuLaoAnd60To70F"));
        jsonObject.put("NumPingYangAndGuLaoAnd70To80F",dataMap.get(0).get("NumPingYangAndGuLaoAnd70To80F"));
        jsonObject.put("NumPingYangAndGuLaoAnd80To90F",dataMap.get(0).get("NumPingYangAndGuLaoAnd80To90F"));
        jsonObject.put("NumPingYangAndGuLaoAnd90AboveF",dataMap.get(0).get("NumPingYangAndGuLaoAnd90AboveF"));

        jsonObject.put("NumPingYangAndSanZhiAndHuJi",dataMap.get(0).get("NumPingYangAndSanZhiAndHuJi"));
        jsonObject.put("NumPingYangAndSanZhiAndFeiHuJi",dataMap.get(0).get("NumPingYangAndSanZhiAndFeiHuJi"));
        jsonObject.put("NumPingYangAndSanZhiAndMale",dataMap.get(0).get("NumPingYangAndSanZhiAndMale"));
        jsonObject.put("NumPingYangAndSanZhiAndFemale",dataMap.get(0).get("NumPingYangAndSanZhiAndFemale"));
        jsonObject.put("NumPingYangAndSanZhiAnd60To70M",dataMap.get(0).get("NumPingYangAndSanZhiAnd60To70M"));
        jsonObject.put("NumPingYangAndSanZhiAnd70To80M",dataMap.get(0).get("NumPingYangAndSanZhiAnd70To80M"));
        jsonObject.put("NumPingYangAndSanZhiAnd80To90M",dataMap.get(0).get("NumPingYangAndSanZhiAnd80To90M"));
        jsonObject.put("NumPingYangAndSanZhiAnd90AboveM",dataMap.get(0).get("NumPingYangAndSanZhiAnd90AboveM"));
        jsonObject.put("NumPingYangAndSanZhiAnd60To70F",dataMap.get(0).get("NumPingYangAndSanZhiAnd60To70F"));
        jsonObject.put("NumPingYangAndSanZhiAnd70To80F",dataMap.get(0).get("NumPingYangAndSanZhiAnd70To80F"));
        jsonObject.put("NumPingYangAndSanZhiAnd80To90F",dataMap.get(0).get("NumPingYangAndSanZhiAnd80To90F"));
        jsonObject.put("NumPingYangAndSanZhiAnd90AboveF",dataMap.get(0).get("NumPingYangAndSanZhiAnd90AboveF"));

        jsonObject.put("NumPingYangAndQiTaAndHuJi",dataMap.get(0).get("NumPingYangAndQiTaAndHuJi"));
        jsonObject.put("NumPingYangAndQiTaAndFeiHuJi",dataMap.get(0).get("NumPingYangAndQiTaAndFeiHuJi"));
        jsonObject.put("NumPingYangAndQiTaAndMale",dataMap.get(0).get("NumPingYangAndQiTaAndMale"));
        jsonObject.put("NumPingYangAndQiTaAndFemale",dataMap.get(0).get("NumPingYangAndQiTaAndFemale"));
        jsonObject.put("NumPingYangAndQiTaAnd60To70M",dataMap.get(0).get("NumPingYangAndQiTaAnd60To70M"));
        jsonObject.put("NumPingYangAndQiTaAnd70To80M",dataMap.get(0).get("NumPingYangAndQiTaAnd70To80M"));
        jsonObject.put("NumPingYangAndQiTaAnd80To90M",dataMap.get(0).get("NumPingYangAndQiTaAnd80To90M"));
        jsonObject.put("NumPingYangAndQiTaAnd90AboveM",dataMap.get(0).get("NumPingYangAndQiTaAnd90AboveM"));
        jsonObject.put("NumPingYangAndQiTaAnd60To70F",dataMap.get(0).get("NumPingYangAndQiTaAnd60To70F"));
        jsonObject.put("NumPingYangAndQiTaAnd70To80F",dataMap.get(0).get("NumPingYangAndQiTaAnd70To80F"));
        jsonObject.put("NumPingYangAndQiTaAnd80To90F",dataMap.get(0).get("NumPingYangAndQiTaAnd80To90F"));
        jsonObject.put("NumPingYangAndQiTaAnd90AboveF",dataMap.get(0).get("NumPingYangAndQiTaAnd90AboveF"));

        //health
        jsonObject.put("NumPingYangAndShiNengAndHuJi",dataMap.get(0).get("NumPingYangAndShiNengAndHuJi"));
        jsonObject.put("NumPingYangAndShiNengAndFeiHuJi",dataMap.get(0).get("NumPingYangAndShiNengAndFeiHuJi"));
        jsonObject.put("NumPingYangAndShiNengAndMale",dataMap.get(0).get("NumPingYangAndShiNengAndMale"));
        jsonObject.put("NumPingYangAndShiNengAndFemale",dataMap.get(0).get("NumPingYangAndShiNengAndFemale"));
        jsonObject.put("NumPingYangAndShiNengAnd60To70M",dataMap.get(0).get("NumPingYangAndShiNengAnd60To70M"));
        jsonObject.put("NumPingYangAndShiNengAnd70To80M",dataMap.get(0).get("NumPingYangAndShiNengAnd70To80M"));
        jsonObject.put("NumPingYangAndShiNengAnd80To90M",dataMap.get(0).get("NumPingYangAndShiNengAnd80To90M"));
        jsonObject.put("NumPingYangAndShiNengAnd90AboveM",dataMap.get(0).get("NumPingYangAndShiNengAnd90AboveM"));
        jsonObject.put("NumPingYangAndShiNengAnd60To70F",dataMap.get(0).get("NumPingYangAndShiNengAnd60To70F"));
        jsonObject.put("NumPingYangAndShiNengAnd70To80F",dataMap.get(0).get("NumPingYangAndShiNengAnd70To80F"));
        jsonObject.put("NumPingYangAndShiNengAnd80To90F",dataMap.get(0).get("NumPingYangAndShiNengAnd80To90F"));
        jsonObject.put("NumPingYangAndShiNengAnd90AboveF",dataMap.get(0).get("NumPingYangAndShiNengAnd90AboveF"));

        jsonObject.put("NumPingYangAndManBingAndHuJi",dataMap.get(0).get("NumPingYangAndManBingAndHuJi"));
        jsonObject.put("NumPingYangAndManBingAndFeiHuJi",dataMap.get(0).get("NumPingYangAndManBingAndFeiHuJi"));
        jsonObject.put("NumPingYangAndManBingAndMale",dataMap.get(0).get("NumPingYangAndManBingAndMale"));
        jsonObject.put("NumPingYangAndManBingAndFemale",dataMap.get(0).get("NumPingYangAndManBingAndFemale"));
        jsonObject.put("NumPingYangAndManBingAnd60To70M",dataMap.get(0).get("NumPingYangAndManBingAnd60To70M"));
        jsonObject.put("NumPingYangAndManBingAnd70To80M",dataMap.get(0).get("NumPingYangAndManBingAnd70To80M"));
        jsonObject.put("NumPingYangAndManBingAnd80To90M",dataMap.get(0).get("NumPingYangAndManBingAnd80To90M"));
        jsonObject.put("NumPingYangAndManBingAnd90AboveM",dataMap.get(0).get("NumPingYangAndManBingAnd90AboveM"));
        jsonObject.put("NumPingYangAndManBingAnd60To70F",dataMap.get(0).get("NumPingYangAndManBingAnd60To70F"));
        jsonObject.put("NumPingYangAndManBingAnd70To80F",dataMap.get(0).get("NumPingYangAndManBingAnd70To80F"));
        jsonObject.put("NumPingYangAndManBingAnd80To90F",dataMap.get(0).get("NumPingYangAndManBingAnd80To90F"));
        jsonObject.put("NumPingYangAndManBingAnd90AboveF",dataMap.get(0).get("NumPingYangAndManBingAnd90AboveF"));

        jsonObject.put("NumPingYangAndZhongLiuAndHuJi",dataMap.get(0).get("NumPingYangAndZhongLiuAndHuJi"));
        jsonObject.put("NumPingYangAndZhongLiuAndFeiHuJi",dataMap.get(0).get("NumPingYangAndZhongLiuAndFeiHuJi"));
        jsonObject.put("NumPingYangAndZhongLiuAndMale",dataMap.get(0).get("NumPingYangAndZhongLiuAndMale"));
        jsonObject.put("NumPingYangAndZhongLiuAndFemale",dataMap.get(0).get("NumPingYangAndZhongLiuAndFemale"));
        jsonObject.put("NumPingYangAndZhongLiuAnd60To70M",dataMap.get(0).get("NumPingYangAndZhongLiuAnd60To70M"));
        jsonObject.put("NumPingYangAndZhongLiuAnd70To80M",dataMap.get(0).get("NumPingYangAndZhongLiuAnd70To80M"));
        jsonObject.put("NumPingYangAndZhongLiuAnd80To90M",dataMap.get(0).get("NumPingYangAndZhongLiuAnd80To90M"));
        jsonObject.put("NumPingYangAndZhongLiuAnd90AboveM",dataMap.get(0).get("NumPingYangAndZhongLiuAnd90AboveM"));
        jsonObject.put("NumPingYangAndZhongLiuAnd60To70F",dataMap.get(0).get("NumPingYangAndZhongLiuAnd60To70F"));
        jsonObject.put("NumPingYangAndZhongLiuAnd70To80F",dataMap.get(0).get("NumPingYangAndZhongLiuAnd70To80F"));
        jsonObject.put("NumPingYangAndZhongLiuAnd80To90F",dataMap.get(0).get("NumPingYangAndZhongLiuAnd80To90F"));
        jsonObject.put("NumPingYangAndZhongLiuAnd90AboveF",dataMap.get(0).get("NumPingYangAndZhongLiuAnd90AboveF"));

        jsonObject.put("NumPingYangAndGuZheAndHuJi",dataMap.get(0).get("NumPingYangAndGuZheAndHuJi"));
        jsonObject.put("NumPingYangAndGuZheAndFeiHuJi",dataMap.get(0).get("NumPingYangAndGuZheAndFeiHuJi"));
        jsonObject.put("NumPingYangAndGuZheAndMale",dataMap.get(0).get("NumPingYangAndGuZheAndMale"));
        jsonObject.put("NumPingYangAndGuZheAndFemale",dataMap.get(0).get("NumPingYangAndGuZheAndFemale"));
        jsonObject.put("NumPingYangAndGuZheAnd60To70M",dataMap.get(0).get("NumPingYangAndGuZheAnd60To70M"));
        jsonObject.put("NumPingYangAndGuZheAnd70To80M",dataMap.get(0).get("NumPingYangAndGuZheAnd70To80M"));
        jsonObject.put("NumPingYangAndGuZheAnd80To90M",dataMap.get(0).get("NumPingYangAndGuZheAnd80To90M"));
        jsonObject.put("NumPingYangAndGuZheAnd90AboveM",dataMap.get(0).get("NumPingYangAndGuZheAnd90AboveM"));
        jsonObject.put("NumPingYangAndGuZheAnd60To70F",dataMap.get(0).get("NumPingYangAndGuZheAnd60To70F"));
        jsonObject.put("NumPingYangAndGuZheAnd70To80F",dataMap.get(0).get("NumPingYangAndGuZheAnd70To80F"));
        jsonObject.put("NumPingYangAndGuZheAnd80To90F",dataMap.get(0).get("NumPingYangAndGuZheAnd80To90F"));
        jsonObject.put("NumPingYangAndGuZheAnd90AboveF",dataMap.get(0).get("NumPingYangAndGuZheAnd90AboveF"));

        jsonObject.put("NumPingYangAndShiZhiAndHuJi",dataMap.get(0).get("NumPingYangAndShiZhiAndHuJi"));
        jsonObject.put("NumPingYangAndShiZhiAndFeiHuJi",dataMap.get(0).get("NumPingYangAndShiZhiAndFeiHuJi"));
        jsonObject.put("NumPingYangAndShiZhiAndMale",dataMap.get(0).get("NumPingYangAndShiZhiAndMale"));
        jsonObject.put("NumPingYangAndShiZhiAndFemale",dataMap.get(0).get("NumPingYangAndShiZhiAndFemale"));
        jsonObject.put("NumPingYangAndShiZhiAnd60To70M",dataMap.get(0).get("NumPingYangAndShiZhiAnd60To70M"));
        jsonObject.put("NumPingYangAndShiZhiAnd70To80M",dataMap.get(0).get("NumPingYangAndShiZhiAnd70To80M"));
        jsonObject.put("NumPingYangAndShiZhiAnd80To90M",dataMap.get(0).get("NumPingYangAndShiZhiAnd80To90M"));
        jsonObject.put("NumPingYangAndShiZhiAnd90AboveM",dataMap.get(0).get("NumPingYangAndShiZhiAnd90AboveM"));
        jsonObject.put("NumPingYangAndShiZhiAnd60To70F",dataMap.get(0).get("NumPingYangAndShiZhiAnd60To70F"));
        jsonObject.put("NumPingYangAndShiZhiAnd70To80F",dataMap.get(0).get("NumPingYangAndShiZhiAnd70To80F"));
        jsonObject.put("NumPingYangAndShiZhiAnd80To90F",dataMap.get(0).get("NumPingYangAndShiZhiAnd80To90F"));
        jsonObject.put("NumPingYangAndShiZhiAnd90AboveF",dataMap.get(0).get("NumPingYangAndShiZhiAnd90AboveF"));

        jsonObject.put("NumPingYangAndChangHuAndHuJi",dataMap.get(0).get("NumPingYangAndChangHuAndHuJi"));
        jsonObject.put("NumPingYangAndChangHuAndFeiHuJi",dataMap.get(0).get("NumPingYangAndChangHuAndFeiHuJi"));
        jsonObject.put("NumPingYangAndChangHuAndMale",dataMap.get(0).get("NumPingYangAndChangHuAndMale"));
        jsonObject.put("NumPingYangAndChangHuAndFemale",dataMap.get(0).get("NumPingYangAndChangHuAndFemale"));
        jsonObject.put("NumPingYangAndChangHuAnd60To70M",dataMap.get(0).get("NumPingYangAndChangHuAnd60To70M"));
        jsonObject.put("NumPingYangAndChangHuAnd70To80M",dataMap.get(0).get("NumPingYangAndChangHuAnd70To80M"));
        jsonObject.put("NumPingYangAndChangHuAnd80To90M",dataMap.get(0).get("NumPingYangAndChangHuAnd80To90M"));
        jsonObject.put("NumPingYangAndChangHuAnd90AboveM",dataMap.get(0).get("NumPingYangAndChangHuAnd90AboveM"));
        jsonObject.put("NumPingYangAndChangHuAnd60To70F",dataMap.get(0).get("NumPingYangAndChangHuAnd60To70F"));
        jsonObject.put("NumPingYangAndChangHuAnd70To80F",dataMap.get(0).get("NumPingYangAndChangHuAnd70To80F"));
        jsonObject.put("NumPingYangAndChangHuAnd80To90F",dataMap.get(0).get("NumPingYangAndChangHuAnd80To90F"));
        jsonObject.put("NumPingYangAndChangHuAnd90AboveF",dataMap.get(0).get("NumPingYangAndChangHuAnd90AboveF"));

        jsonObject.put("NumPingYangAndQiTaAndHuJi",dataMap.get(0).get("NumPingYangAndQiTaAndHuJi"));
        jsonObject.put("NumPingYangAndQiTaAndFeiHuJi",dataMap.get(0).get("NumPingYangAndQiTaAndFeiHuJi"));
        jsonObject.put("NumPingYangAndQiTaAndMale",dataMap.get(0).get("NumPingYangAndQiTaAndMale"));
        jsonObject.put("NumPingYangAndQiTaAndFemale",dataMap.get(0).get("NumPingYangAndQiTaAndFemale"));
        jsonObject.put("NumPingYangAndQiTaAnd60To70M",dataMap.get(0).get("NumPingYangAndQiTaAnd60To70M"));
        jsonObject.put("NumPingYangAndQiTaAnd70To80M",dataMap.get(0).get("NumPingYangAndQiTaAnd70To80M"));
        jsonObject.put("NumPingYangAndQiTaAnd80To90M",dataMap.get(0).get("NumPingYangAndQiTaAnd80To90M"));
        jsonObject.put("NumPingYangAndQiTaAnd90AboveM",dataMap.get(0).get("NumPingYangAndQiTaAnd90AboveM"));
        jsonObject.put("NumPingYangAndQiTaAnd60To70F",dataMap.get(0).get("NumPingYangAndQiTaAnd60To70F"));
        jsonObject.put("NumPingYangAndQiTaAnd70To80F",dataMap.get(0).get("NumPingYangAndQiTaAnd70To80F"));
        jsonObject.put("NumPingYangAndQiTaAnd80To90F",dataMap.get(0).get("NumPingYangAndQiTaAnd80To90F"));
        jsonObject.put("NumPingYangAndQiTaAnd90AboveF",dataMap.get(0).get("NumPingYangAndQiTaAnd90AboveF"));

        //economy
        jsonObject.put("NumPingYangAndBangKunAndHuJi",dataMap.get(0).get("NumPingYangAndBangKunAndHuJi"));
        jsonObject.put("NumPingYangAndBangKunAndFeiHuJi",dataMap.get(0).get("NumPingYangAndBangKunAndFeiHuJi"));
        jsonObject.put("NumPingYangAndBangKunAndMale",dataMap.get(0).get("NumPingYangAndBangKunAndMale"));
        jsonObject.put("NumPingYangAndBangKunAndFemale",dataMap.get(0).get("NumPingYangAndBangKunAndFemale"));
        jsonObject.put("NumPingYangAndBangKunAnd60To70M",dataMap.get(0).get("NumPingYangAndBangKunAnd60To70M"));
        jsonObject.put("NumPingYangAndBangKunAnd70To80M",dataMap.get(0).get("NumPingYangAndBangKunAnd70To80M"));
        jsonObject.put("NumPingYangAndBangKunAnd80To90M",dataMap.get(0).get("NumPingYangAndBangKunAnd80To90M"));
        jsonObject.put("NumPingYangAndBangKunAnd90AboveM",dataMap.get(0).get("NumPingYangAndBangKunAnd90AboveM"));
        jsonObject.put("NumPingYangAndBangKunAnd60To70F",dataMap.get(0).get("NumPingYangAndBangKunAnd60To70F"));
        jsonObject.put("NumPingYangAndBangKunAnd70To80F",dataMap.get(0).get("NumPingYangAndBangKunAnd70To80F"));
        jsonObject.put("NumPingYangAndBangKunAnd80To90F",dataMap.get(0).get("NumPingYangAndBangKunAnd80To90F"));
        jsonObject.put("NumPingYangAndBangKunAnd90AboveF",dataMap.get(0).get("NumPingYangAndBangKunAnd90AboveF"));

        jsonObject.put("NumPingYangAndDiBaoAndHuJi",dataMap.get(0).get("NumPingYangAndDiBaoAndHuJi"));
        jsonObject.put("NumPingYangAndDiBaoAndFeiHuJi",dataMap.get(0).get("NumPingYangAndDiBaoAndFeiHuJi"));
        jsonObject.put("NumPingYangAndDiBaoAndMale",dataMap.get(0).get("NumPingYangAndDiBaoAndMale"));
        jsonObject.put("NumPingYangAndDiBaoAndFemale",dataMap.get(0).get("NumPingYangAndDiBaoAndFemale"));
        jsonObject.put("NumPingYangAndDiBaoAnd60To70M",dataMap.get(0).get("NumPingYangAndDiBaoAnd60To70M"));
        jsonObject.put("NumPingYangAndDiBaoAnd70To80M",dataMap.get(0).get("NumPingYangAndDiBaoAnd70To80M"));
        jsonObject.put("NumPingYangAndDiBaoAnd80To90M",dataMap.get(0).get("NumPingYangAndDiBaoAnd80To90M"));
        jsonObject.put("NumPingYangAndDiBaoAnd90AboveM",dataMap.get(0).get("NumPingYangAndDiBaoAnd90AboveM"));
        jsonObject.put("NumPingYangAndDiBaoAnd60To70F",dataMap.get(0).get("NumPingYangAndDiBaoAnd60To70F"));
        jsonObject.put("NumPingYangAndDiBaoAnd70To80F",dataMap.get(0).get("NumPingYangAndDiBaoAnd70To80F"));
        jsonObject.put("NumPingYangAndDiBaoAnd80To90F",dataMap.get(0).get("NumPingYangAndDiBaoAnd80To90F"));
        jsonObject.put("NumPingYangAndDiBaoAnd90AboveF",dataMap.get(0).get("NumPingYangAndDiBaoAnd90AboveF"));

        jsonObject.put("NumPingYangAndYangLaoAndHuJi",dataMap.get(0).get("NumPingYangAndYangLaoAndHuJi"));
        jsonObject.put("NumPingYangAndYangLaoLiuAndFeiHuJi",dataMap.get(0).get("NumPingYangAndYangLaoLiuAndFeiHuJi"));
        jsonObject.put("NumPingYangAndYangLaoAndMale",dataMap.get(0).get("NumPingYangAndYangLaoAndMale"));
        jsonObject.put("NumPingYangAndYangLaoAndFemale",dataMap.get(0).get("NumPingYangAndYangLaoAndFemale"));
        jsonObject.put("NumPingYangAndYangLaoAnd60To70M",dataMap.get(0).get("NumPingYangAndYangLaoAnd60To70M"));
        jsonObject.put("NumPingYangAndYangLaoAnd70To80M",dataMap.get(0).get("NumPingYangAndYangLaoAnd70To80M"));
        jsonObject.put("NumPingYangAndYangLaoAnd80To90M",dataMap.get(0).get("NumPingYangAndYangLaoAnd80To90M"));
        jsonObject.put("NumPingYangAndYangLaoAnd90AboveM",dataMap.get(0).get("NumPingYangAndYangLaoAnd90AboveM"));
        jsonObject.put("NumPingYangAndYangLaoAnd60To70F",dataMap.get(0).get("NumPingYangAndYangLaoAnd60To70F"));
        jsonObject.put("NumPingYangAndYangLaoAnd70To80F",dataMap.get(0).get("NumPingYangAndYangLaoAnd70To80F"));
        jsonObject.put("NumPingYangAndYangLaoAnd80To90F",dataMap.get(0).get("NumPingYangAndYangLaoAnd80To90F"));
        jsonObject.put("NumPingYangAndYangLaoAnd90AboveF",dataMap.get(0).get("NumPingYangAndYangLaoAnd90AboveF"));

        jsonObject.put("NumPingYangAndYiLiaoAndHuJi",dataMap.get(0).get("NumPingYangAndYiLiaoAndHuJi"));
        jsonObject.put("NumPingYangAndYiLiaoAndFeiHuJi",dataMap.get(0).get("NumPingYangAndYiLiaoAndFeiHuJi"));
        jsonObject.put("NumPingYangAndYiLiaoAndMale",dataMap.get(0).get("NumPingYangAndYiLiaoAndMale"));
        jsonObject.put("NumPingYangAndYiLiaoAndFemale",dataMap.get(0).get("NumPingYangAndYiLiaoAndFemale"));
        jsonObject.put("NumPingYangAndYiLiaoAnd60To70M",dataMap.get(0).get("NumPingYangAndYiLiaoAnd60To70M"));
        jsonObject.put("NumPingYangAndYiLiaoAnd70To80M",dataMap.get(0).get("NumPingYangAndYiLiaoAnd70To80M"));
        jsonObject.put("NumPingYangAndYiLiaoAnd80To90M",dataMap.get(0).get("NumPingYangAndYiLiaoAnd80To90M"));
        jsonObject.put("NumPingYangAndYiLiaoAnd90AboveM",dataMap.get(0).get("NumPingYangAndYiLiaoAnd90AboveM"));
        jsonObject.put("NumPingYangAndYiLiaoAnd60To70F",dataMap.get(0).get("NumPingYangAndYiLiaoAnd60To70F"));
        jsonObject.put("NumPingYangAndYiLiaoAnd70To80F",dataMap.get(0).get("NumPingYangAndYiLiaoAnd70To80F"));
        jsonObject.put("NumPingYangAndYiLiaoAnd80To90F",dataMap.get(0).get("NumPingYangAndYiLiaoAnd80To90F"));
        jsonObject.put("NumPingYangAndYiLiaoAnd90AboveF",dataMap.get(0).get("NumPingYangAndYiLiaoAnd90AboveF"));

        jsonObject.put("NumPingYangAndChenZhenAndHuJi",dataMap.get(0).get("NumPingYangAndChenZhenAndHuJi"));
        jsonObject.put("NumPingYangAndChenZhenAndFeiHuJi",dataMap.get(0).get("NumPingYangAndChenZhenAndFeiHuJi"));
        jsonObject.put("NumPingYangAndChenZhenAndMale",dataMap.get(0).get("NumPingYangAndChenZhenAndMale"));
        jsonObject.put("NumPingYangAndChenZhenAndFemale",dataMap.get(0).get("NumPingYangAndChenZhenAndFemale"));
        jsonObject.put("NumPingYangAndChenZhenAnd60To70M",dataMap.get(0).get("NumPingYangAndChenZhenAnd60To70M"));
        jsonObject.put("NumPingYangAndChenZhenAnd70To80M",dataMap.get(0).get("NumPingYangAndChenZhenAnd70To80M"));
        jsonObject.put("NumPingYangAndChenZhenAnd80To90M",dataMap.get(0).get("NumPingYangAndChenZhenAnd80To90M"));
        jsonObject.put("NumPingYangAndChenZhenAnd90AboveM",dataMap.get(0).get("NumPingYangAndChenZhenAnd90AboveM"));
        jsonObject.put("NumPingYangAndChenZhenAnd60To70F",dataMap.get(0).get("NumPingYangAndChenZhenAnd60To70F"));
        jsonObject.put("NumPingYangAndChenZhenAnd70To80F",dataMap.get(0).get("NumPingYangAndChenZhenAnd70To80F"));
        jsonObject.put("NumPingYangAndChenZhenAnd80To90F",dataMap.get(0).get("NumPingYangAndChenZhenAnd80To90F"));
        jsonObject.put("NumPingYangAndChenZhenAnd90AboveF",dataMap.get(0).get("NumPingYangAndChenZhenAnd90AboveF"));

//pingnan
        //family
        jsonObject.put("NumPingNanAndChunLaoAndHuJi",dataMap.get(0).get("NumPingNanAndChunLaoAndHuJi"));
        jsonObject.put("NumPingNanAndChunLaoAndFeiHuJi",dataMap.get(0).get("NumPingNanAndChunLaoAndFeiHuJi"));
        jsonObject.put("NumPingNanAndChunLaoAndMale",dataMap.get(0).get("NumPingNanAndChunLaoAndMale"));
        jsonObject.put("NumPingNanAndChunLaoAndFemale",dataMap.get(0).get("NumPingNanAndChunLaoAndFemale"));
        jsonObject.put("NumPingNanAndChunLaoAnd60To70M",dataMap.get(0).get("NumPingNanAndChunLaoAnd60To70M"));
        jsonObject.put("NumPingNanAndChunLaoAnd70To80M",dataMap.get(0).get("NumPingNanAndChunLaoAnd70To80M"));
        jsonObject.put("NumPingNanAndChunLaoAnd80To90M",dataMap.get(0).get("NumPingNanAndChunLaoAnd80To90M"));
        jsonObject.put("NumPingNanAndChunLaoAnd90AboveM",dataMap.get(0).get("NumPingNanAndChunLaoAnd90AboveM"));
        jsonObject.put("NumPingNanAndChunLaoAnd60To70F",dataMap.get(0).get("NumPingNanAndChunLaoAnd60To70F"));
        jsonObject.put("NumPingNanAndChunLaoAnd70To80F",dataMap.get(0).get("NumPingNanAndChunLaoAnd70To80F"));
        jsonObject.put("NumPingNanAndChunLaoAnd80To90F",dataMap.get(0).get("NumPingNanAndChunLaoAnd80To90F"));
        jsonObject.put("NumPingNanAndChunLaoAnd90AboveF",dataMap.get(0).get("NumPingNanAndChunLaoAnd90AboveF"));


        jsonObject.put("NumPingNanAndDuJuAndHuJi",dataMap.get(0).get("NumPingNanAndDuJuAndHuJi"));
        jsonObject.put("NumPingNanAndDuJuAndFeiHuJi",dataMap.get(0).get("NumPingNanAndDuJuAndFeiHuJi"));
        jsonObject.put("NumPingNanAndDuJuAndMale",dataMap.get(0).get("NumPingNanAndDuJuAndMale"));
        jsonObject.put("NumPingNanAndDuJuAndFemale",dataMap.get(0).get("NumPingNanAndDuJuAndFemale"));
        jsonObject.put("NumPingNanAndDuJuAnd60To70M",dataMap.get(0).get("NumPingNanAndDuJuAnd60To70M"));
        jsonObject.put("NumPingNanAndDuJuAnd70To80M",dataMap.get(0).get("NumPingNanAndDuJuAnd70To80M"));
        jsonObject.put("NumPingNanAndDuJuAnd80To90M",dataMap.get(0).get("NumPingNanAndDuJuAnd80To90M"));
        jsonObject.put("NumPingNanAndDuJuAnd90AboveM",dataMap.get(0).get("NumPingNanAndDuJuAnd90AboveM"));
        jsonObject.put("NumPingNanAndDuJuAnd60To70F",dataMap.get(0).get("NumPingNanAndDuJuAnd60To70F"));
        jsonObject.put("NumPingNanAndDuJuAnd70To80F",dataMap.get(0).get("NumPingNanAndDuJuAnd70To80F"));
        jsonObject.put("NumPingNanAndDuJuAnd80To90F",dataMap.get(0).get("NumPingNanAndDuJuAnd80To90F"));
        jsonObject.put("NumPingNanAndDuJuAnd90AboveF",dataMap.get(0).get("NumPingNanAndDuJuAnd90AboveF"));


        jsonObject.put("NumPingNanAndShiDuAndHuJi",dataMap.get(0).get("NumPingNanAndShiDuAndHuJi"));
        jsonObject.put("NumPingNanAndShiDuAndFeiHuJi",dataMap.get(0).get("NumPingNanAndShiDuAndFeiHuJi"));
        jsonObject.put("NumPingNanAndShiDuAndMale",dataMap.get(0).get("NumPingNanAndShiDuAndMale"));
        jsonObject.put("NumPingNanAndShiDuAndFemale",dataMap.get(0).get("NumPingNanAndShiDuAndFemale"));
        jsonObject.put("NumPingNanAndShiDuAnd60To70M",dataMap.get(0).get("NumPingNanAndShiDuAnd60To70M"));
        jsonObject.put("NumPingNanAndShiDuAnd70To80M",dataMap.get(0).get("NumPingNanAndShiDuAnd70To80M"));
        jsonObject.put("NumPingNanAndShiDuAnd80To90M",dataMap.get(0).get("NumPingNanAndShiDuAnd80To90M"));
        jsonObject.put("NumPingNanAndShiDuAnd90AboveM",dataMap.get(0).get("NumPingNanAndShiDuAnd90AboveM"));
        jsonObject.put("NumPingNanAndShiDuAnd60To70F",dataMap.get(0).get("NumPingNanAndShiDuAnd60To70F"));
        jsonObject.put("NumPingNanAndShiDuAnd70To80F",dataMap.get(0).get("NumPingNanAndShiDuAnd70To80F"));
        jsonObject.put("NumPingNanAndShiDuAnd80To90F",dataMap.get(0).get("NumPingNanAndShiDuAnd80To90F"));
        jsonObject.put("NumPingNanAndShiDuAnd90AboveF",dataMap.get(0).get("NumPingNanAndShiDuAnd90AboveF"));

        jsonObject.put("NumPingNanAndYiLaoAndHuJi",dataMap.get(0).get("NumPingNanAndYiLaoAndHuJi"));
        jsonObject.put("NumPingNanAndYiLaoAndFeiHuJi",dataMap.get(0).get("NumPingNanAndYiLaoAndFeiHuJi"));
        jsonObject.put("NumPingNanAndYiLaoAndMale",dataMap.get(0).get("NumPingNanAndYiLaoAndMale"));
        jsonObject.put("NumPingNanAndYiLaoAndFemale",dataMap.get(0).get("NumPingNanAndYiLaoAndFemale"));
        jsonObject.put("NumPingNanAndYiLaoAnd60To70M",dataMap.get(0).get("NumPingNanAndYiLaoAnd60To70M"));
        jsonObject.put("NumPingNanAndYiLaoAnd70To80M",dataMap.get(0).get("NumPingNanAndYiLaoAnd70To80M"));
        jsonObject.put("NumPingNanAndYiLaoAnd80To90M",dataMap.get(0).get("NumPingNanAndYiLaoAnd80To90M"));
        jsonObject.put("NumPingNanAndYiLaoAnd90AboveM",dataMap.get(0).get("NumPingNanAndYiLaoAnd90AboveM"));
        jsonObject.put("NumPingNanAndYiLaoAnd60To70F",dataMap.get(0).get("NumPingNanAndYiLaoAnd60To70F"));
        jsonObject.put("NumPingNanAndYiLaoAnd70To80F",dataMap.get(0).get("NumPingNanAndYiLaoAnd70To80F"));
        jsonObject.put("NumPingNanAndYiLaoAnd80To90F",dataMap.get(0).get("NumPingNanAndYiLaoAnd80To90F"));
        jsonObject.put("NumPingNanAndYiLaoAnd90AboveF",dataMap.get(0).get("NumPingNanAndYiLaoAnd90AboveF"));

        jsonObject.put("NumPingNanAndGuLaoAndHuJi",dataMap.get(0).get("NumPingNanAndGuLaoAndHuJi"));
        jsonObject.put("NumPingNanAndGuLaoAndFeiHuJi",dataMap.get(0).get("NumPingNanAndGuLaoAndFeiHuJi"));
        jsonObject.put("NumPingNanAndGuLaoAndMale",dataMap.get(0).get("NumPingNanAndGuLaoAndMale"));
        jsonObject.put("NumPingNanAndGuLaoAndFemale",dataMap.get(0).get("NumPingNanAndGuLaoAndFemale"));
        jsonObject.put("NumPingNanAndGuLaoAnd60To70M",dataMap.get(0).get("NumPingNanAndGuLaoAnd60To70M"));
        jsonObject.put("NumPingNanAndGuLaoAnd70To80M",dataMap.get(0).get("NumPingNanAndGuLaoAnd70To80M"));
        jsonObject.put("NumPingNanAndGuLaoAnd80To90M",dataMap.get(0).get("NumPingNanAndGuLaoAnd80To90M"));
        jsonObject.put("NumPingNanAndGuLaoAnd90AboveM",dataMap.get(0).get("NumPingNanAndGuLaoAnd90AboveM"));
        jsonObject.put("NumPingNanAndGuLaoAnd60To70F",dataMap.get(0).get("NumPingNanAndGuLaoAnd60To70F"));
        jsonObject.put("NumPingNanAndGuLaoAnd70To80F",dataMap.get(0).get("NumPingNanAndGuLaoAnd70To80F"));
        jsonObject.put("NumPingNanAndGuLaoAnd80To90F",dataMap.get(0).get("NumPingNanAndGuLaoAnd80To90F"));
        jsonObject.put("NumPingNanAndGuLaoAnd90AboveF",dataMap.get(0).get("NumPingNanAndGuLaoAnd90AboveF"));

        jsonObject.put("NumPingNanAndSanZhiAndHuJi",dataMap.get(0).get("NumPingNanAndSanZhiAndHuJi"));
        jsonObject.put("NumPingNanAndSanZhiAndFeiHuJi",dataMap.get(0).get("NumPingNanAndSanZhiAndFeiHuJi"));
        jsonObject.put("NumPingNanAndSanZhiAndMale",dataMap.get(0).get("NumPingNanAndSanZhiAndMale"));
        jsonObject.put("NumPingNanAndSanZhiAndFemale",dataMap.get(0).get("NumPingNanAndSanZhiAndFemale"));
        jsonObject.put("NumPingNanAndSanZhiAnd60To70M",dataMap.get(0).get("NumPingNanAndSanZhiAnd60To70M"));
        jsonObject.put("NumPingNanAndSanZhiAnd70To80M",dataMap.get(0).get("NumPingNanAndSanZhiAnd70To80M"));
        jsonObject.put("NumPingNanAndSanZhiAnd80To90M",dataMap.get(0).get("NumPingNanAndSanZhiAnd80To90M"));
        jsonObject.put("NumPingNanAndSanZhiAnd90AboveM",dataMap.get(0).get("NumPingNanAndSanZhiAnd90AboveM"));
        jsonObject.put("NumPingNanAndSanZhiAnd60To70F",dataMap.get(0).get("NumPingNanAndSanZhiAnd60To70F"));
        jsonObject.put("NumPingNanAndSanZhiAnd70To80F",dataMap.get(0).get("NumPingNanAndSanZhiAnd70To80F"));
        jsonObject.put("NumPingNanAndSanZhiAnd80To90F",dataMap.get(0).get("NumPingNanAndSanZhiAnd80To90F"));
        jsonObject.put("NumPingNanAndSanZhiAnd90AboveF",dataMap.get(0).get("NumPingNanAndSanZhiAnd90AboveF"));

        jsonObject.put("NumPingNanAndQiTaAndHuJi",dataMap.get(0).get("NumPingNanAndQiTaAndHuJi"));
        jsonObject.put("NumPingNanAndQiTaAndFeiHuJi",dataMap.get(0).get("NumPingNanAndQiTaAndFeiHuJi"));
        jsonObject.put("NumPingNanAndQiTaAndMale",dataMap.get(0).get("NumPingNanAndQiTaAndMale"));
        jsonObject.put("NumPingNanAndQiTaAndFemale",dataMap.get(0).get("NumPingNanAndQiTaAndFemale"));
        jsonObject.put("NumPingNanAndQiTaAnd60To70M",dataMap.get(0).get("NumPingNanAndQiTaAnd60To70M"));
        jsonObject.put("NumPingNanAndQiTaAnd70To80M",dataMap.get(0).get("NumPingNanAndQiTaAnd70To80M"));
        jsonObject.put("NumPingNanAndQiTaAnd80To90M",dataMap.get(0).get("NumPingNanAndQiTaAnd80To90M"));
        jsonObject.put("NumPingNanAndQiTaAnd90AboveM",dataMap.get(0).get("NumPingNanAndQiTaAnd90AboveM"));
        jsonObject.put("NumPingNanAndQiTaAnd60To70F",dataMap.get(0).get("NumPingNanAndQiTaAnd60To70F"));
        jsonObject.put("NumPingNanAndQiTaAnd70To80F",dataMap.get(0).get("NumPingNanAndQiTaAnd70To80F"));
        jsonObject.put("NumPingNanAndQiTaAnd80To90F",dataMap.get(0).get("NumPingNanAndQiTaAnd80To90F"));
        jsonObject.put("NumPingNanAndQiTaAnd90AboveF",dataMap.get(0).get("NumPingNanAndQiTaAnd90AboveF"));

        //health
        jsonObject.put("NumPingNanAndShiNengAndHuJi",dataMap.get(0).get("NumPingNanAndShiNengAndHuJi"));
        jsonObject.put("NumPingNanAndShiNengAndFeiHuJi",dataMap.get(0).get("NumPingNanAndShiNengAndFeiHuJi"));
        jsonObject.put("NumPingNanAndShiNengAndMale",dataMap.get(0).get("NumPingNanAndShiNengAndMale"));
        jsonObject.put("NumPingNanAndShiNengAndFemale",dataMap.get(0).get("NumPingNanAndShiNengAndFemale"));
        jsonObject.put("NumPingNanAndShiNengAnd60To70M",dataMap.get(0).get("NumPingNanAndShiNengAnd60To70M"));
        jsonObject.put("NumPingNanAndShiNengAnd70To80M",dataMap.get(0).get("NumPingNanAndShiNengAnd70To80M"));
        jsonObject.put("NumPingNanAndShiNengAnd80To90M",dataMap.get(0).get("NumPingNanAndShiNengAnd80To90M"));
        jsonObject.put("NumPingNanAndShiNengAnd90AboveM",dataMap.get(0).get("NumPingNanAndShiNengAnd90AboveM"));
        jsonObject.put("NumPingNanAndShiNengAnd60To70F",dataMap.get(0).get("NumPingNanAndShiNengAnd60To70F"));
        jsonObject.put("NumPingNanAndShiNengAnd70To80F",dataMap.get(0).get("NumPingNanAndShiNengAnd70To80F"));
        jsonObject.put("NumPingNanAndShiNengAnd80To90F",dataMap.get(0).get("NumPingNanAndShiNengAnd80To90F"));
        jsonObject.put("NumPingNanAndShiNengAnd90AboveF",dataMap.get(0).get("NumPingNanAndShiNengAnd90AboveF"));

        jsonObject.put("NumPingNanAndManBingAndHuJi",dataMap.get(0).get("NumPingNanAndManBingAndHuJi"));
        jsonObject.put("NumPingNanAndManBingAndFeiHuJi",dataMap.get(0).get("NumPingNanAndManBingAndFeiHuJi"));
        jsonObject.put("NumPingNanAndManBingAndMale",dataMap.get(0).get("NumPingNanAndManBingAndMale"));
        jsonObject.put("NumPingNanAndManBingAndFemale",dataMap.get(0).get("NumPingNanAndManBingAndFemale"));
        jsonObject.put("NumPingNanAndManBingAnd60To70M",dataMap.get(0).get("NumPingNanAndManBingAnd60To70M"));
        jsonObject.put("NumPingNanAndManBingAnd70To80M",dataMap.get(0).get("NumPingNanAndManBingAnd70To80M"));
        jsonObject.put("NumPingNanAndManBingAnd80To90M",dataMap.get(0).get("NumPingNanAndManBingAnd80To90M"));
        jsonObject.put("NumPingNanAndManBingAnd90AboveM",dataMap.get(0).get("NumPingNanAndManBingAnd90AboveM"));
        jsonObject.put("NumPingNanAndManBingAnd60To70F",dataMap.get(0).get("NumPingNanAndManBingAnd60To70F"));
        jsonObject.put("NumPingNanAndManBingAnd70To80F",dataMap.get(0).get("NumPingNanAndManBingAnd70To80F"));
        jsonObject.put("NumPingNanAndManBingAnd80To90F",dataMap.get(0).get("NumPingNanAndManBingAnd80To90F"));
        jsonObject.put("NumPingNanAndManBingAnd90AboveF",dataMap.get(0).get("NumPingNanAndManBingAnd90AboveF"));

        jsonObject.put("NumPingNanAndZhongLiuAndHuJi",dataMap.get(0).get("NumPingNanAndZhongLiuAndHuJi"));
        jsonObject.put("NumPingNanAndZhongLiuAndFeiHuJi",dataMap.get(0).get("NumPingNanAndZhongLiuAndFeiHuJi"));
        jsonObject.put("NumPingNanAndZhongLiuAndMale",dataMap.get(0).get("NumPingNanAndZhongLiuAndMale"));
        jsonObject.put("NumPingNanAndZhongLiuAndFemale",dataMap.get(0).get("NumPingNanAndZhongLiuAndFemale"));
        jsonObject.put("NumPingNanAndZhongLiuAnd60To70M",dataMap.get(0).get("NumPingNanAndZhongLiuAnd60To70M"));
        jsonObject.put("NumPingNanAndZhongLiuAnd70To80M",dataMap.get(0).get("NumPingNanAndZhongLiuAnd70To80M"));
        jsonObject.put("NumPingNanAndZhongLiuAnd80To90M",dataMap.get(0).get("NumPingNanAndZhongLiuAnd80To90M"));
        jsonObject.put("NumPingNanAndZhongLiuAnd90AboveM",dataMap.get(0).get("NumPingNanAndZhongLiuAnd90AboveM"));
        jsonObject.put("NumPingNanAndZhongLiuAnd60To70F",dataMap.get(0).get("NumPingNanAndZhongLiuAnd60To70F"));
        jsonObject.put("NumPingNanAndZhongLiuAnd70To80F",dataMap.get(0).get("NumPingNanAndZhongLiuAnd70To80F"));
        jsonObject.put("NumPingNanAndZhongLiuAnd80To90F",dataMap.get(0).get("NumPingNanAndZhongLiuAnd80To90F"));
        jsonObject.put("NumPingNanAndZhongLiuAnd90AboveF",dataMap.get(0).get("NumPingNanAndZhongLiuAnd90AboveF"));

        jsonObject.put("NumPingNanAndGuZheAndHuJi",dataMap.get(0).get("NumPingNanAndGuZheAndHuJi"));
        jsonObject.put("NumPingNanAndGuZheAndFeiHuJi",dataMap.get(0).get("NumPingNanAndGuZheAndFeiHuJi"));
        jsonObject.put("NumPingNanAndGuZheAndMale",dataMap.get(0).get("NumPingNanAndGuZheAndMale"));
        jsonObject.put("NumPingNanAndGuZheAndFemale",dataMap.get(0).get("NumPingNanAndGuZheAndFemale"));
        jsonObject.put("NumPingNanAndGuZheAnd60To70M",dataMap.get(0).get("NumPingNanAndGuZheAnd60To70M"));
        jsonObject.put("NumPingNanAndGuZheAnd70To80M",dataMap.get(0).get("NumPingNanAndGuZheAnd70To80M"));
        jsonObject.put("NumPingNanAndGuZheAnd80To90M",dataMap.get(0).get("NumPingNanAndGuZheAnd80To90M"));
        jsonObject.put("NumPingNanAndGuZheAnd90AboveM",dataMap.get(0).get("NumPingNanAndGuZheAnd90AboveM"));
        jsonObject.put("NumPingNanAndGuZheAnd60To70F",dataMap.get(0).get("NumPingNanAndGuZheAnd60To70F"));
        jsonObject.put("NumPingNanAndGuZheAnd70To80F",dataMap.get(0).get("NumPingNanAndGuZheAnd70To80F"));
        jsonObject.put("NumPingNanAndGuZheAnd80To90F",dataMap.get(0).get("NumPingNanAndGuZheAnd80To90F"));
        jsonObject.put("NumPingNanAndGuZheAnd90AboveF",dataMap.get(0).get("NumPingNanAndGuZheAnd90AboveF"));

        jsonObject.put("NumPingNanAndShiZhiAndHuJi",dataMap.get(0).get("NumPingNanAndShiZhiAndHuJi"));
        jsonObject.put("NumPingNanAndShiZhiAndFeiHuJi",dataMap.get(0).get("NumPingNanAndShiZhiAndFeiHuJi"));
        jsonObject.put("NumPingNanAndShiZhiAndMale",dataMap.get(0).get("NumPingNanAndShiZhiAndMale"));
        jsonObject.put("NumPingNanAndShiZhiAndFemale",dataMap.get(0).get("NumPingNanAndShiZhiAndFemale"));
        jsonObject.put("NumPingNanAndShiZhiAnd60To70M",dataMap.get(0).get("NumPingNanAndShiZhiAnd60To70M"));
        jsonObject.put("NumPingNanAndShiZhiAnd70To80M",dataMap.get(0).get("NumPingNanAndShiZhiAnd70To80M"));
        jsonObject.put("NumPingNanAndShiZhiAnd80To90M",dataMap.get(0).get("NumPingNanAndShiZhiAnd80To90M"));
        jsonObject.put("NumPingNanAndShiZhiAnd90AboveM",dataMap.get(0).get("NumPingNanAndShiZhiAnd90AboveM"));
        jsonObject.put("NumPingNanAndShiZhiAnd60To70F",dataMap.get(0).get("NumPingNanAndShiZhiAnd60To70F"));
        jsonObject.put("NumPingNanAndShiZhiAnd70To80F",dataMap.get(0).get("NumPingNanAndShiZhiAnd70To80F"));
        jsonObject.put("NumPingNanAndShiZhiAnd80To90F",dataMap.get(0).get("NumPingNanAndShiZhiAnd80To90F"));
        jsonObject.put("NumPingNanAndShiZhiAnd90AboveF",dataMap.get(0).get("NumPingNanAndShiZhiAnd90AboveF"));

        jsonObject.put("NumPingNanAndChangHuAndHuJi",dataMap.get(0).get("NumPingNanAndChangHuAndHuJi"));
        jsonObject.put("NumPingNanAndChangHuAndFeiHuJi",dataMap.get(0).get("NumPingNanAndChangHuAndFeiHuJi"));
        jsonObject.put("NumPingNanAndChangHuAndMale",dataMap.get(0).get("NumPingNanAndChangHuAndMale"));
        jsonObject.put("NumPingNanAndChangHuAndFemale",dataMap.get(0).get("NumPingNanAndChangHuAndFemale"));
        jsonObject.put("NumPingNanAndChangHuAnd60To70M",dataMap.get(0).get("NumPingNanAndChangHuAnd60To70M"));
        jsonObject.put("NumPingNanAndChangHuAnd70To80M",dataMap.get(0).get("NumPingNanAndChangHuAnd70To80M"));
        jsonObject.put("NumPingNanAndChangHuAnd80To90M",dataMap.get(0).get("NumPingNanAndChangHuAnd80To90M"));
        jsonObject.put("NumPingNanAndChangHuAnd90AboveM",dataMap.get(0).get("NumPingNanAndChangHuAnd90AboveM"));
        jsonObject.put("NumPingNanAndChangHuAnd60To70F",dataMap.get(0).get("NumPingNanAndChangHuAnd60To70F"));
        jsonObject.put("NumPingNanAndChangHuAnd70To80F",dataMap.get(0).get("NumPingNanAndChangHuAnd70To80F"));
        jsonObject.put("NumPingNanAndChangHuAnd80To90F",dataMap.get(0).get("NumPingNanAndChangHuAnd80To90F"));
        jsonObject.put("NumPingNanAndChangHuAnd90AboveF",dataMap.get(0).get("NumPingNanAndChangHuAnd90AboveF"));

        jsonObject.put("NumPingNanAndQiTaAndHuJi",dataMap.get(0).get("NumPingNanAndQiTaAndHuJi"));
        jsonObject.put("NumPingNanAndQiTaAndFeiHuJi",dataMap.get(0).get("NumPingNanAndQiTaAndFeiHuJi"));
        jsonObject.put("NumPingNanAndQiTaAndMale",dataMap.get(0).get("NumPingNanAndQiTaAndMale"));
        jsonObject.put("NumPingNanAndQiTaAndFemale",dataMap.get(0).get("NumPingNanAndQiTaAndFemale"));
        jsonObject.put("NumPingNanAndQiTaAnd60To70M",dataMap.get(0).get("NumPingNanAndQiTaAnd60To70M"));
        jsonObject.put("NumPingNanAndQiTaAnd70To80M",dataMap.get(0).get("NumPingNanAndQiTaAnd70To80M"));
        jsonObject.put("NumPingNanAndQiTaAnd80To90M",dataMap.get(0).get("NumPingNanAndQiTaAnd80To90M"));
        jsonObject.put("NumPingNanAndQiTaAnd90AboveM",dataMap.get(0).get("NumPingNanAndQiTaAnd90AboveM"));
        jsonObject.put("NumPingNanAndQiTaAnd60To70F",dataMap.get(0).get("NumPingNanAndQiTaAnd60To70F"));
        jsonObject.put("NumPingNanAndQiTaAnd70To80F",dataMap.get(0).get("NumPingNanAndQiTaAnd70To80F"));
        jsonObject.put("NumPingNanAndQiTaAnd80To90F",dataMap.get(0).get("NumPingNanAndQiTaAnd80To90F"));
        jsonObject.put("NumPingNanAndQiTaAnd90AboveF",dataMap.get(0).get("NumPingNanAndQiTaAnd90AboveF"));

        //economy
        jsonObject.put("NumPingNanAndBangKunAndHuJi",dataMap.get(0).get("NumPingNanAndBangKunAndHuJi"));
        jsonObject.put("NumPingNanAndBangKunAndFeiHuJi",dataMap.get(0).get("NumPingNanAndBangKunAndFeiHuJi"));
        jsonObject.put("NumPingNanAndBangKunAndMale",dataMap.get(0).get("NumPingNanAndBangKunAndMale"));
        jsonObject.put("NumPingNanAndBangKunAndFemale",dataMap.get(0).get("NumPingNanAndBangKunAndFemale"));
        jsonObject.put("NumPingNanAndBangKunAnd60To70M",dataMap.get(0).get("NumPingNanAndBangKunAnd60To70M"));
        jsonObject.put("NumPingNanAndBangKunAnd70To80M",dataMap.get(0).get("NumPingNanAndBangKunAnd70To80M"));
        jsonObject.put("NumPingNanAndBangKunAnd80To90M",dataMap.get(0).get("NumPingNanAndBangKunAnd80To90M"));
        jsonObject.put("NumPingNanAndBangKunAnd90AboveM",dataMap.get(0).get("NumPingNanAndBangKunAnd90AboveM"));
        jsonObject.put("NumPingNanAndBangKunAnd60To70F",dataMap.get(0).get("NumPingNanAndBangKunAnd60To70F"));
        jsonObject.put("NumPingNanAndBangKunAnd70To80F",dataMap.get(0).get("NumPingNanAndBangKunAnd70To80F"));
        jsonObject.put("NumPingNanAndBangKunAnd80To90F",dataMap.get(0).get("NumPingNanAndBangKunAnd80To90F"));
        jsonObject.put("NumPingNanAndBangKunAnd90AboveF",dataMap.get(0).get("NumPingNanAndBangKunAnd90AboveF"));

        jsonObject.put("NumPingNanAndDiBaoAndHuJi",dataMap.get(0).get("NumPingNanAndDiBaoAndHuJi"));
        jsonObject.put("NumPingNanAndDiBaoAndFeiHuJi",dataMap.get(0).get("NumPingNanAndDiBaoAndFeiHuJi"));
        jsonObject.put("NumPingNanAndDiBaoAndMale",dataMap.get(0).get("NumPingNanAndDiBaoAndMale"));
        jsonObject.put("NumPingNanAndDiBaoAndFemale",dataMap.get(0).get("NumPingNanAndDiBaoAndFemale"));
        jsonObject.put("NumPingNanAndDiBaoAnd60To70M",dataMap.get(0).get("NumPingNanAndDiBaoAnd60To70M"));
        jsonObject.put("NumPingNanAndDiBaoAnd70To80M",dataMap.get(0).get("NumPingNanAndDiBaoAnd70To80M"));
        jsonObject.put("NumPingNanAndDiBaoAnd80To90M",dataMap.get(0).get("NumPingNanAndDiBaoAnd80To90M"));
        jsonObject.put("NumPingNanAndDiBaoAnd90AboveM",dataMap.get(0).get("NumPingNanAndDiBaoAnd90AboveM"));
        jsonObject.put("NumPingNanAndDiBaoAnd60To70F",dataMap.get(0).get("NumPingNanAndDiBaoAnd60To70F"));
        jsonObject.put("NumPingNanAndDiBaoAnd70To80F",dataMap.get(0).get("NumPingNanAndDiBaoAnd70To80F"));
        jsonObject.put("NumPingNanAndDiBaoAnd80To90F",dataMap.get(0).get("NumPingNanAndDiBaoAnd80To90F"));
        jsonObject.put("NumPingNanAndDiBaoAnd90AboveF",dataMap.get(0).get("NumPingNanAndDiBaoAnd90AboveF"));

        jsonObject.put("NumPingNanAndYangLaoAndHuJi",dataMap.get(0).get("NumPingNanAndYangLaoAndHuJi"));
        jsonObject.put("NumPingNanAndYangLaoLiuAndFeiHuJi",dataMap.get(0).get("NumPingNanAndYangLaoLiuAndFeiHuJi"));
        jsonObject.put("NumPingNanAndYangLaoAndMale",dataMap.get(0).get("NumPingNanAndYangLaoAndMale"));
        jsonObject.put("NumPingNanAndYangLaoAndFemale",dataMap.get(0).get("NumPingNanAndYangLaoAndFemale"));
        jsonObject.put("NumPingNanAndYangLaoAnd60To70M",dataMap.get(0).get("NumPingNanAndYangLaoAnd60To70M"));
        jsonObject.put("NumPingNanAndYangLaoAnd70To80M",dataMap.get(0).get("NumPingNanAndYangLaoAnd70To80M"));
        jsonObject.put("NumPingNanAndYangLaoAnd80To90M",dataMap.get(0).get("NumPingNanAndYangLaoAnd80To90M"));
        jsonObject.put("NumPingNanAndYangLaoAnd90AboveM",dataMap.get(0).get("NumPingNanAndYangLaoAnd90AboveM"));
        jsonObject.put("NumPingNanAndYangLaoAnd60To70F",dataMap.get(0).get("NumPingNanAndYangLaoAnd60To70F"));
        jsonObject.put("NumPingNanAndYangLaoAnd70To80F",dataMap.get(0).get("NumPingNanAndYangLaoAnd70To80F"));
        jsonObject.put("NumPingNanAndYangLaoAnd80To90F",dataMap.get(0).get("NumPingNanAndYangLaoAnd80To90F"));
        jsonObject.put("NumPingNanAndYangLaoAnd90AboveF",dataMap.get(0).get("NumPingNanAndYangLaoAnd90AboveF"));

        jsonObject.put("NumPingNanAndYiLiaoAndHuJi",dataMap.get(0).get("NumPingNanAndYiLiaoAndHuJi"));
        jsonObject.put("NumPingNanAndYiLiaoAndFeiHuJi",dataMap.get(0).get("NumPingNanAndYiLiaoAndFeiHuJi"));
        jsonObject.put("NumPingNanAndYiLiaoAndMale",dataMap.get(0).get("NumPingNanAndYiLiaoAndMale"));
        jsonObject.put("NumPingNanAndYiLiaoAndFemale",dataMap.get(0).get("NumPingNanAndYiLiaoAndFemale"));
        jsonObject.put("NumPingNanAndYiLiaoAnd60To70M",dataMap.get(0).get("NumPingNanAndYiLiaoAnd60To70M"));
        jsonObject.put("NumPingNanAndYiLiaoAnd70To80M",dataMap.get(0).get("NumPingNanAndYiLiaoAnd70To80M"));
        jsonObject.put("NumPingNanAndYiLiaoAnd80To90M",dataMap.get(0).get("NumPingNanAndYiLiaoAnd80To90M"));
        jsonObject.put("NumPingNanAndYiLiaoAnd90AboveM",dataMap.get(0).get("NumPingNanAndYiLiaoAnd90AboveM"));
        jsonObject.put("NumPingNanAndYiLiaoAnd60To70F",dataMap.get(0).get("NumPingNanAndYiLiaoAnd60To70F"));
        jsonObject.put("NumPingNanAndYiLiaoAnd70To80F",dataMap.get(0).get("NumPingNanAndYiLiaoAnd70To80F"));
        jsonObject.put("NumPingNanAndYiLiaoAnd80To90F",dataMap.get(0).get("NumPingNanAndYiLiaoAnd80To90F"));
        jsonObject.put("NumPingNanAndYiLiaoAnd90AboveF",dataMap.get(0).get("NumPingNanAndYiLiaoAnd90AboveF"));

        jsonObject.put("NumPingNanAndChenZhenAndHuJi",dataMap.get(0).get("NumPingNanAndChenZhenAndHuJi"));
        jsonObject.put("NumPingNanAndChenZhenAndFeiHuJi",dataMap.get(0).get("NumPingNanAndChenZhenAndFeiHuJi"));
        jsonObject.put("NumPingNanAndChenZhenAndMale",dataMap.get(0).get("NumPingNanAndChenZhenAndMale"));
        jsonObject.put("NumPingNanAndChenZhenAndFemale",dataMap.get(0).get("NumPingNanAndChenZhenAndFemale"));
        jsonObject.put("NumPingNanAndChenZhenAnd60To70M",dataMap.get(0).get("NumPingNanAndChenZhenAnd60To70M"));
        jsonObject.put("NumPingNanAndChenZhenAnd70To80M",dataMap.get(0).get("NumPingNanAndChenZhenAnd70To80M"));
        jsonObject.put("NumPingNanAndChenZhenAnd80To90M",dataMap.get(0).get("NumPingNanAndChenZhenAnd80To90M"));
        jsonObject.put("NumPingNanAndChenZhenAnd90AboveM",dataMap.get(0).get("NumPingNanAndChenZhenAnd90AboveM"));
        jsonObject.put("NumPingNanAndChenZhenAnd60To70F",dataMap.get(0).get("NumPingNanAndChenZhenAnd60To70F"));
        jsonObject.put("NumPingNanAndChenZhenAnd70To80F",dataMap.get(0).get("NumPingNanAndChenZhenAnd70To80F"));
        jsonObject.put("NumPingNanAndChenZhenAnd80To90F",dataMap.get(0).get("NumPingNanAndChenZhenAnd80To90F"));
        jsonObject.put("NumPingNanAndChenZhenAnd90AboveF",dataMap.get(0).get("NumPingNanAndChenZhenAnd90AboveF"));

        //all NumDongLan
        jsonObject.put("NumDongLanAndShiNeng",dataMap.get(0).get("NumDongLanAndShiNeng"));
        jsonObject.put("NumDongLanAndManBing",dataMap.get(0).get("NumDongLanAndManBing"));
        jsonObject.put("NumDongLanAndZhongLiu",dataMap.get(0).get("NumDongLanAndZhongLiu"));
        jsonObject.put("NumDongLanAndGuZhe",dataMap.get(0).get("NumDongLanAndGuZhe"));
        jsonObject.put("NumDongLanAndShiZhi",dataMap.get(0).get("NumDongLanAndShiZhi"));
        jsonObject.put("NumDongLanAndChangHu",dataMap.get(0).get("NumDongLanAndChangHu"));
        jsonObject.put("NumDongLanAndQiTa",dataMap.get(0).get("NumDongLanAndQiTa"));

        jsonObject.put("NumDongLanAndBangKun",dataMap.get(0).get("NumDongLanAndBangKun"));
        jsonObject.put("NumDongLanAndDiBao",dataMap.get(0).get("NumDongLanAndDiBao"));
        jsonObject.put("NumDongLanAndYangLao",dataMap.get(0).get("NumDongLanAndYangLao"));
        jsonObject.put("NumDongLanAndYiLiao",dataMap.get(0).get("NumDongLanAndYiLiao"));
        jsonObject.put("NumDongLanAndChenZhen",dataMap.get(0).get("NumDongLanAndChenZhen"));

        jsonObject.put("NumDongLanAndChunLao",dataMap.get(0).get("NumDongLanAndChunLao"));
        jsonObject.put("NumDongLanAndSanZhi",dataMap.get(0).get("NumDongLanAndSanZhi"));
        jsonObject.put("NumDongLanAndDuJu",dataMap.get(0).get("NumDongLanAndDuJu"));
        jsonObject.put("NumDongLanAndShiDu",dataMap.get(0).get("NumDongLanAndShiDu"));
        jsonObject.put("NumDongLanAndYiLao",dataMap.get(0).get("NumDongLanAndYiLao"));
        jsonObject.put("NumDongLanAndGuLao",dataMap.get(0).get("NumDongLanAndGuLao"));

        //gulongall
        jsonObject.put("NumGuLongAndShiNeng",dataMap.get(0).get("NumGuLongAndShiNeng"));
        jsonObject.put("NumGuLongAndManBing",dataMap.get(0).get("NumGuLongAndManBing"));
        jsonObject.put("NumGuLongAndZhongLiu",dataMap.get(0).get("NumGuLongAndZhongLiu"));
        jsonObject.put("NumGuLongAndGuZhe",dataMap.get(0).get("NumGuLongAndGuZhe"));
        jsonObject.put("NumGuLongAndShiZhi",dataMap.get(0).get("NumGuLongAndShiZhi"));
        jsonObject.put("NumGuLongAndChangHu",dataMap.get(0).get("NumGuLongAndChangHu"));
        jsonObject.put("NumGuLongAndQiTa",dataMap.get(0).get("NumGuLongAndQiTa"));

        jsonObject.put("NumGuLongAndBangKun",dataMap.get(0).get("NumGuLongAndBangKun"));
        jsonObject.put("NumGuLongAndDiBao",dataMap.get(0).get("NumGuLongAndDiBao"));
        jsonObject.put("NumGuLongAndYangLao",dataMap.get(0).get("NumGuLongAndYangLao"));
        jsonObject.put("NumGuLongAndYiLiao",dataMap.get(0).get("NumGuLongAndYiLiao"));
        jsonObject.put("NumGuLongAndChenZhen",dataMap.get(0).get("NumGuLongAndChenZhen"));

        jsonObject.put("NumGuLongAndChunLao",dataMap.get(0).get("NumGuLongAndChunLao"));
        jsonObject.put("NumGuLongAndDuJu",dataMap.get(0).get("NumGuLongAndDuJu"));
        jsonObject.put("NumGuLongAndShiDu",dataMap.get(0).get("NumGuLongAndShiDu"));
        jsonObject.put("NumGuLongAndYiLao",dataMap.get(0).get("NumGuLongAndYiLao"));
        jsonObject.put("NumGuLongAndGuLao",dataMap.get(0).get("NumGuLongAndGuLao"));

        //pingnan all
        jsonObject.put("NumPingNanAndShiNeng",dataMap.get(0).get("NumPingNanAndShiNeng"));
        jsonObject.put("NumPingNanAndManBing",dataMap.get(0).get("NumPingNanAndManBing"));
        jsonObject.put("NumPingNanAndZhongLiu",dataMap.get(0).get("NumPingNanAndZhongLiu"));
        jsonObject.put("NumPingNanAndGuZhe",dataMap.get(0).get("NumPingNanAndGuZhe"));
        jsonObject.put("NumPingNanAndShiZhi",dataMap.get(0).get("NumPingNanAndShiZhi"));
        jsonObject.put("NumPingNanAndChangHu",dataMap.get(0).get("NumPingNanAndChangHu"));
        jsonObject.put("NumPingNanAndQiTa",dataMap.get(0).get("NumPingNanAndQiTa"));

        jsonObject.put("NumPingNanAndBangKun",dataMap.get(0).get("NumPingNanAndBangKun"));
        jsonObject.put("NumPingNanAndDiBao",dataMap.get(0).get("NumPingNanAndDiBao"));
        jsonObject.put("NumPingNanAndYangLao",dataMap.get(0).get("NumPingNanAndYangLao"));
        jsonObject.put("NumPingNanAndYiLiao",dataMap.get(0).get("NumPingNanAndYiLiao"));
        jsonObject.put("NumPingNanAndChenZhen",dataMap.get(0).get("NumPingNanAndChenZhen"));

        jsonObject.put("NumPingNanAndChunLao",dataMap.get(0).get("NumPingNanAndChunLao"));
        jsonObject.put("NumPingNanAndDuJu",dataMap.get(0).get("NumPingNanAndDuJu"));
        jsonObject.put("NumPingNanAndShiDu",dataMap.get(0).get("NumPingNanAndShiDu"));
        jsonObject.put("NumPingNanAndYiLao",dataMap.get(0).get("NumPingNanAndYiLao"));
        jsonObject.put("NumPingNanAndGuLao",dataMap.get(0).get("NumPingNanAndGuLao"));
        //pingyangall
        jsonObject.put("NumPingYangAndShiNeng",dataMap.get(0).get("NumPingYangAndShiNeng"));
        jsonObject.put("NumPingYangAndManBing",dataMap.get(0).get("NumPingYangAndManBing"));
        jsonObject.put("NumPingYangAndZhongLiu",dataMap.get(0).get("NumPingYangAndZhongLiu"));
        jsonObject.put("NumPingYangAndGuZhe",dataMap.get(0).get("NumPingYangAndGuZhe"));
        jsonObject.put("NumPingYangAndShiZhi",dataMap.get(0).get("NumPingYangAndShiZhi"));
        jsonObject.put("NumPingYangAndChangHu",dataMap.get(0).get("NumPingYangAndChangHu"));
        jsonObject.put("NumPingYangAndQiTa",dataMap.get(0).get("NumPingYangAndQiTa"));

        jsonObject.put("NumPingYangAndBangKun",dataMap.get(0).get("NumPingYangAndBangKun"));
        jsonObject.put("NumPingYangAndDiBao",dataMap.get(0).get("NumPingYangAndDiBao"));
        jsonObject.put("NumPingYangAndYangLao",dataMap.get(0).get("NumPingYangAndYangLao"));
        jsonObject.put("NumPingYangAndYiLiao",dataMap.get(0).get("NumPingYangAndYiLiao"));
        jsonObject.put("NumPingYangAndChenZhen",dataMap.get(0).get("NumPingYangAndChenZhen"));

        jsonObject.put("NumPingYangAndChunLao",dataMap.get(0).get("NumPingYangAndChunLao"));
        jsonObject.put("NumPingYangAndDuJu",dataMap.get(0).get("NumPingYangAndDuJu"));
        jsonObject.put("NumPingYangAndShiDu",dataMap.get(0).get("NumPingYangAndShiDu"));
        jsonObject.put("NumPingYangAndYiLao",dataMap.get(0).get("NumPingYangAndYiLao"));
        jsonObject.put("NumPingYangAndGuLao",dataMap.get(0).get("NumPingYangAndGuLao"));

        //Pingji all
        jsonObject.put("NumPingJiAndShiNeng",dataMap.get(0).get("NumPingJiAndShiNeng"));
        jsonObject.put("NumPingJiAndManBing",dataMap.get(0).get("NumPingJiAndManBing"));
        jsonObject.put("NumPingJiAndZhongLiu",dataMap.get(0).get("NumPingJiAndZhongLiu"));
        jsonObject.put("NumPingJiAndGuZhe",dataMap.get(0).get("NumPingJiAndGuZhe"));
        jsonObject.put("NumPingJiAndShiZhi",dataMap.get(0).get("NumPingJiAndShiZhi"));
        jsonObject.put("NumPingJiAndChangHu",dataMap.get(0).get("NumPingJiAndChangHu"));
        jsonObject.put("NumPingJiAndQiTa",dataMap.get(0).get("NumPingJiAndQiTa"));

        jsonObject.put("NumPingJiAndBangKun",dataMap.get(0).get("NumPingJiAndBangKun"));
        jsonObject.put("NumPingJiAndDiBao",dataMap.get(0).get("NumPingJiAndDiBao"));
        jsonObject.put("NumPingJiAndYangLao",dataMap.get(0).get("NumPingJiAndYangLao"));
        jsonObject.put("NumPingJiAndYiLiao",dataMap.get(0).get("NumPingJiAndYiLiao"));
        jsonObject.put("NumPingJiAndChenZhen",dataMap.get(0).get("NumPingJiAndChenZhen"));

        jsonObject.put("NumPingJiAndChunLao",dataMap.get(0).get("NumPingJiAndChunLao"));
        jsonObject.put("NumPingJiAndDuJu",dataMap.get(0).get("NumPingJiAndDuJu"));
        jsonObject.put("NumPingJiAndShiDu",dataMap.get(0).get("NumPingJiAndShiDu"));
        jsonObject.put("NumPingJiAndYiLao",dataMap.get(0).get("NumPingJiAndYiLao"));
        jsonObject.put("NumPingJiAndGuLao",dataMap.get(0).get("NumPingJiAndGuLao"));

        //gumei all
        jsonObject.put("NumGuMeiAndShiNeng",dataMap.get(0).get("NumGuMeiAndShiNeng"));
        jsonObject.put("NumGuMeiAndManBing",dataMap.get(0).get("NumGuMeiAndManBing"));
        jsonObject.put("NumGuMeiAndZhongLiu",dataMap.get(0).get("NumGuMeiAndZhongLiu"));
        jsonObject.put("NumGuMeiAndGuZhe",dataMap.get(0).get("NumGuMeiAndGuZhe"));
        jsonObject.put("NumGuMeiAndShiZhi",dataMap.get(0).get("NumGuMeiAndShiZhi"));
        jsonObject.put("NumGuMeiAndChangHu",dataMap.get(0).get("NumGuMeiAndChangHu"));
        jsonObject.put("NumGuMeiAndQiTa",dataMap.get(0).get("NumGuMeiAndQiTa"));

        jsonObject.put("NumGuMeiAndBangKun",dataMap.get(0).get("NumGuMeiAndBangKun"));
        jsonObject.put("NumGuMeiAndDiBao",dataMap.get(0).get("NumGuMeiAndDiBao"));
        jsonObject.put("NumGuMeiAndYangLao",dataMap.get(0).get("NumGuMeiAndYangLao"));
        jsonObject.put("NumGuMeiAndYiLiao",dataMap.get(0).get("NumGuMeiAndYiLiao"));
        jsonObject.put("NumGuMeiAndChenZhen",dataMap.get(0).get("NumGuMeiAndChenZhen"));

        jsonObject.put("NumGuMeiAndChunLao",dataMap.get(0).get("NumGuMeiAndChunLao"));
        jsonObject.put("NumGuMeiAndDuJu",dataMap.get(0).get("NumGuMeiAndDuJu"));
        jsonObject.put("NumGuMeiAndShiDu",dataMap.get(0).get("NumGuMeiAndShiDu"));
        jsonObject.put("NumGuMeiAndYiLao",dataMap.get(0).get("NumGuMeiAndYiLao"));
        jsonObject.put("NumGuMeiAndGuLao",dataMap.get(0).get("NumGuMeiAndGuLao"));


        //detail data
        jsonObject.put("NumDongLanAndHuJi",dataMap.get(0).get("NumDongLanAndHuJi"));
        jsonObject.put("NumDongLanAndFeiHuJi",dataMap.get(0).get("NumDongLanAndFeiHuJi"));
        jsonObject.put("NumDongLanAndMale",dataMap.get(0).get("NumDongLanAndMale"));
        jsonObject.put("NumDongLanAndFemale",dataMap.get(0).get("NumDongLanAndFemale"));
        jsonObject.put("NumDongLanAnd60To70M",dataMap.get(0).get("NumDongLanAnd60To70M"));
        jsonObject.put("NumDongLanAnd70To80M",dataMap.get(0).get("NumDongLanAnd70To80M"));
        jsonObject.put("NumDongLanAnd80To90M",dataMap.get(0).get("NumDongLanAnd80To90M"));
        jsonObject.put("NumDongLanAnd90AboveM",dataMap.get(0).get("NumDongLanAnd90AboveM"));
        jsonObject.put("NumDongLanAnd60To70F",dataMap.get(0).get("NumDongLanAnd60To70F"));
        jsonObject.put("NumDongLanAnd70To80F",dataMap.get(0).get("NumDongLanAnd70To80F"));
        jsonObject.put("NumDongLanAnd80To90F",dataMap.get(0).get("NumDongLanAnd80To90F"));
        jsonObject.put("NumDongLanAnd90AboveF",dataMap.get(0).get("NumDongLanAnd90AboveF"));

        jsonObject.put("NumGuLongAndHuJi",dataMap.get(0).get("NumGuLongAndHuJi"));
        jsonObject.put("NumGuLongAndFeiHuJi",dataMap.get(0).get("NumGuLongAndFeiHuJi"));
        jsonObject.put("NumGuLongAndMale",dataMap.get(0).get("NumGuLongAndMale"));
        jsonObject.put("NumGuLongAndFemale",dataMap.get(0).get("NumGuLongAndFemale"));
        jsonObject.put("NumGuLongAnd60To70M",dataMap.get(0).get("NumGuLongAnd60To70M"));
        jsonObject.put("NumGuLongAnd70To80M",dataMap.get(0).get("NumGuLongAnd70To80M"));
        jsonObject.put("NumGuLongAnd80To90M",dataMap.get(0).get("NumGuLongAnd80To90M"));
        jsonObject.put("NumGuLongAnd90AboveM",dataMap.get(0).get("NumGuLongAnd90AboveM"));
        jsonObject.put("NumGuLongAnd60To70F",dataMap.get(0).get("NumGuLongAnd60To70F"));
        jsonObject.put("NumGuLongAnd70To80F",dataMap.get(0).get("NumGuLongAnd70To80F"));
        jsonObject.put("NumGuLongAnd80To90F",dataMap.get(0).get("NumGuLongAnd80To90F"));
        jsonObject.put("NumGuLongAnd90AboveF",dataMap.get(0).get("NumGuLongAnd90AboveF"));

        jsonObject.put("NumPingNanAndHuJi",dataMap.get(0).get("NumPingNanAndHuJi"));
        jsonObject.put("NumPingNanAndFeiHuJi",dataMap.get(0).get("NumPingNanAndFeiHuJi"));
        jsonObject.put("NumPingNanAndMale",dataMap.get(0).get("NumPingNanAndMale"));
        jsonObject.put("NumPingNanAndFemale",dataMap.get(0).get("NumPingNanAndFemale"));
        jsonObject.put("NumPingNanAnd60To70M",dataMap.get(0).get("NumPingNanAnd60To70M"));
        jsonObject.put("NumPingNanAnd70To80M",dataMap.get(0).get("NumPingNanAnd70To80M"));
        jsonObject.put("NumPingNanAnd80To90M",dataMap.get(0).get("NumPingNanAnd80To90M"));
        jsonObject.put("NumPingNanAnd90AboveM",dataMap.get(0).get("NumPingNanAnd90AboveM"));
        jsonObject.put("NumPingNanAnd60To70F",dataMap.get(0).get("NumPingNanAnd60To70F"));
        jsonObject.put("NumPingNanAnd70To80F",dataMap.get(0).get("NumPingNanAnd70To80F"));
        jsonObject.put("NumPingNanAnd80To90F",dataMap.get(0).get("NumPingNanAnd80To90F"));
        jsonObject.put("NumPingNanAnd90AboveF",dataMap.get(0).get("NumPingNanAnd90AboveF"));

        jsonObject.put("NumPingYangAndHuJi",dataMap.get(0).get("NumPingYangAndHuJi"));
        jsonObject.put("NumPingYangAndFeiHuJi",dataMap.get(0).get("NumPingYangAndFeiHuJi"));
        jsonObject.put("NumPingYangAndMale",dataMap.get(0).get("NumPingYangAndMale"));
        jsonObject.put("NumPingYangAndFemale",dataMap.get(0).get("NumPingYangAndFemale"));
        jsonObject.put("NumPingYangAnd60To70M",dataMap.get(0).get("NumPingYangAnd60To70M"));
        jsonObject.put("NumPingYangAnd70To80M",dataMap.get(0).get("NumPingYangAnd70To80M"));
        jsonObject.put("NumPingYangAnd80To90M",dataMap.get(0).get("NumPingYangAnd80To90M"));
        jsonObject.put("NumPingYangAnd90AboveM",dataMap.get(0).get("NumPingYangAnd90AboveM"));
        jsonObject.put("NumPingYangAnd60To70F",dataMap.get(0).get("NumPingYangAnd60To70F"));
        jsonObject.put("NumPingYangAnd70To80F",dataMap.get(0).get("NumPingYangAnd70To80F"));
        jsonObject.put("NumPingYangAnd80To90F",dataMap.get(0).get("NumPingYangAnd80To90F"));
        jsonObject.put("NumPingYangAnd90AboveF",dataMap.get(0).get("NumPingYangAnd90AboveF"));

        jsonObject.put("NumPingJiAndHuJi",dataMap.get(0).get("NumPingJiAndHuJi"));
        jsonObject.put("NumPingJiAndFeiHuJi",dataMap.get(0).get("NumPingJiAndFeiHuJi"));
        jsonObject.put("NumPingJiAndMale",dataMap.get(0).get("NumPingJiAndMale"));
        jsonObject.put("NumPingJiAndFemale",dataMap.get(0).get("NumPingJiAndFemale"));
        jsonObject.put("NumPingJiAnd60To70M",dataMap.get(0).get("NumPingJiAnd60To70M"));
        jsonObject.put("NumPingJiAnd70To80M",dataMap.get(0).get("NumPingJiAnd70To80M"));
        jsonObject.put("NumPingJiAnd80To90M",dataMap.get(0).get("NumPingJiAnd80To90M"));
        jsonObject.put("NumPingJiAnd90AboveM",dataMap.get(0).get("NumPingJiAnd90AboveM"));
        jsonObject.put("NumPingJiAnd60To70F",dataMap.get(0).get("NumPingJiAnd60To70F"));
        jsonObject.put("NumPingJiAnd70To80F",dataMap.get(0).get("NumPingJiAnd70To80F"));
        jsonObject.put("NumPingJiAnd80To90F",dataMap.get(0).get("NumPingJiAnd80To90F"));
        jsonObject.put("NumPingJiAnd90AboveF",dataMap.get(0).get("NumPingJiAnd90AboveF"));

        jsonObject.put("NumGuMeiAndHuJi",dataMap.get(0).get("NumGuMeiAndHuJi"));
        jsonObject.put("NumGuMeiAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndMale",dataMap.get(0).get("NumGuMeiAndMale"));
        jsonObject.put("NumGuMeiAndFemale",dataMap.get(0).get("NumGuMeiAndFemale"));
        jsonObject.put("NumGuMeiAnd60To70M",dataMap.get(0).get("NumGuMeiAnd60To70M"));
        jsonObject.put("NumGuMeiAnd70To80M",dataMap.get(0).get("NumGuMeiAnd70To80M"));
        jsonObject.put("NumGuMeiAnd80To90M",dataMap.get(0).get("NumGuMeiAnd80To90M"));
        jsonObject.put("NumGuMeiAnd90AboveM",dataMap.get(0).get("NumGuMeiAnd90AboveM"));
        jsonObject.put("NumGuMeiAnd60To70F",dataMap.get(0).get("NumGuMeiAnd60To70F"));
        jsonObject.put("NumGuMeiAnd70To80F",dataMap.get(0).get("NumGuMeiAnd70To80F"));
        jsonObject.put("NumGuMeiAnd80To90F",dataMap.get(0).get("NumGuMeiAnd80To90F"));
        jsonObject.put("NumGuMeiAnd90AboveF",dataMap.get(0).get("NumGuMeiAnd90AboveF"));

        //80above
        jsonObject.put("NumDongLan80Above",dataMap.get(0).get("NumDongLan80Above"));
        jsonObject.put("NumGuLong80Above",dataMap.get(0).get("NumGuLong80Above"));
        jsonObject.put("NumPingNan80Above",dataMap.get(0).get("NumPingNan80Above"));
        jsonObject.put("NumPingYang80Above",dataMap.get(0).get("NumPingYang80Above"));
        jsonObject.put("NumPingJi80Above",dataMap.get(0).get("NumPingJi80Above"));
        jsonObject.put("NumGuMei80Above",dataMap.get(0).get("NumGuMei80Above"));


        jsonObject.put("NumPingJiAndDuJuAndHuJi",dataMap.get(0).get("NumPingJiAndDuJuAndHuJi"));
        jsonObject.put("NumPingJiAndDuJuAndFeiHuJi",dataMap.get(0).get("NumPingJiAndDuJuAndFeiHuJi"));
        jsonObject.put("NumPingJiAndDuJuAndMale",dataMap.get(0).get("NumPingJiAndDuJuAndMale"));
        jsonObject.put("NumPingJiAndDuJuAndFemale",dataMap.get(0).get("NumPingJiAndDuJuAndFemale"));
        jsonObject.put("NumPingJiAndDuJuAnd60To70M",dataMap.get(0).get("NumPingJiAndDuJuAnd60To70M"));
        jsonObject.put("NumPingJiAndDuJuAnd70To80M",dataMap.get(0).get("NumPingJiAndDuJuAnd70To80M"));
        jsonObject.put("NumPingJiAndDuJuAnd80To90M",dataMap.get(0).get("NumPingJiAndDuJuAnd80To90M"));
        jsonObject.put("NumPingJiAndDuJuAnd90AboveM",dataMap.get(0).get("NumPingJiAndDuJuAnd90AboveM"));
        jsonObject.put("NumPingJiAndDuJuAnd60To70F",dataMap.get(0).get("NumPingJiAndDuJuAnd60To70F"));
        jsonObject.put("NumPingJiAndDuJuAnd70To80F",dataMap.get(0).get("NumPingJiAndDuJuAnd70To80F"));
        jsonObject.put("NumPingJiAndDuJuAnd80To90F",dataMap.get(0).get("NumPingJiAndDuJuAnd80To90F"));
        jsonObject.put("NumPingJiAndDuJuAnd90AboveF",dataMap.get(0).get("NumPingJiAndDuJuAnd90AboveF"));
        jsonObject.put("NumT",dataMap.get(0).get("NumT"));


        //add_code(jsonObject,dataMap);
//        return jsonObject;
        Result result =new Result(true,jsonObject);
        return result;

    }


}
