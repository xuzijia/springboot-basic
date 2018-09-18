package com.simple.springbootbasic.basic.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 分页bean
 * @Author Simple
 * @Date 2018/9/18 9:25
 * @Version 1.0
 */
@Data
public class PageQuery implements Serializable {
    private int pageSize=10;
    private int pageNum=1;
}
