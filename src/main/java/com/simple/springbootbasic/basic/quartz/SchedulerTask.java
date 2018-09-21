package com.simple.springbootbasic.basic.quartz;

import com.simple.springbootbasic.basic.properties.SimpleProperies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 测试任务调度
 * @Author Simple
 * @Date 2018/9/20 10:56
 * @Version 1.0
 */
@Component
public class SchedulerTask {
    @Autowired
    private SimpleProperies simpleProperies;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    //每隔xx秒打印一下内容
    @Scheduled(fixedRate = 1000000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date())+"   uuid:["+simpleProperies.getUuid()+"]");
    }
}
