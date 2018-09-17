package com.simple.springbootbasic.basic.result;

import java.util.*;

/**
 * @Description 返回统一json格式工具类
 * @Author Simple
 * @Date 2018/9/17 17:24
 * @Version 1.0
 */
public class ResultJsonUtils<T> {
    public static ResultJsonData success(){
        return new ResultJsonData(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage());
    }
    public static ResultJsonData success(String message){
        return new ResultJsonData(ResponseCode.SUCCESS.getCode(),message);
    }
    public static ResultJsonData success(Integer code,String message){
        return new ResultJsonData(code,message);
    }

    public ResultJsonData<T> success(T object){
        return new ResultJsonData(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),object);
    }
    public ResultJsonData<T> success(List<T> list){
        return new ResultJsonData(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),list);
    }

    public static ResultJsonData error(Integer code,String message){
        return new ResultJsonData(code,message);
    }
}
