package com.y.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ�������
 * @author Administrator
 *
 */
public class DBAccess {

	private static String url="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
	private static String uesrname="root";
	private static String password="123456";
	
	//�������ݿ�����
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			return conn;
		}else {
			return conn;
		}
	}
	
}
