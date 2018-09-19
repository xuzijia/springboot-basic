package com.simple.springbootbasic.basic.permission.mapper;


import com.simple.springbootbasic.basic.base.MyMapper;
import com.simple.springbootbasic.basic.permission.entity.Role;

import java.util.List;

/**
 * @Description
 * @Author Simple
 * @Date 2018/9/18 20:29
 * @Version 1.0
 */
public interface RoleMapper extends MyMapper<Role> {

    List<Role> findUserRole(String userName);
}
