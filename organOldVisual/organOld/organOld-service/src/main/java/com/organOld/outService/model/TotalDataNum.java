package com.organOld.outService.model;

public class TotalDataNum {
    private Long messageNum;
    private Long num80;
    private String bl;
    private Long oldmanNum;
    private Long organNum; //除 片区、居委

    public Long getOrganNum() {
        return organNum;
    }

    public void setOrganNum(Long organNum) {
        this.organNum = organNum;
    }

    public Long getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(Long messageNum) {
        this.messageNum = messageNum;
    }


    public Long getNum80() {
        return num80;
    }

    public void setNum80(Long num80) {
        this.num80 = num80;
    }

    public String getBl() {
        return bl;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }

    public Long getOldmanNum() {
        return oldmanNum;
    }

    public void setOldmanNum(Long oldmanNum) {
        this.oldmanNum = oldmanNum;
    }
}
