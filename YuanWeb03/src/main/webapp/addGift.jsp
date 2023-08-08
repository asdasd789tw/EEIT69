<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%
	Object obj = session.getAttribute("member");
	
	if(obj == null){
		//response.sendError(HttpServletResponse.SC_NOT_FOUND);
		response.sendRedirect("login.html");
		//sendRedirect 沒登入或登入過期(有設置setMaxInactiveInterval)就會轉址
	}
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script type="text/javascript">
			function add() {
				$.get("addNewGift.jsp?" +
						"name="	+$('#name').val() +
						"&feature=" +$('#feature').val() +
						"&county=" +$('#county').val()
						,function(data,status){
							if(status == 'success'){
								console.log(data);//會傳回有的沒的換列符號
								console.log(data.trim());//會把有的沒的換列符號清除
								if(data.trim()=='OK'){
									location.href = "main.jsp";	
								}								
							}
				});
			}
		
		</script>
	</head>
	<body>
			Name: <input type="text" id="name"><br>
			Feature: <input type="text" id="feature"><br> 
			County: <input type="text" id="county"><br>
			<input type="button" value="Add" onclick="add()"><br>
		
		
	</body>
</html>