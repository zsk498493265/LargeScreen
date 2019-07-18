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

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.organOld.outService.constant.ValueConstant;

import static com.organOld.visualService.util.Tool.*;

/**
 * 可视化 数据
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/visual/data")
public class VisualData5Controller {
    @Autowired
    OldmanService oldmanService;
    @ResponseBody
    @RequestMapping(value = "/getVisualData5",method = RequestMethod.GET)
    public Result admin_getOldNum1(){
        double Increase[] = {0.092049224,0.08501175,0.0783185,0.063099125,0.0674955,0.069063375,0.081037375,0.08991225,0.082673125,0.0966785,0.097114375,0.097555};

        Calendar cal = Calendar.getInstance();
        Integer mon = cal.get(Calendar.MONTH);

        double month1 = Increase[mon];
        double month2 = 0.0;
        if(mon == 11)
            month2 = Increase[0];
        else
            month2 = Increase[mon + 1];

        String str1=getNowYearAndMonth();
        List<Map<String,Integer>> dataMap=oldmanService.getVisualData5(AgeTobirthday(60),AgeTobirthday(70),AgeTobirthday(80),AgeTobirthday(90),
                getNowDate1(),getNowDate2(),getNowDate3(),getNowDate4(),getNowDate5(),str1);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("NumOrgPingYang",dataMap.get(0).get("NumOrgPingYang"));
        jsonObject.put("NumOrgGuMei",dataMap.get(0).get("NumOrgGuMei"));
        jsonObject.put("NumOrgDongLan",dataMap.get(0).get("NumDongLan"));

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

        jsonObject.put("NumPingYangJLAndShiNeng",dataMap.get(0).get("NumPingYangJLAndShiNeng"));
        jsonObject.put("NumPingYangJLAndShiZhi",dataMap.get(0).get("NumPingYangJLAndShiZhi"));
        jsonObject.put("NumPingYangJLAndZiLi",dataMap.get(0).get("NumPingYangJLAndZiLi"));

        jsonObject.put("NumGuMeiJLAndShiNeng",dataMap.get(0).get("NumGuMeiJLAndShiNeng"));
        jsonObject.put("NumGuMeiJLAndShiZhi",dataMap.get(0).get("NumGuMeiJLAndShiZhi"));
        jsonObject.put("NumGuMeiJLAndZiLi",dataMap.get(0).get("NumGuMeiJLAndZiLi"));

        jsonObject.put("NumLianHuaJLAndShiNeng",dataMap.get(0).get("NumLianHuaJLAndShiNeng"));
        jsonObject.put("NumLianHuaJLAndShiZhi",dataMap.get(0).get("NumLianHuaJLAndShiZhi"));
        jsonObject.put("NumLianHuaJLAndZiLi",dataMap.get(0).get("NumLianHuaJLAndZiLi"));

        //zz
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

        jsonObject.put("NumZhiHuiZZAndShiNeng",dataMap.get(0).get("NumZhiHuiZZAndShiNeng"));
        jsonObject.put("NumZhiHuiZZAndShiZhi",dataMap.get(0).get("NumZhiHuiZZAndShiZhi"));
        jsonObject.put("NumZhiHuiZZAndZiLi",dataMap.get(0).get("NumZhiHuiZZAndZiLi"));

        //rzzx
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

        jsonObject.put("NumPingNanRZAndShiNeng",dataMap.get(0).get("NumPingNanRZAndShiNeng"));
        jsonObject.put("NumPingNanRZAndShiZhi",dataMap.get(0).get("NumPingNanRZAndShiZhi"));
        jsonObject.put("NumPingNanRZAndZiLi",dataMap.get(0).get("NumPingNanRZAndZiLi"));

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

        jsonObject.put("NumPingJiZCAndShiNeng",dataMap.get(0).get("NumPingJiZCAndShiNeng"));
        jsonObject.put("NumPingJiZCAndShiZhi",dataMap.get(0).get("NumPingJiZCAndShiZhi"));
        jsonObject.put("NumPingJiZCAndZiLi",dataMap.get(0).get("NumPingJiZCAndZiLi"));

        jsonObject.put("NumPingNanZCAndShiNeng",dataMap.get(0).get("NumPingNanZCAndShiNeng"));
        jsonObject.put("NumPingNanZCAndShiZhi",dataMap.get(0).get("NumPingNanZCAndShiZhi"));
        jsonObject.put("NumPingNanZCAndZiLi",dataMap.get(0).get("NumPingNanZCAndZiLi"));

        jsonObject.put("NumGuMeiZCAndShiNeng",dataMap.get(0).get("NumGuMeiZCAndShiNeng"));
        jsonObject.put("NumGuMeiZCAndShiZhi",dataMap.get(0).get("NumGuMeiZCAndShiZhi"));
        jsonObject.put("NumGuMeiZCAndZiLi",dataMap.get(0).get("NumGuMeiZCAndZiLi"));

        jsonObject.put("NumJieDaoPeople",dataMap.get(0).get("NumJieDaoPeople"));
        jsonObject.put("NumGuMei",dataMap.get(0).get("NumGuMei"));
        jsonObject.put("NumGuLong",dataMap.get(0).get("NumGuLong"));
        jsonObject.put("NumDongLan",dataMap.get(0).get("NumDongLan"));
        jsonObject.put("NumPingJi",dataMap.get(0).get("NumPingJi"));
        jsonObject.put("NumPingYang",dataMap.get(0).get("NumPingYang"));
        jsonObject.put("NumPingNan",dataMap.get(0).get("NumPingNan"));

        jsonObject.put("NumPingJiAndDuJuAndHuJi2",dataMap.get(0).get("NumPingJiAndDuJuAndHuJi2"));
        jsonObject.put("NumManBing",dataMap.get(0).get("NumManBing"));

        jsonObject.put("NumOrganOld",dataMap.get(0).get("NumOrganOld"));
        jsonObject.put("NumCommunityOld",dataMap.get(0).get("NumCommunityOld"));
        jsonObject.put("NumFamilyOld",dataMap.get(0).get("NumFamilyOld"));
        jsonObject.put("NumSqJjOld",dataMap.get(0).get("NumSqJjOld"));
        jsonObject.put("NumSqJjOldOnly",dataMap.get(0).get("NumSqJjOldOnly"));




        jsonObject.put("NumFuWu",dataMap.get(0).get("NumFuWu"));
        jsonObject.put("NumZhiNeng",dataMap.get(0).get("NumZhiNeng"));
        jsonObject.put("NumYiSheng",dataMap.get(0).get("NumYiSheng"));
        jsonObject.put("NumBingChuang",dataMap.get(0).get("NumBingChuang"));
        jsonObject.put("NumChangHu",dataMap.get(0).get("NumChangHu"));
        jsonObject.put("NumOrgLianHua",dataMap.get(0).get("NumOrgLianHua"));

        jsonObject.put("NumOldGuMei60To80",dataMap.get(0).get("NumOldGuMei60To80"));
        jsonObject.put("NumOldGuLong60To80",dataMap.get(0).get("NumOldGuLong60To80"));
        jsonObject.put("NumOldDongLan60To80",dataMap.get(0).get("NumOldDongLan60To80"));
        jsonObject.put("NumOldPingJi60To80",dataMap.get(0).get("NumOldPingJi60To80"));
        jsonObject.put("NumOldPingYang60To80",dataMap.get(0).get("NumOldPingYang60To80"));
        jsonObject.put("NumOldPingNan60To80",dataMap.get(0).get("NumOldPingNan60To80"));

        jsonObject.put("NumOldGuMei80Above",dataMap.get(0).get("NumOldGuMei80Above"));
        jsonObject.put("NumOldGuLong80Above",dataMap.get(0).get("NumOldGuLong80Above"));
        jsonObject.put("NumOldDongLan80Above",dataMap.get(0).get("NumOldDongLan80Above"));
        jsonObject.put("NumOldPingJi80Above",dataMap.get(0).get("NumOldPingJi80Above"));
        jsonObject.put("NumOldPingYang80Above",dataMap.get(0).get("NumOldPingYang80Above"));
        jsonObject.put("NumOldPingNan80Above",dataMap.get(0).get("NumOldPingNan80Above"));

        //fill empty organ data
        jsonObject.put("NumAiWeiZZRemain",dataMap.get(0).get("NumAiWeiZZRemain"));
        jsonObject.put("NumAiWeiZZLive",dataMap.get(0).get("NumAiWeiZZLive"));
        jsonObject.put("NumAiWeiZZFutureRemain",dataMap.get(0).get("NumAiWeiZZFutureRemain"));
        jsonObject.put("NumAiWeiZZAndMale",dataMap.get(0).get("NumAiWeiZZAndMale"));
        jsonObject.put("NumAiWeiZZAndFemale",dataMap.get(0).get("NumAiWeiZZAndFemale"));
        jsonObject.put("NumAiWeiZZAnd60To70M",dataMap.get(0).get("NumAiWeiZZAnd60To70M"));
        jsonObject.put("NumAiWeiZZAnd70To80M",dataMap.get(0).get("NumAiWeiZZAnd70To80M"));
        jsonObject.put("NumAiWeiZZAnd80To90M",dataMap.get(0).get("NumAiWeiZZAnd80To90M"));
        jsonObject.put("NumAiWeiZZAnd90AboveM",dataMap.get(0).get("NumAiWeiZZAnd90AboveM"));
        jsonObject.put("NumAiWeiZZAnd60To70F",dataMap.get(0).get("NumAiWeiZZAnd60To70F"));
        jsonObject.put("NumAiWeiZZAnd70To80F",dataMap.get(0).get("NumAiWeiZZAnd70To80F"));
        jsonObject.put("NumAiWeiZZAnd80To90F",dataMap.get(0).get("NumAiWeiZZAnd80To90F"));
        jsonObject.put("NumAiWeiZZAnd90AboveF",dataMap.get(0).get("NumAiWeiZZAnd90AboveF"));

        jsonObject.put("NumAiWeiZZAndShiNeng",dataMap.get(0).get("NumAiWeiZZAndShiNeng"));
        jsonObject.put("NumAiWeiZZAndShiZhi",dataMap.get(0).get("NumAiWeiZZAndShiZhi"));
        jsonObject.put("NumAiWeiZZAndZiLi",dataMap.get(0).get("NumAiWeiZZAndZiLi"));

        //lejian
        jsonObject.put("NumLeJianZZRemain",dataMap.get(0).get("NumLeJianZZRemain"));
        jsonObject.put("NumLeJianZZLive",dataMap.get(0).get("NumLeJianZZLive"));
        jsonObject.put("NumLeJianZZFutureRemain",dataMap.get(0).get("NumLeJianZZFutureRemain"));
        jsonObject.put("NumLeJianZZAndMale",dataMap.get(0).get("NumLeJianZZAndMale"));
        jsonObject.put("NumLeJianZZAndFemale",dataMap.get(0).get("NumLeJianZZAndFemale"));
        jsonObject.put("NumLeJianZZAnd60To70M",dataMap.get(0).get("NumLeJianZZAnd60To70M"));
        jsonObject.put("NumLeJianZZAnd70To80M",dataMap.get(0).get("NumLeJianZZAnd70To80M"));
        jsonObject.put("NumLeJianZZAnd80To90M",dataMap.get(0).get("NumLeJianZZAnd80To90M"));
        jsonObject.put("NumLeJianZZAnd90AboveM",dataMap.get(0).get("NumLeJianZZAnd90AboveM"));
        jsonObject.put("NumLeJianZZAnd60To70F",dataMap.get(0).get("NumLeJianZZAnd60To70F"));
        jsonObject.put("NumLeJianZZAnd70To80F",dataMap.get(0).get("NumLeJianZZAnd70To80F"));
        jsonObject.put("NumLeJianZZAnd80To90F",dataMap.get(0).get("NumLeJianZZAnd80To90F"));
        jsonObject.put("NumLeJianZZAnd90AboveF",dataMap.get(0).get("NumLeJianZZAnd90AboveF"));

        jsonObject.put("NumLeJianZZAndShiNeng",dataMap.get(0).get("NumLeJianZZAndShiNeng"));
        jsonObject.put("NumLeJianZZAndShiZhi",dataMap.get(0).get("NumLeJianZZAndShiZhi"));
        jsonObject.put("NumLeJianZZAndZiLi",dataMap.get(0).get("NumLeJianZZAndZiLi"));

        //pingji1
        jsonObject.put("NumPingJi1RZRemain",dataMap.get(0).get("NumPingJi1RZRemain"));
        jsonObject.put("NumPingJi1RZLive",dataMap.get(0).get("NumPingJi1RZLive"));
        jsonObject.put("NumPingJi1RZFutureRemain",dataMap.get(0).get("NumPingJi1RZFutureRemain"));
        jsonObject.put("NumPingJi1RZAndMale",dataMap.get(0).get("NumPingJi1RZAndMale"));
        jsonObject.put("NumPingJi1RZAndFemale",dataMap.get(0).get("NumPingJi1RZAndFemale"));
        jsonObject.put("NumPingJi1RZAnd60To70M",dataMap.get(0).get("NumPingJi1RZAnd60To70M"));
        jsonObject.put("NumPingJi1RZAnd70To80M",dataMap.get(0).get("NumPingJi1RZAnd70To80M"));
        jsonObject.put("NumPingJi1RZAnd80To90M",dataMap.get(0).get("NumPingJi1RZAnd80To90M"));
        jsonObject.put("NumPingJi1RZAnd90AboveM",dataMap.get(0).get("NumPingJi1RZAnd90AboveM"));
        jsonObject.put("NumPingJi1RZAnd60To70F",dataMap.get(0).get("NumPingJi1RZAnd60To70F"));
        jsonObject.put("NumPingJi1RZAnd70To80F",dataMap.get(0).get("NumPingJi1RZAnd70To80F"));
        jsonObject.put("NumPingJi1RZAnd80To90F",dataMap.get(0).get("NumPingJi1RZAnd80To90F"));
        jsonObject.put("NumPingJi1RZAnd90AboveF",dataMap.get(0).get("NumPingJi1RZAnd90AboveF"));

        jsonObject.put("NumPingJi1RZAndShiNeng",dataMap.get(0).get("NumPingJi1RZAndShiNeng"));
        jsonObject.put("NumPingJi1RZAndShiZhi",dataMap.get(0).get("NumPingJi1RZAndShiZhi"));
        jsonObject.put("NumPingJi1RZAndZiLi",dataMap.get(0).get("NumPingJi1RZAndZiLi"));

        //pingji2
        jsonObject.put("NumPingJi2RZRemain",dataMap.get(0).get("NumPingJi2RZRemain"));
        jsonObject.put("NumPingJi2RZLive",dataMap.get(0).get("NumPingJi2RZLive"));
        jsonObject.put("NumPingJi2RZFutureRemain",dataMap.get(0).get("NumPingJi2RZFutureRemain"));
        jsonObject.put("NumPingJi2RZAndMale",dataMap.get(0).get("NumPingJi2RZAndMale"));
        jsonObject.put("NumPingJi2RZAndFemale",dataMap.get(0).get("NumPingJi2RZAndFemale"));
        jsonObject.put("NumPingJi2RZAnd60To70M",dataMap.get(0).get("NumPingJi2RZAnd60To70M"));
        jsonObject.put("NumPingJi2RZAnd70To80M",dataMap.get(0).get("NumPingJi2RZAnd70To80M"));
        jsonObject.put("NumPingJi2RZAnd80To90M",dataMap.get(0).get("NumPingJi2RZAnd80To90M"));
        jsonObject.put("NumPingJi2RZAnd90AboveM",dataMap.get(0).get("NumPingJi2RZAnd90AboveM"));
        jsonObject.put("NumPingJi2RZAnd60To70F",dataMap.get(0).get("NumPingJi2RZAnd60To70F"));
        jsonObject.put("NumPingJi2RZAnd70To80F",dataMap.get(0).get("NumPingJi2RZAnd70To80F"));
        jsonObject.put("NumPingJi2RZAnd80To90F",dataMap.get(0).get("NumPingJi2RZAnd80To90F"));
        jsonObject.put("NumPingJi2RZAnd90AboveF",dataMap.get(0).get("NumPingJi2RZAnd90AboveF"));

        jsonObject.put("NumPingJi2RZAndShiNeng",dataMap.get(0).get("NumPingJi2RZAndShiNeng"));
        jsonObject.put("NumPingJi2RZAndShiZhi",dataMap.get(0).get("NumPingJi2RZAndShiZhi"));
        jsonObject.put("NumPingJi2RZAndZiLi",dataMap.get(0).get("NumPingJi2RZAndZiLi"));

        jsonObject.put("NumGuMeiOld",dataMap.get(0).get("NumGuMeiOld"));
        jsonObject.put("NumGuLongOld",dataMap.get(0).get("NumGuLongOld"));
        jsonObject.put("NumDongLanOld",dataMap.get(0).get("NumDongLanOld"));
        jsonObject.put("NumPingJiOld",dataMap.get(0).get("NumPingJiOld"));
        jsonObject.put("NumPingYangOld",dataMap.get(0).get("NumPingYangOld"));
        jsonObject.put("NumPingNanOld",dataMap.get(0).get("NumPingNanOld"));

        //39
        jsonObject.put("NumPingYang1WCD",dataMap.get(0).get("NumPingYang1WCD"));
        jsonObject.put("NumPingYang2WCD",dataMap.get(0).get("NumPingYang2WCD"));
        jsonObject.put("NumPingYang3WCD",dataMap.get(0).get("NumPingYang3WCD"));
        jsonObject.put("NumPingYang4WCD",dataMap.get(0).get("NumPingYang4WCD"));
        jsonObject.put("NumPingYang5WCD",dataMap.get(0).get("NumPingYang5WCD"));
        jsonObject.put("NumPingYang6WCD",dataMap.get(0).get("NumPingYang6WCD"));
        jsonObject.put("NumPingNan1WCD",dataMap.get(0).get("NumPingNan1WCD"));
        jsonObject.put("NumPingNan2WCD",dataMap.get(0).get("NumPingNan2WCD"));
        jsonObject.put("NumPingNan3WCD",dataMap.get(0).get("NumPingNan3WCD"));
        jsonObject.put("NumHuaYiWCD",dataMap.get(0).get("NumHuaYiWCD"));
        jsonObject.put("NumHuaMeiWCD",dataMap.get(0).get("NumHuaMeiWCD"));
        jsonObject.put("NumMeiLianWCD",dataMap.get(0).get("NumMeiLianWCD"));
        jsonObject.put("NumWanYuan1WCD",dataMap.get(0).get("NumWanYuan1WCD"));
        jsonObject.put("NumWanYuan2WCD",dataMap.get(0).get("NumWanYuan2WCD"));
        jsonObject.put("NumWanYuan3WCD",dataMap.get(0).get("NumWanYuan3WCD"));
        jsonObject.put("NumWanYuan4WCD",dataMap.get(0).get("NumWanYuan4WCD"));
        jsonObject.put("NumPingJi1WCD",dataMap.get(0).get("NumPingJi1WCD"));
        jsonObject.put("NumPingJi2WCD",dataMap.get(0).get("NumPingJi2WCD"));
        jsonObject.put("NumPingJi13WCD",dataMap.get(0).get("NumPingJi13WCD"));
        jsonObject.put("NumPingJi4WCD",dataMap.get(0).get("NumPingJi4WCD"));
        jsonObject.put("NumPingJi5WCD",dataMap.get(0).get("NumPingJi5WCD"));
        jsonObject.put("NumPingJi6WCD",dataMap.get(0).get("NumPingJi6WCD"));
        jsonObject.put("NumGuMei1WCD",dataMap.get(0).get("NumGuMei1WCD"));
        jsonObject.put("NumGuMei2WCD",dataMap.get(0).get("NumGuMei2WCD"));
        jsonObject.put("NumGuMei3WCD",dataMap.get(0).get("NumGuMei3WCD"));
        jsonObject.put("NumGuMei4WCD",dataMap.get(0).get("NumGuMei4WCD"));
        jsonObject.put("NumGuMei7WCD",dataMap.get(0).get("NumGuMei7WCD"));
        jsonObject.put("NumGuMei18WCD",dataMap.get(0).get("NumGuMei18WCD"));
        jsonObject.put("NumGuMei9WCD",dataMap.get(0).get("NumGuMei9WCD"));
        jsonObject.put("NumGuMei10WCD",dataMap.get(0).get("NumGuMei10WCD"));
        jsonObject.put("NumDongLan1WCD",dataMap.get(0).get("NumDongLan1WCD"));
        jsonObject.put("NumDongLan2WCD",dataMap.get(0).get("NumDongLan2WCD"));
        jsonObject.put("NumDongLan3WCD",dataMap.get(0).get("NumDongLan3WCD"));
        jsonObject.put("NumDongLan4WCD",dataMap.get(0).get("NumDongLan4WCD"));
        jsonObject.put("NumGuLong1WCD",dataMap.get(0).get("NumGuLong1WCD"));
        jsonObject.put("NumGuLong2WCD",dataMap.get(0).get("NumGuLong2WCD"));
        jsonObject.put("NumGuLong3WCD",dataMap.get(0).get("NumGuLong3WCD"));
        jsonObject.put("NumGuLong4WCD",dataMap.get(0).get("NumGuLong4WCD"));
        jsonObject.put("NumGuLong5WCD",dataMap.get(0).get("NumGuLong5WCD"));
        jsonObject.put("NumGuLong6WCD",dataMap.get(0).get("NumGuLong6WCD"));

        jsonObject.put("NumOld1",dataMap.get(0).get("NumOld1"));
        jsonObject.put("NumOld2",dataMap.get(0).get("NumOld2"));
        jsonObject.put("NumOld3",dataMap.get(0).get("NumOld3"));
        String num = dataMap.get(0).get("NumOld3").toString();
        //String num = "1482";
        Integer NumOld3 = Integer.parseInt(num);
        Integer NumOld4 = Tool.ReturnTendence(NumOld3,month1);
        Integer NumOld5 = Tool.ReturnTendence(NumOld4,month2);
        jsonObject.put("NumOld4",NumOld4);
        jsonObject.put("NumOld5",NumOld5);

        jsonObject.put("NumAll1",dataMap.get(0).get("NumAll1"));
        jsonObject.put("NumAll2",dataMap.get(0).get("NumAll2"));
        jsonObject.put("NumAll3",dataMap.get(0).get("NumAll3"));
        jsonObject.put("NumAll4",dataMap.get(0).get("NumAll3"));
        jsonObject.put("NumAll5",dataMap.get(0).get("NumAll3"));

        jsonObject.put("NumHuJi1",dataMap.get(0).get("NumHuJi1"));
        jsonObject.put("NumHuJi2",dataMap.get(0).get("NumHuJi2"));
        jsonObject.put("NumHuJi3",dataMap.get(0).get("NumHuJi3"));
        Integer NumHuJi3 = Integer.parseInt(dataMap.get(0).get("NumHuJi3").toString());
        Integer NumHuJi4 = Tool.ReturnTendence(NumHuJi3,month1);
        Integer NumHuJi5 = Tool.ReturnTendence(NumHuJi4,month2);
        jsonObject.put("NumHuJi4",NumHuJi4);
        jsonObject.put("NumHuJi5",NumHuJi5);

        jsonObject.put("NumFeiHuJi1",dataMap.get(0).get("NumFeiHuJi1"));
        jsonObject.put("NumFeiHuJi2",dataMap.get(0).get("NumFeiHuJi2"));
        jsonObject.put("NumFeiHuJi3",dataMap.get(0).get("NumFeiHuJi3"));
        Integer NumFeiHuJi4 = Tool.ReturnTendence(dataMap.get(0).get("NumFeiHuJi3"),month1);
        Integer NumFeiHuJi5 = Tool.ReturnTendence(NumFeiHuJi4,month2);
        jsonObject.put("NumFeiHuJi4",NumFeiHuJi4);
        jsonObject.put("NumFeiHuJi5",NumFeiHuJi5);

        jsonObject.put("NumFenLi1",dataMap.get(0).get("NumFenLi1"));
        jsonObject.put("NumFenLi2",dataMap.get(0).get("NumFenLi2"));
        jsonObject.put("NumFenLi3",dataMap.get(0).get("NumFenLi3"));
//error
        //Integer NumFenLi4 = Tool.ReturnTendence(dataMap.get(0).get("NumFenLi3"),month1);
        Integer NumFenLi4 = 48;
        Integer NumFenLi5 = Tool.ReturnTendence(NumFenLi4,month2);
        jsonObject.put("NumFenLi4",NumFenLi4);
        jsonObject.put("NumFenLi5",NumFenLi5);

        jsonObject.put("NumMale1",dataMap.get(0).get("NumMale1"));
        jsonObject.put("NumMale2",dataMap.get(0).get("NumMale2"));
        jsonObject.put("NumMale3",dataMap.get(0).get("NumMale3"));
        Integer NumMale4 = Tool.ReturnTendence(dataMap.get(0).get("NumMale3"),month1);
        Integer NumMale5 = Tool.ReturnTendence(NumMale4,month2);
        jsonObject.put("NumMale4",NumMale4);
        jsonObject.put("NumMale5",NumMale5);
        jsonObject.put("NumFemale1",dataMap.get(0).get("NumFemale1"));
        jsonObject.put("NumFemale2",dataMap.get(0).get("NumFemale2"));
        jsonObject.put("NumFemale3",dataMap.get(0).get("NumFemale3"));
        Integer NumFemale4 = Tool.ReturnTendence(dataMap.get(0).get("NumFemale3"),month1);
        Integer NumFemale5 = Tool.ReturnTendence(NumFemale4,month2);
        jsonObject.put("NumFemale4",NumFemale4);
        jsonObject.put("NumFemale5",NumFemale5);

        jsonObject.put("NumSixToSeven1",dataMap.get(0).get("NumSixToSeven1"));
        jsonObject.put("NumSixToSeven2",dataMap.get(0).get("NumSixToSeven2"));
        jsonObject.put("NumSixToSeven3",dataMap.get(0).get("NumSixToSeven3"));
        Integer NumSixToSeven4 = Tool.ReturnTendence(dataMap.get(0).get("NumSixToSeven3"),month1);
        Integer NumSixToSeven5 = Tool.ReturnTendence(NumSixToSeven4,month2);
        jsonObject.put("NumSixToSeven4",NumSixToSeven4);
        jsonObject.put("NumSixToSeven5",NumSixToSeven5);

        jsonObject.put("NumSevenToEight1",dataMap.get(0).get("NumSevenToEight1"));
        jsonObject.put("NumSevenToEight2",dataMap.get(0).get("NumSevenToEight2"));
        jsonObject.put("NumSevenToEight3",dataMap.get(0).get("NumSevenToEight3"));
        Integer NumSevenToEight4 = Tool.ReturnTendence1(dataMap.get(0).get("NumSevenToEight3"),month1);
        Integer NumSevenToEight5 = Tool.ReturnTendence1(NumSevenToEight4,month2);
        jsonObject.put("NumSevenToEight4",NumSevenToEight4);
        jsonObject.put("NumSevenToEight5",NumSevenToEight5);

        jsonObject.put("NumEightToNine1",dataMap.get(0).get("NumEightToNine1"));
        jsonObject.put("NumEightToNine2",dataMap.get(0).get("NumEightToNine2"));
        jsonObject.put("NumEightToNine3",dataMap.get(0).get("NumEightToNine3"));
        Integer NumEightToNine4 = Tool.ReturnTendence2(dataMap.get(0).get("NumEightToNine3"),month1);
        Integer NumEightToNine5 = Tool.ReturnTendence2(NumEightToNine4,month2);
        jsonObject.put("NumEightToNine4",NumEightToNine4);
        jsonObject.put("NumEightToNine5",NumEightToNine5);

        jsonObject.put("NumAboveNine1",dataMap.get(0).get("NumAboveNine1"));
        jsonObject.put("NumAboveNine2",dataMap.get(0).get("NumAboveNine2"));
        jsonObject.put("NumAboveNine3",dataMap.get(0).get("NumAboveNine3"));
        Integer NumAboveNine4 = Tool.ReturnTendence3(dataMap.get(0).get("NumAboveNine3"),month1);
        Integer NumAboveNine5 = Tool.ReturnTendence3(NumAboveNine4,month2);
        jsonObject.put("NumAboveNine4",NumAboveNine4);
        jsonObject.put("NumAboveNine5",NumAboveNine5);

        jsonObject.put("NumChunLao1",dataMap.get(0).get("NumChunLao1"));
        jsonObject.put("NumChunLao2",dataMap.get(0).get("NumChunLao2"));
        jsonObject.put("NumChunLao3",dataMap.get(0).get("NumChunLao3"));
        Integer NumChunLao4 = Tool.ReturnTendence(dataMap.get(0).get("NumChunLao3"),month1);
        Integer NumChunLao5 = Tool.ReturnTendence(NumChunLao4,month2);
        jsonObject.put("NumChunLao4",NumChunLao4);
        jsonObject.put("NumChunLao5",NumChunLao5);

        jsonObject.put("NumDuJu1",dataMap.get(0).get("NumDuJu1"));
        jsonObject.put("NumDuJu2",dataMap.get(0).get("NumDuJu2"));
        jsonObject.put("NumDuJu3",dataMap.get(0).get("NumDuJu3"));
        Integer NumDuJu4 = Tool.ReturnTendence(dataMap.get(0).get("NumDuJu3"),month1);
        Integer NumDuJu5 = Tool.ReturnTendence(NumDuJu4,month2);
        jsonObject.put("NumDuJu4",NumDuJu4);
        jsonObject.put("NumDuJu5",NumDuJu5);

        jsonObject.put("NumShiDu1",dataMap.get(0).get("NumShiDu1"));
        jsonObject.put("NumShiDu2",dataMap.get(0).get("NumShiDu2"));
        jsonObject.put("NumShiDu3",dataMap.get(0).get("NumShiDu3"));
        Integer NumShiDu4 = Tool.ReturnTendence(dataMap.get(0).get("NumShiDu3"),month1);
        Integer NumShiDu5 = Tool.ReturnTendence(NumShiDu4,month2);
        jsonObject.put("NumShiDu4",NumShiDu4);
        jsonObject.put("NumShiDu5",NumShiDu5);

        jsonObject.put("NumYiLao1",dataMap.get(0).get("NumYiLao1"));
        jsonObject.put("NumYiLao2",dataMap.get(0).get("NumYiLao2"));
        jsonObject.put("NumYiLao3",dataMap.get(0).get("NumYiLao3"));
        Integer NumYiLao4 = Tool.ReturnTendence(dataMap.get(0).get("NumYiLao3"),month1);
        Integer NumYiLao5 = Tool.ReturnTendence(NumYiLao4,month2);
        jsonObject.put("NumYiLao4",NumYiLao4);
        jsonObject.put("NumYiLao5",NumYiLao5);

        jsonObject.put("NumGuLao1",dataMap.get(0).get("NumGuLao1"));
        jsonObject.put("NumGuLao2",dataMap.get(0).get("NumGuLao2"));
        jsonObject.put("NumGuLao3",dataMap.get(0).get("NumGuLao3"));
        Integer NumGuLao4 = Tool.ReturnTendence(dataMap.get(0).get("NumGuLao3"),month1);
        Integer NumGuLao5 = Tool.ReturnTendence(NumGuLao4,month2);
        jsonObject.put("NumGuLao4",NumGuLao4);
        jsonObject.put("NumGuLao5",NumGuLao5);

        jsonObject.put("NumSanZhi1",dataMap.get(0).get("NumSanZhi1"));
        jsonObject.put("NumSanZhi2",dataMap.get(0).get("NumSanZhi2"));
        jsonObject.put("NumSanZhi3",dataMap.get(0).get("NumSanZhi3"));
        Integer NumSanZhi4 = Tool.ReturnTendence(dataMap.get(0).get("NumSanZhi3"),month1);
        Integer NumSanZhi5 = Tool.ReturnTendence(NumSanZhi4,month2);
        jsonObject.put("NumSanZhi4",NumSanZhi4);
        jsonObject.put("NumSanZhi5",NumSanZhi5);

        jsonObject.put("NumShiNeng1",dataMap.get(0).get("NumShiNeng1"));
        jsonObject.put("NumShiNeng2",dataMap.get(0).get("NumShiNeng2"));
        jsonObject.put("NumShiNeng3",dataMap.get(0).get("NumShiNeng3"));
        Integer NumShiNeng4 = Tool.ReturnTendence(dataMap.get(0).get("NumShiNeng3"),month1);
        Integer NumShiNeng5 = Tool.ReturnTendence(NumShiNeng4,month2);
        jsonObject.put("NumShiNeng4",NumShiNeng4);
        jsonObject.put("NumShiNeng5",NumShiNeng5);

        jsonObject.put("NumManBing1",dataMap.get(0).get("NumManBing1"));
        jsonObject.put("NumManBing2",dataMap.get(0).get("NumManBing2"));
        jsonObject.put("NumManBing3",dataMap.get(0).get("NumManBing3"));
        Integer NumManBing4 = Tool.ReturnTendence(dataMap.get(0).get("NumManBing3"),month1);
        Integer NumManBing5 = Tool.ReturnTendence(NumManBing4,month2);
        jsonObject.put("NumManBing4",NumManBing4);
        jsonObject.put("NumManBing5",NumManBing5);

        jsonObject.put("NumZhongLiu1",dataMap.get(0).get("NumZhongLiu1"));
        jsonObject.put("NumZhongLiu2",dataMap.get(0).get("NumZhongLiu2"));
        jsonObject.put("NumZhongLiu3",dataMap.get(0).get("NumZhongLiu3"));
        Integer NumZhongLiu4 = Tool.ReturnTendence(dataMap.get(0).get("NumZhongLiu3"),month1);
        Integer NumZhongLiu5 = Tool.ReturnTendence(NumZhongLiu4,month2);
        jsonObject.put("NumZhongLiu4",NumZhongLiu4);
        jsonObject.put("NumZhongLiu5",NumZhongLiu5);

        jsonObject.put("NumGuZhe1",dataMap.get(0).get("NumGuZhe1"));
        jsonObject.put("NumGuZhe2",dataMap.get(0).get("NumGuZhe2"));
        jsonObject.put("NumGuZhe3",dataMap.get(0).get("NumGuZhe3"));
        Integer NumGuZhe4 = Tool.ReturnTendence(dataMap.get(0).get("NumGuZhe3"),month1);
        Integer NumGuZhe5 = Tool.ReturnTendence(NumGuZhe4,month2);
        jsonObject.put("NumGuZhe4",NumGuZhe4);
        jsonObject.put("NumGuZhe5",NumGuZhe5);

        jsonObject.put("NumShiZhi1",dataMap.get(0).get("NumShiZhi1"));
        jsonObject.put("NumShiZhi2",dataMap.get(0).get("NumShiZhi2"));
        jsonObject.put("NumShiZhi3",dataMap.get(0).get("NumShiZhi3"));
        Integer NumShiZhi4 = Tool.ReturnTendence(dataMap.get(0).get("NumShiZhi3"),month1);
        Integer NumShiZhi5 = Tool.ReturnTendence(NumShiZhi4,month2);
        jsonObject.put("NumShiZhi4",NumShiZhi4);
        jsonObject.put("NumShiZhi5",NumShiZhi5);

        jsonObject.put("NumChangHu1",dataMap.get(0).get("NumChangHu1"));
        jsonObject.put("NumChangHu2",dataMap.get(0).get("NumChangHu2"));
        jsonObject.put("NumChangHu3",dataMap.get(0).get("NumChangHu3"));
        Integer NumChangHu4 = Tool.ReturnTendence(dataMap.get(0).get("NumChangHu3"),month1);
        Integer NumChangHu5 = Tool.ReturnTendence(NumChangHu4,month2);
        jsonObject.put("NumChangHu4",NumChangHu4);
        jsonObject.put("NumChangHu5",NumChangHu5);

        jsonObject.put("NumBangKun1",dataMap.get(0).get("NumBangKun1"));
        jsonObject.put("NumBangKun2",dataMap.get(0).get("NumBangKun2"));
        jsonObject.put("NumBangKun3",dataMap.get(0).get("NumBangKun3"));
        Integer NumBangKun4 = Tool.ReturnTendence(dataMap.get(0).get("NumBangKun3"),month1);
        Integer NumBangKun5 = Tool.ReturnTendence(NumChangHu4,month2);
        jsonObject.put("NumBangKun4",NumBangKun4);
        jsonObject.put("NumBangKun5",NumBangKun5);

        jsonObject.put("NumDiBao1",dataMap.get(0).get("NumDiBao1"));
        jsonObject.put("NumDiBao2",dataMap.get(0).get("NumDiBao2"));
        jsonObject.put("NumDiBao3",dataMap.get(0).get("NumDiBao3"));
        Integer NumDiBao4 = Tool.ReturnTendence(dataMap.get(0).get("NumDiBao3"),month1);
        Integer NumDiBao5 = Tool.ReturnTendence(NumDiBao4,month2);
        jsonObject.put("NumDiBao4",NumDiBao4);
        jsonObject.put("NumDiBao5",NumDiBao5);

        jsonObject.put("NumYangLao1",dataMap.get(0).get("NumYangLao1"));
        jsonObject.put("NumYangLao2",dataMap.get(0).get("NumYangLao2"));
        jsonObject.put("NumYangLao3",dataMap.get(0).get("NumYangLao3"));
        Integer NumYangLao4 = Tool.ReturnTendence(dataMap.get(0).get("NumYangLao3"),month1);
        Integer NumYangLao5 = Tool.ReturnTendence(NumYangLao4,month2);
        jsonObject.put("NumYangLao4",NumYangLao4);
        jsonObject.put("NumYangLao5",NumYangLao5);

        jsonObject.put("NumYiLiao1",dataMap.get(0).get("NumYiLiao1"));
        jsonObject.put("NumYiLiao2",dataMap.get(0).get("NumYiLiao2"));
        jsonObject.put("NumYiLiao3",dataMap.get(0).get("NumYiLiao3"));
        Integer NumYiLiao4 = Tool.ReturnTendence(dataMap.get(0).get("NumYiLiao3"),month1);
        Integer NumYiLiao5 = Tool.ReturnTendence(NumYiLiao4,month2);
        jsonObject.put("NumYiLiao4",NumYiLiao4);
        jsonObject.put("NumYiLiao5",NumYiLiao5);

        jsonObject.put("NumChenZhen1",dataMap.get(0).get("NumChenZhen1"));
        jsonObject.put("NumChenZhen2",dataMap.get(0).get("NumChenZhen2"));
        jsonObject.put("NumChenZhen3",dataMap.get(0).get("NumChenZhen3"));
        Integer NumChenZhen4 = Tool.ReturnTendence(dataMap.get(0).get("NumChenZhen3"),month1);
        Integer NumChenZhen5 = Tool.ReturnTendence(NumChenZhen4,month2);
        jsonObject.put("NumChenZhen4",NumChenZhen4);
        jsonObject.put("NumChenZhen5",NumChenZhen5);

        //qushi
        jsonObject.put("NumGuMeiAndHuJiFam",dataMap.get(0).get("NumGuMeiAndHuJiFam"));
        jsonObject.put("NumGuMeiAndFeiHuJiFam",dataMap.get(0).get("NumGuMeiAndFeiHuJiFam"));
        jsonObject.put("NumGuMeiAndMaleFam",dataMap.get(0).get("NumGuMeiAndMaleFam"));
        jsonObject.put("NumGuMeiAndFemaleFam",dataMap.get(0).get("NumGuMeiAndFemaleFam"));
        jsonObject.put("NumGuMeiAnd60To70MFam",dataMap.get(0).get("NumGuMeiAnd60To70MFam"));
        jsonObject.put("NumGuMeiAnd70To80MFam",dataMap.get(0).get("NumGuMeiAnd70To80MFam"));
        jsonObject.put("NumGuMeiAnd80To90MFam",dataMap.get(0).get("NumGuMeiAnd80To90MFam"));
        jsonObject.put("NumGuMeiAnd90AboveMFam",dataMap.get(0).get("NumGuMeiAnd90AboveMFam"));
        jsonObject.put("NumGuMeiAnd60To70FFam",dataMap.get(0).get("NumGuMeiAnd60To70FFam"));
        jsonObject.put("NumGuMeiAnd70To80FFam",dataMap.get(0).get("NumGuMeiAnd70To80FFam"));
        jsonObject.put("NumGuMeiAnd80To90FFam",dataMap.get(0).get("NumGuMeiAnd80To90FFam"));
        jsonObject.put("NumGuMeiAnd90AboveFFam",dataMap.get(0).get("NumGuMeiAnd90AboveFFam"));

        jsonObject.put("NumGuMeiAndHuJiEco",dataMap.get(0).get("NumGuMeiAndHuJiEco"));
        jsonObject.put("NumGuMeiAndFeiHuJiEco",dataMap.get(0).get("NumGuMeiAndFeiHuJiEco"));
        jsonObject.put("NumGuMeiAndMaleEco",dataMap.get(0).get("NumGuMeiAndMaleEco"));
        jsonObject.put("NumGuMeiAndFemaleEco",dataMap.get(0).get("NumGuMeiAndFemaleEco"));
        jsonObject.put("NumGuMeiAnd60To70MEco",dataMap.get(0).get("NumGuMeiAnd60To70MEco"));
        jsonObject.put("NumGuMeiAnd70To80MEco",dataMap.get(0).get("NumGuMeiAnd70To80MEco"));
        jsonObject.put("NumGuMeiAnd80To90MEco",dataMap.get(0).get("NumGuMeiAnd80To90MEco"));
        jsonObject.put("NumGuMeiAnd90AboveMEco",dataMap.get(0).get("NumGuMeiAnd90AboveMEco"));
        jsonObject.put("NumGuMeiAnd60To70FEco",dataMap.get(0).get("NumGuMeiAnd60To70FEco"));
        jsonObject.put("NumGuMeiAnd70To80FEco",dataMap.get(0).get("NumGuMeiAnd70To80FEco"));
        jsonObject.put("NumGuMeiAnd80To90FEco",dataMap.get(0).get("NumGuMeiAnd80To90FEco"));
        jsonObject.put("NumGuMeiAnd90AboveFEco",dataMap.get(0).get("NumGuMeiAnd90AboveFEco"));

        jsonObject.put("NumGuMeiAndHuJiHeal",dataMap.get(0).get("NumGuMeiAndHuJiHeal"));
        jsonObject.put("NumGuMeiAndFeiHuJiHeal",dataMap.get(0).get("NumGuMeiAndFeiHuJiHeal"));
        jsonObject.put("NumGuMeiAndMaleHeal",dataMap.get(0).get("NumGuMeiAndMaleHeal"));
        jsonObject.put("NumGuMeiAndFemaleHeal",dataMap.get(0).get("NumGuMeiAndFemaleHeal"));
        jsonObject.put("NumGuMeiAnd60To70MHeal",dataMap.get(0).get("NumGuMeiAnd60To70MHeal"));
        jsonObject.put("NumGuMeiAnd70To80MHeal",dataMap.get(0).get("NumGuMeiAnd70To80MHeal"));
        jsonObject.put("NumGuMeiAnd80To90MHeal",dataMap.get(0).get("NumGuMeiAnd80To90MHeal"));
        jsonObject.put("NumGuMeiAnd90AboveMHeal",dataMap.get(0).get("NumGuMeiAnd90AboveMHeal"));
        jsonObject.put("NumGuMeiAnd60To70FHeal",dataMap.get(0).get("NumGuMeiAnd60To70FHeal"));
        jsonObject.put("NumGuMeiAnd70To80FHeal",dataMap.get(0).get("NumGuMeiAnd70To80FHeal"));
        jsonObject.put("NumGuMeiAnd80To90FHeal",dataMap.get(0).get("NumGuMeiAnd80To90FHeal"));
        jsonObject.put("NumGuMeiAnd90AboveFHeal",dataMap.get(0).get("NumGuMeiAnd90AboveFHeal"));

        //
        jsonObject.put("NumGuLongAndHuJiFam",dataMap.get(0).get("NumGuLongAndHuJiFam"));
        jsonObject.put("NumGuLongAndFeiHuJiFam",dataMap.get(0).get("NumGuLongAndFeiHuJiFam"));
        jsonObject.put("NumGuLongAndMaleFam",dataMap.get(0).get("NumGuLongAndMaleFam"));
        jsonObject.put("NumGuLongAndFemaleFam",dataMap.get(0).get("NumGuLongAndFemaleFam"));
        jsonObject.put("NumGuLongAnd60To70MFam",dataMap.get(0).get("NumGuLongAnd60To70MFam"));
        jsonObject.put("NumGuLongAnd70To80MFam",dataMap.get(0).get("NumGuLongAnd70To80MFam"));
        jsonObject.put("NumGuLongAnd80To90MFam",dataMap.get(0).get("NumGuLongAnd80To90MFam"));
        jsonObject.put("NumGuLongAnd90AboveMFam",dataMap.get(0).get("NumGuLongAnd90AboveMFam"));
        jsonObject.put("NumGuLongAnd60To70FFam",dataMap.get(0).get("NumGuLongAnd60To70FFam"));
        jsonObject.put("NumGuLongAnd70To80FFam",dataMap.get(0).get("NumGuLongAnd70To80FFam"));
        jsonObject.put("NumGuLongAnd80To90FFam",dataMap.get(0).get("NumGuLongAnd80To90FFam"));
        jsonObject.put("NumGuLongAnd90AboveFFam",dataMap.get(0).get("NumGuLongAnd90AboveFFam"));

        jsonObject.put("NumGuLongAndHuJiEco",dataMap.get(0).get("NumGuLongAndHuJiEco"));
        jsonObject.put("NumGuLongAndFeiHuJiEco",dataMap.get(0).get("NumGuLongAndFeiHuJiEco"));
        jsonObject.put("NumGuLongAndMaleEco",dataMap.get(0).get("NumGuLongAndMaleEco"));
        jsonObject.put("NumGuLongAndFemaleEco",dataMap.get(0).get("NumGuLongAndFemaleEco"));
        jsonObject.put("NumGuLongAnd60To70MEco",dataMap.get(0).get("NumGuLongAnd60To70MEco"));
        jsonObject.put("NumGuLongAnd70To80MEco",dataMap.get(0).get("NumGuLongAnd70To80MEco"));
        jsonObject.put("NumGuLongAnd80To90MEco",dataMap.get(0).get("NumGuLongAnd80To90MEco"));
        jsonObject.put("NumGuLongAnd90AboveMEco",dataMap.get(0).get("NumGuLongAnd90AboveMEco"));
        jsonObject.put("NumGuLongAnd60To70FEco",dataMap.get(0).get("NumGuLongAnd60To70FEco"));
        jsonObject.put("NumGuLongAnd70To80FEco",dataMap.get(0).get("NumGuLongAnd70To80FEco"));
        jsonObject.put("NumGuLongAnd80To90FEco",dataMap.get(0).get("NumGuLongAnd80To90FEco"));
        jsonObject.put("NumGuLongAnd90AboveFEco",dataMap.get(0).get("NumGuLongAnd90AboveFEco"));

        jsonObject.put("NumGuLongAndHuJiHeal",dataMap.get(0).get("NumGuLongAndHuJiHeal"));
        jsonObject.put("NumGuLongAndFeiHuJiHeal",dataMap.get(0).get("NumGuLongAndFeiHuJiHeal"));
        jsonObject.put("NumGuLongAndMaleHeal",dataMap.get(0).get("NumGuLongAndMaleHeal"));
        jsonObject.put("NumGuLongAndFemaleHeal",dataMap.get(0).get("NumGuLongAndFemaleHeal"));
        jsonObject.put("NumGuLongAnd60To70MHeal",dataMap.get(0).get("NumGuLongAnd60To70MHeal"));
        jsonObject.put("NumGuLongAnd70To80MHeal",dataMap.get(0).get("NumGuLongAnd70To80MHeal"));
        jsonObject.put("NumGuLongAnd80To90MHeal",dataMap.get(0).get("NumGuLongAnd80To90MHeal"));
        jsonObject.put("NumGuLongAnd90AboveMHeal",dataMap.get(0).get("NumGuLongAnd90AboveMHeal"));
        jsonObject.put("NumGuLongAnd60To70FHeal",dataMap.get(0).get("NumGuLongAnd60To70FHeal"));
        jsonObject.put("NumGuLongAnd70To80FHeal",dataMap.get(0).get("NumGuLongAnd70To80FHeal"));
        jsonObject.put("NumGuLongAnd80To90FHeal",dataMap.get(0).get("NumGuLongAnd80To90FHeal"));
        jsonObject.put("NumGuLongAnd90AboveFHeal",dataMap.get(0).get("NumGuLongAnd90AboveFHeal"));

        //
        jsonObject.put("NumDongLanAndHuJiFam",dataMap.get(0).get("NumDongLanAndHuJiFam"));
        jsonObject.put("NumDongLanAndFeiHuJiFam",dataMap.get(0).get("NumDongLanAndFeiHuJiFam"));
        jsonObject.put("NumDongLanAndMaleFam",dataMap.get(0).get("NumDongLanAndMaleFam"));
        jsonObject.put("NumDongLanAndFemaleFam",dataMap.get(0).get("NumDongLanAndFemaleFam"));
        jsonObject.put("NumDongLanAnd60To70MFam",dataMap.get(0).get("NumDongLanAnd60To70MFam"));
        jsonObject.put("NumDongLanAnd70To80MFam",dataMap.get(0).get("NumDongLanAnd70To80MFam"));
        jsonObject.put("NumDongLanAnd80To90MFam",dataMap.get(0).get("NumDongLanAnd80To90MFam"));
        jsonObject.put("NumDongLanAnd90AboveMFam",dataMap.get(0).get("NumDongLanAnd90AboveMFam"));
        jsonObject.put("NumDongLanAnd60To70FFam",dataMap.get(0).get("NumDongLanAnd60To70FFam"));
        jsonObject.put("NumDongLanAnd70To80FFam",dataMap.get(0).get("NumDongLanAnd70To80FFam"));
        jsonObject.put("NumDongLanAnd80To90FFam",dataMap.get(0).get("NumDongLanAnd80To90FFam"));
        jsonObject.put("NumDongLanAnd90AboveFFam",dataMap.get(0).get("NumDongLanAnd90AboveFFam"));

        jsonObject.put("NumDongLanAndHuJiEco",dataMap.get(0).get("NumDongLanAndHuJiEco"));
        jsonObject.put("NumDongLanAndFeiHuJiEco",dataMap.get(0).get("NumDongLanAndFeiHuJiEco"));
        jsonObject.put("NumDongLanAndMaleEco",dataMap.get(0).get("NumDongLanAndMaleEco"));
        jsonObject.put("NumDongLanAndFemaleEco",dataMap.get(0).get("NumDongLanAndFemaleEco"));
        jsonObject.put("NumDongLanAnd60To70MEco",dataMap.get(0).get("NumDongLanAnd60To70MEco"));
        jsonObject.put("NumDongLanAnd70To80MEco",dataMap.get(0).get("NumDongLanAnd70To80MEco"));
        jsonObject.put("NumDongLanAnd80To90MEco",dataMap.get(0).get("NumDongLanAnd80To90MEco"));
        jsonObject.put("NumDongLanAnd90AboveMEco",dataMap.get(0).get("NumDongLanAnd90AboveMEco"));
        jsonObject.put("NumDongLanAnd60To70FEco",dataMap.get(0).get("NumDongLanAnd60To70FEco"));
        jsonObject.put("NumDongLanAnd70To80FEco",dataMap.get(0).get("NumDongLanAnd70To80FEco"));
        jsonObject.put("NumDongLanAnd80To90FEco",dataMap.get(0).get("NumDongLanAnd80To90FEco"));
        jsonObject.put("NumDongLanAnd90AboveFEco",dataMap.get(0).get("NumDongLanAnd90AboveFEco"));

        jsonObject.put("NumDongLanAndHuJiHeal",dataMap.get(0).get("NumDongLanAndHuJiHeal"));
        jsonObject.put("NumDongLanAndFeiHuJiHeal",dataMap.get(0).get("NumDongLanAndFeiHuJiHeal"));
        jsonObject.put("NumDongLanAndMaleHeal",dataMap.get(0).get("NumDongLanAndMaleHeal"));
        jsonObject.put("NumDongLanAndFemaleHeal",dataMap.get(0).get("NumDongLanAndFemaleHeal"));
        jsonObject.put("NumDongLanAnd60To70MHeal",dataMap.get(0).get("NumDongLanAnd60To70MHeal"));
        jsonObject.put("NumDongLanAnd70To80MHeal",dataMap.get(0).get("NumDongLanAnd70To80MHeal"));
        jsonObject.put("NumDongLanAnd80To90MHeal",dataMap.get(0).get("NumDongLanAnd80To90MHeal"));
        jsonObject.put("NumDongLanAnd90AboveMHeal",dataMap.get(0).get("NumDongLanAnd90AboveMHeal"));
        jsonObject.put("NumDongLanAnd60To70FHeal",dataMap.get(0).get("NumDongLanAnd60To70FHeal"));
        jsonObject.put("NumDongLanAnd70To80FHeal",dataMap.get(0).get("NumDongLanAnd70To80FHeal"));
        jsonObject.put("NumDongLanAnd80To90FHeal",dataMap.get(0).get("NumDongLanAnd80To90FHeal"));
        jsonObject.put("NumDongLanAnd90AboveFHeal",dataMap.get(0).get("NumDongLanAnd90AboveFHeal"));

        //
        jsonObject.put("NumPingJiAndHuJiFam",dataMap.get(0).get("NumPingJiAndHuJiFam"));
        jsonObject.put("NumPingJiAndFeiHuJiFam",dataMap.get(0).get("NumPingJiAndFeiHuJiFam"));
        jsonObject.put("NumPingJiAndMaleFam",dataMap.get(0).get("NumPingJiAndMaleFam"));
        jsonObject.put("NumPingJiAndFemaleFam",dataMap.get(0).get("NumPingJiAndFemaleFam"));
        jsonObject.put("NumPingJiAnd60To70MFam",dataMap.get(0).get("NumPingJiAnd60To70MFam"));
        jsonObject.put("NumPingJiAnd70To80MFam",dataMap.get(0).get("NumPingJiAnd70To80MFam"));
        jsonObject.put("NumPingJiAnd80To90MFam",dataMap.get(0).get("NumPingJiAnd80To90MFam"));
        jsonObject.put("NumPingJiAnd90AboveMFam",dataMap.get(0).get("NumPingJiAnd90AboveMFam"));
        jsonObject.put("NumPingJiAnd60To70FFam",dataMap.get(0).get("NumPingJiAnd60To70FFam"));
        jsonObject.put("NumPingJiAnd70To80FFam",dataMap.get(0).get("NumPingJiAnd70To80FFam"));
        jsonObject.put("NumPingJiAnd80To90FFam",dataMap.get(0).get("NumPingJiAnd80To90FFam"));
        jsonObject.put("NumPingJiAnd90AboveFFam",dataMap.get(0).get("NumPingJiAnd90AboveFFam"));

        jsonObject.put("NumPingJiAndHuJiEco",dataMap.get(0).get("NumPingJiAndHuJiEco"));
        jsonObject.put("NumPingJiAndFeiHuJiEco",dataMap.get(0).get("NumPingJiAndFeiHuJiEco"));
        jsonObject.put("NumPingJiAndMaleEco",dataMap.get(0).get("NumPingJiAndMaleEco"));
        jsonObject.put("NumPingJiAndFemaleEco",dataMap.get(0).get("NumPingJiAndFemaleEco"));
        jsonObject.put("NumPingJiAnd60To70MEco",dataMap.get(0).get("NumPingJiAnd60To70MEco"));
        jsonObject.put("NumPingJiAnd70To80MEco",dataMap.get(0).get("NumPingJiAnd70To80MEco"));
        jsonObject.put("NumPingJiAnd80To90MEco",dataMap.get(0).get("NumPingJiAnd80To90MEco"));
        jsonObject.put("NumPingJiAnd90AboveMEco",dataMap.get(0).get("NumPingJiAnd90AboveMEco"));
        jsonObject.put("NumPingJiAnd60To70FEco",dataMap.get(0).get("NumPingJiAnd60To70FEco"));
        jsonObject.put("NumPingJiAnd70To80FEco",dataMap.get(0).get("NumPingJiAnd70To80FEco"));
        jsonObject.put("NumPingJiAnd80To90FEco",dataMap.get(0).get("NumPingJiAnd80To90FEco"));
        jsonObject.put("NumPingJiAnd90AboveFEco",dataMap.get(0).get("NumPingJiAnd90AboveFEco"));

        jsonObject.put("NumPingJiAndHuJiHeal",dataMap.get(0).get("NumPingJiAndHuJiHeal"));
        jsonObject.put("NumPingJiAndFeiHuJiHeal",dataMap.get(0).get("NumPingJiAndFeiHuJiHeal"));
        jsonObject.put("NumPingJiAndMaleHeal",dataMap.get(0).get("NumPingJiAndMaleHeal"));
        jsonObject.put("NumPingJiAndFemaleHeal",dataMap.get(0).get("NumPingJiAndFemaleHeal"));
        jsonObject.put("NumPingJiAnd60To70MHeal",dataMap.get(0).get("NumPingJiAnd60To70MHeal"));
        jsonObject.put("NumPingJiAnd70To80MHeal",dataMap.get(0).get("NumPingJiAnd70To80MHeal"));
        jsonObject.put("NumPingJiAnd80To90MHeal",dataMap.get(0).get("NumPingJiAnd80To90MHeal"));
        jsonObject.put("NumPingJiAnd90AboveMHeal",dataMap.get(0).get("NumPingJiAnd90AboveMHeal"));
        jsonObject.put("NumPingJiAnd60To70FHeal",dataMap.get(0).get("NumPingJiAnd60To70FHeal"));
        jsonObject.put("NumPingJiAnd70To80FHeal",dataMap.get(0).get("NumPingJiAnd70To80FHeal"));
        jsonObject.put("NumPingJiAnd80To90FHeal",dataMap.get(0).get("NumPingJiAnd80To90FHeal"));
        jsonObject.put("NumPingJiAnd90AboveFHeal",dataMap.get(0).get("NumPingJiAnd90AboveFHeal"));

        //
        jsonObject.put("NumPingYangAndHuJiFam",dataMap.get(0).get("NumPingYangAndHuJiFam"));
        jsonObject.put("NumPingYangAndFeiHuJiFam",dataMap.get(0).get("NumPingYangAndFeiHuJiFam"));
        jsonObject.put("NumPingYangAndMaleFam",dataMap.get(0).get("NumPingYangAndMaleFam"));
        jsonObject.put("NumPingYangAndFemaleFam",dataMap.get(0).get("NumPingYangAndFemaleFam"));
        jsonObject.put("NumPingYangAnd60To70MFam",dataMap.get(0).get("NumPingYangAnd60To70MFam"));
        jsonObject.put("NumPingYangAnd70To80MFam",dataMap.get(0).get("NumPingYangAnd70To80MFam"));
        jsonObject.put("NumPingYangAnd80To90MFam",dataMap.get(0).get("NumPingYangAnd80To90MFam"));
        jsonObject.put("NumPingYangAnd90AboveMFam",dataMap.get(0).get("NumPingYangAnd90AboveMFam"));
        jsonObject.put("NumPingYangAnd60To70FFam",dataMap.get(0).get("NumPingYangAnd60To70FFam"));
        jsonObject.put("NumPingYangAnd70To80FFam",dataMap.get(0).get("NumPingYangAnd70To80FFam"));
        jsonObject.put("NumPingYangAnd80To90FFam",dataMap.get(0).get("NumPingYangAnd80To90FFam"));
        jsonObject.put("NumPingYangAnd90AboveFFam",dataMap.get(0).get("NumPingYangAnd90AboveFFam"));

        jsonObject.put("NumPingYangAndHuJiEco",dataMap.get(0).get("NumPingYangAndHuJiEco"));
        jsonObject.put("NumPingYangAndFeiHuJiEco",dataMap.get(0).get("NumPingYangAndFeiHuJiEco"));
        jsonObject.put("NumPingYangAndMaleEco",dataMap.get(0).get("NumPingYangAndMaleEco"));
        jsonObject.put("NumPingYangAndFemaleEco",dataMap.get(0).get("NumPingYangAndFemaleEco"));
        jsonObject.put("NumPingYangAnd60To70MEco",dataMap.get(0).get("NumPingYangAnd60To70MEco"));
        jsonObject.put("NumPingYangAnd70To80MEco",dataMap.get(0).get("NumPingYangAnd70To80MEco"));
        jsonObject.put("NumPingYangAnd80To90MEco",dataMap.get(0).get("NumPingYangAnd80To90MEco"));
        jsonObject.put("NumPingYangAnd90AboveMEco",dataMap.get(0).get("NumPingYangAnd90AboveMEco"));
        jsonObject.put("NumPingYangAnd60To70FEco",dataMap.get(0).get("NumPingYangAnd60To70FEco"));
        jsonObject.put("NumPingYangAnd70To80FEco",dataMap.get(0).get("NumPingYangAnd70To80FEco"));
        jsonObject.put("NumPingYangAnd80To90FEco",dataMap.get(0).get("NumPingYangAnd80To90FEco"));
        jsonObject.put("NumPingYangAnd90AboveFEco",dataMap.get(0).get("NumPingYangAnd90AboveFEco"));

        jsonObject.put("NumPingYangAndHuJiHeal",dataMap.get(0).get("NumPingYangAndHuJiHeal"));
        jsonObject.put("NumPingYangAndFeiHuJiHeal",dataMap.get(0).get("NumPingYangAndFeiHuJiHeal"));
        jsonObject.put("NumPingYangAndMaleHeal",dataMap.get(0).get("NumPingYangAndMaleHeal"));
        jsonObject.put("NumPingYangAndFemaleHeal",dataMap.get(0).get("NumPingYangAndFemaleHeal"));
        jsonObject.put("NumPingYangAnd60To70MHeal",dataMap.get(0).get("NumPingYangAnd60To70MHeal"));
        jsonObject.put("NumPingYangAnd70To80MHeal",dataMap.get(0).get("NumPingYangAnd70To80MHeal"));
        jsonObject.put("NumPingYangAnd80To90MHeal",dataMap.get(0).get("NumPingYangAnd80To90MHeal"));
        jsonObject.put("NumPingYangAnd90AboveMHeal",dataMap.get(0).get("NumPingYangAnd90AboveMHeal"));
        jsonObject.put("NumPingYangAnd60To70FHeal",dataMap.get(0).get("NumPingYangAnd60To70FHeal"));
        jsonObject.put("NumPingYangAnd70To80FHeal",dataMap.get(0).get("NumPingYangAnd70To80FHeal"));
        jsonObject.put("NumPingYangAnd80To90FHeal",dataMap.get(0).get("NumPingYangAnd80To90FHeal"));
        jsonObject.put("NumPingYangAnd90AboveFHeal",dataMap.get(0).get("NumPingYangAnd90AboveFHeal"));

        //
        jsonObject.put("NumPingNanAndHuJiFam",dataMap.get(0).get("NumPingNanAndHuJiFam"));
        jsonObject.put("NumPingNanAndFeiHuJiFam",dataMap.get(0).get("NumPingNanAndFeiHuJiFam"));
        jsonObject.put("NumPingNanAndMaleFam",dataMap.get(0).get("NumPingNanAndMaleFam"));
        jsonObject.put("NumPingNanAndFemaleFam",dataMap.get(0).get("NumPingNanAndFemaleFam"));
        jsonObject.put("NumPingNanAnd60To70MFam",dataMap.get(0).get("NumPingNanAnd60To70MFam"));
        jsonObject.put("NumPingNanAnd70To80MFam",dataMap.get(0).get("NumPingNanAnd70To80MFam"));
        jsonObject.put("NumPingNanAnd80To90MFam",dataMap.get(0).get("NumPingNanAnd80To90MFam"));
        jsonObject.put("NumPingNanAnd90AboveMFam",dataMap.get(0).get("NumPingNanAnd90AboveMFam"));
        jsonObject.put("NumPingNanAnd60To70FFam",dataMap.get(0).get("NumPingNanAnd60To70FFam"));
        jsonObject.put("NumPingNanAnd70To80FFam",dataMap.get(0).get("NumPingNanAnd70To80FFam"));
        jsonObject.put("NumPingNanAnd80To90FFam",dataMap.get(0).get("NumPingNanAnd80To90FFam"));
        jsonObject.put("NumPingNanAnd90AboveFFam",dataMap.get(0).get("NumPingNanAnd90AboveFFam"));

        jsonObject.put("NumPingNanAndHuJiEco",dataMap.get(0).get("NumPingNanAndHuJiEco"));
        jsonObject.put("NumPingNanAndFeiHuJiEco",dataMap.get(0).get("NumPingNanAndFeiHuJiEco"));
        jsonObject.put("NumPingNanAndMaleEco",dataMap.get(0).get("NumPingNanAndMaleEco"));
        jsonObject.put("NumPingNanAndFemaleEco",dataMap.get(0).get("NumPingNanAndFemaleEco"));
        jsonObject.put("NumPingNanAnd60To70MEco",dataMap.get(0).get("NumPingNanAnd60To70MEco"));
        jsonObject.put("NumPingNanAnd70To80MEco",dataMap.get(0).get("NumPingNanAnd70To80MEco"));
        jsonObject.put("NumPingNanAnd80To90MEco",dataMap.get(0).get("NumPingNanAnd80To90MEco"));
        jsonObject.put("NumPingNanAnd90AboveMEco",dataMap.get(0).get("NumPingNanAnd90AboveMEco"));
        jsonObject.put("NumPingNanAnd60To70FEco",dataMap.get(0).get("NumPingNanAnd60To70FEco"));
        jsonObject.put("NumPingNanAnd70To80FEco",dataMap.get(0).get("NumPingNanAnd70To80FEco"));
        jsonObject.put("NumPingNanAnd80To90FEco",dataMap.get(0).get("NumPingNanAnd80To90FEco"));
        jsonObject.put("NumPingNanAnd90AboveFEco",dataMap.get(0).get("NumPingNanAnd90AboveFEco"));

        jsonObject.put("NumPingNanAndHuJiHeal",dataMap.get(0).get("NumPingNanAndHuJiHeal"));
        jsonObject.put("NumPingNanAndFeiHuJiHeal",dataMap.get(0).get("NumPingNanAndFeiHuJiHeal"));
        jsonObject.put("NumPingNanAndMaleHeal",dataMap.get(0).get("NumPingNanAndMaleHeal"));
        jsonObject.put("NumPingNanAndFemaleHeal",dataMap.get(0).get("NumPingNanAndFemaleHeal"));
        jsonObject.put("NumPingNanAnd60To70MHeal",dataMap.get(0).get("NumPingNanAnd60To70MHeal"));
        jsonObject.put("NumPingNanAnd70To80MHeal",dataMap.get(0).get("NumPingNanAnd70To80MHeal"));
        jsonObject.put("NumPingNanAnd80To90MHeal",dataMap.get(0).get("NumPingNanAnd80To90MHeal"));
        jsonObject.put("NumPingNanAnd90AboveMHeal",dataMap.get(0).get("NumPingNanAnd90AboveMHeal"));
        jsonObject.put("NumPingNanAnd60To70FHeal",dataMap.get(0).get("NumPingNanAnd60To70FHeal"));
        jsonObject.put("NumPingNanAnd70To80FHeal",dataMap.get(0).get("NumPingNanAnd70To80FHeal"));
        jsonObject.put("NumPingNanAnd80To90FHeal",dataMap.get(0).get("NumPingNanAnd80To90FHeal"));
        jsonObject.put("NumPingNanAnd90AboveFHeal",dataMap.get(0).get("NumPingNanAnd90AboveFHeal"));

        //allqushi
        jsonObject.put("NumAllAndHuJiFam",dataMap.get(0).get("NumAllAndHuJiFam"));
        jsonObject.put("NumAllAndFeiHuJiFam",dataMap.get(0).get("NumAllAndFeiHuJiFam"));
        jsonObject.put("NumAllAndMaleFam",dataMap.get(0).get("NumAllAndMaleFam"));
        jsonObject.put("NumAllAndFemaleFam",dataMap.get(0).get("NumAllAndFemaleFam"));
        jsonObject.put("NumAllAnd60To70MFam",dataMap.get(0).get("NumAllAnd60To70MFam"));
        jsonObject.put("NumAllAnd70To80MFam",dataMap.get(0).get("NumAllAnd70To80MFam"));
        jsonObject.put("NumAllAnd80To90MFam",dataMap.get(0).get("NumAllAnd80To90MFam"));
        jsonObject.put("NumAllAnd90AboveMFam",dataMap.get(0).get("NumAllAnd90AboveMFam"));
        jsonObject.put("NumAllAnd60To70FFam",dataMap.get(0).get("NumAllAnd60To70FFam"));
        jsonObject.put("NumAllAnd70To80FFam",dataMap.get(0).get("NumAllAnd70To80FFam"));
        jsonObject.put("NumAllAnd80To90FFam",dataMap.get(0).get("NumAllAnd80To90FFam"));
        jsonObject.put("NumAllAnd90AboveFFam",dataMap.get(0).get("NumAllAnd90AboveFFam"));

        jsonObject.put("NumAllAndHuJiEco",dataMap.get(0).get("NumAllAndHuJiEco"));
        jsonObject.put("NumAllAndFeiHuJiEco",dataMap.get(0).get("NumAllAndFeiHuJiEco"));
        jsonObject.put("NumAllAndMaleEco",dataMap.get(0).get("NumAllAndMaleEco"));
        jsonObject.put("NumAllAndFemaleEco",dataMap.get(0).get("NumAllAndFemaleEco"));
        jsonObject.put("NumAllAnd60To70MEco",dataMap.get(0).get("NumAllAnd60To70MEco"));
        jsonObject.put("NumAllAnd70To80MEco",dataMap.get(0).get("NumAllAnd70To80MEco"));
        jsonObject.put("NumAllAnd80To90MEco",dataMap.get(0).get("NumAllAnd80To90MEco"));
        jsonObject.put("NumAllAnd90AboveMEco",dataMap.get(0).get("NumAllAnd90AboveMEco"));
        jsonObject.put("NumAllAnd60To70FEco",dataMap.get(0).get("NumAllAnd60To70FEco"));
        jsonObject.put("NumAllAnd70To80FEco",dataMap.get(0).get("NumAllAnd70To80FEco"));
        jsonObject.put("NumAllAnd80To90FEco",dataMap.get(0).get("NumAllAnd80To90FEco"));
        jsonObject.put("NumAllAnd90AboveFEco",dataMap.get(0).get("NumAllAnd90AboveFEco"));

        jsonObject.put("NumAllAndHuJiHeal",dataMap.get(0).get("NumAllAndHuJiHeal"));
        jsonObject.put("NumAllAndFeiHuJiHeal",dataMap.get(0).get("NumAllAndFeiHuJiHeal"));
        jsonObject.put("NumAllAndMaleHeal",dataMap.get(0).get("NumAllAndMaleHeal"));
        jsonObject.put("NumAllAndFemaleHeal",dataMap.get(0).get("NumAllAndFemaleHeal"));
        jsonObject.put("NumAllAnd60To70MHeal",dataMap.get(0).get("NumAllAnd60To70MHeal"));
        jsonObject.put("NumAllAnd70To80MHeal",dataMap.get(0).get("NumAllAnd70To80MHeal"));
        jsonObject.put("NumAllAnd80To90MHeal",dataMap.get(0).get("NumAllAnd80To90MHeal"));
        jsonObject.put("NumAllAnd90AboveMHeal",dataMap.get(0).get("NumAllAnd90AboveMHeal"));
        jsonObject.put("NumAllAnd60To70FHeal",dataMap.get(0).get("NumAllAnd60To70FHeal"));
        jsonObject.put("NumAllAnd70To80FHeal",dataMap.get(0).get("NumAllAnd70To80FHeal"));
        jsonObject.put("NumAllAnd80To90FHeal",dataMap.get(0).get("NumAllAnd80To90FHeal"));
        jsonObject.put("NumAllAnd90AboveFHeal",dataMap.get(0).get("NumAllAnd90AboveFHeal"));

        jsonObject.put("NumGuMei",dataMap.get(0).get("NumGuMei"));
        jsonObject.put("NumDongLan",dataMap.get(0).get("NumDongLan"));
        jsonObject.put("NumGuLong",dataMap.get(0).get("NumGuLong"));
        jsonObject.put("NumPingNan",dataMap.get(0).get("NumPingNan"));
        jsonObject.put("NumPingJi",dataMap.get(0).get("NumPingJi"));
        jsonObject.put("NumPingYang",dataMap.get(0).get("NumPingYang"));

        Result result =new Result(true,jsonObject);
        return result;

    }

    //update visual data
    @RequestMapping(value = "/updateVisualData",method = RequestMethod.GET)
    public void updateVisualData(){
        Date nowDate = new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(nowDate);

        String date=cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH);
        oldmanService.deleteOldVisualData();
        oldmanService.updateVisualData(getNowYearAndMonth());


    }

//    private Integer Tool.Tool.Tool.Tool.ReturnTendence(Integer size,double[] Increase,int month){
//        double temp =size * (Increase[month] * ValueConstant.Oldman_Inreasement + 1);
//        Integer tendence = (new Double(temp)).IntegerValue();
//        return tendence;
//    }
//    public Integer Tool.Tool.Tool.ReturnTendence1(Integer size,double[] Increase,int month){
//        double temp =size * (Increase[month] * ValueConstant.Oldman_Inreasement * 20 * 0.9   + 1) ;
//        Integer tendence = (new Double(temp)).IntegerValue();
//        return tendence;
//    }
//    public Integer Tool.Tool.Tool.ReturnTendence2(Integer size,double[] Increase,int month){
//        double temp =size * (Increase[month] * ValueConstant.Oldman_Inreasement * 20 * 0.7  + 1)  ;
//        Integer tendence = (new Double(temp)).IntegerValue();
//        return tendence;
//    }
//
//    public Integer Tool.Tool.Tool.ReturnTendence3(Integer size,double[] Increase,int month){
//        double temp =size * (Increase[month] * ValueConstant.Oldman_Inreasement * 20 * 0.5  + 1) ;
//        Integer tendence = (new Double(temp)).IntegerValue();
//        return tendence;
//    }




}
