<%@page import="tw.yuan.apis.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member member1 = new Member(1,"yuan","yuan123","1998-05-09");
%>
<jsp:useBean id="member2" class="tw.yuan.apis.Member"></jsp:useBean>
<jsp:setProperty property="id" name="member2" value="2"/>
<jsp:setProperty property="account" name="member2" value="chu"/>
<jsp:setProperty property="realname" name="member2" value="chu123"/>
<jsp:setProperty property="birthday" name="member2" value="2000-1-1"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Member1:
		<%= member1.getId()%> : <%= member1.getAccount()%>
		<hr>
		Member2:
		<%= member2.getId()%> : <%= member2.getAccount()%>
		<hr>
		Member2 V2:
		<jsp:getProperty property="id" name="member2"/>
		<jsp:getProperty property="account" name="member2"/>
		<hr>
		<!-- 
		Member2 V1:
		<jsp:getProperty property="id" name="member1"/>
		<jsp:getProperty property="account" name="member1"/>
		沒辦法get
		 -->
	</body>
</html>