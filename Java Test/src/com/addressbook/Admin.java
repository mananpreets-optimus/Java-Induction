package com.addressbook;

/**
 * @author optimus3
 *
 */
public class Admin {
	private int adminId;
	private String adminName;
	private String password;
	public Admin() {
		
	}
	/**
	 * @param adminName
	 * @param password
	 */
	public Admin(String adminName, String password) {
		
		this.adminName = adminName;
		this.password = password;
	}
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
	public String getAdminName() {
		return adminName;
	}
	/**
	 * @param adminName
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
