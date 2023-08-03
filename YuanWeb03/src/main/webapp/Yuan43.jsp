<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b = (Integer)application.getAttribute("a");
	b++;
	application.setAttribute("a", b);
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<span>getAttribute拿出來的是物件，要轉型成Integer物件再給int接</span>
		<br>
		a= ${a }
		<br>
		<span>session存放在自己瀏覽器上，application是存放在網站上</span>
		<br>
	</body>
</html>