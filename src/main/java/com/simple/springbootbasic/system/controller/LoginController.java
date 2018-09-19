package com.simple.springbootbasic.system.controller;

import com.simple.springbootbasic.basic.annotation.Log;
import com.simple.springbootbasic.basic.base.BaseController;
import com.simple.springbootbasic.basic.permission.entity.User;
import com.simple.springbootbasic.basic.properties.SimpleProperies;
import com.simple.springbootbasic.basic.result.ResultJsonUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 登陆
 * @Author Simple
 * @Date 2018/9/18 17:34
 * @Version 1.0
 */
@Controller
public class LoginController extends BaseController {
    @Autowired
    private SimpleProperies simpleProperies;

    /**
     * 登陆页面
     */
    @RequestMapping("/login.view")
    public String loginView() {
        return "login";
    }

    /**
     * 登陆校验
     *
     * @param user
     * @return
     */
    @RequestMapping("/login.do")
    @ResponseBody
    @Log("登陆系统")
    public Object login(User user, Boolean rememberMe) {
        //密码加密
        String md5 = new SimpleHash("md5", user.getPassword() + simpleProperies.getSalt()).toString();
        //登陆校验
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), md5, rememberMe);
        super.login(token);
        //登陆成功
        return ResultJsonUtils.success();
    }

    /**
     * 重定向到主页
     *
     * @return
     */
    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index.do";
    }

    /**
     * 主页
     *
     * @param model
     * @return
     */
    @Log("访问系统主页")
    @RequestMapping("/index.do")
    public String index(Model model) {
        // 登录成后，即可通过 Subject 获取登录的用户信息
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "index";
    }
}
