package com.simple.springbootbasic.basic.permission.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_system_menu")
@Data
public class Menu implements Serializable {
    @Id
    private Long menuId;

    private Long parentId;

    private String menuName;

    private String url;

    private String code;

    private String icon;

    private String type;

    private Long orderNum;
}