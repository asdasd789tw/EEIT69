<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/iii"
	user="root"
	password="root"
/>
<sql:query var="rs" >
	SELECT * FROM foods
</sql:query>

<c:set var="rpp">10</c:set>
<c:set var="test">${param.page}</c:set>
<c:if test="${param.page==null || param.page<=0}"><c:set var="test">1</c:set></c:if>
<c:if test="${Math.round(Math.ceil(rs.rowCount/10))<test}"><c:set var="test">${Math.round(Math.ceil(rs.rowCount/10))}</c:set></c:if>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<a href="Yuan48.jsp?page=${test-1 }">上一頁</a> | <a href="Yuan48.jsp?page=${test+1 }">下一頁</a>
		<table border="1" width="100%">
			<tr>
				<th>#</th>
				<th>name</th>
				<th>addr</th>
				<th>tel</th>
				<th>city</th>
				<th>town</th>
				<th>count</th>
			</tr>
			
			
			<c:forEach items="${rs.rows }" var="row" varStatus="status">	
				<c:if test="${status.count <= rpp * test && status.count > rpp * (test-1)}">
					<tr>
						<td>${row.id }</td>
						<td>${row.name }</td>
						<td>${row.addr }</td>
						<td>${row.tel }</td>
						<td>${row.city }</td>
						<td>${row.town }</td>
						<td>${status.count }</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		${test }
		${param.page==null }
		${Math.round(8/3)}
		${Math.round(Math.floor(8/3))}
		${Math.ceil(8/3)}
		
	</body>
</html>