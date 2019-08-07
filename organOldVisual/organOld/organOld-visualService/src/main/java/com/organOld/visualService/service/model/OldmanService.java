package com.organOld.visualService.service.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by netlab606 on 2018/4/1.
 */
public interface OldmanService {

    List<Map<String,Long>> getVisualData(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualData1(Date date1, Date date2,Date date3,Date date4,String preMonth);
    List<Map<String,Long>> getVisualData2(Date date1, Date date2,Date date3,Date date4,String preMonth);
    List<Map<String,Long>> getVisualData3(Date date1, Date date2,Date date3,Date date4,String preMonth);
    List<Map<String,Long>> getVisualData4(Date date1, Date date2,Date date3,Date date4,String preMonth);
    List<Map<String,Integer>> getVisualData5(Date date1, Date date2,Date date3,Date date4,Date date5,Date date6,Date date7,Date date8,Date date9,String preMonth);

    List<Map<String,String>> getOrganInfo();


    List<Map<String,Long>> getVisualDataApartFinish(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartOldman(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartTotal(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartOrgan(Date date1, Date date2,Date date3,Date date4);

    List<Map<String,Long>> getVisualDataApartFamily(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartHealth(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartEconomic(Date date1, Date date2,Date date3,Date date4);

    List<Map<String,Long>> getVisualDataApartYLY(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartRZ(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartFuWu(Date date1, Date date2,Date date3,Date date4);

    List<Map<String,Long>> getVisualDataApartBase(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartZZ(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartZC(Date date1, Date date2,Date date3,Date date4);

    List<Map<String,Long>> getVisualDataApartCHX(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartZNH(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartJTYS(Date date1, Date date2,Date date3,Date date4);
    List<Map<String,Long>> getVisualDataApartJTBC(Date date1, Date date2,Date date3,Date date4);

    List<Map<String,Long>> getVisualDataApartLabel(Date date1, Date date2,Date date3,Date date4);

    void updateVisualData(String date);
    void deleteOldVisualData();

    void updateOrganAndNews(String name,String content);

}
