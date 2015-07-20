package com.onlinestore;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Authentication
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * 
     * 
     * @param user
     * @param password
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
   
    public static Connection DatabaseConnectivity() throws SQLException,ClassNotFoundException  {
    	
    		Connection connection = null;
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		String dbURL =  "jdbc:sqlserver://localhost:1433;databaseName=Online;user=sa;password=optimus@123";
    		System.out.println("aaaaaaaa");
    		connection = DriverManager.getConnection(dbURL);
    		System.out.println("bbbbbbbbbbbb");
    		return connection;
    		
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userNameKey = new String("user");
		String user = new String(request.getParameter("name"));
		String passKey = new String("password");
		String password = new String(request.getParameter("password"));
		Map<String,Integer> HashMapQuant = new HashMap<String,Integer> ();
		HashMapQuant.put("Pens", 0);
		HashMapQuant.put("Mobile", 0);
		HashMapQuant.put("Pant", 0);
		HashMapQuant.put("Shirt", 0);
		
	
		//Connection con = null;
		//Statement stmt = null;
		//ResultSet rs = null;
		try {
			Connection con = Authentication.DatabaseConnectivity();
			Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery("select * from Login where name='"+user+"'and password='"+password+"'");
    		//System.out.println("ABC");
    		if(rs.next()) {
    			//System.out.println("1");
    			HttpSession session = request.getSession();
    			session.setAttribute("User", user);
    			session.setAttribute("Quantity",HashMapQuant);
    			/*HttpSession session = null;*/
    			/*session.setAttribute("user", user);
    			session.setAttribute("password", password);*/
    			response.sendRedirect("Catalog");
    			
    		}
    		else {
    			//System.out.println("1");
    			response.sendRedirect("Login.jsp");
    		}
    		con.close();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
