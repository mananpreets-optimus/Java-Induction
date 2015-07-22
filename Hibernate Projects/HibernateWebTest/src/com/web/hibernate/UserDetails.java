/*
 * Package Name: com.web.hibernate
 */
package com.web.hibernate;
/*
 * Class Name: UserDetails
 * includes variables userName and password
 * two constructors and getter setter methods for userName and password
 */
public class UserDetails {
	private int id;
	private String userName;
	private String password;
	
	public UserDetails() {
		
	}
	
	public UserDetails(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
