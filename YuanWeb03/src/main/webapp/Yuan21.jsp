<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%
	String name = request.getParameter("name");
	if(name == null) {
		name="world";
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h1>Test</h1><br>
		<span>可以在開頭先儲存變數供後續使用</span>
		<span>編譯錯誤一樣可以執行，但是會出現500錯誤</span>
		<hr>
		<div>Welcome, <%= name %></div>	
	</body>
</html>