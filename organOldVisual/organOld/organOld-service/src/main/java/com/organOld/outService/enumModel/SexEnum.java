package com.organOld.outService.enumModel;

//性别
public enum SexEnum {
    WOMAN("女",1),MAN("男",2);

    private String name ;
    private int index ;

    SexEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public static String getValue(Integer index) {
        if (index==null || index==0)
            return "";
        for (SexEnum d : SexEnum.values()) {
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
