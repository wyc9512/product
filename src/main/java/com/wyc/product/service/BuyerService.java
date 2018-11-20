package com.wyc.product.service;

import com.wyc.product.dto.OrderDTO;

/**
 * @author 文永川
 * @data 2018/10/19 4:05
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderid);
    //取消订单
    OrderDTO cancelOrderOne(String openid,String orderid);
}
