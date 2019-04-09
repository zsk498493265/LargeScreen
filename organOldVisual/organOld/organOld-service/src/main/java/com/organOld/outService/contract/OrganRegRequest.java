package com.organOld.outService.contract;

import org.springframework.web.multipart.MultipartFile;

public class OrganRegRequest {
    private Integer organFirType;

    private int id;
    private Integer organTypeId;
    private String name;
    private String intro;
    private String work;
    private String serviceTime;
    private String address;
    private String phone;
    private String webUrl;
    private MultipartFile pic;
    private Integer num;
    private String districtId;//所属片区名称 如果有的话
    private String[] auth;
    private String require;
    private String insitution;
    private Integer numIn;
    private Integer numRemain;
    private Integer parent;
    private Integer signCount;
    private Integer peopleNum;

    /**
     * 机构注册  注册人信息
     */
    private String personPhone;
    private String email;

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public Integer getSignCount() {
        return signCount;
    }

    public void setSignCount(Integer signCount) {
        this.signCount = signCount;
    }

    public Integer getOrganFirType() {
        return organFirType;
    }

    public void setOrganFirType(Integer organFirType) {
        this.organFirType = organFirType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getInsitution() {
        return insitution;
    }

    public void setInsitution(String insitution) {
        this.insitution = insitution;
    }

    public Integer getNumIn() {
        return numIn;
    }

    public void setNumIn(Integer numIn) {
        this.numIn = numIn;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getNumRemain() {
        return numRemain;
    }

    public void setNumRemain(Integer numRemain) {
        this.numRemain = numRemain;
    }

    public String[] getAuth() {
        return auth;
    }

    public void setAuth(String[] auth) {
        this.auth = auth;
    }

    public Integer getOrganTypeId() {
        return organTypeId;
    }

    public void setOrganTypeId(Integer organTypeId) {
        this.organTypeId = organTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public MultipartFile getPic() {
        return pic;
    }

    public void setPic(MultipartFile pic) {
        this.pic = pic;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
