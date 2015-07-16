/*
 * Package Name: assignment
 */
package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*
 * Class Name:EmployeeNew
 * includes variables name, id and department of employee
 */
public class EmployeeNew {
	
	private String name;
	private int id;
	private Department dep;
	/*
	 * Enum Name: Department
	 * includes department names
	 */
	public enum Department {
		IT("IT"), OPERATIONS("Operations"), SALES("Sales");
		
		private String deptName;
		/*
		 * Constructor of Enum: Department for initialization
		 */
		Department(String deptName) {
			this.deptName = deptName;
		}
		public String getDepartment() {
			return deptName;
		}
		public String toString() {
			return this.deptName;
		}
	}
	
	public String toString() {
		return name+" "+id+" "+dep;
	}
	/*
	 * Constructor of Class: EmployeeNew for initialization
	 */
	public EmployeeNew(String name, int id, Department dep) {
		this.name = name;
		this.id = id;
		this.dep = dep;
	}
	
	public static void main(String args[]) throws IOException {
	
		List<EmployeeNew> list= new ArrayList<EmployeeNew> ();
		Map<Integer,String> map = new HashMap<Integer, String> ();
		//Map<Integer,String> mapTree = new TreeMap<Integer, String>();
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter number of employees : ");
		int numOfEmployee = Integer.parseInt(read.readLine());
		while(numOfEmployee > 0) {
			System.out.println("Enter Name : ");
			String nam = read.readLine();
			System.out.println("Enter id : ");
			int idd = Integer.parseInt(read.readLine());
			
			Department[] s = Department.values();
			System.out.println("Department : "+s[numOfEmployee % 3]);
			list.add(new EmployeeNew(nam, idd, s[numOfEmployee % 3]));
			map.put(idd, nam);
			//mapTree.put(idd, nam);
			--numOfEmployee;
		}
		System.out.println("Employees whose department is not Sales are as follows");
		for(EmployeeNew emp : list) {
			if (emp.dep.toString() != "Sales") {
				System.out.println("Employee Name : "+map.get(emp.id));
			}
		}
		read.close();
	
	}
}
