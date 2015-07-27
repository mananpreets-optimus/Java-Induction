/*
 * Package Name: com.webservices.client
 */
package com.webservices.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Class Name : HelloWorldClient
 */
public class HelloWorldClient {
	public static void main(String args[]) throws IOException{
		BufferedReader br = null;
		String url ="http://localhost:8282/sum?wsdl";
		URL obj = new URL(url);
		/*
		 * Http Connection is opened.
		 */
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "text/xml");
		String urlParameters;
		/*
		 * Soap Request is kept in SoapRequest.txt
		 * and this request is read from SoapRequest.txt file
		 */
		br = new BufferedReader(new FileReader("SoapRequest.txt"));
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		while ((urlParameters = br.readLine()) != null) {
			System.out.println(urlParameters);
			wr.writeBytes(urlParameters);
		}
	
		wr.flush();
		wr.close();
		
		
		int responseCode = con.getResponseCode();
		System.out.println("Response Code: "+ responseCode);
		/*
		 * Response is recieved.
		 */
		BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input;
		StringBuffer response = new StringBuffer();
		while((input = rd.readLine())!= null){
			response.append(input);
		}
		rd.close();
		System.out.println(response.toString());
	}
}
