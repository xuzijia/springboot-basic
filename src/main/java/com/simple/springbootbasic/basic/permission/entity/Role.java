package com.simple.springbootbasic.basic.permission.entity;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_system_role")
@Data
public class Role implements Serializable {

	@Id
	private Long roleId;

	private String roleName;

	private String remark;

}