package com.organOld.outService.model;

import java.util.List;

public class KeyRulelModel {
    private int baseGoal;
    private List<KeyRuleTypeModel> keyRuleTypeList;

    public int getBaseGoal() {
        return baseGoal;
    }

    public void setBaseGoal(int baseGoal) {
        this.baseGoal = baseGoal;
    }

    public List<KeyRuleTypeModel> getKeyRuleTypeList() {
        return keyRuleTypeList;
    }

    public void setKeyRuleTypeList(List<KeyRuleTypeModel> keyRuleTypeList) {
        this.keyRuleTypeList = keyRuleTypeList;
    }
}
