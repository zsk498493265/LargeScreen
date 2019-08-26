package com.organOld.visualService.contract;

public class VisualRequest implements NeiboRequest {
    private int id;
    private String[] censusArray;//户籍
    private String[] district;//片区索引
    private String ageStart;//年龄段-起
    private String ageEnd;//年龄段-止
    private String[] jw;//居委索引
    private Integer sex;//1女 2男
    private String[] politicalStatusArray;//政治面貌
    private String[] familyArray;
    private String[] familyTypeArray;
    private String[] economicArray;
    private String[] intelligence;
    private String[] eyesight;
    private String[] oldStatusArray;
    private String politicalStatus;
    private String[] isHealth;
    private String[] organIdArray;
    private String[] secTypeArray;
    private String[] thirdTypeArray;
    private String[] forthTypeArray;
    private String[] fifthTypeArray;
    private String[] sixthTypeArray;
    private Integer isMb ;
    private Integer isSn ;
    private Integer isYwfy;
    private Integer isExzl ;
    private Integer isGz;
    private Integer isCj;
    private Integer zhucan ;
    private Integer zhuji ;
    private Integer zhujie ;
    private Integer zhuyu ;
    private Integer zhuxing ;
    private Integer zhuyi ;
    private Integer kangfu ;
    private Integer xiangtan ;
    private Integer xidi ;
    private Integer shenghuo ;
    private Integer isVolunteer;
    private Integer isService;
    private String name;

    public String[] getThirdTypeArray() {
        return thirdTypeArray;
    }

    public void setThirdTypeArray(String[] thirdTypeArray) {
        this.thirdTypeArray = thirdTypeArray;
    }

    public String[] getForthTypeArray() {
        return forthTypeArray;
    }

    public void setForthTypeArray(String[] forthTypeArray) {
        this.forthTypeArray = forthTypeArray;
    }

    public String[] getFifthTypeArray() {
        return fifthTypeArray;
    }

    public void setFifthTypeArray(String[] fifthTypeArray) {
        this.fifthTypeArray = fifthTypeArray;
    }

    public String[] getSixthTypeArray() {
        return sixthTypeArray;
    }

    public String[] getIsHealth() {
        return isHealth;
    }

    public void setIsHealth(String[] isHealth) {
        this.isHealth = isHealth;
    }

    public void setSixthTypeArray(String[] sixthTypeArray) {
        this.sixthTypeArray = sixthTypeArray;
    }

    public String[] getOldStatusArray() {
        return oldStatusArray;
    }

    public void setOldStatusArray(String[] oldStatusArray) {
        this.oldStatusArray = oldStatusArray;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getCensusArray() {
        return censusArray;
    }

    public void setCensusArray(String[] censusArray) {
        this.censusArray = censusArray;
    }

    @Override
    public String[] getDistrict() {
        return district;
    }

    public void setDistrict(String[] district) {
        this.district = district;
    }

    public String getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(String ageStart) {
        this.ageStart = ageStart;
    }

    public String getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(String ageEnd) {
        this.ageEnd = ageEnd;
    }

    @Override
    public String[] getJw() {
        return jw;
    }

    public void setJw(String[] jw) {
        this.jw = jw;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String[] getPoliticalStatusArray() {
        return politicalStatusArray;
    }

    public void setPoliticalStatusArray(String[] politicalStatusArray) {
        this.politicalStatusArray = politicalStatusArray;
    }

    public String[] getFamilyArray() {
        return familyArray;
    }

    public void setFamilyArray(String[] familyArray) {
        this.familyArray = familyArray;
    }

    public String[] getFamilyTypeArray() {
        return familyTypeArray;
    }

    public void setFamilyTypeArray(String[] familyTypeArray) {
        this.familyTypeArray = familyTypeArray;
    }

    public String[] getEconomicArray() {
        return economicArray;
    }

    public void setEconomicArray(String[] economicArray) {
        this.economicArray = economicArray;
    }

    public String[] getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String[] intelligence) {
        this.intelligence = intelligence;
    }

    public String[] getEyesight() {
        return eyesight;
    }

    public void setEyesight(String[] eyesight) {
        this.eyesight = eyesight;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String[] getOrganIdArray() {
        return organIdArray;
    }

    public void setOrganIdArray(String[] organIdArray) {
        this.organIdArray = organIdArray;
    }

    public String[] getSecTypeArray() {
        return secTypeArray;
    }

    public void setSecTypeArray(String[] secTypeArray) {
        this.secTypeArray = secTypeArray;
    }

    public Integer getIsMb() {
        return isMb;
    }

    public void setIsMb(Integer isMb) {
        this.isMb = isMb;
    }

    public Integer getIsSn() {
        return isSn;
    }

    public void setIsSn(Integer isSn) {
        this.isSn = isSn;
    }

    public Integer getIsYwfy() {
        return isYwfy;
    }

    public void setIsYwfy(Integer isYwfy) {
        this.isYwfy = isYwfy;
    }

    public Integer getIsExzl() {
        return isExzl;
    }

    public void setIsExzl(Integer isExzl) {
        this.isExzl = isExzl;
    }

    public Integer getIsGz() {
        return isGz;
    }

    public void setIsGz(Integer isGz) {
        this.isGz = isGz;
    }

    public Integer getIsCj() {
        return isCj;
    }

    public void setIsCj(Integer isCj) {
        this.isCj = isCj;
    }

    public Integer getZhucan() {
        return zhucan;
    }

    public void setZhucan(Integer zhucan) {
        this.zhucan = zhucan;
    }

    public Integer getZhuji() {
        return zhuji;
    }

    public void setZhuji(Integer zhuji) {
        this.zhuji = zhuji;
    }

    public Integer getZhujie() {
        return zhujie;
    }

    public void setZhujie(Integer zhujie) {
        this.zhujie = zhujie;
    }

    public Integer getZhuyu() {
        return zhuyu;
    }

    public void setZhuyu(Integer zhuyu) {
        this.zhuyu = zhuyu;
    }

    public Integer getZhuxing() {
        return zhuxing;
    }

    public void setZhuxing(Integer zhuxing) {
        this.zhuxing = zhuxing;
    }

    public Integer getZhuyi() {
        return zhuyi;
    }

    public void setZhuyi(Integer zhuyi) {
        this.zhuyi = zhuyi;
    }

    public Integer getKangfu() {
        return kangfu;
    }

    public void setKangfu(Integer kangfu) {
        this.kangfu = kangfu;
    }

    public Integer getXiangtan() {
        return xiangtan;
    }

    public void setXiangtan(Integer xiangtan) {
        this.xiangtan = xiangtan;
    }

    public Integer getXidi() {
        return xidi;
    }

    public void setXidi(Integer xidi) {
        this.xidi = xidi;
    }

    public Integer getShenghuo() {
        return shenghuo;
    }

    public void setShenghuo(Integer shenghuo) {
        this.shenghuo = shenghuo;
    }

    public Integer getIsVolunteer() {
        return isVolunteer;
    }

    public void setIsVolunteer(Integer isVolunteer) {
        this.isVolunteer = isVolunteer;
    }

    public Integer getIsService() {
        return isService;
    }

    public void setIsService(Integer isService) {
        this.isService = isService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
