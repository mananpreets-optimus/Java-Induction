/*
 * Package Name: com.WriteRead
 */
package com.WriteRead;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * Class Name: ReadFromFile
 */
public class ReadFromFile {
	
	public static void main(String args[]) throws IOException{
		
		File folder = new File("bin/my");
		File[] listOfFiles = folder.listFiles();
		BufferedReader br = null;
		String urlParameters;
		    for (int i = 0; i < listOfFiles.length; i++) {
		    	/*
		    	 * All files are listed and read
		    	 */
		    	if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		        String sCurrentLine;
		        
				br = new BufferedReader(new FileReader(listOfFiles[i]));
	 
				while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(sCurrentLine);
				}
		        
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		    
	}
}
