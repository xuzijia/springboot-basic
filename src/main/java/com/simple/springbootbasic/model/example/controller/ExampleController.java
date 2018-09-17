package com.simple.springbootbasic.model.example.controller;

import com.simple.springbootbasic.basic.result.ResponseCode;
import com.simple.springbootbasic.basic.result.ResultJsonData;
import com.simple.springbootbasic.basic.result.ResultJsonUtils;
import com.simple.springbootbasic.model.example.entity.Example;
import com.simple.springbootbasic.model.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("/index");
        modelAndView.addObject("message","FREEMARKER");
        return modelAndView;
    }

    @RequestMapping("/exampleList.do")
    public ResultJsonData list(){
        List<Example> examples = exampleService.selectAll();
        return new ResultJsonUtils<Example>().success(examples);
    }

    @RequestMapping("/delete/{id}")
    public ResultJsonData list(@PathVariable("id") Integer id){
        if(id==null){
            return ResultJsonUtils.error(ResponseCode.MISSINGPARAMETERS.getCode(),ResponseCode.MISSINGPARAMETERS.getMessage());
        }
        exampleService.delete(id);
        return ResultJsonUtils.success("删除成功");
    }
}
