package com.organOld.outService.contract;

public class OldmanhKeyHandleRequest {
    private Integer id;
    private int oldmanId;
    private int type;
    private String[] organIds;
    private String[] homeFirTypes;
    private String handle;//增加还是修改 还是删除

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }


    public int getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(int oldmanId) {
        this.oldmanId = oldmanId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String[] getOrganIds() {
        return organIds;
    }

    public void setOrganIds(String[] organIds) {
        this.organIds = organIds;
    }

    public String[] getHomeFirTypes() {
        return homeFirTypes;
    }

    public void setHomeFirTypes(String[] homeFirTypes) {
        this.homeFirTypes = homeFirTypes;
    }
}
