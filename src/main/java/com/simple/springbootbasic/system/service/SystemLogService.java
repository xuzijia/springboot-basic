package com.simple.springbootbasic.system.service;

import com.simple.springbootbasic.basic.base.BaseService;
import com.simple.springbootbasic.system.entity.SystemLog;

import java.util.List;

/**
 * @Description 日志服务
 * @Author Simple
 * @Date 2018/9/18 10:47
 * @Version 1.0
 */
public interface SystemLogService extends BaseService<SystemLog> {
    List<SystemLog> pageList(Integer page, Integer size);
}
