package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.HealthSelect;
import com.organOld.dao.entity.oldman.OldmanHealth;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanHealthDao extends BaseDao<OldmanHealth,Integer>{


    List<HealthSelect> getAllHealthSelect();

    Integer getSelectStringLikeIndex(@Param("str") String str, @Param("type") int index);

    void updateByOldmanIds(List<OldmanHealth> healthList_update);

    OldmanHealth getByOldmanId(int id);

    void updateByOldmanId(OldmanHealth oldmanHealth);

    Map<String,Long> getHealthNum(@Param("xqIds")List<Integer> xqIds);

    void updateByOldmanIdsSelect(@Param("oldmanhealth") List<OldmanHealth> healthList_update,@Param("filed") Set<String> oldmanHealthfiledNames);

    void updatePropsByOldmanIds(@Param("prop") String prop, @Param("value") String s,@Param("ids") String[] ids);


    void saveAllOldmanIds(List<Integer> oldmanIds);
}
