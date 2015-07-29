package com.rest.example.messanger.client.messangerClient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;



public class JSONParsing {
	public static void main(String args[]) throws IOException, JSONException{
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("JSON.txt"));
		String json;
		while((json = br.readLine()) != null){
			System.out.println(json);
		}
		String str="{\"name\": \"MANAN\",\"age\": 21 }";
		JSONObject obj = new JSONObject(str);
		String name = obj.getString("name");
		int age = obj.getInt("age");
		System.out.println("NAME : "+name+" Age : "+age);
	}
}
