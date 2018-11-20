package com.wyc.product.service.impl;

import com.wyc.product.dto.OrderDTO;
import com.wyc.product.enums.ResultEnum;
import com.wyc.product.exception.SellException;
import com.wyc.product.service.BuyerService;
import com.wyc.product.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 文永川
 * @data 2018/10/19 4:08
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid, String orderid) {
        return checkOrderOwner(openid,orderid);
    }

    @Override
    public OrderDTO cancelOrderOne(String openid, String orderid) {
        OrderDTO orderDTO = checkOrderOwner(openid,orderid);
        if (orderDTO == null){
            log.error("【取消订单】查不到该订单，orderId={}",orderid);
            throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderDTO);
    }
    private OrderDTO checkOrderOwner(String openid, String orderid){
        OrderDTO orderDTO = orderService.findOne(orderid);
        if(orderDTO == null){
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单的openid不一致，openid={},orderDTO={}",openid,orderDTO);
            throw  new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
