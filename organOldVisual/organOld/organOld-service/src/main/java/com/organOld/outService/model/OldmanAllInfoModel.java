package com.organOld.outService.model;

import java.util.List;

/**
 * 老人全部信息查看
 * Created by netlab606 on 2018/6/29.
 */
public class OldmanAllInfoModel {
    private OldmanModel oldman;
    private OldmanHealthModel health;
    private String family;
    private String economic;
    private LinkmanModel linkman;
    private OrganOldmanModel organ;//机构养老
    private List<OrganOldmanModel> community;//社区养老
    private List<HomeOldmanModel> home;//居家养老
    private OldmanKeyModel key;//重点老人参数

    public OldmanKeyModel getKey() {
        return key;
    }

    public void setKey(OldmanKeyModel key) {
        this.key = key;
    }

    public OldmanModel getOldman() {
        return oldman;
    }

    public void setOldman(OldmanModel oldman) {
        this.oldman = oldman;
    }

    public OldmanHealthModel getHealth() {
        return health;
    }

    public void setHealth(OldmanHealthModel health) {
        this.health = health;
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

    public LinkmanModel getLinkman() {
        return linkman;
    }

    public void setLinkman(LinkmanModel linkman) {
        this.linkman = linkman;
    }

    public OrganOldmanModel getOrgan() {
        return organ;
    }

    public void setOrgan(OrganOldmanModel organ) {
        this.organ = organ;
    }

    public List<OrganOldmanModel> getCommunity() {
        return community;
    }

    public void setCommunity(List<OrganOldmanModel> community) {
        this.community = community;
    }

    public List<HomeOldmanModel> getHome() {
        return home;
    }

    public void setHome(List<HomeOldmanModel> home) {
        this.home = home;
    }
}
