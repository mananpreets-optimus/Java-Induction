/*
 * Package Name: com.optimus.RestWebAssignment
 */
package com.optimus.RestWebAssignment;

import java.util.Iterator;
import java.util.List;
/*
 * Class Name: ListToString
 * includes method getJson
 */
public class ListToString {
	/*
	 * Method Name: getJson
	 * parameter list of employees
	 * returns- json string
	 */
	 public String getJson(List<Employee> list) {
	  Iterator<Employee> iterator = list.iterator();
	  StringBuffer response = new StringBuffer("");
	  response.append("[");
	  while (iterator.hasNext()) {
	   Employee employee = (Employee) iterator.next();
	   int id = employee.getId();
	   String name = employee.getEmpName();
	   String gender = employee.getGender();
	   String address = employee.getAddress();
	   response.append("{\"id\":" + id + ",\"empName\":\"" + name
	     + "\",\"gender\":\"" + gender + "\",\"address\":\""
	     + address + "\"},");

	  }
	  int length = response.length();
	  response.deleteCharAt(length - 1);
	  response.append("]");
	  return (response.toString());
	 }
	}
