package com.simple.springbootbasic.basic.permission.service.impl;

import com.simple.springbootbasic.basic.base.impl.BaseServiceImpl;
import com.simple.springbootbasic.basic.permission.entity.User;
import com.simple.springbootbasic.basic.permission.mapper.UserMapper;
import com.simple.springbootbasic.basic.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description
 * @Author Simple
 * @Date 2018/9/18 17:59
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("username=", userName);
        List<User> list = this.selectByExample(example);
        return list.size() == 0 ? null : list.get(0);
    }
}
