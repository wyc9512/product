package com.wyc.product.dao;

import com.wyc.product.bean.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 文永川
 * @data 2018/10/11 2:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private  ProductCategoryRepository repository;

    @Test
    public  void  findOneTest(){

        System.out.println(repository.findById(1).toString());
    }
    @Test
    public  void  updateTest(){
        ProductCategory list= repository.findById(1).get();
        list.setCategoryType(2);
        repository.save(list);
    }
    @Test
    public  void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result =repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}