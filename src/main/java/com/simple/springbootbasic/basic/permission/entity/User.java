package com.simple.springbootbasic.basic.permission.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_system_user")
@Data
public class User implements Serializable {
	@Id
	private Long userId;

	private String username;

	private String password;
}