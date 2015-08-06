<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Menu</title>
</head>
<body>
<form action="DisplayUsers" method="GET">
<input type="Submit" value="GetAllUsers" />
</form>
<br>
<br>
<form action="SearchUsers.jsp" method="GET">
<input type="Submit" value="Search" />
</form>
<br>
<br>
<form action="AddUsers.jsp" method="GET">
<input type="Submit" value="addUsers" />
</form>
<br>
<br>
<form action="RemoveUsers.jsp" method="GET">
<input type="Submit" value="removeUsers" />
</form>
<br>
<form action="DownloadDisplayUsers" method="GET">
<input type="Submit" value="DownloadDisplayUsers" />
</form>
<br>
</body>
</html>