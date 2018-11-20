package com.wyc.product.bean;

import com.wyc.product.enums.OrderStatusEnum;
import com.wyc.product.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 文永川
 * @data 2018/10/11 16:59
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private String orderId;
    private  String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    /*订单金额*/
    private BigDecimal orderAmount;
   /* 订单状态，默认为新下单*/
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();
  /*  支付状态，默认为0未支付*/
    private  Integer payStatus= PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private  Date updateTime;

}
