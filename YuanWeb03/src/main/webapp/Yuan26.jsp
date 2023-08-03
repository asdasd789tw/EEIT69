<%@page import="tw.yuan.apis.Bike"%>
<%
	String x = request.getParameter("x");
	Bike b2 = (Bike)request.getAttribute("bike");
%>
I am Yuan26<br>
<%= x %>
<tr>
<%= b2 %>
