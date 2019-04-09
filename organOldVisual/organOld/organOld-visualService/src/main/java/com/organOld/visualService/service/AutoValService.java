package com.organOld.visualService.service;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.Xq;
import com.organOld.outService.contract.AutoValueRequest;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.Result;

import java.util.List;

public interface AutoValService {
    List<AutoValue> getByType(int index);

    String getByPage(AutoValueRequest autoValueRequest, BTableRequest bTableRequest);

    Result getById(int id);

    void handle(String type, AutoValue autoValue);

    void delByIds(String[] ids);

    List<AutoValue> getByIds(String[] sq);

    Xq getXqById(Integer xqId);

    List<AutoValue> getByTypeList(List<Integer> type);

    List<Integer> getXqIdsByJwIds(String[] jw);

    List<Integer> getXqIdsByPqIds(String[] district);

    List<Integer> getXqIdsByUsername(String userNameBySession);

    Integer getStringLikeIndex(String stringCellValue, int index, String like);

    Long getNumByType(int index);
}
