<%@page import="com.example.demo.model.Marks"%>
<%@page import="java.util.List"%>
<%@page import="com.example.demo.model.Progress"%>
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
	try{
		Progress progress = (Progress) request.getAttribute("progress");
		List<Marks> marklist = (List) request.getAttribute("markList");
		if(progress == null){
			%>
				Result not found!!!
			<%
		}
		else{
			for(Marks mark : marklist){
				%>
					<h3>subject Id: <%= mark.getSubId() %></h3>
					<h3>marks: <%=mark.getMarks() %></h3>
					<br/>
				<%
			}
			%>
				<hr/>
				<h2>Progress report</h2>
				<h3>Total: <%=progress.getTot() %></h3>
				<h3>Average: <%=progress.getAvg() %></h3>
				<h3>Position: <%=progress.getPosition() %></h3>
			<%
		}
	}
	catch(Exception e){
		%>
			 Some error or Results not found!!!
		<%
		System.out.println("Error in jsp: " + e);
	}
%>
</body>
</html>