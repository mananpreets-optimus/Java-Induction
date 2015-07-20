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
		String productName = request.getParameter("ProductType");
		String productType = request.getParameter("ProductName");
		String totalQuantity = request.getParameter("TotalQuantity");
		out.println(quantityEntered+" "+productName+" "+productType); 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			/*if(Integer.parseInt(quantityEntered) > Integer.parseInt(totalQuantity)){
				out.println("QUANTITY ENTERED MORE THAN AVAILABLE");
				out.println("\n <a href='Catalog' style='text-decoration:none'>GO BACK </a><br>");
				out.println("</body></html>");
			}*/
			
			con = Authentication.DatabaseConnectivity();
			stmt = con.createStatement();
			String sql="update Pant set Quantity = Quantity-1 WHERE Name='JOHN'";
			
			String sql1="update "+productType+" set Quantity = Quantity-1 WHERE Name = \'"+productName+"\'"; 
			stmt.executeUpdate(sql1);
			HttpSession session = request.getSession(false);
			if(session !=null){
				session.setAttribute(productType, quantityEntered);
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
