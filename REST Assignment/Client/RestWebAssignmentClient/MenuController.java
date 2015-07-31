/*
 * Package Name: com.optimus.RestWebAssignmentClient
 */
package com.optimus.RestWebAssignmentClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

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
		String type = request.getParameter("menu");
		if(type.equals("getEmployeeDetails")){
			
				try{
					/*
					 * HttpURLConnection is opened.
					 */
					URL url = new URL("http://localhost:8080/RestWebAssignment/webapi/optimus/v1/employeeDetails");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					con.setRequestProperty("content-type", "application/XML");
					/*
					 * If response code is not equal to 200 then it displays Failed along with response code.  
					 */
					if(con.getResponseCode() != 200){
						System.out.println("Failed : "+ con.getResponseCode());
					}
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String output;
					while((output = br.readLine()) != null){
						System.out.println(output);
					}
					con.disconnect();
				}
				catch(MalformedURLException e){
					
				}
				
		}
		if(type.equals("addEmployee")){
			response.sendRedirect("addEmployee.jsp");
		}
		if(type.equals("updateEmployee")){
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