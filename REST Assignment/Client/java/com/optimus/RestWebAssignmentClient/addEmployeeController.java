/*
 * Package Name: com.optimus.RestWebAssignmentClient
 */
package com.optimus.RestWebAssignmentClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class addEmployeeController
 */
public class addEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /*
     * Connection with the  web service
     */
    public void sendRequestToService(String jsonText) throws IOException{
    	String string="";
		BufferedReader br = null;
		/*
		 * URL of web service is set
		 */
		String url ="http://localhost:8080/RestWebAssignment/webapi/optimus/v1/addEmployee";
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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empName = request.getParameter("empName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String telephone = request.getParameter("telephone");
		
		  //JSONObject a = new JSONObject();
		  JSONObject obj=new JSONObject();
		  try {
			obj.put("empName",empName);
			 obj.put("gender",gender);
			  obj.put("address",address);
			  obj.put("city",city);
			  obj.put("state",state);
			  obj.put("telephone",telephone);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		 
		  String jsonText = JSONValue.toJSONString(obj);
		  System.out.println(jsonText);
		  sendRequestToService(jsonText);
		  //response.sendRedirect(arg0);
		 // return jsonText;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
