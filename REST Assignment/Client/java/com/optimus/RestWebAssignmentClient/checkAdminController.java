package com.optimus.RestWebAssignmentClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class checkAdminController
 */
public class checkAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String sendCheckToService(String jsonText) throws IOException{
    	String string="";
		BufferedReader br = null;
		/*
		 * URL of web service is set
		 */
		String url ="http://localhost:8080/RestWebAssignment/webapi/optimus/v1/isAdmin";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		String urlParameters;
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(jsonText);
		wr.flush();
		int responseCode = con.getResponseCode();
		System.out.println("Response Code: "+ responseCode);
		/*
		 * Response is recieved.
		 */
		BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input;
		StringBuffer response = new StringBuffer();
		while((input = rd.readLine())!= null){
			response.append(input);
		}
		rd.close();
		System.out.println(response.toString());
		return response.toString();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		 JSONObject obj=new JSONObject();
		  try {
			obj.put("userName",userName);
			 obj.put("password",password);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		 
		  String jsonText = JSONValue.toJSONString(obj);
		  System.out.println(jsonText);
		  String responseText = sendCheckToService(jsonText);
		 // if(jsonText){
		  try {
			JSONObject objResponse = new JSONObject(responseText);
			String message = objResponse.getString("message");
			if(message.equals("success")){
				System.out.println("hhhhhhh");
				response.sendRedirect("addEmployee.jsp");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 // }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
