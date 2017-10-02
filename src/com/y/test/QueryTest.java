package com.y.test;

import java.util.List;

import com.y.model.LoginDemoTable;
import com.y.service.Service;

/**
 * Query≤‚ ‘¿‡
 * @author Administrator
 *
 */
public class QueryTest {

	public static void main(String[] args) {
		Service service=new Service();
		List<LoginDemoTable> list= service.queryAll();
		for (LoginDemoTable loginDemoTable : list) {
			System.out.println(loginDemoTable);
		}
	}
	
}
