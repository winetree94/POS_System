<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


	<style type="text/css">
		table{
			width:600px;
			border-collapse: collapse;
			text-align : center;
			align-content: center;
			margin-left: auto;
			margin-right: auto;
		}
		.content{
			color: hotpink;
		}

		#table{
			text-align: center;
			align-content: center;
			width: 1200px;
			margin-left: auto;
			margin-right: auto;
		}

	</style>


<jsp:include page="../comm/header.jsp"/>
<%
	List<Service_Board_DTO> board_list = (List<Service_Board_DTO>)request.getAttribute("board_list");
%>
<h2>게시판 목록</h2>

<div id="table">
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
			<td><a class="content" href="/board/${dto.board_seq}">${dto.getContent()}</a></td>
			<td><fmt:formatDate value="${dto.getRegdate()}" pattern="yyyy-MM-dd"/></td>
			<td>${dto.getReadcount()}</td>
		</tr>
	</c:forEach>

</table>
</div>
<jsp:include page="../comm/footer.jsp"/>
