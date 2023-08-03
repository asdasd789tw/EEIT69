<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.yuan.apis.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Math.random() => <%=Math.random() %>
		<hr>
		Math.random()el => ${Math.random()}
		<hr>
		sayYa => ${YuanUtils.sayYa() }
		<hr>
		sayYa,Yuan => ${YuanUtils.sayYa("Yuan") }
		<hr>
		sayYa,param => ${YuanUtils.sayYa("param.name") }
		
	</body>
</html>