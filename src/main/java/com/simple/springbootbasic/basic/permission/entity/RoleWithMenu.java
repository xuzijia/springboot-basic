package com.simple.springbootbasic.basic.permission.entity;

import lombok.Data;

import java.util.List;

@Data
public class RoleWithMenu extends Role{
	private Long menuId;
	private List<Long> menuIds;
}
