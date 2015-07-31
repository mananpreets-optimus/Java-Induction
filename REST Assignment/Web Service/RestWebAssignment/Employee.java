/*
 * Package Name: com.optimus.OptimusRestWebService
 */
package com.optimus.RestWebAssignment;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Class Name: Employee
 * includes variables id empName gender address city state telephone
 * two constructors and getter setter methods all variables
 */
@XmlRootElement
public class Employee {
	private int id;
	private String empName;
	private String gender;
	private String address;
	private String city;
	private String state;
	private String telephone;
	
	public Employee(){
		
	}
	public Employee(String empName, String gender, String address,
			String city, String state, String telephone) {
		
		this.empName = empName;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.telephone = telephone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
