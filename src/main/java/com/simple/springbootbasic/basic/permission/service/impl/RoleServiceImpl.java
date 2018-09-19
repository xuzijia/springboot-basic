package com.simple.springbootbasic.basic.permission.service.impl;

import com.simple.springbootbasic.basic.base.impl.BaseServiceImpl;
import com.simple.springbootbasic.basic.permission.entity.Role;
import com.simple.springbootbasic.basic.permission.mapper.RoleMapper;
import com.simple.springbootbasic.basic.permission.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Simple
 * @Date 2018/9/18 20:26
 * @Version 1.0
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findUserRole(String userName) {
        return roleMapper.findUserRole(userName);
    }
}
