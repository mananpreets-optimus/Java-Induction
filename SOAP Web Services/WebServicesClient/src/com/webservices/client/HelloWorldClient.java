/*
 * Package Name: com.webservices.client
 */
package com.webservices.client;

import com.webservices.HelloWorld;
import com.webservices.HelloWorldImplService;

/*
 * Class Name: HelloWorldClient
 * uses wsimport command.
 */
public class HelloWorldClient {
	public static void main(String args[]){
		HelloWorldImplService helloWorldService = new HelloWorldImplService();
		HelloWorld helloWorld = helloWorldService.getHelloWorldImplPort();
		System.out.println(helloWorld.helloWorld("Manan"));
		
	}
}
