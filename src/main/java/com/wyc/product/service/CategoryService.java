package com.wyc.product.service;

import com.wyc.product.bean.ProductCategory;

import java.util.List;

/**
 * @author 文永川
 * @data 2018/10/11 16:56
 */
public interface CategoryService {
    ProductCategory findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
