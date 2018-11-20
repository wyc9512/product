package com.wyc.product.controller;

import com.wyc.product.ObjectView.ProductInfoVO;
import com.wyc.product.ObjectView.ProductVO;
import com.wyc.product.ObjectView.ResultVO;
import com.wyc.product.bean.ProductCategory;
import com.wyc.product.bean.ProductInfo;
import com.wyc.product.service.CategoryService;
import com.wyc.product.service.ProductService;
import com.wyc.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 文永川
 * @data 2018/10/11 23:58
 */
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){
        //1.先查询所有的商家商品
       List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目（一次性查询）
           //精简方法（java8的特性，lambda）
        List<Integer>  categoryTypeList = productInfoList.stream()
                .map(e ->e.getCategoryType()).collect(Collectors.toList());
       List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据的拼装
        List<ProductVO> productVOList  = new ArrayList<>();

        for(ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //spring提供的方法把一个对象的值copy到另外一个对象
                    BeanUtils.copyProperties(productInfo, productInfoVO);

                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
