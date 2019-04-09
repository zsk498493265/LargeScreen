package com.organOld.outService.service.impl;

import com.organOld.dao.entity.MessageCard;
import com.organOld.dao.entity.product.Product;
import com.organOld.dao.entity.product.ProductBook;
import com.organOld.dao.entity.product.ProductType;
import com.organOld.dao.repository.MessageCardDao;
import com.organOld.dao.repository.ProductBookDao;
import com.organOld.dao.repository.ProductDao;
import com.organOld.dao.repository.ProductTypeDao;
import com.organOld.dao.util.Page;
import com.organOld.outService.contract.*;
import com.organOld.outService.model.ProductBookModel;
import com.organOld.outService.model.ProductModel;
import com.organOld.outService.model.ProductTypeModel;
import com.organOld.outService.service.CommonService;
import com.organOld.outService.service.ProductService;
import com.organOld.outService.tool.ImgUpload;
import com.organOld.outService.wrapper.ProductBookWrapper;
import com.organOld.outService.wrapper.ProductWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    CommonService commonService;
    @Autowired
    ProductDao productDao;
    @Autowired
    ProductBookDao productBookDao;
    @Autowired
    ProductBookWrapper productBookWrapper;
    @Autowired
    ProductWrapper productWrapper;
    @Autowired
    ProductTypeDao productTypeDao;
    @Autowired
    MessageCardDao messageCardDao;

    @Override
    public String getByPage(ProductRequest productRequest, BTableRequest bTableRequest) {
        Page<Product> page=commonService.getPage(bTableRequest,"product");
        Product product=  productWrapper.unwrap(productRequest);
        if(product.getOrganId()==null || product.getOrganId()==0){
            //机构账号页面
            commonService.checkIsOrgan(product);
        }
        page.setEntity(product);
        List<ProductModel> productModelList=productDao.getByPage(page).stream().map( productWrapper::wrap).collect(Collectors.toList());
        Long size=productDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,productModelList);
    }

    @Override
    public String getBookByPage(ProductBookRequest productBookRequest, BTableRequest bTableRequest) {
        Page<ProductBook> page=commonService.getPage(bTableRequest,"product_book");
        ProductBook productBook=  productBookWrapper.unwrap(productBookRequest);
        if(productBook.getOrganId()==null || productBook.getOrganId()==0){
            //机构账号页面
            commonService.checkIsOrgan(productBook);
        }
        commonService.checkIsOrgan(productBook);
        page.setEntity(productBook);
        List<ProductBookModel> productBookModelList=productBookDao.getByPage(page).stream().map( productBookWrapper::wrap).collect(Collectors.toList());
        Long size=productBookDao.getSizeByPage(page);


        //TODO  先获得 该机构所有的 商品 做缓存  减少查询次数
//        for(ProductBookModel book:productBookModelList){
//            String[] ids=book.getIds().split("#");
//            List<Product> productList=new ArrayList<>();
//            for(int i=0;i<ids.length;i++){
//                Product product=productDao.getById(ids[i]);
//                productList.add(product);
//            }
//            book.setProductList(productList);
//        }

        return commonService.tableReturn(bTableRequest.getsEcho(),size,productBookModelList);
    }


    @Override
    public void addOrUpdate(ProductRequest productRequest, String type, HttpServletRequest request) {
        Product product= productWrapper.unwrap(productRequest);
        if(!productRequest.getPic().isEmpty()){
            try {
                String path= ImgUpload.uploadFile(productRequest.getPic(), request,"product");
           //     int index = path.indexOf("img");
                String picUrl= path;
                product.setImgUrl(picUrl);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        Integer organId=commonService.getIdBySession();
        product.setOrganId(organId);
        if(type.equals("add"))
            productDao.save(product);
        else
            productDao.updateById(product);
    }

    @Override
    @Transactional
    public Result bookHandle(Integer id) {
        productBookDao.updateProp("status","1",id);
        Integer cardId=productBookDao.getCardById(id);
        MessageCard messageCard=new MessageCard();
        messageCard.setCardId(cardId);
        messageCard.setContent("您的订单已被处理，请等待机构回电，单号："+id);
        messageCardDao.save(messageCard);
        return new Result(true);
    }

    @Override
    public String getTypeByPage(ProductTypeRequest productTypeRequest, BTableRequest bTableRequest) {
        Page<ProductType> page=commonService.getPage(bTableRequest,"product");
        ProductType productType=  productWrapper.unwrapType(productTypeRequest);
        page.setEntity(productType);
        List<ProductTypeModel> productModelList=productTypeDao.getByPage(page).stream().map( productWrapper::wrapType).collect(Collectors.toList());
        Long size=productTypeDao.getSizeByPage(page);
        return commonService.tableReturn(bTableRequest.getsEcho(),size,productModelList);
    }

    @Override
    public void addOrUpdateType(ProductTypeRequest productTypeRequest, String type) {
        ProductType productType= productWrapper.unwrapType(productTypeRequest);
        if(type.equals("add"))
            productTypeDao.save(productType);
        else
            productTypeDao.updateById(productType);
    }

    @Override
    public void delByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        productDao.delByIds(id);
    }

    @Override
    public void delTypeByIds(String[] ids) {
        Integer[] id=new Integer[ids.length];
        for(int i=0;i<ids.length;i++){
            id[i]=Integer.parseInt(ids[i]);
        }
        productTypeDao.delByIds(id);
    }

    @Override
    public List<ProductType> getTypeByParent(int parent) {
        return productTypeDao.getByParent(parent);
    }


    @Override
    public Result getById(Integer id) {
        return new Result(true,productDao.getById(id));
    }

    @Override
    public Result getTypeById(Integer id) {
        ProductType productType=productTypeDao.getById(id);
        if(productType.getType()==2){
            productType.setGrand(productType.getParent());
        }
        return new Result(true,productType);
    }

    @Override
    public List<ProductType> getTypeByType(int i) {
        return productTypeDao.getByType(i);
    }
}
