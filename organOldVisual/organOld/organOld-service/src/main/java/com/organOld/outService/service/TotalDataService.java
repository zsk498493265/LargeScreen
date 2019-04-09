package com.organOld.outService.service;

import com.organOld.outService.contract.Result;
import com.organOld.outService.model.TotalDataNum;

/**
 * Created by netlab606 on 2018/8/9.
 */
public interface TotalDataService {
    Result getOldStatus();

    String getRoleBySession() throws Exception;

    Result getIntegralSort();

    Result getOldmanNum();

    Result getKeyNum();

    Result getHealthNum();

    Result getOrganNum();

    TotalDataNum getNum(String role);

    Result getOrganBedNum();

    Result getOrganOldmanNum();


    Result getOrganOldmanHisNum();
}
