package com.organOld.outService.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.outService.contract.AutoValueRequest;
import com.organOld.outService.model.AutoValueModel;
import com.organOld.outService.service.CommonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by netlab606 on 2018/7/25.
 */
@Service
public class AutoValueWrapper implements Wrapper<AutoValue,AutoValueModel,AutoValueRequest> {

    @Autowired
    CommonService commonService;

    @Override
    public AutoValueModel wrap(AutoValue autoValue) {
        AutoValueModel autoValueModel=new AutoValueModel();
        BeanUtils.copyProperties(autoValue,autoValueModel);
        return autoValueModel;
    }

    @Override
    public AutoValue unwrap(AutoValueRequest autoValueRequest) {
        AutoValue autoValue=new AutoValue();
        BeanUtils.copyProperties(autoValueRequest,autoValue);
        Integer organId=commonService.getIdBySession();
        if(organId!=null && organId!=0)
            autoValue.setParentIndex(organId);
        return autoValue;
    }
}
