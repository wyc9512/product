package com.wyc.product.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wyc.product.bean.OrderDetail;
import com.wyc.product.enums.OrderStatusEnum;
import com.wyc.product.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 文永川
 * @data 2018/10/12 17:05
 */
@Data
/*为空的字段返回json类型时不返回*/
//@JsonInclude(JsonInclude.Include.NON_NULL)
/*每个都想如此就需要在配置文件里配置了*/
public class OrderDTO {
    private String orderId;
    private  String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    /*订单金额*/
    private BigDecimal orderAmount;
    /* 订单状态，默认为新下单*/
    private Integer orderStatus;
    /*  支付状态，默认为0未支付*/
    private  Integer payStatus;

    private Date createTime;

    private  Date updateTime;

    List<OrderDetail> orderDetailList;
}
