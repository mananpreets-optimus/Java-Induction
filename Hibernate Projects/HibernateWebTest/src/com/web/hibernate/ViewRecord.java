/*
 * Package Name: com.web.hibernate
 */
package com.web.hibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewRecord
 */
@WebServlet("/ViewRecord")
public class ViewRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List users=null;
		PrintWriter out = response.getWriter();
		try{
			UserDAO user = new UserDAO();
			users = user.listAllUsers();
		}catch(Exception exception){
			exception.printStackTrace();
		}
		for(Iterator iterator = users.iterator();iterator.hasNext();){
			UserDetails userDetails = (UserDetails) iterator.next();
			out.println("USER_NAME: "+userDetails.getUserName());
			out.println("USER_ID: "+userDetails.getId());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
