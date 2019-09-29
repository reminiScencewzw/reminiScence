package cn.yunhe.dao;

import cn.yunhe.entity.User;

public interface UserDao {

	User queryUser(String userName,String pwd);
}
