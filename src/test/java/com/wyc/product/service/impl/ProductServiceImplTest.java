package com.wyc.product.service.impl;

import com.wyc.product.bean.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author 文永川
 * @data 2018/10/11 23:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private  ProductServiceImpl productService;
    @Test
    public void findOne() {
       ProductInfo productInfo= productService.findOne("123");
        Assert.assertEquals("123",productInfo.getProductId());
    }
}