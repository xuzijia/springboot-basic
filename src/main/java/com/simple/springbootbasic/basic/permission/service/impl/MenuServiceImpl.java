package com.simple.springbootbasic.basic.permission.service.impl;

import com.simple.springbootbasic.basic.base.impl.BaseServiceImpl;
import com.simple.springbootbasic.basic.permission.entity.Menu;
import com.simple.springbootbasic.basic.permission.mapper.MenuMapper;
import com.simple.springbootbasic.basic.permission.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Simple
 * @Date 2018/9/18 20:27
 * @Version 1.0
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findUserPermissions(String userName) {
        return menuMapper.findUserPermissions(userName);
    }
}
