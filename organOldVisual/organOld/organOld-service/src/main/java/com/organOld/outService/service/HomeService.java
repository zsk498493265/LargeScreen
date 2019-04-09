package com.organOld.outService.service;

import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.home.HomeOldman;
import com.organOld.dao.entity.oldman.OldmanKey;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.HomeOldmanRequest;
import com.organOld.outService.contract.HomeRequest;
import com.organOld.outService.contract.Result;
import com.organOld.outService.model.HomeOldmanAddInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HomeService {
    String getByPage(HomeRequest homeRequest, BTableRequest bTableRequest);

    String getManByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest);

    Result importManExcel(MultipartFile file, String type, String s) throws IOException;


    Result getById(int id, int firType);

    void addOrUpdate(Home home, String type);

    void delByIds(String[] ids, int type);

    String getManAllByPage(HomeOldmanRequest homeOldmanRequest, BTableRequest bTableRequest);

    HomeOldman getOldmanById(Integer id);

    void delByOldmanIds(String[] ids);

    void updateOldman(HomeOldman homeOldman);

    void addOldman(HomeOldman homeOldman);

    HomeOldmanAddInfo getAddInfo();

    long getHomeOldmanOidSize();

    List<Integer> getHomeOldmanOidByRound(long round, long current);
}
