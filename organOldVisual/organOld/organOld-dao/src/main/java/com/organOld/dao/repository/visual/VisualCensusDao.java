package com.organOld.dao.repository.visual;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.repository.BaseDao;
import com.organOld.dao.util.Page;

import java.util.Map;

public interface VisualCensusDao extends BaseDao<Oldman,Integer> {
    Map<String,Long> getNumOfCensus(Page page);

    Map<String,Long> getNumOfCensusT(Page page);

    Map<String,Long> getNumOfCensusTh(Page page);

    Map<String,Long> getNumOfCensusF(Page page);

}
