package com.simple.springbootbasic.system.controller;

import com.simple.springbootbasic.basic.annotation.Log;
import com.simple.springbootbasic.basic.result.PageQuery;
import com.simple.springbootbasic.basic.result.ResponseCode;
import com.simple.springbootbasic.basic.result.ResultJsonData;
import com.simple.springbootbasic.basic.result.ResultJsonUtils;
import com.simple.springbootbasic.system.entity.SystemLog;
import com.simple.springbootbasic.system.service.SystemLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 系统日志记录
 * @Author Simple
 * @Date 2018/9/18 10:52
 * @Version 1.0
 */
@RestController
@RequestMapping("/system/log/")
public class SystemLogController {

    @Autowired
    private SystemLogService systemLogService;
    /**
     * 查询日志列表
     * @param pageQuery
     * @return
     */
    @Log(value = "查询日志列表")
    @RequestMapping("list.do")
    @RequiresPermissions("log:find")
    public ResultJsonData list(PageQuery pageQuery){
        List<SystemLog> systemLogs = systemLogService.pageList(pageQuery.getPageNum(), pageQuery.getPageSize());
        return new ResultJsonUtils<SystemLog>().success(systemLogs);
    }

    /**
     * 删除日志
     */
    @Log(value="删除日志")
    @RequestMapping("delete.do")
    @RequiresPermissions("log:delete")
    public ResultJsonData delete(Integer id){
        //判断id
        if(id==null){
            return ResultJsonUtils.error(ResponseCode.NOT_FOUND_PARAMS.getCode(),ResponseCode.NOT_FOUND_PARAMS.getMessage());
        }
        //执行删除
        systemLogService.delete(id);

        return ResultJsonUtils.success("删除成功");
    }
}
