<%@page import="tw.yuan.apis.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
	Object obj = session.getAttribute("member");
	Member member = (Member)obj;
	
	if(obj == null){
		//response.sendError(HttpServletResponse.SC_NOT_FOUND);
		response.sendRedirect("login.html");
		//sendRedirect 沒登入或登入過期(有設置setMaxInactiveInterval)就會轉址
	}
%>
<sql:setDataSource 
	driver="com.mysql.cj.jdbc.Driver" 
	url="jdbc:mysql://localhost/iii" 
	user="root" 
	password="root"
/>

<c:if test="${!empty param.delid }">
	<sql:update>
		DELETE FROM gift WHERE id = ?
		<sql:param>${param.delid }</sql:param>	
	</sql:update>
	
</c:if>
<sql:query var="rs">
	SELECT * FROM gift
</sql:query>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<script>
		function delAlert(name) {
			let isDel = confirm("真的要刪除 *" + name + "* 嗎?")
			return isDel
		}
	</script>
	<body>
		Welcome ${member.realname } 
		<hr>
		<a href="logout.jsp">Logout</a>
		<hr>
		<a href="addGift.jsp">New Gift</a>
		
		<table border="1" width=100%>
			<tr>
				<th>#</th>
				<th>Name</th>
				<th>Feature</th>
				<th>County</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
			<c:forEach items="${rs.rows }" var="row">
			<tr>
				<td width=5%>${row.id }</td>
				<td width=15%>${row.name }</td>
				<td>${row.feature }</td>
				<td>${row.county }</td>
				<td><a href="?delid=${row.id }" onclick="return delAlert(${row.name });">Del</a></td>
				<td><a href="?editGift.jsp?editid=${row.id }">Edit</a></td>
			</tr>
			</c:forEach>
		</table>
	</body>
	

</html>