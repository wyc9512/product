package com.wyc.product.dao;

import com.wyc.product.bean.OrderDetail;
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
 * @data 2018/10/12 16:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private  OrderDetailRepository orderDetailRepository;
    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("00117");
        orderDetail.setOrderId("1112");
        orderDetail.setProductIcon("pic");
        orderDetail.setProductId("11144");
        orderDetail.setProductName("死");
        orderDetail.setProductPrice( new BigDecimal(98));
        orderDetail.setProductQuantity(100);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        Assert.assertNotEquals(0,orderDetailRepository.findByOrderId("1112").size());
    }
}