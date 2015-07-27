package com.web;

import javax.jws.WebService;
/*
 * Class Name: HelloWorldImpl implements HelloWorld interface 
 */
@WebService(endpointInterface = "com.web.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public int helloWorld(int param1 ,int param2) {
		return (param1 + param2);
	}

}
