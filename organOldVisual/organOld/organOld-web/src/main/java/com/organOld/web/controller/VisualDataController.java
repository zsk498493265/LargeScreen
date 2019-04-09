package com.organOld.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.organOld.visualService.service.model.OldmanService;
import com.organOld.visualService.service.model.Result;
import com.organOld.visualService.service.model.VisualData;
import org.apache.ibatis.annotations.Param;
import org.directwebremoting.json.types.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.organOld.visualService.util.Tool.AgeTobirthday;
import static com.organOld.web.controller.VisualDataController2.add_code;
import static jdk.nashorn.internal.objects.Global.print;

/**
 * 可视化 数据
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/visual/data")
public class VisualDataController {
    @Autowired
    OldmanService oldmanService;

    @ResponseBody
    @RequestMapping(value = "/getVisualData",method = RequestMethod.GET)
    public Result admin_getOldNum60(){
        List<Map<String,Long>> dataMap=oldmanService.getVisualData(AgeTobirthday(60),AgeTobirthday(70),AgeTobirthday(80),AgeTobirthday(90));
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

        add_code(jsonObject,dataMap);
//        return jsonObject;
        Result result =new Result(true,jsonObject);
        return result;

    }





}
