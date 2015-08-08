package com.restwebservice.RestWsEHCaching;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Class Name: Employee
 * includes variables id empName gender address city state telephone
 * two constructors and getter setter methods all variables
 */
/**
 * @author optimus3
 *
 */
@XmlRootElement
public class Employee {
	private int id;
	private String empName;
	private String gender;
	private String address;
	private String city;
	private String state;
	private int telephone;

	public Employee() {

	}

	/**
	 * @param empName
	 * @param gender
	 * @param address
	 * @param city
	 * @param state
	 * @param telephone
	 */
	public Employee(String empName, String gender, String address, String city,
			String state, int telephone) {

		this.empName = empName;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.telephone = telephone;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return telephone
	 */
	public int getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 */
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

}
