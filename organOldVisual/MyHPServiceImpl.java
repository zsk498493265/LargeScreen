package com.organOld.visualService.service.impl;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.entity.visual.Visual;
import com.organOld.dao.repository.OrganDao;
import com.organOld.dao.repository.visual.*;
import com.organOld.dao.util.Page;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.visualService.contract.OldsRequest;
import com.organOld.visualService.contract.VisualRequest;
import com.organOld.visualService.enumModel.NeiboEnum;
import com.organOld.visualService.service.AutoValService;
import com.organOld.visualService.service.ComService;
import com.organOld.visualService.service.MyHPService;
import com.organOld.visualService.service.model.Result;
import com.organOld.visualService.wrapper.OldsWrapper;
import com.organOld.visualService.wrapper.VisualWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.organOld.visualService.util.Tool.AgeTobirthday;

@Service
public class MyHPServiceImpl implements MyHPService {
    @Autowired
    ComService comService;
    @Autowired
    VisualLabelDao visualLabelDao;
    @Autowired
    OldsWrapper oldsWrapper;
    @Autowired
    VisualOldmanDao visualOldmanDao;
    @Autowired
    OrganVisualDao organDao;
    @Autowired
    VisualSexDao visualSexDao;
    @Autowired
    VisualCensusDao visualCensusDao;
    @Autowired
    VisualDistrictDao visualDistrictDao;
    @Autowired
    AutoValDao autoValDao;
    @Autowired
    VisualViewDao visualViewDao;
    @Autowired
    VisualLabelDaoT visualLabelDaoT;
    @Autowired
    VisualLabelDaoTh visualLabelDaoTh;
    @Autowired
    VisualWrap visualWrap;

    @Override
    public Result getJwAndNum(OldsRequest oldsRequest, BTableRequest bTableRequest){
        Page<Oldman> page=comService.getPage(bTableRequest,"oldman_base");
        Oldman oldman = oldsWrapper.unwrap(oldsRequest);
        Map<String,Long> dataMap = new HashMap<>();
        String[] jwIds = oldsRequest.getJw();
        if(jwIds.length > 0)
            for(int i=0;i<jwIds.length;++i)
            {
                String jwId = jwIds[i];
                comService.fillXqIds(jwId,oldman,oldsRequest.getDistrict());
                page.setEntity(oldman);
                Long size;
                if(oldman.getIsHealth() == null && oldman.getIntelligence() == null && oldman.getEyesight() == null)
                    size = visualOldmanDao.getSizeByPageFive(page);
                else
                    size = visualOldmanDao.getSizeByPageSix(page);
                if(jwId == "")
                    jwId = jwIds[++i];
                int id = Integer.parseInt(jwId);
                String name = organDao.getNameById(id);
                dataMap.put(name,size);
            }
        return new Result(true,dataMap);
    }
    @Override
    public Result getJwAndNumT(VisualRequest visualRequest){
        Visual visual = visualWrap.unwrap(visualRequest);
        Map<String,Long> dataMap = new HashMap<>();
        String[] jwIds = visualRequest.getJw();
        if(jwIds.length > 0)
            for(int i=0;i<jwIds.length;++i) {
                String jwId = jwIds[i];
                comService.fillXqIds(jwId, visual, visualRequest.getDistrict());
                Long size = visualViewDao.getVisualSizeByView(visual);
                if(jwId == "")
                    jwId = jwIds[++i];
                int id = Integer.parseInt(jwId);
                String name = organDao.getNameById(id);
                dataMap.put(name,size);
            }
        return new Result(true,dataMap);
    }

    @Override
    public Result getNumofAges(OldsRequest oldsRequest,BTableRequest bTableRequest){
        Page<Oldman> page=comService.getPage(bTableRequest,"oldman_base");
        Oldman oldman = oldsWrapper.unwrap(oldsRequest);
        if(oldsRequest.getDistrict() != null)
            comService.fillXq(oldsRequest,oldman);
        page.setEntity(oldman);
        Map<String,Long> dataMap = new HashMap<>();
        if(oldman.getIsHealth() == null && oldman.getIntelligence() == null && oldman.getEyesight() == null)
            dataMap = visualLabelDao.getVisualDataApart(page,AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));
        else
            dataMap = visualLabelDaoT.getVisualDataApart(page,AgeTobirthday(60), AgeTobirthday(70), AgeTobirthday(80), AgeTobirthday(90));

