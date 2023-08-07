<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("lottery");
	if(obj == null){
		response.sendError(HttpServletResponse.SC_NOT_FOUND);
		//response.sendRedirect("Yuan50.jsp");
		//sendRedirect 轉址
	}else{
		int lottery = (Integer)session.getAttribute("lottery");
		pageContext.setAttribute("lottery", lottery);
	}	
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		I am yuan51 <hr>
		${lottery }
		
		<a href="logout.jsp">Logout</a>
	</body>
</html>