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

import org.json.JSONObject;
/*
 * Class Name: AccessToken
 */
public class AccessToken {
	/*
	 * Method Name: getAccessToken
	 * parameter code 
	 * returns access token
	 */
	public String getAccessToken(String code) throws IOException{
		String url ="https://www.linkedin.com/uas/oauth2/accessToken?grant_type=authorization_code&code="+code+"&redirect_uri=https://localhost:8443/LinkedInClient/CallbackPage.jsp&client_id=75cay7b03aipuk&client_secret=OJSIyKHwamkifgkJ";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input;
		StringBuffer response = new StringBuffer();
		while((input = read.readLine())!= null){
			response.append(input);
		}
		read.close();
		System.out.println(response.toString());
		return response.toString();
		
	}
	
}
