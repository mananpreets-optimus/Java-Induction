<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%if(null!=session.getAttribute("valid")) {%>
	please enter valid locations<%}
	session.setAttribute("valid", null); %>
<form action ="calculate" method='POST'>
<table>
	<tr>
		<td>Enter Source Location : </td>
		<td><input type='text' name='Source' required></td>
	</tr>
	<tr>
		<td>Enter Destination Location : </td>
		
		<td><input type='text' name='Destination' required></td>
	</tr>
	<tr>
		<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
	</tr>
	
</table>
</form>
</body>
</html>