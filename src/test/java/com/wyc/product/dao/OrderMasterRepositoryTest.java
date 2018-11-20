package com.wyc.product.dao;

import com.wyc.product.bean.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author 文永川
 * @data 2018/10/12 16:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private  OrderMasterRepository orderMasterRepository;

    private final String OPENID="1111";

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("3210");
        orderMaster.setBuyerName("文永川");
        orderMaster.setBuyerPhone("123212314561");
        orderMaster.setBuyerAddress("慕课");
        orderMaster.setBuyerOpenid("1111");
        orderMaster.setOrderAmount(new BigDecimal(2.9));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0,3);
       Page<OrderMaster> result= orderMasterRepository.findByBuyerOpenid(OPENID,request);
        System.out.println(request.getPageSize());
    }
}