package com.simple.springbootbasic.model.example.service.impl;

import com.simple.springbootbasic.basic.configuration.SimpleProperies;
import com.simple.springbootbasic.basic.utils.RedisUtil;
import com.simple.springbootbasic.model.example.entity.Example;
import com.simple.springbootbasic.model.example.mapper.ExampleMapper;
import com.simple.springbootbasic.model.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description
 * @Author Simple
 * @Date 2018/9/17 15:06
 * @Version 1.0
 */
@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private ExampleMapper exampleMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SimpleProperies simpleProperies;

    public List<Example> selectAll(){
        List<Example> examples = null;
        String example = simpleProperies.getExample();
        if(redisUtil.hasKey(example)){
            examples= (List<Example>) redisUtil.get(example);
        }else{
            examples=exampleMapper.selectAll();
            redisUtil.set(example,examples,5);
        }
        return examples;
    }
    @Transactional
    public void delete(Integer id){
        exampleMapper.delete(id);
        //测试事务
        int a=1/0;
    }
}
