package com.organOld.outService.contract;

/**
 * Created by netlab606 on 2018/7/8.
 */
public class LabelManRequest implements XqRequest{
    private int labelId;
    private int id;//老人的id
    private String[] censusArray;//户籍
    private String[] district;//片区索引
    private String ageStart;//年龄段-起
    private String ageEnd;//年龄段-止
    private String louNumStart;//楼号-起
    private String louNumEnd;//楼号-止
    private String search;//模糊全文 匹配搜索  姓名、身份证、地址、电话
    private String[] jw;//居委索引
    private Integer sex;//1女 2男
    private String[] politicalStatusArray;//政治面貌
    private String[] family;
    private String[] economic;
    private String[] isHealth;
    private String[] intelligence;
    private String[] eyesight;
    private String isImplement;
    private Integer[] xq;


    public String getLouNumStart() {
        return louNumStart;
    }

    public void setLouNumStart(String louNumStart) {
        this.louNumStart = louNumStart;
    }

    public String getLouNumEnd() {
        return louNumEnd;
    }

    public void setLouNumEnd(String louNumEnd) {
        this.louNumEnd = louNumEnd;
    }

    @Override
    public Integer[] getXq() {
        return xq;
    }

    public void setXq(Integer[] xq) {
        this.xq = xq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public String[] getCensusArray() {
        return censusArray;
    }

    public void setCensusArray(String[] censusArray) {
        this.censusArray = censusArray;
    }

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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

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

    public String[] getFamily() {
        return family;
    }

    public void setFamily(String[] family) {
        this.family = family;
    }

    public String[] getEconomic() {
        return economic;
    }

    public void setEconomic(String[] economic) {
        this.economic = economic;
    }

    public String[] getIsHealth() {
        return isHealth;
    }

    public void setIsHealth(String[] isHealth) {
        this.isHealth = isHealth;
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

    public String getIsImplement() {
        return isImplement;
    }

    public void setIsImplement(String isImplement) {
        this.isImplement = isImplement;
    }
}
