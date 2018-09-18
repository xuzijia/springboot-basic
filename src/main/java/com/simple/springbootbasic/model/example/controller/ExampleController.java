package com.simple.springbootbasic.model.example.controller;

import com.simple.springbootbasic.basic.result.PageQuery;
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

import javax.xml.namespace.QName;
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

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("/index");
        modelAndView.addObject("message","FREEMARKER");
        return modelAndView;
    }

    @RequestMapping("/exampleList.do")
    public ResultJsonData list(PageQuery pageQuery){
        List<Example> examples = exampleService.pageList(pageQuery.getPageNum(), pageQuery.getPageSize());
        return new ResultJsonUtils<Example>().success(examples);
    }

    @RequestMapping("/delete/{id}")
    public ResultJsonData list(@PathVariable("id") Integer id){
        if(id==null){
            return ResultJsonUtils.error(ResponseCode.MISSINGPARAMETERS.getCode(),ResponseCode.MISSINGPARAMETERS.getMessage());
        }
        exampleService.deleteExample(id);
        return ResultJsonUtils.success("删除成功");
    }

    @RequestMapping("/insert.do")
    public ResultJsonData insert(){
        Example e=new Example();
        e.setUsername("insert");
        e.setNote("desc");
        exampleService.save(e);
        return ResultJsonUtils.success();
    }
    @RequestMapping("/batchInsert.do")
    public ResultJsonData batchInsert(){
        for (int i=0;i<10;i++){
            Example e=new Example();
            e.setUsername("insert");
            e.setNote("desc");
            exampleService.save(e);
        }
        return ResultJsonUtils.success();
    }

}
