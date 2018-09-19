package com.simple.springbootbasic.basic.permission.service.impl;

import com.simple.springbootbasic.basic.base.impl.BaseServiceImpl;
import com.simple.springbootbasic.basic.permission.entity.Role;
import com.simple.springbootbasic.basic.permission.entity.RoleMenu;
import com.simple.springbootbasic.basic.permission.mapper.RoleMapper;
import com.simple.springbootbasic.basic.permission.mapper.RoleMenuMapper;
import com.simple.springbootbasic.basic.permission.realm.ShiroRealm;
import com.simple.springbootbasic.basic.permission.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
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
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<Role> findUserRole(String userName) {
        return roleMapper.findUserRole(userName);
    }

    /**
     * 在角色菜单的中间表中新增一条记录
     */
    @Override
    public void addMenu(RoleMenu roleMenu)throws Exception {
        roleMenuMapper.insert(roleMenu);
        //刷新用户权限
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm authRealm = (ShiroRealm)rsm.getRealms().iterator().next();
        authRealm.clearAuthorizationInfoCache();
    }

    /**
     * 删除角色中的权限
     * @param roleMenu
     */
    @Override
    public void deleteMenu(RoleMenu roleMenu) {
        roleMenuMapper.delete(roleMenu);
        //刷新用户权限
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm authRealm = (ShiroRealm)rsm.getRealms().iterator().next();
        authRealm.clearAuthorizationInfoCache();

    }
}
