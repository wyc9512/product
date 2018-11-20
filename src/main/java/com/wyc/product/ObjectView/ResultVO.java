package com.wyc.product.ObjectView;

import lombok.Data;

/**
 * HTTP请求返回的最外层对象
 * @author 文永川
 * @data 2018/10/12 0:14
 */
@Data
public class ResultVO<T> {
    /*错误码，0成功*/
    private  Integer code;
    /*提示信息*/
    private String msg;
    /*返回的具体内容*/
    private  T data;

}
