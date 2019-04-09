package com.organOld.visualService.service;

import com.organOld.outService.contract.BTableRequest;
import com.organOld.outService.contract.OldmanRequest;
import com.organOld.visualService.service.model.Result;

public interface HeatPointService {
    Result getNeiborAndNum(OldmanRequest oldsRequest, BTableRequest bTableRequest);
}
