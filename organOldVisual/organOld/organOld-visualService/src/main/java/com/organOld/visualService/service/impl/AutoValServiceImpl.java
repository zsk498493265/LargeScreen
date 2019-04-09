package com.organOld.visualService.service.impl;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.Xq;
import com.organOld.dao.repository.AutoValueDao;
import com.organOld.dao.util.Page;
import com.organOld.outService.contract.AutoValueRequest;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.Result;
import com.organOld.outService.model.AutoValueModel;
import com.organOld.visualService.service.AutoValService;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.wrapper.AutoValueWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service


public class AutoValServiceImpl implements AutoValService {

    @Autowired
    AutoValueDao autoValueDao;
    @Autowired
    CommonService commonService;
    @Autowired
    AutoValueWrapper autoValueWrapper;

    @Override
    public List<AutoValue> getByType(int type) {
        return autoValueDao.getByType(type);
    }


    @Override
    public String getByPage(AutoValueRequest autoValueRequest, BTableRequest bTableRequest) {
        Page<AutoValue> page=commonService.getPage(bTableRequest,"auto_value");
        AutoValue autoValue= autoValueWrapper.unwrap(autoValueRequest);
        page.setEntity(autoValue);
        List<AutoValueModel> autoValueModelList=autoValueDao.getByPage(page).stream().map(autoValueWrapper::wrap).collect(Collectors.toList());
        Long size=autoValueDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,autoValueModelList);
    }

    @Override
    public Result getById(int id) {
        return new Result(true,autoValueDao.getById(id));
    }

    @Override
    public void handle(String type, AutoValue autoValue) {
        if(type.equals("add")){
            autoValueDao.save(autoValue);
        }else{
            autoValueDao.updateById(autoValue);
        }
    }

    @Override
    public void delByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        autoValueDao.delByIds(id);
    }

    @Override
    public List<AutoValue> getByIds(String[] sq) {
        return autoValueDao.getByIds(sq);
    }

    @Override
    public Xq getXqById(Integer xqId) {
        return autoValueDao.getXqById(xqId);
    }


    @Override
    public List<AutoValue> getByTypeList(List<Integer> type) {
        return autoValueDao.getByTypeList(type);
    }


    @Override
    public List<Integer> getXqIdsByJwIds(String[] jw) {
        return autoValueDao.getXqIdsByJwIds(jw);
    }

    @Override
    public List<Integer> getXqIdsByPqIds(String[] district) {
        return autoValueDao.getXqIdsByPqIds(district);
    }

    @Override
    public List<Integer> getXqIdsByUsername(String userNameBySession) {
        return autoValueDao.getXqIdsByUsername(userNameBySession);
    }

    @Override
    public Integer getStringLikeIndex(String stringCellValue, int index, String like) {
        return autoValueDao.getStringLikeIndex(stringCellValue,index,like);
    }

    @Override
    public Long getNumByType(int index) {
        return autoValueDao.getNumByType(index);
    }
}
