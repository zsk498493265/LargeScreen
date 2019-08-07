package com.organOld.visualService.service.model;

import com.organOld.dao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by netlab606 on 2018/4/1.
 */
@Service
public class OldmanServiceImpl2 implements OldmanService {

    @Autowired
    VisualDataDao visualDataDao;

    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="+fileName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Map<String,Long>> getVisualData(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualData(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualData1(Date date1, Date date2,Date date3,Date date4,String preMonth) {
        return visualDataDao.getVisualData1(date1,date2,date3,date4,preMonth);
    }

    @Override
    public List<Map<String,Long>> getVisualData2(Date date1, Date date2,Date date3,Date date4,String preMonth) {
        return visualDataDao.getVisualData2(date1,date2,date3,date4,preMonth);
    }

    @Override
    public List<Map<String,Long>> getVisualData3(Date date1, Date date2,Date date3,Date date4,String preMonth) {
        return visualDataDao.getVisualData3(date1,date2,date3,date4,preMonth);
    }

    @Override
    public List<Map<String,Long>> getVisualData4(Date date1, Date date2,Date date3,Date date4,String preMonth) {
        return visualDataDao.getVisualData4(date1,date2,date3,date4,preMonth);
    }

    @Override
    public List<Map<String,Integer>> getVisualData5(Date date1, Date date2,Date date3,Date date4,Date date5,Date date6,Date date7,Date date8,Date date9,String preMonth) {
        return visualDataDao.getVisualData5(date1,date2,date3,date4,date5,date6,date7,date8,date9,preMonth);
    }

    @Override
    public List<Map<String,String>> getOrganInfo() {
        return visualDataDao.getOrganInfo();
    }
    @Override
    public List<Map<String,Long>> getVisualDataApartFinish(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartFinish(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartOldman(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartOldman(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartTotal(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartTotal(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartOrgan(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartOrgan(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartFamily(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartFamily(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartHealth(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartHealth(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartEconomic(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartEconomic(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartYLY(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartYLY(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartRZ(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartRZ(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartFuWu(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartFuWu(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartBase(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartBase(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartZZ(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartZZ(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartZC(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartZC(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartCHX(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartCHX(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartZNH(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartZNH(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartJTYS(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartJTYS(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartJTBC(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartJTBC(date1,date2,date3,date4);
    }

    @Override
    public List<Map<String,Long>> getVisualDataApartLabel(Date date1, Date date2,Date date3,Date date4) {
        return visualDataDao.getVisualDataApartLabel(date1,date2,date3,date4);
    }

    @Override
    public void updateVisualData(String date) {
         visualDataDao.updateVisualData(date);
    }

    @Override
    public void deleteOldVisualData() {
        visualDataDao.deleteOldVisualData();
    }

    @Override
    public void updateOrganAndNews(String name, String content) {
        visualDataDao.updateOrganAndNews(name,content);
    }
}
