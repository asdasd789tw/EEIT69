
<%@page import="tw.yuan.apis.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.yuan.apis.YuanUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	//pageContext.setAttribute("x", 10);
	Member test = YuanUtils.createMember();
	request.setAttribute("test", test);
%>
<c:set var="x" value="10"></c:set>
<c:set var="x" value="100" scope="request"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		x= ${x }<br>
		<span>↑page  ↓request</span><br>
		x= ${requestScope.x }<br>
		<%= "Hello, World"%><br>
		<c:out value="Hello, World"></c:out><br>
		x = <c:out value="${x }"></c:out><br>
		i = <c:out value="${param.i }" default="no value"></c:out>
		<hr>
		<jsp:useBean id="member" class="tw.yuan.apis.Member"></jsp:useBean>
		<jsp:setProperty property="id" name="member" value="3"/>
		<jsp:setProperty property="account" name="member" value="Yuan"/>
		<jsp:setProperty property="realname" name="member" value="Yuan123"/>
		<jsp:setProperty property="birthday" name="member" value="1999-9-9"/>
		
		${member.id } : ${member.account } : ${member.realname } : ${member.birthday }
		<br>
		${member }
		<hr>
		<c:remove var="member"/> 
		remove : ${member }
		<hr>
		<c:set var="yuan">${YuanUtils.createMember() }</c:set>
		${yuan }
		${test }
	</body>
</html>