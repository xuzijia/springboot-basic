package com.simple.springbootbasic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 程序启动入口
 */
@SpringBootApplication
@EnableTransactionManagement //开启事务处理
@MapperScan("com.simple.springbootbasic.**.mapper")
@EnableScheduling //开启任务调度
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
