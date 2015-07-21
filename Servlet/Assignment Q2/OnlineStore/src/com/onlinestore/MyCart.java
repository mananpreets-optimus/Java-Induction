package com.onlinestore;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class MyCart
 */
@WebServlet("/MyCart")
public class MyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		Authentication a = new Authentication();
		Map<String,Integer> HashMapValues = new HashMap<String,Integer> ();
		HashMapValues = (Map<String, Integer>) session.getAttribute("Quantity");
		a.HashMapQuant = (Map<String, Integer>) session.getAttribute("Quantity");
		/*Map<String,Integer> HashMapValues = new HashMap<String,Integer> ();
		HashMapValues = (Map<String, Integer>) session.getAttribute("Quantity");*/
		for(Entry<String, Integer> hashNames: a.HashMapQuant.entrySet()) {
			out.println(".................\n");
			out.println("Quantity : "+hashNames.getValue()+" ProductName : "+hashNames.getKey());
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
