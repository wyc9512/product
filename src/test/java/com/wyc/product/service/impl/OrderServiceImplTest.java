package com.wyc.product.service.impl;

import com.wyc.product.bean.OrderDetail;
import com.wyc.product.dto.OrderDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 文永川
 * @data 2018/10/12 23:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private  OrderServiceImpl orderService;
    private  final  String BUYER_OPENID="112312";
    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("wyc");
        orderDTO.setBuyerAddress("成都");
        orderDTO.setBuyerPhone("10086");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o= new OrderDetail();
        o.setProductQuantity(998);
        o.setProductId("02");
        orderDetailList.add(o);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result =  orderService.create(orderDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne("1539368303953199954");
        Assert.assertNotNull(orderDTO);
    }

    @Test
    public void findList() {
        PageRequest request =PageRequest.of(0 , 2);
        Page<OrderDTO> orderDTOPage = orderService.findList("112312",request);
        Assert.assertNotNull(orderDTOPage);
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne("1539368303953199954");
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne("1539368303953199954");
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1539368303953199954");
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertNotNull(result);
    }

}