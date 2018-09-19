package com.simple.springbootbasic.model.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.simple.springbootbasic.basic.base.impl.BaseServiceImpl;
import com.simple.springbootbasic.utils.RedisUtil;
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
    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void deleteExample(Integer id) {
        exampleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 开启分页
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Example> pageList(Integer page, Integer size) throws Exception {
        //分页核心代码
        PageHelper.startPage(page, size);
        List<Example> examples = exampleMapper.selectAll();
        //redisUtil.set("list",examples,3600);
        return examples;
    }


}
