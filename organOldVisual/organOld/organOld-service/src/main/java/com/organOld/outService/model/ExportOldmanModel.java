package com.organOld.outService.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by netlab606 on 2018/7/29.
 */
public class ExportOldmanModel extends Model{
    private String name;
    private String pName;
    private String jName;
    private String xName;
    private String louNum;
    private String sex;
    private String birthday;
    private String politicalStatus;
    private String census;
    private String phone;
    private String pid;
    private String address;
    private String zc;
    private String oldStatus;
    private String link;

    private List<String> family=new ArrayList<>();
    private List<String> economic=new ArrayList<>();
    private String bloodType;
    private String intelligence;//失智
    private String eyesight;//视力

    private List<String> sqzw=new ArrayList<>();
    private List<String> familyType=new ArrayList<>();

    private String mb="";
    private String sn="";
    private String exzl="";
    private String gz="";
    private String cj="";
    private String ywfy="";


    public List<String> getSqzw() {
        return sqzw;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setSqzw(List<String> sqzw) {
        this.sqzw = sqzw;
    }

    public List<String> getFamilyType() {
        return familyType;
    }

    public void setFamilyType(List<String> familyType) {
        this.familyType = familyType;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getMb() {
        return mb;
    }

    public void setMb(String mb) {
        this.mb = mb;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getExzl() {
        return exzl;
    }

    public void setExzl(String exzl) {
        this.exzl = exzl;
    }

    public String getGz() {
        return gz;
    }

    public void setGz(String gz) {
        this.gz = gz;
    }

    public String getCj() {
        return cj;
    }

    public void setCj(String cj) {
        this.cj = cj;
    }

    public String getYwfy() {
        return ywfy;
    }

    public void setYwfy(String ywfy) {
        this.ywfy = ywfy;
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

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getEyesight() {
        return eyesight;
    }

    public void setEyesight(String eyesight) {
        this.eyesight = eyesight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public String getxName() {
        return xName;
    }

    public void setxName(String xName) {
        this.xName = xName;
    }

    public String getLouNum() {
        return louNum;
    }

    public void setLouNum(String louNum) {
        this.louNum = louNum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getCensus() {
        return census;
    }

    public void setCensus(String census) {
        this.census = census;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZc() {
        return zc;
    }

    public void setZc(String zc) {
        this.zc = zc;
    }

}
