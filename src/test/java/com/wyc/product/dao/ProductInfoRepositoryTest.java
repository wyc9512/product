package com.wyc.product.dao;

import com.wyc.product.bean.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author 文永川
 * @data 2018/10/11 22:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private  ProductInfoRepository repository;
    @Test
    public  void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("巨无霸");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("超级巨大");
        productInfo.setProductIcon("HTTP//116");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result=repository.save(productInfo);
        Assert.assertNotNull(result);

    }

}