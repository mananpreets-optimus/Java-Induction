/*
 * Package Name : com.employee
 */
package com.employee;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/*
 * Class Name: TestRunner
 * runs TestEmployee class
 */
public class TestRunner {
	
	public static void main(String args[]){
		
		Result result = JUnitCore.runClasses(TestEmployee.class);
		for(Failure failure : result.getFailures()){
			
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
		
	}

}
