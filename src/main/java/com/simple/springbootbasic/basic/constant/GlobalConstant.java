package com.simple.springbootbasic.basic.constant;

/**
 * @Description 项目全局常量
 * @Author Simple
 * @Date 2018/9/18 11:12
 * @Version 1.0
 */
public interface GlobalConstant {

    interface SystemLog{
        /**
         * 日志类型
         */
        //web
        Integer logTypeWeb=1;
        //service
        Integer logTypeService=2;
        /**
         * 程序执行状态
         */
        Integer success=1;
        Integer error=2;
    }
}
