package cn.edu.guet.util;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 获得连接 关闭连接
 *
 * @author liwei
 *
 */
public class DBConnection {

	private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

	public static Connection getConn() {
		// 先从TreadLocal取
		Connection conn = connectionThreadLocal.get();

		if (conn == null){
			Properties prop = new Properties();
			InputStream in;
			try {
				in = Class.forName("cn.edu.guet.util.DBConnection").getResourceAsStream("/db.properties");
				prop.load(in);

				String url = prop.getProperty("url");
				Class.forName(prop.getProperty("driver"));// 加载驱动
				conn = DriverManager.getConnection(url, prop.getProperty("user"), prop.getProperty("password"));
				connectionThreadLocal.set(conn);
				return conn;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void closeConn(Connection conn)
	{
		try {
			if(conn!=null) 	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}