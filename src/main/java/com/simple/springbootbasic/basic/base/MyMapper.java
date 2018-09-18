package com.simple.springbootbasic.basic.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用MAPPER接口
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
	
}