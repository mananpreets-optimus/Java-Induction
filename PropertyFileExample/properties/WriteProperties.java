/*
 * Package Name: com.properties
 */
package com.properties;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;
import java.io.FileOutputStream;
/*
 * Class Name: WriteProperties
 */
public class WriteProperties {
	
	public static void main(String args[]) throws IOException{
		
		// Properties object is created
		Properties defaultProperty = new Properties();
		InputStream in = new FileInputStream("defaultProp.properties"); 
		
		//Default Properties file Loaded
		defaultProperty.load(in);
		Properties property = new Properties(defaultProperty);
		OutputStream out = null;
		String name;
		int salary;
		int id;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Name:");
		name = br.readLine();
		System.out.println("Enter Salary:");
		salary = Integer.parseInt(br.readLine());
		System.out.println("Enter id:");
		id = Integer.parseInt(br.readLine());
		try{
			out = new FileOutputStream("example.properties");
			
			//Properties of property file is set
			property.setProperty("Name", name);
			property.setProperty("Salary", String.valueOf(salary));
			property.setProperty("Id", String.valueOf(id));
			//property file is stored
			property.store(out, "Hello "+name);
			property.load(in);
			System.out.println(out);
		}catch(Exception e){
			e.printStackTrace();
		}
		out.close();
		in.close();
	}
}
