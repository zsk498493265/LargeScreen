package com.organOld.dao.repository.visual;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.repository.BaseDao;
import com.organOld.dao.util.Page;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface VisualLabelDao extends BaseDao<Oldman,Integer> {
    Map<String,Long> getVisualDataApart(Page page, Date date1, Date date2, Date date3, Date date4);
}
