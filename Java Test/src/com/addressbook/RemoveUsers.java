package com.addressbook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveUsers
 */
@WebServlet("/RemoveUsers")
public class RemoveUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserDAO user = new UserDAO();
		PrintWriter out = response.getWriter();
		System.out.println(userId+Integer.parseInt(userId));
		user.deleteUser(Integer.parseInt(userId));
		response.sendRedirect("removedUser.jsp");
	}

}
