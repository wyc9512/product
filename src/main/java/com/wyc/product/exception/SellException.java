package com.wyc.product.exception;

import com.wyc.product.enums.ResultEnum;

/**
 * @author 文永川
 * @data 2018/10/12 17:38
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException( Integer code,String message) {
        super(message);
        this.code = code;
    }
}
