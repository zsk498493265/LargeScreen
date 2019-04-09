package com.organOld.outService.wrapper;

import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.product.ProductType;
import com.organOld.outService.constant.TimeConstant;
import com.organOld.outService.contract.ProductRequest;
import com.organOld.outService.contract.ProductTypeRequest;
import com.organOld.outService.model.ProductModel;
import com.organOld.outService.model.ProductTypeModel;
import com.organOld.outService.tool.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductWrapper implements Wrapper<Product,ProductModel,ProductRequest> {

    @Override
    public ProductModel wrap(Product product) {
        ProductModel productModel=new ProductModel();
        productModel.setName(product.getProductType().getName());
        productModel.setSecType(product.getProductType().getProductType().getName());
        productModel.setFirType(product.getProductType().getProductType().getProductType().getName());
        BeanUtils.copyProperties(product,productModel);
        productModel.setTime(Tool.dateToString(product.getTime(), TimeConstant.DATA_FORMAT_YMD));
        return productModel;
    }

    @Override
    public Product unwrap(ProductRequest productRequest) {
        Product product=new Product();
        if(productRequest.getPrice()!=null && !productRequest.getPrice().equals(""))
            product.setPrice(Double.parseDouble(productRequest.getPrice()));
        product.setIntro(productRequest.getIntro());
        if(productRequest.getId()!=null)
        product.setId(productRequest.getId());
//        product.setName(productRequest.getName());
        product.setOrganId(productRequest.getOrganId());
        product.setType(productRequest.getType());
        return product;
    }

    public ProductType unwrapType(ProductTypeRequest productTypeRequest) {
        ProductType productType=new ProductType();
        BeanUtils.copyProperties(productTypeRequest,productType);
        if(productTypeRequest.getType()!=null && productTypeRequest.getType()==2){
            productType.setParent(productTypeRequest.getGrand());
        }
        if(productTypeRequest.getType()!=null && productTypeRequest.getType()==3){
            productType.setParent("0");
        }
        return productType;
    }

    public ProductTypeModel wrapType(ProductType productType) {
        ProductTypeModel productTypeModel=new ProductTypeModel();
        productTypeModel.setName(productType.getName());
        productTypeModel.setId(productType.getId());
        if(productType.getProductType()!=null){
            productTypeModel.setParentName(productType.getProductType().getName());
            if(productType.getProductType().getProductType()!=null){
                productTypeModel.setGrandName(productType.getProductType().getProductType().getName());
            }
        }
        return productTypeModel;
    }
}
