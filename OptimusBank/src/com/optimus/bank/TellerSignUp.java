package com.optimus.bank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class TellerSignUp
 */
@WebServlet("/TellerSignUp")
public class TellerSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TellerSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerName = request.getParameter("customerName");
		String gender = request.getParameter("gender");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pin = request.getParameter("pin");
		String telephoneNo = request.getParameter("telephoneNo");
		String fax = request.getParameter("fax");
		String email = request.getParameter("email");
		
		try{
		CustomerDAO customer = new CustomerDAO();
		Integer customerID101 = customer.addNewCustomer(customerName, gender, dateOfBirth, address, city, state, pin, telephoneNo, fax, email);
		if(customerID101 != null){
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
		}
		System.out.println("Registered");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//response.sendRedirect("CreateNewAccount.jsp");
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
