package com.organOld.dao.repository;


import com.organOld.dao.entity.NumberHistory;
import com.organOld.dao.entity.ScheduleModel;
import com.organOld.dao.entity.home.Chx;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by netlab606 on 2018/6/16.
 */
public interface ScheduleDao extends BaseDao<NumberHistory,Integer>{

    ScheduleModel getSumNum(@Param("start60") Date start60,@Param("start70") Date start70,@Param("start80") Date start80, @Param("start90")Date start90);

    ScheduleModel getNum();
}
