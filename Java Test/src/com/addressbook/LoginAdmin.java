package com.addressbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminName = request.getParameter("adminName");
		String password = request.getParameter("password");
		UserDAO user = new UserDAO();
		try{
		int check = user.isAdmin(adminName,password);
		if(check==0){
			response.sendRedirect("Login.jsp");
		}
		else{
			response.sendRedirect("admin.jsp");
		}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
