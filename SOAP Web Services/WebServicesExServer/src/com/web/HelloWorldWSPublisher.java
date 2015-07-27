/*
 * Package Name: com.web
 */
package com.web;

import javax.xml.ws.Endpoint;
/*
 * Class Name: HelloWorldPublisher
 * publishes the endpoint of HelloWorldImpl
 */
public class HelloWorldWSPublisher {
	public static void main(String args[]) {
	
		Endpoint.publish("http://localhost:8282/sum", new HelloWorldImpl());
		System.out.println("End");
	}
}
