package com.simple.springbootbasic.utils;

import java.util.UUID;

/**
 * @Description 获取不同的随机数值
 * @Author Simple
 * @Date 2018/9/19 17:25
 * @Version 1.0
 */
public class RandomUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
