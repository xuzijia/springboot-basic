package com.simple.springbootbasic.basic.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 全局配置文件
 */
@Configuration
@ConfigurationProperties(prefix = "simple")
@Data
public class SimpleProperies {
    private String example;
    private String errorPage;
    private String notFoundPage;
    private Boolean openAopLog;
    private String salt;
    private String unauthorizedPage;
    private String timeFormat;


    //shiro相关配置
    private ShiroProperties shiro = new ShiroProperties();
}
