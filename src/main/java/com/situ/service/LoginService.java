package com.situ.service;

import com.situ.model.User;

/**
 * 登入业务
 * @author 浅墨~~
 * @date  2021年12月22日
 */


public interface LoginService {
	
	
	
	/**
	 * 通过User查找是否能登入
	 * @param valueOf
	 * @return
	 */
	public User findUser(User user);

	
	
}
