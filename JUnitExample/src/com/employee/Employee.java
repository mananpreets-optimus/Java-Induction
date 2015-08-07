package com.employee;
/*
 * Class Name: Employee
 * Pojo class
 */
public class Employee {
	
	private String name;
	private double monthlySalary;
	private int age;
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return
	 */
	public double getMonthlySalary() {
		return monthlySalary;
	}
	/**
	 * @param monthlySalary
	 */
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	/**
	 * @return
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
