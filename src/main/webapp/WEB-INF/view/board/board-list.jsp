<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:include page="../comm/header.jsp"/>


<%
    List<Service_Board_DTO> board_list = (List<Service_Board_DTO>) request.getAttribute("board_list");
    Service_Account_DTO user = (Service_Account_DTO) session.getAttribute("user");
    String service_id = "";
    if (user != null) {
        service_id = user.getService_id();
    }

%>
<script type="text/javascript">
    // document.querySelector("ul:eq(1) li").removeClass





</script>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
    <h4 class="display-4 text-center">게시판</h4>
        <hr class="my-4">
        <p class="lead small text-right">Q&A 게시판입니다. 문의사항이 있다면 로그인 후 질문해주세요.</p>
        <% if (user != null) {%>
        <div class="container text-right">
        <a href="board/new" class="btn btn-primary">새글작성</a>
        </div>
        <%}%>
    </div>
</div>
<div class="container">


    <%--<table class="table w-75 p-3 mx-auto table-hover text-center">--%>
    <table class="table mx-auto table-hover text-center">
        <%--<form action="/board/new" method="get" class="text-right">--%>
        <%--<input type="submit" value="새글작성" class="btn btn-primary">--%>
        <%--</form>--%>

        <thead class="thead-dark">

        <tr>
            <th scope="col">글번호</th>
            <th scope="col">작성자</th>
            <th scope="col">제목</th>
            <th scope="col">작성일</th>
            <th scope="col">조회수</th>
        </tr>
        </thead>

        <tbody>
        <c:choose>
            <c:when test="${empty board_list}">
                <tr>
                    <th colspan="5">작성된 글이 없습니다</th>
                </tr>
            </c:when>
        <c:otherwise>


            <c:forEach items="${board_list}" var="dto" varStatus="vs">
                    <tr>
                        <th id="board_seq" scope="row">${vs.count}</th>
                        <td>${dto.getService_id()}</td>
                        <td><a href="/board/${dto.board_seq}">${dto.getTitle()}</a></td>
                        <td><fmt:formatDate value="${dto.getRegdate()}" pattern="yyyy-MM-dd"/></td>
                        <td>${dto.getReadcount()}</td>
                    </tr>
                </tbody>
                </c:forEach>
            </c:otherwise>
        </c:choose>

    </table>
</div>
<jsp:include page="../comm/footer.jsp"/>
