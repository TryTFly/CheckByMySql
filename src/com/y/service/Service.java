package com.y.service;

import java.io.IOException;
import java.util.List;

import com.y.dao.Dao;
import com.y.model.LoginDemoTable;
import com.y.model.TextArea1;
import com.y.model.TextArea2;

/**
 * Service������
 * 
 * @author Administrator
 *
 */
public class Service {

	public void insert(String path) {
		Dao dao = new Dao();
		try {
			dao.storeToDb(path);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	public List<LoginDemoTable> queryAll() {
		Dao dao = new Dao();
		return dao.queryAll();
	}

	public void insertByJsp(String str1, String str2) {
		Dao dao = new Dao();
		dao.insertByJsp(str1, str2);
	}

	public List<TextArea1> queryAllByJsp() {
		Dao dao = new Dao();
		return dao.queryAllByJsp();
	}
	
	public List<TextArea2> queryAllT2(){
		Dao dao=new Dao();
		return dao.queryAllT2();
	}
	
	public void deleteAll(){
		Dao dao = new Dao();
		dao.deleteAll();
	}

}
