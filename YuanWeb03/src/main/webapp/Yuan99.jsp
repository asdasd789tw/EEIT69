<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int ROW , COL , START;
	String row = request.getParameter("row");
	String col = request.getParameter("col");
	String start = request.getParameter("start");
	String[] color = {"YELLOW","RED","GREEN","BLUE","PINK"};
	try{
		ROW = Integer.parseInt(row);
		COL = Integer.parseInt(col);
		START = Integer.parseInt(start);
	}catch(Exception e){
		ROW = 2 ;
		COL = 4 ;
		START = 2;
	}
			
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		Row: <input type="number" name="row" value="<%=ROW %>">
		Column: <input type="number" name="col" value="<%=COL %>">
		Start: <input type="number" name="start" value="<%=START %>">
		<input type="submit" value="change">	
	</form>


	<table border="1" width="100%">
		<%
		for (int k = 0; k < ROW; k++) {
			out.println("<tr>");
			for (int j = START; j <= (START + COL -1); j++) {
				int j1 = j + k * COL;
				out.println(String.format("<td style='background-color:%s'>",color[(j+k)%5]));
				for (int i = 1; i <= 9; i++) {
					int r = j1 * i;
					out.println(String.format("%d x %d = %d<br>", j1, i, r));
				}
				out.println("</td>");
			}
			out.println("</tr>");
		}
		%>
	</table>
	
	<br>
	<tr>
	<br>
		
	<table border="1" width="100%">		
		<%
		for (int k = 0; k < 2; k++) {
			%>
			<tr>
			<%
			for (int j = 2; j <= 5; j++) {
				int j1 = j + 4 * k;
				%>
				<td>
				<%
				for (int i = 1; i <= 9; i++) {					
					int r = j1 * i;
					out.println(String.format("%d x %d = %d<br>", j1, i, r));
				}
				%>
				</td>
				<%
			}
			%>
			</tr>
			<%
		}
		%>
	</table>
	-------------------↑莫名其妙的寫法，可以但不要-------------------
</body>
</html>