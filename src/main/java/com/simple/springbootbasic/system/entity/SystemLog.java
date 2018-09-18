package com.simple.springbootbasic.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_system_log")
@Data
public class SystemLog implements Serializable {

	@Id
	private Long id;

	private String username;

	private Long time;

	private String method;

	private String url;

	private String ip;

	private String location;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;

	private String description;

	private String params;

	private String method_type;

	private Integer log_type;

	private Integer status;

	private String errorMessage;


	

}