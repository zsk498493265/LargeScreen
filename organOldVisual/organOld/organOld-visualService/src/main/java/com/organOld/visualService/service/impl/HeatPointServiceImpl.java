package com.organOld.visualService.service.impl;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.dao.repository.AutoValueDao;
import com.organOld.dao.repository.OldmanDao;
import com.organOld.dao.repository.visual.AutoValDao;
import com.organOld.dao.repository.visual.OrganVisualDao;
import com.organOld.dao.util.Page;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.OldmanRequest;
import com.organOld.outService.wrapper.OldmanWrapper;
import com.organOld.visualService.service.ComService;
import com.organOld.visualService.service.HeatPointService;
import com.organOld.visualService.service.model.Result;
import com.organOld.visualService.wrapper.OldsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HeatPointServiceImpl implements HeatPointService {
    @Autowired
    OldmanDao oldmanBaseDao;
    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    OrganVisualDao organDao;
    @Autowired
    AutoValDao autoValDao;
    @Autowired
    OldmanWrapper oldmanWrapper;
    @Autowired
    OldsWrapper oldsWrapper;
    @Autowired
    ComService comService;

    @Override
    public Result getNeiborAndNum(OldmanRequest oldsRequest, BTableRequest bTableRequest){
        Page<Oldman> page=comService.getPage(bTableRequest,"oldman_base");
        Oldman oldman= oldmanWrapper.unwrap(oldsRequest);
        Map<String,Long> dataMap = new HashMap<>();
        String[] jwIds = oldsRequest.getJw();
        if(jwIds.length > 0)
            for(int i=0;i<jwIds.length;++i)
            {
                String jwId = jwIds[i];
                comService.fillXqIds(jwId,oldman,oldsRequest.getDistrict());
                page.setEntity(oldman);
                Long size=oldmanBaseDao.getSizeByPage(page);
                if(jwId == "")
                    jwId = jwIds[++i];
                int id = Integer.parseInt(jwId);
                String name = organDao.getNameById(id);
                dataMap.put(name,size);
            }
        return new Result(true,dataMap);
    }
}


