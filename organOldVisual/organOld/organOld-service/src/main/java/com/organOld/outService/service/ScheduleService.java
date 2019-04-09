package com.organOld.outService.service;

import com.organOld.dao.entity.NumberHistory;
import com.organOld.dao.repository.ScheduleDao;
import com.organOld.dao.entity.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;
    @Autowired
    OrganService organService;
    @Autowired
    CommonService commonService;

    @Scheduled(cron = "0 0 1 1 * ? ")
    public void demoSchedule() {
        Date start60=CommonService.AgeTobirthday(60);
        Date start80=CommonService.AgeTobirthday(80);
        Date start90=CommonService.AgeTobirthday(90);
        Date start70=CommonService.AgeTobirthday(70);

        ScheduleModel manSumModel=scheduleDao.getSumNum(start60,start70,start80,start90);
        ScheduleModel model=scheduleDao.getNum();
        Integer manSum=organService.getPeopleNum();

        List<NumberHistory> numberHistoryList=new ArrayList<>();
        String tm=commonService.getToday();
        numberHistoryList.add(new NumberHistory(1,(long)manSum,tm));
        numberHistoryList.add(new NumberHistory(21,model.getHj(),tm));
        numberHistoryList.add(new NumberHistory(22,model.getFhj(),tm));
        numberHistoryList.add(new NumberHistory(31,model.getNan(),tm));
        numberHistoryList.add(new NumberHistory(32,model.getNv(),tm));
        numberHistoryList.add(new NumberHistory(41,manSumModel.getOldman60(),tm));
        numberHistoryList.add(new NumberHistory(42,manSumModel.getOldman70(),tm));
        numberHistoryList.add(new NumberHistory(43,manSumModel.getOldman80(),tm));
        numberHistoryList.add(new NumberHistory(44,manSumModel.getOldman90(),tm));
        numberHistoryList.add(new NumberHistory(51,model.getCl(),tm));
        numberHistoryList.add(new NumberHistory(52,model.getDj(),tm));
        numberHistoryList.add(new NumberHistory(53,model.getSd(),tm));
        numberHistoryList.add(new NumberHistory(54,model.getYlyyl(),tm));
        numberHistoryList.add(new NumberHistory(55,model.getGl(),tm));
        numberHistoryList.add(new NumberHistory(56,model.getSz(),tm));
        numberHistoryList.add(new NumberHistory(57,model.getQt(),tm));
        numberHistoryList.add(new NumberHistory(61,model.getSn(),tm));
        numberHistoryList.add(new NumberHistory(62,model.getMb(),tm));
        numberHistoryList.add(new NumberHistory(63,model.getZls(),tm));
        numberHistoryList.add(new NumberHistory(64,model.getGzs(),tm));
        numberHistoryList.add(new NumberHistory(65,model.getJkztSz(),tm));
        numberHistoryList.add(new NumberHistory(66,model.getChx(),tm));
        numberHistoryList.add(new NumberHistory(71,model.getBk(),tm));
        numberHistoryList.add(new NumberHistory(72,model.getDb(),tm));
        numberHistoryList.add(new NumberHistory(73,model.getYlbx(),tm));
        numberHistoryList.add(new NumberHistory(74,model.getYljzj(),tm));
        numberHistoryList.add(new NumberHistory(75,model.getCzyb(),tm));
        numberHistoryList.add(new NumberHistory(76,model.getJjtjQt(),tm));

        scheduleDao.saveAll(numberHistoryList);
    }
}
