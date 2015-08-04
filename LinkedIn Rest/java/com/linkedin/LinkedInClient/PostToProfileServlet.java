/*
 * Package Name: com.linkedin.LinkedInClient
 */
package com.linkedin.LinkedInClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;


/**
 * Servlet implementation class PostToProfileServlet
 */
public class PostToProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostToProfileServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="https://api.linkedin.com/v1/people/~/shares?format=json&oauth2_access_token=AQU4DtBZ4YEyosMnnChJaZUTZR0alS5x7PLqE706rQaMnupDDMgBiGP2Sby_xVGk9s9clowNmAevUw8kBdk9uhjOdx6TMo39DLe5mG-JppUw-1dKJJjh4IHpA_hmKRfDk9uzjk4ap_NBOYEjPpZIgkir_sWpJF5QLVYS2HlkqLyM0RsGfmE";
		URL obj = new URL(url);
		PrintWriter out = response.getWriter();
		//Connection open
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		//Content Type : application/json 
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("x-li-format","json");
		//con.setRequestProperty("Authorization", "Bearer AQVLosXUmwMPXUHDeWHC9Rc03xp1F6hIR9XWNTZBJSuaZ6n-74MHPea5LfV3x9IyTuht5vVtuzSfZSPlZvRDfKfifWS4FzafiqSKhd0UOd4tqf_3-i2yqn_eKIcB_6txJ0ITuvI1bk3h92V0K5g6SKUsuiAF2t3I-UudlINI7zsQ9kOJolE");
		
		BufferedReader br = null;
		String urlParameters;
		String stringJson;
		/*br = new BufferedReader(stringJson);*/
		br = new BufferedReader(new FileReader("E:\\JavaWorkspace\\LinkedInClient\\JSONText.txt"));
		con.setDoOutput(true);
		String stringJson1="{\"comment\": \"Check out developer.linkedin.com!\",\"content\": {\"title\": \"LinkedIn Developers Resources\",\"description\": \"Leverage LinkedIn's APIs to maximize engagement\"},\"visibility\": {\"code\": \"anyone\"}  }";
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		/*while ((urlParameters = br.readLine()) != null) {
			System.out.println(urlParameters);
			wr.writeBytes(urlParameters);
		}*/
		wr.writeBytes(stringJson1);
		wr.flush();
		int responseCode = con.getResponseCode();
		System.out.println("Response Code: "+ responseCode);
		// Response is recieved.
		 
		BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input;
		StringBuffer response1 = new StringBuffer();
		while((input = read.readLine())!= null){
			response1.append(input);
		}
		//Closed
		read.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
