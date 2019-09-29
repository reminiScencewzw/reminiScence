package cn.yunhe.service;

import cn.yunhe.entity.User;

public interface UserService {

	User queryUser(String userName,String pwd);
}
