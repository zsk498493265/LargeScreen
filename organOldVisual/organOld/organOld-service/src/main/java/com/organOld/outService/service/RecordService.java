package com.organOld.outService.service;

import com.organOld.dao.entity.record.Record;
import com.organOld.outService.contract.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface RecordService {
    String getByPage(RecordRequest recordRequest, BTableRequest bTableRequest);

//    void save(int oldmanId, int organId, int index);

    String getByCardPage(BTableRequest bTableRequest, CardRecordRequest cardRecordRequest);

    void saveEntity(Record record);

    Result getMoneySum(String start, String end,Integer organId);

    Integer getCountByOldmanIdToday(int oldmanId, int type, int organId);

    void export(HttpServletResponse response, RecordRequest exportTableRecordRequest);

    Result getHdNameLike(String name);

    void saveEntitys(List<Record> recordList);
}
