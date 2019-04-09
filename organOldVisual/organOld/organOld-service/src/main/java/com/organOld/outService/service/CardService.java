package com.organOld.outService.service;

import com.organOld.dao.entity.Card;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.CardRequest;
import com.organOld.outService.contract.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by netlab606 on 2018/6/25.
 */
public interface CardService {
    String getByPage(CardRequest cardRequest, BTableRequest bTableRequest);

    Result addMoney(String[] ids, Double money);

    Result changeStatus(String[] ids, String status);

    Integer getIdByOldmanId(int oldmanId);

    Result handleInfo(String cid, int organId);

    Result handleIntegral(String cid, int organId, int type, int minus);

    Result handleSign(String cid, int organId, int type, int peopleType, String name, int hdType, String hdTime);


    Result handleConsume(int cid, int organId, String order, String oldmanPassword, String money);


    Result getById(Integer id);

    void updateById(Card card);

    void createZip(String[] ids, HttpServletResponse response, HttpServletRequest request);

    void delByIds(String[] ids);

    void add(Card card);
    Result handleJh(String cid);

    String getSumByPage(BTableRequest bTableRequest);
}
