<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.addressbook.User" %>
    <%@ page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DISPLAYS USERS</title>
</head>
<body>
<% List<User> users = (List<User>) request.getAttribute("user");
for(Iterator iterator = users.iterator();iterator.hasNext();){
	User userDetails = (User) iterator.next();%>
	
    <u>First Name</u> : <%=userDetails.getFirstName()%><br>
	<u>Last Name</u> : <%=userDetails.getLastName()%><br>
	<u>Address</u> : <%=userDetails.getAddress()%><br>
	<u>Email</u> : <%=userDetails.getEmail()%><br><br><br>
	
<%} %>
</body>
</html>