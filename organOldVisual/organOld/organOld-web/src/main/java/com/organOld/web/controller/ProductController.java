package com.organOld.web.controller;

import com.organOld.dao.entity.product.ProductType;
import com.organOld.outService.contract.*;
import com.organOld.outService.service.OrganService;
import com.organOld.outService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    OrganService organService;

    /**
     * 商品管理
     * organId 有值 表示从管理页面过来
     * @return
     */

    @RequestMapping("")
    public ModelAndView index(@RequestParam(required = false) Integer organId){
        ModelAndView mv=null;
        Boolean result=organService.checkHaveAuthByAuthType(5,organId);//有没有商品权限
        if(result) {
            mv = new ModelAndView("product/product");
            mv.addObject("organId", organId);
            mv.addObject("fir", productService.getTypeByParent(0));
        }else{
            //没有权限
            mv = new ModelAndView("error/message");
            mv.addObject("message","抱歉！您没有权限");
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/data",method = RequestMethod.POST)
    public String data(ProductRequest productRequest, BTableRequest bTableRequest){
        return productService.getByPage(productRequest,bTableRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/getById",method = RequestMethod.GET)
    public Result getById(@PathVariable Integer id){
        return productService.getById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/type/{id}/getById",method = RequestMethod.GET)
    public Result type_getById(@PathVariable Integer id){
        return productService.getTypeById(id);
    }

    @RequestMapping(value = "/{type}",method = RequestMethod.POST)
    public ModelAndView addOrupdate(@PathVariable String type, ProductRequest productRequest, HttpServletRequest request){
        ModelAndView mv=new ModelAndView("redirect:/product");
        productService.addOrUpdate(productRequest,type,request);
        return mv;
    }


    @RequestMapping("/type")
    public ModelAndView type(){
        ModelAndView mv=new ModelAndView("product/product_type");
        mv.addObject("type","1");
        mv.addObject("grand",productService.getTypeByType(3));
        mv.addObject("parent",productService.getTypeByType(2));
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/type/data",method = RequestMethod.POST)
    public String type_data(ProductTypeRequest productTypeRequest, BTableRequest bTableRequest){
        return productService.getTypeByPage(productTypeRequest,bTableRequest);
    }

    @RequestMapping(value = "/type/{type}",method = RequestMethod.POST)
    public ModelAndView type_addOrupdate(@PathVariable String type, ProductTypeRequest productTypeRequest){
        ModelAndView mv=new ModelAndView("product/product_type");
        productService.addOrUpdateType(productTypeRequest,type);
        mv.addObject("type",productTypeRequest.getType()+"");
        mv.addObject("grand",productService.getTypeByType(3));
        mv.addObject("parent",productService.getTypeByType(2));
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/type/del",method = RequestMethod.POST)
    public Result type_del(@RequestParam("ids[]") String ids[]){
        productService.delTypeByIds(ids);
        return new Result(true);
    }

    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public Result del(@RequestParam("ids[]") String ids[]){
        productService.delByIds(ids);
        return new Result(true);
    }

    /**
     * 商品预订
     */

    @RequestMapping("/book")
    public ModelAndView book(@RequestParam(required = false) Integer organId){
        ModelAndView mv=null;
        Boolean result=organService.checkHaveAuthByAuthType(5,organId);//有没有商品权限
        if(result) {
            mv=new ModelAndView("product/product_book");
            mv.addObject("organId",organId);
        }else{
            //没有权限
            mv = new ModelAndView("error/message");
            mv.addObject("message","抱歉！您没有权限");
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/book/data",method = RequestMethod.POST)
    public String data(ProductBookRequest productBookRequest, BTableRequest bTableRequest){
        return productService.getBookByPage(productBookRequest,bTableRequest);
    }

    @ResponseBody
    @RequestMapping("/book/handle")
    public Result bookHandle(@RequestParam Integer id){
        Result result=productService.bookHandle(id);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/type/{parent}/getByParent",method = RequestMethod.GET)
    public Result getByParent(@PathVariable Integer parent){
        return new Result(true,productService.getTypeByParent(parent));
    }
}
