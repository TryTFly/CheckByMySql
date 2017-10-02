package com.y.test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.y.service.Service;

/**
 * 从本地文件插入数据测试类
 * @author Administrator
 *
 */
public class InsertTest {

	
	public static void main(String[] args) {
		//String a1=System.getProperty("/resources/txt/user.txt");
		Service service=new Service();
		service.insert("D:/user.txt");
	}
}
