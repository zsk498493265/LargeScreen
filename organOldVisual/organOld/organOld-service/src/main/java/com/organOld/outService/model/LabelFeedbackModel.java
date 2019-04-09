package com.organOld.outService.model;

import com.organOld.dao.entity.label.LabelManImplNum;

public class LabelFeedbackModel {
    private int organId;
    private String organName;
    private String time;
    private String districtName;
    private String remark;
    private String isFinish;
    private LabelManImplNum labelManImplNum;


    public LabelManImplNum getLabelManImplNum() {
        return labelManImplNum;
    }

    public void setLabelManImplNum(LabelManImplNum labelManImplNum) {
        this.labelManImplNum = labelManImplNum;
    }

    public int getOrganId() {
        return organId;
    }

    public void setOrganId(int organId) {
        this.organId = organId;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }
}
