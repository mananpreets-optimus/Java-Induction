/*
 * Package Name: com.WriteRead
 */
package com.WriteRead;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
/*
 * Class Name: WriteToFileLimit
 */
public class WriteToFileLimit {
	
	public static void main(String args[]) throws IOException{
	
		//Writing data to multiple files based on size limit
		String fileName = "abc";
		long fileSize = 1000;
		int i = 2;
		//New File is created
		File fout = new File("bin/my/"+fileName+String.valueOf(1)+".txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		OutputStreamWriter osw = new OutputStreamWriter(fos);
	 
		for (int i1 = 0; i1 < 200; i1++) {
			
			osw.write("sopeuuhingjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjshkauuueuggaeuiaeuiaeuiaeuiaeuiaeuiaeui");
			osw.flush();
			System.out.println(fout.length());
			if(fout.length() > fileSize){
				System.out.println("ABC");
				osw.close();
				fos.close();
				//New file is created
				fout = new File("bin/my/"+fileName+String.valueOf(i++)+".txt");
				fos = new FileOutputStream(fout);
				osw = new OutputStreamWriter(fos);
			}
			
		}
	 
		osw.close();

		
	}
}
