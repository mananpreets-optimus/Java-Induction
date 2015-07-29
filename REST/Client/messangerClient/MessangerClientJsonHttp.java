/*
 * Package Name : com.rest.example.messanger.client.messangerClient
 */
package com.rest.example.messanger.client.messangerClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
/*
 * Class Name : MessangerClientJsonHttp
 */
public class MessangerClientJsonHttp {
	
	public static void main(String args[]) throws IOException{
		
		String string="";
		BufferedReader br = null;
		/*
		 * URL of web service is set
		 */
		String url ="http://localhost:8080/RestExample/webapi/messages/yes";
		URL obj = new URL(url);
		/*
		 * Http Connection is opened and headers are set
		 */
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		String urlParameters;
		br = new BufferedReader(new FileReader("JSONText.txt"));
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
