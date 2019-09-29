package cn.yunhe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;

import cn.yunhe.dao.UserDao;
import cn.yunhe.entity.User;
import cn.yunhe.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User queryUser(String userName, String pwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from t_user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()){
				String queryName = rs.getString(2);
				if(null != queryName){
					User user = new User();
					user.setId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setPwd(rs.getString(3));
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return null;
	}

}
