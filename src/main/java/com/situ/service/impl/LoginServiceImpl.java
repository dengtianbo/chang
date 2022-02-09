package com.situ.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.situ.dao.LoginDAO;
import com.situ.model.User;
import com.situ.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDAO dao;
	
	/**
	 * 没有查询到返回null，查到返回user
	 */
	@Override
	public User findUser(User user) {
		
		User checkuser = dao.findUser(user.getName());
		
		if (checkuser == null) {
			return null;
		}
		// 在数据库中新增用户的时候，密码是：username{password}的md5格式
		String encrypt = user.getName() + "{" + user.getPassword() + "}";
		String md5Str = DigestUtils.md5DigestAsHex(encrypt.getBytes());
		
		if (md5Str.equals(checkuser.getPassword())) {
			
			return checkuser;
		}else {
			
			return null;
		}
		
	}

}
