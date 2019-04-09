package com.organOld.dao.repository;


import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.oldman.OldmanIntegral;
import com.organOld.dao.util.Page;
import com.organOld.dao.util.bean.ExportOldman;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by netlab606 on 2018/4/2.
 */
public interface OldmanDao extends BaseDao<Oldman,Integer>{
    void updateKeyOldman(List<Oldman> oldmanList);

    long getMaxId();

    void updateKeyOldmanFuture(List<Oldman> updatedData);

    Integer getIdByPid(String pid);

    int setDisabled(@Param("oldmanIds") List<Integer> existOldmanIds,@Param("xqIds") List<Integer> xqIds);

    Oldman getIntegralByOldmanId(int oldmanId);

    void updateOrganExceLImportByIds(List<Oldman> oldmanList);

    List<Oldman> getIntegralByPage(Page<OldmanIntegral> page);

    Long getIntegralSizeByPage(Page<OldmanIntegral> page);

    void addInregral(@Param("oldmanId") int oldmanId,@Param("integral") int integral);


    List<Oldman> getByJwId(Integer jwId);

    List<ExportOldman> getAll(Oldman oldman);

    List<Oldman> getOrganOldmans(@Param("xqIds") List<Integer> xqIds);

    void delVolunteerByXqIds(@Param("existOldmanIds") List<Integer> existOldmanIds,@Param("xqIds") List<Integer> xqIds);

    Map<String,Long> getOldStatusNum(@Param("xqIds")List<Integer> xqIds);

    @MapKey("pid")
    Map<String,Oldman> getAllOldman();

    List<Oldman> getBySearch(String search);

    void delHomeOldStatus();


    void updateHomeOldStatusById(Integer id);


    void delHomeOldStatusByIds(List<Integer> id);

    List<Oldman> getByDelOldmanIds(List<Integer> delOldmanId);

    void updateCommunityOldmanStatusById(Integer id);

    void delCommunityOldmanStatusByIds(String[] delOldmanId);

    Map<String,Long> getOldmanNum(@Param("xqIds") List<Integer> xqIds,@Param("start60") Date start60,@Param("start80") Date start80);

    Map<String,Long> getKeyNum(@Param("xqIds")List<Integer> xqIds,@Param("baseGoal") int baseGoal);

    List<Oldman> getIntegralSort(List<Integer> xqIds);

    void updateHomeOldStatusByOldmanIds(List<Integer> loadedData);

    void delAllOldStatusHandle();

    void updateOrganOldStatusByOldmanIds(List<Oldman> loadedData);

    void saveAllNoExist(List<Oldman> list);

    void changeIntegralByOldmanIds(@Param("ids") String[] oldmanIds,@Param("value") Integer value);

    void zeroIntegralByOldmanIds(String[] oldmanIds);

    void updateGoal(@Param("map") Map<Integer, Integer> goalHealthMap);

    List<Oldman> getKeyStatusByIds(List<Integer> oldmanIds);

    List<Map<Integer,Integer>> getKeyAddNum();

    List<Oldman> getAllOldmanKey();


    Set<Integer> getOrganOldmansMap(@Param("xqIds") List<Integer> xqIds);

    void updateByIdsSelect(@Param("oldman") List<Oldman> oldmanList_update, @Param("filed") Set<String> oldmanfiledNames);
}
