package com.simple.springbootbasic.basic.permission.service;

import com.simple.springbootbasic.basic.base.BaseService;
import com.simple.springbootbasic.basic.permission.entity.Menu;

import java.util.List;

/**
 * @Description
 * @Author Simple
 * @Date 2018/9/18 19:13
 * @Version 1.0
 */
public interface MenuService extends BaseService<Menu> {
    List<Menu> findUserPermissions(String userName);
}
