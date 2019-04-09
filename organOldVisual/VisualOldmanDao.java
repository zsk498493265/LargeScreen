package com.organOld.dao.repository.visual;


import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanIntegral;
import com.organOld.dao.repository.BaseDao;
import com.organOld.dao.util.Page;
import com.organOld.dao.util.bean.ExportOldman;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface VisualOldmanDao extends BaseDao<Oldman,Integer>{
    Long getSizeByPageT(Page page);

    Long getSizeByPageTh(Page page);

    Long getSizeByPageF(Page page);

    Long getSizeByPageFive(Page page);

    Long getSizeByPageSix(Page page);

    List<Integer>  getOldsIdByOrganId(String[] organIds);

    List<Integer> getOldsIdByHomeId(String[] secTypes);

    List<Integer> getOldsIdByHealthId(Page page);

    List<Integer> getOldsIdByPage(Page page);
 }

