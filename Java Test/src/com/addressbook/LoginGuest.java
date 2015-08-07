package com.addressbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginGuest
 */
@WebServlet("/LoginGuest")
public class LoginGuest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDAO user = new UserDAO();
		try{
		int check = user.isUser(email,password);
		if(check==0){
			response.sendRedirect("Login.jsp");
		}
		else{
			response.sendRedirect("guest.jsp");
		}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
