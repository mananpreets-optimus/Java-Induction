/**
 * Package com.patterns.composite 
 * contains classes and interfaces for implementation of composite design pattern.
 */
package com.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Employee : contains details of employees.
 */
public class Employee {
	   private String name;
	   private String dept;
	   private int salary;
	   private List<Employee> subordinates;

	   /**
	    * constructor of Employee class
	    * @param name name of employee
	    * @param dept department of employee
	    * @param sal salary of employee
	    */
	   public Employee(String name,String dept, int sal) {
	      this.name = name;
	      this.dept = dept;
	      this.salary = sal;
	      subordinates = new ArrayList<Employee>();
	   }

	   /**
	    * For adding employee
	    * @param employee employee
	    */
	   public void add(Employee employee) {
	      subordinates.add(employee);
	   }

	   /**
	    * For removing employee
	    * @param employee employee
	    */
	   public void remove(Employee employee) {
	      subordinates.remove(employee);
	   }

	   /**
	    * For getting subordinates of an employee
	    * @return subordinates subordinates of an employee
	    */
	   public List<Employee> getSubordinates(){
	     return subordinates;
	   }

	   /**
	    * ToString method is override.
	    */
	   public String toString(){
	      return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
	   }   
	}
