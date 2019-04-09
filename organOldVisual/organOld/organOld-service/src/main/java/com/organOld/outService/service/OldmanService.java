package com.organOld.outService.service;


import com.organOld.dao.entity.DBEntity;
import com.organOld.dao.entity.oldman.HealthSelect;
import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.outService.contract.*;
import com.organOld.outService.model.HealthSelectInfoModel;
import com.organOld.outService.model.OldmanAddInfoModel;
import com.organOld.outService.model.OldmanAllInfoModel;
import com.organOld.outService.contract.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by netlab606 on 2018/4/1.
 */
public interface OldmanService {

    void delById(int id);

    void save(OldmanAddRequest oldmanAddRequest);


    String getOldmanByPage(OldmanRequest oldmanBaseRequest, BTableRequest bTableRequest);

    String getHealthByPage(OldmanHealthRequest oldmanHealthRequest, BTableRequest bTableRequest);
//
//    String getLinkmanByPage(LinkmanRequest linkmanRequest, BTableRequest bTableRequest);
//
//    String getEconomyByPage(OldmanEconomicRequest economicRequest, BTableRequest bTableRequest);
//
//    String getFamilyByPage(OldmanFamilyRequest familyRequest, BTableRequest bTableRequest);
//
    String getOrganOldmanByPage(OrganOldmanRequest organOldmanRequest, BTableRequest bTableRequest);

    OldmanAddInfoModel getAddInfo();

    String getHomeOldmanByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest);

    OldmanAllInfoModel getOldmanInfo(int oldmanId);

    Result importExcel(MultipartFile file, HttpSession session) throws IOException;

    Result getIntegralByOldmanId(int oldmanId);

    String getHealthSelectByPage(HealthSelectRequest healthSelectRequest, BTableRequest bTableRequest);

    void addOrUpdateHealthSelect(HealthSelect healthSelect, String type);

    String getIntegralByPage(OldmanIntegralRequest oldmanIntegralRequest, BTableRequest bTableRequest);

    Result getById(int id, String type);

    Result updateById(DBEntity dbEntity, String base);

    void delByIds(String[] ids);

    void delHealthSelectByIds(String[] ids);

    Result getIntegralRule();

    void updateIntegral(int signRc, int sign_zz, int sign_qt, int sign, int consume);

    void export(HttpServletResponse response, ExportTableThRequest exportTableThRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    HealthSelectInfoModel getAllHealthInfo();

    Map<String,Long> getOldStatusNum(List<Integer> xqIds);

    Map<String,Oldman> getAllOldman();

    Result getBySearch(String search);

    Map<String,Long> getOldmanNum(List<Integer> xqIds, Date start60, Date start80);

    Map<String,Long> getKeyNum(List<Integer> xqIds,int baseGoal);

    Map<String,Long> getHealthNum(List<Integer> xqIds);

    List<Oldman> getIntegralSort(List<Integer> xqIds);

    Long getOldmanNum(Date date);

    void updateOldStatus();

    void updateHomeOldStatusByOldmanIds(List<Integer> loadedData);

    void updateOrganOldStatusByOldmanIds(List<Oldman> loadedData);

    Result changeIntegral(String[] oldmanIds, String type, Integer value);

    Result zeroIntegral(String[] oldmanIds);

    Result importExcelCunstom(MultipartFile file, String[] tables, Integer start) throws IOException;
}
