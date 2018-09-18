package com.simple.springbootbasic.model.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.simple.springbootbasic.basic.base.impl.BaseServiceImpl;
import com.simple.springbootbasic.model.example.entity.Example;
import com.simple.springbootbasic.model.example.mapper.ExampleMapper;
import com.simple.springbootbasic.model.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description
 * @Author Simple
 * @Date 2018/9/17 15:06
 * @Version 1.0
 */
@Service
public class ExampleServiceImpl extends BaseServiceImpl<Example> implements ExampleService {

    @Autowired
    private ExampleMapper exampleMapper;
    @Override
    public void deleteExample(Integer id) {
        Example example = exampleMapper.selectByPrimaryKey(id);
        exampleMapper.delete(example);
    }

    /**
     * 开启分页
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Example> pageList(Integer page, Integer size) {
        //分页核心代码
        PageHelper.startPage(page, size);
        return exampleMapper.selectAll();
    }


}
