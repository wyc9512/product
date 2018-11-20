package com.wyc.product.service.impl;

import com.wyc.product.bean.ProductCategory;
import com.wyc.product.dao.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wyc.product.service.CategoryService;

import java.util.List;

/**
 * 类目
 * @author 文永川
 * @data 2018/10/11 18:30
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Override
    public ProductCategory findById(Integer categoryId) {
        return  productCategoryRepository.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
