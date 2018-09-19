package com.simple.springbootbasic.basic.configuration;

import com.simple.springbootbasic.basic.properties.SimpleProperies;
import com.simple.springbootbasic.basic.result.ResponseCode;
import com.simple.springbootbasic.basic.result.ResultJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 全局异常处理 兼容web ajax两种形式
 * @Author Simple
 * @Date 2018/9/17 17:08
 * @Version 1.0
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @Autowired
    private SimpleProperies simpleProperies;

    /**
     * 发生运行时错误时
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object runtimeExceptionHander(HttpServletRequest request, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        String message = "";
        Integer code = ResponseCode.SERVERERROR.getCode();
        //权限不足 403
        if (e instanceof UnauthorizedException) {
            //未授权
            code = ResponseCode.FORBIDDEN.getCode();
            message = "权限不足";
            if (isAjax(request)) {
                //ajax请求
                return ResultJsonUtils.error(code, message);
            } else {
                modelAndView.setViewName(simpleProperies.getUnauthorizedPage());
                return modelAndView;
            }
        }
        //认证失败 401
        else if(e instanceof AuthenticationException){
            code = ResponseCode.UNAUTHORIZED.getCode();
            message = e.getMessage();
            if (isAjax(request)) {
                //ajax请求
                return ResultJsonUtils.error(code, message);
            } else {
                modelAndView.setViewName(simpleProperies.getShiro().getLoginUrl());
                return modelAndView;
            }
        }
        //其他错误 500
        else{
            log.error(e.getMessage());
            if (isAjax(request)) {
                //ajax请求
                return ResultJsonUtils.error(code, "系统错误");
            }

            modelAndView.addObject("message", "系统错误");
            modelAndView.addObject("code", ResponseCode.SERVERERROR.getCode());
            modelAndView.setViewName(simpleProperies.getErrorPage());
            return modelAndView;
        }
    }


    /**
     * 判断是否是ajax请求
     * <p>Title: isAjax</p>
     * <p>Description: </p>
     *
     * @param httpRequest
     * @return
     */
    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals(httpRequest.getHeader("X-Requested-With")));
    }


}
