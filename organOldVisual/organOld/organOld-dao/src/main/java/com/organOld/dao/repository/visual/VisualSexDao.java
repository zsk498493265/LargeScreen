package com.organOld.dao.repository.visual;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.repository.BaseDao;
import com.organOld.dao.util.Page;

import java.util.Map;

public interface VisualSexDao extends BaseDao<Oldman,Integer> {
    Map<String,Long> getNumOfSexes(Page page);

    Map<String,Long> getNumOfSexesT(Page page);

    Map<String,Long> getNumOfSexesTh(Page page);

    Map<String,Long> getNumOfSexesF(Page page);
}
