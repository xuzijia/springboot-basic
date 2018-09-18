package com.simple.springbootbasic.basic.result;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * @Description 分页bean
 * @Author Simple
 * @Date 2018/9/18 9:25
 * @Version 1.0
 */
@Data
public class PageQuery implements Serializable {
    @Value("${simple.page.size}")
    private int pageSize=10;
    @Value("1")
    private int pageNum=2;
}
