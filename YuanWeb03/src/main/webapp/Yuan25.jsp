<%@page import="tw.yuan.apis.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Bike b1 = new Bike("yuan");
	request.setAttribute("bike", b1);
	b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Test Yuan25</h1>
		<h1>JSP的源頭是Servlet</h1>
		<h1>jsp:param標籤的name value相當於key&value</h1>
		<h1>可以被request給get到(getParameter)</h1>
		<hr>
		<%@ include file="Yuan26.jsp" %>
		<hr>
		<jsp:include page="Yuan27.jsp">
			<jsp:param value="100" name="x"/>
			<jsp:param value="33" name="y"/>
			<jsp:param value="50" name="z"/>
		</jsp:include>
	</body>
</html>