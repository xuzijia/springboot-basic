package com.simple.springbootbasic.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.simple.springbootbasic.basic.base.impl.BaseServiceImpl;
import com.simple.springbootbasic.system.entity.SystemLog;
import com.simple.springbootbasic.system.mapper.SystemLogMapper;
import com.simple.springbootbasic.system.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 日志服务
 * @Author Simple
 * @Date 2018/9/18 10:48
 * @Version 1.0
 */
@Service
public class SystemLogImpl extends BaseServiceImpl<SystemLog> implements SystemLogService  {

    @Autowired
    private SystemLogMapper systemLogMapper;

    @Override
    public List<SystemLog> pageList(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return systemLogMapper.selectAll();
    }
}
