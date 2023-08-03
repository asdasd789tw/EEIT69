<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		${paramValues.habby[0] }
		${paramValues.habby[1] }
		${paramValues.habby[2] }
		${paramValues.habby[3] }
		${paramValues.habby[4] }
		${paramValues.habby[5] }
		<hr>
		Method: <%= request.getMethod() %> <br>
		<span>用JAVA % 呼叫Method的寫法</span><br>
		<hr>	
		Method: ${pageContext.request.method } <br>
		<span>用el 呼叫Method的寫法</span><br>
		<span>pageContext層級比request高，可以透過pageContext取得</span>
		<span>並get request內的Method屬性</span>
		<hr>
		IP: <%=request.getRemoteAddr() %><br>
		<span>↑java　  ↓EL</span><br>
		IP: ${pageContext.request.remoteAddr }<br>
		<hr>
		Locale: <%=request.getLocale() %><br>
		<span>↑java　  ↓EL</span><br>
		Locale: ${pageContext.request.locale }<br>
		<hr>
		Language:<%= request.getLocale().getDisplayLanguage() %><br>
		<span>↑java　  ↓EL</span><br>
		Language:${pageContext.request.locale.displayLanguage }<br>
		<hr>
		
	</body>
</html>