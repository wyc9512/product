package com.wyc.product.enums;

import lombok.Getter;

/**
 * @author 文永川
 * @data 2018/10/12 15:46
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;
    private  Integer code;
    private  String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
