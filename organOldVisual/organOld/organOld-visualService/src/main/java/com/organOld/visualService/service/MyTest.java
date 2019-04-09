package com.organOld.visualService.service;

import com.organOld.dao.repository.visual.VisualDistrictDao;
import com.organOld.dao.repository.visual.VisualLabelDao;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.visualService.contract.OldsRequest;
import com.organOld.visualService.contract.VisualRequest;
import com.organOld.visualService.service.model.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class MyTest {
    @Autowired
    VisualLabelDao visualLabelDao;
    @Autowired
    MyHPService myHPService;
    @Autowired
    AutoValService autoValService;
    @Autowired
    VisualDistrictDao visualDistrictDao;

    @Test
    public void testLabel(){
        BTableRequest bTableRequest = new BTableRequest();
        OldsRequest oldsRequest = new OldsRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        Result result = myHPService.getNumofAges(oldsRequest,bTableRequest);
        result.getData();
    }

    @Test
    public void testOutVisual(){
        BTableRequest bTableRequest = new BTableRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        OldsRequest oldmanRequest = new OldsRequest();
        String[] jwIds = {"1","58","59","2"};
        oldmanRequest.setJw(jwIds);
        Result conse = myHPService.getJwAndNum(oldmanRequest,bTableRequest);
        conse.getData();
    }
    @Test
    public void testSexChart(){
        BTableRequest bTableRequest = new BTableRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        OldsRequest oldmanRequest = new OldsRequest();
        Result result = myHPService.getNumOfSexes(oldmanRequest,bTableRequest);
        result.getData();
    }

    @Test
    public void testCensusChart(){
        BTableRequest bTableRequest = new BTableRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        OldsRequest oldmanRequest = new OldsRequest();
        Result result = myHPService.getNumOfCensus(oldmanRequest,bTableRequest);
        result.getData();
    }

    @Test
    public void testDistrict(){
        VisualRequest visualRequest = new VisualRequest();
        Result result = myHPService.getDistrictNum(visualRequest);
        result.getData();
    }

    @Test
    public void testJws(){
        BTableRequest bTableRequest = new BTableRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        OldsRequest oldmanRequest = new OldsRequest();
        Result result = myHPService.getNumOfJwTest(oldmanRequest,bTableRequest);
        result.getData();
    }

}
