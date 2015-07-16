/*
 * Package Name: assignment
 */
package assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CountServlet
 */
@WebServlet("/CountServlet")
/*
 * Class Name: CountServlet
 * extends HttpServlet
 */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private int count;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	count = 0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		  HttpSession session= request.getSession(true);
		  Cookie name = new Cookie("name",request.getParameter("name"));
		  Cookie cookie=null;
		  Cookie[] cookies = null;
		  
		  /*cookies = request.getCookies();
		  if(cookies != null) {
			  for(int i=0 ; i<cookies.length ; i++){
				  if(cookies[i].getName().equals(request.getParameter("name"))) {
					  Cookie name = new Cookie("name",request.getParameter("name"));
			  }
			 
			  }
		  }*/
		  Map<Integer,String> map = new HashMap<Integer,String> ();
		  name.setMaxAge(60*60*24);
		  response.addCookie(name);
		  response.setContentType("text/html");
		  int visitCount=0;
		  String visitCountKey= new String("visitCount");
		  String userIdKey= new String("userId");
		  String userId=new String("ABCD");
		  if(session.isNew()) {
			  session.setAttribute(userIdKey,userId);
		  }
		  else {
			  visitCount = (int) session.getAttribute(visitCountKey);
			  visitCount = visitCount + 1;
			  userId = (String) session.getAttribute(userIdKey);
			  }
		  session.setAttribute(visitCountKey, visitCount);
		  
		  PrintWriter out = response.getWriter();
		  String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		  out.println(docType+"<html><h1>"+request.getParameter("name")+" Count = "+visitCount+"</h1></html>");
		  
		  
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
