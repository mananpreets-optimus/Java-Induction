<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<form action="updateEmployeeController" method="GET">
Employee Id of Employee whose details you want to change: <input type="text" name="id" />
<br>
<br>
Enter new updated details of Employee
<br>
Name : <input type="text" name="empName">
<br>
Gender :
<br>
<input type="radio" name="gender" value="M" checked>Male
<br>
<input type="radio" name="gender" value="F">Female
<br>
Address : <input type="text" name="address">
<br>
City : <input type="text" name="city">
<br>
State : <input type="text" name="state">
<br>
Telephone No : <input type="text" name="telephone">
<br>
<input type="Submit" value="Submit" />
</form>
</body>
</html>