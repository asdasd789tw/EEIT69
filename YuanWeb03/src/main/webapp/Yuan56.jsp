<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<tags:text1 />
		<h1><tags:text2 /></h1>
		<hr>
		<tags:text3 />
		<hr>
		<table border="1" width="100%">
			<tr>
				<th>Name</th>
				<th>Price</th>			
			</tr>
			<tags:text5 name="Item1" price="100" />
			<tags:text5 name="Item2" price="200" />
			<tags:text5 name="Item3" price="300" />
			<tags:text5 name="Item4" price="400" />
			<tags:text5 name="Item5" price="500" />
		
		</table>
		
	</body>
</html>