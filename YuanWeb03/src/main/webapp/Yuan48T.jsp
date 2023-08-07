<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.yuan.apis.*" %>
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

<c:set var="rpp">7</c:set>
<c:set var="pages">
${rs.rowCount % rpp == 0 ? rs.rowCount / rpp : (Math.round((rs.rowCount - (rs.rowCount % rpp))/ rpp + 1))}
</c:set>
<c:set var="page">${param.page== null ? 1 : param.page }</c:set>
<c:set var="prev">${YuanUtils.prevPage(page) }</c:set>
<c:set var="next">${YuanUtils.nextPage(page,pages) }</c:set>
<c:set var="start">${(page - 1 )*rpp }</c:set>

<sql:query var="rs2">
SELECT * FROM foods LIMIT ${start },${rpp }
</sql:query>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		總筆數: ${rs.rowCount }<br> 
		目前頁數/總頁數: ${page } / ${pages }<br>
		<a href="?page=${prev }">上一頁</a> | <a href="?page=${next }">下一頁</a>
		<table border="1" width="100%">
			<tr>
				<th>#</th>
				<th>name</th>
				<th>addr</th>
				<th>tel</th>
				<th>city</th>
				<th>town</th>
			</tr>
			
			
			<c:forEach items="${rs2.rows }" var="row" varStatus="status">	
					<tr>
						<td>${row.id }</td>
						<td>${row.name }</td>
						<td>${row.addr }</td>
						<td>${row.tel }</td>
						<td>${row.city }</td>
						<td>${row.town }</td>
					</tr>
			</c:forEach>
		</table>
		
		<br>		
		${param.page==null }
		${Math.round(8/3)}
		${Math.round(Math.floor(8/3))}
		${Math.ceil(8/3)}
		
	</body>
</html>