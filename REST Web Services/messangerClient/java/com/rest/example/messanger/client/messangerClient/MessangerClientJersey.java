package com.rest.example.messanger.client.messangerClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MessangerClientJersey {
	public static void main(String args[]){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/messanger/webapi/messages");
		ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
		System.out.println("Status Code:"+response.getStatus());
		String output = response.getEntity(String.class);
		System.out.println(output);
	}
}
