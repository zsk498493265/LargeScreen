package com.organOld.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.organOld.visualService.service.model.OldmanService;
import com.organOld.visualService.service.model.Result;
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

/**
 * 可视化 数据
 * Created by netlab606 on 2018/6/25.
 */
@Controller
@RequestMapping("/visual/data")
public class VisualDataApartController {
    @Autowired
    OldmanService oldmanService;
//分页数据
    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartFinish",method = RequestMethod.GET)
    public Result admin_getOldNum60() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartFinish(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();
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

        //wcd
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
        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartOldman",method = RequestMethod.GET)
    public Result admin_getOldNum601() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartOldman(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NumOld",dataMap.get(0).get("NumOld"));
        jsonObject.put("NumAll",dataMap.get(0).get("NumAll"));
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

        jsonObject.put("NumChunLao",dataMap.get(0).get("NumChunLao"));
        jsonObject.put("NumDuJu",dataMap.get(0).get("NumDuJu"));
        jsonObject.put("NumShiDu",dataMap.get(0).get("NumShiDu"));
        jsonObject.put("NumYiLaoYYL",dataMap.get(0).get("NumYiLaoYYL"));
        jsonObject.put("NumGuLao",dataMap.get(0).get("NumGuLao"));
        jsonObject.put("NumSanZhiRY",dataMap.get(0).get("NumSanZhiRY"));
        jsonObject.put("NumQiTaFamily",dataMap.get(0).get("NumQiTaFamily"));

        jsonObject.put("NumJieDaoPeople",dataMap.get(0).get("NumJieDaoPeople"));
        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartTotal",method = RequestMethod.GET)
    public Result admin_getOldNum603() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartTotal(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NumOld",dataMap.get(0).get("NumOld"));
        jsonObject.put("NumAll",dataMap.get(0).get("NumAll"));
        jsonObject.put("NumOld60",dataMap.get(0).get("NumOld60"));
        jsonObject.put("NumOld80",dataMap.get(0).get("NumOld80"));

        jsonObject.put("NumOrganOld",dataMap.get(0).get("NumOrganOld"));
        jsonObject.put("NumCommunityOld",dataMap.get(0).get("NumCommunityOld"));
        jsonObject.put("NumFamilyOld",dataMap.get(0).get("NumFamilyOld"));

        jsonObject.put("NumGuMeiAnd80Above",dataMap.get(0).get("NumGuMeiAnd80Above"));
        jsonObject.put("NumGuMeiAnd60To80",dataMap.get(0).get("NumGuMeiAnd60To80"));
        jsonObject.put("NumGuMeiAnd60Above",dataMap.get(0).get("NumGuMeiAnd60Above"));
        jsonObject.put("NumGuMeiAnd60Below",dataMap.get(0).get("NumGuMeiAnd60Below"));
        jsonObject.put("NumGuMeiAndOrganOld",dataMap.get(0).get("NumGuMeiAndOrganOld"));
        jsonObject.put("NumGuMeiAndCommunityOld",dataMap.get(0).get("NumGuMeiAndCommunityOld"));
        jsonObject.put("NumGuMeiAndFamilyOld",dataMap.get(0).get("NumGuMeiAndFamilyOld"));

        jsonObject.put("NumGuLongAnd80Above",dataMap.get(0).get("NumGuLongAnd80Above"));
        jsonObject.put("NumGuLongAnd60To80",dataMap.get(0).get("NumGuLongAnd60To80"));
        jsonObject.put("NumGuLongAnd60Above",dataMap.get(0).get("NumGuLongAnd60Above"));
        jsonObject.put("NumGuLongAnd60Below",dataMap.get(0).get("NumGuLongAnd60Below"));
        jsonObject.put("NumGuLongAndOrganOld",dataMap.get(0).get("NumGuLongAndOrganOld"));
        jsonObject.put("NumGuLongAndCommunityOld",dataMap.get(0).get("NumGuLongAndCommunityOld"));
        jsonObject.put("NumGuLongAndFamilyOld",dataMap.get(0).get("NumGuLongAndFamilyOld"));

        jsonObject.put("NumDongLanAnd80Above",dataMap.get(0).get("NumDongLanAnd80Above"));
        jsonObject.put("NumDongLanAnd60To80",dataMap.get(0).get("NumDongLanAnd60To80"));
        jsonObject.put("NumDongLanAnd60Above",dataMap.get(0).get("NumDongLanAnd60Above"));
        jsonObject.put("NumDongLanAnd60Below",dataMap.get(0).get("NumDongLanAnd60Below"));
        jsonObject.put("NumDongLanAndOrganOld",dataMap.get(0).get("NumDongLanAndOrganOld"));
        jsonObject.put("NumDongLanAndCommunityOld",dataMap.get(0).get("NumDongLanAndCommunityOld"));
        jsonObject.put("NumDongLanAndFamilyOld",dataMap.get(0).get("NumDongLanAndFamilyOld"));

        jsonObject.put("NumPingJiAnd80Above",dataMap.get(0).get("NumPingJiAnd80Above"));
        jsonObject.put("NumPingJiAnd60To80",dataMap.get(0).get("NumPingJiAnd60To80"));
        jsonObject.put("NumPingJiAnd60Above",dataMap.get(0).get("NumPingJiAnd60Above"));
        jsonObject.put("NumPingJiAnd60Below",dataMap.get(0).get("NumPingJiAnd60Below"));
        jsonObject.put("NumPingJiAndOrganOld",dataMap.get(0).get("NumPingJiAndOrganOld"));
        jsonObject.put("NumPingJiAndCommunityOld",dataMap.get(0).get("NumPingJiAndCommunityOld"));
        jsonObject.put("NumPingJiAndFamilyOld",dataMap.get(0).get("NumPingJiAndFamilyOld"));

        jsonObject.put("NumPingYangAnd80Above",dataMap.get(0).get("NumPingYangAnd80Above"));
        jsonObject.put("NumPingYangAnd60To80",dataMap.get(0).get("NumPingYangAnd60To80"));
        jsonObject.put("NumPingYangAnd60Above",dataMap.get(0).get("NumPingYangAnd60Above"));
        jsonObject.put("NumPingYangAnd60Below",dataMap.get(0).get("NumPingYangAnd60Below"));
        jsonObject.put("NumPingYangAndOrganOld",dataMap.get(0).get("NumPingYangAndOrganOld"));
        jsonObject.put("NumPingYangAndCommunityOld",dataMap.get(0).get("NumPingYangAndCommunityOld"));
        jsonObject.put("NumPingYangAndFamilyOld",dataMap.get(0).get("NumPingYangAndFamilyOld"));

        jsonObject.put("NumPingNanAnd80Above",dataMap.get(0).get("NumPingNanAnd80Above"));
        jsonObject.put("NumPingNanAnd60To80",dataMap.get(0).get("NumPingNanAnd60To80"));
        jsonObject.put("NumPingNanAnd60Above",dataMap.get(0).get("NumPingNanAnd60Above"));
        jsonObject.put("NumPingNanAnd60Below",dataMap.get(0).get("NumPingNanAnd60Below"));
        jsonObject.put("NumPingNanAndOrganOld",dataMap.get(0).get("NumPingNanAndOrganOld"));
        jsonObject.put("NumPingNanAndCommunityOld",dataMap.get(0).get("NumPingNanAndCommunityOld"));
        jsonObject.put("NumPingNanAndFamilyOld",dataMap.get(0).get("NumPingNanAndFamilyOld"));

        jsonObject.put("NumGuMei",dataMap.get(0).get("NumGuMei"));
        jsonObject.put("NumGuLong",dataMap.get(0).get("NumGuLong"));
        jsonObject.put("NumPingJi",dataMap.get(0).get("NumPingJi"));
        jsonObject.put("NumPingYang",dataMap.get(0).get("NumPingYang"));
        jsonObject.put("NumPingNan",dataMap.get(0).get("NumPingNan"));
        jsonObject.put("NumDongLan",dataMap.get(0).get("NumDongLan"));

        jsonObject.put("NumJieDaoPeople",dataMap.get(0).get("NumJieDaoPeople"));






        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartOrgan",method = RequestMethod.GET)
    public Result admin_getOldNum604() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartOrgan(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NumOld",dataMap.get(0).get("NumOld"));
        jsonObject.put("NumAll",dataMap.get(0).get("NumAll"));


        jsonObject.put("NumOrganOld",dataMap.get(0).get("NumOrganOld"));
        jsonObject.put("NumFamilyOld",dataMap.get(0).get("NumFamilyOld"));
        jsonObject.put("NumCommunityOld",dataMap.get(0).get("NumCommunityOld"));

        jsonObject.put("NumSqJjOld",dataMap.get(0).get("NumSqJjOld"));
        jsonObject.put("NumSqJjOldOnly",dataMap.get(0).get("NumSqJjOldOnly"));
        jsonObject.put("NumOrgGuMei",dataMap.get(0).get("NumOrgGuMei"));
        jsonObject.put("NumOrgPingYang",dataMap.get(0).get("NumOrgPingYang"));
        jsonObject.put("NumOrgDongLan",dataMap.get(0).get("NumOrgDongLan"));

        jsonObject.put("NumJieDaoPeople",dataMap.get(0).get("NumJieDaoPeople"));

        jsonObject.put("NumPingYangJLLive",dataMap.get(0).get("NumPingYangJLLive"));
        jsonObject.put("NumGuMeiJLLive",dataMap.get(0).get("NumGuMeiJLLive"));
        jsonObject.put("NumLianHuaJLLive",dataMap.get(0).get("NumLianHuaJLLive"));

        jsonObject.put("NumZhiHuiZZLive",dataMap.get(0).get("NumZhiHuiZZLive"));
        jsonObject.put("NumFuWu",dataMap.get(0).get("NumFuWu"));
        jsonObject.put("NumZhiNeng",dataMap.get(0).get("NumZhiNeng"));
        jsonObject.put("NumYiSheng",dataMap.get(0).get("NumYiSheng"));
        jsonObject.put("NumBingChuang",dataMap.get(0).get("NumBingChuang"));
        jsonObject.put("NumChangHu",dataMap.get(0).get("NumChangHu"));







        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartFamily",method = RequestMethod.GET)
    public Result admin_getOldNum605() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartFamily(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NumOld",dataMap.get(0).get("NumOld"));
        jsonObject.put("NumAll",dataMap.get(0).get("NumAll"));


        jsonObject.put("NumOrganOld",dataMap.get(0).get("NumOrganOld"));
        jsonObject.put("NumFamilyOld",dataMap.get(0).get("NumFamilyOld"));
        jsonObject.put("NumOrganOld",dataMap.get(0).get("NumOrganOld"));

        jsonObject.put("NumChunLao",dataMap.get(0).get("NumChunLao"));
        jsonObject.put("NumDuJu",dataMap.get(0).get("NumDuJu"));
        jsonObject.put("NumShiDu",dataMap.get(0).get("NumShiDu"));
        jsonObject.put("NumYiLaoYYL",dataMap.get(0).get("NumYiLaoYYL"));
        jsonObject.put("NumGuLao",dataMap.get(0).get("NumGuLao"));
        jsonObject.put("NumSanZhiRY",dataMap.get(0).get("NumSanZhiRY"));
        jsonObject.put("NumQiTaFamily",dataMap.get(0).get("NumQiTaFamily"));

        jsonObject.put("NumHuJi",dataMap.get(0).get("NumHuJi"));
        jsonObject.put("NumFeiHuJi",dataMap.get(0).get("NumFeiHuJi"));
        jsonObject.put("NumMale",dataMap.get(0).get("NumMale"));
        jsonObject.put("NumFemale",dataMap.get(0).get("NumFemale"));


        jsonObject.put("Num60To70M",dataMap.get(0).get("Num60To70M"));
        jsonObject.put("Num70To80M",dataMap.get(0).get("Num70To80M"));
        jsonObject.put("Num80To90M",dataMap.get(0).get("Num80To90M"));
        jsonObject.put("NumAbove90M",dataMap.get(0).get("NumAbove90M"));
        jsonObject.put("Num60To70F",dataMap.get(0).get("Num60To70F"));
        jsonObject.put("Num70To80F",dataMap.get(0).get("Num70To80F"));
        jsonObject.put("Num80To90F",dataMap.get(0).get("Num80To90F"));
        jsonObject.put("NumAbove90F",dataMap.get(0).get("NumAbove90F"));

        jsonObject.put("NumChunLaoAndHuJi",dataMap.get(0).get("NumChunLaoAndHuJi"));
        jsonObject.put("NumChunLaoAndFeiHuJi",dataMap.get(0).get("NumChunLaoAndFeiHuJi"));
        jsonObject.put("NumChunLaoAndMale",dataMap.get(0).get("NumChunLaoAndMale"));
        jsonObject.put("NumChunLaoAndFemale",dataMap.get(0).get("NumChunLaoAndFemale"));
        jsonObject.put("NumChunLaoAnd60To70M",dataMap.get(0).get("NumChunLaoAnd60To70M"));
        jsonObject.put("NumChunLaoAnd70To80M",dataMap.get(0).get("NumChunLaoAnd70To80M"));
        jsonObject.put("NumChunLaoAnd80To90M",dataMap.get(0).get("NumChunLaoAnd80To90M"));
        jsonObject.put("NumChunLaoAnd90AboveM",dataMap.get(0).get("NumChunLaoAnd90AboveM"));
        jsonObject.put("NumChunLaoAnd60To70F",dataMap.get(0).get("NumChunLaoAnd60To70F"));
        jsonObject.put("NumChunLaoAnd70To80F",dataMap.get(0).get("NumChunLaoAnd70To80F"));
        jsonObject.put("NumChunLaoAnd80To90F",dataMap.get(0).get("NumChunLaoAnd80To90F"));
        jsonObject.put("NumChunLaoAnd90AboveF",dataMap.get(0).get("NumChunLaoAnd90AboveF"));

        jsonObject.put("NumDuJuAndHuJi",dataMap.get(0).get("NumDuJuAndHuJi"));
        jsonObject.put("NumDuJuAndFeiHuJi",dataMap.get(0).get("NumDuJuAndFeiHuJi"));
        jsonObject.put("NumDuJuAndMale",dataMap.get(0).get("NumDuJuAndMale"));
        jsonObject.put("NumDuJuAndFemale",dataMap.get(0).get("NumDuJuAndFemale"));
        jsonObject.put("NumDuJuAnd60To70M",dataMap.get(0).get("NumDuJuAnd60To70M"));
        jsonObject.put("NumDuJuAnd70To80M",dataMap.get(0).get("NumDuJuAnd70To80M"));
        jsonObject.put("NumDuJuAnd80To90M",dataMap.get(0).get("NumDuJuAnd80To90M"));
        jsonObject.put("NumDuJuAnd90AboveM",dataMap.get(0).get("NumDuJuAnd90AboveM"));
        jsonObject.put("NumDuJuAnd60To70F",dataMap.get(0).get("NumDuJuAnd60To70F"));
        jsonObject.put("NumDuJuAnd70To80F",dataMap.get(0).get("NumDuJuAnd70To80F"));
        jsonObject.put("NumDuJuAnd80To90F",dataMap.get(0).get("NumDuJuAnd80To90F"));
        jsonObject.put("NumDuJuAnd90AboveF",dataMap.get(0).get("NumDuJuAnd90AboveF"));

        jsonObject.put("NumShiDuAndHuJi",dataMap.get(0).get("NumShiDuAndHuJi"));
        jsonObject.put("NumShiDuAndFeiHuJi",dataMap.get(0).get("NumShiDuAndFeiHuJi"));
        jsonObject.put("NumShiDuAndMale",dataMap.get(0).get("NumShiDuAndMale"));
        jsonObject.put("NumShiDuAndFemale",dataMap.get(0).get("NumShiDuAndFemale"));
        jsonObject.put("NumShiDuAnd60To70M",dataMap.get(0).get("NumShiDuAnd60To70M"));
        jsonObject.put("NumShiDuAnd70To80M",dataMap.get(0).get("NumShiDuAnd70To80M"));
        jsonObject.put("NumShiDuAnd80To90M",dataMap.get(0).get("NumShiDuAnd80To90M"));
        jsonObject.put("NumShiDuAnd90AboveM",dataMap.get(0).get("NumShiDuAnd90AboveM"));
        jsonObject.put("NumShiDuAnd60To70F",dataMap.get(0).get("NumShiDuAnd60To70F"));
        jsonObject.put("NumShiDuAnd70To80F",dataMap.get(0).get("NumShiDuAnd70To80F"));
        jsonObject.put("NumShiDuAnd80To90F",dataMap.get(0).get("NumShiDuAnd80To90F"));
        jsonObject.put("NumShiDuAnd90AboveF",dataMap.get(0).get("NumShiDuAnd90AboveF"));

        jsonObject.put("NumYiLaoAndHuJi",dataMap.get(0).get("NumYiLaoAndHuJi"));
        jsonObject.put("NumYiLaoAndFeiHuJi",dataMap.get(0).get("NumYiLaoAndFeiHuJi"));
        jsonObject.put("NumYiLaoAndMale",dataMap.get(0).get("NumYiLaoAndMale"));
        jsonObject.put("NumYiLaoAndFemale",dataMap.get(0).get("NumYiLaoAndFemale"));
        jsonObject.put("NumYiLaoAnd60To70M",dataMap.get(0).get("NumYiLaoAnd60To70M"));
        jsonObject.put("NumYiLaoAnd70To80M",dataMap.get(0).get("NumYiLaoAnd70To80M"));
        jsonObject.put("NumYiLaoAnd80To90M",dataMap.get(0).get("NumYiLaoAnd80To90M"));
        jsonObject.put("NumYiLaoAnd90AboveM",dataMap.get(0).get("NumYiLaoAnd90AboveM"));
        jsonObject.put("NumYiLaoAnd60To70F",dataMap.get(0).get("NumYiLaoAnd60To70F"));
        jsonObject.put("NumYiLaoAnd70To80F",dataMap.get(0).get("NumYiLaoAnd70To80F"));
        jsonObject.put("NumYiLaoAnd80To90F",dataMap.get(0).get("NumYiLaoAnd80To90F"));
        jsonObject.put("NumYiLaoAnd90AboveF",dataMap.get(0).get("NumYiLaoAnd90AboveF"));

        jsonObject.put("NumGuLaoAndHuJi",dataMap.get(0).get("NumGuLaoAndHuJi"));
        jsonObject.put("NumGuLaoAndFeiHuJi",dataMap.get(0).get("NumGuLaoAndFeiHuJi"));
        jsonObject.put("NumGuLaoAndMale",dataMap.get(0).get("NumGuLaoAndMale"));
        jsonObject.put("NumGuLaoAndFemale",dataMap.get(0).get("NumGuLaoAndFemale"));
        jsonObject.put("NumGuLaoAnd60To70M",dataMap.get(0).get("NumGuLaoAnd60To70M"));
        jsonObject.put("NumGuLaoAnd70To80M",dataMap.get(0).get("NumGuLaoAnd70To80M"));
        jsonObject.put("NumGuLaoAnd80To90M",dataMap.get(0).get("NumGuLaoAnd80To90M"));
        jsonObject.put("NumGuLaoAnd90AboveM",dataMap.get(0).get("NumGuLaoAnd90AboveM"));
        jsonObject.put("NumGuLaoAnd60To70F",dataMap.get(0).get("NumGuLaoAnd60To70F"));
        jsonObject.put("NumGuLaoAnd70To80F",dataMap.get(0).get("NumGuLaoAnd70To80F"));
        jsonObject.put("NumGuLaoAnd80To90F",dataMap.get(0).get("NumGuLaoAnd80To90F"));
        jsonObject.put("NumGuLaoAnd90AboveF",dataMap.get(0).get("NumGuLaoAnd90AboveF"));

        jsonObject.put("NumSanZhiAndHuJi",dataMap.get(0).get("NumSanZhiAndHuJi"));
        jsonObject.put("NumSanZhiAndFeiHuJi",dataMap.get(0).get("NumSanZhiAndFeiHuJi"));
        jsonObject.put("NumSanZhiAndMale",dataMap.get(0).get("NumSanZhiAndMale"));
        jsonObject.put("NumSanZhiAndFemale",dataMap.get(0).get("NumSanZhiAndFemale"));
        jsonObject.put("NumSanZhiAnd60To70M",dataMap.get(0).get("NumSanZhiAnd60To70M"));
        jsonObject.put("NumSanZhiAnd70To80M",dataMap.get(0).get("NumSanZhiAnd70To80M"));
        jsonObject.put("NumSanZhiAnd80To90M",dataMap.get(0).get("NumSanZhiAnd80To90M"));
        jsonObject.put("NumSanZhiAnd90AboveM",dataMap.get(0).get("NumSanZhiAnd90AboveM"));
        jsonObject.put("NumSanZhiAnd60To70F",dataMap.get(0).get("NumSanZhiAnd60To70F"));
        jsonObject.put("NumSanZhiAnd70To80F",dataMap.get(0).get("NumSanZhiAnd70To80F"));
        jsonObject.put("NumSanZhiAnd80To90F",dataMap.get(0).get("NumSanZhiAnd80To90F"));
        jsonObject.put("NumSanZhiAnd90AboveF",dataMap.get(0).get("NumSanZhiAnd90AboveF"));

        jsonObject.put("NumQiTaFamilyAndHuJi",dataMap.get(0).get("NumQiTaFamilyAndHuJi"));
        jsonObject.put("NumQiTaFamilyAndFeiHuJi",dataMap.get(0).get("NumQiTaFamilyAndFeiHuJi"));
        jsonObject.put("NumQiTaFamilyAndMale",dataMap.get(0).get("NumQiTaFamilyAndMale"));
        jsonObject.put("NumQiTaFamilyAndFemale",dataMap.get(0).get("NumQiTaFamilyAndFemale"));
        jsonObject.put("NumQiTaFamilyAnd60To70M",dataMap.get(0).get("NumQiTaFamilyAnd60To70M"));
        jsonObject.put("NumQiTaFamilyAnd70To80M",dataMap.get(0).get("NumQiTaFamilyAnd70To80M"));
        jsonObject.put("NumQiTaFamilyAnd80To90M",dataMap.get(0).get("NumQiTaFamilyAnd80To90M"));
        jsonObject.put("NumQiTaFamilyAnd90AboveM",dataMap.get(0).get("NumQiTaFamilyAnd90AboveM"));
        jsonObject.put("NumQiTaFamilyAnd60To70F",dataMap.get(0).get("NumQiTaFamilyAnd60To70F"));
        jsonObject.put("NumQiTaFamilyAnd70To80F",dataMap.get(0).get("NumQiTaFamilyAnd70To80F"));
        jsonObject.put("NumQiTaFamilyAnd80To90F",dataMap.get(0).get("NumQiTaFamilyAnd80To90F"));
        jsonObject.put("NumQiTaFamilyAnd90AboveF",dataMap.get(0).get("NumQiTaFamilyAnd90AboveF"));





        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartHealth",method = RequestMethod.GET)
    public Result admin_getOldNum606() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartHealth(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NumOld",dataMap.get(0).get("NumOld"));
        jsonObject.put("NumAll",dataMap.get(0).get("NumAll"));


        jsonObject.put("NumOrganOld",dataMap.get(0).get("NumOrganOld"));
        jsonObject.put("NumFamilyOld",dataMap.get(0).get("NumFamilyOld"));
        jsonObject.put("NumOrganOld",dataMap.get(0).get("NumOrganOld"));

        jsonObject.put("NumSN",dataMap.get(0).get("NumSN"));
        jsonObject.put("NumMB",dataMap.get(0).get("NumMB"));
        jsonObject.put("NumZLS",dataMap.get(0).get("NumZLS"));
        jsonObject.put("NumGZS",dataMap.get(0).get("NumGZS"));
        jsonObject.put("NumSZ",dataMap.get(0).get("NumSZ"));
        jsonObject.put("NumCHXPJ",dataMap.get(0).get("NumCHXPJ"));
        jsonObject.put("NumQiTaHealth",dataMap.get(0).get("NumQiTaHealth"));

        jsonObject.put("NumHuJi",dataMap.get(0).get("NumHuJi"));
        jsonObject.put("NumFeiHuJi",dataMap.get(0).get("NumFeiHuJi"));
        jsonObject.put("NumMale",dataMap.get(0).get("NumMale"));
        jsonObject.put("NumFemale",dataMap.get(0).get("NumFemale"));


        jsonObject.put("Num60To70M",dataMap.get(0).get("Num60To70M"));
        jsonObject.put("Num70To80M",dataMap.get(0).get("Num70To80M"));
        jsonObject.put("Num80To90M",dataMap.get(0).get("Num80To90M"));
        jsonObject.put("NumAbove90M",dataMap.get(0).get("NumAbove90M"));
        jsonObject.put("Num60To70F",dataMap.get(0).get("Num60To70F"));
        jsonObject.put("Num70To80F",dataMap.get(0).get("Num70To80F"));
        jsonObject.put("Num80To90F",dataMap.get(0).get("Num80To90F"));
        jsonObject.put("NumAbove90F",dataMap.get(0).get("NumAbove90F"));

        jsonObject.put("NumShiNengAndHuJi",dataMap.get(0).get("NumShiNengAndHuJi"));
        jsonObject.put("NumShiNengAndFeiHuJi",dataMap.get(0).get("NumShiNengAndFeiHuJi"));
        jsonObject.put("NumShiNengAndMale",dataMap.get(0).get("NumShiNengAndMale"));
        jsonObject.put("NumShiNengAndFemale",dataMap.get(0).get("NumShiNengAndFemale"));
        jsonObject.put("NumShiNengAnd60To70M",dataMap.get(0).get("NumShiNengAnd60To70M"));
        jsonObject.put("NumShiNengAnd70To80M",dataMap.get(0).get("NumShiNengAnd70To80M"));
        jsonObject.put("NumShiNengAnd80To90M",dataMap.get(0).get("NumShiNengAnd80To90M"));
        jsonObject.put("NumShiNengAnd90AboveM",dataMap.get(0).get("NumShiNengAnd90AboveM"));
        jsonObject.put("NumShiNengAnd60To70F",dataMap.get(0).get("NumShiNengAnd60To70F"));
        jsonObject.put("NumShiNengAnd70To80F",dataMap.get(0).get("NumShiNengAnd70To80F"));
        jsonObject.put("NumShiNengAnd80To90F",dataMap.get(0).get("NumShiNengAnd80To90F"));
        jsonObject.put("NumShiNengAnd90AboveF",dataMap.get(0).get("NumShiNengAnd90AboveF"));

        jsonObject.put("NumManBingAndHuJi",dataMap.get(0).get("NumManBingAndHuJi"));
        jsonObject.put("NumManBingAndFeiHuJi",dataMap.get(0).get("NumManBingAndFeiHuJi"));
        jsonObject.put("NumManBingAndMale",dataMap.get(0).get("NumManBingAndMale"));
        jsonObject.put("NumManBingAndFemale",dataMap.get(0).get("NumManBingAndFemale"));
        jsonObject.put("NumManBingAnd60To70M",dataMap.get(0).get("NumManBingAnd60To70M"));
        jsonObject.put("NumManBingAnd70To80M",dataMap.get(0).get("NumManBingAnd70To80M"));
        jsonObject.put("NumManBingAnd80To90M",dataMap.get(0).get("NumManBingAnd80To90M"));
        jsonObject.put("NumManBingAnd90AboveM",dataMap.get(0).get("NumManBingAnd90AboveM"));
        jsonObject.put("NumManBingAnd60To70F",dataMap.get(0).get("NumManBingAnd60To70F"));
        jsonObject.put("NumManBingAnd70To80F",dataMap.get(0).get("NumManBingAnd70To80F"));
        jsonObject.put("NumManBingAnd80To90F",dataMap.get(0).get("NumManBingAnd80To90F"));
        jsonObject.put("NumManBingAnd90AboveF",dataMap.get(0).get("NumManBingAnd90AboveF"));

        jsonObject.put("NumZhongLiuAndHuJi",dataMap.get(0).get("NumZhongLiuAndHuJi"));
        jsonObject.put("NumZhongLiuAndFeiHuJi",dataMap.get(0).get("NumZhongLiuAndFeiHuJi"));
        jsonObject.put("NumZhongLiuAndMale",dataMap.get(0).get("NumZhongLiuAndMale"));
        jsonObject.put("NumZhongLiuAndFemale",dataMap.get(0).get("NumZhongLiuAndFemale"));
        jsonObject.put("NumZhongLiuAnd60To70M",dataMap.get(0).get("NumZhongLiuAnd60To70M"));
        jsonObject.put("NumZhongLiuAnd70To80M",dataMap.get(0).get("NumZhongLiuAnd70To80M"));
        jsonObject.put("NumZhongLiuAnd80To90M",dataMap.get(0).get("NumZhongLiuAnd80To90M"));
        jsonObject.put("NumZhongLiuAnd90AboveM",dataMap.get(0).get("NumZhongLiuAnd90AboveM"));
        jsonObject.put("NumZhongLiuAnd60To70F",dataMap.get(0).get("NumZhongLiuAnd60To70F"));
        jsonObject.put("NumZhongLiuAnd70To80F",dataMap.get(0).get("NumZhongLiuAnd70To80F"));
        jsonObject.put("NumZhongLiuAnd80To90F",dataMap.get(0).get("NumZhongLiuAnd80To90F"));
        jsonObject.put("NumZhongLiuAnd90AboveF",dataMap.get(0).get("NumZhongLiuAnd90AboveF"));

        jsonObject.put("NumGuZheAndHuJi",dataMap.get(0).get("NumGuZheAndHuJi"));
        jsonObject.put("NumGuZheAndFeiHuJi",dataMap.get(0).get("NumGuZheAndFeiHuJi"));
        jsonObject.put("NumGuZheAndMale",dataMap.get(0).get("NumGuZheAndMale"));
        jsonObject.put("NumGuZheAndFemale",dataMap.get(0).get("NumGuZheAndFemale"));
        jsonObject.put("NumGuZheAnd60To70M",dataMap.get(0).get("NumGuZheAnd60To70M"));
        jsonObject.put("NumGuZheAnd70To80M",dataMap.get(0).get("NumGuZheAnd70To80M"));
        jsonObject.put("NumGuZheAnd80To90M",dataMap.get(0).get("NumGuZheAnd80To90M"));
        jsonObject.put("NumGuZheAnd90AboveM",dataMap.get(0).get("NumGuZheAnd90AboveM"));
        jsonObject.put("NumGuZheAnd60To70F",dataMap.get(0).get("NumGuZheAnd60To70F"));
        jsonObject.put("NumGuZheAnd70To80F",dataMap.get(0).get("NumGuZheAnd70To80F"));
        jsonObject.put("NumGuZheAnd80To90F",dataMap.get(0).get("NumGuZheAnd80To90F"));
        jsonObject.put("NumGuZheAnd90AboveF",dataMap.get(0).get("NumGuZheAnd90AboveF"));

        jsonObject.put("NumShiZhiAndHuJi",dataMap.get(0).get("NumShiZhiAndHuJi"));
        jsonObject.put("NumShiZhiAndFeiHuJi",dataMap.get(0).get("NumShiZhiAndFeiHuJi"));
        jsonObject.put("NumShiZhiAndMale",dataMap.get(0).get("NumShiZhiAndMale"));
        jsonObject.put("NumShiZhiAndFemale",dataMap.get(0).get("NumShiZhiAndFemale"));
        jsonObject.put("NumShiZhiAnd60To70M",dataMap.get(0).get("NumShiZhiAnd60To70M"));
        jsonObject.put("NumShiZhiAnd70To80M",dataMap.get(0).get("NumShiZhiAnd70To80M"));
        jsonObject.put("NumShiZhiAnd80To90M",dataMap.get(0).get("NumShiZhiAnd80To90M"));
        jsonObject.put("NumShiZhiAnd90AboveM",dataMap.get(0).get("NumShiZhiAnd90AboveM"));
        jsonObject.put("NumShiZhiAnd60To70F",dataMap.get(0).get("NumShiZhiAnd60To70F"));
        jsonObject.put("NumShiZhiAnd70To80F",dataMap.get(0).get("NumShiZhiAnd70To80F"));
        jsonObject.put("NumShiZhiAnd80To90F",dataMap.get(0).get("NumShiZhiAnd80To90F"));
        jsonObject.put("NumShiZhiAnd90AboveF",dataMap.get(0).get("NumShiZhiAnd90AboveF"));

        jsonObject.put("NumChangHuAndHuJi",dataMap.get(0).get("NumChangHuAndHuJi"));
        jsonObject.put("NumChangHuAndFeiHuJi",dataMap.get(0).get("NumChangHuAndFeiHuJi"));
        jsonObject.put("NumChangHuAndMale",dataMap.get(0).get("NumChangHuAndMale"));
        jsonObject.put("NumChangHuAndFemale",dataMap.get(0).get("NumChangHuAndFemale"));
        jsonObject.put("NumChangHuAnd60To70M",dataMap.get(0).get("NumChangHuAnd60To70M"));
        jsonObject.put("NumChangHuAnd70To80M",dataMap.get(0).get("NumChangHuAnd70To80M"));
        jsonObject.put("NumChangHuAnd80To90M",dataMap.get(0).get("NumChangHuAnd80To90M"));
        jsonObject.put("NumChangHuAnd90AboveM",dataMap.get(0).get("NumChangHuAnd90AboveM"));
        jsonObject.put("NumChangHuAnd60To70F",dataMap.get(0).get("NumChangHuAnd60To70F"));
        jsonObject.put("NumChangHuAnd70To80F",dataMap.get(0).get("NumChangHuAnd70To80F"));
        jsonObject.put("NumChangHuAnd80To90F",dataMap.get(0).get("NumChangHuAnd80To90F"));
        jsonObject.put("NumChangHuAnd90AboveF",dataMap.get(0).get("NumChangHuAnd90AboveF"));

        jsonObject.put("NumQiTaHealthAndHuJi",dataMap.get(0).get("NumQiTaHealthAndHuJi"));
        jsonObject.put("NumQiTaHealthAndFeiHuJi",dataMap.get(0).get("NumQiTaHealthAndFeiHuJi"));
        jsonObject.put("NumQiTaHealthAndMale",dataMap.get(0).get("NumQiTaHealthAndMale"));
        jsonObject.put("NumQiTaHealthAndFemale",dataMap.get(0).get("NumQiTaHealthAndFemale"));
        jsonObject.put("NumQiTaHealthAnd60To70M",dataMap.get(0).get("NumQiTaHealthAnd60To70M"));
        jsonObject.put("NumQiTaHealthAnd70To80M",dataMap.get(0).get("NumQiTaHealthAnd70To80M"));
        jsonObject.put("NumQiTaHealthAnd80To90M",dataMap.get(0).get("NumQiTaHealthAnd80To90M"));
        jsonObject.put("NumQiTaHealthAnd90AboveM",dataMap.get(0).get("NumQiTaHealthAnd90AboveM"));
        jsonObject.put("NumQiTaHealthAnd60To70F",dataMap.get(0).get("NumQiTaHealthAnd60To70F"));
        jsonObject.put("NumQiTaHealthAnd70To80F",dataMap.get(0).get("NumQiTaHealthAnd70To80F"));
        jsonObject.put("NumQiTaHealthAnd80To90F",dataMap.get(0).get("NumQiTaHealthAnd80To90F"));
        jsonObject.put("NumQiTaHealthAnd90AboveF",dataMap.get(0).get("NumQiTaHealthAnd90AboveF"));




        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartEconomic",method = RequestMethod.GET)
    public Result admin_getOldNum607() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartEconomic(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NumOld",dataMap.get(0).get("NumOld"));
        jsonObject.put("NumAll",dataMap.get(0).get("NumAll"));


        jsonObject.put("NumOrganOld",dataMap.get(0).get("NumOrganOld"));
        jsonObject.put("NumFamilyOld",dataMap.get(0).get("NumFamilyOld"));
        jsonObject.put("NumOrganOld",dataMap.get(0).get("NumOrganOld"));

        jsonObject.put("NumBangKun",dataMap.get(0).get("NumBangKun"));
        jsonObject.put("NumDiBao",dataMap.get(0).get("NumDiBao"));
        jsonObject.put("NumYangLaoBX",dataMap.get(0).get("NumYangLaoBX"));
        jsonObject.put("NumYiLiaoJZJ",dataMap.get(0).get("NumYiLiaoJZJ"));
        jsonObject.put("NumChengZhenYB",dataMap.get(0).get("NumChengZhenYB"));
        jsonObject.put("NumQiTaEco",dataMap.get(0).get("NumQiTaEco"));

        jsonObject.put("NumHuJi",dataMap.get(0).get("NumHuJi"));
        jsonObject.put("NumFeiHuJi",dataMap.get(0).get("NumFeiHuJi"));
        jsonObject.put("NumMale",dataMap.get(0).get("NumMale"));
        jsonObject.put("NumFemale",dataMap.get(0).get("NumFemale"));


        jsonObject.put("Num60To70M",dataMap.get(0).get("Num60To70M"));
        jsonObject.put("Num70To80M",dataMap.get(0).get("Num70To80M"));
        jsonObject.put("Num80To90M",dataMap.get(0).get("Num80To90M"));
        jsonObject.put("NumAbove90M",dataMap.get(0).get("NumAbove90M"));
        jsonObject.put("Num60To70F",dataMap.get(0).get("Num60To70F"));
        jsonObject.put("Num70To80F",dataMap.get(0).get("Num70To80F"));
        jsonObject.put("Num80To90F",dataMap.get(0).get("Num80To90F"));
        jsonObject.put("NumAbove90F",dataMap.get(0).get("NumAbove90F"));

        jsonObject.put("NumBangKunAndHuJi",dataMap.get(0).get("NumBangKunAndHuJi"));
        jsonObject.put("NumBangKunAndFeiHuJi",dataMap.get(0).get("NumBangKunAndFeiHuJi"));
        jsonObject.put("NumBangKunAndMale",dataMap.get(0).get("NumBangKunAndMale"));
        jsonObject.put("NumBangKunAndFemale",dataMap.get(0).get("NumBangKunAndFemale"));
        jsonObject.put("NumBangKunAnd60To70M",dataMap.get(0).get("NumBangKunAnd60To70M"));
        jsonObject.put("NumBangKunAnd70To80M",dataMap.get(0).get("NumBangKunAnd70To80M"));
        jsonObject.put("NumBangKunAnd80To90M",dataMap.get(0).get("NumBangKunAnd80To90M"));
        jsonObject.put("NumBangKunAnd90AboveM",dataMap.get(0).get("NumBangKunAnd90AboveM"));
        jsonObject.put("NumBangKunAnd60To70F",dataMap.get(0).get("NumBangKunAnd60To70F"));
        jsonObject.put("NumBangKunAnd70To80F",dataMap.get(0).get("NumBangKunAnd70To80F"));
        jsonObject.put("NumBangKunAnd80To90F",dataMap.get(0).get("NumBangKunAnd80To90F"));
        jsonObject.put("NumBangKunAnd90AboveF",dataMap.get(0).get("NumBangKunAnd90AboveF"));

        jsonObject.put("NumDiBaoAndHuJi",dataMap.get(0).get("NumDiBaoAndHuJi"));
        jsonObject.put("NumDiBaoAndFeiHuJi",dataMap.get(0).get("NumDiBaoAndFeiHuJi"));
        jsonObject.put("NumDiBaoAndMale",dataMap.get(0).get("NumDiBaoAndMale"));
        jsonObject.put("NumDiBaoAndFemale",dataMap.get(0).get("NumDiBaoAndFemale"));
        jsonObject.put("NumDiBaoAnd60To70M",dataMap.get(0).get("NumDiBaoAnd60To70M"));
        jsonObject.put("NumDiBaoAnd70To80M",dataMap.get(0).get("NumDiBaoAnd70To80M"));
        jsonObject.put("NumDiBaoAnd80To90M",dataMap.get(0).get("NumDiBaoAnd80To90M"));
        jsonObject.put("NumDiBaoAnd90AboveM",dataMap.get(0).get("NumDiBaoAnd90AboveM"));
        jsonObject.put("NumDiBaoAnd60To70F",dataMap.get(0).get("NumDiBaoAnd60To70F"));
        jsonObject.put("NumDiBaoAnd70To80F",dataMap.get(0).get("NumDiBaoAnd70To80F"));
        jsonObject.put("NumDiBaoAnd80To90F",dataMap.get(0).get("NumDiBaoAnd80To90F"));
        jsonObject.put("NumDiBaoAnd90AboveF",dataMap.get(0).get("NumDiBaoAnd90AboveF"));

        jsonObject.put("NumYangLaoAndHuJi",dataMap.get(0).get("NumYangLaoAndHuJi"));
        jsonObject.put("NumYangLaoAndFeiHuJi",dataMap.get(0).get("NumYangLaoAndFeiHuJi"));
        jsonObject.put("NumYangLaoAndMale",dataMap.get(0).get("NumYangLaoAndMale"));
        jsonObject.put("NumYangLaoAndFemale",dataMap.get(0).get("NumYangLaoAndFemale"));
        jsonObject.put("NumYangLaoAnd60To70M",dataMap.get(0).get("NumYangLaoAnd60To70M"));
        jsonObject.put("NumYangLaoAnd70To80M",dataMap.get(0).get("NumYangLaoAnd70To80M"));
        jsonObject.put("NumYangLaoAnd80To90M",dataMap.get(0).get("NumYangLaoAnd80To90M"));
        jsonObject.put("NumYangLaoAnd90AboveM",dataMap.get(0).get("NumYangLaoAnd90AboveM"));
        jsonObject.put("NumYangLaoAnd60To70F",dataMap.get(0).get("NumYangLaoAnd60To70F"));
        jsonObject.put("NumYangLaoAnd70To80F",dataMap.get(0).get("NumYangLaoAnd70To80F"));
        jsonObject.put("NumYangLaoAnd80To90F",dataMap.get(0).get("NumYangLaoAnd80To90F"));
        jsonObject.put("NumYangLaoAnd90AboveF",dataMap.get(0).get("NumYangLaoAnd90AboveF"));

        jsonObject.put("NumYiLiaoAndHuJi",dataMap.get(0).get("NumYiLiaoAndHuJi"));
        jsonObject.put("NumYiLiaoAndFeiHuJi",dataMap.get(0).get("NumYiLiaoAndFeiHuJi"));
        jsonObject.put("NumYiLiaoAndMale",dataMap.get(0).get("NumYiLiaoAndMale"));
        jsonObject.put("NumYiLiaoAndFemale",dataMap.get(0).get("NumYiLiaoAndFemale"));
        jsonObject.put("NumYiLiaoAnd60To70M",dataMap.get(0).get("NumYiLiaoAnd60To70M"));
        jsonObject.put("NumYiLiaoAnd70To80M",dataMap.get(0).get("NumYiLiaoAnd70To80M"));
        jsonObject.put("NumYiLiaoAnd80To90M",dataMap.get(0).get("NumYiLiaoAnd80To90M"));
        jsonObject.put("NumYiLiaoAnd90AboveM",dataMap.get(0).get("NumYiLiaoAnd90AboveM"));
        jsonObject.put("NumYiLiaoAnd60To70F",dataMap.get(0).get("NumYiLiaoAnd60To70F"));
        jsonObject.put("NumYiLiaoAnd70To80F",dataMap.get(0).get("NumYiLiaoAnd70To80F"));
        jsonObject.put("NumYiLiaoAnd80To90F",dataMap.get(0).get("NumYiLiaoAnd80To90F"));
        jsonObject.put("NumYiLiaoAnd90AboveF",dataMap.get(0).get("NumYiLiaoAnd90AboveF"));

        jsonObject.put("NumChenZhenAndHuJi",dataMap.get(0).get("NumChenZhenAndHuJi"));
        jsonObject.put("NumChenZhenAndFeiHuJi",dataMap.get(0).get("NumChenZhenAndFeiHuJi"));
        jsonObject.put("NumChenZhenAndMale",dataMap.get(0).get("NumChenZhenAndMale"));
        jsonObject.put("NumChenZhenAndFemale",dataMap.get(0).get("NumChenZhenAndFemale"));
        jsonObject.put("NumChenZhenAnd60To70M",dataMap.get(0).get("NumChenZhenAnd60To70M"));
        jsonObject.put("NumChenZhenAnd70To80M",dataMap.get(0).get("NumChenZhenAnd70To80M"));
        jsonObject.put("NumChenZhenAnd80To90M",dataMap.get(0).get("NumChenZhenAnd80To90M"));
        jsonObject.put("NumChenZhenAnd90AboveM",dataMap.get(0).get("NumChenZhenAnd90AboveM"));
        jsonObject.put("NumChenZhenAnd60To70F",dataMap.get(0).get("NumChenZhenAnd60To70F"));
        jsonObject.put("NumChenZhenAnd70To80F",dataMap.get(0).get("NumChenZhenAnd70To80F"));
        jsonObject.put("NumChenZhenAnd80To90F",dataMap.get(0).get("NumChenZhenAnd80To90F"));
        jsonObject.put("NumChenZhenAnd90AboveF",dataMap.get(0).get("NumChenZhenAnd90AboveF"));

        jsonObject.put("NumQiTaEconomicAndHuJi",dataMap.get(0).get("NumQiTaEconomicAndHuJi"));
        jsonObject.put("NumQiTaEconomicAndFeiHuJi",dataMap.get(0).get("NumQiTaEconomicAndFeiHuJi"));
        jsonObject.put("NumQiTaEconomicAndMale",dataMap.get(0).get("NumQiTaEconomicAndMale"));
        jsonObject.put("NumQiTaEconomicAndFemale",dataMap.get(0).get("NumQiTaEconomicAndFemale"));
        jsonObject.put("NumQiTaEconomicAnd60To70M",dataMap.get(0).get("NumQiTaEconomicAnd60To70M"));
        jsonObject.put("NumQiTaEconomicAnd70To80M",dataMap.get(0).get("NumQiTaEconomicAnd70To80M"));
        jsonObject.put("NumQiTaEconomicAnd80To90M",dataMap.get(0).get("NumQiTaEconomicAnd80To90M"));
        jsonObject.put("NumQiTaEconomicAnd90AboveM",dataMap.get(0).get("NumQiTaEconomicAnd90AboveM"));
        jsonObject.put("NumQiTaEconomicAnd60To70F",dataMap.get(0).get("NumQiTaEconomicAnd60To70F"));
        jsonObject.put("NumQiTaEconomicAnd70To80F",dataMap.get(0).get("NumQiTaEconomicAnd70To80F"));
        jsonObject.put("NumQiTaEconomicAnd80To90F",dataMap.get(0).get("NumQiTaEconomicAnd80To90F"));
        jsonObject.put("NumQiTaEconomicAnd90AboveF",dataMap.get(0).get("NumQiTaEconomicAnd90AboveF"));

        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartYLY",method = RequestMethod.GET)
    public Result admin_getOldNum608() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartYLY(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NumOld",dataMap.get(0).get("NumOld"));
        jsonObject.put("NumAll",dataMap.get(0).get("NumAll"));


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

        jsonObject.put("NumPingYangJLAndShiNeng",dataMap.get(0).get("NumPingYangJLAndShiNeng"));
        jsonObject.put("NumPingYangJLAndShiZhi",dataMap.get(0).get("NumPingYangJLAndShiZhi"));
        jsonObject.put("NumPingYangJLAndZiLi",dataMap.get(0).get("NumPingYangJLAndZiLi"));

        jsonObject.put("NumGuMeiJLAndShiNeng",dataMap.get(0).get("NumGuMeiJLAndShiNeng"));
        jsonObject.put("NumGuMeiJLAndShiZhi",dataMap.get(0).get("NumGuMeiJLAndShiZhi"));
        jsonObject.put("NumGuMeiJLAndZiLi",dataMap.get(0).get("NumGuMeiJLAndZiLi"));

        jsonObject.put("NumLianHuaJLAndShiNeng",dataMap.get(0).get("NumLianHuaJLAndShiNeng"));
        jsonObject.put("NumLianHuaJLAndShiZhi",dataMap.get(0).get("NumLianHuaJLAndShiZhi"));
        jsonObject.put("NumLianHuaJLAndZiLi",dataMap.get(0).get("NumLianHuaJLAndZiLi"));


        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartRZ",method = RequestMethod.GET)
    public Result admin_getOldNum609() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartRZ(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();
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

        //PINGJI1
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

        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartFuWu",method = RequestMethod.GET)
    public Result admin_getOldNum610() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartFuWu(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();

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

        jsonObject.put("NumHuJi",dataMap.get(0).get("NumHuJi"));
        jsonObject.put("NumFeiHuJi",dataMap.get(0).get("NumFeiHuJi"));
        jsonObject.put("NumMale",dataMap.get(0).get("NumMale"));
        jsonObject.put("NumFemale",dataMap.get(0).get("NumFemale"));

        jsonObject.put("Num60To70M",dataMap.get(0).get("Num60To70M"));
        jsonObject.put("Num70To80M",dataMap.get(0).get("Num70To80M"));
        jsonObject.put("Num80To90M",dataMap.get(0).get("Num80To90M"));
        jsonObject.put("NumAbove90M",dataMap.get(0).get("NumAbove90M"));
        jsonObject.put("Num60To70F",dataMap.get(0).get("Num60To70F"));
        jsonObject.put("Num70To80F",dataMap.get(0).get("Num70To80F"));
        jsonObject.put("Num80To90F",dataMap.get(0).get("Num80To90F"));
        jsonObject.put("NumAbove90F",dataMap.get(0).get("NumAbove90F"));

        jsonObject.put("NumKeyOld",dataMap.get(0).get("NumKeyOld"));
        jsonObject.put("NumKeyAttend",dataMap.get(0).get("NumKeyAttend"));

        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartBase",method = RequestMethod.GET)
    public Result admin_getOldNum611() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartBase(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NumOld",dataMap.get(0).get("NumOld"));
        jsonObject.put("NumAll",dataMap.get(0).get("NumAll"));


        jsonObject.put("NumHuJi",dataMap.get(0).get("NumHuJi"));
        jsonObject.put("NumFeiHuJi",dataMap.get(0).get("NumFeiHuJi"));
        jsonObject.put("NumMale",dataMap.get(0).get("NumMale"));
        jsonObject.put("NumFemale",dataMap.get(0).get("NumFemale"));

        jsonObject.put("Num60To70M",dataMap.get(0).get("Num60To70M"));
        jsonObject.put("Num70To80M",dataMap.get(0).get("Num70To80M"));
        jsonObject.put("Num80To90M",dataMap.get(0).get("Num80To90M"));
        jsonObject.put("NumAbove90M",dataMap.get(0).get("NumAbove90M"));
        jsonObject.put("Num60To70F",dataMap.get(0).get("Num60To70F"));
        jsonObject.put("Num70To80F",dataMap.get(0).get("Num70To80F"));
        jsonObject.put("Num80To90F",dataMap.get(0).get("Num80To90F"));
        jsonObject.put("NumAbove90F",dataMap.get(0).get("NumAbove90F"));

        jsonObject.put("NumJieDaoPeople",dataMap.get(0).get("NumJieDaoPeople"));

        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartZZ",method = RequestMethod.GET)
    public Result admin_getOldNum612() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartZZ(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();

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

        //aiwei
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

        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartZC",method = RequestMethod.GET)
    public Result admin_getOldNum613() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartZC(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();

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



        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartCHX",method = RequestMethod.GET)
    public Result admin_getOldNum614() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartCHX(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();

        //chx
        jsonObject.put("NumOld",dataMap.get(0).get("NumOld"));
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

        jsonObject.put("NumLeveled",dataMap.get(0).get("NumLeveled"));
        jsonObject.put("NumServed",dataMap.get(0).get("NumServed"));


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



        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartZNH",method = RequestMethod.GET)
    public Result admin_getOldNum615() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartZNH(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();

        //znh
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

        //JTYS
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

        jsonObject.put("NumKeyOld",dataMap.get(0).get("NumKeyOld"));
        jsonObject.put("NumZhiNengKeyOld",dataMap.get(0).get("NumZhiNengKeyOld"));
        jsonObject.put("NumKeyAttendZhiNeng",dataMap.get(0).get("NumKeyAttendZhiNeng"));
        jsonObject.put("NumKeyAttendYiSheng",dataMap.get(0).get("NumKeyAttendYiSheng"));
        jsonObject.put("NumKeyAttendBingChuang",dataMap.get(0).get("NumKeyAttendBingChuang"));

        Result result =new Result(true,jsonObject);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getVisualDataApartLabel",method = RequestMethod.GET)
    public Result admin_getOldNum616() {
        List<Map<String, Long>> dataMap = oldmanService.getVisualDataApartLabel(AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NumHuJi",dataMap.get(0).get("NumHuJi"));
        jsonObject.put("NumFeiHuJi",dataMap.get(0).get("NumFeiHuJi"));
        jsonObject.put("NumMale",dataMap.get(0).get("NumMale"));
        jsonObject.put("NumFemale",dataMap.get(0).get("NumFemale"));


        jsonObject.put("Num60To70M",dataMap.get(0).get("Num60To70M"));
        jsonObject.put("Num70To80M",dataMap.get(0).get("Num70To80M"));
        jsonObject.put("Num80To90M",dataMap.get(0).get("Num80To90M"));
        jsonObject.put("NumAbove90M",dataMap.get(0).get("NumAbove90M"));
        jsonObject.put("Num60To70F",dataMap.get(0).get("Num60To70F"));
        jsonObject.put("Num70To80F",dataMap.get(0).get("Num70To80F"));
        jsonObject.put("Num80To90F",dataMap.get(0).get("Num80To90F"));
        jsonObject.put("NumAbove90F",dataMap.get(0).get("NumAbove90F"));

        jsonObject.put("NumGuMei",dataMap.get(0).get("NumGuMei"));
        jsonObject.put("NumGuLong",dataMap.get(0).get("NumGuLong"));
        jsonObject.put("NumPingJi",dataMap.get(0).get("NumPingJi"));
        jsonObject.put("NumPingYang",dataMap.get(0).get("NumPingYang"));
        jsonObject.put("NumPingNan",dataMap.get(0).get("NumPingNan"));
        jsonObject.put("NumDongLan",dataMap.get(0).get("NumDongLan"));



        Result result =new Result(true,jsonObject);
        return result;
    }


}
