package com.wyc.product.converter;

import com.wyc.product.bean.OrderMaster;
import com.wyc.product.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 文永川
 * @data 2018/10/13 3:27
 */
public class OrderMasterOrderDTOConverter {
    public  static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public  static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return  orderMasterList.stream().map(e ->convert(e)).collect(Collectors.toList());
    }
}
