package com.organOld.outService.model;

public class TotalDataOrganBedNum implements TotalData{
    private Long num;
    private Long inNum;
    private Long remainNum;

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getInNum() {
        return inNum;
    }

    public void setInNum(Long inNum) {
        this.inNum = inNum;
    }

    public Long getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Long remainNum) {
        this.remainNum = remainNum;
    }
}
