package com.rest.example.messanger.client.messangerClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MessageClientPost {
	public static void main(String args[]) throws IOException{
		BufferedReader br = null;
		String url ="http://localhost:8080/RestExample/webapi/messages/po";
		URL obj = new URL(url);
		/*
		 * Http Connection is opened.
		 */
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "text/html");
		String urlParameters;
		br = new BufferedReader(new FileReader("a.txt"));
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		while ((urlParameters = br.readLine()) != null) {
			System.out.println(urlParameters);
			wr.writeBytes(urlParameters);
		}
		wr.flush();
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
