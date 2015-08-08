package com.restwebservice.RestWsEHCaching;
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
	/**
	 * @return
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
