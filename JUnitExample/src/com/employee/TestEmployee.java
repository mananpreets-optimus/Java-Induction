/*
 * Package Name: com.employee
 */
package com.employee;

import static org.junit.Assert.*;

import org.junit.Test;
/*
 * Class Name: TestEmployee
 * includes method testCalculateYearlySalary
 */
public class TestEmployee {
	
	Employee employee = new Employee();
	EmployeeBussinessLogic empBusinessLogic = new EmployeeBussinessLogic();
	// test to check yearly salary
	   @Test
	   public void testCalculateYearlySalary() {
		   
	      employee.setName("Rajeev");
	      employee.setAge(25);
	      employee.setMonthlySalary(8000);
	      double salary= empBusinessLogic.calculateYearlySalary(employee);
	      assertEquals(96000, salary, 0.0);
	   }
}
