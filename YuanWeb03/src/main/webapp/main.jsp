<%@page import="tw.yuan.apis.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("member");

	if(obj instanceof Object){
		out.print("test11");	
	}
	
	if(obj instanceof String){
		out.print("test2");	
	}
	
	if(obj == null){
		response.sendError(HttpServletResponse.SC_NOT_FOUND);
		//response.sendRedirect("Yuan50.jsp");
		//sendRedirect 轉址
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Welcome ${member.realname }
	</body>
</html>