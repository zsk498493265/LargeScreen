package com.organOld.outService.model;


import java.util.ArrayList;
import java.util.List;

public class OldmanModel extends ManModel{
    private String sex;
    private String census;//户籍
    private Integer age;//年龄
    private Integer isVolunteer;//是否是志愿者
    private String politicalStatus;//政治面貌
    private String address;//地址
    private String pid;//身份证号码
    private String louNum;//楼号
    private String xName;//小区名称
    private String jName;//居委名称
    private String dName;//片区名称
    private String oldStatus;
    private String zc;
    private List<String> sqzw=new ArrayList<>();
    private List<String>family=new ArrayList<>();
    private List<String> economic=new ArrayList<>();
    private List<String> familyType=new ArrayList<>();
    private Integer integral;
    private String birthday;


//    private List<LabelManInfoModel> labelManInfoModelList;


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getIsVolunteer() {
        return isVolunteer;
    }

    public void setIsVolunteer(Integer isVolunteer) {
        this.isVolunteer = isVolunteer;
    }

    public List<String> getFamilyType() {
        return familyType;
    }

    public void setFamilyType(List<String> familyType) {
        this.familyType = familyType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getLouNum() {
        return louNum;
    }

    public void setLouNum(String louNum) {
        this.louNum = louNum;
    }

    public String getxName() {
        return xName;
    }

    public void setxName(String xName) {
        this.xName = xName;
    }

    public String getZc() {
        return zc;
    }

    public void setZc(String zc) {
        this.zc = zc;
    }

    public List<String> getSqzw() {
        return sqzw;
    }

    public void setSqzw(List<String> sqzw) {
        this.sqzw = sqzw;
    }

    public List<String> getFamily() {
        return family;
    }

    public void setFamily(List<String> family) {
        this.family = family;
    }

    public List<String> getEconomic() {
        return economic;
    }

    public void setEconomic(List<String> economic) {
        this.economic = economic;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCensus() {
        return census;
    }

    public void setCensus(String census) {
        this.census = census;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }


    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
