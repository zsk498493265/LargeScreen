package com.organOld.outService.enumModel;

//导表失败的原因
public enum ImportFailEnum {
    REPEAT("重复添加"),
    PID("身份证号码错误"),
    NONE("未知原因"),
    AGE("年龄异常（可能小于60岁）"),
    XQ("小区异常"),
    ZNSB("智能设备不存在"),
    JTYS("家庭医生不存在"),
    JTBC("家庭病床的机构不存在"),
    JGNO("机构不存在");
    private String name ;

    ImportFailEnum(String name ){
        this.name = name ;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
