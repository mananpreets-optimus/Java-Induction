package com.eclipselink.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class Name : Employee 
 * [Pojo Class consisting of variables eid, ename, salary, deg]
 */
@Entity
@Table
public class Employee {
	
	@Id
	private int eid;
	private String ename;
	private double salary;
	private String deg;

	/**
	 * Default Constructor
	 */
	public Employee() {
		
		super();
	}

	/**Constructor
	 * @param eid : Employee Id
	 * @param ename : Employee Name
	 * @param salary : Employee Salary
	 * @param deg : Employee Designation
	 */
	public Employee(int eid, String ename, double salary, String deg) {
		
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.deg = deg;
	}

	/**
	 * @return eid : Employee Id
	 */
	public int getEid() {
		
		return eid;
	}

	/**
	 * @param eid : Employee Id
	 */
	public void setEid(int eid) {
		
		this.eid = eid;
	}

	/**
	 * @return ename : Employee Name
	 */
	public String getEname() {
		
		return ename;
	}

	/**
	 * @param ename : Employee Name
	 */
	public void setEname(String ename) {
		
		this.ename = ename;
	}

	/**
	 * @return salary : Employee Salary
	 */
	public double getSalary() {
		
		return salary;
	}

	/**
	 * @param salary : Employee Salary
	 */
	public void setSalary(double salary) {
		
		this.salary = salary;
	}

	/**
	 * @return deg : Employee Designation
	 */
	public String getDeg() {
		
		return deg;
	}

	/**
	 * @param deg : Employee Designation
	 */
	public void setDeg(String deg) {
		
		this.deg = deg;
	}

}
