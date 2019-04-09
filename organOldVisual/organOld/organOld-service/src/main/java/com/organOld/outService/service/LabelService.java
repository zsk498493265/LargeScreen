package com.organOld.outService.service;


import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.label.Label;
import com.organOld.dao.entity.label.LabelMan;
import com.organOld.dao.entity.label.LabelSec;
import com.organOld.outService.contract.*;
import com.organOld.outService.model.LabelAllRuleModel;
import com.organOld.outService.model.LabelFilterModel;
import com.organOld.outService.model.LabelRuleModel;
import com.organOld.outService.contract.Result;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by netlab606 on 2018/6/7.
 */
public interface LabelService {
    String getByPage(LabelRequest labelRequest, BTableRequest bTableRequest);

    String getBindManByPage(LabelManRequest labelManRequest, BTableRequest bTableRequest);

    String getNoSelectManDataByPage(OldmanRequest oldmanRequest, BTableRequest bTableRequest, int labelId);

    LabelAllRuleModel getLabelRule();

    LabelRuleModel getLabelRuleById(int labelId);

    void saveRule(LabelRuleRequest labelRuleRequest);

    Result getByOldmanId(int oldmanId);

    void save(Label label);

    Result saveLabelMan(int labelId, int[] oldmanIds);

    Result implement(LabelMan id);

    String getFeedbackByPage(LabelFeedbackRequest labelFeedbackRequest, BTableRequest bTableRequest);

    void feedbackAdd(LabelFeedbackAddRequest labelFeedbackAddRequest);

    Result getFeedbackByLabelId(int labelId);

    Result checkCanChange(int labelId);

    Result getSecLabelByFirType(int firType);
    LabelFilterModel getFilterLabelRule(int i);

    String getTypeByPage(int index, LabelTypeRequest labelTypeRequest, BTableRequest bTableRequest);

    void addOrUpdateFirType(AutoValue firType, String type);

    void addOrUpdateSecType(LabelSec labelSec, String type);

    Result getById(int id);

    void updateById(Label label);

    void delByIds(String[] ids);


    void delManByIds(String[] ids);

    void delTypeByIds(String[] ids);

    void export(HttpServletResponse response,LabelManRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
