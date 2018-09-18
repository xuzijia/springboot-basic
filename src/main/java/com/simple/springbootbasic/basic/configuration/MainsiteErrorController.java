package com.simple.springbootbasic.basic.configuration;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author Simple
 * @Date 2018/9/17 20:27
 * @Version 1.0
 */
@Controller
public class MainsiteErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 404){
            return "/404";
        }
        return "/error";
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }

}
