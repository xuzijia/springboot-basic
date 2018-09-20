package com.simple.springbootbasic.basic.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description 测试websocket
 * @Author Simple
 * @Date 2018/9/20 10:03
 * @Version 1.0
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketController {
    @RequestMapping("/socket")
    public ModelAndView socket() {
        ModelAndView mav=new ModelAndView("/websocket/socket");
        return mav;
    }
}
