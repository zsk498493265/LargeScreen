package com.organOld.dao.repository;

import com.organOld.dao.entity.oldman.HealthAdd;

import java.util.List;

public interface HealthAddDao extends BaseDao<HealthAdd,Number> {
    void delByOldmanId(int id);

    void delByOldmanIds(List<Integer> existOldmanIds);
}
