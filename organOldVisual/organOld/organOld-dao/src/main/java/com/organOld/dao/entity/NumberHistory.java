package com.organOld.dao.entity;

public class NumberHistory extends DBEntity{
    private Integer type;
    private long num;
    private String tm;

    public NumberHistory(Integer type, Long num, String tm) {
        this.type = type;
        this.num = num;
        this.tm = tm;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }
}
