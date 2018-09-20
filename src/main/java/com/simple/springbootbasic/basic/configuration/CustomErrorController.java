package com.simple.springbootbasic.basic.configuration;

import com.simple.springbootbasic.basic.properties.SimpleProperies;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomErrorController implements ErrorController {
    @Autowired
    private SimpleProperies simpleProperies;

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 404){
            request.setAttribute("javax.servlet.error.status_code",200);
            return simpleProperies.getNotFoundPage();
        }
        return "/error";
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }

}
