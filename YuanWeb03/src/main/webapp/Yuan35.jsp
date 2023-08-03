<%@page import="tw.yuan.apis.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Member member1 = new Member(4,"godtone","隱翅蟲","1987-8-7");
	request.setAttribute("member1", member1);
%>    
    
<jsp:useBean id="member" class="tw.yuan.apis.Member"></jsp:useBean>
<jsp:setProperty property="id" name="member" value="2"/>
<jsp:setProperty property="account" name="member" value="${param.account}"/>
<jsp:setProperty property="realname" name="member" value="${param.realname}"/>
<jsp:setProperty property="birthday" name="member" value="${param.birthday}"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Member:
		<jsp:getProperty property="id" name="member"/>
		<jsp:getProperty property="account" name="member"/>
		<jsp:getProperty property="realname" name="member"/>
		<jsp:getProperty property="birthday" name="member"/>
		<!-- 
		${param.account} 根據上一個表單的請求拿到數值
		 --> 
		<hr>
		Member: ${member.id } : ${member.account } : ${member.realname } : ${member.birthday }
		<h1>可以直接在html使用物件</h1>
		<hr> 
		Member: ${member1.id } : ${member1.account } : ${member1.realname } : ${member1.birthday }
		<h1>使用%JAVA創立的物件也可以呼叫，但要先setAttribute</h1>
	</body>
</html>