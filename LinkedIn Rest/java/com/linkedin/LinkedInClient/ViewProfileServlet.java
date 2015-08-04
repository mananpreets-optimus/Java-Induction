/*
 * Package Name: com.linkedin.LinkedInClient
 */
package com.linkedin.LinkedInClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class ViewProfileServlet
 */
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="https://api.linkedin.com/v1/people/~?format=json&oauth2_access_token=AQWX-NFr9LGoJaFrDdtkQBc5ZbH7LavGZY_dlBJZjCnz02foIeIDVNRpT_t-5fyPgmf3spkGZ-YXZBoOO8C1Y-p6chrxnStfsTvE-kXeBJYhrmogEUouepLXdyGc8SXhmU2EUAcD1EoG81Dk23XsOCALxl0ScDYn3bFJ0Sx9l1Urg1LZzg8";
		URL obj = new URL(url);
		PrintWriter out = response.getWriter();
		//Connection opened
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		//Content Type
		con.setRequestProperty("Content-Type", "application/json");
		BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input;
		StringBuffer response1 = new StringBuffer();
		while((input = read.readLine())!= null){
			response1.append(input);
		}
		//Closed
		read.close();
		out.println(response1.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
