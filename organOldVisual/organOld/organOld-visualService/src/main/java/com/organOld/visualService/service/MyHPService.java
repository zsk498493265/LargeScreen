package com.organOld.visualService.service;

import com.organOld.dao.entity.oldman.Oldman;
import com.organOld.outService.contract.BTableRequest;
import com.organOld.visualService.contract.OldsRequest;
import com.organOld.visualService.contract.VisualRequest;
import com.organOld.visualService.service.model.Result;

public interface MyHPService {
    Result getJwAndNum(OldsRequest oldsRequest, BTableRequest bTableRequest);

    Result getJwAndNumT(VisualRequest visualRequest);

    Result getAgeSex(VisualRequest visualRequest);

    Result getSexNum(VisualRequest visualRequest);

    Result getCensusNum(VisualRequest visualRequest);

    Result getDistrictNum(VisualRequest visualRequest);

    Result getNumofAges(OldsRequest oldsRequest,BTableRequest bTableRequest);

    Result getNumOfSexes(OldsRequest oldsRequest,BTableRequest bTableRequest);

    Result getNumOfCensus(OldsRequest oldsRequest,BTableRequest bTableRequest);

    Result getNumOfDistrict(OldsRequest oldsRequest,BTableRequest bTableRequest);

    Result getNumOfJwTest(OldsRequest oldsRequest,BTableRequest bTableRequest);

    String getVisualOlds(VisualRequest visualRequest,BTableRequest bTableRequest);
}
