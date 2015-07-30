/*
 * Package Name: com.properties
 */
package com.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
/*
 * Class Name: ReadProperties
 */
public class ReadProperties {
	
	public static void main(String args[]) throws FileNotFoundException{
		
		Properties prop = new Properties();
		InputStream in = null;
		try{
		in = new FileInputStream("example.properties");
		
		//Properties file Loaded
		prop.load(in);
		
		//Print Specific element of specific
		System.out.println(prop.getProperty("Name"));
		System.out.println(prop.getProperty("Id"));
		System.out.println(prop.getProperty("Salary"));
		
		//Print all elements
		Enumeration<?> e = prop.propertyNames();
		while(e.hasMoreElements()){
			String key = (String) e.nextElement();
			String value = prop.getProperty(key);
			System.out.println("Key : "+ key+" Value : "+value);
		}
		
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
}
