package com.organOld.outService.service;

import com.organOld.dao.entity.product.ProductType;
import com.organOld.outService.contract.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductService {
    String getByPage(ProductRequest productRequest, BTableRequest bTableRequest);

    String getBookByPage(ProductBookRequest productBookRequest, BTableRequest bTableRequest);

    void addOrUpdate(ProductRequest product, String type, HttpServletRequest request);

    Result bookHandle(Integer id);


    List<ProductType> getTypeByParent(int parent);

    String getTypeByPage(ProductTypeRequest productTypeRequest, BTableRequest bTableRequest);

    void addOrUpdateType(ProductTypeRequest productTypeRequest, String type);

    void delByIds(String[] ids);

    void delTypeByIds(String[] ids);

    Result getById(Integer id);

    Result getTypeById(Integer id);

    Object getTypeByType(int i);
}
