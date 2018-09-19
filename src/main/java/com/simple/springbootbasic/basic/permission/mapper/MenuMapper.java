package com.simple.springbootbasic.basic.permission.mapper;

import com.simple.springbootbasic.basic.base.MyMapper;
import com.simple.springbootbasic.basic.permission.entity.Menu;

import java.util.List;

/**
 * @Description
 * @Author Simple
 * @Date 2018/9/18 20:28
 * @Version 1.0
 */
public interface MenuMapper extends MyMapper<Menu> {
    List<Menu> findUserPermissions(String userName);
}
