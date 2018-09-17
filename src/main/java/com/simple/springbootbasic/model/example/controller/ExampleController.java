package com.simple.springbootbasic.model.example.controller;

import com.simple.springbootbasic.model.example.entity.Example;
import com.simple.springbootbasic.model.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/delete/{id}")
    public Map list(@PathVariable("id") Integer id){
        Map<String,Object> map=new HashMap<>();
        if(id==null){
            map.put("code",400);
            map.put("message","参数错误");
            return map;
        }
        exampleService.delete(id);
        map.put("code",200);
        map.put("message","删除成功");
        return map;
    }
}
