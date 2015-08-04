/*
 * Package Name: com.linkedin.LinkedInClient
 */
package com.linkedin.LinkedInClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/*
 * Class Name: ViewProfileClass
 */
public class ViewProfileClass {
	/*
	 * Method Name: viewProfile
	 * parameter token string
	 */
	public void viewProfile(String tokenAccess) throws IOException{
		String url ="https://api.linkedin.com/v1/people/~?oaurth2_access_token=AQV0WwJuXvWHsWDK3zm0SrUN4fxXyyok2kICk3y3MQ5WSJCu0D8nTsP1QhaZK4lRep5l3GRUDF5AO7dmboLVbdcuH4tBAFTEhvnh_PLRI_YPE62GUIHH4kqkmVDqNw6WrIsJnhFHugpnAxk395-WeT5A1Gcm1OBfx7DhjZGBpuU15eeZEv0"+tokenAccess;
		URL obj = new URL(url);
		//Connection open
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/xml");
		BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input;
		StringBuffer response1 = new StringBuffer();
		while((input = read.readLine())!= null){
			response1.append(input);
		}
		//Closed
		read.close();
		System.out.println(response1.toString());
	
	}
}
