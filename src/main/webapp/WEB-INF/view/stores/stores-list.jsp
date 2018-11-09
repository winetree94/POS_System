<%@ page import="java.util.List" %>
<%@ page import="com.pos.system.dto.Service_Store_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
</head>
<body>
<%
	List<Service_Store_DTO> stores_list = (List<Service_Store_DTO>)request.getAttribute("stores_list");
%>
<h1>store list</h1>

<% for (int i = 0; i < stores_list.size(); i++) { %>
	<li><%=stores_list.get(i)%></li>
<% } %>

</body>
</html>