package com.simple.springbootbasic.basic.permission.service;

import com.simple.springbootbasic.basic.base.BaseService;
import com.simple.springbootbasic.basic.permission.entity.Role;
import com.simple.springbootbasic.basic.permission.entity.RoleMenu;

import java.util.List;

/**
 * @Description TODO
 * @Author Simple
 * @Date 2018/9/18 19:13
 * @Version 1.0
 */
public interface RoleService extends BaseService<Role> {
    List<Role> findUserRole(String userName);

    void addMenu(RoleMenu roleMenu) throws Exception;

    void deleteMenu(RoleMenu roleMenu);

}
