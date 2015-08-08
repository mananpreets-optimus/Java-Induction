package com.restwebservice.RestWsEHCaching;

import java.util.Iterator;
import java.util.List;

public class ToString {
	/*
	 * Method Name: getJson parameter list of employees returns- json string
	 */
	/**
	 * @param list
	 * @return json string response
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
