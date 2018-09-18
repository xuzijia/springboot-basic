package com.simple.springbootbasic.basic.configuration;

import com.simple.springbootbasic.basic.result.ResponseCode;
import com.simple.springbootbasic.basic.result.ResultJsonData;
import com.simple.springbootbasic.basic.result.ResultJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 全局异常处理 兼容web ajax两种形式
 * @Author Simple
 * @Date 2018/9/17 17:08
 * @Version 1.0
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @Autowired
    private SimpleProperies simpleProperies;

    /**
     * 发生运行时错误时
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public Object runtimeExceptionHander(HttpServletRequest request, Exception e){
        e.printStackTrace();
        if (isAjax(request)){
            //ajax请求
            return ResultJsonUtils.error(ResponseCode.SERVERERROR.getCode(),e.getMessage());
        }
        //web请求
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("message",e.getMessage());
        modelAndView.addObject("code",ResponseCode.SERVERERROR.getCode());
        modelAndView.setViewName(simpleProperies.getError_page());
        return modelAndView;
    }


    /**
     * 判断是否是ajax请求
     * <p>Title: isAjax</p>
     * <p>Description: </p>
     * @param httpRequest
     * @return
     */
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With")));
    }


}
