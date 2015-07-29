/*
 * Package Name: com.rest.example.messanger.client.messangerClient
 */
package com.rest.example.messanger.client.messangerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/*
 * Class Name: MessangerClient
 * makes a httpConnection to Messanger web service url and 
 * sends a GET request and displays the output.
 */
public class MessangerClient {
	
	public static void main(String args[]) throws IOException{
	try{
		/*
		 * HttpURLConnection is opened.
		 */
		URL url = new URL("http://localhost:8080/RestExample/webapi/messages/get");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("content-type", "application/json");
		/*
		 * If response code is not equal to 200 then it displays Failed along with response code.  
		 */
		if(con.getResponseCode() != 200){
			System.out.println("Failed : "+ con.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String output;
		while((output = br.readLine()) != null){
			System.out.println(output);
		}
		con.disconnect();
	}
	catch(MalformedURLException e){
		
	}
	}
}

