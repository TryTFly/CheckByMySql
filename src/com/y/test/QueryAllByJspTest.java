package com.y.test;

import java.util.List;

import com.y.model.TextArea1;
import com.y.service.Service;

/**
 * �ȶԲ�ѯ������ҳ������
 * @author Administrator
 *
 */
public class QueryAllByJspTest {

	public static void main(String[] args) {
		Service service=new Service();
		List<TextArea1> list=service.queryAllByJsp();
		for (TextArea1 textArea1 : list) {
			System.out.println(textArea1);
		}
		
	}
	
}
