<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//session.setAttribute("lottery", null);
	//單筆資料清除
	
	
	session.invalidate();
	response.sendRedirect("login.html");
	//全部資料清除
%>