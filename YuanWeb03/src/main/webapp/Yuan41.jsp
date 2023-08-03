<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] var1 = {"Yuan","OK","III"};
	pageContext.setAttribute("var1", var1);
	
	String[] var2 = {"Yuan2","OK2","III2"};
	request.setAttribute("var1", var2);
	
	String[] var3 = {"Yuan3","OK3","III3"};
	session.setAttribute("var1", var3);
	
	String[] var4 = {"Yuan4","OK4","III4"};
	application.setAttribute("var1", var4);
	
	LinkedList<String> list = new LinkedList<>();
	list.add("Yuan5");list.add("ok5");list.add("III5");
	pageContext.setAttribute("list", list);
	
	HashMap<String,String> map = new HashMap<>();
	map.put("k1","v1");map.put("k2","v2");map.put("k3","v3");
	pageContext.setAttribute("map", map);
	
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		var1[0]: ${var1[0] }<br>
		var1[0]: ${pageScope.var1[0] }<br>
		var1[0]: ${requestScope.var1[0] }<br>
		var1[0]: ${sessionScope.var1[0] }<br>
		var1[0]: ${applicationScope.var1[0] }<br>
		<hr>
		list.get(0) : ${list[0] }<br>
		list.get(i) : ${list[param.i] }<br>
		<hr>
		map.get("k1") : ${map["k1"] }<br>
		map.get("k2") : ${map.k2 }<br>
		<hr>
		${10+3 }<br>
		${param.x+param.y}<br>
		${param.x==param.y}<br>
		<hr>
		<span>名稱相同時，會由小到大優先取用，
		pageContext < request < session < application
		</span>
		<br>
		<span>
		session是用在登入登出，F5沒辦法清除掉之前設定的屬性，要清cookie
		</span>
	</body>
</html>