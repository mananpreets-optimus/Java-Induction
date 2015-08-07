package com.employee;
/*
 * Class Name:  EmployeeBussinessLogic
 * involves function calculateYearlySalary
 */
public class EmployeeBussinessLogic {
	/*
	 * Calculates yearly salary
	 */
	 public double calculateYearlySalary(Employee employee){
		 
	      double yearlySalary=0;
	      yearlySalary = employee.getMonthlySalary() * 12;
	      return yearlySalary;
	   }
}
