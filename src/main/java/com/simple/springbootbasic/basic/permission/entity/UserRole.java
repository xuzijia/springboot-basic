package com.simple.springbootbasic.basic.permission.entity;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_user_role")
@Data
public class UserRole implements Serializable {

	private Long userId;
	private Long roleId;

}