package com.situ.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 工具类
 * @author 浅墨~~
 *
 */
public class JdbcUtils {
	private static String url;
	private static String user;
	private static String password;
	private static String driver;
	//只加载一次
	static {
		 //读取资源文件，获取值。
		Properties pro=new Properties();
		InputStream is = JdbcUtils.class.getClassLoader().
				getResourceAsStream("com/situ/config/jdbc.properties");
		try {
			pro.load(is);
			url=pro.getProperty("url");
			user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //注册驱动
            Class.forName(driver);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	
	/**
	 * 获取链接
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("获取链接异常");
	}
	
	/**
	 * 释放连接
	 */
	public static void close( Connection connection) {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
