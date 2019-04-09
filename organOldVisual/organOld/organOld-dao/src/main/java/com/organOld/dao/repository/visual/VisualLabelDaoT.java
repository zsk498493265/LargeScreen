package com.organOld.dao.repository.visual;

import com.organOld.dao.util.Page;

import java.util.Date;
import java.util.Map;

public interface VisualLabelDaoT {
    Map<String,Long> getVisualDataApart(Page page, Date date1, Date date2, Date date3, Date date4);
}
