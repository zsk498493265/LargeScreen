package com.organOld.outService.model;

/**
 *
 * Created by netlab606 on 2018/8/9.
 */
public class TotalDataKey implements TotalData{
    private Long apNum;
    private Long clNum;
    private Long num;

    public Long getApNum() {
        return apNum;
    }

    public void setApNum(Long apNum) {
        this.apNum = apNum;
    }

    public Long getClNum() {
        return clNum;
    }

    public void setClNum(Long clNum) {
        this.clNum = clNum;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
