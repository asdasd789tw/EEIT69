
<%@page import="tw.yuan.apis.Member"%>
<%@page import="tw.yuan.apis.BCrypt"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String account = request.getParameter("account");
	String passwd = request.getParameter("passwd");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii","root","root");
	
	String sql = "SELECT * FROM member WHERE account = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, account);
	ResultSet rs = pstmt.executeQuery();
	
	
	if(rs.next()){
		String hashPasswd = rs.getString("password");
		if(BCrypt.checkpw(passwd, hashPasswd)){
			Member member = new Member(rs.getInt("id"),rs.getString("account"),rs.getString("cname"),null);
			session.setAttribute("member", member);
			session.setMaxInactiveInterval(600);
			response.sendRedirect("main.jsp");
		}else{
			session.invalidate();
			response.sendRedirect("login.html");
		}
	}else{
		session.invalidate();
		response.sendRedirect("login.html");
	}
	
%>