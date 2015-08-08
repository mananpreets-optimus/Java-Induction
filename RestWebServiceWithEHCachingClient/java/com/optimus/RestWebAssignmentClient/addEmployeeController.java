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

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class addEmployeeController
 */
public class addEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*
     * Method Name: sendRequestToService
     * parameter jsonText string
     * Connection with the  web service
     */
    public void sendRequestToService(String jsonText) throws IOException{
    	String string="";
		BufferedReader br = null;
		Logger logger = Logger.getLogger("addEmployeeController");
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
		/*
		 * URL of web service is set
		 */
		String url ="http://http://localhost:8080/RestWsEHCaching/webapi/optimus/v1/addEmployee";
		URL obj = new URL(url);
		logger.info("Connection opened");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		logger.info("Content type set to application/json");
		String urlParameters;
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(jsonText);
		wr.flush();
		logger.info("Request to service sent.");
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
		logger.info("Response from service recieved");
		rd.close();
    }

	/*
	 * Request parameters are recieved and JSONObject is created and
	 * sendRequestToService method is called.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Request parameters are recieved
		String empName = request.getParameter("empName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String telephone = request.getParameter("telephone");
		
		  //New JSONObject created.
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
		  /*
		   * redirected to Menu.jsp 
		   */
		  response.sendRedirect("Menu.jsp");
	}

}
