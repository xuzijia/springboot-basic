package com.simple.springbootbasic.model.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description 测试
 * @Author Simple
 * @Date 2018/9/17 15:04
 * @Version 1.0
 */
@Data
@Table(name="t_example")
public class Example implements Serializable {

    @JsonIgnore
    @Id
    private Integer id;
    @Column(name="name")
    private String username;
    private Date birthday;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String note;
}
