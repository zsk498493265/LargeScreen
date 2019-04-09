package com.organOld.outService.model;

/**
 *
 * Created by netlab606 on 2018/8/9.
 */
public class TotalDataOrgan implements TotalData{
    private Long govNum;
    private Long societyNum;
    private Long organOldNum;
    private Long communityOldNum;

    public Long getGovNum() {
        return govNum;
    }

    public void setGovNum(Long govNum) {
        this.govNum = govNum;
    }

    public Long getSocietyNum() {
        return societyNum;
    }

    public void setSocietyNum(Long societyNum) {
        this.societyNum = societyNum;
    }

    public Long getOrganOldNum() {
        return organOldNum;
    }

    public void setOrganOldNum(Long organOldNum) {
        this.organOldNum = organOldNum;
    }

    public Long getCommunityOldNum() {
        return communityOldNum;
    }

    public void setCommunityOldNum(Long communityOldNum) {
        this.communityOldNum = communityOldNum;
    }
}
