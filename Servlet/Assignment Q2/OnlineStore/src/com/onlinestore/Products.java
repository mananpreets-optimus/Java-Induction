package com.onlinestore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class Products
 * In this servlet all products with description of 
 * a particular type is displayed.
 */
@WebServlet("/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productType = request.getParameter("Category");
		PrintWriter out = response.getWriter();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println(productType);
		try {
				/*
				 * Connection to database
				 */
				con = Authentication.DatabaseConnectivity();
				stmt = con.createStatement();
	    		rs = stmt.executeQuery("SELECT * FROM "+productType);
	    		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	    		out.println(docType+"<html><body>");
	    		out.println("<form action =\"MyCart\" method=\"GET\">");
	    		out.println("<center><input type=\"Submit\" value=\"MyCart\" /></center></form>");
	    		
	    		while(rs.next()) {
	    			
	    			out.println(" NAME : ");
	    			out.println(rs.getString("Name"));
	    			out.println(" QUANTITY : ");
	    			out.println(rs.getString("Quantity"));
	    			out.println(" PRICE : ");
	    			out.println(rs.getString("Price"));
	    			out.println("........");
	    			out.println("\n <a href='AddToCart?ProductName="+rs.getString("Name")+"&ProductType="+productType+"' style='text-decoration:none'>ADD TO CART : "+rs.getString("Name")+"</a><br>");	
	    			
	    		}	
	    		out.println("</body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
