<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello User</title>
</head>
<body>
	<p>
		<%
			if (null != request.getAttribute("response")) {
		%>
		The distance between
		<%=request.getAttribute("source")%>
		and
		<%=request.getAttribute("destination")%>
		is:-
	<%
		String travelInfo[] = (String[]) request.getAttribute("response");
	%>
	<B><%=travelInfo[0]%>km</B>
	</p>
	<p>
		The time taken to travel between
		<%=request.getAttribute("source")%>
		and
		<%=request.getAttribute("destination")%>
		is:-
	<B><%=Float.parseFloat(travelInfo[1]) / 3600%>hours</B>
	</p>
	<p>
		Time to travel with <b>traffic</b> between
		<%=request.getAttribute("source")%>
		and
		<%=request.getAttribute("destination")%>
		is:-
	<B><%=Float.parseFloat(travelInfo[2]) / 3600%>hours</B>
	</p>
	<%
		} else {
			session.setAttribute("valid", "Enter valid locations");

			response.sendRedirect("calculate.jsp");
		}
	%>
</body>
</html>