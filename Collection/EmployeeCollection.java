package concepts;

import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeCollection  {
	
	public static void main (String args[]) {
		
		Employee employee1 = new Employee(1, "Manan");
		Employee employee2 = new Employee(2, "Ravi");
		Employee employee3 = new Employee(3, "Aman");
		ArrayList <Employee> EmployeeList = new ArrayList <Employee>();
		EmployeeList.add(employee1);
		EmployeeList.add(employee2);
		EmployeeList.add(employee3);
		ArrayList <Employee> EmployeeList2 = new ArrayList<Employee>();
		EmployeeList2.add(employee1);
		EmployeeList2.add(employee2);
		/*
		 * addAll() method implementation 
		 */
		EmployeeList.addAll(EmployeeList2);
		Iterator<Employee> itr = EmployeeList.iterator();
		while(itr.hasNext()) {
			Employee emp =  (Employee)itr.next();
			System.out.println("Name : "+ emp.name+"  Employee Id : "+emp.id);
		}
		/*
		 * removeAll() method implementation
		 */
		EmployeeList.removeAll(EmployeeList2);
		Iterator<Employee> iter = EmployeeList.iterator();
		System.out.println("\nIterating after removing elements of EmployeeList2");
		while(iter.hasNext()) {
			Employee emp1 = (Employee) iter.next();
			System.out.println("Name : " + emp1.name +" Employee Id : " + emp1.id);
		}
	}
}
