/*
 * Package Name: com.optimus.RestWebAssignmentClient
 */
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
 * Servlet implementation class updateEmployeeController
 */
/*
 * Class Name: updateEmployeeController
 */
public class updateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateEmployeeController() {
        super();
        
    }
    /*
     * Class Name: sendUpdateRequestToService
     * parameter jsonText string
     */
    public void sendUpdateRequestToService(String jsonText) throws IOException{
    	String string="";
		BufferedReader br = null;
		/*
		 * Logger and configuration
		 */
		Logger logger = Logger.getLogger("updateEmployeeController");
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
		/*
		 * URL of web service is set
		 */
		String url ="http://localhost:8080/RestWebAssignment/webapi/optimus/v1/updateEmployee";
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
		    System.out.println("File: " + ((FileAppender)app).getFile());
		  }
		}
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
		//Request Parameters are recieved.
		String id = request.getParameter("id");
		int empID = Integer.valueOf(id);
		String empName = request.getParameter("empName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String telephone = request.getParameter("telephone");
		//New JSONObject created.
		  JSONObject obj=new JSONObject();
		  try {
			  obj.put("id", empID);
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
		  System.out.println(jsonText+"HELLO");
		  //Method sendUpdateRequestToService is called
		  sendUpdateRequestToService(jsonText);
		  //Redirected to Menu.jsp
		  response.sendRedirect("Menu.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
