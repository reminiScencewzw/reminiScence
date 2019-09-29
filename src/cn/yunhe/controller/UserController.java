package cn.yunhe.controller;

import cn.yunhe.entity.User;
import cn.yunhe.service.UserService;
import cn.yunhe.service.impl.UserServiceImpl;

public class UserController {

	UserService userService = new UserServiceImpl();
	
	/**
	 * 根据用户名和密码查询用户信息
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public User queryUser(String userName,String pwd) {
		return userService.queryUser(userName, pwd);
	}
}
