package com.rest.example.messanger.client.messangerClient;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MessangerClientJson {
	public static void main(String args[]) throws ParseException{
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/RestExample/webapi/messages/post");
		String input="{\"id\":2,\"message\":\"Black\",\"author\":\"Fade\"}";
		
		JSONParser jp = new JSONParser();
		Object ob = jp.parse(input);
		JSONObject obj = new JSONObject(ob);
		
		webResource.setProperty("Content-type", "application/json");
		ClientResponse response = webResource.accept("application/json").post(ClientResponse.class,obj);
		System.out.println("Status Code:"+response.getStatus());
		String output = response.getEntity(String.class);
		System.out.println(output);
	}
}
