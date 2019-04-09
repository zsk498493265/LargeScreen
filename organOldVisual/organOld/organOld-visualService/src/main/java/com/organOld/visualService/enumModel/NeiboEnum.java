package com.organOld.visualService.enumModel;

public enum NeiboEnum {
    X1("DLyij",1),
    X2("GLyij",2),
    X3("GMyic",3),
    X4("GLerc",13),
    X5("GLsanc",45),
    X6("GLerj",58),
    X7("DLsanj",59),
    X8("DLsij",60),
    X9("GLliuc",63),
    X10("GMjiuc",66),
    X11("GMqic",67),
    X12("HM",84),
    X13("ML",85),
    X14("PYerc",87),
    X15("PYsanc",88),
    X16("WYsij",89),
    X17("WYyij",90),
    X18("DLerj",93),
    X19("PJsic",97),
    X20("GLsij",98),
    X21("GMbac",99),
    X22("GMsic",100),
    X23("PNsanj",101),
    X24("PNyij",102),
    X25("PYliuc",103),
    X26("PYsic",104),
    X27("PYyic",105),
    X28("WYsanj",106),
    X29("GLwuc",107),
    X30("PJliuc",108),
    X31("HYxin",119),
    X32("PJerc",120),
    X33("PJwuc",121),
    X34("GMsanc",122),
    X35("GMshij",123),
    X36("PNerj",124),
    X37("PYwuc",125),
    X38("PJyic",126),
    X39("WYerj",134),
    X40("DLerj",135);

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

    private String name;
    private int index;

    NeiboEnum(String name,int index){
        this.name = name;
        this.index = index;
    }

    public static String getValue(int index){
        for(NeiboEnum d:NeiboEnum.values()){
            if(d.getIndex() == index){
                return d.name;
            }
        }
        return null;
    }


}
