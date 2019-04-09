package com.organOld.dao.entity;

public class CardSum {
    private Integer id;
    private String name;
    private Long create;
    private Long noCreate;
    private Long jh;
    private Long wjh;
    private Long bky;
    private Long gs;
    private Long sum;

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreate() {
        return create;
    }

    public void setCreate(Long create) {
        this.create = create;
    }

    public Long getNoCreate() {
        return noCreate;
    }

    public void setNoCreate(Long noCreate) {
        this.noCreate = noCreate;
    }

    public Long getJh() {
        return jh;
    }

    public void setJh(Long jh) {
        this.jh = jh;
    }

    public Long getWjh() {
        return wjh;
    }

    public void setWjh(Long wjh) {
        this.wjh = wjh;
    }

    public Long getBky() {
        return bky;
    }

    public void setBky(Long bky) {
        this.bky = bky;
    }

    public Long getGs() {
        return gs;
    }

    public void setGs(Long gs) {
        this.gs = gs;
    }
}
