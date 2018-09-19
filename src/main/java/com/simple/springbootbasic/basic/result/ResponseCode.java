package com.simple.springbootbasic.basic.result;

import lombok.Getter;

/**
 * @Description 响应状态码
 * @Author Simple
 * @Date 2018/9/17 17:17
 * @Version 1.0
 */
@Getter
public enum ResponseCode {
    SUCCESS(200,"ok"),
    NOT_FOUND(404,"Not Found"),
    UNAUTHORIZED(401,"Unauthorized"),
    FORBIDDEN(403,"Forbidden"),
    SERVERERROR(500,"Server Error"),
    MISSINGPARAMETERS(-1,"Missing Parameters"),
    LOINGERROR(-2,"Login Error"),
    UNAUTHENTICATION(-3,"Unauthentication")
    ;
    private Integer code;
    private String message;
    private ResponseCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }


}
