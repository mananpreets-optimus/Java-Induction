<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.json.JSONArray" %>
    <%@ page import="org.json.JSONException" %>
    <%@ page import="org.json.JSONObject" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
 <% JSONArray json=new JSONArray((String)(request.getAttribute("json")));%>
 <%!JSONObject object; %>
 <%int i=0; %>
 <%while(i<(json.length()))
   {  
    object=json.getJSONObject(i);%>
 Employee
 <%=i+1 %>:
 <br> Id:
 <%= object.getInt("id")%><br> EmployeeName:<%= object.getString("empName")%><br>

 <br>
 <%  i++;
    }%>
 <br>
 <a href="Menu.jsp">Home</a>

</body>
</html>