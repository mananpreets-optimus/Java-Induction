/*
 * Package Name: assignment
 */
package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Map;
/*
 * Class Name: Employee
 * involves setHash
 */
public class Employee {
	
	EnumDepartment dept;
	HashMap <Integer,String> hashEmployee = new HashMap<Integer, String>();
	public HashMap<Integer, String> getHashEmployee() {
		return hashEmployee;
	}

	public void setHashEmployee(HashMap<Integer, String> hashEmployee) {
		this.hashEmployee = hashEmployee;
	}

	public Employee(EnumDepartment dept) {
		this.dept = dept;
	}
	
	private int id;
	private String name;
	private String depart;
	int count = 0;
	/*
	 * Method Name: getDepart
	 * returns- department name
	 */ 
	public String getDepart() {
		return depart;
	}
	/*
	 * Method Name: setDepart
	 * sets department name
	 */
	public void setDepart(String depart) {
		this.depart = depart;
	}
	/*
	 * Method Name: getId
	 * returns- id of employee
	 */
	public int getId() {
		return id;
	}
	/*
	 * Method Name: setId
	 * sets id of employee
	 */
	public void setId(int id) {
		this.id = id;
	}
	/*
	 * Method Name: getName
	 * returns- name of employee
	 */
	public String getName() {
		return name;
	}
	/*
	 * Method Name: setName
	 * sets name of employee
	 */
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * Method Name: checkDepart
	 * it checks for department name
	 */
	public void checkDepart() {
		switch(dept) {
		case IT:
			count = count++;
			System.out.println("Employee No." + count);
			for(Map.Entry<Integer, String> hashNames : getHashEmployee().entrySet()) {
			System.out.println("Department:IT Name: "+hashNames.getKey()+" Id " +hashNames.getValue());
			}
			break;
		case OPERATIONS:
			count = count++;
			System.out.println("Employee No." + count);
			for(Map.Entry<Integer, String> hashNames : getHashEmployee().entrySet()) {
				System.out.println("Department:IT Name: "+hashNames.getKey()+" Id " +hashNames.getValue());
				}
			break;
		case SALES:
			System.out.println("SALES");
			break;
		default:
			System.out.println("NOT AVALIABLE");
		}
			
	}
		
	public static void main(String args[]) throws IOException {

		int numOfEmployees = 0;
		String name = null;
		int id;
		String department;
		
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		
		HashMap <Integer,String> hashEmployee1 = new HashMap<Integer, String>();
	
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Department : IT, OPERATIONS, SALES ");
			department = reader1.readLine();
			Employee employee = new Employee(EnumDepartment.valueOf(department));
			employee.setDepart(department);
			
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Name of Employee");
			name = reader2.readLine();
			employee.setName(name);
			
			BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Id of Employee");
			id = Integer.parseInt(reader3.readLine());
			
			employee.setId(id);
			hashEmployee1.put(employee.getId(), employee.getName());
			employee.setHashEmployee(hashEmployee1);
			employee.checkDepart();
	
		
	}
	
}
