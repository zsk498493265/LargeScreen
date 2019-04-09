package com.organOld.dao.entity.visual;

import com.organOld.dao.entity.DBInterface;
import com.organOld.dao.entity.XqInterface;
import com.organOld.dao.entity.home.Home;
import com.organOld.dao.entity.label.LabelMan;
import com.organOld.dao.entity.oldman.Man;
import com.organOld.dao.entity.oldman.OldmanKeyHandle;
import com.organOld.dao.entity.oldman.Xq;
import com.organOld.dao.entity.organ.Organ;

import java.util.Date;
import java.util.List;

public class Visual extends Man implements DBInterface,XqInterface {
    private Integer sex;//1女 2男
    private Date birthday;//出生年月
    private String census;//户籍
    private String politicalStatus;//政治面貌
    private String family;
    private String economic;
    private Integer xqId;
    private Integer isVolunteer;
    private String familyType;
    private String pid;
    private Integer oldStatus;
    /**
     * 搜索对象
     */

    private List<Integer> xqIds;
    private Integer organId;//居委ID 或者片区ID
    private Date birthdayStart;//出生年月-起
    private Date birthdayEnd;//出生年月-止
    private String censusArray[];//户籍 1非 2户籍 3人户分离
    private String politicalStatusArray[];//政治面貌 1群众 2党员
    private String familyArray[];
    private String familyTypeArray[];
    private String economicArray[];
    private String intelligence[];
    private String eyesight[];
    private String[] organIdArray;
    private String[] secTypeArray;
    private String[] thirdTypeArray;
    private String[] forthTypeArray;
    private String[] fifthTypeArray;
    private String[] sixthTypeArray;
    private String[] isHealth;
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
    private Integer isService;

    private String oldStatusArray[];
    /**
     * 关联对象
     * @return
     */
    private Xq xq;//小区

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Integer oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String[] getIsHealth() {
        return isHealth;
    }

    public void setIsHealth(String[] isHealth) {
        this.isHealth = isHealth;
    }

    public String[] getOldStatusArray() {
        return oldStatusArray;
    }

    public void setOldStatusArray(String[] oldStatusArray) {
        this.oldStatusArray = oldStatusArray;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getEconomic() {
        return economic;
    }

    public void setEconomic(String economic) {
        this.economic = economic;
    }

    public Integer getXqId() {
        return xqId;
    }

    public void setXqId(Integer xqId) {
        this.xqId = xqId;
    }

    public Integer getIsVolunteer() {
        return isVolunteer;
    }

    public void setIsVolunteer(Integer isVolunteer) {
        this.isVolunteer = isVolunteer;
    }

    public String getFamilyType() {
        return familyType;
    }

    public void setFamilyType(String familyType) {
        this.familyType = familyType;
    }

    @Override
    public List<Integer> getXqIds() {
        return xqIds;
    }

    @Override
    public void setXqIds(List<Integer> xqIds) {
        this.xqIds = xqIds;
    }

    public Integer getOrganId() {
        return organId;
    }
    @Override
    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Date getBirthdayStart() {
        return birthdayStart;
    }

    public void setBirthdayStart(Date birthdayStart) {
        this.birthdayStart = birthdayStart;
    }

    public Date getBirthdayEnd() {
        return birthdayEnd;
    }

    public void setBirthdayEnd(Date birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }

    public String[] getCensusArray() {
        return censusArray;
    }

    public void setCensusArray(String[] censusArray) {
        this.censusArray = censusArray;
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

    public String[] getOrganIdArray() {
        return organIdArray;
    }

    public void setOrganIdArray(String[] organIdArray) {
        this.organIdArray = organIdArray;
    }

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

    public void setSixthTypeArray(String[] sixthTypeArray) {
        this.sixthTypeArray = sixthTypeArray;
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

    public Xq getXq() {
        return xq;
    }

    public void setXq(Xq xq) {
        this.xq = xq;
    }

    public String[] getSecTypeArray() {
        return secTypeArray;
    }

    public void setSecTypeArray(String[] secTypeArray) {
        this.secTypeArray = secTypeArray;
    }

    public Integer getIsService() {
        return isService;
    }

    public void setIsService(Integer isService) {
        this.isService = isService;
    }
}
