/*
 * Package Name: com.optimus.RestWebAssignmentClient
 */
package com.optimus.RestWebAssignmentClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Servlet implementation class MenuController
 */
/*
 * Class Name: MenuController
 */
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MenuController() {
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Request parameters are recieved
		String type = request.getParameter("menu");
		/*
		 * Logger and configuration
		 */
		Logger logger = Logger.getLogger("MenuController");
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
		if(type.equals("getEmployeeDetails")){
			logger.info("Inside getEmployeeDetails");
				try{
					/*
					 * HttpURLConnection is opened.
					 */
					URL url = new URL("http://localhost:8080/RestWebAssignment/webapi/optimus/v1/employeeDetails");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					logger.info("HttpURLConnection is opened.");
					con.setRequestMethod("GET");
					con.setRequestProperty("content-type", "application/json");
					logger.info("Content type set to application/json");
					/*
					 * If response code is not equal to 200 then it displays Failed along with response code.  
					 */
					if(con.getResponseCode() != 200){
						System.out.println("Failed : "+ con.getResponseCode());
					}
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String output;
					StringBuffer string = new StringBuffer();
					while((output = br.readLine()) != null){
						System.out.println("56565656");
						System.out.println(output);
						string.append(output);
					}
					System.out.println("stringhhh"+string);
					logger.info("Response Recieved.");
					request.setAttribute("json", (string.toString()));
					  JSONArray jsonarray=new JSONArray(string.toString());
					  if(jsonarray.length()==0)
					  {
					   PrintWriter out = response.getWriter();
					   out.println("Try again");
					   //Redirect to Menu.jsp
					   RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Menu.jsp");
					   requestDispatcher.forward(request, response);
					  }
					  else{
						  //Redirect to displayEmployee.jsp
					  RequestDispatcher requestDispatcher = request.getRequestDispatcher("/displayEmployee.jsp");
					  requestDispatcher.forward(request, response);
					  }
					
		
					con.disconnect();
				}
				catch(MalformedURLException e){
					
				} catch (JSONException e) {
				
					e.printStackTrace();
				}
				
		}
		if(type.equals("addEmployee")){
			//Redirect to checkAdmin.jsp
			response.sendRedirect("checkAdmin.jsp");
		}
		if(type.equals("updateEmployee")){
			//Redirect to updateEmployee.jsp
			response.sendRedirect("updateEmployee.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
