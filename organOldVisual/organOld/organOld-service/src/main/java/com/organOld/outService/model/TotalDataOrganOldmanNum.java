package com.organOld.outService.model;

public class TotalDataOrganOldmanNum implements TotalData{
    private Long num;
    private Long pdNum;//排队的数量
    private Long noPdNum;//不排队的数量
    private Long inNum;//不在当前数据库数量
    private Long outNum;//在当前数据库数量

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getPdNum() {
        return pdNum;
    }

    public void setPdNum(Long pdNum) {
        this.pdNum = pdNum;
    }

    public Long getNoPdNum() {
        return noPdNum;
    }

    public void setNoPdNum(Long noPdNum) {
        this.noPdNum = noPdNum;
    }

    public Long getInNum() {
        return inNum;
    }

    public void setInNum(Long inNum) {
        this.inNum = inNum;
    }

    public Long getOutNum() {
        return outNum;
    }

    public void setOutNum(Long outNum) {
        this.outNum = outNum;
    }
}
