package com.wyc.product.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wyc.product.bean.OrderDetail;
import com.wyc.product.dto.OrderDTO;
import com.wyc.product.enums.ResultEnum;
import com.wyc.product.exception.SellException;
import com.wyc.product.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 文永川
 * @data 2018/10/17 18:39
 */
@Slf4j
public class OrderFormOrderDTOconverter {
    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
             orderDetailList = JSON.parseArray(orderForm.getItems(),OrderDetail.class);
        }catch (Exception e){
            log.error("【对象转换】错误，string = {}" ,orderForm.getItems());
            throw  new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList( orderDetailList);
        return  orderDTO;
    }
}
