<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Properties" %>
    <%@ page import="java.io.FileInputStream" %>
    <%@ page import="java.io.InputStream" %>
    <%@ page import="java.io.PrintWriter" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Access Token</title>
<script type="text/javascript" >
function getAuthorized(responseType,clientId,redirectUri){
	var value = Math.floor((Math.random() * 1000000) + 1);
	//var url = "https://www.linkedin.com/uas/oauth2/authorization?response_type=code&client_id=75cay7b03aipuk&redirect_uri=https://localhost:8443/LinkedInClient/CallbackPage.jsp&state="+value+"&scope=r_basicprofile";
 	var url1 = "https://www.linkedin.com/uas/oauth2/authorization?response_type="+responseType+"&client_id="+clientId+"&redirect_uri="+redirectUri+"&state="+value+"&scope=r_basicprofile%20w_share";
    window.location.href = url1;
   
}
</script>
</head>
<body>
<% 
Properties prop = new Properties();
PrintWriter outp = response.getWriter();
InputStream in = new FileInputStream("E:\\JavaWorkspace\\LinkedInClient\\linkedin.properties");
prop.load(in);
String responseType = prop.getProperty("response_type");
String clientId = prop.getProperty("client_id");
String redirectUri = prop.getProperty("redirect_uri");
%>
<button onclick="getAuthorized('<%= responseType%>','<%= clientId%>','<%= redirectUri%>')">Get Access Token</button>
<br>
<form action ="ViewProfileServlet">
<input type="Submit" value="View Profile" />
</form>
<br>
<form action ="PostToProfileServlet">
<input type="Submit" value="Post in Profile" />

</form>
</body>
</html>