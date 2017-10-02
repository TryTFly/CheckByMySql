package com.y.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接类
 * @author Administrator
 *
 */
public class DBAccess {

	private static String url="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
	private static String uesrname="root";
	private static String password="123456";
	
	//加载数据库驱动
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	private static Connection conn=null;
	
	public static Connection getConnection(){
		if(conn==null)
		{
			try {
				conn=DriverManager.getConnection(url,uesrname,password);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return conn;
		}else {
			return conn;
		}
	}
	
}
