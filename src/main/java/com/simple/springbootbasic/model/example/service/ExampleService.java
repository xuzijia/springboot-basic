package com.simple.springbootbasic.model.example.service;

import com.simple.springbootbasic.basic.base.BaseService;
import com.simple.springbootbasic.model.example.entity.Example;
import java.util.List;

/**
 * @Description
 * @Author Simple
 * @Date 2018/9/17 15:05
 * @Version 1.0
 */
public interface ExampleService extends BaseService<Example> {
    void deleteExample(Integer id);

    /**
     * 开启分页
     * @param page
     * @param size
     * @return
     */
    List<Example> pageList(Integer page,Integer size) throws Exception;
}
