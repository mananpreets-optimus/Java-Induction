package com.optimus.RestWebAssignment;
/*
 * public class Admin
 * POJO for admin table
 */
public class Admin {
	
	/*
	 * Data members
	 */
	private int adminId;
	private String userName;
	private String password;
	
	public Admin() {
	
	}
	public Admin(int adminId, String userName, String password) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
	}
	/*
	 * Getters & Setters for data members
	 */
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}