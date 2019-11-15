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
	String id = request.getParameter("id");
%>
View the mark
<br/>

<form method = "post" action = "viewMarksAndProgress" onsubmit="return validate()">
	Student Id: <input type = "text" name = "sid" id = "sid" value = "<%=id %>" readonly/>
	<br/>
	Year: <input type = "text" id = "year" name = "year" placeholder = "2019"/>
	<br/>
	Semester: <select name = "semester" id = "semester">
			  	<option value = "1">1</option>
			  	<option value = "2">2</option>
			  </select>
	<br/>
	<input type = "submit" name = "submit" value = "Submit"/>
</form>

 <!-- <a href = "one">Click</a>  -->
</body>
</html>

<script>
	function validate(){
		
		var numbers = /[0-9]+$/;	
		
		var year = document.getElementById("year").value;
		if(year.match(numbers)){
			return true;
		}
		else{
			alert("year should be an an integer value");
			return false;
		}
	}
</script>