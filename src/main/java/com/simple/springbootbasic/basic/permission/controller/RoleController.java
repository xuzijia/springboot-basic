package com.simple.springbootbasic.basic.permission.controller;

import com.simple.springbootbasic.basic.base.BaseController;
import com.simple.springbootbasic.basic.permission.entity.RoleMenu;
import com.simple.springbootbasic.basic.permission.service.RoleService;
import com.simple.springbootbasic.basic.result.ResultJsonData;
import com.simple.springbootbasic.basic.result.ResultJsonUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 用户角色
 * @Author Simple
 * @Date 2018/9/19 15:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/permission/role")
public class RoleController  extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 为角色新增权限
     * @return
     */
    @RequestMapping("/addMenu.do")
    @RequiresPermissions("role:addMenu")
    public ResultJsonData addMenu(RoleMenu roleMenu) throws Exception {
        roleService.addMenu(roleMenu);
        return ResultJsonUtils.success("角色权限修改成功");
    }
    /**
     * 从角色中删除权限
     * @return
     */
    @RequestMapping("/deleteMenu.do")
    @RequiresPermissions("role:deleteMenu")
    public ResultJsonData deleteMenu(RoleMenu roleMenu){
        roleService.deleteMenu(roleMenu);
        return ResultJsonUtils.success("角色权限删除成功");
    }
}
