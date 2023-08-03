<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		Hello, World
		<hr>
		<span>%內的敘述會交由後端執行</span>
		<br>
		<span>out是隱含物件，不用特別new出來</span> 
		<hr>
		<%
			out.println("Hello, World2");
		%>
		<hr>
		<%
			int lottery = (int)(Math.random()*49+1);
			out.println(lottery);
		%>
		<hr>
		<%
			out.println(lottery);
		%>
		<hr>
		<%= lottery	%>
		
	</body>
</html>