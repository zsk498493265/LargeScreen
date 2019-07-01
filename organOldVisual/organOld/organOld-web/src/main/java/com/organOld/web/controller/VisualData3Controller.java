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

/**
 * 可视化 数据
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/visual/data")
public class VisualData3Controller {
    @Autowired
    OldmanService oldmanService;
    @ResponseBody
    @RequestMapping(value = "/getVisualData3",method = RequestMethod.GET)
    public Result admin_getOldNum1(){
        List<Map<String,Long>> dataMap=oldmanService.getVisualData3(AgeTobirthday(60),AgeTobirthday(70),AgeTobirthday(80),AgeTobirthday(90),"2019-05");
        //String s=AgeTobirthday(80).toString();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NumOld",dataMap.get(0).get("NumOld"));
        jsonObject.put("NumAll", dataMap.get(0).get("NumAll"));
        jsonObject.put("NumOld60",dataMap.get(0).get("NumOld60"));
        jsonObject.put("NumOld80", dataMap.get(0).get("NumOld80"));
        jsonObject.put("NumOrganOld",dataMap.get(0).get("NumOrganOld"));
        jsonObject.put("NumCommunityOld", dataMap.get(0).get("NumCommunityOld"));
        jsonObject.put("NumFamilyOld", dataMap.get(0).get("NumFamilyOld"));
        jsonObject.put("NumChunLao", dataMap.get(0).get("NumChunLao"));

        jsonObject.put("NumHuJi",dataMap.get(0).get("NumHuJi"));
        jsonObject.put("NumFeiHuJi",dataMap.get(0).get("NumFeiHuJi"));
        jsonObject.put("NumMale",dataMap.get(0).get("NumMale"));
        jsonObject.put("NumFemale",dataMap.get(0).get("NumFemale"));
        jsonObject.put("NumChunLao",dataMap.get(0).get("NumChunLao"));
        jsonObject.put("NumDuJu",dataMap.get(0).get("NumDuJu"));
        jsonObject.put("NumShiDu",dataMap.get(0).get("NumShiDu"));
        jsonObject.put("NumYiLaoYYL",dataMap.get(0).get("NumYiLaoYYL"));
        jsonObject.put("NumGuLao",dataMap.get(0).get("NumGuLao"));
        jsonObject.put("NumSanZhiRY",dataMap.get(0).get("NumSanZhiRY"));
        jsonObject.put("NumQiTaFamily",dataMap.get(0).get("NumQiTaFamily"));
        jsonObject.put("NumAbove90M",dataMap.get(0).get("NumAbove90M"));
        jsonObject.put("Num80To90M",dataMap.get(0).get("Num80To90M"));
        jsonObject.put("Num70To80M",dataMap.get(0).get("Num70To80M"));
        jsonObject.put("Num60To70M",dataMap.get(0).get("Num60To70M"));
        jsonObject.put("NumAbove90F",dataMap.get(0).get("NumAbove90F"));
        jsonObject.put("Num80To90F",dataMap.get(0).get("Num80To90F"));
        jsonObject.put("Num70To80F",dataMap.get(0).get("Num70To80F"));
        jsonObject.put("Num60To70F",dataMap.get(0).get("Num60To70F"));
        jsonObject.put("NumBangKun",dataMap.get(0).get("NumBangKun"));
        jsonObject.put("NumDiBao",dataMap.get(0).get("NumDiBao"));
        jsonObject.put("NumYangLaoBX",dataMap.get(0).get("NumYangLaoBX"));
        jsonObject.put("NumYiLiaoJZJ",dataMap.get(0).get("NumYiLiaoJZJ"));
        jsonObject.put("NumChengZhenYB",dataMap.get(0).get("NumChengZhenYB"));
        jsonObject.put("NumQiTaEco",dataMap.get(0).get("NumQiTaEco"));

        jsonObject.put("NumSN",dataMap.get(0).get("NumSN"));
        jsonObject.put("NumMB",dataMap.get(0).get("NumMB"));
        jsonObject.put("NumZLS",dataMap.get(0).get("NumZLS"));
        jsonObject.put("NumGZS",dataMap.get(0).get("NumGZS"));
        jsonObject.put("NumSZ",dataMap.get(0).get("NumSZ"));
        jsonObject.put("NumCHXPJ",dataMap.get(0).get("NumCHXPJ"));
        jsonObject.put("NumQiTaHealth",dataMap.get(0).get("NumQiTaHealth"));
        jsonObject.put("NumOrgGuMei",dataMap.get(0).get("NumOrgGuMei"));
        jsonObject.put("NumOrgPingYang",dataMap.get(0).get("NumOrgPingYang"));
        jsonObject.put("NumOrgDongLan",dataMap.get(0).get("NumOrgDongLan"));
        jsonObject.put("NumJiaTingYL",dataMap.get(0).get("NumJiaTingYL"));
        jsonObject.put("NumChangHuX",dataMap.get(0).get("NumChangHuX"));
        jsonObject.put("NumZhiNengHYY",dataMap.get(0).get("NumZhiNengHYY"));
        jsonObject.put("NumJiaTingYS",dataMap.get(0).get("NumJiaTingYS"));
        jsonObject.put("NumJiaTingBC",dataMap.get(0).get("NumJiaTingBC"));
        jsonObject.put("NumOrgOld",dataMap.get(0).get("NumOrgOld"));
        jsonObject.put("NumSqJjOld",dataMap.get(0).get("NumSqJjOld"));
        jsonObject.put("NumSqOld",dataMap.get(0).get("NumSqOld"));
        jsonObject.put("NumJjOld",dataMap.get(0).get("NumJjOld"));

        jsonObject.put("NumGuMeiIn",dataMap.get(0).get("NumGuMeiIn"));
        jsonObject.put("NumGuMeiRemain",dataMap.get(0).get("NumGuMeiRemain"));
        jsonObject.put("NumDongLanIn",dataMap.get(0).get("NumDongLanIn"));
        jsonObject.put("NumDongLanRemain",dataMap.get(0).get("NumDongLanRemain"));
        jsonObject.put("NumPingYangIn",dataMap.get(0).get("NumPingYangIn"));
        jsonObject.put("NumPingYangRemain",dataMap.get(0).get("NumPingYangRemain"));



        jsonObject.put("OrganName1",dataMap.get(0).get("OrganName1"));
        jsonObject.put("OrganName2",dataMap.get(0).get("OrganName2"));
        jsonObject.put("OrganName3",dataMap.get(0).get("OrganName3"));

        //big lian dong


//GuMei
        //family
        jsonObject.put("NumGuMeiAndChunLaoAndHuJi",dataMap.get(0).get("NumGuMeiAndChunLaoAndHuJi"));
        jsonObject.put("NumGuMeiAndChunLaoAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndChunLaoAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndChunLaoAndMale",dataMap.get(0).get("NumGuMeiAndChunLaoAndMale"));
        jsonObject.put("NumGuMeiAndChunLaoAndFemale",dataMap.get(0).get("NumGuMeiAndChunLaoAndFemale"));
        jsonObject.put("NumGuMeiAndChunLaoAnd60To70M",dataMap.get(0).get("NumGuMeiAndChunLaoAnd60To70M"));
        jsonObject.put("NumGuMeiAndChunLaoAnd70To80M",dataMap.get(0).get("NumGuMeiAndChunLaoAnd70To80M"));
        jsonObject.put("NumGuMeiAndChunLaoAnd80To90M",dataMap.get(0).get("NumGuMeiAndChunLaoAnd80To90M"));
        jsonObject.put("NumGuMeiAndChunLaoAnd90AboveM",dataMap.get(0).get("NumGuMeiAndChunLaoAnd90AboveM"));
        jsonObject.put("NumGuMeiAndChunLaoAnd60To70F",dataMap.get(0).get("NumGuMeiAndChunLaoAnd60To70F"));
        jsonObject.put("NumGuMeiAndChunLaoAnd70To80F",dataMap.get(0).get("NumGuMeiAndChunLaoAnd70To80F"));
        jsonObject.put("NumGuMeiAndChunLaoAnd80To90F",dataMap.get(0).get("NumGuMeiAndChunLaoAnd80To90F"));
        jsonObject.put("NumGuMeiAndChunLaoAnd90AboveF",dataMap.get(0).get("NumGuMeiAndChunLaoAnd90AboveF"));


        jsonObject.put("NumGuMeiAndDuJuAndHuJi",dataMap.get(0).get("NumGuMeiAndDuJuAndHuJi"));
        jsonObject.put("NumGuMeiAndDuJuAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndDuJuAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndDuJuAndMale",dataMap.get(0).get("NumGuMeiAndDuJuAndMale"));
        jsonObject.put("NumGuMeiAndDuJuAndFemale",dataMap.get(0).get("NumGuMeiAndDuJuAndFemale"));
        jsonObject.put("NumGuMeiAndDuJuAnd60To70M",dataMap.get(0).get("NumGuMeiAndDuJuAnd60To70M"));
        jsonObject.put("NumGuMeiAndDuJuAnd70To80M",dataMap.get(0).get("NumGuMeiAndDuJuAnd70To80M"));
        jsonObject.put("NumGuMeiAndDuJuAnd80To90M",dataMap.get(0).get("NumGuMeiAndDuJuAnd80To90M"));
        jsonObject.put("NumGuMeiAndDuJuAnd90AboveM",dataMap.get(0).get("NumGuMeiAndDuJuAnd90AboveM"));
        jsonObject.put("NumGuMeiAndDuJuAnd60To70F",dataMap.get(0).get("NumGuMeiAndDuJuAnd60To70F"));
        jsonObject.put("NumGuMeiAndDuJuAnd70To80F",dataMap.get(0).get("NumGuMeiAndDuJuAnd70To80F"));
        jsonObject.put("NumGuMeiAndDuJuAnd80To90F",dataMap.get(0).get("NumGuMeiAndDuJuAnd80To90F"));
        jsonObject.put("NumGuMeiAndDuJuAnd90AboveF",dataMap.get(0).get("NumGuMeiAndDuJuAnd90AboveF"));


        jsonObject.put("NumGuMeiAndShiDuAndHuJi",dataMap.get(0).get("NumGuMeiAndShiDuAndHuJi"));
        jsonObject.put("NumGuMeiAndShiDuAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndShiDuAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndShiDuAndMale",dataMap.get(0).get("NumGuMeiAndShiDuAndMale"));
        jsonObject.put("NumGuMeiAndShiDuAndFemale",dataMap.get(0).get("NumGuMeiAndShiDuAndFemale"));
        jsonObject.put("NumGuMeiAndShiDuAnd60To70M",dataMap.get(0).get("NumGuMeiAndShiDuAnd60To70M"));
        jsonObject.put("NumGuMeiAndShiDuAnd70To80M",dataMap.get(0).get("NumGuMeiAndShiDuAnd70To80M"));
        jsonObject.put("NumGuMeiAndShiDuAnd80To90M",dataMap.get(0).get("NumGuMeiAndShiDuAnd80To90M"));
        jsonObject.put("NumGuMeiAndShiDuAnd90AboveM",dataMap.get(0).get("NumGuMeiAndShiDuAnd90AboveM"));
        jsonObject.put("NumGuMeiAndShiDuAnd60To70F",dataMap.get(0).get("NumGuMeiAndShiDuAnd60To70F"));
        jsonObject.put("NumGuMeiAndShiDuAnd70To80F",dataMap.get(0).get("NumGuMeiAndShiDuAnd70To80F"));
        jsonObject.put("NumGuMeiAndShiDuAnd80To90F",dataMap.get(0).get("NumGuMeiAndShiDuAnd80To90F"));
        jsonObject.put("NumGuMeiAndShiDuAnd90AboveF",dataMap.get(0).get("NumGuMeiAndShiDuAnd90AboveF"));

        jsonObject.put("NumGuMeiAndYiLaoAndHuJi",dataMap.get(0).get("NumGuMeiAndYiLaoAndHuJi"));
        jsonObject.put("NumGuMeiAndYiLaoAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndYiLaoAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndYiLaoAndMale",dataMap.get(0).get("NumGuMeiAndYiLaoAndMale"));
        jsonObject.put("NumGuMeiAndYiLaoAndFemale",dataMap.get(0).get("NumGuMeiAndYiLaoAndFemale"));
        jsonObject.put("NumGuMeiAndYiLaoAnd60To70M",dataMap.get(0).get("NumGuMeiAndYiLaoAnd60To70M"));
        jsonObject.put("NumGuMeiAndYiLaoAnd70To80M",dataMap.get(0).get("NumGuMeiAndYiLaoAnd70To80M"));
        jsonObject.put("NumGuMeiAndYiLaoAnd80To90M",dataMap.get(0).get("NumGuMeiAndYiLaoAnd80To90M"));
        jsonObject.put("NumGuMeiAndYiLaoAnd90AboveM",dataMap.get(0).get("NumGuMeiAndYiLaoAnd90AboveM"));
        jsonObject.put("NumGuMeiAndYiLaoAnd60To70F",dataMap.get(0).get("NumGuMeiAndYiLaoAnd60To70F"));
        jsonObject.put("NumGuMeiAndYiLaoAnd70To80F",dataMap.get(0).get("NumGuMeiAndYiLaoAnd70To80F"));
        jsonObject.put("NumGuMeiAndYiLaoAnd80To90F",dataMap.get(0).get("NumGuMeiAndYiLaoAnd80To90F"));
        jsonObject.put("NumGuMeiAndYiLaoAnd90AboveF",dataMap.get(0).get("NumGuMeiAndYiLaoAnd90AboveF"));

        jsonObject.put("NumGuMeiAndGuLaoAndHuJi",dataMap.get(0).get("NumGuMeiAndGuLaoAndHuJi"));
        jsonObject.put("NumGuMeiAndGuLaoAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndGuLaoAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndGuLaoAndMale",dataMap.get(0).get("NumGuMeiAndGuLaoAndMale"));
        jsonObject.put("NumGuMeiAndGuLaoAndFemale",dataMap.get(0).get("NumGuMeiAndGuLaoAndFemale"));
        jsonObject.put("NumGuMeiAndGuLaoAnd60To70M",dataMap.get(0).get("NumGuMeiAndGuLaoAnd60To70M"));
        jsonObject.put("NumGuMeiAndGuLaoAnd70To80M",dataMap.get(0).get("NumGuMeiAndGuLaoAnd70To80M"));
        jsonObject.put("NumGuMeiAndGuLaoAnd80To90M",dataMap.get(0).get("NumGuMeiAndGuLaoAnd80To90M"));
        jsonObject.put("NumGuMeiAndGuLaoAnd90AboveM",dataMap.get(0).get("NumGuMeiAndGuLaoAnd90AboveM"));
        jsonObject.put("NumGuMeiAndGuLaoAnd60To70F",dataMap.get(0).get("NumGuMeiAndGuLaoAnd60To70F"));
        jsonObject.put("NumGuMeiAndGuLaoAnd70To80F",dataMap.get(0).get("NumGuMeiAndGuLaoAnd70To80F"));
        jsonObject.put("NumGuMeiAndGuLaoAnd80To90F",dataMap.get(0).get("NumGuMeiAndGuLaoAnd80To90F"));
        jsonObject.put("NumGuMeiAndGuLaoAnd90AboveF",dataMap.get(0).get("NumGuMeiAndGuLaoAnd90AboveF"));

        jsonObject.put("NumGuMeiAndSanZhiAndHuJi",dataMap.get(0).get("NumGuMeiAndSanZhiAndHuJi"));
        jsonObject.put("NumGuMeiAndSanZhiAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndSanZhiAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndSanZhiAndMale",dataMap.get(0).get("NumGuMeiAndSanZhiAndMale"));
        jsonObject.put("NumGuMeiAndSanZhiAndFemale",dataMap.get(0).get("NumGuMeiAndSanZhiAndFemale"));
        jsonObject.put("NumGuMeiAndSanZhiAnd60To70M",dataMap.get(0).get("NumGuMeiAndSanZhiAnd60To70M"));
        jsonObject.put("NumGuMeiAndSanZhiAnd70To80M",dataMap.get(0).get("NumGuMeiAndSanZhiAnd70To80M"));
        jsonObject.put("NumGuMeiAndSanZhiAnd80To90M",dataMap.get(0).get("NumGuMeiAndSanZhiAnd80To90M"));
        jsonObject.put("NumGuMeiAndSanZhiAnd90AboveM",dataMap.get(0).get("NumGuMeiAndSanZhiAnd90AboveM"));
        jsonObject.put("NumGuMeiAndSanZhiAnd60To70F",dataMap.get(0).get("NumGuMeiAndSanZhiAnd60To70F"));
        jsonObject.put("NumGuMeiAndSanZhiAnd70To80F",dataMap.get(0).get("NumGuMeiAndSanZhiAnd70To80F"));
        jsonObject.put("NumGuMeiAndSanZhiAnd80To90F",dataMap.get(0).get("NumGuMeiAndSanZhiAnd80To90F"));
        jsonObject.put("NumGuMeiAndSanZhiAnd90AboveF",dataMap.get(0).get("NumGuMeiAndSanZhiAnd90AboveF"));

        jsonObject.put("NumGuMeiAndQiTaAndHuJi",dataMap.get(0).get("NumGuMeiAndQiTaAndHuJi"));
        jsonObject.put("NumGuMeiAndQiTaAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndQiTaAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndQiTaAndMale",dataMap.get(0).get("NumGuMeiAndQiTaAndMale"));
        jsonObject.put("NumGuMeiAndQiTaAndFemale",dataMap.get(0).get("NumGuMeiAndQiTaAndFemale"));
        jsonObject.put("NumGuMeiAndQiTaAnd60To70M",dataMap.get(0).get("NumGuMeiAndQiTaAnd60To70M"));
        jsonObject.put("NumGuMeiAndQiTaAnd70To80M",dataMap.get(0).get("NumGuMeiAndQiTaAnd70To80M"));
        jsonObject.put("NumGuMeiAndQiTaAnd80To90M",dataMap.get(0).get("NumGuMeiAndQiTaAnd80To90M"));
        jsonObject.put("NumGuMeiAndQiTaAnd90AboveM",dataMap.get(0).get("NumGuMeiAndQiTaAnd90AboveM"));
        jsonObject.put("NumGuMeiAndQiTaAnd60To70F",dataMap.get(0).get("NumGuMeiAndQiTaAnd60To70F"));
        jsonObject.put("NumGuMeiAndQiTaAnd70To80F",dataMap.get(0).get("NumGuMeiAndQiTaAnd70To80F"));
        jsonObject.put("NumGuMeiAndQiTaAnd80To90F",dataMap.get(0).get("NumGuMeiAndQiTaAnd80To90F"));
        jsonObject.put("NumGuMeiAndQiTaAnd90AboveF",dataMap.get(0).get("NumGuMeiAndQiTaAnd90AboveF"));

        //health
        jsonObject.put("NumGuMeiAndShiNengAndHuJi",dataMap.get(0).get("NumGuMeiAndShiNengAndHuJi"));
        jsonObject.put("NumGuMeiAndShiNengAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndShiNengAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndShiNengAndMale",dataMap.get(0).get("NumGuMeiAndShiNengAndMale"));
        jsonObject.put("NumGuMeiAndShiNengAndFemale",dataMap.get(0).get("NumGuMeiAndShiNengAndFemale"));
        jsonObject.put("NumGuMeiAndShiNengAnd60To70M",dataMap.get(0).get("NumGuMeiAndShiNengAnd60To70M"));
        jsonObject.put("NumGuMeiAndShiNengAnd70To80M",dataMap.get(0).get("NumGuMeiAndShiNengAnd70To80M"));
        jsonObject.put("NumGuMeiAndShiNengAnd80To90M",dataMap.get(0).get("NumGuMeiAndShiNengAnd80To90M"));
        jsonObject.put("NumGuMeiAndShiNengAnd90AboveM",dataMap.get(0).get("NumGuMeiAndShiNengAnd90AboveM"));
        jsonObject.put("NumGuMeiAndShiNengAnd60To70F",dataMap.get(0).get("NumGuMeiAndShiNengAnd60To70F"));
        jsonObject.put("NumGuMeiAndShiNengAnd70To80F",dataMap.get(0).get("NumGuMeiAndShiNengAnd70To80F"));
        jsonObject.put("NumGuMeiAndShiNengAnd80To90F",dataMap.get(0).get("NumGuMeiAndShiNengAnd80To90F"));
        jsonObject.put("NumGuMeiAndShiNengAnd90AboveF",dataMap.get(0).get("NumGuMeiAndShiNengAnd90AboveF"));

        jsonObject.put("NumGuMeiAndManBingAndHuJi",dataMap.get(0).get("NumGuMeiAndManBingAndHuJi"));
        jsonObject.put("NumGuMeiAndManBingAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndManBingAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndManBingAndMale",dataMap.get(0).get("NumGuMeiAndManBingAndMale"));
        jsonObject.put("NumGuMeiAndManBingAndFemale",dataMap.get(0).get("NumGuMeiAndManBingAndFemale"));
        jsonObject.put("NumGuMeiAndManBingAnd60To70M",dataMap.get(0).get("NumGuMeiAndManBingAnd60To70M"));
        jsonObject.put("NumGuMeiAndManBingAnd70To80M",dataMap.get(0).get("NumGuMeiAndManBingAnd70To80M"));
        jsonObject.put("NumGuMeiAndManBingAnd80To90M",dataMap.get(0).get("NumGuMeiAndManBingAnd80To90M"));
        jsonObject.put("NumGuMeiAndManBingAnd90AboveM",dataMap.get(0).get("NumGuMeiAndManBingAnd90AboveM"));
        jsonObject.put("NumGuMeiAndManBingAnd60To70F",dataMap.get(0).get("NumGuMeiAndManBingAnd60To70F"));
        jsonObject.put("NumGuMeiAndManBingAnd70To80F",dataMap.get(0).get("NumGuMeiAndManBingAnd70To80F"));
        jsonObject.put("NumGuMeiAndManBingAnd80To90F",dataMap.get(0).get("NumGuMeiAndManBingAnd80To90F"));
        jsonObject.put("NumGuMeiAndManBingAnd90AboveF",dataMap.get(0).get("NumGuMeiAndManBingAnd90AboveF"));

        jsonObject.put("NumGuMeiAndZhongLiuAndHuJi",dataMap.get(0).get("NumGuMeiAndZhongLiuAndHuJi"));
        jsonObject.put("NumGuMeiAndZhongLiuAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndZhongLiuAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndZhongLiuAndMale",dataMap.get(0).get("NumGuMeiAndZhongLiuAndMale"));
        jsonObject.put("NumGuMeiAndZhongLiuAndFemale",dataMap.get(0).get("NumGuMeiAndZhongLiuAndFemale"));
        jsonObject.put("NumGuMeiAndZhongLiuAnd60To70M",dataMap.get(0).get("NumGuMeiAndZhongLiuAnd60To70M"));
        jsonObject.put("NumGuMeiAndZhongLiuAnd70To80M",dataMap.get(0).get("NumGuMeiAndZhongLiuAnd70To80M"));
        jsonObject.put("NumGuMeiAndZhongLiuAnd80To90M",dataMap.get(0).get("NumGuMeiAndZhongLiuAnd80To90M"));
        jsonObject.put("NumGuMeiAndZhongLiuAnd90AboveM",dataMap.get(0).get("NumGuMeiAndZhongLiuAnd90AboveM"));
        jsonObject.put("NumGuMeiAndZhongLiuAnd60To70F",dataMap.get(0).get("NumGuMeiAndZhongLiuAnd60To70F"));
        jsonObject.put("NumGuMeiAndZhongLiuAnd70To80F",dataMap.get(0).get("NumGuMeiAndZhongLiuAnd70To80F"));
        jsonObject.put("NumGuMeiAndZhongLiuAnd80To90F",dataMap.get(0).get("NumGuMeiAndZhongLiuAnd80To90F"));
        jsonObject.put("NumGuMeiAndZhongLiuAnd90AboveF",dataMap.get(0).get("NumGuMeiAndZhongLiuAnd90AboveF"));

        jsonObject.put("NumGuMeiAndGuZheAndHuJi",dataMap.get(0).get("NumGuMeiAndGuZheAndHuJi"));
        jsonObject.put("NumGuMeiAndGuZheAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndGuZheAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndGuZheAndMale",dataMap.get(0).get("NumGuMeiAndGuZheAndMale"));
        jsonObject.put("NumGuMeiAndGuZheAndFemale",dataMap.get(0).get("NumGuMeiAndGuZheAndFemale"));
        jsonObject.put("NumGuMeiAndGuZheAnd60To70M",dataMap.get(0).get("NumGuMeiAndGuZheAnd60To70M"));
        jsonObject.put("NumGuMeiAndGuZheAnd70To80M",dataMap.get(0).get("NumGuMeiAndGuZheAnd70To80M"));
        jsonObject.put("NumGuMeiAndGuZheAnd80To90M",dataMap.get(0).get("NumGuMeiAndGuZheAnd80To90M"));
        jsonObject.put("NumGuMeiAndGuZheAnd90AboveM",dataMap.get(0).get("NumGuMeiAndGuZheAnd90AboveM"));
        jsonObject.put("NumGuMeiAndGuZheAnd60To70F",dataMap.get(0).get("NumGuMeiAndGuZheAnd60To70F"));
        jsonObject.put("NumGuMeiAndGuZheAnd70To80F",dataMap.get(0).get("NumGuMeiAndGuZheAnd70To80F"));
        jsonObject.put("NumGuMeiAndGuZheAnd80To90F",dataMap.get(0).get("NumGuMeiAndGuZheAnd80To90F"));
        jsonObject.put("NumGuMeiAndGuZheAnd90AboveF",dataMap.get(0).get("NumGuMeiAndGuZheAnd90AboveF"));

        jsonObject.put("NumGuMeiAndShiZhiAndHuJi",dataMap.get(0).get("NumGuMeiAndShiZhiAndHuJi"));
        jsonObject.put("NumGuMeiAndShiZhiAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndShiZhiAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndShiZhiAndMale",dataMap.get(0).get("NumGuMeiAndShiZhiAndMale"));
        jsonObject.put("NumGuMeiAndShiZhiAndFemale",dataMap.get(0).get("NumGuMeiAndShiZhiAndFemale"));
        jsonObject.put("NumGuMeiAndShiZhiAnd60To70M",dataMap.get(0).get("NumGuMeiAndShiZhiAnd60To70M"));
        jsonObject.put("NumGuMeiAndShiZhiAnd70To80M",dataMap.get(0).get("NumGuMeiAndShiZhiAnd70To80M"));
        jsonObject.put("NumGuMeiAndShiZhiAnd80To90M",dataMap.get(0).get("NumGuMeiAndShiZhiAnd80To90M"));
        jsonObject.put("NumGuMeiAndShiZhiAnd90AboveM",dataMap.get(0).get("NumGuMeiAndShiZhiAnd90AboveM"));
        jsonObject.put("NumGuMeiAndShiZhiAnd60To70F",dataMap.get(0).get("NumGuMeiAndShiZhiAnd60To70F"));
        jsonObject.put("NumGuMeiAndShiZhiAnd70To80F",dataMap.get(0).get("NumGuMeiAndShiZhiAnd70To80F"));
        jsonObject.put("NumGuMeiAndShiZhiAnd80To90F",dataMap.get(0).get("NumGuMeiAndShiZhiAnd80To90F"));
        jsonObject.put("NumGuMeiAndShiZhiAnd90AboveF",dataMap.get(0).get("NumGuMeiAndShiZhiAnd90AboveF"));

        jsonObject.put("NumGuMeiAndChangHuAndHuJi",dataMap.get(0).get("NumGuMeiAndChangHuAndHuJi"));
        jsonObject.put("NumGuMeiAndChangHuAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndChangHuAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndChangHuAndMale",dataMap.get(0).get("NumGuMeiAndChangHuAndMale"));
        jsonObject.put("NumGuMeiAndChangHuAndFemale",dataMap.get(0).get("NumGuMeiAndChangHuAndFemale"));
        jsonObject.put("NumGuMeiAndChangHuAnd60To70M",dataMap.get(0).get("NumGuMeiAndChangHuAnd60To70M"));
        jsonObject.put("NumGuMeiAndChangHuAnd70To80M",dataMap.get(0).get("NumGuMeiAndChangHuAnd70To80M"));
        jsonObject.put("NumGuMeiAndChangHuAnd80To90M",dataMap.get(0).get("NumGuMeiAndChangHuAnd80To90M"));
        jsonObject.put("NumGuMeiAndChangHuAnd90AboveM",dataMap.get(0).get("NumGuMeiAndChangHuAnd90AboveM"));
        jsonObject.put("NumGuMeiAndChangHuAnd60To70F",dataMap.get(0).get("NumGuMeiAndChangHuAnd60To70F"));
        jsonObject.put("NumGuMeiAndChangHuAnd70To80F",dataMap.get(0).get("NumGuMeiAndChangHuAnd70To80F"));
        jsonObject.put("NumGuMeiAndChangHuAnd80To90F",dataMap.get(0).get("NumGuMeiAndChangHuAnd80To90F"));
        jsonObject.put("NumGuMeiAndChangHuAnd90AboveF",dataMap.get(0).get("NumGuMeiAndChangHuAnd90AboveF"));

        jsonObject.put("NumGuMeiAndQiTaAndHuJi",dataMap.get(0).get("NumGuMeiAndQiTaAndHuJi"));
        jsonObject.put("NumGuMeiAndQiTaAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndQiTaAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndQiTaAndMale",dataMap.get(0).get("NumGuMeiAndQiTaAndMale"));
        jsonObject.put("NumGuMeiAndQiTaAndFemale",dataMap.get(0).get("NumGuMeiAndQiTaAndFemale"));
        jsonObject.put("NumGuMeiAndQiTaAnd60To70M",dataMap.get(0).get("NumGuMeiAndQiTaAnd60To70M"));
        jsonObject.put("NumGuMeiAndQiTaAnd70To80M",dataMap.get(0).get("NumGuMeiAndQiTaAnd70To80M"));
        jsonObject.put("NumGuMeiAndQiTaAnd80To90M",dataMap.get(0).get("NumGuMeiAndQiTaAnd80To90M"));
        jsonObject.put("NumGuMeiAndQiTaAnd90AboveM",dataMap.get(0).get("NumGuMeiAndQiTaAnd90AboveM"));
        jsonObject.put("NumGuMeiAndQiTaAnd60To70F",dataMap.get(0).get("NumGuMeiAndQiTaAnd60To70F"));
        jsonObject.put("NumGuMeiAndQiTaAnd70To80F",dataMap.get(0).get("NumGuMeiAndQiTaAnd70To80F"));
        jsonObject.put("NumGuMeiAndQiTaAnd80To90F",dataMap.get(0).get("NumGuMeiAndQiTaAnd80To90F"));
        jsonObject.put("NumGuMeiAndQiTaAnd90AboveF",dataMap.get(0).get("NumGuMeiAndQiTaAnd90AboveF"));

        //economy
        jsonObject.put("NumGuMeiAndBangKunAndHuJi",dataMap.get(0).get("NumGuMeiAndBangKunAndHuJi"));
        jsonObject.put("NumGuMeiAndBangKunAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndBangKunAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndBangKunAndMale",dataMap.get(0).get("NumGuMeiAndBangKunAndMale"));
        jsonObject.put("NumGuMeiAndBangKunAndFemale",dataMap.get(0).get("NumGuMeiAndBangKunAndFemale"));
        jsonObject.put("NumGuMeiAndBangKunAnd60To70M",dataMap.get(0).get("NumGuMeiAndBangKunAnd60To70M"));
        jsonObject.put("NumGuMeiAndBangKunAnd70To80M",dataMap.get(0).get("NumGuMeiAndBangKunAnd70To80M"));
        jsonObject.put("NumGuMeiAndBangKunAnd80To90M",dataMap.get(0).get("NumGuMeiAndBangKunAnd80To90M"));
        jsonObject.put("NumGuMeiAndBangKunAnd90AboveM",dataMap.get(0).get("NumGuMeiAndBangKunAnd90AboveM"));
        jsonObject.put("NumGuMeiAndBangKunAnd60To70F",dataMap.get(0).get("NumGuMeiAndBangKunAnd60To70F"));
        jsonObject.put("NumGuMeiAndBangKunAnd70To80F",dataMap.get(0).get("NumGuMeiAndBangKunAnd70To80F"));
        jsonObject.put("NumGuMeiAndBangKunAnd80To90F",dataMap.get(0).get("NumGuMeiAndBangKunAnd80To90F"));
        jsonObject.put("NumGuMeiAndBangKunAnd90AboveF",dataMap.get(0).get("NumGuMeiAndBangKunAnd90AboveF"));

        jsonObject.put("NumGuMeiAndDiBaoAndHuJi",dataMap.get(0).get("NumGuMeiAndDiBaoAndHuJi"));
        jsonObject.put("NumGuMeiAndDiBaoAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndDiBaoAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndDiBaoAndMale",dataMap.get(0).get("NumGuMeiAndDiBaoAndMale"));
        jsonObject.put("NumGuMeiAndDiBaoAndFemale",dataMap.get(0).get("NumGuMeiAndDiBaoAndFemale"));
        jsonObject.put("NumGuMeiAndDiBaoAnd60To70M",dataMap.get(0).get("NumGuMeiAndDiBaoAnd60To70M"));
        jsonObject.put("NumGuMeiAndDiBaoAnd70To80M",dataMap.get(0).get("NumGuMeiAndDiBaoAnd70To80M"));
        jsonObject.put("NumGuMeiAndDiBaoAnd80To90M",dataMap.get(0).get("NumGuMeiAndDiBaoAnd80To90M"));
        jsonObject.put("NumGuMeiAndDiBaoAnd90AboveM",dataMap.get(0).get("NumGuMeiAndDiBaoAnd90AboveM"));
        jsonObject.put("NumGuMeiAndDiBaoAnd60To70F",dataMap.get(0).get("NumGuMeiAndDiBaoAnd60To70F"));
        jsonObject.put("NumGuMeiAndDiBaoAnd70To80F",dataMap.get(0).get("NumGuMeiAndDiBaoAnd70To80F"));
        jsonObject.put("NumGuMeiAndDiBaoAnd80To90F",dataMap.get(0).get("NumGuMeiAndDiBaoAnd80To90F"));
        jsonObject.put("NumGuMeiAndDiBaoAnd90AboveF",dataMap.get(0).get("NumGuMeiAndDiBaoAnd90AboveF"));

        jsonObject.put("NumGuMeiAndYangLaoAndHuJi",dataMap.get(0).get("NumGuMeiAndYangLaoAndHuJi"));
        jsonObject.put("NumGuMeiAndYangLaoLiuAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndYangLaoLiuAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndYangLaoAndMale",dataMap.get(0).get("NumGuMeiAndYangLaoAndMale"));
        jsonObject.put("NumGuMeiAndYangLaoAndFemale",dataMap.get(0).get("NumGuMeiAndYangLaoAndFemale"));
        jsonObject.put("NumGuMeiAndYangLaoAnd60To70M",dataMap.get(0).get("NumGuMeiAndYangLaoAnd60To70M"));
        jsonObject.put("NumGuMeiAndYangLaoAnd70To80M",dataMap.get(0).get("NumGuMeiAndYangLaoAnd70To80M"));
        jsonObject.put("NumGuMeiAndYangLaoAnd80To90M",dataMap.get(0).get("NumGuMeiAndYangLaoAnd80To90M"));
        jsonObject.put("NumGuMeiAndYangLaoAnd90AboveM",dataMap.get(0).get("NumGuMeiAndYangLaoAnd90AboveM"));
        jsonObject.put("NumGuMeiAndYangLaoAnd60To70F",dataMap.get(0).get("NumGuMeiAndYangLaoAnd60To70F"));
        jsonObject.put("NumGuMeiAndYangLaoAnd70To80F",dataMap.get(0).get("NumGuMeiAndYangLaoAnd70To80F"));
        jsonObject.put("NumGuMeiAndYangLaoAnd80To90F",dataMap.get(0).get("NumGuMeiAndYangLaoAnd80To90F"));
        jsonObject.put("NumGuMeiAndYangLaoAnd90AboveF",dataMap.get(0).get("NumGuMeiAndYangLaoAnd90AboveF"));

        jsonObject.put("NumGuMeiAndYiLiaoAndHuJi",dataMap.get(0).get("NumGuMeiAndYiLiaoAndHuJi"));
        jsonObject.put("NumGuMeiAndYiLiaoAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndYiLiaoAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndYiLiaoAndMale",dataMap.get(0).get("NumGuMeiAndYiLiaoAndMale"));
        jsonObject.put("NumGuMeiAndYiLiaoAndFemale",dataMap.get(0).get("NumGuMeiAndYiLiaoAndFemale"));
        jsonObject.put("NumGuMeiAndYiLiaoAnd60To70M",dataMap.get(0).get("NumGuMeiAndYiLiaoAnd60To70M"));
        jsonObject.put("NumGuMeiAndYiLiaoAnd70To80M",dataMap.get(0).get("NumGuMeiAndYiLiaoAnd70To80M"));
        jsonObject.put("NumGuMeiAndYiLiaoAnd80To90M",dataMap.get(0).get("NumGuMeiAndYiLiaoAnd80To90M"));
        jsonObject.put("NumGuMeiAndYiLiaoAnd90AboveM",dataMap.get(0).get("NumGuMeiAndYiLiaoAnd90AboveM"));
        jsonObject.put("NumGuMeiAndYiLiaoAnd60To70F",dataMap.get(0).get("NumGuMeiAndYiLiaoAnd60To70F"));
        jsonObject.put("NumGuMeiAndYiLiaoAnd70To80F",dataMap.get(0).get("NumGuMeiAndYiLiaoAnd70To80F"));
        jsonObject.put("NumGuMeiAndYiLiaoAnd80To90F",dataMap.get(0).get("NumGuMeiAndYiLiaoAnd80To90F"));
        jsonObject.put("NumGuMeiAndYiLiaoAnd90AboveF",dataMap.get(0).get("NumGuMeiAndYiLiaoAnd90AboveF"));

        jsonObject.put("NumGuMeiAndChenZhenAndHuJi",dataMap.get(0).get("NumGuMeiAndChenZhenAndHuJi"));
        jsonObject.put("NumGuMeiAndChenZhenAndFeiHuJi",dataMap.get(0).get("NumGuMeiAndChenZhenAndFeiHuJi"));
        jsonObject.put("NumGuMeiAndChenZhenAndMale",dataMap.get(0).get("NumGuMeiAndChenZhenAndMale"));
        jsonObject.put("NumGuMeiAndChenZhenAndFemale",dataMap.get(0).get("NumGuMeiAndChenZhenAndFemale"));
        jsonObject.put("NumGuMeiAndChenZhenAnd60To70M",dataMap.get(0).get("NumGuMeiAndChenZhenAnd60To70M"));
        jsonObject.put("NumGuMeiAndChenZhenAnd70To80M",dataMap.get(0).get("NumGuMeiAndChenZhenAnd70To80M"));
        jsonObject.put("NumGuMeiAndChenZhenAnd80To90M",dataMap.get(0).get("NumGuMeiAndChenZhenAnd80To90M"));
        jsonObject.put("NumGuMeiAndChenZhenAnd90AboveM",dataMap.get(0).get("NumGuMeiAndChenZhenAnd90AboveM"));
        jsonObject.put("NumGuMeiAndChenZhenAnd60To70F",dataMap.get(0).get("NumGuMeiAndChenZhenAnd60To70F"));
        jsonObject.put("NumGuMeiAndChenZhenAnd70To80F",dataMap.get(0).get("NumGuMeiAndChenZhenAnd70To80F"));
        jsonObject.put("NumGuMeiAndChenZhenAnd80To90F",dataMap.get(0).get("NumGuMeiAndChenZhenAnd80To90F"));
        jsonObject.put("NumGuMeiAndChenZhenAnd90AboveF",dataMap.get(0).get("NumGuMeiAndChenZhenAnd90AboveF"));

//gulong fhe detail
        //family
        jsonObject.put("NumGuLongAndChunLaoAndHuJi",dataMap.get(0).get("NumGuLongAndChunLaoAndHuJi"));
        jsonObject.put("NumGuLongAndChunLaoAndFeiHuJi",dataMap.get(0).get("NumGuLongAndChunLaoAndFeiHuJi"));
        jsonObject.put("NumGuLongAndChunLaoAndMale",dataMap.get(0).get("NumGuLongAndChunLaoAndMale"));
        jsonObject.put("NumGuLongAndChunLaoAndFemale",dataMap.get(0).get("NumGuLongAndChunLaoAndFemale"));
        jsonObject.put("NumGuLongAndChunLaoAnd60To70M",dataMap.get(0).get("NumGuLongAndChunLaoAnd60To70M"));
        jsonObject.put("NumGuLongAndChunLaoAnd70To80M",dataMap.get(0).get("NumGuLongAndChunLaoAnd70To80M"));
        jsonObject.put("NumGuLongAndChunLaoAnd80To90M",dataMap.get(0).get("NumGuLongAndChunLaoAnd80To90M"));
        jsonObject.put("NumGuLongAndChunLaoAnd90AboveM",dataMap.get(0).get("NumGuLongAndChunLaoAnd90AboveM"));
        jsonObject.put("NumGuLongAndChunLaoAnd60To70F",dataMap.get(0).get("NumGuLongAndChunLaoAnd60To70F"));
        jsonObject.put("NumGuLongAndChunLaoAnd70To80F",dataMap.get(0).get("NumGuLongAndChunLaoAnd70To80F"));
        jsonObject.put("NumGuLongAndChunLaoAnd80To90F",dataMap.get(0).get("NumGuLongAndChunLaoAnd80To90F"));
        jsonObject.put("NumGuLongAndChunLaoAnd90AboveF",dataMap.get(0).get("NumGuLongAndChunLaoAnd90AboveF"));


        jsonObject.put("NumGuLongAndDuJuAndHuJi",dataMap.get(0).get("NumGuLongAndDuJuAndHuJi"));
        jsonObject.put("NumGuLongAndDuJuAndFeiHuJi",dataMap.get(0).get("NumGuLongAndDuJuAndFeiHuJi"));
        jsonObject.put("NumGuLongAndDuJuAndMale",dataMap.get(0).get("NumGuLongAndDuJuAndMale"));
        jsonObject.put("NumGuLongAndDuJuAndFemale",dataMap.get(0).get("NumGuLongAndDuJuAndFemale"));
        jsonObject.put("NumGuLongAndDuJuAnd60To70M",dataMap.get(0).get("NumGuLongAndDuJuAnd60To70M"));
        jsonObject.put("NumGuLongAndDuJuAnd70To80M",dataMap.get(0).get("NumGuLongAndDuJuAnd70To80M"));
        jsonObject.put("NumGuLongAndDuJuAnd80To90M",dataMap.get(0).get("NumGuLongAndDuJuAnd80To90M"));
        jsonObject.put("NumGuLongAndDuJuAnd90AboveM",dataMap.get(0).get("NumGuLongAndDuJuAnd90AboveM"));
        jsonObject.put("NumGuLongAndDuJuAnd60To70F",dataMap.get(0).get("NumGuLongAndDuJuAnd60To70F"));
        jsonObject.put("NumGuLongAndDuJuAnd70To80F",dataMap.get(0).get("NumGuLongAndDuJuAnd70To80F"));
        jsonObject.put("NumGuLongAndDuJuAnd80To90F",dataMap.get(0).get("NumGuLongAndDuJuAnd80To90F"));
        jsonObject.put("NumGuLongAndDuJuAnd90AboveF",dataMap.get(0).get("NumGuLongAndDuJuAnd90AboveF"));


        jsonObject.put("NumGuLongAndShiDuAndHuJi",dataMap.get(0).get("NumGuLongAndShiDuAndHuJi"));
        jsonObject.put("NumGuLongAndShiDuAndFeiHuJi",dataMap.get(0).get("NumGuLongAndShiDuAndFeiHuJi"));
        jsonObject.put("NumGuLongAndShiDuAndMale",dataMap.get(0).get("NumGuLongAndShiDuAndMale"));
        jsonObject.put("NumGuLongAndShiDuAndFemale",dataMap.get(0).get("NumGuLongAndShiDuAndFemale"));
        jsonObject.put("NumGuLongAndShiDuAnd60To70M",dataMap.get(0).get("NumGuLongAndShiDuAnd60To70M"));
        jsonObject.put("NumGuLongAndShiDuAnd70To80M",dataMap.get(0).get("NumGuLongAndShiDuAnd70To80M"));
        jsonObject.put("NumGuLongAndShiDuAnd80To90M",dataMap.get(0).get("NumGuLongAndShiDuAnd80To90M"));
        jsonObject.put("NumGuLongAndShiDuAnd90AboveM",dataMap.get(0).get("NumGuLongAndShiDuAnd90AboveM"));
        jsonObject.put("NumGuLongAndShiDuAnd60To70F",dataMap.get(0).get("NumGuLongAndShiDuAnd60To70F"));
        jsonObject.put("NumGuLongAndShiDuAnd70To80F",dataMap.get(0).get("NumGuLongAndShiDuAnd70To80F"));
        jsonObject.put("NumGuLongAndShiDuAnd80To90F",dataMap.get(0).get("NumGuLongAndShiDuAnd80To90F"));
        jsonObject.put("NumGuLongAndShiDuAnd90AboveF",dataMap.get(0).get("NumGuLongAndShiDuAnd90AboveF"));

        jsonObject.put("NumGuLongAndYiLaoAndHuJi",dataMap.get(0).get("NumGuLongAndYiLaoAndHuJi"));
        jsonObject.put("NumGuLongAndYiLaoAndFeiHuJi",dataMap.get(0).get("NumGuLongAndYiLaoAndFeiHuJi"));
        jsonObject.put("NumGuLongAndYiLaoAndMale",dataMap.get(0).get("NumGuLongAndYiLaoAndMale"));
        jsonObject.put("NumGuLongAndYiLaoAndFemale",dataMap.get(0).get("NumGuLongAndYiLaoAndFemale"));
        jsonObject.put("NumGuLongAndYiLaoAnd60To70M",dataMap.get(0).get("NumGuLongAndYiLaoAnd60To70M"));
        jsonObject.put("NumGuLongAndYiLaoAnd70To80M",dataMap.get(0).get("NumGuLongAndYiLaoAnd70To80M"));
        jsonObject.put("NumGuLongAndYiLaoAnd80To90M",dataMap.get(0).get("NumGuLongAndYiLaoAnd80To90M"));
        jsonObject.put("NumGuLongAndYiLaoAnd90AboveM",dataMap.get(0).get("NumGuLongAndYiLaoAnd90AboveM"));
        jsonObject.put("NumGuLongAndYiLaoAnd60To70F",dataMap.get(0).get("NumGuLongAndYiLaoAnd60To70F"));
        jsonObject.put("NumGuLongAndYiLaoAnd70To80F",dataMap.get(0).get("NumGuLongAndYiLaoAnd70To80F"));
        jsonObject.put("NumGuLongAndYiLaoAnd80To90F",dataMap.get(0).get("NumGuLongAndYiLaoAnd80To90F"));
        jsonObject.put("NumGuLongAndYiLaoAnd90AboveF",dataMap.get(0).get("NumGuLongAndYiLaoAnd90AboveF"));

        jsonObject.put("NumGuLongAndGuLaoAndHuJi",dataMap.get(0).get("NumGuLongAndGuLaoAndHuJi"));
        jsonObject.put("NumGuLongAndGuLaoAndFeiHuJi",dataMap.get(0).get("NumGuLongAndGuLaoAndFeiHuJi"));
        jsonObject.put("NumGuLongAndGuLaoAndMale",dataMap.get(0).get("NumGuLongAndGuLaoAndMale"));
        jsonObject.put("NumGuLongAndGuLaoAndFemale",dataMap.get(0).get("NumGuLongAndGuLaoAndFemale"));
        jsonObject.put("NumGuLongAndGuLaoAnd60To70M",dataMap.get(0).get("NumGuLongAndGuLaoAnd60To70M"));
        jsonObject.put("NumGuLongAndGuLaoAnd70To80M",dataMap.get(0).get("NumGuLongAndGuLaoAnd70To80M"));
        jsonObject.put("NumGuLongAndGuLaoAnd80To90M",dataMap.get(0).get("NumGuLongAndGuLaoAnd80To90M"));
        jsonObject.put("NumGuLongAndGuLaoAnd90AboveM",dataMap.get(0).get("NumGuLongAndGuLaoAnd90AboveM"));
        jsonObject.put("NumGuLongAndGuLaoAnd60To70F",dataMap.get(0).get("NumGuLongAndGuLaoAnd60To70F"));
        jsonObject.put("NumGuLongAndGuLaoAnd70To80F",dataMap.get(0).get("NumGuLongAndGuLaoAnd70To80F"));
        jsonObject.put("NumGuLongAndGuLaoAnd80To90F",dataMap.get(0).get("NumGuLongAndGuLaoAnd80To90F"));
        jsonObject.put("NumGuLongAndGuLaoAnd90AboveF",dataMap.get(0).get("NumGuLongAndGuLaoAnd90AboveF"));

        jsonObject.put("NumGuLongAndSanZhiAndHuJi",dataMap.get(0).get("NumGuLongAndSanZhiAndHuJi"));
        jsonObject.put("NumGuLongAndSanZhiAndFeiHuJi",dataMap.get(0).get("NumGuLongAndSanZhiAndFeiHuJi"));
        jsonObject.put("NumGuLongAndSanZhiAndMale",dataMap.get(0).get("NumGuLongAndSanZhiAndMale"));
        jsonObject.put("NumGuLongAndSanZhiAndFemale",dataMap.get(0).get("NumGuLongAndSanZhiAndFemale"));
        jsonObject.put("NumGuLongAndSanZhiAnd60To70M",dataMap.get(0).get("NumGuLongAndSanZhiAnd60To70M"));
        jsonObject.put("NumGuLongAndSanZhiAnd70To80M",dataMap.get(0).get("NumGuLongAndSanZhiAnd70To80M"));
        jsonObject.put("NumGuLongAndSanZhiAnd80To90M",dataMap.get(0).get("NumGuLongAndSanZhiAnd80To90M"));
        jsonObject.put("NumGuLongAndSanZhiAnd90AboveM",dataMap.get(0).get("NumGuLongAndSanZhiAnd90AboveM"));
        jsonObject.put("NumGuLongAndSanZhiAnd60To70F",dataMap.get(0).get("NumGuLongAndSanZhiAnd60To70F"));
        jsonObject.put("NumGuLongAndSanZhiAnd70To80F",dataMap.get(0).get("NumGuLongAndSanZhiAnd70To80F"));
        jsonObject.put("NumGuLongAndSanZhiAnd80To90F",dataMap.get(0).get("NumGuLongAndSanZhiAnd80To90F"));
        jsonObject.put("NumGuLongAndSanZhiAnd90AboveF",dataMap.get(0).get("NumGuLongAndSanZhiAnd90AboveF"));

        jsonObject.put("NumGuLongAndQiTaAndHuJi",dataMap.get(0).get("NumGuLongAndQiTaAndHuJi"));
        jsonObject.put("NumGuLongAndQiTaAndFeiHuJi",dataMap.get(0).get("NumGuLongAndQiTaAndFeiHuJi"));
        jsonObject.put("NumGuLongAndQiTaAndMale",dataMap.get(0).get("NumGuLongAndQiTaAndMale"));
        jsonObject.put("NumGuLongAndQiTaAndFemale",dataMap.get(0).get("NumGuLongAndQiTaAndFemale"));
        jsonObject.put("NumGuLongAndQiTaAnd60To70M",dataMap.get(0).get("NumGuLongAndQiTaAnd60To70M"));
        jsonObject.put("NumGuLongAndQiTaAnd70To80M",dataMap.get(0).get("NumGuLongAndQiTaAnd70To80M"));
        jsonObject.put("NumGuLongAndQiTaAnd80To90M",dataMap.get(0).get("NumGuLongAndQiTaAnd80To90M"));
        jsonObject.put("NumGuLongAndQiTaAnd90AboveM",dataMap.get(0).get("NumGuLongAndQiTaAnd90AboveM"));
        jsonObject.put("NumGuLongAndQiTaAnd60To70F",dataMap.get(0).get("NumGuLongAndQiTaAnd60To70F"));
        jsonObject.put("NumGuLongAndQiTaAnd70To80F",dataMap.get(0).get("NumGuLongAndQiTaAnd70To80F"));
        jsonObject.put("NumGuLongAndQiTaAnd80To90F",dataMap.get(0).get("NumGuLongAndQiTaAnd80To90F"));
        jsonObject.put("NumGuLongAndQiTaAnd90AboveF",dataMap.get(0).get("NumGuLongAndQiTaAnd90AboveF"));

        //health
        jsonObject.put("NumGuLongAndShiNengAndHuJi",dataMap.get(0).get("NumGuLongAndShiNengAndHuJi"));
        jsonObject.put("NumGuLongAndShiNengAndFeiHuJi",dataMap.get(0).get("NumGuLongAndShiNengAndFeiHuJi"));
        jsonObject.put("NumGuLongAndShiNengAndMale",dataMap.get(0).get("NumGuLongAndShiNengAndMale"));
        jsonObject.put("NumGuLongAndShiNengAndFemale",dataMap.get(0).get("NumGuLongAndShiNengAndFemale"));
        jsonObject.put("NumGuLongAndShiNengAnd60To70M",dataMap.get(0).get("NumGuLongAndShiNengAnd60To70M"));
        jsonObject.put("NumGuLongAndShiNengAnd70To80M",dataMap.get(0).get("NumGuLongAndShiNengAnd70To80M"));
        jsonObject.put("NumGuLongAndShiNengAnd80To90M",dataMap.get(0).get("NumGuLongAndShiNengAnd80To90M"));
        jsonObject.put("NumGuLongAndShiNengAnd90AboveM",dataMap.get(0).get("NumGuLongAndShiNengAnd90AboveM"));
        jsonObject.put("NumGuLongAndShiNengAnd60To70F",dataMap.get(0).get("NumGuLongAndShiNengAnd60To70F"));
        jsonObject.put("NumGuLongAndShiNengAnd70To80F",dataMap.get(0).get("NumGuLongAndShiNengAnd70To80F"));
        jsonObject.put("NumGuLongAndShiNengAnd80To90F",dataMap.get(0).get("NumGuLongAndShiNengAnd80To90F"));
        jsonObject.put("NumGuLongAndShiNengAnd90AboveF",dataMap.get(0).get("NumGuLongAndShiNengAnd90AboveF"));

        jsonObject.put("NumGuLongAndManBingAndHuJi",dataMap.get(0).get("NumGuLongAndManBingAndHuJi"));
        jsonObject.put("NumGuLongAndManBingAndFeiHuJi",dataMap.get(0).get("NumGuLongAndManBingAndFeiHuJi"));
        jsonObject.put("NumGuLongAndManBingAndMale",dataMap.get(0).get("NumGuLongAndManBingAndMale"));
        jsonObject.put("NumGuLongAndManBingAndFemale",dataMap.get(0).get("NumGuLongAndManBingAndFemale"));
        jsonObject.put("NumGuLongAndManBingAnd60To70M",dataMap.get(0).get("NumGuLongAndManBingAnd60To70M"));
        jsonObject.put("NumGuLongAndManBingAnd70To80M",dataMap.get(0).get("NumGuLongAndManBingAnd70To80M"));
        jsonObject.put("NumGuLongAndManBingAnd80To90M",dataMap.get(0).get("NumGuLongAndManBingAnd80To90M"));
        jsonObject.put("NumGuLongAndManBingAnd90AboveM",dataMap.get(0).get("NumGuLongAndManBingAnd90AboveM"));
        jsonObject.put("NumGuLongAndManBingAnd60To70F",dataMap.get(0).get("NumGuLongAndManBingAnd60To70F"));
        jsonObject.put("NumGuLongAndManBingAnd70To80F",dataMap.get(0).get("NumGuLongAndManBingAnd70To80F"));
        jsonObject.put("NumGuLongAndManBingAnd80To90F",dataMap.get(0).get("NumGuLongAndManBingAnd80To90F"));
        jsonObject.put("NumGuLongAndManBingAnd90AboveF",dataMap.get(0).get("NumGuLongAndManBingAnd90AboveF"));

        jsonObject.put("NumGuLongAndZhongLiuAndHuJi",dataMap.get(0).get("NumGuLongAndZhongLiuAndHuJi"));
        jsonObject.put("NumGuLongAndZhongLiuAndFeiHuJi",dataMap.get(0).get("NumGuLongAndZhongLiuAndFeiHuJi"));
        jsonObject.put("NumGuLongAndZhongLiuAndMale",dataMap.get(0).get("NumGuLongAndZhongLiuAndMale"));
        jsonObject.put("NumGuLongAndZhongLiuAndFemale",dataMap.get(0).get("NumGuLongAndZhongLiuAndFemale"));
        jsonObject.put("NumGuLongAndZhongLiuAnd60To70M",dataMap.get(0).get("NumGuLongAndZhongLiuAnd60To70M"));
        jsonObject.put("NumGuLongAndZhongLiuAnd70To80M",dataMap.get(0).get("NumGuLongAndZhongLiuAnd70To80M"));
        jsonObject.put("NumGuLongAndZhongLiuAnd80To90M",dataMap.get(0).get("NumGuLongAndZhongLiuAnd80To90M"));
        jsonObject.put("NumGuLongAndZhongLiuAnd90AboveM",dataMap.get(0).get("NumGuLongAndZhongLiuAnd90AboveM"));
        jsonObject.put("NumGuLongAndZhongLiuAnd60To70F",dataMap.get(0).get("NumGuLongAndZhongLiuAnd60To70F"));
        jsonObject.put("NumGuLongAndZhongLiuAnd70To80F",dataMap.get(0).get("NumGuLongAndZhongLiuAnd70To80F"));
        jsonObject.put("NumGuLongAndZhongLiuAnd80To90F",dataMap.get(0).get("NumGuLongAndZhongLiuAnd80To90F"));
        jsonObject.put("NumGuLongAndZhongLiuAnd90AboveF",dataMap.get(0).get("NumGuLongAndZhongLiuAnd90AboveF"));

        jsonObject.put("NumGuLongAndGuZheAndHuJi",dataMap.get(0).get("NumGuLongAndGuZheAndHuJi"));
        jsonObject.put("NumGuLongAndGuZheAndFeiHuJi",dataMap.get(0).get("NumGuLongAndGuZheAndFeiHuJi"));
        jsonObject.put("NumGuLongAndGuZheAndMale",dataMap.get(0).get("NumGuLongAndGuZheAndMale"));
        jsonObject.put("NumGuLongAndGuZheAndFemale",dataMap.get(0).get("NumGuLongAndGuZheAndFemale"));
        jsonObject.put("NumGuLongAndGuZheAnd60To70M",dataMap.get(0).get("NumGuLongAndGuZheAnd60To70M"));
        jsonObject.put("NumGuLongAndGuZheAnd70To80M",dataMap.get(0).get("NumGuLongAndGuZheAnd70To80M"));
        jsonObject.put("NumGuLongAndGuZheAnd80To90M",dataMap.get(0).get("NumGuLongAndGuZheAnd80To90M"));
        jsonObject.put("NumGuLongAndGuZheAnd90AboveM",dataMap.get(0).get("NumGuLongAndGuZheAnd90AboveM"));
        jsonObject.put("NumGuLongAndGuZheAnd60To70F",dataMap.get(0).get("NumGuLongAndGuZheAnd60To70F"));
        jsonObject.put("NumGuLongAndGuZheAnd70To80F",dataMap.get(0).get("NumGuLongAndGuZheAnd70To80F"));
        jsonObject.put("NumGuLongAndGuZheAnd80To90F",dataMap.get(0).get("NumGuLongAndGuZheAnd80To90F"));
        jsonObject.put("NumGuLongAndGuZheAnd90AboveF",dataMap.get(0).get("NumGuLongAndGuZheAnd90AboveF"));

        jsonObject.put("NumGuLongAndShiZhiAndHuJi",dataMap.get(0).get("NumGuLongAndShiZhiAndHuJi"));
        jsonObject.put("NumGuLongAndShiZhiAndFeiHuJi",dataMap.get(0).get("NumGuLongAndShiZhiAndFeiHuJi"));
        jsonObject.put("NumGuLongAndShiZhiAndMale",dataMap.get(0).get("NumGuLongAndShiZhiAndMale"));
        jsonObject.put("NumGuLongAndShiZhiAndFemale",dataMap.get(0).get("NumGuLongAndShiZhiAndFemale"));
        jsonObject.put("NumGuLongAndShiZhiAnd60To70M",dataMap.get(0).get("NumGuLongAndShiZhiAnd60To70M"));
        jsonObject.put("NumGuLongAndShiZhiAnd70To80M",dataMap.get(0).get("NumGuLongAndShiZhiAnd70To80M"));
        jsonObject.put("NumGuLongAndShiZhiAnd80To90M",dataMap.get(0).get("NumGuLongAndShiZhiAnd80To90M"));
        jsonObject.put("NumGuLongAndShiZhiAnd90AboveM",dataMap.get(0).get("NumGuLongAndShiZhiAnd90AboveM"));
        jsonObject.put("NumGuLongAndShiZhiAnd60To70F",dataMap.get(0).get("NumGuLongAndShiZhiAnd60To70F"));
        jsonObject.put("NumGuLongAndShiZhiAnd70To80F",dataMap.get(0).get("NumGuLongAndShiZhiAnd70To80F"));
        jsonObject.put("NumGuLongAndShiZhiAnd80To90F",dataMap.get(0).get("NumGuLongAndShiZhiAnd80To90F"));
        jsonObject.put("NumGuLongAndShiZhiAnd90AboveF",dataMap.get(0).get("NumGuLongAndShiZhiAnd90AboveF"));

        jsonObject.put("NumGuLongAndChangHuAndHuJi",dataMap.get(0).get("NumGuLongAndChangHuAndHuJi"));
        jsonObject.put("NumGuLongAndChangHuAndFeiHuJi",dataMap.get(0).get("NumGuLongAndChangHuAndFeiHuJi"));
        jsonObject.put("NumGuLongAndChangHuAndMale",dataMap.get(0).get("NumGuLongAndChangHuAndMale"));
        jsonObject.put("NumGuLongAndChangHuAndFemale",dataMap.get(0).get("NumGuLongAndChangHuAndFemale"));
        jsonObject.put("NumGuLongAndChangHuAnd60To70M",dataMap.get(0).get("NumGuLongAndChangHuAnd60To70M"));
        jsonObject.put("NumGuLongAndChangHuAnd70To80M",dataMap.get(0).get("NumGuLongAndChangHuAnd70To80M"));
        jsonObject.put("NumGuLongAndChangHuAnd80To90M",dataMap.get(0).get("NumGuLongAndChangHuAnd80To90M"));
        jsonObject.put("NumGuLongAndChangHuAnd90AboveM",dataMap.get(0).get("NumGuLongAndChangHuAnd90AboveM"));
        jsonObject.put("NumGuLongAndChangHuAnd60To70F",dataMap.get(0).get("NumGuLongAndChangHuAnd60To70F"));
        jsonObject.put("NumGuLongAndChangHuAnd70To80F",dataMap.get(0).get("NumGuLongAndChangHuAnd70To80F"));
        jsonObject.put("NumGuLongAndChangHuAnd80To90F",dataMap.get(0).get("NumGuLongAndChangHuAnd80To90F"));
        jsonObject.put("NumGuLongAndChangHuAnd90AboveF",dataMap.get(0).get("NumGuLongAndChangHuAnd90AboveF"));

        jsonObject.put("NumGuLongAndQiTaAndHuJi",dataMap.get(0).get("NumGuLongAndQiTaAndHuJi"));
        jsonObject.put("NumGuLongAndQiTaAndFeiHuJi",dataMap.get(0).get("NumGuLongAndQiTaAndFeiHuJi"));
        jsonObject.put("NumGuLongAndQiTaAndMale",dataMap.get(0).get("NumGuLongAndQiTaAndMale"));
        jsonObject.put("NumGuLongAndQiTaAndFemale",dataMap.get(0).get("NumGuLongAndQiTaAndFemale"));
        jsonObject.put("NumGuLongAndQiTaAnd60To70M",dataMap.get(0).get("NumGuLongAndQiTaAnd60To70M"));
        jsonObject.put("NumGuLongAndQiTaAnd70To80M",dataMap.get(0).get("NumGuLongAndQiTaAnd70To80M"));
        jsonObject.put("NumGuLongAndQiTaAnd80To90M",dataMap.get(0).get("NumGuLongAndQiTaAnd80To90M"));
        jsonObject.put("NumGuLongAndQiTaAnd90AboveM",dataMap.get(0).get("NumGuLongAndQiTaAnd90AboveM"));
        jsonObject.put("NumGuLongAndQiTaAnd60To70F",dataMap.get(0).get("NumGuLongAndQiTaAnd60To70F"));
        jsonObject.put("NumGuLongAndQiTaAnd70To80F",dataMap.get(0).get("NumGuLongAndQiTaAnd70To80F"));
        jsonObject.put("NumGuLongAndQiTaAnd80To90F",dataMap.get(0).get("NumGuLongAndQiTaAnd80To90F"));
        jsonObject.put("NumGuLongAndQiTaAnd90AboveF",dataMap.get(0).get("NumGuLongAndQiTaAnd90AboveF"));

        //economy
        jsonObject.put("NumGuLongAndBangKunAndHuJi",dataMap.get(0).get("NumGuLongAndBangKunAndHuJi"));
        jsonObject.put("NumGuLongAndBangKunAndFeiHuJi",dataMap.get(0).get("NumGuLongAndBangKunAndFeiHuJi"));
        jsonObject.put("NumGuLongAndBangKunAndMale",dataMap.get(0).get("NumGuLongAndBangKunAndMale"));
        jsonObject.put("NumGuLongAndBangKunAndFemale",dataMap.get(0).get("NumGuLongAndBangKunAndFemale"));
        jsonObject.put("NumGuLongAndBangKunAnd60To70M",dataMap.get(0).get("NumGuLongAndBangKunAnd60To70M"));
        jsonObject.put("NumGuLongAndBangKunAnd70To80M",dataMap.get(0).get("NumGuLongAndBangKunAnd70To80M"));
        jsonObject.put("NumGuLongAndBangKunAnd80To90M",dataMap.get(0).get("NumGuLongAndBangKunAnd80To90M"));
        jsonObject.put("NumGuLongAndBangKunAnd90AboveM",dataMap.get(0).get("NumGuLongAndBangKunAnd90AboveM"));
        jsonObject.put("NumGuLongAndBangKunAnd60To70F",dataMap.get(0).get("NumGuLongAndBangKunAnd60To70F"));
        jsonObject.put("NumGuLongAndBangKunAnd70To80F",dataMap.get(0).get("NumGuLongAndBangKunAnd70To80F"));
        jsonObject.put("NumGuLongAndBangKunAnd80To90F",dataMap.get(0).get("NumGuLongAndBangKunAnd80To90F"));
        jsonObject.put("NumGuLongAndBangKunAnd90AboveF",dataMap.get(0).get("NumGuLongAndBangKunAnd90AboveF"));

        jsonObject.put("NumGuLongAndDiBaoAndHuJi",dataMap.get(0).get("NumGuLongAndDiBaoAndHuJi"));
        jsonObject.put("NumGuLongAndDiBaoAndFeiHuJi",dataMap.get(0).get("NumGuLongAndDiBaoAndFeiHuJi"));
        jsonObject.put("NumGuLongAndDiBaoAndMale",dataMap.get(0).get("NumGuLongAndDiBaoAndMale"));
        jsonObject.put("NumGuLongAndDiBaoAndFemale",dataMap.get(0).get("NumGuLongAndDiBaoAndFemale"));
        jsonObject.put("NumGuLongAndDiBaoAnd60To70M",dataMap.get(0).get("NumGuLongAndDiBaoAnd60To70M"));
        jsonObject.put("NumGuLongAndDiBaoAnd70To80M",dataMap.get(0).get("NumGuLongAndDiBaoAnd70To80M"));
        jsonObject.put("NumGuLongAndDiBaoAnd80To90M",dataMap.get(0).get("NumGuLongAndDiBaoAnd80To90M"));
        jsonObject.put("NumGuLongAndDiBaoAnd90AboveM",dataMap.get(0).get("NumGuLongAndDiBaoAnd90AboveM"));
        jsonObject.put("NumGuLongAndDiBaoAnd60To70F",dataMap.get(0).get("NumGuLongAndDiBaoAnd60To70F"));
        jsonObject.put("NumGuLongAndDiBaoAnd70To80F",dataMap.get(0).get("NumGuLongAndDiBaoAnd70To80F"));
        jsonObject.put("NumGuLongAndDiBaoAnd80To90F",dataMap.get(0).get("NumGuLongAndDiBaoAnd80To90F"));
        jsonObject.put("NumGuLongAndDiBaoAnd90AboveF",dataMap.get(0).get("NumGuLongAndDiBaoAnd90AboveF"));

        jsonObject.put("NumGuLongAndYangLaoAndHuJi",dataMap.get(0).get("NumGuLongAndYangLaoAndHuJi"));
        jsonObject.put("NumGuLongAndYangLaoLiuAndFeiHuJi",dataMap.get(0).get("NumGuLongAndYangLaoLiuAndFeiHuJi"));
        jsonObject.put("NumGuLongAndYangLaoAndMale",dataMap.get(0).get("NumGuLongAndYangLaoAndMale"));
        jsonObject.put("NumGuLongAndYangLaoAndFemale",dataMap.get(0).get("NumGuLongAndYangLaoAndFemale"));
        jsonObject.put("NumGuLongAndYangLaoAnd60To70M",dataMap.get(0).get("NumGuLongAndYangLaoAnd60To70M"));
        jsonObject.put("NumGuLongAndYangLaoAnd70To80M",dataMap.get(0).get("NumGuLongAndYangLaoAnd70To80M"));
        jsonObject.put("NumGuLongAndYangLaoAnd80To90M",dataMap.get(0).get("NumGuLongAndYangLaoAnd80To90M"));
        jsonObject.put("NumGuLongAndYangLaoAnd90AboveM",dataMap.get(0).get("NumGuLongAndYangLaoAnd90AboveM"));
        jsonObject.put("NumGuLongAndYangLaoAnd60To70F",dataMap.get(0).get("NumGuLongAndYangLaoAnd60To70F"));
        jsonObject.put("NumGuLongAndYangLaoAnd70To80F",dataMap.get(0).get("NumGuLongAndYangLaoAnd70To80F"));
        jsonObject.put("NumGuLongAndYangLaoAnd80To90F",dataMap.get(0).get("NumGuLongAndYangLaoAnd80To90F"));
        jsonObject.put("NumGuLongAndYangLaoAnd90AboveF",dataMap.get(0).get("NumGuLongAndYangLaoAnd90AboveF"));

        jsonObject.put("NumGuLongAndYiLiaoAndHuJi",dataMap.get(0).get("NumGuLongAndYiLiaoAndHuJi"));
        jsonObject.put("NumGuLongAndYiLiaoAndFeiHuJi",dataMap.get(0).get("NumGuLongAndYiLiaoAndFeiHuJi"));
        jsonObject.put("NumGuLongAndYiLiaoAndMale",dataMap.get(0).get("NumGuLongAndYiLiaoAndMale"));
        jsonObject.put("NumGuLongAndYiLiaoAndFemale",dataMap.get(0).get("NumGuLongAndYiLiaoAndFemale"));
        jsonObject.put("NumGuLongAndYiLiaoAnd60To70M",dataMap.get(0).get("NumGuLongAndYiLiaoAnd60To70M"));
        jsonObject.put("NumGuLongAndYiLiaoAnd70To80M",dataMap.get(0).get("NumGuLongAndYiLiaoAnd70To80M"));
        jsonObject.put("NumGuLongAndYiLiaoAnd80To90M",dataMap.get(0).get("NumGuLongAndYiLiaoAnd80To90M"));
        jsonObject.put("NumGuLongAndYiLiaoAnd90AboveM",dataMap.get(0).get("NumGuLongAndYiLiaoAnd90AboveM"));
        jsonObject.put("NumGuLongAndYiLiaoAnd60To70F",dataMap.get(0).get("NumGuLongAndYiLiaoAnd60To70F"));
        jsonObject.put("NumGuLongAndYiLiaoAnd70To80F",dataMap.get(0).get("NumGuLongAndYiLiaoAnd70To80F"));
        jsonObject.put("NumGuLongAndYiLiaoAnd80To90F",dataMap.get(0).get("NumGuLongAndYiLiaoAnd80To90F"));
        jsonObject.put("NumGuLongAndYiLiaoAnd90AboveF",dataMap.get(0).get("NumGuLongAndYiLiaoAnd90AboveF"));

        jsonObject.put("NumGuLongAndChenZhenAndHuJi",dataMap.get(0).get("NumGuLongAndChenZhenAndHuJi"));
        jsonObject.put("NumGuLongAndChenZhenAndFeiHuJi",dataMap.get(0).get("NumGuLongAndChenZhenAndFeiHuJi"));
        jsonObject.put("NumGuLongAndChenZhenAndMale",dataMap.get(0).get("NumGuLongAndChenZhenAndMale"));
        jsonObject.put("NumGuLongAndChenZhenAndFemale",dataMap.get(0).get("NumGuLongAndChenZhenAndFemale"));
        jsonObject.put("NumGuLongAndChenZhenAnd60To70M",dataMap.get(0).get("NumGuLongAndChenZhenAnd60To70M"));
        jsonObject.put("NumGuLongAndChenZhenAnd70To80M",dataMap.get(0).get("NumGuLongAndChenZhenAnd70To80M"));
        jsonObject.put("NumGuLongAndChenZhenAnd80To90M",dataMap.get(0).get("NumGuLongAndChenZhenAnd80To90M"));
        jsonObject.put("NumGuLongAndChenZhenAnd90AboveM",dataMap.get(0).get("NumGuLongAndChenZhenAnd90AboveM"));
        jsonObject.put("NumGuLongAndChenZhenAnd60To70F",dataMap.get(0).get("NumGuLongAndChenZhenAnd60To70F"));
        jsonObject.put("NumGuLongAndChenZhenAnd70To80F",dataMap.get(0).get("NumGuLongAndChenZhenAnd70To80F"));
        jsonObject.put("NumGuLongAndChenZhenAnd80To90F",dataMap.get(0).get("NumGuLongAndChenZhenAnd80To90F"));
        jsonObject.put("NumGuLongAndChenZhenAnd90AboveF",dataMap.get(0).get("NumGuLongAndChenZhenAnd90AboveF"));

//      donglan
        //family
        jsonObject.put("NumDongLanAndChunLaoAndHuJi",dataMap.get(0).get("NumDongLanAndChunLaoAndHuJi"));
        jsonObject.put("NumDongLanAndChunLaoAndFeiHuJi",dataMap.get(0).get("NumDongLanAndChunLaoAndFeiHuJi"));
        jsonObject.put("NumDongLanAndChunLaoAndMale",dataMap.get(0).get("NumDongLanAndChunLaoAndMale"));
        jsonObject.put("NumDongLanAndChunLaoAndFemale",dataMap.get(0).get("NumDongLanAndChunLaoAndFemale"));
        jsonObject.put("NumDongLanAndChunLaoAnd60To70M",dataMap.get(0).get("NumDongLanAndChunLaoAnd60To70M"));
        jsonObject.put("NumDongLanAndChunLaoAnd70To80M",dataMap.get(0).get("NumDongLanAndChunLaoAnd70To80M"));
        jsonObject.put("NumDongLanAndChunLaoAnd80To90M",dataMap.get(0).get("NumDongLanAndChunLaoAnd80To90M"));
        jsonObject.put("NumDongLanAndChunLaoAnd90AboveM",dataMap.get(0).get("NumDongLanAndChunLaoAnd90AboveM"));
        jsonObject.put("NumDongLanAndChunLaoAnd60To70F",dataMap.get(0).get("NumDongLanAndChunLaoAnd60To70F"));
        jsonObject.put("NumDongLanAndChunLaoAnd70To80F",dataMap.get(0).get("NumDongLanAndChunLaoAnd70To80F"));
        jsonObject.put("NumDongLanAndChunLaoAnd80To90F",dataMap.get(0).get("NumDongLanAndChunLaoAnd80To90F"));
        jsonObject.put("NumDongLanAndChunLaoAnd90AboveF",dataMap.get(0).get("NumDongLanAndChunLaoAnd90AboveF"));


        jsonObject.put("NumDongLanAndDuJuAndHuJi",dataMap.get(0).get("NumDongLanAndDuJuAndHuJi"));
        jsonObject.put("NumDongLanAndDuJuAndFeiHuJi",dataMap.get(0).get("NumDongLanAndDuJuAndFeiHuJi"));
        jsonObject.put("NumDongLanAndDuJuAndMale",dataMap.get(0).get("NumDongLanAndDuJuAndMale"));
        jsonObject.put("NumDongLanAndDuJuAndFemale",dataMap.get(0).get("NumDongLanAndDuJuAndFemale"));
        jsonObject.put("NumDongLanAndDuJuAnd60To70M",dataMap.get(0).get("NumDongLanAndDuJuAnd60To70M"));
        jsonObject.put("NumDongLanAndDuJuAnd70To80M",dataMap.get(0).get("NumDongLanAndDuJuAnd70To80M"));
        jsonObject.put("NumDongLanAndDuJuAnd80To90M",dataMap.get(0).get("NumDongLanAndDuJuAnd80To90M"));
        jsonObject.put("NumDongLanAndDuJuAnd90AboveM",dataMap.get(0).get("NumDongLanAndDuJuAnd90AboveM"));
        jsonObject.put("NumDongLanAndDuJuAnd60To70F",dataMap.get(0).get("NumDongLanAndDuJuAnd60To70F"));
        jsonObject.put("NumDongLanAndDuJuAnd70To80F",dataMap.get(0).get("NumDongLanAndDuJuAnd70To80F"));
        jsonObject.put("NumDongLanAndDuJuAnd80To90F",dataMap.get(0).get("NumDongLanAndDuJuAnd80To90F"));
        jsonObject.put("NumDongLanAndDuJuAnd90AboveF",dataMap.get(0).get("NumDongLanAndDuJuAnd90AboveF"));


        jsonObject.put("NumDongLanAndShiDuAndHuJi",dataMap.get(0).get("NumDongLanAndShiDuAndHuJi"));
        jsonObject.put("NumDongLanAndShiDuAndFeiHuJi",dataMap.get(0).get("NumDongLanAndShiDuAndFeiHuJi"));
        jsonObject.put("NumDongLanAndShiDuAndMale",dataMap.get(0).get("NumDongLanAndShiDuAndMale"));
        jsonObject.put("NumDongLanAndShiDuAndFemale",dataMap.get(0).get("NumDongLanAndShiDuAndFemale"));
        jsonObject.put("NumDongLanAndShiDuAnd60To70M",dataMap.get(0).get("NumDongLanAndShiDuAnd60To70M"));
        jsonObject.put("NumDongLanAndShiDuAnd70To80M",dataMap.get(0).get("NumDongLanAndShiDuAnd70To80M"));
        jsonObject.put("NumDongLanAndShiDuAnd80To90M",dataMap.get(0).get("NumDongLanAndShiDuAnd80To90M"));
        jsonObject.put("NumDongLanAndShiDuAnd90AboveM",dataMap.get(0).get("NumDongLanAndShiDuAnd90AboveM"));
        jsonObject.put("NumDongLanAndShiDuAnd60To70F",dataMap.get(0).get("NumDongLanAndShiDuAnd60To70F"));
        jsonObject.put("NumDongLanAndShiDuAnd70To80F",dataMap.get(0).get("NumDongLanAndShiDuAnd70To80F"));
        jsonObject.put("NumDongLanAndShiDuAnd80To90F",dataMap.get(0).get("NumDongLanAndShiDuAnd80To90F"));
        jsonObject.put("NumDongLanAndShiDuAnd90AboveF",dataMap.get(0).get("NumDongLanAndShiDuAnd90AboveF"));

        jsonObject.put("NumDongLanAndYiLaoAndHuJi",dataMap.get(0).get("NumDongLanAndYiLaoAndHuJi"));
        jsonObject.put("NumDongLanAndYiLaoAndFeiHuJi",dataMap.get(0).get("NumDongLanAndYiLaoAndFeiHuJi"));
        jsonObject.put("NumDongLanAndYiLaoAndMale",dataMap.get(0).get("NumDongLanAndYiLaoAndMale"));
        jsonObject.put("NumDongLanAndYiLaoAndFemale",dataMap.get(0).get("NumDongLanAndYiLaoAndFemale"));
        jsonObject.put("NumDongLanAndYiLaoAnd60To70M",dataMap.get(0).get("NumDongLanAndYiLaoAnd60To70M"));
        jsonObject.put("NumDongLanAndYiLaoAnd70To80M",dataMap.get(0).get("NumDongLanAndYiLaoAnd70To80M"));
        jsonObject.put("NumDongLanAndYiLaoAnd80To90M",dataMap.get(0).get("NumDongLanAndYiLaoAnd80To90M"));
        jsonObject.put("NumDongLanAndYiLaoAnd90AboveM",dataMap.get(0).get("NumDongLanAndYiLaoAnd90AboveM"));
        jsonObject.put("NumDongLanAndYiLaoAnd60To70F",dataMap.get(0).get("NumDongLanAndYiLaoAnd60To70F"));
        jsonObject.put("NumDongLanAndYiLaoAnd70To80F",dataMap.get(0).get("NumDongLanAndYiLaoAnd70To80F"));
        jsonObject.put("NumDongLanAndYiLaoAnd80To90F",dataMap.get(0).get("NumDongLanAndYiLaoAnd80To90F"));
        jsonObject.put("NumDongLanAndYiLaoAnd90AboveF",dataMap.get(0).get("NumDongLanAndYiLaoAnd90AboveF"));

        jsonObject.put("NumDongLanAndGuLaoAndHuJi",dataMap.get(0).get("NumDongLanAndGuLaoAndHuJi"));
        jsonObject.put("NumDongLanAndGuLaoAndFeiHuJi",dataMap.get(0).get("NumDongLanAndGuLaoAndFeiHuJi"));
        jsonObject.put("NumDongLanAndGuLaoAndMale",dataMap.get(0).get("NumDongLanAndGuLaoAndMale"));
        jsonObject.put("NumDongLanAndGuLaoAndFemale",dataMap.get(0).get("NumDongLanAndGuLaoAndFemale"));
        jsonObject.put("NumDongLanAndGuLaoAnd60To70M",dataMap.get(0).get("NumDongLanAndGuLaoAnd60To70M"));
        jsonObject.put("NumDongLanAndGuLaoAnd70To80M",dataMap.get(0).get("NumDongLanAndGuLaoAnd70To80M"));
        jsonObject.put("NumDongLanAndGuLaoAnd80To90M",dataMap.get(0).get("NumDongLanAndGuLaoAnd80To90M"));
        jsonObject.put("NumDongLanAndGuLaoAnd90AboveM",dataMap.get(0).get("NumDongLanAndGuLaoAnd90AboveM"));
        jsonObject.put("NumDongLanAndGuLaoAnd60To70F",dataMap.get(0).get("NumDongLanAndGuLaoAnd60To70F"));
        jsonObject.put("NumDongLanAndGuLaoAnd70To80F",dataMap.get(0).get("NumDongLanAndGuLaoAnd70To80F"));
        jsonObject.put("NumDongLanAndGuLaoAnd80To90F",dataMap.get(0).get("NumDongLanAndGuLaoAnd80To90F"));
        jsonObject.put("NumDongLanAndGuLaoAnd90AboveF",dataMap.get(0).get("NumDongLanAndGuLaoAnd90AboveF"));

        jsonObject.put("NumDongLanAndSanZhiAndHuJi",dataMap.get(0).get("NumDongLanAndSanZhiAndHuJi"));
        jsonObject.put("NumDongLanAndSanZhiAndFeiHuJi",dataMap.get(0).get("NumDongLanAndSanZhiAndFeiHuJi"));
        jsonObject.put("NumDongLanAndSanZhiAndMale",dataMap.get(0).get("NumDongLanAndSanZhiAndMale"));
        jsonObject.put("NumDongLanAndSanZhiAndFemale",dataMap.get(0).get("NumDongLanAndSanZhiAndFemale"));
        jsonObject.put("NumDongLanAndSanZhiAnd60To70M",dataMap.get(0).get("NumDongLanAndSanZhiAnd60To70M"));
        jsonObject.put("NumDongLanAndSanZhiAnd70To80M",dataMap.get(0).get("NumDongLanAndSanZhiAnd70To80M"));
        jsonObject.put("NumDongLanAndSanZhiAnd80To90M",dataMap.get(0).get("NumDongLanAndSanZhiAnd80To90M"));
        jsonObject.put("NumDongLanAndSanZhiAnd90AboveM",dataMap.get(0).get("NumDongLanAndSanZhiAnd90AboveM"));
        jsonObject.put("NumDongLanAndSanZhiAnd60To70F",dataMap.get(0).get("NumDongLanAndSanZhiAnd60To70F"));
        jsonObject.put("NumDongLanAndSanZhiAnd70To80F",dataMap.get(0).get("NumDongLanAndSanZhiAnd70To80F"));
        jsonObject.put("NumDongLanAndSanZhiAnd80To90F",dataMap.get(0).get("NumDongLanAndSanZhiAnd80To90F"));
        jsonObject.put("NumDongLanAndSanZhiAnd90AboveF",dataMap.get(0).get("NumDongLanAndSanZhiAnd90AboveF"));

        jsonObject.put("NumDongLanAndQiTaAndHuJi",dataMap.get(0).get("NumDongLanAndQiTaAndHuJi"));
        jsonObject.put("NumDongLanAndQiTaAndFeiHuJi",dataMap.get(0).get("NumDongLanAndQiTaAndFeiHuJi"));
        jsonObject.put("NumDongLanAndQiTaAndMale",dataMap.get(0).get("NumDongLanAndQiTaAndMale"));
        jsonObject.put("NumDongLanAndQiTaAndFemale",dataMap.get(0).get("NumDongLanAndQiTaAndFemale"));
        jsonObject.put("NumDongLanAndQiTaAnd60To70M",dataMap.get(0).get("NumDongLanAndQiTaAnd60To70M"));
        jsonObject.put("NumDongLanAndQiTaAnd70To80M",dataMap.get(0).get("NumDongLanAndQiTaAnd70To80M"));
        jsonObject.put("NumDongLanAndQiTaAnd80To90M",dataMap.get(0).get("NumDongLanAndQiTaAnd80To90M"));
        jsonObject.put("NumDongLanAndQiTaAnd90AboveM",dataMap.get(0).get("NumDongLanAndQiTaAnd90AboveM"));
        jsonObject.put("NumDongLanAndQiTaAnd60To70F",dataMap.get(0).get("NumDongLanAndQiTaAnd60To70F"));
        jsonObject.put("NumDongLanAndQiTaAnd70To80F",dataMap.get(0).get("NumDongLanAndQiTaAnd70To80F"));
        jsonObject.put("NumDongLanAndQiTaAnd80To90F",dataMap.get(0).get("NumDongLanAndQiTaAnd80To90F"));
        jsonObject.put("NumDongLanAndQiTaAnd90AboveF",dataMap.get(0).get("NumDongLanAndQiTaAnd90AboveF"));

        //health
        jsonObject.put("NumDongLanAndShiNengAndHuJi",dataMap.get(0).get("NumDongLanAndShiNengAndHuJi"));
        jsonObject.put("NumDongLanAndShiNengAndFeiHuJi",dataMap.get(0).get("NumDongLanAndShiNengAndFeiHuJi"));
        jsonObject.put("NumDongLanAndShiNengAndMale",dataMap.get(0).get("NumDongLanAndShiNengAndMale"));
        jsonObject.put("NumDongLanAndShiNengAndFemale",dataMap.get(0).get("NumDongLanAndShiNengAndFemale"));
        jsonObject.put("NumDongLanAndShiNengAnd60To70M",dataMap.get(0).get("NumDongLanAndShiNengAnd60To70M"));
        jsonObject.put("NumDongLanAndShiNengAnd70To80M",dataMap.get(0).get("NumDongLanAndShiNengAnd70To80M"));
        jsonObject.put("NumDongLanAndShiNengAnd80To90M",dataMap.get(0).get("NumDongLanAndShiNengAnd80To90M"));
        jsonObject.put("NumDongLanAndShiNengAnd90AboveM",dataMap.get(0).get("NumDongLanAndShiNengAnd90AboveM"));
        jsonObject.put("NumDongLanAndShiNengAnd60To70F",dataMap.get(0).get("NumDongLanAndShiNengAnd60To70F"));
        jsonObject.put("NumDongLanAndShiNengAnd70To80F",dataMap.get(0).get("NumDongLanAndShiNengAnd70To80F"));
        jsonObject.put("NumDongLanAndShiNengAnd80To90F",dataMap.get(0).get("NumDongLanAndShiNengAnd80To90F"));
        jsonObject.put("NumDongLanAndShiNengAnd90AboveF",dataMap.get(0).get("NumDongLanAndShiNengAnd90AboveF"));

        jsonObject.put("NumDongLanAndManBingAndHuJi",dataMap.get(0).get("NumDongLanAndManBingAndHuJi"));
        jsonObject.put("NumDongLanAndManBingAndFeiHuJi",dataMap.get(0).get("NumDongLanAndManBingAndFeiHuJi"));
        jsonObject.put("NumDongLanAndManBingAndMale",dataMap.get(0).get("NumDongLanAndManBingAndMale"));
        jsonObject.put("NumDongLanAndManBingAndFemale",dataMap.get(0).get("NumDongLanAndManBingAndFemale"));
        jsonObject.put("NumDongLanAndManBingAnd60To70M",dataMap.get(0).get("NumDongLanAndManBingAnd60To70M"));
        jsonObject.put("NumDongLanAndManBingAnd70To80M",dataMap.get(0).get("NumDongLanAndManBingAnd70To80M"));
        jsonObject.put("NumDongLanAndManBingAnd80To90M",dataMap.get(0).get("NumDongLanAndManBingAnd80To90M"));
        jsonObject.put("NumDongLanAndManBingAnd90AboveM",dataMap.get(0).get("NumDongLanAndManBingAnd90AboveM"));
        jsonObject.put("NumDongLanAndManBingAnd60To70F",dataMap.get(0).get("NumDongLanAndManBingAnd60To70F"));
        jsonObject.put("NumDongLanAndManBingAnd70To80F",dataMap.get(0).get("NumDongLanAndManBingAnd70To80F"));
        jsonObject.put("NumDongLanAndManBingAnd80To90F",dataMap.get(0).get("NumDongLanAndManBingAnd80To90F"));
        jsonObject.put("NumDongLanAndManBingAnd90AboveF",dataMap.get(0).get("NumDongLanAndManBingAnd90AboveF"));

        jsonObject.put("NumDongLanAndZhongLiuAndHuJi",dataMap.get(0).get("NumDongLanAndZhongLiuAndHuJi"));
        jsonObject.put("NumDongLanAndZhongLiuAndFeiHuJi",dataMap.get(0).get("NumDongLanAndZhongLiuAndFeiHuJi"));
        jsonObject.put("NumDongLanAndZhongLiuAndMale",dataMap.get(0).get("NumDongLanAndZhongLiuAndMale"));
        jsonObject.put("NumDongLanAndZhongLiuAndFemale",dataMap.get(0).get("NumDongLanAndZhongLiuAndFemale"));
        jsonObject.put("NumDongLanAndZhongLiuAnd60To70M",dataMap.get(0).get("NumDongLanAndZhongLiuAnd60To70M"));
        jsonObject.put("NumDongLanAndZhongLiuAnd70To80M",dataMap.get(0).get("NumDongLanAndZhongLiuAnd70To80M"));
        jsonObject.put("NumDongLanAndZhongLiuAnd80To90M",dataMap.get(0).get("NumDongLanAndZhongLiuAnd80To90M"));
        jsonObject.put("NumDongLanAndZhongLiuAnd90AboveM",dataMap.get(0).get("NumDongLanAndZhongLiuAnd90AboveM"));
        jsonObject.put("NumDongLanAndZhongLiuAnd60To70F",dataMap.get(0).get("NumDongLanAndZhongLiuAnd60To70F"));
        jsonObject.put("NumDongLanAndZhongLiuAnd70To80F",dataMap.get(0).get("NumDongLanAndZhongLiuAnd70To80F"));
        jsonObject.put("NumDongLanAndZhongLiuAnd80To90F",dataMap.get(0).get("NumDongLanAndZhongLiuAnd80To90F"));
        jsonObject.put("NumDongLanAndZhongLiuAnd90AboveF",dataMap.get(0).get("NumDongLanAndZhongLiuAnd90AboveF"));

        jsonObject.put("NumDongLanAndGuZheAndHuJi",dataMap.get(0).get("NumDongLanAndGuZheAndHuJi"));
        jsonObject.put("NumDongLanAndGuZheAndFeiHuJi",dataMap.get(0).get("NumDongLanAndGuZheAndFeiHuJi"));
        jsonObject.put("NumDongLanAndGuZheAndMale",dataMap.get(0).get("NumDongLanAndGuZheAndMale"));
        jsonObject.put("NumDongLanAndGuZheAndFemale",dataMap.get(0).get("NumDongLanAndGuZheAndFemale"));
        jsonObject.put("NumDongLanAndGuZheAnd60To70M",dataMap.get(0).get("NumDongLanAndGuZheAnd60To70M"));
        jsonObject.put("NumDongLanAndGuZheAnd70To80M",dataMap.get(0).get("NumDongLanAndGuZheAnd70To80M"));
        jsonObject.put("NumDongLanAndGuZheAnd80To90M",dataMap.get(0).get("NumDongLanAndGuZheAnd80To90M"));
        jsonObject.put("NumDongLanAndGuZheAnd90AboveM",dataMap.get(0).get("NumDongLanAndGuZheAnd90AboveM"));
        jsonObject.put("NumDongLanAndGuZheAnd60To70F",dataMap.get(0).get("NumDongLanAndGuZheAnd60To70F"));
        jsonObject.put("NumDongLanAndGuZheAnd70To80F",dataMap.get(0).get("NumDongLanAndGuZheAnd70To80F"));
        jsonObject.put("NumDongLanAndGuZheAnd80To90F",dataMap.get(0).get("NumDongLanAndGuZheAnd80To90F"));
        jsonObject.put("NumDongLanAndGuZheAnd90AboveF",dataMap.get(0).get("NumDongLanAndGuZheAnd90AboveF"));

        jsonObject.put("NumDongLanAndShiZhiAndHuJi",dataMap.get(0).get("NumDongLanAndShiZhiAndHuJi"));
        jsonObject.put("NumDongLanAndShiZhiAndFeiHuJi",dataMap.get(0).get("NumDongLanAndShiZhiAndFeiHuJi"));
        jsonObject.put("NumDongLanAndShiZhiAndMale",dataMap.get(0).get("NumDongLanAndShiZhiAndMale"));
        jsonObject.put("NumDongLanAndShiZhiAndFemale",dataMap.get(0).get("NumDongLanAndShiZhiAndFemale"));
        jsonObject.put("NumDongLanAndShiZhiAnd60To70M",dataMap.get(0).get("NumDongLanAndShiZhiAnd60To70M"));
        jsonObject.put("NumDongLanAndShiZhiAnd70To80M",dataMap.get(0).get("NumDongLanAndShiZhiAnd70To80M"));
        jsonObject.put("NumDongLanAndShiZhiAnd80To90M",dataMap.get(0).get("NumDongLanAndShiZhiAnd80To90M"));
        jsonObject.put("NumDongLanAndShiZhiAnd90AboveM",dataMap.get(0).get("NumDongLanAndShiZhiAnd90AboveM"));
        jsonObject.put("NumDongLanAndShiZhiAnd60To70F",dataMap.get(0).get("NumDongLanAndShiZhiAnd60To70F"));
        jsonObject.put("NumDongLanAndShiZhiAnd70To80F",dataMap.get(0).get("NumDongLanAndShiZhiAnd70To80F"));
        jsonObject.put("NumDongLanAndShiZhiAnd80To90F",dataMap.get(0).get("NumDongLanAndShiZhiAnd80To90F"));
        jsonObject.put("NumDongLanAndShiZhiAnd90AboveF",dataMap.get(0).get("NumDongLanAndShiZhiAnd90AboveF"));

        jsonObject.put("NumDongLanAndChangHuAndHuJi",dataMap.get(0).get("NumDongLanAndChangHuAndHuJi"));
        jsonObject.put("NumDongLanAndChangHuAndFeiHuJi",dataMap.get(0).get("NumDongLanAndChangHuAndFeiHuJi"));
        jsonObject.put("NumDongLanAndChangHuAndMale",dataMap.get(0).get("NumDongLanAndChangHuAndMale"));
        jsonObject.put("NumDongLanAndChangHuAndFemale",dataMap.get(0).get("NumDongLanAndChangHuAndFemale"));
        jsonObject.put("NumDongLanAndChangHuAnd60To70M",dataMap.get(0).get("NumDongLanAndChangHuAnd60To70M"));
        jsonObject.put("NumDongLanAndChangHuAnd70To80M",dataMap.get(0).get("NumDongLanAndChangHuAnd70To80M"));
        jsonObject.put("NumDongLanAndChangHuAnd80To90M",dataMap.get(0).get("NumDongLanAndChangHuAnd80To90M"));
        jsonObject.put("NumDongLanAndChangHuAnd90AboveM",dataMap.get(0).get("NumDongLanAndChangHuAnd90AboveM"));
        jsonObject.put("NumDongLanAndChangHuAnd60To70F",dataMap.get(0).get("NumDongLanAndChangHuAnd60To70F"));
        jsonObject.put("NumDongLanAndChangHuAnd70To80F",dataMap.get(0).get("NumDongLanAndChangHuAnd70To80F"));
        jsonObject.put("NumDongLanAndChangHuAnd80To90F",dataMap.get(0).get("NumDongLanAndChangHuAnd80To90F"));
        jsonObject.put("NumDongLanAndChangHuAnd90AboveF",dataMap.get(0).get("NumDongLanAndChangHuAnd90AboveF"));

        jsonObject.put("NumDongLanAndQiTaAndHuJi",dataMap.get(0).get("NumDongLanAndQiTaAndHuJi"));
        jsonObject.put("NumDongLanAndQiTaAndFeiHuJi",dataMap.get(0).get("NumDongLanAndQiTaAndFeiHuJi"));
        jsonObject.put("NumDongLanAndQiTaAndMale",dataMap.get(0).get("NumDongLanAndQiTaAndMale"));
        jsonObject.put("NumDongLanAndQiTaAndFemale",dataMap.get(0).get("NumDongLanAndQiTaAndFemale"));
        jsonObject.put("NumDongLanAndQiTaAnd60To70M",dataMap.get(0).get("NumDongLanAndQiTaAnd60To70M"));
        jsonObject.put("NumDongLanAndQiTaAnd70To80M",dataMap.get(0).get("NumDongLanAndQiTaAnd70To80M"));
        jsonObject.put("NumDongLanAndQiTaAnd80To90M",dataMap.get(0).get("NumDongLanAndQiTaAnd80To90M"));
        jsonObject.put("NumDongLanAndQiTaAnd90AboveM",dataMap.get(0).get("NumDongLanAndQiTaAnd90AboveM"));
        jsonObject.put("NumDongLanAndQiTaAnd60To70F",dataMap.get(0).get("NumDongLanAndQiTaAnd60To70F"));
        jsonObject.put("NumDongLanAndQiTaAnd70To80F",dataMap.get(0).get("NumDongLanAndQiTaAnd70To80F"));
        jsonObject.put("NumDongLanAndQiTaAnd80To90F",dataMap.get(0).get("NumDongLanAndQiTaAnd80To90F"));
        jsonObject.put("NumDongLanAndQiTaAnd90AboveF",dataMap.get(0).get("NumDongLanAndQiTaAnd90AboveF"));

        //economy
        jsonObject.put("NumDongLanAndBangKunAndHuJi",dataMap.get(0).get("NumDongLanAndBangKunAndHuJi"));
        jsonObject.put("NumDongLanAndBangKunAndFeiHuJi",dataMap.get(0).get("NumDongLanAndBangKunAndFeiHuJi"));
        jsonObject.put("NumDongLanAndBangKunAndMale",dataMap.get(0).get("NumDongLanAndBangKunAndMale"));
        jsonObject.put("NumDongLanAndBangKunAndFemale",dataMap.get(0).get("NumDongLanAndBangKunAndFemale"));
        jsonObject.put("NumDongLanAndBangKunAnd60To70M",dataMap.get(0).get("NumDongLanAndBangKunAnd60To70M"));
        jsonObject.put("NumDongLanAndBangKunAnd70To80M",dataMap.get(0).get("NumDongLanAndBangKunAnd70To80M"));
        jsonObject.put("NumDongLanAndBangKunAnd80To90M",dataMap.get(0).get("NumDongLanAndBangKunAnd80To90M"));
        jsonObject.put("NumDongLanAndBangKunAnd90AboveM",dataMap.get(0).get("NumDongLanAndBangKunAnd90AboveM"));
        jsonObject.put("NumDongLanAndBangKunAnd60To70F",dataMap.get(0).get("NumDongLanAndBangKunAnd60To70F"));
        jsonObject.put("NumDongLanAndBangKunAnd70To80F",dataMap.get(0).get("NumDongLanAndBangKunAnd70To80F"));
        jsonObject.put("NumDongLanAndBangKunAnd80To90F",dataMap.get(0).get("NumDongLanAndBangKunAnd80To90F"));
        jsonObject.put("NumDongLanAndBangKunAnd90AboveF",dataMap.get(0).get("NumDongLanAndBangKunAnd90AboveF"));

        jsonObject.put("NumDongLanAndDiBaoAndHuJi",dataMap.get(0).get("NumDongLanAndDiBaoAndHuJi"));
        jsonObject.put("NumDongLanAndDiBaoAndFeiHuJi",dataMap.get(0).get("NumDongLanAndDiBaoAndFeiHuJi"));
        jsonObject.put("NumDongLanAndDiBaoAndMale",dataMap.get(0).get("NumDongLanAndDiBaoAndMale"));
        jsonObject.put("NumDongLanAndDiBaoAndFemale",dataMap.get(0).get("NumDongLanAndDiBaoAndFemale"));
        jsonObject.put("NumDongLanAndDiBaoAnd60To70M",dataMap.get(0).get("NumDongLanAndDiBaoAnd60To70M"));
        jsonObject.put("NumDongLanAndDiBaoAnd70To80M",dataMap.get(0).get("NumDongLanAndDiBaoAnd70To80M"));
        jsonObject.put("NumDongLanAndDiBaoAnd80To90M",dataMap.get(0).get("NumDongLanAndDiBaoAnd80To90M"));
        jsonObject.put("NumDongLanAndDiBaoAnd90AboveM",dataMap.get(0).get("NumDongLanAndDiBaoAnd90AboveM"));
        jsonObject.put("NumDongLanAndDiBaoAnd60To70F",dataMap.get(0).get("NumDongLanAndDiBaoAnd60To70F"));
        jsonObject.put("NumDongLanAndDiBaoAnd70To80F",dataMap.get(0).get("NumDongLanAndDiBaoAnd70To80F"));
        jsonObject.put("NumDongLanAndDiBaoAnd80To90F",dataMap.get(0).get("NumDongLanAndDiBaoAnd80To90F"));
        jsonObject.put("NumDongLanAndDiBaoAnd90AboveF",dataMap.get(0).get("NumDongLanAndDiBaoAnd90AboveF"));

        jsonObject.put("NumDongLanAndYangLaoAndHuJi",dataMap.get(0).get("NumDongLanAndYangLaoAndHuJi"));
        jsonObject.put("NumDongLanAndYangLaoLiuAndFeiHuJi",dataMap.get(0).get("NumDongLanAndYangLaoLiuAndFeiHuJi"));
        jsonObject.put("NumDongLanAndYangLaoAndMale",dataMap.get(0).get("NumDongLanAndYangLaoAndMale"));
        jsonObject.put("NumDongLanAndYangLaoAndFemale",dataMap.get(0).get("NumDongLanAndYangLaoAndFemale"));
        jsonObject.put("NumDongLanAndYangLaoAnd60To70M",dataMap.get(0).get("NumDongLanAndYangLaoAnd60To70M"));
        jsonObject.put("NumDongLanAndYangLaoAnd70To80M",dataMap.get(0).get("NumDongLanAndYangLaoAnd70To80M"));
        jsonObject.put("NumDongLanAndYangLaoAnd80To90M",dataMap.get(0).get("NumDongLanAndYangLaoAnd80To90M"));
        jsonObject.put("NumDongLanAndYangLaoAnd90AboveM",dataMap.get(0).get("NumDongLanAndYangLaoAnd90AboveM"));
        jsonObject.put("NumDongLanAndYangLaoAnd60To70F",dataMap.get(0).get("NumDongLanAndYangLaoAnd60To70F"));
        jsonObject.put("NumDongLanAndYangLaoAnd70To80F",dataMap.get(0).get("NumDongLanAndYangLaoAnd70To80F"));
        jsonObject.put("NumDongLanAndYangLaoAnd80To90F",dataMap.get(0).get("NumDongLanAndYangLaoAnd80To90F"));
        jsonObject.put("NumDongLanAndYangLaoAnd90AboveF",dataMap.get(0).get("NumDongLanAndYangLaoAnd90AboveF"));

        jsonObject.put("NumDongLanAndYiLiaoAndHuJi",dataMap.get(0).get("NumDongLanAndYiLiaoAndHuJi"));
        jsonObject.put("NumDongLanAndYiLiaoAndFeiHuJi",dataMap.get(0).get("NumDongLanAndYiLiaoAndFeiHuJi"));
        jsonObject.put("NumDongLanAndYiLiaoAndMale",dataMap.get(0).get("NumDongLanAndYiLiaoAndMale"));
        jsonObject.put("NumDongLanAndYiLiaoAndFemale",dataMap.get(0).get("NumDongLanAndYiLiaoAndFemale"));
        jsonObject.put("NumDongLanAndYiLiaoAnd60To70M",dataMap.get(0).get("NumDongLanAndYiLiaoAnd60To70M"));
        jsonObject.put("NumDongLanAndYiLiaoAnd70To80M",dataMap.get(0).get("NumDongLanAndYiLiaoAnd70To80M"));
        jsonObject.put("NumDongLanAndYiLiaoAnd80To90M",dataMap.get(0).get("NumDongLanAndYiLiaoAnd80To90M"));
        jsonObject.put("NumDongLanAndYiLiaoAnd90AboveM",dataMap.get(0).get("NumDongLanAndYiLiaoAnd90AboveM"));
        jsonObject.put("NumDongLanAndYiLiaoAnd60To70F",dataMap.get(0).get("NumDongLanAndYiLiaoAnd60To70F"));
        jsonObject.put("NumDongLanAndYiLiaoAnd70To80F",dataMap.get(0).get("NumDongLanAndYiLiaoAnd70To80F"));
        jsonObject.put("NumDongLanAndYiLiaoAnd80To90F",dataMap.get(0).get("NumDongLanAndYiLiaoAnd80To90F"));
        jsonObject.put("NumDongLanAndYiLiaoAnd90AboveF",dataMap.get(0).get("NumDongLanAndYiLiaoAnd90AboveF"));

        jsonObject.put("NumDongLanAndChenZhenAndHuJi",dataMap.get(0).get("NumDongLanAndChenZhenAndHuJi"));
        jsonObject.put("NumDongLanAndChenZhenAndFeiHuJi",dataMap.get(0).get("NumDongLanAndChenZhenAndFeiHuJi"));
        jsonObject.put("NumDongLanAndChenZhenAndMale",dataMap.get(0).get("NumDongLanAndChenZhenAndMale"));
        jsonObject.put("NumDongLanAndChenZhenAndFemale",dataMap.get(0).get("NumDongLanAndChenZhenAndFemale"));
        jsonObject.put("NumDongLanAndChenZhenAnd60To70M",dataMap.get(0).get("NumDongLanAndChenZhenAnd60To70M"));
        jsonObject.put("NumDongLanAndChenZhenAnd70To80M",dataMap.get(0).get("NumDongLanAndChenZhenAnd70To80M"));
        jsonObject.put("NumDongLanAndChenZhenAnd80To90M",dataMap.get(0).get("NumDongLanAndChenZhenAnd80To90M"));
        jsonObject.put("NumDongLanAndChenZhenAnd90AboveM",dataMap.get(0).get("NumDongLanAndChenZhenAnd90AboveM"));
        jsonObject.put("NumDongLanAndChenZhenAnd60To70F",dataMap.get(0).get("NumDongLanAndChenZhenAnd60To70F"));
        jsonObject.put("NumDongLanAndChenZhenAnd70To80F",dataMap.get(0).get("NumDongLanAndChenZhenAnd70To80F"));
        jsonObject.put("NumDongLanAndChenZhenAnd80To90F",dataMap.get(0).get("NumDongLanAndChenZhenAnd80To90F"));
        jsonObject.put("NumDongLanAndChenZhenAnd90AboveF",dataMap.get(0).get("NumDongLanAndChenZhenAnd90AboveF"));

//pingji
        //family
        jsonObject.put("NumPingJiAndChunLaoAndHuJi",dataMap.get(0).get("NumPingJiAndChunLaoAndHuJi"));
        jsonObject.put("NumPingJiAndChunLaoAndFeiHuJi",dataMap.get(0).get("NumPingJiAndChunLaoAndFeiHuJi"));
        jsonObject.put("NumPingJiAndChunLaoAndMale",dataMap.get(0).get("NumPingJiAndChunLaoAndMale"));
        jsonObject.put("NumPingJiAndChunLaoAndFemale",dataMap.get(0).get("NumPingJiAndChunLaoAndFemale"));
        jsonObject.put("NumPingJiAndChunLaoAnd60To70M",dataMap.get(0).get("NumPingJiAndChunLaoAnd60To70M"));
        jsonObject.put("NumPingJiAndChunLaoAnd70To80M",dataMap.get(0).get("NumPingJiAndChunLaoAnd70To80M"));
        jsonObject.put("NumPingJiAndChunLaoAnd80To90M",dataMap.get(0).get("NumPingJiAndChunLaoAnd80To90M"));
        jsonObject.put("NumPingJiAndChunLaoAnd90AboveM",dataMap.get(0).get("NumPingJiAndChunLaoAnd90AboveM"));
        jsonObject.put("NumPingJiAndChunLaoAnd60To70F",dataMap.get(0).get("NumPingJiAndChunLaoAnd60To70F"));
        jsonObject.put("NumPingJiAndChunLaoAnd70To80F",dataMap.get(0).get("NumPingJiAndChunLaoAnd70To80F"));
        jsonObject.put("NumPingJiAndChunLaoAnd80To90F",dataMap.get(0).get("NumPingJiAndChunLaoAnd80To90F"));
        jsonObject.put("NumPingJiAndChunLaoAnd90AboveF",dataMap.get(0).get("NumPingJiAndChunLaoAnd90AboveF"));


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


        jsonObject.put("NumPingJiAndShiDuAndHuJi",dataMap.get(0).get("NumPingJiAndShiDuAndHuJi"));
        jsonObject.put("NumPingJiAndShiDuAndFeiHuJi",dataMap.get(0).get("NumPingJiAndShiDuAndFeiHuJi"));
        jsonObject.put("NumPingJiAndShiDuAndMale",dataMap.get(0).get("NumPingJiAndShiDuAndMale"));
        jsonObject.put("NumPingJiAndShiDuAndFemale",dataMap.get(0).get("NumPingJiAndShiDuAndFemale"));
        jsonObject.put("NumPingJiAndShiDuAnd60To70M",dataMap.get(0).get("NumPingJiAndShiDuAnd60To70M"));
        jsonObject.put("NumPingJiAndShiDuAnd70To80M",dataMap.get(0).get("NumPingJiAndShiDuAnd70To80M"));
        jsonObject.put("NumPingJiAndShiDuAnd80To90M",dataMap.get(0).get("NumPingJiAndShiDuAnd80To90M"));
        jsonObject.put("NumPingJiAndShiDuAnd90AboveM",dataMap.get(0).get("NumPingJiAndShiDuAnd90AboveM"));
        jsonObject.put("NumPingJiAndShiDuAnd60To70F",dataMap.get(0).get("NumPingJiAndShiDuAnd60To70F"));
        jsonObject.put("NumPingJiAndShiDuAnd70To80F",dataMap.get(0).get("NumPingJiAndShiDuAnd70To80F"));
        jsonObject.put("NumPingJiAndShiDuAnd80To90F",dataMap.get(0).get("NumPingJiAndShiDuAnd80To90F"));
        jsonObject.put("NumPingJiAndShiDuAnd90AboveF",dataMap.get(0).get("NumPingJiAndShiDuAnd90AboveF"));

        jsonObject.put("NumPingJiAndYiLaoAndHuJi",dataMap.get(0).get("NumPingJiAndYiLaoAndHuJi"));
        jsonObject.put("NumPingJiAndYiLaoAndFeiHuJi",dataMap.get(0).get("NumPingJiAndYiLaoAndFeiHuJi"));
        jsonObject.put("NumPingJiAndYiLaoAndMale",dataMap.get(0).get("NumPingJiAndYiLaoAndMale"));
        jsonObject.put("NumPingJiAndYiLaoAndFemale",dataMap.get(0).get("NumPingJiAndYiLaoAndFemale"));
        jsonObject.put("NumPingJiAndYiLaoAnd60To70M",dataMap.get(0).get("NumPingJiAndYiLaoAnd60To70M"));
        jsonObject.put("NumPingJiAndYiLaoAnd70To80M",dataMap.get(0).get("NumPingJiAndYiLaoAnd70To80M"));
        jsonObject.put("NumPingJiAndYiLaoAnd80To90M",dataMap.get(0).get("NumPingJiAndYiLaoAnd80To90M"));
        jsonObject.put("NumPingJiAndYiLaoAnd90AboveM",dataMap.get(0).get("NumPingJiAndYiLaoAnd90AboveM"));
        jsonObject.put("NumPingJiAndYiLaoAnd60To70F",dataMap.get(0).get("NumPingJiAndYiLaoAnd60To70F"));
        jsonObject.put("NumPingJiAndYiLaoAnd70To80F",dataMap.get(0).get("NumPingJiAndYiLaoAnd70To80F"));
        jsonObject.put("NumPingJiAndYiLaoAnd80To90F",dataMap.get(0).get("NumPingJiAndYiLaoAnd80To90F"));
        jsonObject.put("NumPingJiAndYiLaoAnd90AboveF",dataMap.get(0).get("NumPingJiAndYiLaoAnd90AboveF"));

        jsonObject.put("NumPingJiAndGuLaoAndHuJi",dataMap.get(0).get("NumPingJiAndGuLaoAndHuJi"));
        jsonObject.put("NumPingJiAndGuLaoAndFeiHuJi",dataMap.get(0).get("NumPingJiAndGuLaoAndFeiHuJi"));
        jsonObject.put("NumPingJiAndGuLaoAndMale",dataMap.get(0).get("NumPingJiAndGuLaoAndMale"));
        jsonObject.put("NumPingJiAndGuLaoAndFemale",dataMap.get(0).get("NumPingJiAndGuLaoAndFemale"));
        jsonObject.put("NumPingJiAndGuLaoAnd60To70M",dataMap.get(0).get("NumPingJiAndGuLaoAnd60To70M"));
        jsonObject.put("NumPingJiAndGuLaoAnd70To80M",dataMap.get(0).get("NumPingJiAndGuLaoAnd70To80M"));
        jsonObject.put("NumPingJiAndGuLaoAnd80To90M",dataMap.get(0).get("NumPingJiAndGuLaoAnd80To90M"));
        jsonObject.put("NumPingJiAndGuLaoAnd90AboveM",dataMap.get(0).get("NumPingJiAndGuLaoAnd90AboveM"));
        jsonObject.put("NumPingJiAndGuLaoAnd60To70F",dataMap.get(0).get("NumPingJiAndGuLaoAnd60To70F"));
        jsonObject.put("NumPingJiAndGuLaoAnd70To80F",dataMap.get(0).get("NumPingJiAndGuLaoAnd70To80F"));
        jsonObject.put("NumPingJiAndGuLaoAnd80To90F",dataMap.get(0).get("NumPingJiAndGuLaoAnd80To90F"));
        jsonObject.put("NumPingJiAndGuLaoAnd90AboveF",dataMap.get(0).get("NumPingJiAndGuLaoAnd90AboveF"));

        jsonObject.put("NumPingJiAndSanZhiAndHuJi",dataMap.get(0).get("NumPingJiAndSanZhiAndHuJi"));
        jsonObject.put("NumPingJiAndSanZhiAndFeiHuJi",dataMap.get(0).get("NumPingJiAndSanZhiAndFeiHuJi"));
        jsonObject.put("NumPingJiAndSanZhiAndMale",dataMap.get(0).get("NumPingJiAndSanZhiAndMale"));
        jsonObject.put("NumPingJiAndSanZhiAndFemale",dataMap.get(0).get("NumPingJiAndSanZhiAndFemale"));
        jsonObject.put("NumPingJiAndSanZhiAnd60To70M",dataMap.get(0).get("NumPingJiAndSanZhiAnd60To70M"));
        jsonObject.put("NumPingJiAndSanZhiAnd70To80M",dataMap.get(0).get("NumPingJiAndSanZhiAnd70To80M"));
        jsonObject.put("NumPingJiAndSanZhiAnd80To90M",dataMap.get(0).get("NumPingJiAndSanZhiAnd80To90M"));
        jsonObject.put("NumPingJiAndSanZhiAnd90AboveM",dataMap.get(0).get("NumPingJiAndSanZhiAnd90AboveM"));
        jsonObject.put("NumPingJiAndSanZhiAnd60To70F",dataMap.get(0).get("NumPingJiAndSanZhiAnd60To70F"));
        jsonObject.put("NumPingJiAndSanZhiAnd70To80F",dataMap.get(0).get("NumPingJiAndSanZhiAnd70To80F"));
        jsonObject.put("NumPingJiAndSanZhiAnd80To90F",dataMap.get(0).get("NumPingJiAndSanZhiAnd80To90F"));
        jsonObject.put("NumPingJiAndSanZhiAnd90AboveF",dataMap.get(0).get("NumPingJiAndSanZhiAnd90AboveF"));

        jsonObject.put("NumPingJiAndQiTaAndHuJi",dataMap.get(0).get("NumPingJiAndQiTaAndHuJi"));
        jsonObject.put("NumPingJiAndQiTaAndFeiHuJi",dataMap.get(0).get("NumPingJiAndQiTaAndFeiHuJi"));
        jsonObject.put("NumPingJiAndQiTaAndMale",dataMap.get(0).get("NumPingJiAndQiTaAndMale"));
        jsonObject.put("NumPingJiAndQiTaAndFemale",dataMap.get(0).get("NumPingJiAndQiTaAndFemale"));
        jsonObject.put("NumPingJiAndQiTaAnd60To70M",dataMap.get(0).get("NumPingJiAndQiTaAnd60To70M"));
        jsonObject.put("NumPingJiAndQiTaAnd70To80M",dataMap.get(0).get("NumPingJiAndQiTaAnd70To80M"));
        jsonObject.put("NumPingJiAndQiTaAnd80To90M",dataMap.get(0).get("NumPingJiAndQiTaAnd80To90M"));
        jsonObject.put("NumPingJiAndQiTaAnd90AboveM",dataMap.get(0).get("NumPingJiAndQiTaAnd90AboveM"));
        jsonObject.put("NumPingJiAndQiTaAnd60To70F",dataMap.get(0).get("NumPingJiAndQiTaAnd60To70F"));
        jsonObject.put("NumPingJiAndQiTaAnd70To80F",dataMap.get(0).get("NumPingJiAndQiTaAnd70To80F"));
        jsonObject.put("NumPingJiAndQiTaAnd80To90F",dataMap.get(0).get("NumPingJiAndQiTaAnd80To90F"));
        jsonObject.put("NumPingJiAndQiTaAnd90AboveF",dataMap.get(0).get("NumPingJiAndQiTaAnd90AboveF"));

        //health
        jsonObject.put("NumPingJiAndShiNengAndHuJi",dataMap.get(0).get("NumPingJiAndShiNengAndHuJi"));
        jsonObject.put("NumPingJiAndShiNengAndFeiHuJi",dataMap.get(0).get("NumPingJiAndShiNengAndFeiHuJi"));
        jsonObject.put("NumPingJiAndShiNengAndMale",dataMap.get(0).get("NumPingJiAndShiNengAndMale"));
        jsonObject.put("NumPingJiAndShiNengAndFemale",dataMap.get(0).get("NumPingJiAndShiNengAndFemale"));
        jsonObject.put("NumPingJiAndShiNengAnd60To70M",dataMap.get(0).get("NumPingJiAndShiNengAnd60To70M"));
        jsonObject.put("NumPingJiAndShiNengAnd70To80M",dataMap.get(0).get("NumPingJiAndShiNengAnd70To80M"));
        jsonObject.put("NumPingJiAndShiNengAnd80To90M",dataMap.get(0).get("NumPingJiAndShiNengAnd80To90M"));
        jsonObject.put("NumPingJiAndShiNengAnd90AboveM",dataMap.get(0).get("NumPingJiAndShiNengAnd90AboveM"));
        jsonObject.put("NumPingJiAndShiNengAnd60To70F",dataMap.get(0).get("NumPingJiAndShiNengAnd60To70F"));
        jsonObject.put("NumPingJiAndShiNengAnd70To80F",dataMap.get(0).get("NumPingJiAndShiNengAnd70To80F"));
        jsonObject.put("NumPingJiAndShiNengAnd80To90F",dataMap.get(0).get("NumPingJiAndShiNengAnd80To90F"));
        jsonObject.put("NumPingJiAndShiNengAnd90AboveF",dataMap.get(0).get("NumPingJiAndShiNengAnd90AboveF"));

        jsonObject.put("NumPingJiAndManBingAndHuJi",dataMap.get(0).get("NumPingJiAndManBingAndHuJi"));
        jsonObject.put("NumPingJiAndManBingAndFeiHuJi",dataMap.get(0).get("NumPingJiAndManBingAndFeiHuJi"));
        jsonObject.put("NumPingJiAndManBingAndMale",dataMap.get(0).get("NumPingJiAndManBingAndMale"));
        jsonObject.put("NumPingJiAndManBingAndFemale",dataMap.get(0).get("NumPingJiAndManBingAndFemale"));
        jsonObject.put("NumPingJiAndManBingAnd60To70M",dataMap.get(0).get("NumPingJiAndManBingAnd60To70M"));
        jsonObject.put("NumPingJiAndManBingAnd70To80M",dataMap.get(0).get("NumPingJiAndManBingAnd70To80M"));
        jsonObject.put("NumPingJiAndManBingAnd80To90M",dataMap.get(0).get("NumPingJiAndManBingAnd80To90M"));
        jsonObject.put("NumPingJiAndManBingAnd90AboveM",dataMap.get(0).get("NumPingJiAndManBingAnd90AboveM"));
        jsonObject.put("NumPingJiAndManBingAnd60To70F",dataMap.get(0).get("NumPingJiAndManBingAnd60To70F"));
        jsonObject.put("NumPingJiAndManBingAnd70To80F",dataMap.get(0).get("NumPingJiAndManBingAnd70To80F"));
        jsonObject.put("NumPingJiAndManBingAnd80To90F",dataMap.get(0).get("NumPingJiAndManBingAnd80To90F"));
        jsonObject.put("NumPingJiAndManBingAnd90AboveF",dataMap.get(0).get("NumPingJiAndManBingAnd90AboveF"));

        jsonObject.put("NumPingJiAndZhongLiuAndHuJi",dataMap.get(0).get("NumPingJiAndZhongLiuAndHuJi"));
        jsonObject.put("NumPingJiAndZhongLiuAndFeiHuJi",dataMap.get(0).get("NumPingJiAndZhongLiuAndFeiHuJi"));
        jsonObject.put("NumPingJiAndZhongLiuAndMale",dataMap.get(0).get("NumPingJiAndZhongLiuAndMale"));
        jsonObject.put("NumPingJiAndZhongLiuAndFemale",dataMap.get(0).get("NumPingJiAndZhongLiuAndFemale"));
        jsonObject.put("NumPingJiAndZhongLiuAnd60To70M",dataMap.get(0).get("NumPingJiAndZhongLiuAnd60To70M"));
        jsonObject.put("NumPingJiAndZhongLiuAnd70To80M",dataMap.get(0).get("NumPingJiAndZhongLiuAnd70To80M"));
        jsonObject.put("NumPingJiAndZhongLiuAnd80To90M",dataMap.get(0).get("NumPingJiAndZhongLiuAnd80To90M"));
        jsonObject.put("NumPingJiAndZhongLiuAnd90AboveM",dataMap.get(0).get("NumPingJiAndZhongLiuAnd90AboveM"));
        jsonObject.put("NumPingJiAndZhongLiuAnd60To70F",dataMap.get(0).get("NumPingJiAndZhongLiuAnd60To70F"));
        jsonObject.put("NumPingJiAndZhongLiuAnd70To80F",dataMap.get(0).get("NumPingJiAndZhongLiuAnd70To80F"));
        jsonObject.put("NumPingJiAndZhongLiuAnd80To90F",dataMap.get(0).get("NumPingJiAndZhongLiuAnd80To90F"));
        jsonObject.put("NumPingJiAndZhongLiuAnd90AboveF",dataMap.get(0).get("NumPingJiAndZhongLiuAnd90AboveF"));

        jsonObject.put("NumPingJiAndGuZheAndHuJi",dataMap.get(0).get("NumPingJiAndGuZheAndHuJi"));
        jsonObject.put("NumPingJiAndGuZheAndFeiHuJi",dataMap.get(0).get("NumPingJiAndGuZheAndFeiHuJi"));
        jsonObject.put("NumPingJiAndGuZheAndMale",dataMap.get(0).get("NumPingJiAndGuZheAndMale"));
        jsonObject.put("NumPingJiAndGuZheAndFemale",dataMap.get(0).get("NumPingJiAndGuZheAndFemale"));
        jsonObject.put("NumPingJiAndGuZheAnd60To70M",dataMap.get(0).get("NumPingJiAndGuZheAnd60To70M"));
        jsonObject.put("NumPingJiAndGuZheAnd70To80M",dataMap.get(0).get("NumPingJiAndGuZheAnd70To80M"));
        jsonObject.put("NumPingJiAndGuZheAnd80To90M",dataMap.get(0).get("NumPingJiAndGuZheAnd80To90M"));
        jsonObject.put("NumPingJiAndGuZheAnd90AboveM",dataMap.get(0).get("NumPingJiAndGuZheAnd90AboveM"));
        jsonObject.put("NumPingJiAndGuZheAnd60To70F",dataMap.get(0).get("NumPingJiAndGuZheAnd60To70F"));
        jsonObject.put("NumPingJiAndGuZheAnd70To80F",dataMap.get(0).get("NumPingJiAndGuZheAnd70To80F"));
        jsonObject.put("NumPingJiAndGuZheAnd80To90F",dataMap.get(0).get("NumPingJiAndGuZheAnd80To90F"));
        jsonObject.put("NumPingJiAndGuZheAnd90AboveF",dataMap.get(0).get("NumPingJiAndGuZheAnd90AboveF"));

        jsonObject.put("NumPingJiAndShiZhiAndHuJi",dataMap.get(0).get("NumPingJiAndShiZhiAndHuJi"));
        jsonObject.put("NumPingJiAndShiZhiAndFeiHuJi",dataMap.get(0).get("NumPingJiAndShiZhiAndFeiHuJi"));
        jsonObject.put("NumPingJiAndShiZhiAndMale",dataMap.get(0).get("NumPingJiAndShiZhiAndMale"));
        jsonObject.put("NumPingJiAndShiZhiAndFemale",dataMap.get(0).get("NumPingJiAndShiZhiAndFemale"));
        jsonObject.put("NumPingJiAndShiZhiAnd60To70M",dataMap.get(0).get("NumPingJiAndShiZhiAnd60To70M"));
        jsonObject.put("NumPingJiAndShiZhiAnd70To80M",dataMap.get(0).get("NumPingJiAndShiZhiAnd70To80M"));
        jsonObject.put("NumPingJiAndShiZhiAnd80To90M",dataMap.get(0).get("NumPingJiAndShiZhiAnd80To90M"));
        jsonObject.put("NumPingJiAndShiZhiAnd90AboveM",dataMap.get(0).get("NumPingJiAndShiZhiAnd90AboveM"));
        jsonObject.put("NumPingJiAndShiZhiAnd60To70F",dataMap.get(0).get("NumPingJiAndShiZhiAnd60To70F"));
        jsonObject.put("NumPingJiAndShiZhiAnd70To80F",dataMap.get(0).get("NumPingJiAndShiZhiAnd70To80F"));
        jsonObject.put("NumPingJiAndShiZhiAnd80To90F",dataMap.get(0).get("NumPingJiAndShiZhiAnd80To90F"));
        jsonObject.put("NumPingJiAndShiZhiAnd90AboveF",dataMap.get(0).get("NumPingJiAndShiZhiAnd90AboveF"));

        jsonObject.put("NumPingJiAndChangHuAndHuJi",dataMap.get(0).get("NumPingJiAndChangHuAndHuJi"));
        jsonObject.put("NumPingJiAndChangHuAndFeiHuJi",dataMap.get(0).get("NumPingJiAndChangHuAndFeiHuJi"));
        jsonObject.put("NumPingJiAndChangHuAndMale",dataMap.get(0).get("NumPingJiAndChangHuAndMale"));
        jsonObject.put("NumPingJiAndChangHuAndFemale",dataMap.get(0).get("NumPingJiAndChangHuAndFemale"));
        jsonObject.put("NumPingJiAndChangHuAnd60To70M",dataMap.get(0).get("NumPingJiAndChangHuAnd60To70M"));
        jsonObject.put("NumPingJiAndChangHuAnd70To80M",dataMap.get(0).get("NumPingJiAndChangHuAnd70To80M"));
        jsonObject.put("NumPingJiAndChangHuAnd80To90M",dataMap.get(0).get("NumPingJiAndChangHuAnd80To90M"));
        jsonObject.put("NumPingJiAndChangHuAnd90AboveM",dataMap.get(0).get("NumPingJiAndChangHuAnd90AboveM"));
        jsonObject.put("NumPingJiAndChangHuAnd60To70F",dataMap.get(0).get("NumPingJiAndChangHuAnd60To70F"));
        jsonObject.put("NumPingJiAndChangHuAnd70To80F",dataMap.get(0).get("NumPingJiAndChangHuAnd70To80F"));
        jsonObject.put("NumPingJiAndChangHuAnd80To90F",dataMap.get(0).get("NumPingJiAndChangHuAnd80To90F"));
        jsonObject.put("NumPingJiAndChangHuAnd90AboveF",dataMap.get(0).get("NumPingJiAndChangHuAnd90AboveF"));

        jsonObject.put("NumPingJiAndQiTaAndHuJi",dataMap.get(0).get("NumPingJiAndQiTaAndHuJi"));
        jsonObject.put("NumPingJiAndQiTaAndFeiHuJi",dataMap.get(0).get("NumPingJiAndQiTaAndFeiHuJi"));
        jsonObject.put("NumPingJiAndQiTaAndMale",dataMap.get(0).get("NumPingJiAndQiTaAndMale"));
        jsonObject.put("NumPingJiAndQiTaAndFemale",dataMap.get(0).get("NumPingJiAndQiTaAndFemale"));
        jsonObject.put("NumPingJiAndQiTaAnd60To70M",dataMap.get(0).get("NumPingJiAndQiTaAnd60To70M"));
        jsonObject.put("NumPingJiAndQiTaAnd70To80M",dataMap.get(0).get("NumPingJiAndQiTaAnd70To80M"));
        jsonObject.put("NumPingJiAndQiTaAnd80To90M",dataMap.get(0).get("NumPingJiAndQiTaAnd80To90M"));
        jsonObject.put("NumPingJiAndQiTaAnd90AboveM",dataMap.get(0).get("NumPingJiAndQiTaAnd90AboveM"));
        jsonObject.put("NumPingJiAndQiTaAnd60To70F",dataMap.get(0).get("NumPingJiAndQiTaAnd60To70F"));
        jsonObject.put("NumPingJiAndQiTaAnd70To80F",dataMap.get(0).get("NumPingJiAndQiTaAnd70To80F"));
        jsonObject.put("NumPingJiAndQiTaAnd80To90F",dataMap.get(0).get("NumPingJiAndQiTaAnd80To90F"));
        jsonObject.put("NumPingJiAndQiTaAnd90AboveF",dataMap.get(0).get("NumPingJiAndQiTaAnd90AboveF"));

        //economy
        jsonObject.put("NumPingJiAndBangKunAndHuJi",dataMap.get(0).get("NumPingJiAndBangKunAndHuJi"));
        jsonObject.put("NumPingJiAndBangKunAndFeiHuJi",dataMap.get(0).get("NumPingJiAndBangKunAndFeiHuJi"));
        jsonObject.put("NumPingJiAndBangKunAndMale",dataMap.get(0).get("NumPingJiAndBangKunAndMale"));
        jsonObject.put("NumPingJiAndBangKunAndFemale",dataMap.get(0).get("NumPingJiAndBangKunAndFemale"));
        jsonObject.put("NumPingJiAndBangKunAnd60To70M",dataMap.get(0).get("NumPingJiAndBangKunAnd60To70M"));
        jsonObject.put("NumPingJiAndBangKunAnd70To80M",dataMap.get(0).get("NumPingJiAndBangKunAnd70To80M"));
        jsonObject.put("NumPingJiAndBangKunAnd80To90M",dataMap.get(0).get("NumPingJiAndBangKunAnd80To90M"));
        jsonObject.put("NumPingJiAndBangKunAnd90AboveM",dataMap.get(0).get("NumPingJiAndBangKunAnd90AboveM"));
        jsonObject.put("NumPingJiAndBangKunAnd60To70F",dataMap.get(0).get("NumPingJiAndBangKunAnd60To70F"));
        jsonObject.put("NumPingJiAndBangKunAnd70To80F",dataMap.get(0).get("NumPingJiAndBangKunAnd70To80F"));
        jsonObject.put("NumPingJiAndBangKunAnd80To90F",dataMap.get(0).get("NumPingJiAndBangKunAnd80To90F"));
        jsonObject.put("NumPingJiAndBangKunAnd90AboveF",dataMap.get(0).get("NumPingJiAndBangKunAnd90AboveF"));

        jsonObject.put("NumPingJiAndDiBaoAndHuJi",dataMap.get(0).get("NumPingJiAndDiBaoAndHuJi"));
        jsonObject.put("NumPingJiAndDiBaoAndFeiHuJi",dataMap.get(0).get("NumPingJiAndDiBaoAndFeiHuJi"));
        jsonObject.put("NumPingJiAndDiBaoAndMale",dataMap.get(0).get("NumPingJiAndDiBaoAndMale"));
        jsonObject.put("NumPingJiAndDiBaoAndFemale",dataMap.get(0).get("NumPingJiAndDiBaoAndFemale"));
        jsonObject.put("NumPingJiAndDiBaoAnd60To70M",dataMap.get(0).get("NumPingJiAndDiBaoAnd60To70M"));
        jsonObject.put("NumPingJiAndDiBaoAnd70To80M",dataMap.get(0).get("NumPingJiAndDiBaoAnd70To80M"));
        jsonObject.put("NumPingJiAndDiBaoAnd80To90M",dataMap.get(0).get("NumPingJiAndDiBaoAnd80To90M"));
        jsonObject.put("NumPingJiAndDiBaoAnd90AboveM",dataMap.get(0).get("NumPingJiAndDiBaoAnd90AboveM"));
        jsonObject.put("NumPingJiAndDiBaoAnd60To70F",dataMap.get(0).get("NumPingJiAndDiBaoAnd60To70F"));
        jsonObject.put("NumPingJiAndDiBaoAnd70To80F",dataMap.get(0).get("NumPingJiAndDiBaoAnd70To80F"));
        jsonObject.put("NumPingJiAndDiBaoAnd80To90F",dataMap.get(0).get("NumPingJiAndDiBaoAnd80To90F"));
        jsonObject.put("NumPingJiAndDiBaoAnd90AboveF",dataMap.get(0).get("NumPingJiAndDiBaoAnd90AboveF"));

        jsonObject.put("NumPingJiAndYangLaoAndHuJi",dataMap.get(0).get("NumPingJiAndYangLaoAndHuJi"));
        jsonObject.put("NumPingJiAndYangLaoLiuAndFeiHuJi",dataMap.get(0).get("NumPingJiAndYangLaoLiuAndFeiHuJi"));
        jsonObject.put("NumPingJiAndYangLaoAndMale",dataMap.get(0).get("NumPingJiAndYangLaoAndMale"));
        jsonObject.put("NumPingJiAndYangLaoAndFemale",dataMap.get(0).get("NumPingJiAndYangLaoAndFemale"));
        jsonObject.put("NumPingJiAndYangLaoAnd60To70M",dataMap.get(0).get("NumPingJiAndYangLaoAnd60To70M"));
        jsonObject.put("NumPingJiAndYangLaoAnd70To80M",dataMap.get(0).get("NumPingJiAndYangLaoAnd70To80M"));
        jsonObject.put("NumPingJiAndYangLaoAnd80To90M",dataMap.get(0).get("NumPingJiAndYangLaoAnd80To90M"));
        jsonObject.put("NumPingJiAndYangLaoAnd90AboveM",dataMap.get(0).get("NumPingJiAndYangLaoAnd90AboveM"));
        jsonObject.put("NumPingJiAndYangLaoAnd60To70F",dataMap.get(0).get("NumPingJiAndYangLaoAnd60To70F"));
        jsonObject.put("NumPingJiAndYangLaoAnd70To80F",dataMap.get(0).get("NumPingJiAndYangLaoAnd70To80F"));
        jsonObject.put("NumPingJiAndYangLaoAnd80To90F",dataMap.get(0).get("NumPingJiAndYangLaoAnd80To90F"));
        jsonObject.put("NumPingJiAndYangLaoAnd90AboveF",dataMap.get(0).get("NumPingJiAndYangLaoAnd90AboveF"));

        jsonObject.put("NumPingJiAndYiLiaoAndHuJi",dataMap.get(0).get("NumPingJiAndYiLiaoAndHuJi"));
        jsonObject.put("NumPingJiAndYiLiaoAndFeiHuJi",dataMap.get(0).get("NumPingJiAndYiLiaoAndFeiHuJi"));
        jsonObject.put("NumPingJiAndYiLiaoAndMale",dataMap.get(0).get("NumPingJiAndYiLiaoAndMale"));
        jsonObject.put("NumPingJiAndYiLiaoAndFemale",dataMap.get(0).get("NumPingJiAndYiLiaoAndFemale"));
        jsonObject.put("NumPingJiAndYiLiaoAnd60To70M",dataMap.get(0).get("NumPingJiAndYiLiaoAnd60To70M"));
        jsonObject.put("NumPingJiAndYiLiaoAnd70To80M",dataMap.get(0).get("NumPingJiAndYiLiaoAnd70To80M"));
        jsonObject.put("NumPingJiAndYiLiaoAnd80To90M",dataMap.get(0).get("NumPingJiAndYiLiaoAnd80To90M"));
        jsonObject.put("NumPingJiAndYiLiaoAnd90AboveM",dataMap.get(0).get("NumPingJiAndYiLiaoAnd90AboveM"));
        jsonObject.put("NumPingJiAndYiLiaoAnd60To70F",dataMap.get(0).get("NumPingJiAndYiLiaoAnd60To70F"));
        jsonObject.put("NumPingJiAndYiLiaoAnd70To80F",dataMap.get(0).get("NumPingJiAndYiLiaoAnd70To80F"));
        jsonObject.put("NumPingJiAndYiLiaoAnd80To90F",dataMap.get(0).get("NumPingJiAndYiLiaoAnd80To90F"));
        jsonObject.put("NumPingJiAndYiLiaoAnd90AboveF",dataMap.get(0).get("NumPingJiAndYiLiaoAnd90AboveF"));

        jsonObject.put("NumPingJiAndChenZhenAndHuJi",dataMap.get(0).get("NumPingJiAndChenZhenAndHuJi"));
        jsonObject.put("NumPingJiAndChenZhenAndFeiHuJi",dataMap.get(0).get("NumPingJiAndChenZhenAndFeiHuJi"));
        jsonObject.put("NumPingJiAndChenZhenAndMale",dataMap.get(0).get("NumPingJiAndChenZhenAndMale"));
        jsonObject.put("NumPingJiAndChenZhenAndFemale",dataMap.get(0).get("NumPingJiAndChenZhenAndFemale"));
        jsonObject.put("NumPingJiAndChenZhenAnd60To70M",dataMap.get(0).get("NumPingJiAndChenZhenAnd60To70M"));
        jsonObject.put("NumPingJiAndChenZhenAnd70To80M",dataMap.get(0).get("NumPingJiAndChenZhenAnd70To80M"));
        jsonObject.put("NumPingJiAndChenZhenAnd80To90M",dataMap.get(0).get("NumPingJiAndChenZhenAnd80To90M"));
        jsonObject.put("NumPingJiAndChenZhenAnd90AboveM",dataMap.get(0).get("NumPingJiAndChenZhenAnd90AboveM"));
        jsonObject.put("NumPingJiAndChenZhenAnd60To70F",dataMap.get(0).get("NumPingJiAndChenZhenAnd60To70F"));
        jsonObject.put("NumPingJiAndChenZhenAnd70To80F",dataMap.get(0).get("NumPingJiAndChenZhenAnd70To80F"));
        jsonObject.put("NumPingJiAndChenZhenAnd80To90F",dataMap.get(0).get("NumPingJiAndChenZhenAnd80To90F"));
        jsonObject.put("NumPingJiAndChenZhenAnd90AboveF",dataMap.get(0).get("NumPingJiAndChenZhenAnd90AboveF"));

//fenge2

        Result result =new Result(true,jsonObject);
        return result;

    }


}
