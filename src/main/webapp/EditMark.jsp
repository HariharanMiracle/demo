<%@page import="com.example.demo.model.Progress"%>
<%@page import="com.example.demo.model.Marks"%>
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
<%
	List<Marks> mlist = (List) request.getAttribute("markList");
	Progress progress = (Progress) request.getAttribute("progress");
	String[] mid = {"mid1", "mid2", "mid3", "mid4", "mid5"};
	String[] subjectStr = {"subid1", "subid2", "subid3", "subid4", "subid5"};
	String[] marksStr = {"marks1", "marks2", "marks3", "marks4", "marks5"};
	int i = 0;
%>
	<form method = "post" action = "editMarksAndProgress" onsubmit="return validate()">
		<label>Student Id</label>
		<input type = "text" name = "sid" id = "sid" value="<%=progress.getSid() %>" readonly/><br/>
		
		<hr/>
		
		<%
			for(Marks m : mlist){
				%>
					<input type="text" id = "<%=mid[i] %>" name = "<%=mid[i] %>" value = "<%=m.getMid() %>" hidden/>
					<label>Subject <%=i+1 %> Id</label>
					<input type = "text" name = "<%=subjectStr[i] %>" id = "<%=subjectStr[i] %>" value="<%=m.getSubId() %>"/><br/>
					<label>Marks <%=i+1 %></label>
					<input type = "text" name = "<%=marksStr[i] %>" id = "<%=marksStr[i] %>" value="<%=m.getMarks() %>"/><br/>
				<%
				i++;
			}
		%>
		
		<!--  
		<label>Subject 1 Id</label>
		<input type = "text" name = "subid1" id = "subid1"/><br/>
		<label>Marks 1</label>
		<input type = "text" name = "marks1" id = "marks1"/><br/>

		<label>Subject 2 Id</label>
		<input type = "text" name = "subid2" id = "subid2"/><br/>
		<label>Marks 2</label>
		<input type = "text" name = "marks2" id = "marks2"/><br/>

		<label>Subject 3 Id</label>
		<input type = "text" name = "subid3" id = "subid3"/><br/>
		<label>Marks 3</label>
		<input type = "text" name = "marks3" id = "marks3"/><br/>

		<label>Subject 4 Id</label>
		<input type = "text" name = "subid4" id = "subid4"/><br/>
		<label>Marks 4</label>
		<input type = "text" name = "marks4" id = "marks4"/><br/>

		<label>Subject 5 Id</label>
		<input type = "text" name = "subid5" id = "subid5"/><br/>
		<label>Marks 5</label>
		<input type = "text" name = "marks5" id = "marks5"/><br/>
		-->

		<hr/>

		<label>Total</label>
		<input type="text" id = "pid" name = "pid" value = "<%=progress.getPid() %>" hidden/>
		<input type = "text" name = "total" id = "total" value = "<%=progress.getTot() %>" readonly/><br/>
		<label>Average</label>
		<input type = "text" name = "avg" id = "avg" readonly value = "<%=progress.getAvg() %>"/><br/>

		<input type = "button" value = "Calculate Total Mark and Average" onclick="calculate()"/>&nbsp;
		<input type = "submit" name = "submit" value = "Submit" onclick = "calculate()"/>
</form>

<script type="text/javascript">
	function calculate() {
		 var mark1 = document.getElementById("marks1").value;
		 var imark1 = parseInt(mark1, 10);
		 var mark2 = document.getElementById("marks2").value;
		 var imark2 = parseInt(mark2, 10);
		 var mark3 = document.getElementById("marks3").value;
		 var imark3 = parseInt(mark3, 10);
		 var mark4 = document.getElementById("marks4").value;
		 var imark4 = parseInt(mark4, 10);
		 var mark5 = document.getElementById("marks5").value;
		 var imark5 = parseInt(mark5, 10);
	 
	 	if(((mark1 == null) || (mark1 == "")) && ((mark2 == null) || (mark2 == "")) && ((mark3 == null) || (mark3 == "")) && ((mark4 == null) || (mark4 == "")) && ((mark5 == null) || (mark5 == ""))){
	 		alert("Please type all the marks!!!");
	 	}
	 	else{
			 var total = imark1 + imark2 + imark3 + imark4 + imark5;
			 var avg = total / 5.0;
			 document.getElementById("total").value = total;
			 document.getElementById("avg").value = avg;
	 	}
	}
	
	function validate(){
		var letters = /^[0-9a-zA-Z]+$/;
		var numbers = /^[-+]?[0-9]+\.[0-9]+$/;	
	
		var mark1 = document.getElementById("marks1").value;
		var subid1 = document.getElementById("subid1").value;
		var mark2 = document.getElementById("marks2").value;
		var subid2 = document.getElementById("subid2").value;
		var mark3 = document.getElementById("marks3").value;
		var subid3 = document.getElementById("subid3").value;
		var mark4 = document.getElementById("marks4").value;
		var subid4 = document.getElementById("subid4").value;
		var mark5 = document.getElementById("marks5").value;
		var subid5 = document.getElementById("subid5").value;
		
		if(mark1.match(numbers)){
			if(mark2.match(numbers)){
				if(mark3.match(numbers)){
					if(mark4.match(numbers)){
						if(mark5.match(numbers)){
							if(subid1.match(letters)){
								if(subid2.match(letters)){
									if(subid3.match(letters)){
										if(subid4.match(letters)){
											if(subid5.match(letters)){
												return true;
											}
											else{
												alert("subject Id should be an an alpha numeric value");
												return false;
											}
										}
										else{
											alert("subject Id should be an an alpha numeric value");
											return false;
										}
									}
									else{
										alert("subject Id should be an an alpha numeric value");
										return false;
									}
								}
								else{
									alert("subject Id should be an an alpha numeric value");
									return false;
								}
							}
							else{
								alert("subject Id should be an an alpha numeric value");
								return false;
							}
						}
						else{
							alert("Marks should be an numeric value");
							return false;
						}
					}
					else{
						alert("Marks should be an numeric value");
						return false;
					}
				}
				else{
					alert("Marks should be an numeric value");
					return false;
				}
			}
			else{
				alert("Marks should be an numeric value");
				return false;
			}
		}
		else{
			alert("Marks should be an numeric value");
			return false;
		}
 			
	}
</script>
</body>
</html>