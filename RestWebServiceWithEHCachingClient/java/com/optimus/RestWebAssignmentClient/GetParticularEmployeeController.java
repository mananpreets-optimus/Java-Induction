package com.optimus.RestWebAssignmentClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class GetParticularEmployeeController
 */
public class GetParticularEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	 /**
	 * @param jsonText
	 * @throws IOException
	 */
	public void sendDetailsRequestToService(String jsonText) throws IOException{
		 String string="";
			BufferedReader br = null;
			/*
			 * Logger and configuration
			 */
			Logger logger = Logger.getLogger("GetParticularEmployeeController");
			PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
			/*
			 * URL of web service is set
			 */
			String url ="http://localhost:8080/RestWsEHCaching/webapi/optimus/v1/employee";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			logger.info("Connection opened");
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			logger.info("Content type set to application/json");
			String urlParameters;
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(jsonText);
			wr.flush();
			/*
			 * Request is sent.
			 */
			logger.info("Request to service sent.");
			int responseCode = con.getResponseCode();
			System.out.println("Response Code: "+ responseCode);
			/*
			 * Response is recieved.
			 */
			BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String input;
			StringBuffer response = new StringBuffer();
			logger.info("Response from service recieved");
			  Enumeration e = Logger.getRootLogger().getAllAppenders();
			    while ( e.hasMoreElements() ){
			      Appender app = (Appender)e.nextElement();
			     if ( app instanceof FileAppender ){
			   
			  }
			}
			while((input = rd.readLine())!= null){
				response.append(input);
			}
			rd.close();
			System.out.println(response.toString());
	 }
	/*
	 * Parameters are recieved and JSONObject is created and 
	 * sendDetailsRequestToService method is called
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int empID = Integer.valueOf(id);
		//New JSONObject created.
		 JSONObject obj=new JSONObject();
		  try {
			  obj.put("id", empID);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		  String jsonText = JSONValue.toJSONString(obj);
		  //Method sendUpdateRequestToService is called
		  sendDetailsRequestToService(jsonText);
		  //Redirected to Menu.jsp
		  response.sendRedirect("Menu.jsp");
	}

	

}
