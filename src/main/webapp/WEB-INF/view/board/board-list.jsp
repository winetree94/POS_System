<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>

	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	
	<title>Document</title>

	<script type="text/javascript" src="./src/js/script.js"></script>
	<link rel="stylesheet" href="./src/css/style.css">

	<style type="text/css">
		table{
			width:600px;
			border-collapse: collapse;
			text-align : center;
		}
		
	</style>
</head>
<body>
<%
	List<Service_Board_DTO> board_list = (List<Service_Board_DTO>)request.getAttribute("board_list");
%>
<h1>게시판 목록</h1>

<table border="1">
	<tr>
		<td>글번호</td>
		<td>작성자</td>
		<td>제목</td>
		<td>내용</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
	<c:forEach items="${board_list}" var="dto">
		<tr>
			<td>${dto.getBoard_seq()}</td>
			<td>${dto.getService_id()}</td>
			<td>${dto.getTitle()}</td>
			<td>${dto.getContent()}</td>
			<td><fmt:formatDate value="${dto.getRegdate()}" pattern="yyyy-MM-dd"/></td>
			<td>${dto.getReadcount()}</td>
		</tr>
	</c:forEach>
	
</table>

</body>
</html>