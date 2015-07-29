/*
 * Package Name: com.rest.example.messanger.client.messangerClient
 */
package com.rest.example.messanger.client.messangerClient;

import java.io.DataOutputStream;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
/*
 * Class Name : MessagerClientPostUsingJersey
 * Client of Rest Web service using Jersey
 */
public class MessagerClientPostUsingJersey {
	
	public static void main(String args[]){
		/*
		 * URL of web service is set
		 */
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/RestExample/webapi/messages/yes");
		String input = "{\"id\": 1,\"message\": \"REST Service\",\"author\": \"Manan\"}";
		/*
		 * Content-Type: application/json
		 */
		ClientResponse response = webResource.accept("application/json").post(ClientResponse.class,input);
		System.out.println("Status Code:"+response.getStatus());
		String output = response.getEntity(String.class);
		System.out.println(output);
	}
}
