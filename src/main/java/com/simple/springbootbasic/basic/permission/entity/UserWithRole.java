package com.simple.springbootbasic.basic.permission.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserWithRole extends User{

	private Long RoleId;
	private List<Long> roleIds;

}