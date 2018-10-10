package com.simple.springbootbasic.system.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_system_log")
@Data
public class SystemLog implements Serializable {

	@Id
	@Column(name="log_id")
	private Long id;

	private String username;

	private Long time;

	private String method;

	private String url;

	private String ip;

	private String location;

	private Date createTime;

	private String description;

	private String params;

	private String method_type;

	private Integer log_type;

	private Integer status;

	private String errorMessage;

}
