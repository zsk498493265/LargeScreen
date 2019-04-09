package com.organOld.dao.repository;

import com.organOld.dao.entity.oldman.HealthSelectMan;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface HealthSelectManDao extends BaseDao<HealthSelectMan,Number> {
    void delByOldmanIds(List<Integer> existOldmanIds);

    void delByOldmanId(int oldmanId);

    List<HealthSelectMan> getMbSn();

    void del(@Param("oldmanIds") List<Integer> oldmanIds_delHealthSelect,@Param("healthSelectIds") Set<Integer> healthSlectId);
}
