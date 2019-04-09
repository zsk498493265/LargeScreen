package com.organOld.outService.wrapper;

import com.organOld.dao.entity.product.ProductBook;
import com.organOld.outService.constant.TimeConstant;
import com.organOld.outService.contract.ProductBookRequest;
import com.organOld.outService.model.ProductBookModel;
import com.organOld.outService.tool.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductBookWrapper implements Wrapper<ProductBook,ProductBookModel,ProductBookRequest> {


    @Override
    public ProductBookModel wrap(ProductBook productBook) {
        ProductBookModel productBookModel=new ProductBookModel();
        productBookModel.setId(productBook.getId());
        productBookModel.setTime(Tool.dateToString(productBook.getTime(),TimeConstant.DATA_FORMAT_YMD));
        productBookModel.setIds(productBook.getProductId());
        productBookModel.setOldman(productBook.getOldman());
        productBookModel.setStatus(productBook.getStatus());
        productBookModel.setProduct(productBook.getProduct());
        return productBookModel;
    }

    @Override
    public ProductBook unwrap(ProductBookRequest productBookRequest) {
        ProductBook productBook=new ProductBook();
        BeanUtils.copyProperties(productBookRequest,productBook);
        return productBook;
    }
}
