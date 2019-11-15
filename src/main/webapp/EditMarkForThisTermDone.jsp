<%@page import="com.example.demo.model.Marks"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Marks m = (Marks) request.getAttribute("mark");
	if(m.getMid() == 0){
		out.println("Sorry unexpected error...");
		%><a href = "index.jsp">Click here</a><%
	}
	else{
		out.println("Marks And Progress Card Edited...");
		%><a href = "index.jsp">Click here</a><%
	}
%>
</body>
</html>