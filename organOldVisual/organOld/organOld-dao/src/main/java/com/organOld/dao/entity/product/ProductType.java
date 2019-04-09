package com.organOld.dao.entity.product;

import com.organOld.dao.entity.DBEntity;

public class ProductType extends DBEntity{
    private String name;
    private String parent;
    private Integer type;
    private ProductType productType;
    private String grand;

    private String search;
    private Integer firId;
    private Integer secId;


    public String getGrand() {
        return grand;
    }

    public void setGrand(String grand) {
        this.grand = grand;
    }

    public Integer getFirId() {
        return firId;
    }

    public void setFirId(Integer firId) {
        this.firId = firId;
    }

    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
