package com.organOld.dao.repository;

import com.organOld.dao.entity.product.ProductType;

import java.util.List;

public interface ProductTypeDao extends BaseDao<ProductType,Number> {
    List<ProductType> getByParent(int parent);

    List<ProductType> getByType(int type);
}
