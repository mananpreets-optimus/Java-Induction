<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
<form action="AddUsers" method="GET">
FirstName : <input type="text" name="firstName" />
<br>
LastName : <input type="text" name="lastName" />
<br>
Address : <input type="text" name="address" />
<br>
Email : <input type="text" name="email" />
<br>
Password : <input type="password" name="password">
<br>

<input type="Submit"  value="Submit" />
</body>
</html>