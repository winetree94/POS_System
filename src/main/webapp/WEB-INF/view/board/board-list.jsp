<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


	<style type="text/css">
		/*table{
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
		}*/

	</style>


<jsp:include page="../comm/header.jsp"/>
<%
	List<Service_Board_DTO> board_list = (List<Service_Board_DTO>)request.getAttribute("board_list");
%>
<div class="wrap">
<h4 class="text-center">게시판 목록</h4>

<table class="table w-75 p-3 mx-auto table-hover text-center">
	<thead class="thead-dark">
		<tr>
			<th scope="col">글번호</th>
			<th scope="col">작성자</th>
			<th scope="col">제목</th>
			<th scope="col">내용</th>
			<th scope="col">작성일</th>
			<th scope="col">조회수</th>
		</tr>
	</thead>
	<c:forEach items="${board_list}" var="dto">
		<tbody>
			<tr>
				<th scope="row">${dto.getBoard_seq()}</th>
				<td>${dto.getService_id()}</td>
				<td><a href="/board/${dto.board_seq}">${dto.getTitle()}</a></td>
				<td><a href="/board/${dto.board_seq}">${dto.getContent()}</a></td>
				<td><fmt:formatDate value="${dto.getRegdate()}" pattern="yyyy-MM-dd"/></td>
				<td>${dto.getReadcount()}</td>
			</tr>
		</tbody>
	</c:forEach>

</table>
</div>
<jsp:include page="../comm/footer.jsp"/>
