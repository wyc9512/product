package com.wyc.product.service.impl;

import com.wyc.product.bean.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 文永川
 * @data 2018/10/11 19:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private  CategoryServiceImpl categoryService;

    @Test
    public void findById() {
       ProductCategory productCategory= categoryService.findById(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }
}