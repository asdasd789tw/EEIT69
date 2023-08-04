<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="tw.yuan.apis.*"  %>
<c:set var="score">${YuanUtils.createScore() }</c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Score: ${score }<hr>
		<c:if test="${score >=90 }">A</c:if>
		<c:if test="${score >=80 }">B</c:if>
		<c:if test="${score >=70 }">C</c:if>
		<c:if test="${score >=60 }">D</c:if>
		<c:if test="${score <60 }">Down</c:if>
		<h1>JSTL標籤庫taglib只有if 沒有else、elseif</h1>
		<hr>
		
		<c:choose>		
			<c:when test="${score >= 90 }">A</c:when>
			<c:when test="${score >= 80 }">B</c:when>
			<c:when test="${score >= 70 }">C</c:when>
			<c:when test="${score >= 60 }">D</c:when>
			<c:otherwise>E</c:otherwise>
		</c:choose>
		<h1>choose+when可以達到if else的需求</h1>
		<hr>
		
		<c:choose>
			<c:when test="${score >= 90 }">A</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${score >= 80 }">B</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${score >= 70 }">C</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${score >= 60 }">D</c:when>
									<c:otherwise>E</c:otherwise>
								</c:choose>								
							</c:otherwise>
						</c:choose>					
					</c:otherwise>
				</c:choose>				
			</c:otherwise>
		</c:choose>
	</body>
</html>