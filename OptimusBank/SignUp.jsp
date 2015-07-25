<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Optimus Bank</title>
</head>
<body>
<form action="TellerSignUp" method="GET">
Customer Name : <input type="text" name="customerName" />
<br>
Gender : <input type="text" name="gender">
<br>
Date Of Birth :<input type="text" name="dateOfBirth" />
<br>
Address : <input type="text" name="address">
<br>
City : <input type="text" name="city">
<br>
State : <input type="text" name="state">
<br>
Pin : <input type="text" name="pin">
<br>
Telephone No : <input type="text" name="telephoneNo">
<br>
Fax : <input type="text" name="fax">
<br>
Email : <input type="text" name="email">
<br>
<input type="Submit" value="Submit" />
</form>
<a href="Login.jsp">
If Already Registered then LOGIN
</a>

</body>
</html>