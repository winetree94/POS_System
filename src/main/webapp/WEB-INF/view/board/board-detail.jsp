<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="com.pos.system.dto.Service_File_DTO" %>
<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../comm/header.jsp"/>


<%
    //Service_Board_DTO board_detail = request.getAttribute("board_list");
    Object obj = request.getAttribute("board_detail");
    Object objF = request.getAttribute("fileDto");
    Service_Board_DTO board_detail = (Service_Board_DTO) obj;
    Service_File_DTO fileDto = (Service_File_DTO) objF;

    Service_Account_DTO user = (Service_Account_DTO) session.getAttribute("user");
    String service_id = "";
    if (user != null) {
        service_id = user.getService_id();
    }

%>
<div class="jumbotron jumbotron-fluid">
    <div class="container">


        <h2 class="display-4 text-center">게시판</h2>
        <hr class="my-4">

    </div>
</div>
<div class="container">
    <table class="table mx-auto text-center">
        <thead class="thead-dark">
        <tr>

            <th scope="col">작성자</th>
            <th scope="col">제목</th>
            <th scope="col">내용</th>
            <th scope="col">작성일</th>
            <th scope="col">조회수</th>
            <th scope="col">파일</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${board_detail.getService_id()}</td>
            <td>${board_detail.getTitle()}</td>
            <td>${board_detail.getContent()}</td>
            <td><fmt:formatDate value="${board_detail.getRegdate()}" pattern="yyyy-MM-dd"/></td>
            <td>${board_detail.getReadcount()}</td>
            <td><%
                if (fileDto != null) {
            %>
                <%=fileDto.getOrigin_fname()%>
                <form action="./${board_detail.board_seq}/download" method="POST" id="fileChk"
                      enctype="multipart/form-data">
                    <%--<input type="button" onclick="editFile()" value="파일수정">--%>
                    <%--<input type="button" onclick="delFile()" value="파일삭제">--%>
                    <input type="submit" value="다운로드">
                </form>
                <script type="text/javascript">

                    <%--function editFile(){--%>
                    <%--var editF = document.querySelector("#fileChk")--%>
                    <%--editF.action =  "./${board_detail.board_seq}/edit/file";--%>
                    <%--editF.method = ""--%>
                    <%--}--%>

                </script>

                <%
                } else {
                %>
                첨부파일 없음
                <%
                    }
                %>
            </td>
        </tr>
        </tbody>
    </table>

    <div class="container text-right">
        <form action="" method="" id="boardChk">
            <% if (service_id.equalsIgnoreCase(board_detail.getService_id())) {%>
            <input class="btn btn-primary" type="button" onclick="edit()" value="수정"/>
            <input class="btn btn-primary" type="button" onclick="del()" value="삭제"/>
            <%}%>

            <input class="btn btn-primary" type="button" onclick="back()" value="뒤로가기">


        </form>
    </div>
</div>

<script type="text/javascript">

    function edit() {

        // var edit = document.forms[0];
        var edit = document.querySelector("#boardChk");
        edit.action = "./${board_detail.board_seq}/edit";
        edit.method = "get";
        edit.submit();


    }

    function del() {
        var del = document.querySelector("#boardChk");
        del.action = "./${board_detail.board_seq}/delete";
        del.method = "post";
        del.submit();
        //alert("del");

    }

    function back() {
        // history.back();
        location.href = document.referrer;
    }


</script>
<jsp:include page="../comm/footer.jsp"/>