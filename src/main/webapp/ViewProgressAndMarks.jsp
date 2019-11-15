<%@page import="com.example.demo.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
View Student's Progress and Marks
<% 
	List<Student> students = (List) request.getAttribute("students");
	for(Student student : students) {
		%>
			<h5>Sname: <%=student.getSname() %></h5>
			<a href = "ViewMarks.jsp?id=<%=student.getSid() %>">View Marks</a>
			<hr/>
		<%
	}
%>
</body>
</html>