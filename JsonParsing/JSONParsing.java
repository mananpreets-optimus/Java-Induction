/*
 * Package Name: com.rest.example.messanger.client.messangerClient
 */
package com.rest.example.messanger.client.messangerClient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.glassfish.jersey.server.JSONP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 * Class Name: JSONParsing
 */
public class JSONParsing {
	
	
	public static void main(String args[]) throws IOException, JSONException{
		//Reading from file JSON.txt
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("JSON.txt"));
		String json;
		StringBuffer string = new StringBuffer();
		while((json = br.readLine()) != null){
			System.out.println(json);
			string.append(json);
		}
		JSONObject obj = new JSONObject(string.toString());

		JSONArray arr = obj.getJSONArray("phoneNumber");
		System.out.println(obj.getString("name"));
		for(int i=0;i<arr.length();i++){
			System.out.println(arr.getJSONObject(i).get("type"));
		}
		
		String s = ((JSONArray) obj.get("phoneNumber")).toString();
		JSONArray j=new JSONArray(s);
		System.out.println(j.toString());
		System.out.println((j.getJSONObject(0)).getString("type"));
	}
}
