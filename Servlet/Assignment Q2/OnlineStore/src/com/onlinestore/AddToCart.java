package com.onlinestore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddToCart
 * In this servlet class a particular product is shown and 
 * user can enter value corresponding to product in text field
 * and can add product to cart. 
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productType = request.getParameter("ProductType");
		String productName = request.getParameter("ProductName");
		PrintWriter out = response.getWriter();
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType+"<html><body>");
		out.println("TYPE : "+productType);
		out.println("\n Product Name :"+productName);
		out.println();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			/*
			 * 	Connection to database
			 */
			con = Authentication.DatabaseConnectivity();
			stmt = con.createStatement();
			String sql="SELECT * FROM "+productType+" WHERE Name = \'"+productName+"\'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				out.println("<form action =\"ToCart\" method=\"GET\">");
				out.println("Quantity : "+rs.getInt("Quantity"));
				out.println("Price :"+rs.getInt("Price"));
				out.println("<input type=\"hidden\" name=\"TotalQuantity\" value=\" "+rs.getInt("Quantity")+" \">");
				out.println("<input type=\"hidden\" name=\"ProductType\" value=\""+productType+"\">");
				out.println("<input type=\"hidden\" name=\"ProductName\" value=\""+productName+"\">");
				out.println("Enter Quantity: "+"<input type=\"text\" name=\"quantity\">");
				out.println("<input type=\"Submit\" value=\"AddToCart\"/></form>");	
			}
			
			out.println("</body></html>");
		} catch(Exception e) {
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
