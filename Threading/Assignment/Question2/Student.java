/*
 * Package Name: assignment2b
 */
package assignment2b;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Class Name: Student
 * includes variables name : name of student
 * and id : id of student 
 */
public class Student extends Thread {
	String name;
	long id;
	/*
	 * Method Name: setNames
	 * sets name of student
	 */
	public void setNames(String name) {
		this.name = name;
	}
	/*
	 * Method Name: setId
	 * sets id of student
	 */
	protected void setId(long id) {
		this.id = id;
	}
	/*
	 * Method Name: getNames
	 * returns- name of student
	 */
	public String getNames() {
		return this.name;
	}
	/*
	 * Method Name: getId
	 * returns- id of student
	 */
	public long getId() {
		return this.id;
	}
	public static void main(String args[]) throws IOException {
		String name;
		String name2;
		long id;
		long id2;
		String threadName;
		String objectName;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		for(int i=0; i<10; i++)
		{
			objectName = "object"+i;
			Student objectName1 = new Student();
			objectName1.setName(objectName);
			System.out.println("Enter Name Of Student");
			name = br.readLine();
			objectName1.setNames(name);
			System.out.println("Enter Id of Student");
			id = Long.parseLong(br.readLine());
			objectName1.setId(id);
			
			threadName = "thread"+i;
			Thread threadName1 = new Thread(objectName1);
			threadName1.setName(threadName);
			threadName1.start();
		}
		for(int i=10; i<20; i++)
		{
			
			objectName = "object"+i;
			Student objectName2 = new Student();
			objectName2.setName(objectName);
			System.out.println("Enter Name Of Student");
			name2 = br.readLine();
			objectName2.setNames(name2);
			System.out.println("Enter Id of Student");
			id2 = Long.parseLong(br.readLine());
			objectName2.setId(id2);
			
			threadName = "thread"+i;
			Thread threadName2 = new Thread(objectName2);
			threadName2.setName(threadName);
			threadName2.start();
		}
	}
	public void run() {
		try {
			/*
			 * File StudentRecord.txt is created
			 * and result is set to file. 
			 */
		FileWriter file = new FileWriter("StudentRecord.txt",true);
		file.write(" \n Name of Student : "+this.getNames());
		file.write("  \n Id of Student : "+this.getId());
		System.out.println("Write Successful");
		file.close();
		} catch(IOException exception) {
			System.out.println(exception);
		}
	}
}
