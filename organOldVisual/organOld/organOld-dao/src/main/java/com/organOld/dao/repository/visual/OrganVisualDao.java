package com.organOld.dao.repository.visual;

import com.organOld.dao.entity.organ.Organ;
import com.organOld.dao.repository.BaseDao;

public interface OrganVisualDao extends BaseDao<Organ,Integer> {
    String getNameById(int id);
}
