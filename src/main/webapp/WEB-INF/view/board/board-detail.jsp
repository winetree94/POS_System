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

    System.out.println(user+"과아아아아아아연!!");
    String service_id = "";
    String service_type = "";
    if (user != null) {
        service_id = user.getService_id();
        service_type = user.getService_type();
    }

%>

<div class="jumbotron jumbotron-fluid" style="margin-top:56px">
    <div class="container">

        <h2 class="display-4 text-center">게시판</h2>
        <hr class="my-4">

    </div>
</div>
<div class="container">
    <div class="input-group">
        <input type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)">
        <div class="input-group-append">
            <span class="input-group-text">$</span>
            <span class="input-group-text">0.00</span>
        </div>
    </div>


    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">작성자</span>
        </div>
        <div class="form-control" aria-label="With textarea">${board_detail.getService_id()}</div>
    </div>


    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">제목</span>
        </div>
        <div class="form-control" aria-label="With textarea">${board_detail.getTitle()}</div>
    </div>


    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">내용</span>
        </div>
        <div class="form-control" aria-label="With textarea">${board_detail.getContent()}</div>
    </div>

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
                <form action="./${board_detail.board_seq}/download" method="POST" class="fileChk"
                      enctype="multipart/form-data">
                    <%--<input type="button" onclick="editFile()" value="파일수정">--%>
                    <%--<input type="button" onclick="delFile()" value="파일삭제">--%>
                    <input type="submit" value="다운로드">
                </form>

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
        <form action="" method="" class="boardChk">
            <% if (service_id.equalsIgnoreCase(board_detail.getService_id())) {%>
            <input class="btn btn-primary" type="button" onclick="edit()" value="수정"/>
            <input class="btn btn-primary" type="button" onclick="del()" value="삭제"/>
            <%}%>

            <input class="btn btn-primary" type="button" onclick="back()" value="뒤로가기">


        </form>
    </div>
</div>


<% if (service_type.equalsIgnoreCase("M")) {%>
<script type="text/javascript">
    var form_action = "./${board_detail.board_seq}/reply"; // form 의 action 위치
    var form_class = ""; // form 의 클래스 선언
    var form_method = "post"; // form request 방식
    var form_enctype = "multipart/form-data"; // form 의 enctype 방식
    var use_file = true; // 파일 업로드 기능 사용 여부
    var title;

    console.log("jaei");


</script>
<div></div>
<jsp:include page="../util/editor.jsp"/>


<%}%>


<%--<div class="container">--%>

<%--<div class="row">--%>
<%--<div class="col">--%>
<%--<h1 class="display-2">--%>
<%--${board_detail.getTitle()}sadfsfdaasfdafdsfasdafsdasdfafssfdsfdasfd--%>
<%--</h1>--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="row">--%>
<%--${board_detail.getContent()}--%>
<%--</div>--%>


<%--<div class="row">--%>


<%--</div>--%>


<%--</div>--%>

<script type="text/javascript">

    function edit() {

        // var edit = document.forms[0];
        var edit = document.querySelector(".boardChk");
        edit.action = "./${board_detail.board_seq}/edit";
        edit.method = "get";
        edit.submit();


    }

    function del() {
        var del = document.querySelector(".boardChk");
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