/*
 * Package Name:com.web
 */
package com.web;

import javax.jws.WebMethod;
import javax.jws.WebService;
/*
 * Interface Name: HelloWorld 
 */
@WebService
public interface HelloWorld {
	@WebMethod
	public int helloWorld(int param1,int param2);

}
