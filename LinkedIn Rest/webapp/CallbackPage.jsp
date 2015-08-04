<%@page import="com.linkedin.LinkedInClient.ViewProfileClass"%>
<%@page import="com.linkedin.LinkedInClient.AccessToken"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
PrintWriter outp = response.getWriter();
String code = request.getParameter("code");
outp.println(code);
AccessToken accessToken = new AccessToken();
String accessTokenString = accessToken.getAccessToken(code);
outp.println("Access Token in JSON: ");
outp.println(accessTokenString);
/* JSONObject obj = new JSONObject(accessTokenString);
String tokenAccess = obj.getString("access_token");
ViewProfileClass profile = new ViewProfileClass();
 String viewProfileString =  
profile.viewProfile(tokenAccess); */

%>
</body>
</html>