package com.situ.dao;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.User;
/**
 * 查询User表
 * @author 浅墨~~
 * @date  2021年12月22日
 */
@Mapper
public interface LoginDAO {
	/**
	 * 
	 * @param username
	 * @return
	 */
	public User findUser(String username);

}
