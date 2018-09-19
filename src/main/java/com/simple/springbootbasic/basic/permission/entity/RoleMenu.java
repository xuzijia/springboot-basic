package com.simple.springbootbasic.basic.permission.entity;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "t_role_menu")
public class RoleMenu implements Serializable {
	

    private Long roleId;

    private Long menuId;

}