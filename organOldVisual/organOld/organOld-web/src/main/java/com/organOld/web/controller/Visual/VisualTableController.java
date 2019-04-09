package com.organOld.web.controller.Visual;

import com.organOld.outService.contract.BTableRequest;
import com.organOld.visualService.contract.OldsRequest;
import com.organOld.visualService.contract.VisualRequest;
import com.organOld.visualService.service.MyHPService;
import com.organOld.visualService.service.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/VTabel")
public class VisualTableController {
    @Autowired
    MyHPService myHPService;
    @ResponseBody
    @RequestMapping(value = "/getOld",method = RequestMethod.POST)
    public String getJwNum(VisualRequest visualRequest, BTableRequest bTableRequest,
                           @RequestParam(value = "census_array[]",required = false) String census[],
                           @RequestParam(value = "family_array[]",required = false) String family[],
                           @RequestParam(value = "economic_array[]",required = false) String economic[],
                           @RequestParam(value = "politicalStatus_array[]",required = false) String politicalStatus[],
                           @RequestParam(value = "isHealth_array[]",required = false) String isHealth[],
                           @RequestParam(value = "intelligence_array[]",required = false) String intelligence[],
                           @RequestParam(value = "eyesight_array[]",required = false) String eyesight[],
                           @RequestParam(value = "district_array[]",required = false) String district[],
                           @RequestParam(value = "jw_array[]",required = false) String jw[],
                           @RequestParam(value = "oldStatus_array[]",required = false) String oldStatus[],
                           @RequestParam(value = "sqzw_array[]",required = false) String sqzw[],
                           @RequestParam(value = "zc_array[]",required = false) String zc[],
                           @RequestParam(value = "familyType_array[]",required = false) String familyType[],
                           @RequestParam(value = "organId_array[]",required = false) String organId[],
                           @RequestParam(value = "secType_array[]",required = false) String secType[],
                           @RequestParam(value = "thirdType_array[]",required = false) String thirdType[],
                           @RequestParam(value = "forthType_array[]",required = false) String forthType[],
                           @RequestParam(value = "fifthType_array[]",required = false) String fifthType[],
                           @RequestParam(value = "sixthType_array[]",required = false) String sixthType[]) {
        visualRequest.setCensusArray(census);
        visualRequest.setFamilyArray(family);
        visualRequest.setEconomicArray(economic);
        visualRequest.setPoliticalStatusArray(politicalStatus);
        visualRequest.setIntelligence(intelligence);
        visualRequest.setIsHealth(isHealth);
        visualRequest.setEyesight(eyesight);
        visualRequest.setDistrict(district);
        visualRequest.setJw(jw);
        visualRequest.setFamilyTypeArray(familyType);
        visualRequest.setOldStatusArray(oldStatus);
        visualRequest.setOrganIdArray(organId);
        visualRequest.setSecTypeArray(secType);
        visualRequest.setThirdTypeArray(thirdType);
        visualRequest.setForthTypeArray(forthType);
        visualRequest.setFifthTypeArray(fifthType);
        visualRequest.setSixthTypeArray(sixthType);
        return myHPService.getVisualOlds(visualRequest, bTableRequest);
    }
}
