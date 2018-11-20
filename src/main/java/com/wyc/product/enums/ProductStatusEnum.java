package com.wyc.product.enums;

import lombok.Getter;

/**
 * 商品状态
 * @author 文永川
 * @data 2018/10/11 23:33
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),DOWN(1,"下架")
    ;
    private  Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message=message;
    }
}
