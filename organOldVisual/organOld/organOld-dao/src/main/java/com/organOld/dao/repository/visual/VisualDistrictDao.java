package com.organOld.dao.repository.visual;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.repository.BaseDao;
import com.organOld.dao.util.Page;

import java.util.List;
import java.util.Map;

public interface VisualDistrictDao extends BaseDao<Oldman,Integer> {
   List<Integer> getXqIdsByDis(String districtId);

   Long getNumOfDistrict(Page page,List<Integer> xqIds);

   Long getNumOfDistrictT(Page page,List<Integer> xqIds);

   Long getNumOfDistrictTh(Page page,List<Integer> xqIds);

   Long getNumOfDistrictF(Page page,List<Integer> xqIds);
}
