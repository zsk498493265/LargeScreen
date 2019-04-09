package com.organOld.outService.model;

/**
 *
 * Created by netlab606 on 2018/8/9.
 */
public class TotalDataOldStatus implements TotalData{
    private Long organOldNum;
    private Long communityOldNum;
    private Long familyOldNum;
    private Long cfOldNum;


    public Long getCfOldNum() {
        return cfOldNum;
    }

    public void setCfOldNum(Long cfOldNum) {
        this.cfOldNum = cfOldNum;
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

    public Long getFamilyOldNum() {
        return familyOldNum;
    }

    public void setFamilyOldNum(Long familyOldNum) {
        this.familyOldNum = familyOldNum;
    }
}
