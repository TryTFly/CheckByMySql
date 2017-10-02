package com.y.model;

/**
 * test表对应的实体类
 * 
 * @author Administrator
 *
 */
public class TestTable {

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "TestTable [username=" + username + ", password=" + password + "]";
	}

}
