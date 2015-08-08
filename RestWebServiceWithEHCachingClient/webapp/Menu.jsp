<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
<form action="MenuController" method="GET">
<input type="radio" name="menu" value="getEmployeeDetails" checked>Get Employees Details
<br>
<input type="radio" name="menu" value="getParticularEmployee" checked>Particlular Employee Details
<br>
<input type="radio" name="menu" value="addEmployee">Add Employee
<br>
<input type="radio" name="menu" value="updateEmployee" checked>Update Employees
<br>
<input type="Submit" value="Submit" />
</form> 
</body>
</html>