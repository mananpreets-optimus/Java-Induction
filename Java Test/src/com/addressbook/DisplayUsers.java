package com.addressbook;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



/**
 * Servlet implementation class DisplayUsers
 */
@WebServlet("/DisplayUsers")
public class DisplayUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO user = new UserDAO();
		PrintWriter out = response.getWriter();
		List<User> users = user.lisAllUsers();
		Document document = new Document();
		PdfWriter writer;
		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";
		//CSV file header
		final String FILE_HEADER = "FirstName,LastName,Address,Email";
		FileWriter fileWriter = null;
		try {
			
			writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\JavaWorkspace\\Display.pdf"));
			 document.open();
				                
			 for(Iterator iterator = users.iterator();iterator.hasNext();){
					User userDetails = (User) iterator.next();
					document.add(new Paragraph("\nFIRST_NAME: "+userDetails.getFirstName()));
					document.add(new Paragraph("LAST_NAME: "+userDetails.getLastName()));
					document.add(new Paragraph("Address: "+userDetails.getAddress()));
					document.add(new Paragraph("Email: "+userDetails.getEmail()));
					fileWriter = new FileWriter("E:\\JavaWorkspace\\abc.csv");

					//Write the CSV file header
					fileWriter.append(FILE_HEADER.toString());
					
					//Add a new line separator after the header
					fileWriter.append(NEW_LINE_SEPARATOR);
					fileWriter.append(userDetails.getFirstName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(userDetails.getLastName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(userDetails.getAddress());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(userDetails.getEmail());
					fileWriter.append(NEW_LINE_SEPARATOR);
					fileWriter.flush();
					fileWriter.close();
			 }
			 document.close();
		     writer.close();
			 RequestDispatcher rd=request.getRequestDispatcher("displayUsers.jsp");  
			 request.setAttribute("user", users);
			 rd.forward(request, response);
		        
		} catch (DocumentException e) {
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
