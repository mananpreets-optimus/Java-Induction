package com.onlinestore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ToCart
 */
@WebServlet("/ToCart")
public class ToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType+"<html><body>");
		String quantityEntered = request.getParameter("quantity");
		String productType = request.getParameter("ProductType");
		String productName = request.getParameter("ProductName");
		String totalQuantity = request.getParameter("TotalQuantity");
		out.println(quantityEntered+" . "+productName+" . "+productType); 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			/*
			 * Connection to database
			 */
			con = Authentication.DatabaseConnectivity();
			stmt = con.createStatement();
			String sql="update Pant set Quantity = Quantity+2 WHERE Name='JOHN'";
			System.out.println(productName);
			String sql1="update "+productType+" set Quantity = Quantity-"+quantityEntered+" WHERE Name='"+productName+"'"; 
			System.out.println(sql1);
			stmt.executeUpdate(sql1);
			HttpSession session = request.getSession(false);
			if(session !=null){
				Authentication a = new Authentication();
				a.HashMapQuant = (Map<String, Integer>) session.getAttribute("Quantity");
				a.HashMapQuant.put(productName, Integer.parseInt(quantityEntered));
				for(Entry<String, Integer> hashNames: a.HashMapQuant.entrySet()) {
				
					out.print(hashNames.getKey());
					out.print(productType);
					if((hashNames.getKey()).equals(productType)) {
						
						a.HashMapQuant.put(productType,a.HashMapQuant.get(productType)+ Integer.parseInt(quantityEntered));
						session.setAttribute("Quantity", a.HashMapQuant);
						out.println(Integer.parseInt("SUCCESSFULLY ADDED TO CART: QUANTITY = "+quantityEntered));
						
					}
					
				}
			
			}
			
		}catch(Exception e){
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
