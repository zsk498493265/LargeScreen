package com.organOld.visualService.wrapper;

import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.oldman.Xq;
import com.organOld.dao.entity.visual.Visual;
import com.organOld.outService.enumModel.OldStatusEnum;
import com.organOld.outService.enumModel.SexEnum;
import com.organOld.outService.model.OldmanModel;
import com.organOld.outService.service.AutoValueService;
import com.organOld.outService.service.CommonService;
import com.organOld.visualService.contract.VisualRequest;
import com.organOld.visualService.service.AutoValService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VisualWrap implements Wrapper<Visual,OldmanModel,VisualRequest> {
    @Autowired
    AutoValueService autoValueService;
    List<String> method=new ArrayList<>();
    Map<Integer,String> map=new HashMap<>();
    @Override
    public OldmanModel wrap(Visual visual){
        OldmanModel oldmanModel=new OldmanModel();
        oldmanModel.setName(visual.getName());
        oldmanModel.setPid(visual.getPid());
        if(visual.getBirthday()!=null)
            oldmanModel.setAge(CommonService.birthdayToAge(visual.getBirthday()));
        oldmanModel.setSex(SexEnum.getValue(visual.getSex()));
        if(visual.getOldStatus()!=null && visual.getOldStatus()!=0)
            oldmanModel.setOldStatus(OldStatusEnum.getValue(visual.getOldStatus()));
//        if(oldman.getLabelManList()!=null && oldman.getLabelManList().size()>0)
//            oldmanModel.setLabelManInfoModelList(oldman.getLabelManList().stream().map(Wrappers.labelWrapper::wrapManInfo).collect(Collectors.toList()));
        Xq xq=autoValueService.getXqById(visual.getXqId());
        if(xq!=null) {
            oldmanModel.setjName(xq.getJwName());
            oldmanModel.setxName(xq.getName());
            oldmanModel.setdName(xq.getDistrictName());
        }

        if(method.size()==0){
//            method.add("Family");
//            method.add("Economic");
            method.add("Census");
            method.add("PoliticalStatus");
        }
        if(map.size()==0){
            List<Integer> autoIds=commonService.getAutoValueTypes("oldman");
            List<AutoValue> autoValueList=autoValueService.getByTypeList(autoIds);
            autoValueList.forEach(s->map.put(s.getId(),s.getValue()));
        }
        commonService.fillAutoValue(visual,oldmanModel,method,map);
        return oldmanModel;

    }
    @Autowired
    CommonService commonService;

    @Override
    public Visual unwrap(VisualRequest visualRequest){
        Visual visual = new Visual();
        BeanUtils.copyProperties(visualRequest,visual);
        if(visualRequest.getAgeStart()!=null && !visualRequest.getAgeStart().equals(""))
            visual.setBirthdayEnd(commonService.AgeTobirthday(Integer.parseInt(visualRequest.getAgeStart())));
        if(visualRequest.getAgeEnd()!=null && !visualRequest.getAgeEnd().equals(""))
            visual.setBirthdayStart(commonService.AgeTobirthday(Integer.parseInt(visualRequest.getAgeEnd())));
        return visual;
    }

    public Map<String,Visual> unwrapAgeSex(VisualRequest visualRequest){
        Map<String,Visual> VisualMaps = new HashMap<>();
        visualRequest.setSex(1);
        visualRequest.setAgeStart("60");
        visualRequest.setAgeEnd("70");
        VisualMaps.put("numOfSixToSevenF",unwrap(visualRequest));
        visualRequest.setAgeStart("70");
        visualRequest.setAgeEnd("80");
        VisualMaps.put("numOfSevenToEightF",unwrap(visualRequest));
        visualRequest.setAgeStart("80");
        visualRequest.setAgeEnd("90");
        VisualMaps.put("numOfEightToNineF",unwrap(visualRequest));
        visualRequest.setAgeStart("90");
        visualRequest.setAgeEnd("140");
        VisualMaps.put("numOfOverNineF",unwrap(visualRequest));
        visualRequest.setSex(2);
        visualRequest.setAgeStart("60");
        visualRequest.setAgeEnd("70");
        VisualMaps.put("numOfSixToSevenM",unwrap(visualRequest));
        visualRequest.setAgeStart("70");
        visualRequest.setAgeEnd("80");
        VisualMaps.put("numOfSevenToEightM",unwrap(visualRequest));
        visualRequest.setAgeStart("80");
        visualRequest.setAgeEnd("90");
        VisualMaps.put("numOfEightToNineM",unwrap(visualRequest));
        visualRequest.setAgeStart("90");
        visualRequest.setAgeEnd("140");
        VisualMaps.put("numOfOverNineM",unwrap(visualRequest));
        return VisualMaps;
    }

    public Map<String,Visual> unwrapSex(VisualRequest visualRequest){
        Map<String,Visual> VisualMaps = new HashMap<>();
        visualRequest.setSex(1);
        VisualMaps.put("numOfFemale",unwrap(visualRequest));
        visualRequest.setSex(2);
        VisualMaps.put("numOfMale",unwrap(visualRequest));
        return VisualMaps;
    }

    public Map<String,Visual> unwrapCensus(VisualRequest visualRequest){
        Map<String,Visual> VisualMaps = new HashMap<>();
        String[] census = {"12"};
        visualRequest.setCensusArray(census);
        VisualMaps.put("numOfCensus",unwrap(visualRequest));
        String[] census1 = {"13","14"};
        visualRequest.setCensusArray(census1);
        VisualMaps.put("numOfNotCensus",unwrap(visualRequest));
        return VisualMaps;
    }


}
