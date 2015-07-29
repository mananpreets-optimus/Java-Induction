/*
 * Package Name: com.rest.example.messanger.client.messangerClient
 */
package com.rest.example.messanger.client.messangerClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
/*
 * Class Name: MessangerClientJersey
 * Client of Rest Web service using Jersey
 */
public class MessangerClientJersey {
	
	public static void main(String args[]){
		/*
		 * URL of web service is set
		 */
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/RestExample/webapi/messages/get");
		/*
		 * Content-Type: application/xml
		 */
		ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
		System.out.println("Status Code:"+response.getStatus());
		String output = response.getEntity(String.class);
		System.out.println(output);
	}
}
