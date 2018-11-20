package com.wyc.product.utils;

import java.util.Random;

/**
 * 生成的唯一主键
 * 格式：时间+随机数
 * @author 文永川
 * @data 2018/10/12 19:39
 */
public class KeyUtil {
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
