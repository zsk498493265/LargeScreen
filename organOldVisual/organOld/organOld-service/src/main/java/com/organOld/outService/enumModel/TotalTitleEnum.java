package com.organOld.outService.enumModel;


public enum TotalTitleEnum {
    T1("老人信息",1),//片区
    T2("健康信息",2),//小区
    T3("重点老人",3),//政治面貌
    T4("机构养老",4),//户籍
    T5("社区养老",5),//家庭结构
    T6("居家养老",6),//经济条件
    T7("政府机构",7),//失智
    T8("人员",8),//
    T10("社会涉老机构",10);
    private String name ;
    private int index ;

    TotalTitleEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(int index) {
        for (TotalTitleEnum d : TotalTitleEnum.values()) {
            if (d.getIndex() == index) {
                return d.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
