package com.simple.springbootbasic.basic.permission.service;

import com.simple.springbootbasic.basic.base.BaseService;
import com.simple.springbootbasic.basic.permission.entity.User;

/**
 * @Description TODO
 * @Author Simple
 * @Date 2018/9/18 17:57
 * @Version 1.0
 */
public interface UserService extends BaseService<User> {
    User findByName(String userName);
}
