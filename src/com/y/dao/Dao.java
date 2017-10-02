package com.y.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.y.dbaccess.DBAccess;
import com.y.model.LoginDemoTable;
import com.y.model.TextArea1;
import com.y.model.TextArea2;
import com.y.util.StringUtil;

/**
 * ���ݿ⽻����
 * @author Administrator
 *
 */
public class Dao {

	private Connection conn = DBAccess.getConnection();

	/**�ӱ����ļ��ж�ȡ
	 * @param srcFile
	 * @throws IOException
	 */
	public void storeToDb(String srcFile) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile), "utf-8"));
		try {
			insert(bfr);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bfr.close();
		}
	}

	public void insert(BufferedReader bfr) {
		
		String sql1 = "insert into loginDemo (username,password) values(?,?)";
		try {
			conn.setAutoCommit(false);// �����ֶ��ύ
			int count = 0;
			PreparedStatement psts = conn.prepareStatement(sql1);
			String line = null;
			while (null != (line = bfr.readLine())) {
				//String[] infos = line.split(";");
				String[] infos = line.split("");
				if (infos.length < 2)
					continue;
				if (true) {
					System.out.println(line);
				}
				psts.setString(1, infos[0]);
				psts.setString(2, infos[1]);
				psts.addBatch(); // ������������
				count++;
			}
			psts.executeBatch(); // ִ����������
			conn.commit(); // �ύ
			System.out.println("All down : " + count);
			//conn.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
	
	
public void insertByJsp(String str1,String str2) {
		
		String sql1 = "insert into textarea1 (odNumber) values(?)";
		String sql2="insert into textarea2 (odNumber) values(?)";
		try {
			conn.setAutoCommit(false);// �����ֶ��ύ
			int count = 0;
			PreparedStatement psts1 = conn.prepareStatement(sql1);
			PreparedStatement psts2 = conn.prepareStatement(sql2);
			//String line = null;
			StringUtil stringUtil=new StringUtil();
			String[] infos1 = str1.split("\n");
			for(int i=0;i<infos1.length;i++) {
				//String[] infos = line.split(";");
				//infos1[i]=infos1[i].replaceAll("\n", "");
				infos1[i]=infos1[i].trim();
				if (true) {
					System.out.println(infos1[i]);
				}
				psts1.setString(1, infos1[i]);
				//psts.setString(2, infos[1]);
				psts1.addBatch(); // ������������
				count++;
			}
			psts1.executeBatch(); // ִ����������
			String[] infos2 = str2.split("\n");
			for(int j=0;j<infos2.length;j++) {
				//String[] infos = line.split(";");
				//infos2[j]=infos2[j].replaceAll("\n", "");
				infos2[j]=infos2[j].trim();
				if (true) {
					System.out.println(infos2[j]);
				}
				psts2.setString(1, infos2[j]);
				//psts.setString(2, infos[1]);
				psts2.addBatch(); // ������������
				count++;
			}
			psts2.executeBatch(); // ִ����������
			conn.commit(); // �ύ
			System.out.println("All down : " + count);
			if(count==0){
				conn.rollback();
				System.out.println("ʧ��");
			}
			//conn.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
	
	public List<LoginDemoTable> queryAll(){
		//select a.* from t1 a inner join t2 b on a.id=b.id and a.val=b.val ���Ӳ�ѯ
		//select * from A where aID not in (select aID from B)
		String  sql="select l.username from logindemo l "
				+ "where l.username not in (select t.username from testlogin t) ";
		List<LoginDemoTable> lgList=new ArrayList<LoginDemoTable>();
		try {
			PreparedStatement ptat= conn.prepareStatement(sql);
			ResultSet rs= ptat.executeQuery();
			while(rs.next()){
				LoginDemoTable loginDemoTable=new LoginDemoTable();
				loginDemoTable.setUsername(rs.getString("username"));
				lgList.add(loginDemoTable);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return lgList;
	}

	public List<TextArea1> queryAllByJsp(){
		//select a.* from t1 a inner join t2 b on a.id=b.id and a.val=b.val ���Ӳ�ѯ
		//select * from A where aID not in (select aID from B)
		String  sql="select t1.odnumber from textarea1 t1 "
				+ "where t1.odnumber not in (select t2.odnumber from textarea2 t2) ";
		Date nowTime=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(nowTime);
		List<TextArea1> tList=new ArrayList<TextArea1>();
		try {
			PreparedStatement ptat= conn.prepareStatement(sql);
			ResultSet rs= ptat.executeQuery();
			System.out.println(time);
			while(rs.next()){
				TextArea1 area1=new TextArea1();
				area1.setOdNumber(rs.getString("odnumber"));
				tList.add(area1);
				System.out.println(area1);
				
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return tList;
	}
	
	public List<TextArea2> queryAllT2(){
		String sql="select odnumber from textarea2 ";
		try {
			PreparedStatement ptat= conn.prepareStatement(sql);
			ResultSet rs= ptat.executeQuery();
			List<TextArea2> list=new ArrayList<TextArea2>();
			while(rs.next()){
				TextArea2 area2=new TextArea2();
				area2.setOdNumber(rs.getString("odnumber"));
				list.add(area2);
				System.out.println(area2);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteAll(){
		String sql1="truncate table textarea1";
		String sql2="truncate table textarea2";
		
		try {
			Statement statement= conn.createStatement();
			statement.execute(sql1);
			statement.execute(sql2);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
}
