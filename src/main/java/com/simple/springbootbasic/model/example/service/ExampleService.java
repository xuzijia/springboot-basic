package com.simple.springbootbasic.model.example.service;

import com.simple.springbootbasic.model.example.entity.Example;

import java.util.List;

/**
 * @Description
 * @Author Simple
 * @Date 2018/9/17 15:05
 * @Version 1.0
 */
public interface ExampleService {
    List<Example> selectAll();
    void delete(Integer id);
}
