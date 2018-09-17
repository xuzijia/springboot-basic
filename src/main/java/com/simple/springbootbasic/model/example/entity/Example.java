package com.simple.springbootbasic.model.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * @Description 测试
 * @Author Simple
 * @Date 2018/9/17 15:04
 * @Version 1.0
 */
@Data
public class Example {

    @JsonIgnore
    private Integer id;
    private String username;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date birthday;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String desc;
}