        return new Result(true,dataMap);
    }

    @Override
    public Result getNumOfSexes(OldsRequest oldsRequest,BTableRequest bTableRequest){
        Page<Oldman> page=comService.getPage(bTableRequest,"oldman_base");
        Oldman oldman = oldsWrapper.unwrap(oldsRequest);
        comService.fillXq(oldsRequest,oldman);
        page.setEntity(oldman);
        Map<String,Long> dataMap = new HashMap<>();
        if(oldman.getIsHealth() == null && oldman.getOrganList() == null && oldman.getHomeList() == null &&oldman.getIntelligence() == null && oldman.getEyesight() == null)
            dataMap = visualSexDao.getNumOfSexes(page);
        else if(oldman.getOrganList() != null)
            dataMap = visualSexDao.getNumOfSexesF(page);
        else if(oldman.getHomeList() == null)
            dataMap = visualSexDao.getNumOfSexesT(page);
        else
            dataMap = visualSexDao.getNumOfSexesTh(page);

        return new Result(true,dataMap);
    }

    @Override
    public Result getNumOfCensus(OldsRequest oldsRequest,BTableRequest bTableRequest){
        Page<Oldman> page=comService.getPage(bTableRequest,"oldman_base");
        Oldman oldman = oldsWrapper.unwrap(oldsRequest);
        comService.fillXq(oldsRequest,oldman);
        page.setEntity(oldman);
        Map<String,Long> dataMap = new HashMap<>();
        if(oldman.getIsHealth() == null && oldman.getOrganList() == null && oldman.getHomeList() == null &&oldman.getIntelligence() == null && oldman.getEyesight() == null)
            dataMap = visualCensusDao.getNumOfCensus(page);
        else if(oldman.getOrganList() != null)
            dataMap = visualCensusDao.getNumOfCensusF(page);
        else if(oldman.getHomeList() == null)
            dataMap = visualCensusDao.getNumOfCensusT(page);
        else
            dataMap = visualCensusDao.getNumOfCensusTh(page);

        return new Result(true,dataMap);
    }

    @Override
    public Result getNumOfDistrict(OldsRequest oldsRequest,BTableRequest bTableRequest){
        Page<Oldman> page=comService.getPage(bTableRequest,"oldman_base");
        Oldman oldman = oldsWrapper.unwrap(oldsRequest);
        Map<String,Long> dataMap = new HashMap<>();
        page.setEntity(oldman);
        String[] disIds = {"1","2","3","4","5","6"};
        if(disIds.length>0){
            for(Integer i=0;i<disIds.length;i++){
                String disId = disIds[i];
                List<Integer> xqIds = visualDistrictDao.getXqIdsByDis(disId);
                Long size;
                if(oldman.getIsHealth() == null && oldman.getOrganList() == null && oldman.getHomeList() == null&&oldman.getIntelligence() == null && oldman.getEyesight() == null)
                    size  = visualDistrictDao.getNumOfDistrict(page,xqIds);
                else if(oldman.getOrganList() != null)
                    size  = visualDistrictDao.getNumOfDistrictF(page,xqIds);
                else if(oldman.getHomeList() == null)
                    size  = visualDistrictDao.getNumOfDistrictT(page,xqIds);
                else
                    size  = visualDistrictDao.getNumOfDistrictTh(page,xqIds);

                dataMap.put(trueName(i),size);
            }
        }
        return new Result(true,dataMap);
    }

    public String trueName(Integer i){
        if(i == 0)
            return "gumei";
        else if(i == 1)
            return "gulong";
        else if(i == 2)
            return "donglan";
        else if(i == 3)
            return "pingji";
        else if(i == 4)
            return  "pingyang";
        else if(i == 5)
            return "pingnan";
        return null;
    }

    @Override
    public Result getNumOfJwTest(OldsRequest oldsRequest,BTableRequest bTableRequest) {
        Page<Oldman> page = comService.getPage(bTableRequest, "oldman_base");
        Oldman oldman = oldsWrapper.unwrap(oldsRequest);
        Map<String, Long> dataMap = new HashMap<>();
        page.setEntity(oldman);
        String[] jwIds = {"1", "2", "3", "13", "45", "58", "59", "60", "63", "66", "67", "84", "85", "87", "88", "89", "90", "93", "97", "98", "99", "100", "101", "102", "103", "104", "105"
                , "106", "107", "108", "119", "120", "121", "122", "123", "124", "125", "126", "134", "135"};
        for (Integer i = 0; i < jwIds.length; i++) {
            String jwId = jwIds[i];
            List<Integer> xqIds = autoValDao.getXqIdsByJwId(jwId);
            Long size;
            if(xqIds.size() == 0)
                size = 0L;
            else
                size = visualDistrictDao.getNumOfDistrict(page, xqIds);
            dataMap.put(NeiboEnum.getValue(Integer.parseInt(jwId)), size);
        }
        return new Result(true,dataMap);
    }
    }

