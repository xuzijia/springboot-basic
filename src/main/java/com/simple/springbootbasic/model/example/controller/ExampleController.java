package com.simple.springbootbasic.model.example.controller;

import com.simple.springbootbasic.model.example.entity.Example;
import com.simple.springbootbasic.model.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * @Description
 * @Author Simple
 * @Date 2018/9/17 15:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/example")
public class ExampleController {
    @Autowired
    private ExampleService exampleService;

    @RequestMapping("/exampleList.do")
    public List<Example> list(){
        return exampleService.selectAll();
    }
}
