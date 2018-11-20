package com.wyc.product.dto;

import lombok.Data;

/**
 * 购物车
 * @author 文永川
 * @data 2018/10/12 21:59
 */
@Data
public class CartDTO {
    /*商品id*/
    private  String poductId;
    /*商品数量*/
    private  Integer productQuantity;

    public CartDTO(String poductId, Integer productQuantity) {
        this.poductId = poductId;
        this.productQuantity = productQuantity;
    }
}
