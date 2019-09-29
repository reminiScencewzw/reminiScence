package cn.yunhe.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */
public class DBUtils {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/news?serverTimezone=UTC";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "123456";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public static int cud(String sql) {
		Connection conn = null;
		Statement statement = null;
		int result = 0;
		try {
			//鑾峰彇鏁版嵁搴撹繛鎺ュ璞�
			conn = getConnection();
			//鑾峰彇鎵цSQL鐨勫璞�
			statement = conn.createStatement();
			//鎵цSQL
			result = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//鍏抽棴鏁版嵁搴撻摼鎺ュ璞�
			close(conn,statement,null);
		}
		return result;
	}
	
	/**
	 * 棰勭紪璇戝舰寮忓鍒犳敼鍔熻兘灏佽
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static int cudPre(String sql,Object...objects) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			//鑾峰彇鏁版嵁搴撹繛鎺ュ璞�
			conn = getConnection();
			//鑾峰彇鎵цSQL鐨勫璞�
			ps = conn.prepareStatement(sql);
			//璁剧疆浼犻�掕繃鏉ョ殑鍙傛暟
			for(int i=0;i<objects.length;i++) {
				//鏁扮粍鐨勪笅鏍囨槸浠庨浂寮�濮�,鐩殑鏄负浜嗗彇鏁扮粍涓殑鏁版嵁
				//鍗犱綅绗�(?)浠�1寮�濮�,鏍囪瘑鐨勬槸鍗犱綅绗︾殑浣嶇疆
				ps.setObject(i+1, objects[i]);
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//鍏抽棴鏁版嵁搴撻摼鎺ュ璞�
			close(conn,ps,null);
		}
		return result;
	}
	
	/**
	 * 鍏抽棴鏁版嵁搴撻摼鎺�
	 * @param conn
	 * @param statement
	 * @param rs
	 */
	public static void close(Connection conn,Statement statement,ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
