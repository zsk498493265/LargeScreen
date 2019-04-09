package com.organOld.web.controller.Visual;

import com.organOld.outService.contract.BTableRequest;
import com.organOld.visualService.contract.OldsRequest;
import com.organOld.visualService.contract.VisualRequest;
import com.organOld.visualService.service.ComService;
import com.organOld.visualService.service.MyHPService;
import com.organOld.visualService.service.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/chartchange")
public class ChartChangeController {
    @Autowired
    MyHPService myHPService;
    @Autowired
    ComService comService;

    @ResponseBody
    @RequestMapping(value = "/AgeSex",method = RequestMethod.GET)
    public Result getAgeSexTest(VisualRequest visualRequest,
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
                                @RequestParam(value = "sixthType_array[]",required = false) String sixthType[]
    ){
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
        return myHPService.getAgeSex(visualRequest);
    }
    @ResponseBody
    @RequestMapping(value = "/Sex",method = RequestMethod.GET)
    public Result getSexTest(VisualRequest visualRequest,
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
                                @RequestParam(value = "sixthType_array[]",required = false) String sixthType[]){
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
        return myHPService.getSexNum(visualRequest);
    }
    @ResponseBody
    @RequestMapping(value = "/Census",method = RequestMethod.GET)
    public Result getCensusTest(VisualRequest visualRequest,
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
                                @RequestParam(value = "sixthType_array[]",required = false) String sixthType[]){
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
        return myHPService.getCensusNum(visualRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/District",method = RequestMethod.GET)
    public Result getDistrictTest(VisualRequest visualRequest,
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
                                  @RequestParam(value = "sixthType_array[]",required = false) String sixthType[]){
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
        return myHPService.getDistrictNum(visualRequest);
    }
    @ResponseBody
    @RequestMapping(value = "/sexes",method = RequestMethod.GET)
    public Result getChangeOfSexes(OldsRequest oldsRequest, BTableRequest bTableRequest,
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
                                   @RequestParam(value = "secType_array[]",required = false) String secType[]) {
        oldsRequest.setCensusArray(census);
        oldsRequest.setFamilyArray(family);
        oldsRequest.setEconomicArray(economic);
        oldsRequest.setPoliticalStatusArray(politicalStatus);
        oldsRequest.setIntelligence(intelligence);
        oldsRequest.setEyesight(eyesight);
        oldsRequest.setDistrict(district);
        oldsRequest.setJw(jw);
        oldsRequest.setIsHealth(isHealth);
        oldsRequest.setOldStatusArray(oldStatus);
        oldsRequest.setSqzwArray(sqzw);
        oldsRequest.setZcArray(zc);
        oldsRequest.setFamilyTypeArray(familyType);
        oldsRequest.setOrganIds(organId);
        oldsRequest.setSecTypes(secType);
        return myHPService.getNumOfSexes(oldsRequest,bTableRequest);
    }
    @ResponseBody
    @RequestMapping(value = "/census",method = RequestMethod.GET)
    public Result getChangeOfCensus(OldsRequest oldsRequest, BTableRequest bTableRequest,
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
                                    @RequestParam(value = "secType_array[]",required = false) String secType[]) {
        oldsRequest.setCensusArray(census);
        oldsRequest.setFamilyArray(family);
        oldsRequest.setEconomicArray(economic);
        oldsRequest.setPoliticalStatusArray(politicalStatus);
        oldsRequest.setIntelligence(intelligence);
        oldsRequest.setEyesight(eyesight);
        oldsRequest.setDistrict(district);
        oldsRequest.setJw(jw);
        oldsRequest.setIsHealth(isHealth);
        oldsRequest.setOldStatusArray(oldStatus);
        oldsRequest.setSqzwArray(sqzw);
        oldsRequest.setZcArray(zc);
        oldsRequest.setFamilyTypeArray(familyType);
        oldsRequest.setOrganIds(organId);
        oldsRequest.setSecTypes(secType);
        return myHPService.getNumOfCensus(oldsRequest,bTableRequest);
    }
    @ResponseBody
    @RequestMapping(value= "/district",method = RequestMethod.GET)
    public Result getNumOfDistrict(OldsRequest oldsRequest, BTableRequest bTableRequest,
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
                                   @RequestParam(value = "secType_array[]",required = false) String secType[]){
        oldsRequest.setCensusArray(census);
        oldsRequest.setFamilyArray(family);
        oldsRequest.setEconomicArray(economic);
        oldsRequest.setPoliticalStatusArray(politicalStatus);
        oldsRequest.setIntelligence(intelligence);
        oldsRequest.setEyesight(eyesight);
        oldsRequest.setDistrict(district);
        oldsRequest.setJw(jw);
        oldsRequest.setIsHealth(isHealth);
        oldsRequest.setOldStatusArray(oldStatus);
        oldsRequest.setSqzwArray(sqzw);
        oldsRequest.setZcArray(zc);
        oldsRequest.setFamilyTypeArray(familyType);
        oldsRequest.setOrganIds(organId);
        oldsRequest.setSecTypes(secType);
        return myHPService.getNumOfDistrict(oldsRequest,bTableRequest);
    }
}
