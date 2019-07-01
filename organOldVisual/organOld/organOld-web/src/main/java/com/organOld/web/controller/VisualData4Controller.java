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
import static com.organOld.web.controller.VisualDataController2.add_code;

/**
 * 可视化 数据
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/visual/data")
public class VisualData4Controller {
    @Autowired
    OldmanService oldmanService;
    @ResponseBody
    @RequestMapping(value = "/getVisualData4",method = RequestMethod.GET)
    public Result admin_getOldNum2(){
        List<Map<String,Long>> dataMap=oldmanService.getVisualData4(AgeTobirthday(60),AgeTobirthday(70),AgeTobirthday(80),AgeTobirthday(90),"2019-05");
        //String s=AgeTobirthday(80).toString();

        JSONObject jsonObject = new JSONObject();
        //part fenge

        //chx
        jsonObject.put("NumPingNanLeveled2",dataMap.get(0).get("NumPingNanLeveled2"));
        jsonObject.put("NumPingNanLeveled3",dataMap.get(0).get("NumPingNanLeveled3"));
        jsonObject.put("NumPingNanLeveled4",dataMap.get(0).get("NumPingNanLeveled4"));
        jsonObject.put("NumPingNanLeveled5",dataMap.get(0).get("NumPingNanLeveled5"));
        jsonObject.put("NumPingNanLeveled6",dataMap.get(0).get("NumPingNanLeveled6"));
        jsonObject.put("NumPingNanLeveled60To70",dataMap.get(0).get("NumPingNanLeveled60To70"));
        jsonObject.put("NumPingNanLeveled70To80",dataMap.get(0).get("NumPingNanLeveled70To80"));
        jsonObject.put("NumPingNanLeveled80To90",dataMap.get(0).get("NumPingNanLeveled80To90"));
        jsonObject.put("NumPingNanLeveled90Above",dataMap.get(0).get("NumPingNanLeveled90Above"));
        jsonObject.put("NumPingNanHuJi",dataMap.get(0).get("NumPingNanHuJi"));
        jsonObject.put("NumPingNanFeiHuJi",dataMap.get(0).get("NumPingNanFeiHuJi"));
        jsonObject.put("NumPingNanLeveledMale",dataMap.get(0).get("NumPingNanLeveledMale"));
        jsonObject.put("NumPingNanLeveledFemale",dataMap.get(0).get("NumPingNanLeveledFemale"));
        jsonObject.put("NumPingNanLeveledHuJi",dataMap.get(0).get("NumPingNanLeveledHuJi"));
        jsonObject.put("NumPingNanLeveledFeiHuJi",dataMap.get(0).get("NumPingNanLeveledFeiHuJi"));
        jsonObject.put("NumPingNanServedMale",dataMap.get(0).get("NumPingNanServedMale"));
        jsonObject.put("NumPingNanServedFemale",dataMap.get(0).get("NumPingNanServedFemale"));
        jsonObject.put("NumPingNanServedHuJi",dataMap.get(0).get("NumPingNanServedHuJi"));
        jsonObject.put("NumPingNanServedFeiHuJi",dataMap.get(0).get("NumPingNanServedFeiHuJi"));
        jsonObject.put("NumPingNanServedLeve2",dataMap.get(0).get("NumPingNanServedLeve2"));
        jsonObject.put("NumPingNanServedLeve3",dataMap.get(0).get("NumPingNanServedLeve3"));
        jsonObject.put("NumPingNanServedLeve4",dataMap.get(0).get("NumPingNanServedLeve4"));
        jsonObject.put("NumPingNanServedLeve5",dataMap.get(0).get("NumPingNanServedLeve5"));
        jsonObject.put("NumPingNanServedLeve6",dataMap.get(0).get("NumPingNanServedLeve6"));
        jsonObject.put("NumPingNanServed60To70",dataMap.get(0).get("NumPingNanServed60To70"));
        jsonObject.put("NumPingNanServed70To80",dataMap.get(0).get("NumPingNanServed70To80"));
        jsonObject.put("NumPingNanServed80To90",dataMap.get(0).get("NumPingNanServed80To90"));
        jsonObject.put("NumPingNanServed90Above",dataMap.get(0).get("NumPingNanServed90Above"));

        jsonObject.put("NumPingJiLeveled2",dataMap.get(0).get("NumPingJiLeveled2"));
        jsonObject.put("NumPingJiLeveled3",dataMap.get(0).get("NumPingJiLeveled3"));
        jsonObject.put("NumPingJiLeveled4",dataMap.get(0).get("NumPingJiLeveled4"));
        jsonObject.put("NumPingJiLeveled5",dataMap.get(0).get("NumPingJiLeveled5"));
        jsonObject.put("NumPingJiLeveled6",dataMap.get(0).get("NumPingJiLeveled6"));
        jsonObject.put("NumPingJiLeveled60To70",dataMap.get(0).get("NumPingJiLeveled60To70"));
        jsonObject.put("NumPingJiLeveled70To80",dataMap.get(0).get("NumPingJiLeveled70To80"));
        jsonObject.put("NumPingJiLeveled80To90",dataMap.get(0).get("NumPingJiLeveled80To90"));
        jsonObject.put("NumPingJiLeveled90Above",dataMap.get(0).get("NumPingJiLeveled90Above"));
        jsonObject.put("NumPingJiHuJi",dataMap.get(0).get("NumPingJiHuJi"));
        jsonObject.put("NumPingJiFeiHuJi",dataMap.get(0).get("NumPingJiFeiHuJi"));
        jsonObject.put("NumPingJiLeveledMale",dataMap.get(0).get("NumPingJiLeveledMale"));
        jsonObject.put("NumPingJiLeveledFemale",dataMap.get(0).get("NumPingJiLeveledFemale"));
        jsonObject.put("NumPingJiLeveledHuJi",dataMap.get(0).get("NumPingJiLeveledHuJi"));
        jsonObject.put("NumPingJiLeveledFeiHuJi",dataMap.get(0).get("NumPingJiLeveledFeiHuJi"));
        jsonObject.put("NumPingJiServedMale",dataMap.get(0).get("NumPingJiServedMale"));
        jsonObject.put("NumPingJiServedFemale",dataMap.get(0).get("NumPingJiServedFemale"));
        jsonObject.put("NumPingJiServedHuJi",dataMap.get(0).get("NumPingJiServedHuJi"));
        jsonObject.put("NumPingJiServedFeiHuJi",dataMap.get(0).get("NumPingJiServedFeiHuJi"));
        jsonObject.put("NumPingJiServedLeve2",dataMap.get(0).get("NumPingJiServedLeve2"));
        jsonObject.put("NumPingJiServedLeve3",dataMap.get(0).get("NumPingJiServedLeve3"));
        jsonObject.put("NumPingJiServedLeve4",dataMap.get(0).get("NumPingJiServedLeve4"));
        jsonObject.put("NumPingJiServedLeve5",dataMap.get(0).get("NumPingJiServedLeve5"));
        jsonObject.put("NumPingJiServedLeve6",dataMap.get(0).get("NumPingJiServedLeve6"));
        jsonObject.put("NumPingJiServed60To70",dataMap.get(0).get("NumPingJiServed60To70"));
        jsonObject.put("NumPingJiServed70To80",dataMap.get(0).get("NumPingJiServed70To80"));
        jsonObject.put("NumPingJiServed80To90",dataMap.get(0).get("NumPingJiServed80To90"));
        jsonObject.put("NumPingJiServed90Above",dataMap.get(0).get("NumPingJiServed90Above"));

        jsonObject.put("NumPingYangLeveled2",dataMap.get(0).get("NumPingYangLeveled2"));
        jsonObject.put("NumPingYangLeveled3",dataMap.get(0).get("NumPingYangLeveled3"));
        jsonObject.put("NumPingYangLeveled4",dataMap.get(0).get("NumPingYangLeveled4"));
        jsonObject.put("NumPingYangLeveled5",dataMap.get(0).get("NumPingYangLeveled5"));
        jsonObject.put("NumPingYangLeveled6",dataMap.get(0).get("NumPingYangLeveled6"));
        jsonObject.put("NumPingYangLeveled60To70",dataMap.get(0).get("NumPingYangLeveled60To70"));
        jsonObject.put("NumPingYangLeveled70To80",dataMap.get(0).get("NumPingYangLeveled70To80"));
        jsonObject.put("NumPingYangLeveled80To90",dataMap.get(0).get("NumPingYangLeveled80To90"));
        jsonObject.put("NumPingYangLeveled90Above",dataMap.get(0).get("NumPingYangLeveled90Above"));
        jsonObject.put("NumPingYangHuJi",dataMap.get(0).get("NumPingYangHuJi"));
        jsonObject.put("NumPingYangFeiHuJi",dataMap.get(0).get("NumPingYangFeiHuJi"));
        jsonObject.put("NumPingYangLeveledMale",dataMap.get(0).get("NumPingYangLeveledMale"));
        jsonObject.put("NumPingYangLeveledFemale",dataMap.get(0).get("NumPingYangLeveledFemale"));
        jsonObject.put("NumPingYangLeveledHuJi",dataMap.get(0).get("NumPingYangLeveledHuJi"));
        jsonObject.put("NumPingYangLeveledFeiHuJi",dataMap.get(0).get("NumPingYangLeveledFeiHuJi"));
        jsonObject.put("NumPingYangServedMale",dataMap.get(0).get("NumPingYangServedMale"));
        jsonObject.put("NumPingYangServedFemale",dataMap.get(0).get("NumPingYangServedFemale"));
        jsonObject.put("NumPingYangServedHuJi",dataMap.get(0).get("NumPingYangServedHuJi"));
        jsonObject.put("NumPingYangServedFeiHuJi",dataMap.get(0).get("NumPingYangServedFeiHuJi"));
        jsonObject.put("NumPingYangServedLeve2",dataMap.get(0).get("NumPingYangServedLeve2"));
        jsonObject.put("NumPingYangServedLeve3",dataMap.get(0).get("NumPingYangServedLeve3"));
        jsonObject.put("NumPingYangServedLeve4",dataMap.get(0).get("NumPingYangServedLeve4"));
        jsonObject.put("NumPingYangServedLeve5",dataMap.get(0).get("NumPingYangServedLeve5"));
        jsonObject.put("NumPingYangServedLeve6",dataMap.get(0).get("NumPingYangServedLeve6"));
        jsonObject.put("NumPingYangServed60To70",dataMap.get(0).get("NumPingYangServed60To70"));
        jsonObject.put("NumPingYangServed70To80",dataMap.get(0).get("NumPingYangServed70To80"));
        jsonObject.put("NumPingYangServed80To90",dataMap.get(0).get("NumPingYangServed80To90"));
        jsonObject.put("NumPingYangServed90Above",dataMap.get(0).get("NumPingYangServed90Above"));

        jsonObject.put("NumGuMeiLeveled2",dataMap.get(0).get("NumGuMeiLeveled2"));
        jsonObject.put("NumGuMeiLeveled3",dataMap.get(0).get("NumGuMeiLeveled3"));
        jsonObject.put("NumGuMeiLeveled4",dataMap.get(0).get("NumGuMeiLeveled4"));
        jsonObject.put("NumGuMeiLeveled5",dataMap.get(0).get("NumGuMeiLeveled5"));
        jsonObject.put("NumGuMeiLeveled6",dataMap.get(0).get("NumGuMeiLeveled6"));
        jsonObject.put("NumGuMeiLeveled60To70",dataMap.get(0).get("NumGuMeiLeveled60To70"));
        jsonObject.put("NumGuMeiLeveled70To80",dataMap.get(0).get("NumGuMeiLeveled70To80"));
        jsonObject.put("NumGuMeiLeveled80To90",dataMap.get(0).get("NumGuMeiLeveled80To90"));
        jsonObject.put("NumGuMeiLeveled90Above",dataMap.get(0).get("NumGuMeiLeveled90Above"));
        jsonObject.put("NumGuMeiHuJi",dataMap.get(0).get("NumGuMeiHuJi"));
        jsonObject.put("NumGuMeiFeiHuJi",dataMap.get(0).get("NumGuMeiFeiHuJi"));
        jsonObject.put("NumGuMeiLeveledMale",dataMap.get(0).get("NumGuMeiLeveledMale"));
        jsonObject.put("NumGuMeiLeveledFemale",dataMap.get(0).get("NumGuMeiLeveledFemale"));
        jsonObject.put("NumGuMeiLeveledHuJi",dataMap.get(0).get("NumGuMeiLeveledHuJi"));
        jsonObject.put("NumGuMeiLeveledFeiHuJi",dataMap.get(0).get("NumGuMeiLeveledFeiHuJi"));
        jsonObject.put("NumGuMeiServedMale",dataMap.get(0).get("NumGuMeiServedMale"));
        jsonObject.put("NumGuMeiServedFemale",dataMap.get(0).get("NumGuMeiServedFemale"));
        jsonObject.put("NumGuMeiServedHuJi",dataMap.get(0).get("NumGuMeiServedHuJi"));
        jsonObject.put("NumGuMeiServedFeiHuJi",dataMap.get(0).get("NumGuMeiServedFeiHuJi"));
        jsonObject.put("NumGuMeiServedLeve2",dataMap.get(0).get("NumGuMeiServedLeve2"));
        jsonObject.put("NumGuMeiServedLeve3",dataMap.get(0).get("NumGuMeiServedLeve3"));
        jsonObject.put("NumGuMeiServedLeve4",dataMap.get(0).get("NumGuMeiServedLeve4"));
        jsonObject.put("NumGuMeiServedLeve5",dataMap.get(0).get("NumGuMeiServedLeve5"));
        jsonObject.put("NumGuMeiServedLeve6",dataMap.get(0).get("NumGuMeiServedLeve6"));
        jsonObject.put("NumGuMeiServed60To70",dataMap.get(0).get("NumGuMeiServed60To70"));
        jsonObject.put("NumGuMeiServed70To80",dataMap.get(0).get("NumGuMeiServed70To80"));
        jsonObject.put("NumGuMeiServed80To90",dataMap.get(0).get("NumGuMeiServed80To90"));
        jsonObject.put("NumGuMeiServed90Above",dataMap.get(0).get("NumGuMeiServed90Above"));

        jsonObject.put("NumGuLongLeveled2",dataMap.get(0).get("NumGuLongLeveled2"));
        jsonObject.put("NumGuLongLeveled3",dataMap.get(0).get("NumGuLongLeveled3"));
        jsonObject.put("NumGuLongLeveled4",dataMap.get(0).get("NumGuLongLeveled4"));
        jsonObject.put("NumGuLongLeveled5",dataMap.get(0).get("NumGuLongLeveled5"));
        jsonObject.put("NumGuLongLeveled6",dataMap.get(0).get("NumGuLongLeveled6"));
        jsonObject.put("NumGuLongLeveled60To70",dataMap.get(0).get("NumGuLongLeveled60To70"));
        jsonObject.put("NumGuLongLeveled70To80",dataMap.get(0).get("NumGuLongLeveled70To80"));
        jsonObject.put("NumGuLongLeveled80To90",dataMap.get(0).get("NumGuLongLeveled80To90"));
        jsonObject.put("NumGuLongLeveled90Above",dataMap.get(0).get("NumGuLongLeveled90Above"));
        jsonObject.put("NumGuLongHuJi",dataMap.get(0).get("NumGuLongHuJi"));
        jsonObject.put("NumGuLongFeiHuJi",dataMap.get(0).get("NumGuLongFeiHuJi"));
        jsonObject.put("NumGuLongLeveledMale",dataMap.get(0).get("NumGuLongLeveledMale"));
        jsonObject.put("NumGuLongLeveledFemale",dataMap.get(0).get("NumGuLongLeveledFemale"));
        jsonObject.put("NumGuLongLeveledHuJi",dataMap.get(0).get("NumGuLongLeveledHuJi"));
        jsonObject.put("NumGuLongLeveledFeiHuJi",dataMap.get(0).get("NumGuLongLeveledFeiHuJi"));
        jsonObject.put("NumGuLongServedMale",dataMap.get(0).get("NumGuLongServedMale"));
        jsonObject.put("NumGuLongServedFemale",dataMap.get(0).get("NumGuLongServedFemale"));
        jsonObject.put("NumGuLongServedHuJi",dataMap.get(0).get("NumGuLongServedHuJi"));
        jsonObject.put("NumGuLongServedFeiHuJi",dataMap.get(0).get("NumGuLongServedFeiHuJi"));
        jsonObject.put("NumGuLongServedLeve2",dataMap.get(0).get("NumGuLongServedLeve2"));
        jsonObject.put("NumGuLongServedLeve3",dataMap.get(0).get("NumGuLongServedLeve3"));
        jsonObject.put("NumGuLongServedLeve4",dataMap.get(0).get("NumGuLongServedLeve4"));
        jsonObject.put("NumGuLongServedLeve5",dataMap.get(0).get("NumGuLongServedLeve5"));
        jsonObject.put("NumGuLongServedLeve6",dataMap.get(0).get("NumGuLongServedLeve6"));
        jsonObject.put("NumGuLongServed60To70",dataMap.get(0).get("NumGuLongServed60To70"));
        jsonObject.put("NumGuLongServed70To80",dataMap.get(0).get("NumGuLongServed70To80"));
        jsonObject.put("NumGuLongServed80To90",dataMap.get(0).get("NumGuLongServed80To90"));
        jsonObject.put("NumGuLongServed90Above",dataMap.get(0).get("NumGuLongServed90Above"));

        jsonObject.put("NumDongLanLeveled2",dataMap.get(0).get("NumDongLanLeveled2"));
        jsonObject.put("NumDongLanLeveled3",dataMap.get(0).get("NumDongLanLeveled3"));
        jsonObject.put("NumDongLanLeveled4",dataMap.get(0).get("NumDongLanLeveled4"));
        jsonObject.put("NumDongLanLeveled5",dataMap.get(0).get("NumDongLanLeveled5"));
        jsonObject.put("NumDongLanLeveled6",dataMap.get(0).get("NumDongLanLeveled6"));
        jsonObject.put("NumDongLanLeveled60To70",dataMap.get(0).get("NumDongLanLeveled60To70"));
        jsonObject.put("NumDongLanLeveled70To80",dataMap.get(0).get("NumDongLanLeveled70To80"));
        jsonObject.put("NumDongLanLeveled80To90",dataMap.get(0).get("NumDongLanLeveled80To90"));
        jsonObject.put("NumDongLanLeveled90Above",dataMap.get(0).get("NumDongLanLeveled90Above"));
        jsonObject.put("NumDongLanHuJi",dataMap.get(0).get("NumDongLanHuJi"));
        jsonObject.put("NumDongLanFeiHuJi",dataMap.get(0).get("NumDongLanFeiHuJi"));
        jsonObject.put("NumDongLanLeveledMale",dataMap.get(0).get("NumDongLanLeveledMale"));
        jsonObject.put("NumDongLanLeveledFemale",dataMap.get(0).get("NumDongLanLeveledFemale"));
        jsonObject.put("NumDongLanLeveledHuJi",dataMap.get(0).get("NumDongLanLeveledHuJi"));
        jsonObject.put("NumDongLanLeveledFeiHuJi",dataMap.get(0).get("NumDongLanLeveledFeiHuJi"));
        jsonObject.put("NumDongLanServedMale",dataMap.get(0).get("NumDongLanServedMale"));
        jsonObject.put("NumDongLanServedFemale",dataMap.get(0).get("NumDongLanServedFemale"));
        jsonObject.put("NumDongLanServedHuJi",dataMap.get(0).get("NumDongLanServedHuJi"));
        jsonObject.put("NumDongLanServedFeiHuJi",dataMap.get(0).get("NumDongLanServedFeiHuJi"));
        jsonObject.put("NumDongLanServedLeve2",dataMap.get(0).get("NumDongLanServedLeve2"));
        jsonObject.put("NumDongLanServedLeve3",dataMap.get(0).get("NumDongLanServedLeve3"));
        jsonObject.put("NumDongLanServedLeve4",dataMap.get(0).get("NumDongLanServedLeve4"));
        jsonObject.put("NumDongLanServedLeve5",dataMap.get(0).get("NumDongLanServedLeve5"));
        jsonObject.put("NumDongLanServedLeve6",dataMap.get(0).get("NumDongLanServedLeve6"));
        jsonObject.put("NumDongLanServed60To70",dataMap.get(0).get("NumDongLanServed60To70"));
        jsonObject.put("NumDongLanServed70To80",dataMap.get(0).get("NumDongLanServed70To80"));
        jsonObject.put("NumDongLanServed80To90",dataMap.get(0).get("NumDongLanServed80To90"));
        jsonObject.put("NumDongLanServed90Above",dataMap.get(0).get("NumDongLanServed90Above"));

        //org community family overall info

        jsonObject.put("NumGuMeiOrgGM",dataMap.get(0).get("NumGuMeiOrgGM"));
        jsonObject.put("NumGuMeiOrgDL",dataMap.get(0).get("NumGuMeiOrgDL"));
        jsonObject.put("NumGuMeiOrgPY",dataMap.get(0).get("NumGuMeiOrgPY"));
        jsonObject.put("NumGuMeiZZ",dataMap.get(0).get("NumGuMeiZZ"));
        jsonObject.put("NumGuMeiRZ",dataMap.get(0).get("NumGuMeiRZ"));
        jsonObject.put("NumGuMeiZC",dataMap.get(0).get("NumGuMeiZC"));
        jsonObject.put("NumGuMeiJTYL",dataMap.get(0).get("NumGuMeiJTYL"));
        jsonObject.put("NumGuMeiCHX",dataMap.get(0).get("NumGuMeiCHX"));
        jsonObject.put("NumGuMeiZNH",dataMap.get(0).get("NumGuMeiZNH"));
        jsonObject.put("NumGuMeiJTYS",dataMap.get(0).get("NumGuMeiJTYS"));
        jsonObject.put("NumGuMeiJTBC",dataMap.get(0).get("NumGuMeiJTBC"));

        jsonObject.put("NumGuLongOrgGM",dataMap.get(0).get("NumGuLongOrgGM"));
        jsonObject.put("NumGuLongOrgDL",dataMap.get(0).get("NumGuLongOrgDL"));
        jsonObject.put("NumGuLongOrgPY",dataMap.get(0).get("NumGuLongOrgPY"));
        jsonObject.put("NumGuLongZZ",dataMap.get(0).get("NumGuLongZZ"));
        jsonObject.put("NumGuLongRZ",dataMap.get(0).get("NumGuLongRZ"));
        jsonObject.put("NumGuLongZC",dataMap.get(0).get("NumGuLongZC"));
        jsonObject.put("NumGuLongJTYL",dataMap.get(0).get("NumGuLongJTYL"));
        jsonObject.put("NumGuLongCHX",dataMap.get(0).get("NumGuLongCHX"));
        jsonObject.put("NumGuLongZNH",dataMap.get(0).get("NumGuLongZNH"));
        jsonObject.put("NumGuLongJTYS",dataMap.get(0).get("NumGuLongJTYS"));
        jsonObject.put("NumGuLongJTBC",dataMap.get(0).get("NumGuLongJTBC"));

        jsonObject.put("NumPingNanOrgGM",dataMap.get(0).get("NumPingNanOrgGM"));
        jsonObject.put("NumPingNanOrgDL",dataMap.get(0).get("NumPingNanOrgDL"));
        jsonObject.put("NumPingNanOrgPY",dataMap.get(0).get("NumPingNanOrgPY"));
        jsonObject.put("NumPingNanZZ",dataMap.get(0).get("NumPingNanZZ"));
        jsonObject.put("NumPingNanRZ",dataMap.get(0).get("NumPingNanRZ"));
        jsonObject.put("NumPingNanZC",dataMap.get(0).get("NumPingNanZC"));
        jsonObject.put("NumPingNanJTYL",dataMap.get(0).get("NumPingNanJTYL"));
        jsonObject.put("NumPingNanCHX",dataMap.get(0).get("NumPingNanCHX"));
        jsonObject.put("NumPingNanZNH",dataMap.get(0).get("NumPingNanZNH"));
        jsonObject.put("NumPingNanJTYS",dataMap.get(0).get("NumPingNanJTYS"));
        jsonObject.put("NumPingNanJTBC",dataMap.get(0).get("NumPingNanJTBC"));

        jsonObject.put("NumPingYangOrgGM",dataMap.get(0).get("NumPingYangOrgGM"));
        jsonObject.put("NumPingYangOrgDL",dataMap.get(0).get("NumPingYangOrgDL"));
        jsonObject.put("NumPingYangOrgPY",dataMap.get(0).get("NumPingYangOrgPY"));
        jsonObject.put("NumPingYangZZ",dataMap.get(0).get("NumPingYangZZ"));
        jsonObject.put("NumPingYangRZ",dataMap.get(0).get("NumPingYangRZ"));
        jsonObject.put("NumPingYangZC",dataMap.get(0).get("NumPingYangZC"));
        jsonObject.put("NumPingYangJTYL",dataMap.get(0).get("NumPingYangJTYL"));
        jsonObject.put("NumPingYangCHX",dataMap.get(0).get("NumPingYangCHX"));
        jsonObject.put("NumPingYangZNH",dataMap.get(0).get("NumPingYangZNH"));
        jsonObject.put("NumPingYangJTYS",dataMap.get(0).get("NumPingYangJTYS"));
        jsonObject.put("NumPingYangJTBC",dataMap.get(0).get("NumPingYangJTBC"));

        jsonObject.put("NumPingJiOrgGM",dataMap.get(0).get("NumPingJiOrgGM"));
        jsonObject.put("NumPingJiOrgDL",dataMap.get(0).get("NumPingJiOrgDL"));
        jsonObject.put("NumPingJiOrgPY",dataMap.get(0).get("NumPingJiOrgPY"));
        jsonObject.put("NumPingJiZZ",dataMap.get(0).get("NumPingJiZZ"));
        jsonObject.put("NumPingJiRZ",dataMap.get(0).get("NumPingJiRZ"));
        jsonObject.put("NumPingJiZC",dataMap.get(0).get("NumPingJiZC"));
        jsonObject.put("NumPingJiJTYL",dataMap.get(0).get("NumPingJiJTYL"));
        jsonObject.put("NumPingJiCHX",dataMap.get(0).get("NumPingJiCHX"));
        jsonObject.put("NumPingJiZNH",dataMap.get(0).get("NumPingJiZNH"));
        jsonObject.put("NumPingJiJTYS",dataMap.get(0).get("NumPingJiJTYS"));
        jsonObject.put("NumPingJiJTBC",dataMap.get(0).get("NumPingJiJTBC"));

        jsonObject.put("NumDongLanOrgGM",dataMap.get(0).get("NumDongLanOrgGM"));
        jsonObject.put("NumDongLanOrgDL",dataMap.get(0).get("NumDongLanOrgDL"));
        jsonObject.put("NumDongLanOrgPY",dataMap.get(0).get("NumDongLanOrgPY"));
        jsonObject.put("NumDongLanZZ",dataMap.get(0).get("NumDongLanZZ"));
        jsonObject.put("NumDongLanRZ",dataMap.get(0).get("NumDongLanRZ"));
        jsonObject.put("NumDongLanZC",dataMap.get(0).get("NumDongLanZC"));
        jsonObject.put("NumDongLanJTYL",dataMap.get(0).get("NumDongLanJTYL"));
        jsonObject.put("NumDongLanCHX",dataMap.get(0).get("NumDongLanCHX"));
        jsonObject.put("NumDongLanZNH",dataMap.get(0).get("NumDongLanZNH"));
        jsonObject.put("NumDongLanJTYS",dataMap.get(0).get("NumDongLanJTYS"));
        jsonObject.put("NumDongLanJTBC",dataMap.get(0).get("NumDongLanJTBC"));

        jsonObject.put("NumAllLeveled2",dataMap.get(0).get("NumAllLeveled2"));
        jsonObject.put("NumAllLeveled3",dataMap.get(0).get("NumAllLeveled3"));
        jsonObject.put("NumAllLeveled4",dataMap.get(0).get("NumAllLeveled4"));
        jsonObject.put("NumAllLeveled5",dataMap.get(0).get("NumAllLeveled5"));
        jsonObject.put("NumAllLeveled6",dataMap.get(0).get("NumAllLeveled6"));
        jsonObject.put("NumAllLeveled60To70",dataMap.get(0).get("NumAllLeveled60To70"));
        jsonObject.put("NumAllLeveled70To80",dataMap.get(0).get("NumAllLeveled70To80"));
        jsonObject.put("NumAllLeveled80To90",dataMap.get(0).get("NumAllLeveled80To90"));
        jsonObject.put("NumAllLeveled90Above",dataMap.get(0).get("NumAllLeveled90Above"));
        jsonObject.put("NumAllHuJi",dataMap.get(0).get("NumAllHuJi"));
        jsonObject.put("NumAllFeiHuJi",dataMap.get(0).get("NumAllFeiHuJi"));
        jsonObject.put("NumAllLeveledMale",dataMap.get(0).get("NumAllLeveledMale"));
        jsonObject.put("NumAllLeveledFemale",dataMap.get(0).get("NumAllLeveledFemale"));
        jsonObject.put("NumAllLeveledHuJi",dataMap.get(0).get("NumAllLeveledHuJi"));
        jsonObject.put("NumAllLeveledFeiHuJi",dataMap.get(0).get("NumAllLeveledFeiHuJi"));
        jsonObject.put("NumAllServedMale",dataMap.get(0).get("NumAllServedMale"));
        jsonObject.put("NumAllServedFemale",dataMap.get(0).get("NumAllServedFemale"));
        jsonObject.put("NumAllServedHuJi",dataMap.get(0).get("NumAllServedHuJi"));
        jsonObject.put("NumAllServedFeiHuJi",dataMap.get(0).get("NumAllServedFeiHuJi"));
        jsonObject.put("NumAllServedLeve2",dataMap.get(0).get("NumAllServedLeve2"));
        jsonObject.put("NumAllServedLeve3",dataMap.get(0).get("NumAllServedLeve3"));
        jsonObject.put("NumAllServedLeve4",dataMap.get(0).get("NumAllServedLeve4"));
        jsonObject.put("NumAllServedLeve5",dataMap.get(0).get("NumAllServedLeve5"));
        jsonObject.put("NumAllServedLeve6",dataMap.get(0).get("NumAllServedLeve6"));

        jsonObject.put("NumAllServed60To70",dataMap.get(0).get("NumAllServed60To70"));
        jsonObject.put("NumAllServed70To80",dataMap.get(0).get("NumAllServed70To80"));
        jsonObject.put("NumAllServed80To90",dataMap.get(0).get("NumAllServed80To90"));
        jsonObject.put("NumAllServed90Above",dataMap.get(0).get("NumAllServed90Above"));

        //pq finish
        jsonObject.put("NumPingYangFinish",dataMap.get(0).get("NumPingYangFinish"));
        jsonObject.put("NumPingJiFinish",dataMap.get(0).get("NumPingJiFinish"));
        jsonObject.put("NumPingNanFinish",dataMap.get(0).get("NumPingNanFinish"));
        jsonObject.put("NumDongLanFinish",dataMap.get(0).get("NumDongLanFinish"));
        jsonObject.put("NumGuMeiFinish",dataMap.get(0).get("NumGuMeiFinish"));
        jsonObject.put("NumGuLongFinish",dataMap.get(0).get("NumGuLongFinish"));

        jsonObject.put("NumPingYang1Finish",dataMap.get(0).get("NumPingYang1Finish"));
        jsonObject.put("NumPingYang2Finish",dataMap.get(0).get("NumPingYang2Finish"));
        jsonObject.put("NumPingYang3Finish",dataMap.get(0).get("NumPingYang3Finish"));
        jsonObject.put("NumPingYang4Finish",dataMap.get(0).get("NumPingYang4Finish"));
        jsonObject.put("NumPingYang5Finish",dataMap.get(0).get("NumPingYang5Finish"));
        jsonObject.put("NumPingYang6Finish",dataMap.get(0).get("NumPingYang6Finish"));
        jsonObject.put("NumPingNan1Finish",dataMap.get(0).get("NumPingNan1Finish"));
        jsonObject.put("NumPingNan2Finish",dataMap.get(0).get("NumPingNan2Finish"));
        jsonObject.put("NumPingNan3Finish",dataMap.get(0).get("NumPingNan3Finish"));
        jsonObject.put("NumHuaYiFinish",dataMap.get(0).get("NumHuaYiFinish"));
        jsonObject.put("NumHuaMeiFinish",dataMap.get(0).get("NumHuaMeiFinish"));
        jsonObject.put("NumMeiLianFinish",dataMap.get(0).get("NumMeiLianFinish"));
        jsonObject.put("NumWanYuan1Finish",dataMap.get(0).get("NumWanYuan1Finish"));
        jsonObject.put("NumWanYuan2Finish",dataMap.get(0).get("NumWanYuan2Finish"));
        jsonObject.put("NumWanYuan3Finish",dataMap.get(0).get("NumWanYuan3Finish"));
        jsonObject.put("NumWanYuan4Finish",dataMap.get(0).get("NumWanYuan4Finish"));
        jsonObject.put("NumPingJi1Finish",dataMap.get(0).get("NumPingJi1Finish"));
        jsonObject.put("NumPingJi2Finish",dataMap.get(0).get("NumPingJi2Finish"));
        jsonObject.put("NumPingJi3Finish",dataMap.get(0).get("NumPingJi3Finish"));
        jsonObject.put("NumPingJi4Finish",dataMap.get(0).get("NumPingJi4Finish"));
        jsonObject.put("NumPingJi5Finish",dataMap.get(0).get("NumPingJi5Finish"));
        jsonObject.put("NumPingJi6Finish",dataMap.get(0).get("NumPingJi6Finish"));
        jsonObject.put("NumGuMei1Finish",dataMap.get(0).get("NumGuMei1Finish"));
        jsonObject.put("NumGuMei3Finish",dataMap.get(0).get("NumGuMei3Finish"));
        jsonObject.put("NumGuMei4Finish",dataMap.get(0).get("NumGuMei4Finish"));
        jsonObject.put("NumGuMei7Finish",dataMap.get(0).get("NumGuMei7Finish"));
        jsonObject.put("NumGuMei18Finish",dataMap.get(0).get("NumGuMei18Finish"));
        jsonObject.put("NumGuMei9Finish",dataMap.get(0).get("NumGuMei9Finish"));
        jsonObject.put("NumGuMei10Finish",dataMap.get(0).get("NumGuMei10Finish"));
        jsonObject.put("NumDongLan1Finish",dataMap.get(0).get("NumDongLan1Finish"));
        jsonObject.put("NumDongLan2Finish",dataMap.get(0).get("NumDongLan2Finish"));
        jsonObject.put("NumDongLan3Finish",dataMap.get(0).get("NumDongLan3Finish"));
        jsonObject.put("NumDongLan4Finish",dataMap.get(0).get("NumDongLan4Finish"));
        jsonObject.put("NumGuLong1Finish",dataMap.get(0).get("NumGuLong1Finish"));
        jsonObject.put("NumGuLong2Finish",dataMap.get(0).get("NumGuLong2Finish"));
        jsonObject.put("NumGuLong3Finish",dataMap.get(0).get("NumGuLong3Finish"));
        jsonObject.put("NumGuLong4Finish",dataMap.get(0).get("NumGuLong4Finish"));
        jsonObject.put("NumGuLong5Finish",dataMap.get(0).get("NumGuLong5Finish"));
        jsonObject.put("NumGuLong6Finish",dataMap.get(0).get("NumGuLong6Finish"));


        //finish_all
        jsonObject.put("NumPingYangFinishAll",dataMap.get(0).get("NumPingYangFinishAll"));
        jsonObject.put("NumPingJiFinishAll",dataMap.get(0).get("NumPingJiFinishAll"));
        jsonObject.put("NumPingNanFinishAll",dataMap.get(0).get("NumPingNanFinishAll"));
        jsonObject.put("NumDongLanFinishAll",dataMap.get(0).get("NumDongLanFinishAll"));
        jsonObject.put("NumGuMeiFinishAll",dataMap.get(0).get("NumGuMeiFinishAll"));
        jsonObject.put("NumGuLongFinishAll",dataMap.get(0).get("NumGuLongFinishAll"));

        jsonObject.put("NumPingYang1FinishAll",dataMap.get(0).get("NumPingYang1FinishAll"));
        jsonObject.put("NumPingYang2FinishAll",dataMap.get(0).get("NumPingYang2FinishAll"));
        jsonObject.put("NumPingYang3FinishAll",dataMap.get(0).get("NumPingYang3FinishAll"));
        jsonObject.put("NumPingYang4FinishAll",dataMap.get(0).get("NumPingYang4FinishAll"));
        jsonObject.put("NumPingYang5FinishAll",dataMap.get(0).get("NumPingYang5FinishAll"));
        jsonObject.put("NumPingYang6FinishAll",dataMap.get(0).get("NumPingYang6FinishAll"));
        jsonObject.put("NumPingNan1FinishAll",dataMap.get(0).get("NumPingNan1FinishAll"));
        jsonObject.put("NumPingNan2FinishAll",dataMap.get(0).get("NumPingNan2FinishAll"));
        jsonObject.put("NumPingNan3FinishAll",dataMap.get(0).get("NumPingNan3FinishAll"));
        jsonObject.put("NumHuaYiFinishAll",dataMap.get(0).get("NumHuaYiFinishAll"));
        jsonObject.put("NumHuaMeiFinishAll",dataMap.get(0).get("NumHuaMeiFinishAll"));
        jsonObject.put("NumMeiLianFinishAll",dataMap.get(0).get("NumMeiLianFinishAll"));
        jsonObject.put("NumWanYuan1FinishAll",dataMap.get(0).get("NumWanYuan1FinishAll"));
        jsonObject.put("NumWanYuan2FinishAll",dataMap.get(0).get("NumWanYuan2FinishAll"));
        jsonObject.put("NumWanYuan3FinishAll",dataMap.get(0).get("NumWanYuan3FinishAll"));
        jsonObject.put("NumWanYuan4FinishAll",dataMap.get(0).get("NumWanYuan4FinishAll"));
        jsonObject.put("NumPingJi1FinishAll",dataMap.get(0).get("NumPingJi1FinishAll"));
        jsonObject.put("NumPingJi2FinishAll",dataMap.get(0).get("NumPingJi2FinishAll"));
        jsonObject.put("NumPingJi3FinishAll",dataMap.get(0).get("NumPingJi3FinishAll"));
        jsonObject.put("NumPingJi4FinishAll",dataMap.get(0).get("NumPingJi4FinishAll"));
        jsonObject.put("NumPingJi5FinishAll",dataMap.get(0).get("NumPingJi5FinishAll"));
        jsonObject.put("NumPingJi6FinishAll",dataMap.get(0).get("NumPingJi6FinishAll"));
        jsonObject.put("NumGuMei1FinishAll",dataMap.get(0).get("NumGuMei1FinishAll"));
        jsonObject.put("NumGuMei3FinishAll",dataMap.get(0).get("NumGuMei3FinishAll"));
        jsonObject.put("NumGuMei4FinishAll",dataMap.get(0).get("NumGuMei4FinishAll"));
        jsonObject.put("NumGuMei7FinishAll",dataMap.get(0).get("NumGuMei7FinishAll"));
        jsonObject.put("NumGuMei18FinishAll",dataMap.get(0).get("NumGuMei18FinishAll"));
        jsonObject.put("NumGuMei9FinishAll",dataMap.get(0).get("NumGuMei9FinishAll"));
        jsonObject.put("NumGuMei10FinishAll",dataMap.get(0).get("NumGuMei10FinishAll"));
        jsonObject.put("NumDongLan1FinishAll",dataMap.get(0).get("NumDongLan1FinishAll"));
        jsonObject.put("NumDongLan2FinishAll",dataMap.get(0).get("NumDongLan2FinishAll"));
        jsonObject.put("NumDongLan3FinishAll",dataMap.get(0).get("NumDongLan3FinishAll"));
        jsonObject.put("NumDongLan4FinishAll",dataMap.get(0).get("NumDongLan4FinishAll"));
        jsonObject.put("NumGuLong1FinishAll",dataMap.get(0).get("NumGuLong1FinishAll"));
        jsonObject.put("NumGuLong2FinishAll",dataMap.get(0).get("NumGuLong2FinishAll"));
        jsonObject.put("NumGuLong3FinishAll",dataMap.get(0).get("NumGuLong3FinishAll"));
        jsonObject.put("NumGuLong4FinishAll",dataMap.get(0).get("NumGuLong4FinishAll"));
        jsonObject.put("NumGuLong5FinishAll",dataMap.get(0).get("NumGuLong5FinishAll"));
        jsonObject.put("NumGuLong6FinishAll",dataMap.get(0).get("NumGuLong6FinishAll"));

        //fuwuxiangmu
        jsonObject.put("NumZhuCan",dataMap.get(0).get("NumZhuCan"));
        jsonObject.put("NumZhuJie",dataMap.get(0).get("NumZhuJie"));
        jsonObject.put("NumZhuYu",dataMap.get(0).get("NumZhuYu"));
        jsonObject.put("NumZhuXing",dataMap.get(0).get("NumZhuXing"));
        jsonObject.put("NumZhuYi",dataMap.get(0).get("NumZhuYi"));
        jsonObject.put("NumXiYi",dataMap.get(0).get("NumXiYi"));
        jsonObject.put("NumKangFu",dataMap.get(0).get("NumKangFu"));
        jsonObject.put("NumXiangTan",dataMap.get(0).get("NumXiangTan"));
        jsonObject.put("NumShengHuo",dataMap.get(0).get("NumShengHuo"));
        jsonObject.put("NumQiTa",dataMap.get(0).get("NumQiTa"));

       // add_code(jsonObject,dataMap);
//        return jsonObject;

        //add
        //fuwuxiangmu  detail
        jsonObject.put("NumGuMeiZhuCanAndHuJi",dataMap.get(0).get("NumGuMeiZhuCanAndHuJi"));
        jsonObject.put("NumGuMeiZhuCanAndFeiHuJi",dataMap.get(0).get("NumGuMeiZhuCanAndFeiHuJi"));
        jsonObject.put("NumGuMeiZhuCanAndMale",dataMap.get(0).get("NumGuMeiZhuCanAndMale"));
        jsonObject.put("NumGuMeiZhuCanAndFemale",dataMap.get(0).get("NumGuMeiZhuCanAndFemale"));
        jsonObject.put("NumGuMeiZhuCanAnd60To70M",dataMap.get(0).get("NumGuMeiZhuCanAnd60To70M"));
        jsonObject.put("NumGuMeiZhuCanAnd70To80M",dataMap.get(0).get("NumGuMeiZhuCanAnd70To80M"));
        jsonObject.put("NumGuMeiZhuCanAnd80To90M",dataMap.get(0).get("NumGuMeiZhuCanAnd80To90M"));
        jsonObject.put("NumGuMeiZhuCanAnd90AboveM",dataMap.get(0).get("NumGuMeiZhuCanAnd90AboveM"));
        jsonObject.put("NumGuMeiZhuCanAnd60To70F",dataMap.get(0).get("NumGuMeiZhuCanAnd60To70F"));
        jsonObject.put("NumGuMeiZhuCanAnd70To80F",dataMap.get(0).get("NumGuMeiZhuCanAnd70To80F"));
        jsonObject.put("NumGuMeiZhuCanAnd80To90F",dataMap.get(0).get("NumGuMeiZhuCanAnd80To90F"));
        jsonObject.put("NumGuMeiZhuCanAnd90AboveF",dataMap.get(0).get("NumGuMeiZhuCanAnd90AboveF"));

        jsonObject.put("NumGuMeiZhuJieAndHuJi",dataMap.get(0).get("NumGuMeiZhuJieAndHuJi"));
        jsonObject.put("NumGuMeiZhuJieAndFeiHuJi",dataMap.get(0).get("NumGuMeiZhuJieAndFeiHuJi"));
        jsonObject.put("NumGuMeiZhuJieAndMale",dataMap.get(0).get("NumGuMeiZhuJieAndMale"));
        jsonObject.put("NumGuMeiZhuJieAndFemale",dataMap.get(0).get("NumGuMeiZhuJieAndFemale"));
        jsonObject.put("NumGuMeiZhuJieAnd60To70M",dataMap.get(0).get("NumGuMeiZhuJieAnd60To70M"));
        jsonObject.put("NumGuMeiZhuJieAnd70To80M",dataMap.get(0).get("NumGuMeiZhuJieAnd70To80M"));
        jsonObject.put("NumGuMeiZhuJieAnd80To90M",dataMap.get(0).get("NumGuMeiZhuJieAnd80To90M"));
        jsonObject.put("NumGuMeiZhuJieAnd90AboveM",dataMap.get(0).get("NumGuMeiZhuJieAnd90AboveM"));
        jsonObject.put("NumGuMeiZhuJieAnd60To70F",dataMap.get(0).get("NumGuMeiZhuJieAnd60To70F"));
        jsonObject.put("NumGuMeiZhuJieAnd70To80F",dataMap.get(0).get("NumGuMeiZhuJieAnd70To80F"));
        jsonObject.put("NumGuMeiZhuJieAnd80To90F",dataMap.get(0).get("NumGuMeiZhuJieAnd80To90F"));
        jsonObject.put("NumGuMeiZhuJieAnd90AboveF",dataMap.get(0).get("NumGuMeiZhuJieAnd90AboveF"));

        jsonObject.put("NumGuMeiZhuYuAndHuJi",dataMap.get(0).get("NumGuMeiZhuYuAndHuJi"));
        jsonObject.put("NumGuMeiZhuYuAndFeiHuJi",dataMap.get(0).get("NumGuMeiZhuYuAndFeiHuJi"));
        jsonObject.put("NumGuMeiZhuYuAndMale",dataMap.get(0).get("NumGuMeiZhuYuAndMale"));
        jsonObject.put("NumGuMeiZhuYuAndFemale",dataMap.get(0).get("NumGuMeiZhuYuAndFemale"));
        jsonObject.put("NumGuMeiZhuYuAnd60To70M",dataMap.get(0).get("NumGuMeiZhuYuAnd60To70M"));
        jsonObject.put("NumGuMeiZhuYuAnd70To80M",dataMap.get(0).get("NumGuMeiZhuYuAnd70To80M"));
        jsonObject.put("NumGuMeiZhuYuAnd80To90M",dataMap.get(0).get("NumGuMeiZhuYuAnd80To90M"));
        jsonObject.put("NumGuMeiZhuYuAnd90AboveM",dataMap.get(0).get("NumGuMeiZhuYuAnd90AboveM"));
        jsonObject.put("NumGuMeiZhuYuAnd60To70F",dataMap.get(0).get("NumGuMeiZhuYuAnd60To70F"));
        jsonObject.put("NumGuMeiZhuYuAnd70To80F",dataMap.get(0).get("NumGuMeiZhuYuAnd70To80F"));
        jsonObject.put("NumGuMeiZhuYuAnd80To90F",dataMap.get(0).get("NumGuMeiZhuYuAnd80To90F"));
        jsonObject.put("NumGuMeiZhuYuAnd90AboveF",dataMap.get(0).get("NumGuMeiZhuYuAnd90AboveF"));

        jsonObject.put("NumGuMeiZhuXingAndHuJi",dataMap.get(0).get("NumGuMeiZhuXingAndHuJi"));
        jsonObject.put("NumGuMeiZhuXingAndFeiHuJi",dataMap.get(0).get("NumGuMeiZhuXingAndFeiHuJi"));
        jsonObject.put("NumGuMeiZhuXingAndMale",dataMap.get(0).get("NumGuMeiZhuXingAndMale"));
        jsonObject.put("NumGuMeiZhuXingAndFemale",dataMap.get(0).get("NumGuMeiZhuXingAndFemale"));
        jsonObject.put("NumGuMeiZhuXingAnd60To70M",dataMap.get(0).get("NumGuMeiZhuXingAnd60To70M"));
        jsonObject.put("NumGuMeiZhuXingAnd70To80M",dataMap.get(0).get("NumGuMeiZhuXingAnd70To80M"));
        jsonObject.put("NumGuMeiZhuXingAnd80To90M",dataMap.get(0).get("NumGuMeiZhuXingAnd80To90M"));
        jsonObject.put("NumGuMeiZhuXingAnd90AboveM",dataMap.get(0).get("NumGuMeiZhuXingAnd90AboveM"));
        jsonObject.put("NumGuMeiZhuXingAnd60To70F",dataMap.get(0).get("NumGuMeiZhuXingAnd60To70F"));
        jsonObject.put("NumGuMeiZhuXingAnd70To80F",dataMap.get(0).get("NumGuMeiZhuXingAnd70To80F"));
        jsonObject.put("NumGuMeiZhuXingAnd80To90F",dataMap.get(0).get("NumGuMeiZhuXingAnd80To90F"));
        jsonObject.put("NumGuMeiZhuXingAnd90AboveF",dataMap.get(0).get("NumGuMeiZhuXingAnd90AboveF"));

        jsonObject.put("NumGuMeiZhuYiAndHuJi",dataMap.get(0).get("NumGuMeiZhuYiAndHuJi"));
        jsonObject.put("NumGuMeiZhuYiAndFeiHuJi",dataMap.get(0).get("NumGuMeiZhuYiAndFeiHuJi"));
        jsonObject.put("NumGuMeiZhuYiAndMale",dataMap.get(0).get("NumGuMeiZhuYiAndMale"));
        jsonObject.put("NumGuMeiZhuYiAndFemale",dataMap.get(0).get("NumGuMeiZhuYiAndFemale"));
        jsonObject.put("NumGuMeiZhuYiAnd60To70M",dataMap.get(0).get("NumGuMeiZhuYiAnd60To70M"));
        jsonObject.put("NumGuMeiZhuYiAnd70To80M",dataMap.get(0).get("NumGuMeiZhuYiAnd70To80M"));
        jsonObject.put("NumGuMeiZhuYiAnd80To90M",dataMap.get(0).get("NumGuMeiZhuYiAnd80To90M"));
        jsonObject.put("NumGuMeiZhuYiAnd90AboveM",dataMap.get(0).get("NumGuMeiZhuYiAnd90AboveM"));
        jsonObject.put("NumGuMeiZhuYiAnd60To70F",dataMap.get(0).get("NumGuMeiZhuYiAnd60To70F"));
        jsonObject.put("NumGuMeiZhuYiAnd70To80F",dataMap.get(0).get("NumGuMeiZhuYiAnd70To80F"));
        jsonObject.put("NumGuMeiZhuYiAnd80To90F",dataMap.get(0).get("NumGuMeiZhuYiAnd80To90F"));
        jsonObject.put("NumGuMeiZhuYiAnd90AboveF",dataMap.get(0).get("NumGuMeiZhuYiAnd90AboveF"));

        jsonObject.put("NumGuMeiXiYiAndHuJi",dataMap.get(0).get("NumGuMeiXiYiAndHuJi"));
        jsonObject.put("NumGuMeiXiYiAndFeiHuJi",dataMap.get(0).get("NumGuMeiXiYiAndFeiHuJi"));
        jsonObject.put("NumGuMeiXiYiAndMale",dataMap.get(0).get("NumGuMeiXiYiAndMale"));
        jsonObject.put("NumGuMeiXiYiAndFemale",dataMap.get(0).get("NumGuMeiXiYiAndFemale"));
        jsonObject.put("NumGuMeiXiYiAnd60To70M",dataMap.get(0).get("NumGuMeiXiYiAnd60To70M"));
        jsonObject.put("NumGuMeiXiYiAnd70To80M",dataMap.get(0).get("NumGuMeiXiYiAnd70To80M"));
        jsonObject.put("NumGuMeiXiYiAnd80To90M",dataMap.get(0).get("NumGuMeiXiYiAnd80To90M"));
        jsonObject.put("NumGuMeiXiYiAnd90AboveM",dataMap.get(0).get("NumGuMeiXiYiAnd90AboveM"));
        jsonObject.put("NumGuMeiXiYiAnd60To70F",dataMap.get(0).get("NumGuMeiXiYiAnd60To70F"));
        jsonObject.put("NumGuMeiXiYiAnd70To80F",dataMap.get(0).get("NumGuMeiXiYiAnd70To80F"));
        jsonObject.put("NumGuMeiXiYiAnd80To90F",dataMap.get(0).get("NumGuMeiXiYiAnd80To90F"));
        jsonObject.put("NumGuMeiXiYiAnd90AboveF",dataMap.get(0).get("NumGuMeiXiYiAnd90AboveF"));

        jsonObject.put("NumGuMeiXiangTanAndHuJi",dataMap.get(0).get("NumGuMeiXiangTanAndHuJi"));
        jsonObject.put("NumGuMeiXiangTanAndFeiHuJi",dataMap.get(0).get("NumGuMeiXiangTanAndFeiHuJi"));
        jsonObject.put("NumGuMeiXiangTanAndMale",dataMap.get(0).get("NumGuMeiXiangTanAndMale"));
        jsonObject.put("NumGuMeiXiangTanAndFemale",dataMap.get(0).get("NumGuMeiXiangTanAndFemale"));
        jsonObject.put("NumGuMeiXiangTanAnd60To70M",dataMap.get(0).get("NumGuMeiXiangTanAnd60To70M"));
        jsonObject.put("NumGuMeiXiangTanAnd70To80M",dataMap.get(0).get("NumGuMeiXiangTanAnd70To80M"));
        jsonObject.put("NumGuMeiXiangTanAnd80To90M",dataMap.get(0).get("NumGuMeiXiangTanAnd80To90M"));
        jsonObject.put("NumGuMeiXiangTanAnd90AboveM",dataMap.get(0).get("NumGuMeiXiangTanAnd90AboveM"));
        jsonObject.put("NumGuMeiXiangTanAnd60To70F",dataMap.get(0).get("NumGuMeiXiangTanAnd60To70F"));
        jsonObject.put("NumGuMeiXiangTanAnd70To80F",dataMap.get(0).get("NumGuMeiXiangTanAnd70To80F"));
        jsonObject.put("NumGuMeiXiangTanAnd80To90F",dataMap.get(0).get("NumGuMeiXiangTanAnd80To90F"));
        jsonObject.put("NumGuMeiXiangTanAnd90AboveF",dataMap.get(0).get("NumGuMeiXiangTanAnd90AboveF"));

        jsonObject.put("NumGuMeiKangFuAndHuJi",dataMap.get(0).get("NumGuMeiKangFuAndHuJi"));
        jsonObject.put("NumGuMeiKangFuAndFeiHuJi",dataMap.get(0).get("NumGuMeiKangFuAndFeiHuJi"));
        jsonObject.put("NumGuMeiKangFuAndMale",dataMap.get(0).get("NumGuMeiKangFuAndMale"));
        jsonObject.put("NumGuMeiKangFuAndFemale",dataMap.get(0).get("NumGuMeiKangFuAndFemale"));
        jsonObject.put("NumGuMeiKangFuAnd60To70M",dataMap.get(0).get("NumGuMeiKangFuAnd60To70M"));
        jsonObject.put("NumGuMeiKangFuAnd70To80M",dataMap.get(0).get("NumGuMeiKangFuAnd70To80M"));
        jsonObject.put("NumGuMeiKangFuAnd80To90M",dataMap.get(0).get("NumGuMeiKangFuAnd80To90M"));
        jsonObject.put("NumGuMeiKangFuAnd90AboveM",dataMap.get(0).get("NumGuMeiKangFuAnd90AboveM"));
        jsonObject.put("NumGuMeiKangFuAnd60To70F",dataMap.get(0).get("NumGuMeiKangFuAnd60To70F"));
        jsonObject.put("NumGuMeiKangFuAnd70To80F",dataMap.get(0).get("NumGuMeiKangFuAnd70To80F"));
        jsonObject.put("NumGuMeiKangFuAnd80To90F",dataMap.get(0).get("NumGuMeiKangFuAnd80To90F"));
        jsonObject.put("NumGuMeiKangFuAnd90AboveF",dataMap.get(0).get("NumGuMeiKangFuAnd90AboveF"));

        jsonObject.put("NumGuMeiShengHuoAndHuJi",dataMap.get(0).get("NumGuMeiShengHuoAndHuJi"));
        jsonObject.put("NumGuMeiShengHuoAndFeiHuJi",dataMap.get(0).get("NumGuMeiShengHuoAndFeiHuJi"));
        jsonObject.put("NumGuMeiShengHuoAndMale",dataMap.get(0).get("NumGuMeiShengHuoAndMale"));
        jsonObject.put("NumGuMeiShengHuoAndFemale",dataMap.get(0).get("NumGuMeiShengHuoAndFemale"));
        jsonObject.put("NumGuMeiShengHuoAnd60To70M",dataMap.get(0).get("NumGuMeiShengHuoAnd60To70M"));
        jsonObject.put("NumGuMeiShengHuoAnd70To80M",dataMap.get(0).get("NumGuMeiShengHuoAnd70To80M"));
        jsonObject.put("NumGuMeiShengHuoAnd80To90M",dataMap.get(0).get("NumGuMeiShengHuoAnd80To90M"));
        jsonObject.put("NumGuMeiShengHuoAnd90AboveM",dataMap.get(0).get("NumGuMeiShengHuoAnd90AboveM"));
        jsonObject.put("NumGuMeiShengHuoAnd60To70F",dataMap.get(0).get("NumGuMeiShengHuoAnd60To70F"));
        jsonObject.put("NumGuMeiShengHuoAnd70To80F",dataMap.get(0).get("NumGuMeiShengHuoAnd70To80F"));
        jsonObject.put("NumGuMeiShengHuoAnd80To90F",dataMap.get(0).get("NumGuMeiShengHuoAnd80To90F"));
        jsonObject.put("NumGuMeiShengHuoAnd90AboveF",dataMap.get(0).get("NumGuMeiShengHuoAnd90AboveF"));

        jsonObject.put("NumGuMeiFuWuQiTaAndHuJi",dataMap.get(0).get("NumGuMeiFuWuQiTaAndHuJi"));
        jsonObject.put("NumGuMeiFuWuQiTaAndFeiHuJi",dataMap.get(0).get("NumGuMeiFuWuQiTaAndFeiHuJi"));
        jsonObject.put("NumGuMeiFuWuQiTaAndMale",dataMap.get(0).get("NumGuMeiFuWuQiTaAndMale"));
        jsonObject.put("NumGuMeiFuWuQiTaAndFemale",dataMap.get(0).get("NumGuMeiFuWuQiTaAndFemale"));
        jsonObject.put("NumGuMeiFuWuQiTaAnd60To70M",dataMap.get(0).get("NumGuMeiFuWuQiTaAnd60To70M"));
        jsonObject.put("NumGuMeiFuWuQiTaAnd70To80M",dataMap.get(0).get("NumGuMeiFuWuQiTaAnd70To80M"));
        jsonObject.put("NumGuMeiFuWuQiTaAnd80To90M",dataMap.get(0).get("NumGuMeiFuWuQiTaAnd80To90M"));
        jsonObject.put("NumGuMeiFuWuQiTaAnd90AboveM",dataMap.get(0).get("NumGuMeiFuWuQiTaAnd90AboveM"));
        jsonObject.put("NumGuMeiFuWuQiTaAnd60To70F",dataMap.get(0).get("NumGuMeiFuWuQiTaAnd60To70F"));
        jsonObject.put("NumGuMeiFuWuQiTaAnd70To80F",dataMap.get(0).get("NumGuMeiFuWuQiTaAnd70To80F"));
        jsonObject.put("NumGuMeiFuWuQiTaAnd80To90F",dataMap.get(0).get("NumGuMeiFuWuQiTaAnd80To90F"));
        jsonObject.put("NumGuMeiFuWuQiTaAnd90AboveF",dataMap.get(0).get("NumGuMeiFuWuQiTaAnd90AboveF"));

        //gulong
        jsonObject.put("NumGuLongZhuCanAndHuJi",dataMap.get(0).get("NumGuLongZhuCanAndHuJi"));
        jsonObject.put("NumGuLongZhuCanAndFeiHuJi",dataMap.get(0).get("NumGuLongZhuCanAndFeiHuJi"));
        jsonObject.put("NumGuLongZhuCanAndMale",dataMap.get(0).get("NumGuLongZhuCanAndMale"));
        jsonObject.put("NumGuLongZhuCanAndFemale",dataMap.get(0).get("NumGuLongZhuCanAndFemale"));
        jsonObject.put("NumGuLongZhuCanAnd60To70M",dataMap.get(0).get("NumGuLongZhuCanAnd60To70M"));
        jsonObject.put("NumGuLongZhuCanAnd70To80M",dataMap.get(0).get("NumGuLongZhuCanAnd70To80M"));
        jsonObject.put("NumGuLongZhuCanAnd80To90M",dataMap.get(0).get("NumGuLongZhuCanAnd80To90M"));
        jsonObject.put("NumGuLongZhuCanAnd90AboveM",dataMap.get(0).get("NumGuLongZhuCanAnd90AboveM"));
        jsonObject.put("NumGuLongZhuCanAnd60To70F",dataMap.get(0).get("NumGuLongZhuCanAnd60To70F"));
        jsonObject.put("NumGuLongZhuCanAnd70To80F",dataMap.get(0).get("NumGuLongZhuCanAnd70To80F"));
        jsonObject.put("NumGuLongZhuCanAnd80To90F",dataMap.get(0).get("NumGuLongZhuCanAnd80To90F"));
        jsonObject.put("NumGuLongZhuCanAnd90AboveF",dataMap.get(0).get("NumGuLongZhuCanAnd90AboveF"));

        jsonObject.put("NumGuLongZhuJieAndHuJi",dataMap.get(0).get("NumGuLongZhuJieAndHuJi"));
        jsonObject.put("NumGuLongZhuJieAndFeiHuJi",dataMap.get(0).get("NumGuLongZhuJieAndFeiHuJi"));
        jsonObject.put("NumGuLongZhuJieAndMale",dataMap.get(0).get("NumGuLongZhuJieAndMale"));
        jsonObject.put("NumGuLongZhuJieAndFemale",dataMap.get(0).get("NumGuLongZhuJieAndFemale"));
        jsonObject.put("NumGuLongZhuJieAnd60To70M",dataMap.get(0).get("NumGuLongZhuJieAnd60To70M"));
        jsonObject.put("NumGuLongZhuJieAnd70To80M",dataMap.get(0).get("NumGuLongZhuJieAnd70To80M"));
        jsonObject.put("NumGuLongZhuJieAnd80To90M",dataMap.get(0).get("NumGuLongZhuJieAnd80To90M"));
        jsonObject.put("NumGuLongZhuJieAnd90AboveM",dataMap.get(0).get("NumGuLongZhuJieAnd90AboveM"));
        jsonObject.put("NumGuLongZhuJieAnd60To70F",dataMap.get(0).get("NumGuLongZhuJieAnd60To70F"));
        jsonObject.put("NumGuLongZhuJieAnd70To80F",dataMap.get(0).get("NumGuLongZhuJieAnd70To80F"));
        jsonObject.put("NumGuLongZhuJieAnd80To90F",dataMap.get(0).get("NumGuLongZhuJieAnd80To90F"));
        jsonObject.put("NumGuLongZhuJieAnd90AboveF",dataMap.get(0).get("NumGuLongZhuJieAnd90AboveF"));

        jsonObject.put("NumGuLongZhuYuAndHuJi",dataMap.get(0).get("NumGuLongZhuYuAndHuJi"));
        jsonObject.put("NumGuLongZhuYuAndFeiHuJi",dataMap.get(0).get("NumGuLongZhuYuAndFeiHuJi"));
        jsonObject.put("NumGuLongZhuYuAndMale",dataMap.get(0).get("NumGuLongZhuYuAndMale"));
        jsonObject.put("NumGuLongZhuYuAndFemale",dataMap.get(0).get("NumGuLongZhuYuAndFemale"));
        jsonObject.put("NumGuLongZhuYuAnd60To70M",dataMap.get(0).get("NumGuLongZhuYuAnd60To70M"));
        jsonObject.put("NumGuLongZhuYuAnd70To80M",dataMap.get(0).get("NumGuLongZhuYuAnd70To80M"));
        jsonObject.put("NumGuLongZhuYuAnd80To90M",dataMap.get(0).get("NumGuLongZhuYuAnd80To90M"));
        jsonObject.put("NumGuLongZhuYuAnd90AboveM",dataMap.get(0).get("NumGuLongZhuYuAnd90AboveM"));
        jsonObject.put("NumGuLongZhuYuAnd60To70F",dataMap.get(0).get("NumGuLongZhuYuAnd60To70F"));
        jsonObject.put("NumGuLongZhuYuAnd70To80F",dataMap.get(0).get("NumGuLongZhuYuAnd70To80F"));
        jsonObject.put("NumGuLongZhuYuAnd80To90F",dataMap.get(0).get("NumGuLongZhuYuAnd80To90F"));
        jsonObject.put("NumGuLongZhuYuAnd90AboveF",dataMap.get(0).get("NumGuLongZhuYuAnd90AboveF"));

        jsonObject.put("NumGuLongZhuXingAndHuJi",dataMap.get(0).get("NumGuLongZhuXingAndHuJi"));
        jsonObject.put("NumGuLongZhuXingAndFeiHuJi",dataMap.get(0).get("NumGuLongZhuXingAndFeiHuJi"));
        jsonObject.put("NumGuLongZhuXingAndMale",dataMap.get(0).get("NumGuLongZhuXingAndMale"));
        jsonObject.put("NumGuLongZhuXingAndFemale",dataMap.get(0).get("NumGuLongZhuXingAndFemale"));
        jsonObject.put("NumGuLongZhuXingAnd60To70M",dataMap.get(0).get("NumGuLongZhuXingAnd60To70M"));
        jsonObject.put("NumGuLongZhuXingAnd70To80M",dataMap.get(0).get("NumGuLongZhuXingAnd70To80M"));
        jsonObject.put("NumGuLongZhuXingAnd80To90M",dataMap.get(0).get("NumGuLongZhuXingAnd80To90M"));
        jsonObject.put("NumGuLongZhuXingAnd90AboveM",dataMap.get(0).get("NumGuLongZhuXingAnd90AboveM"));
        jsonObject.put("NumGuLongZhuXingAnd60To70F",dataMap.get(0).get("NumGuLongZhuXingAnd60To70F"));
        jsonObject.put("NumGuLongZhuXingAnd70To80F",dataMap.get(0).get("NumGuLongZhuXingAnd70To80F"));
        jsonObject.put("NumGuLongZhuXingAnd80To90F",dataMap.get(0).get("NumGuLongZhuXingAnd80To90F"));
        jsonObject.put("NumGuLongZhuXingAnd90AboveF",dataMap.get(0).get("NumGuLongZhuXingAnd90AboveF"));

        jsonObject.put("NumGuLongZhuYiAndHuJi",dataMap.get(0).get("NumGuLongZhuYiAndHuJi"));
        jsonObject.put("NumGuLongZhuYiAndFeiHuJi",dataMap.get(0).get("NumGuLongZhuYiAndFeiHuJi"));
        jsonObject.put("NumGuLongZhuYiAndMale",dataMap.get(0).get("NumGuLongZhuYiAndMale"));
        jsonObject.put("NumGuLongZhuYiAndFemale",dataMap.get(0).get("NumGuLongZhuYiAndFemale"));
        jsonObject.put("NumGuLongZhuYiAnd60To70M",dataMap.get(0).get("NumGuLongZhuYiAnd60To70M"));
        jsonObject.put("NumGuLongZhuYiAnd70To80M",dataMap.get(0).get("NumGuLongZhuYiAnd70To80M"));
        jsonObject.put("NumGuLongZhuYiAnd80To90M",dataMap.get(0).get("NumGuLongZhuYiAnd80To90M"));
        jsonObject.put("NumGuLongZhuYiAnd90AboveM",dataMap.get(0).get("NumGuLongZhuYiAnd90AboveM"));
        jsonObject.put("NumGuLongZhuYiAnd60To70F",dataMap.get(0).get("NumGuLongZhuYiAnd60To70F"));
        jsonObject.put("NumGuLongZhuYiAnd70To80F",dataMap.get(0).get("NumGuLongZhuYiAnd70To80F"));
        jsonObject.put("NumGuLongZhuYiAnd80To90F",dataMap.get(0).get("NumGuLongZhuYiAnd80To90F"));
        jsonObject.put("NumGuLongZhuYiAnd90AboveF",dataMap.get(0).get("NumGuLongZhuYiAnd90AboveF"));

        jsonObject.put("NumGuLongXiYiAndHuJi",dataMap.get(0).get("NumGuLongXiYiAndHuJi"));
        jsonObject.put("NumGuLongXiYiAndFeiHuJi",dataMap.get(0).get("NumGuLongXiYiAndFeiHuJi"));
        jsonObject.put("NumGuLongXiYiAndMale",dataMap.get(0).get("NumGuLongXiYiAndMale"));
        jsonObject.put("NumGuLongXiYiAndFemale",dataMap.get(0).get("NumGuLongXiYiAndFemale"));
        jsonObject.put("NumGuLongXiYiAnd60To70M",dataMap.get(0).get("NumGuLongXiYiAnd60To70M"));
        jsonObject.put("NumGuLongXiYiAnd70To80M",dataMap.get(0).get("NumGuLongXiYiAnd70To80M"));
        jsonObject.put("NumGuLongXiYiAnd80To90M",dataMap.get(0).get("NumGuLongXiYiAnd80To90M"));
        jsonObject.put("NumGuLongXiYiAnd90AboveM",dataMap.get(0).get("NumGuLongXiYiAnd90AboveM"));
        jsonObject.put("NumGuLongXiYiAnd60To70F",dataMap.get(0).get("NumGuLongXiYiAnd60To70F"));
        jsonObject.put("NumGuLongXiYiAnd70To80F",dataMap.get(0).get("NumGuLongXiYiAnd70To80F"));
        jsonObject.put("NumGuLongXiYiAnd80To90F",dataMap.get(0).get("NumGuLongXiYiAnd80To90F"));
        jsonObject.put("NumGuLongXiYiAnd90AboveF",dataMap.get(0).get("NumGuLongXiYiAnd90AboveF"));

        jsonObject.put("NumGuLongXiangTanAndHuJi",dataMap.get(0).get("NumGuLongXiangTanAndHuJi"));
        jsonObject.put("NumGuLongXiangTanAndFeiHuJi",dataMap.get(0).get("NumGuLongXiangTanAndFeiHuJi"));
        jsonObject.put("NumGuLongXiangTanAndMale",dataMap.get(0).get("NumGuLongXiangTanAndMale"));
        jsonObject.put("NumGuLongXiangTanAndFemale",dataMap.get(0).get("NumGuLongXiangTanAndFemale"));
        jsonObject.put("NumGuLongXiangTanAnd60To70M",dataMap.get(0).get("NumGuLongXiangTanAnd60To70M"));
        jsonObject.put("NumGuLongXiangTanAnd70To80M",dataMap.get(0).get("NumGuLongXiangTanAnd70To80M"));
        jsonObject.put("NumGuLongXiangTanAnd80To90M",dataMap.get(0).get("NumGuLongXiangTanAnd80To90M"));
        jsonObject.put("NumGuLongXiangTanAnd90AboveM",dataMap.get(0).get("NumGuLongXiangTanAnd90AboveM"));
        jsonObject.put("NumGuLongXiangTanAnd60To70F",dataMap.get(0).get("NumGuLongXiangTanAnd60To70F"));
        jsonObject.put("NumGuLongXiangTanAnd70To80F",dataMap.get(0).get("NumGuLongXiangTanAnd70To80F"));
        jsonObject.put("NumGuLongXiangTanAnd80To90F",dataMap.get(0).get("NumGuLongXiangTanAnd80To90F"));
        jsonObject.put("NumGuLongXiangTanAnd90AboveF",dataMap.get(0).get("NumGuLongXiangTanAnd90AboveF"));

        jsonObject.put("NumGuLongKangFuAndHuJi",dataMap.get(0).get("NumGuLongKangFuAndHuJi"));
        jsonObject.put("NumGuLongKangFuAndFeiHuJi",dataMap.get(0).get("NumGuLongKangFuAndFeiHuJi"));
        jsonObject.put("NumGuLongKangFuAndMale",dataMap.get(0).get("NumGuLongKangFuAndMale"));
        jsonObject.put("NumGuLongKangFuAndFemale",dataMap.get(0).get("NumGuLongKangFuAndFemale"));
        jsonObject.put("NumGuLongKangFuAnd60To70M",dataMap.get(0).get("NumGuLongKangFuAnd60To70M"));
        jsonObject.put("NumGuLongKangFuAnd70To80M",dataMap.get(0).get("NumGuLongKangFuAnd70To80M"));
        jsonObject.put("NumGuLongKangFuAnd80To90M",dataMap.get(0).get("NumGuLongKangFuAnd80To90M"));
        jsonObject.put("NumGuLongKangFuAnd90AboveM",dataMap.get(0).get("NumGuLongKangFuAnd90AboveM"));
        jsonObject.put("NumGuLongKangFuAnd60To70F",dataMap.get(0).get("NumGuLongKangFuAnd60To70F"));
        jsonObject.put("NumGuLongKangFuAnd70To80F",dataMap.get(0).get("NumGuLongKangFuAnd70To80F"));
        jsonObject.put("NumGuLongKangFuAnd80To90F",dataMap.get(0).get("NumGuLongKangFuAnd80To90F"));
        jsonObject.put("NumGuLongKangFuAnd90AboveF",dataMap.get(0).get("NumGuLongKangFuAnd90AboveF"));

        jsonObject.put("NumGuLongShengHuoAndHuJi",dataMap.get(0).get("NumGuLongShengHuoAndHuJi"));
        jsonObject.put("NumGuLongShengHuoAndFeiHuJi",dataMap.get(0).get("NumGuLongShengHuoAndFeiHuJi"));
        jsonObject.put("NumGuLongShengHuoAndMale",dataMap.get(0).get("NumGuLongShengHuoAndMale"));
        jsonObject.put("NumGuLongShengHuoAndFemale",dataMap.get(0).get("NumGuLongShengHuoAndFemale"));
        jsonObject.put("NumGuLongShengHuoAnd60To70M",dataMap.get(0).get("NumGuLongShengHuoAnd60To70M"));
        jsonObject.put("NumGuLongShengHuoAnd70To80M",dataMap.get(0).get("NumGuLongShengHuoAnd70To80M"));
        jsonObject.put("NumGuLongShengHuoAnd80To90M",dataMap.get(0).get("NumGuLongShengHuoAnd80To90M"));
        jsonObject.put("NumGuLongShengHuoAnd90AboveM",dataMap.get(0).get("NumGuLongShengHuoAnd90AboveM"));
        jsonObject.put("NumGuLongShengHuoAnd60To70F",dataMap.get(0).get("NumGuLongShengHuoAnd60To70F"));
        jsonObject.put("NumGuLongShengHuoAnd70To80F",dataMap.get(0).get("NumGuLongShengHuoAnd70To80F"));
        jsonObject.put("NumGuLongShengHuoAnd80To90F",dataMap.get(0).get("NumGuLongShengHuoAnd80To90F"));
        jsonObject.put("NumGuLongShengHuoAnd90AboveF",dataMap.get(0).get("NumGuLongShengHuoAnd90AboveF"));

        jsonObject.put("NumGuLongFuWuQiTaAndHuJi",dataMap.get(0).get("NumGuLongFuWuQiTaAndHuJi"));
        jsonObject.put("NumGuLongFuWuQiTaAndFeiHuJi",dataMap.get(0).get("NumGuLongFuWuQiTaAndFeiHuJi"));
        jsonObject.put("NumGuLongFuWuQiTaAndMale",dataMap.get(0).get("NumGuLongFuWuQiTaAndMale"));
        jsonObject.put("NumGuLongFuWuQiTaAndFemale",dataMap.get(0).get("NumGuLongFuWuQiTaAndFemale"));
        jsonObject.put("NumGuLongFuWuQiTaAnd60To70M",dataMap.get(0).get("NumGuLongFuWuQiTaAnd60To70M"));
        jsonObject.put("NumGuLongFuWuQiTaAnd70To80M",dataMap.get(0).get("NumGuLongFuWuQiTaAnd70To80M"));
        jsonObject.put("NumGuLongFuWuQiTaAnd80To90M",dataMap.get(0).get("NumGuLongFuWuQiTaAnd80To90M"));
        jsonObject.put("NumGuLongFuWuQiTaAnd90AboveM",dataMap.get(0).get("NumGuLongFuWuQiTaAnd90AboveM"));
        jsonObject.put("NumGuLongFuWuQiTaAnd60To70F",dataMap.get(0).get("NumGuLongFuWuQiTaAnd60To70F"));
        jsonObject.put("NumGuLongFuWuQiTaAnd70To80F",dataMap.get(0).get("NumGuLongFuWuQiTaAnd70To80F"));
        jsonObject.put("NumGuLongFuWuQiTaAnd80To90F",dataMap.get(0).get("NumGuLongFuWuQiTaAnd80To90F"));
        jsonObject.put("NumGuLongFuWuQiTaAnd90AboveF",dataMap.get(0).get("NumGuLongFuWuQiTaAnd90AboveF"));

        //donglan
        jsonObject.put("NumDongLanZhuCanAndHuJi",dataMap.get(0).get("NumDongLanZhuCanAndHuJi"));
        jsonObject.put("NumDongLanZhuCanAndFeiHuJi",dataMap.get(0).get("NumDongLanZhuCanAndFeiHuJi"));
        jsonObject.put("NumDongLanZhuCanAndMale",dataMap.get(0).get("NumDongLanZhuCanAndMale"));
        jsonObject.put("NumDongLanZhuCanAndFemale",dataMap.get(0).get("NumDongLanZhuCanAndFemale"));
        jsonObject.put("NumDongLanZhuCanAnd60To70M",dataMap.get(0).get("NumDongLanZhuCanAnd60To70M"));
        jsonObject.put("NumDongLanZhuCanAnd70To80M",dataMap.get(0).get("NumDongLanZhuCanAnd70To80M"));
        jsonObject.put("NumDongLanZhuCanAnd80To90M",dataMap.get(0).get("NumDongLanZhuCanAnd80To90M"));
        jsonObject.put("NumDongLanZhuCanAnd90AboveM",dataMap.get(0).get("NumDongLanZhuCanAnd90AboveM"));
        jsonObject.put("NumDongLanZhuCanAnd60To70F",dataMap.get(0).get("NumDongLanZhuCanAnd60To70F"));
        jsonObject.put("NumDongLanZhuCanAnd70To80F",dataMap.get(0).get("NumDongLanZhuCanAnd70To80F"));
        jsonObject.put("NumDongLanZhuCanAnd80To90F",dataMap.get(0).get("NumDongLanZhuCanAnd80To90F"));
        jsonObject.put("NumDongLanZhuCanAnd90AboveF",dataMap.get(0).get("NumDongLanZhuCanAnd90AboveF"));

        jsonObject.put("NumDongLanZhuJieAndHuJi",dataMap.get(0).get("NumDongLanZhuJieAndHuJi"));
        jsonObject.put("NumDongLanZhuJieAndFeiHuJi",dataMap.get(0).get("NumDongLanZhuJieAndFeiHuJi"));
        jsonObject.put("NumDongLanZhuJieAndMale",dataMap.get(0).get("NumDongLanZhuJieAndMale"));
        jsonObject.put("NumDongLanZhuJieAndFemale",dataMap.get(0).get("NumDongLanZhuJieAndFemale"));
        jsonObject.put("NumDongLanZhuJieAnd60To70M",dataMap.get(0).get("NumDongLanZhuJieAnd60To70M"));
        jsonObject.put("NumDongLanZhuJieAnd70To80M",dataMap.get(0).get("NumDongLanZhuJieAnd70To80M"));
        jsonObject.put("NumDongLanZhuJieAnd80To90M",dataMap.get(0).get("NumDongLanZhuJieAnd80To90M"));
        jsonObject.put("NumDongLanZhuJieAnd90AboveM",dataMap.get(0).get("NumDongLanZhuJieAnd90AboveM"));
        jsonObject.put("NumDongLanZhuJieAnd60To70F",dataMap.get(0).get("NumDongLanZhuJieAnd60To70F"));
        jsonObject.put("NumDongLanZhuJieAnd70To80F",dataMap.get(0).get("NumDongLanZhuJieAnd70To80F"));
        jsonObject.put("NumDongLanZhuJieAnd80To90F",dataMap.get(0).get("NumDongLanZhuJieAnd80To90F"));
        jsonObject.put("NumDongLanZhuJieAnd90AboveF",dataMap.get(0).get("NumDongLanZhuJieAnd90AboveF"));

        jsonObject.put("NumDongLanZhuYuAndHuJi",dataMap.get(0).get("NumDongLanZhuYuAndHuJi"));
        jsonObject.put("NumDongLanZhuYuAndFeiHuJi",dataMap.get(0).get("NumDongLanZhuYuAndFeiHuJi"));
        jsonObject.put("NumDongLanZhuYuAndMale",dataMap.get(0).get("NumDongLanZhuYuAndMale"));
        jsonObject.put("NumDongLanZhuYuAndFemale",dataMap.get(0).get("NumDongLanZhuYuAndFemale"));
        jsonObject.put("NumDongLanZhuYuAnd60To70M",dataMap.get(0).get("NumDongLanZhuYuAnd60To70M"));
        jsonObject.put("NumDongLanZhuYuAnd70To80M",dataMap.get(0).get("NumDongLanZhuYuAnd70To80M"));
        jsonObject.put("NumDongLanZhuYuAnd80To90M",dataMap.get(0).get("NumDongLanZhuYuAnd80To90M"));
        jsonObject.put("NumDongLanZhuYuAnd90AboveM",dataMap.get(0).get("NumDongLanZhuYuAnd90AboveM"));
        jsonObject.put("NumDongLanZhuYuAnd60To70F",dataMap.get(0).get("NumDongLanZhuYuAnd60To70F"));
        jsonObject.put("NumDongLanZhuYuAnd70To80F",dataMap.get(0).get("NumDongLanZhuYuAnd70To80F"));
        jsonObject.put("NumDongLanZhuYuAnd80To90F",dataMap.get(0).get("NumDongLanZhuYuAnd80To90F"));
        jsonObject.put("NumDongLanZhuYuAnd90AboveF",dataMap.get(0).get("NumDongLanZhuYuAnd90AboveF"));

        jsonObject.put("NumDongLanZhuXingAndHuJi",dataMap.get(0).get("NumDongLanZhuXingAndHuJi"));
        jsonObject.put("NumDongLanZhuXingAndFeiHuJi",dataMap.get(0).get("NumDongLanZhuXingAndFeiHuJi"));
        jsonObject.put("NumDongLanZhuXingAndMale",dataMap.get(0).get("NumDongLanZhuXingAndMale"));
        jsonObject.put("NumDongLanZhuXingAndFemale",dataMap.get(0).get("NumDongLanZhuXingAndFemale"));
        jsonObject.put("NumDongLanZhuXingAnd60To70M",dataMap.get(0).get("NumDongLanZhuXingAnd60To70M"));
        jsonObject.put("NumDongLanZhuXingAnd70To80M",dataMap.get(0).get("NumDongLanZhuXingAnd70To80M"));
        jsonObject.put("NumDongLanZhuXingAnd80To90M",dataMap.get(0).get("NumDongLanZhuXingAnd80To90M"));
        jsonObject.put("NumDongLanZhuXingAnd90AboveM",dataMap.get(0).get("NumDongLanZhuXingAnd90AboveM"));
        jsonObject.put("NumDongLanZhuXingAnd60To70F",dataMap.get(0).get("NumDongLanZhuXingAnd60To70F"));
        jsonObject.put("NumDongLanZhuXingAnd70To80F",dataMap.get(0).get("NumDongLanZhuXingAnd70To80F"));
        jsonObject.put("NumDongLanZhuXingAnd80To90F",dataMap.get(0).get("NumDongLanZhuXingAnd80To90F"));
        jsonObject.put("NumDongLanZhuXingAnd90AboveF",dataMap.get(0).get("NumDongLanZhuXingAnd90AboveF"));

        jsonObject.put("NumDongLanZhuYiAndHuJi",dataMap.get(0).get("NumDongLanZhuYiAndHuJi"));
        jsonObject.put("NumDongLanZhuYiAndFeiHuJi",dataMap.get(0).get("NumDongLanZhuYiAndFeiHuJi"));
        jsonObject.put("NumDongLanZhuYiAndMale",dataMap.get(0).get("NumDongLanZhuYiAndMale"));
        jsonObject.put("NumDongLanZhuYiAndFemale",dataMap.get(0).get("NumDongLanZhuYiAndFemale"));
        jsonObject.put("NumDongLanZhuYiAnd60To70M",dataMap.get(0).get("NumDongLanZhuYiAnd60To70M"));
        jsonObject.put("NumDongLanZhuYiAnd70To80M",dataMap.get(0).get("NumDongLanZhuYiAnd70To80M"));
        jsonObject.put("NumDongLanZhuYiAnd80To90M",dataMap.get(0).get("NumDongLanZhuYiAnd80To90M"));
        jsonObject.put("NumDongLanZhuYiAnd90AboveM",dataMap.get(0).get("NumDongLanZhuYiAnd90AboveM"));
        jsonObject.put("NumDongLanZhuYiAnd60To70F",dataMap.get(0).get("NumDongLanZhuYiAnd60To70F"));
        jsonObject.put("NumDongLanZhuYiAnd70To80F",dataMap.get(0).get("NumDongLanZhuYiAnd70To80F"));
        jsonObject.put("NumDongLanZhuYiAnd80To90F",dataMap.get(0).get("NumDongLanZhuYiAnd80To90F"));
        jsonObject.put("NumDongLanZhuYiAnd90AboveF",dataMap.get(0).get("NumDongLanZhuYiAnd90AboveF"));

        jsonObject.put("NumDongLanXiYiAndHuJi",dataMap.get(0).get("NumDongLanXiYiAndHuJi"));
        jsonObject.put("NumDongLanXiYiAndFeiHuJi",dataMap.get(0).get("NumDongLanXiYiAndFeiHuJi"));
        jsonObject.put("NumDongLanXiYiAndMale",dataMap.get(0).get("NumDongLanXiYiAndMale"));
        jsonObject.put("NumDongLanXiYiAndFemale",dataMap.get(0).get("NumDongLanXiYiAndFemale"));
        jsonObject.put("NumDongLanXiYiAnd60To70M",dataMap.get(0).get("NumDongLanXiYiAnd60To70M"));
        jsonObject.put("NumDongLanXiYiAnd70To80M",dataMap.get(0).get("NumDongLanXiYiAnd70To80M"));
        jsonObject.put("NumDongLanXiYiAnd80To90M",dataMap.get(0).get("NumDongLanXiYiAnd80To90M"));
        jsonObject.put("NumDongLanXiYiAnd90AboveM",dataMap.get(0).get("NumDongLanXiYiAnd90AboveM"));
        jsonObject.put("NumDongLanXiYiAnd60To70F",dataMap.get(0).get("NumDongLanXiYiAnd60To70F"));
        jsonObject.put("NumDongLanXiYiAnd70To80F",dataMap.get(0).get("NumDongLanXiYiAnd70To80F"));
        jsonObject.put("NumDongLanXiYiAnd80To90F",dataMap.get(0).get("NumDongLanXiYiAnd80To90F"));
        jsonObject.put("NumDongLanXiYiAnd90AboveF",dataMap.get(0).get("NumDongLanXiYiAnd90AboveF"));

        jsonObject.put("NumDongLanXiangTanAndHuJi",dataMap.get(0).get("NumDongLanXiangTanAndHuJi"));
        jsonObject.put("NumDongLanXiangTanAndFeiHuJi",dataMap.get(0).get("NumDongLanXiangTanAndFeiHuJi"));
        jsonObject.put("NumDongLanXiangTanAndMale",dataMap.get(0).get("NumDongLanXiangTanAndMale"));
        jsonObject.put("NumDongLanXiangTanAndFemale",dataMap.get(0).get("NumDongLanXiangTanAndFemale"));
        jsonObject.put("NumDongLanXiangTanAnd60To70M",dataMap.get(0).get("NumDongLanXiangTanAnd60To70M"));
        jsonObject.put("NumDongLanXiangTanAnd70To80M",dataMap.get(0).get("NumDongLanXiangTanAnd70To80M"));
        jsonObject.put("NumDongLanXiangTanAnd80To90M",dataMap.get(0).get("NumDongLanXiangTanAnd80To90M"));
        jsonObject.put("NumDongLanXiangTanAnd90AboveM",dataMap.get(0).get("NumDongLanXiangTanAnd90AboveM"));
        jsonObject.put("NumDongLanXiangTanAnd60To70F",dataMap.get(0).get("NumDongLanXiangTanAnd60To70F"));
        jsonObject.put("NumDongLanXiangTanAnd70To80F",dataMap.get(0).get("NumDongLanXiangTanAnd70To80F"));
        jsonObject.put("NumDongLanXiangTanAnd80To90F",dataMap.get(0).get("NumDongLanXiangTanAnd80To90F"));
        jsonObject.put("NumDongLanXiangTanAnd90AboveF",dataMap.get(0).get("NumDongLanXiangTanAnd90AboveF"));

        jsonObject.put("NumDongLanKangFuAndHuJi",dataMap.get(0).get("NumDongLanKangFuAndHuJi"));
        jsonObject.put("NumDongLanKangFuAndFeiHuJi",dataMap.get(0).get("NumDongLanKangFuAndFeiHuJi"));
        jsonObject.put("NumDongLanKangFuAndMale",dataMap.get(0).get("NumDongLanKangFuAndMale"));
        jsonObject.put("NumDongLanKangFuAndFemale",dataMap.get(0).get("NumDongLanKangFuAndFemale"));
        jsonObject.put("NumDongLanKangFuAnd60To70M",dataMap.get(0).get("NumDongLanKangFuAnd60To70M"));
        jsonObject.put("NumDongLanKangFuAnd70To80M",dataMap.get(0).get("NumDongLanKangFuAnd70To80M"));
        jsonObject.put("NumDongLanKangFuAnd80To90M",dataMap.get(0).get("NumDongLanKangFuAnd80To90M"));
        jsonObject.put("NumDongLanKangFuAnd90AboveM",dataMap.get(0).get("NumDongLanKangFuAnd90AboveM"));
        jsonObject.put("NumDongLanKangFuAnd60To70F",dataMap.get(0).get("NumDongLanKangFuAnd60To70F"));
        jsonObject.put("NumDongLanKangFuAnd70To80F",dataMap.get(0).get("NumDongLanKangFuAnd70To80F"));
        jsonObject.put("NumDongLanKangFuAnd80To90F",dataMap.get(0).get("NumDongLanKangFuAnd80To90F"));
        jsonObject.put("NumDongLanKangFuAnd90AboveF",dataMap.get(0).get("NumDongLanKangFuAnd90AboveF"));

        jsonObject.put("NumDongLanShengHuoAndHuJi",dataMap.get(0).get("NumDongLanShengHuoAndHuJi"));
        jsonObject.put("NumDongLanShengHuoAndFeiHuJi",dataMap.get(0).get("NumDongLanShengHuoAndFeiHuJi"));
        jsonObject.put("NumDongLanShengHuoAndMale",dataMap.get(0).get("NumDongLanShengHuoAndMale"));
        jsonObject.put("NumDongLanShengHuoAndFemale",dataMap.get(0).get("NumDongLanShengHuoAndFemale"));
        jsonObject.put("NumDongLanShengHuoAnd60To70M",dataMap.get(0).get("NumDongLanShengHuoAnd60To70M"));
        jsonObject.put("NumDongLanShengHuoAnd70To80M",dataMap.get(0).get("NumDongLanShengHuoAnd70To80M"));
        jsonObject.put("NumDongLanShengHuoAnd80To90M",dataMap.get(0).get("NumDongLanShengHuoAnd80To90M"));
        jsonObject.put("NumDongLanShengHuoAnd90AboveM",dataMap.get(0).get("NumDongLanShengHuoAnd90AboveM"));
        jsonObject.put("NumDongLanShengHuoAnd60To70F",dataMap.get(0).get("NumDongLanShengHuoAnd60To70F"));
        jsonObject.put("NumDongLanShengHuoAnd70To80F",dataMap.get(0).get("NumDongLanShengHuoAnd70To80F"));
        jsonObject.put("NumDongLanShengHuoAnd80To90F",dataMap.get(0).get("NumDongLanShengHuoAnd80To90F"));
        jsonObject.put("NumDongLanShengHuoAnd90AboveF",dataMap.get(0).get("NumDongLanShengHuoAnd90AboveF"));

        jsonObject.put("NumDongLanFuWuQiTaAndHuJi",dataMap.get(0).get("NumDongLanFuWuQiTaAndHuJi"));
        jsonObject.put("NumDongLanFuWuQiTaAndFeiHuJi",dataMap.get(0).get("NumDongLanFuWuQiTaAndFeiHuJi"));
        jsonObject.put("NumDongLanFuWuQiTaAndMale",dataMap.get(0).get("NumDongLanFuWuQiTaAndMale"));
        jsonObject.put("NumDongLanFuWuQiTaAndFemale",dataMap.get(0).get("NumDongLanFuWuQiTaAndFemale"));
        jsonObject.put("NumDongLanFuWuQiTaAnd60To70M",dataMap.get(0).get("NumDongLanFuWuQiTaAnd60To70M"));
        jsonObject.put("NumDongLanFuWuQiTaAnd70To80M",dataMap.get(0).get("NumDongLanFuWuQiTaAnd70To80M"));
        jsonObject.put("NumDongLanFuWuQiTaAnd80To90M",dataMap.get(0).get("NumDongLanFuWuQiTaAnd80To90M"));
        jsonObject.put("NumDongLanFuWuQiTaAnd90AboveM",dataMap.get(0).get("NumDongLanFuWuQiTaAnd90AboveM"));
        jsonObject.put("NumDongLanFuWuQiTaAnd60To70F",dataMap.get(0).get("NumDongLanFuWuQiTaAnd60To70F"));
        jsonObject.put("NumDongLanFuWuQiTaAnd70To80F",dataMap.get(0).get("NumDongLanFuWuQiTaAnd70To80F"));
        jsonObject.put("NumDongLanFuWuQiTaAnd80To90F",dataMap.get(0).get("NumDongLanFuWuQiTaAnd80To90F"));
        jsonObject.put("NumDongLanFuWuQiTaAnd90AboveF",dataMap.get(0).get("NumDongLanFuWuQiTaAnd90AboveF"));

        //pingji
        jsonObject.put("NumPingJiZhuCanAndHuJi",dataMap.get(0).get("NumPingJiZhuCanAndHuJi"));
        jsonObject.put("NumPingJiZhuCanAndFeiHuJi",dataMap.get(0).get("NumPingJiZhuCanAndFeiHuJi"));
        jsonObject.put("NumPingJiZhuCanAndMale",dataMap.get(0).get("NumPingJiZhuCanAndMale"));
        jsonObject.put("NumPingJiZhuCanAndFemale",dataMap.get(0).get("NumPingJiZhuCanAndFemale"));
        jsonObject.put("NumPingJiZhuCanAnd60To70M",dataMap.get(0).get("NumPingJiZhuCanAnd60To70M"));
        jsonObject.put("NumPingJiZhuCanAnd70To80M",dataMap.get(0).get("NumPingJiZhuCanAnd70To80M"));
        jsonObject.put("NumPingJiZhuCanAnd80To90M",dataMap.get(0).get("NumPingJiZhuCanAnd80To90M"));
        jsonObject.put("NumPingJiZhuCanAnd90AboveM",dataMap.get(0).get("NumPingJiZhuCanAnd90AboveM"));
        jsonObject.put("NumPingJiZhuCanAnd60To70F",dataMap.get(0).get("NumPingJiZhuCanAnd60To70F"));
        jsonObject.put("NumPingJiZhuCanAnd70To80F",dataMap.get(0).get("NumPingJiZhuCanAnd70To80F"));
        jsonObject.put("NumPingJiZhuCanAnd80To90F",dataMap.get(0).get("NumPingJiZhuCanAnd80To90F"));
        jsonObject.put("NumPingJiZhuCanAnd90AboveF",dataMap.get(0).get("NumPingJiZhuCanAnd90AboveF"));

        jsonObject.put("NumPingJiZhuJieAndHuJi",dataMap.get(0).get("NumPingJiZhuJieAndHuJi"));
        jsonObject.put("NumPingJiZhuJieAndFeiHuJi",dataMap.get(0).get("NumPingJiZhuJieAndFeiHuJi"));
        jsonObject.put("NumPingJiZhuJieAndMale",dataMap.get(0).get("NumPingJiZhuJieAndMale"));
        jsonObject.put("NumPingJiZhuJieAndFemale",dataMap.get(0).get("NumPingJiZhuJieAndFemale"));
        jsonObject.put("NumPingJiZhuJieAnd60To70M",dataMap.get(0).get("NumPingJiZhuJieAnd60To70M"));
        jsonObject.put("NumPingJiZhuJieAnd70To80M",dataMap.get(0).get("NumPingJiZhuJieAnd70To80M"));
        jsonObject.put("NumPingJiZhuJieAnd80To90M",dataMap.get(0).get("NumPingJiZhuJieAnd80To90M"));
        jsonObject.put("NumPingJiZhuJieAnd90AboveM",dataMap.get(0).get("NumPingJiZhuJieAnd90AboveM"));
        jsonObject.put("NumPingJiZhuJieAnd60To70F",dataMap.get(0).get("NumPingJiZhuJieAnd60To70F"));
        jsonObject.put("NumPingJiZhuJieAnd70To80F",dataMap.get(0).get("NumPingJiZhuJieAnd70To80F"));
        jsonObject.put("NumPingJiZhuJieAnd80To90F",dataMap.get(0).get("NumPingJiZhuJieAnd80To90F"));
        jsonObject.put("NumPingJiZhuJieAnd90AboveF",dataMap.get(0).get("NumPingJiZhuJieAnd90AboveF"));

        jsonObject.put("NumPingJiZhuYuAndHuJi",dataMap.get(0).get("NumPingJiZhuYuAndHuJi"));
        jsonObject.put("NumPingJiZhuYuAndFeiHuJi",dataMap.get(0).get("NumPingJiZhuYuAndFeiHuJi"));
        jsonObject.put("NumPingJiZhuYuAndMale",dataMap.get(0).get("NumPingJiZhuYuAndMale"));
        jsonObject.put("NumPingJiZhuYuAndFemale",dataMap.get(0).get("NumPingJiZhuYuAndFemale"));
        jsonObject.put("NumPingJiZhuYuAnd60To70M",dataMap.get(0).get("NumPingJiZhuYuAnd60To70M"));
        jsonObject.put("NumPingJiZhuYuAnd70To80M",dataMap.get(0).get("NumPingJiZhuYuAnd70To80M"));
        jsonObject.put("NumPingJiZhuYuAnd80To90M",dataMap.get(0).get("NumPingJiZhuYuAnd80To90M"));
        jsonObject.put("NumPingJiZhuYuAnd90AboveM",dataMap.get(0).get("NumPingJiZhuYuAnd90AboveM"));
        jsonObject.put("NumPingJiZhuYuAnd60To70F",dataMap.get(0).get("NumPingJiZhuYuAnd60To70F"));
        jsonObject.put("NumPingJiZhuYuAnd70To80F",dataMap.get(0).get("NumPingJiZhuYuAnd70To80F"));
        jsonObject.put("NumPingJiZhuYuAnd80To90F",dataMap.get(0).get("NumPingJiZhuYuAnd80To90F"));
        jsonObject.put("NumPingJiZhuYuAnd90AboveF",dataMap.get(0).get("NumPingJiZhuYuAnd90AboveF"));

        jsonObject.put("NumPingJiZhuXingAndHuJi",dataMap.get(0).get("NumPingJiZhuXingAndHuJi"));
        jsonObject.put("NumPingJiZhuXingAndFeiHuJi",dataMap.get(0).get("NumPingJiZhuXingAndFeiHuJi"));
        jsonObject.put("NumPingJiZhuXingAndMale",dataMap.get(0).get("NumPingJiZhuXingAndMale"));
        jsonObject.put("NumPingJiZhuXingAndFemale",dataMap.get(0).get("NumPingJiZhuXingAndFemale"));
        jsonObject.put("NumPingJiZhuXingAnd60To70M",dataMap.get(0).get("NumPingJiZhuXingAnd60To70M"));
        jsonObject.put("NumPingJiZhuXingAnd70To80M",dataMap.get(0).get("NumPingJiZhuXingAnd70To80M"));
        jsonObject.put("NumPingJiZhuXingAnd80To90M",dataMap.get(0).get("NumPingJiZhuXingAnd80To90M"));
        jsonObject.put("NumPingJiZhuXingAnd90AboveM",dataMap.get(0).get("NumPingJiZhuXingAnd90AboveM"));
        jsonObject.put("NumPingJiZhuXingAnd60To70F",dataMap.get(0).get("NumPingJiZhuXingAnd60To70F"));
        jsonObject.put("NumPingJiZhuXingAnd70To80F",dataMap.get(0).get("NumPingJiZhuXingAnd70To80F"));
        jsonObject.put("NumPingJiZhuXingAnd80To90F",dataMap.get(0).get("NumPingJiZhuXingAnd80To90F"));
        jsonObject.put("NumPingJiZhuXingAnd90AboveF",dataMap.get(0).get("NumPingJiZhuXingAnd90AboveF"));

        jsonObject.put("NumPingJiZhuYiAndHuJi",dataMap.get(0).get("NumPingJiZhuYiAndHuJi"));
        jsonObject.put("NumPingJiZhuYiAndFeiHuJi",dataMap.get(0).get("NumPingJiZhuYiAndFeiHuJi"));
        jsonObject.put("NumPingJiZhuYiAndMale",dataMap.get(0).get("NumPingJiZhuYiAndMale"));
        jsonObject.put("NumPingJiZhuYiAndFemale",dataMap.get(0).get("NumPingJiZhuYiAndFemale"));
        jsonObject.put("NumPingJiZhuYiAnd60To70M",dataMap.get(0).get("NumPingJiZhuYiAnd60To70M"));
        jsonObject.put("NumPingJiZhuYiAnd70To80M",dataMap.get(0).get("NumPingJiZhuYiAnd70To80M"));
        jsonObject.put("NumPingJiZhuYiAnd80To90M",dataMap.get(0).get("NumPingJiZhuYiAnd80To90M"));
        jsonObject.put("NumPingJiZhuYiAnd90AboveM",dataMap.get(0).get("NumPingJiZhuYiAnd90AboveM"));
        jsonObject.put("NumPingJiZhuYiAnd60To70F",dataMap.get(0).get("NumPingJiZhuYiAnd60To70F"));
        jsonObject.put("NumPingJiZhuYiAnd70To80F",dataMap.get(0).get("NumPingJiZhuYiAnd70To80F"));
        jsonObject.put("NumPingJiZhuYiAnd80To90F",dataMap.get(0).get("NumPingJiZhuYiAnd80To90F"));
        jsonObject.put("NumPingJiZhuYiAnd90AboveF",dataMap.get(0).get("NumPingJiZhuYiAnd90AboveF"));

        jsonObject.put("NumPingJiXiYiAndHuJi",dataMap.get(0).get("NumPingJiXiYiAndHuJi"));
        jsonObject.put("NumPingJiXiYiAndFeiHuJi",dataMap.get(0).get("NumPingJiXiYiAndFeiHuJi"));
        jsonObject.put("NumPingJiXiYiAndMale",dataMap.get(0).get("NumPingJiXiYiAndMale"));
        jsonObject.put("NumPingJiXiYiAndFemale",dataMap.get(0).get("NumPingJiXiYiAndFemale"));
        jsonObject.put("NumPingJiXiYiAnd60To70M",dataMap.get(0).get("NumPingJiXiYiAnd60To70M"));
        jsonObject.put("NumPingJiXiYiAnd70To80M",dataMap.get(0).get("NumPingJiXiYiAnd70To80M"));
        jsonObject.put("NumPingJiXiYiAnd80To90M",dataMap.get(0).get("NumPingJiXiYiAnd80To90M"));
        jsonObject.put("NumPingJiXiYiAnd90AboveM",dataMap.get(0).get("NumPingJiXiYiAnd90AboveM"));
        jsonObject.put("NumPingJiXiYiAnd60To70F",dataMap.get(0).get("NumPingJiXiYiAnd60To70F"));
        jsonObject.put("NumPingJiXiYiAnd70To80F",dataMap.get(0).get("NumPingJiXiYiAnd70To80F"));
        jsonObject.put("NumPingJiXiYiAnd80To90F",dataMap.get(0).get("NumPingJiXiYiAnd80To90F"));
        jsonObject.put("NumPingJiXiYiAnd90AboveF",dataMap.get(0).get("NumPingJiXiYiAnd90AboveF"));

        jsonObject.put("NumPingJiXiangTanAndHuJi",dataMap.get(0).get("NumPingJiXiangTanAndHuJi"));
        jsonObject.put("NumPingJiXiangTanAndFeiHuJi",dataMap.get(0).get("NumPingJiXiangTanAndFeiHuJi"));
        jsonObject.put("NumPingJiXiangTanAndMale",dataMap.get(0).get("NumPingJiXiangTanAndMale"));
        jsonObject.put("NumPingJiXiangTanAndFemale",dataMap.get(0).get("NumPingJiXiangTanAndFemale"));
        jsonObject.put("NumPingJiXiangTanAnd60To70M",dataMap.get(0).get("NumPingJiXiangTanAnd60To70M"));
        jsonObject.put("NumPingJiXiangTanAnd70To80M",dataMap.get(0).get("NumPingJiXiangTanAnd70To80M"));
        jsonObject.put("NumPingJiXiangTanAnd80To90M",dataMap.get(0).get("NumPingJiXiangTanAnd80To90M"));
        jsonObject.put("NumPingJiXiangTanAnd90AboveM",dataMap.get(0).get("NumPingJiXiangTanAnd90AboveM"));
        jsonObject.put("NumPingJiXiangTanAnd60To70F",dataMap.get(0).get("NumPingJiXiangTanAnd60To70F"));
        jsonObject.put("NumPingJiXiangTanAnd70To80F",dataMap.get(0).get("NumPingJiXiangTanAnd70To80F"));
        jsonObject.put("NumPingJiXiangTanAnd80To90F",dataMap.get(0).get("NumPingJiXiangTanAnd80To90F"));
        jsonObject.put("NumPingJiXiangTanAnd90AboveF",dataMap.get(0).get("NumPingJiXiangTanAnd90AboveF"));

        jsonObject.put("NumPingJiKangFuAndHuJi",dataMap.get(0).get("NumPingJiKangFuAndHuJi"));
        jsonObject.put("NumPingJiKangFuAndFeiHuJi",dataMap.get(0).get("NumPingJiKangFuAndFeiHuJi"));
        jsonObject.put("NumPingJiKangFuAndMale",dataMap.get(0).get("NumPingJiKangFuAndMale"));
        jsonObject.put("NumPingJiKangFuAndFemale",dataMap.get(0).get("NumPingJiKangFuAndFemale"));
        jsonObject.put("NumPingJiKangFuAnd60To70M",dataMap.get(0).get("NumPingJiKangFuAnd60To70M"));
        jsonObject.put("NumPingJiKangFuAnd70To80M",dataMap.get(0).get("NumPingJiKangFuAnd70To80M"));
        jsonObject.put("NumPingJiKangFuAnd80To90M",dataMap.get(0).get("NumPingJiKangFuAnd80To90M"));
        jsonObject.put("NumPingJiKangFuAnd90AboveM",dataMap.get(0).get("NumPingJiKangFuAnd90AboveM"));
        jsonObject.put("NumPingJiKangFuAnd60To70F",dataMap.get(0).get("NumPingJiKangFuAnd60To70F"));
        jsonObject.put("NumPingJiKangFuAnd70To80F",dataMap.get(0).get("NumPingJiKangFuAnd70To80F"));
        jsonObject.put("NumPingJiKangFuAnd80To90F",dataMap.get(0).get("NumPingJiKangFuAnd80To90F"));
        jsonObject.put("NumPingJiKangFuAnd90AboveF",dataMap.get(0).get("NumPingJiKangFuAnd90AboveF"));

        jsonObject.put("NumPingJiShengHuoAndHuJi",dataMap.get(0).get("NumPingJiShengHuoAndHuJi"));
        jsonObject.put("NumPingJiShengHuoAndFeiHuJi",dataMap.get(0).get("NumPingJiShengHuoAndFeiHuJi"));
        jsonObject.put("NumPingJiShengHuoAndMale",dataMap.get(0).get("NumPingJiShengHuoAndMale"));
        jsonObject.put("NumPingJiShengHuoAndFemale",dataMap.get(0).get("NumPingJiShengHuoAndFemale"));
        jsonObject.put("NumPingJiShengHuoAnd60To70M",dataMap.get(0).get("NumPingJiShengHuoAnd60To70M"));
        jsonObject.put("NumPingJiShengHuoAnd70To80M",dataMap.get(0).get("NumPingJiShengHuoAnd70To80M"));
        jsonObject.put("NumPingJiShengHuoAnd80To90M",dataMap.get(0).get("NumPingJiShengHuoAnd80To90M"));
        jsonObject.put("NumPingJiShengHuoAnd90AboveM",dataMap.get(0).get("NumPingJiShengHuoAnd90AboveM"));
        jsonObject.put("NumPingJiShengHuoAnd60To70F",dataMap.get(0).get("NumPingJiShengHuoAnd60To70F"));
        jsonObject.put("NumPingJiShengHuoAnd70To80F",dataMap.get(0).get("NumPingJiShengHuoAnd70To80F"));
        jsonObject.put("NumPingJiShengHuoAnd80To90F",dataMap.get(0).get("NumPingJiShengHuoAnd80To90F"));
        jsonObject.put("NumPingJiShengHuoAnd90AboveF",dataMap.get(0).get("NumPingJiShengHuoAnd90AboveF"));

        jsonObject.put("NumPingJiFuWuQiTaAndHuJi",dataMap.get(0).get("NumPingJiFuWuQiTaAndHuJi"));
        jsonObject.put("NumPingJiFuWuQiTaAndFeiHuJi",dataMap.get(0).get("NumPingJiFuWuQiTaAndFeiHuJi"));
        jsonObject.put("NumPingJiFuWuQiTaAndMale",dataMap.get(0).get("NumPingJiFuWuQiTaAndMale"));
        jsonObject.put("NumPingJiFuWuQiTaAndFemale",dataMap.get(0).get("NumPingJiFuWuQiTaAndFemale"));
        jsonObject.put("NumPingJiFuWuQiTaAnd60To70M",dataMap.get(0).get("NumPingJiFuWuQiTaAnd60To70M"));
        jsonObject.put("NumPingJiFuWuQiTaAnd70To80M",dataMap.get(0).get("NumPingJiFuWuQiTaAnd70To80M"));
        jsonObject.put("NumPingJiFuWuQiTaAnd80To90M",dataMap.get(0).get("NumPingJiFuWuQiTaAnd80To90M"));
        jsonObject.put("NumPingJiFuWuQiTaAnd90AboveM",dataMap.get(0).get("NumPingJiFuWuQiTaAnd90AboveM"));
        jsonObject.put("NumPingJiFuWuQiTaAnd60To70F",dataMap.get(0).get("NumPingJiFuWuQiTaAnd60To70F"));
        jsonObject.put("NumPingJiFuWuQiTaAnd70To80F",dataMap.get(0).get("NumPingJiFuWuQiTaAnd70To80F"));
        jsonObject.put("NumPingJiFuWuQiTaAnd80To90F",dataMap.get(0).get("NumPingJiFuWuQiTaAnd80To90F"));
        jsonObject.put("NumPingJiFuWuQiTaAnd90AboveF",dataMap.get(0).get("NumPingJiFuWuQiTaAnd90AboveF"));
//fenge3

        jsonObject.put("NumFWHuJi",dataMap.get(0).get("NumFWHuJi"));
        jsonObject.put("NumFWFeiHuJi",dataMap.get(0).get("NumFWFeiHuJi"));
        jsonObject.put("NumFWMale",dataMap.get(0).get("NumFWMale"));
        jsonObject.put("NumFWFemale",dataMap.get(0).get("NumFWFemale"));
        jsonObject.put("NumFWAbove90M",dataMap.get(0).get("NumFWAbove90M"));
        jsonObject.put("NumFW80To90M",dataMap.get(0).get("NumFW80To90M"));
        jsonObject.put("NumFW70To80M",dataMap.get(0).get("NumFW70To80M"));
        jsonObject.put("NumFW60To70M",dataMap.get(0).get("NumFW60To70M"));
        jsonObject.put("NumFWAbove90F",dataMap.get(0).get("NumFWAbove90F"));
        jsonObject.put("NumFW80To90F",dataMap.get(0).get("NumFW80To90F"));
        jsonObject.put("NumFW70To80F",dataMap.get(0).get("NumFW70To80F"));
        jsonObject.put("NumFW60To70F",dataMap.get(0).get("NumFW60To70F"));
        jsonObject.put("NumFWKeyAttend",dataMap.get(0).get("NumFWKeyAttend"));
        jsonObject.put("NumFWKeyOld",dataMap.get(0).get("NumFWKeyOld"));

        jsonObject.put("NumZhiNengKeyOld",dataMap.get(0).get("NumZhiNengKeyOld"));
        jsonObject.put("NumKeyAttendZhiNeng",dataMap.get(0).get("NumKeyAttendZhiNeng"));
        jsonObject.put("NumKeyAttendYiSheng",dataMap.get(0).get("NumKeyAttendYiSheng"));
        jsonObject.put("NumKeyAttendBingChuang",dataMap.get(0).get("NumKeyAttendBingChuang"));

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

        jsonObject.put("NumGuMeiLeveled",dataMap.get(0).get("NumGuMeiLeveled"));
        jsonObject.put("NumGuLongLeveled",dataMap.get(0).get("NumGuLongLeveled"));
        jsonObject.put("NumDongLanLeveled",dataMap.get(0).get("NumDongLanLeveled"));
        jsonObject.put("NumPingJiLeveled",dataMap.get(0).get("NumPingJiLeveled"));
        jsonObject.put("NumPingYangLeveled",dataMap.get(0).get("NumPingYangLeveled"));
        jsonObject.put("NumPingNanLeveled",dataMap.get(0).get("NumPingNanLeveled"));

        jsonObject.put("NumGuMeiServed",dataMap.get(0).get("NumGuMeiServed"));
        jsonObject.put("NumGuLongServed",dataMap.get(0).get("NumGuLongServed"));
        jsonObject.put("NumDongLanServed",dataMap.get(0).get("NumDongLanServed"));
        jsonObject.put("NumPingJiServed",dataMap.get(0).get("NumPingJiServed"));
        jsonObject.put("NumPingYangServed",dataMap.get(0).get("NumPingYangServed"));
        jsonObject.put("NumPingNanServed",dataMap.get(0).get("NumPingNanServed"));

        jsonObject.put("NumServed",dataMap.get(0).get("NumServed"));
        jsonObject.put("NumLeveled",dataMap.get(0).get("NumLeveled"));



        Result result =new Result(true,jsonObject);
        return result;

    }


}
