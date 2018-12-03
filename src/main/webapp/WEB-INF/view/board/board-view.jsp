<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="com.pos.system.dto.Service_File_DTO" %>
<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="https://cdn.quilljs.com/1.2.2/quill.snow.css" rel="stylesheet">
<script src="https://cdn.quilljs.com/1.2.2/quill.js"></script>
<style type="text/css">
    /*.ql-toolbar{*/
    /*display:none;*/
    /*}*/
    /*.ql-editor{*/
    /*border-top: 1px solid #ccc;*/
    /*}*/
</style>
<script type="text/javascript">


</script>
<jsp:include page="../comm/header.jsp"/>
<%

    Service_Board_DTO board = new Service_Board_DTO();//빈객체

    Service_Account_DTO user = (Service_Account_DTO) session.getAttribute("user");//유저
//    String user_type = user.getService_type();

    Object objE = request.getAttribute("board_edit");
    Object objD = request.getAttribute("board_detail");
    Object objR = request.getAttribute("board_reply");

    Service_Board_DTO board_edit = (Service_Board_DTO) objE;
    Service_Board_DTO board_detail = (Service_Board_DTO) objD;
    Service_Board_DTO board_reply = (Service_Board_DTO) objR;

    Object objF = request.getAttribute("fileDto");
    Object objEF = request.getAttribute("file_edit");
    Service_File_DTO fileDto = (Service_File_DTO) objF;
    Service_File_DTO file_edit = (Service_File_DTO) objEF;

    int command = (int) request.getAttribute("command");//board-new:1 board-detail:2 board-edit:3

    String service_id = "";
    String service_type = "";

    if (user != null) {
        service_id = user.getService_id();
        service_type = user.getService_type();
    }

%>
<%--if (request.getAttribute("file_edit") != null){ --%>
<%--var file = "<%=file_edit.getOrigin_fname()%>";--%>
<%--}--%>


<div class="jumbotron jumbotron-fluid" style="margin-top:56px">
    <div class="container">

        <h2 class="display-4 text-center">게시판</h2>
        <hr class="my-4">
    </div>
</div>
<div class="container">
    <form class="editor-form boardChk" style="margin-bottom:14px" action="" method="" enctype="multipart/form-data"
          onsubmit="return submitbtn()">
        <%-- 제목, 글쓴이 --%>
        <div class="form-group input-group mb-3 input-group-prepend" style="margin-bottom: 0!important;">
            <%--<div class="input-group mb-3">--%>
            <%--<div class="input-group-prepend">--%>
            <span class="input-group-text input-group-prepend" id="basic-addon1">제목</span>
            <%--</div>--%>

            <input style="text-overflow:ellipsis; overflow:hidden; white-space:nowrap;text-overflow:ellipsis; overflow:hidden; white-space:nowrap"type="text" class="title form-control input-group-text" name="title" aria-describedby="basic-addon1"
                   value="<%=command==2?board_detail.getTitle():""%><%=command==3?board_edit.getTitle():""%>"
                   <%if (command==2){%>disabled<%}%>>

            <%--<div class="input-group-append">--%>
            <input type="text" class="writer form-control  input-group-text" id="basic-addon2" name="writer"
                   placeholder="<% if (command==1){%><%=service_id%> <%}else if(command==2){%><%=board_detail.getService_id()%><%}else if(command==3){%><%=board_edit.getService_id()%><%}%>"
                   readonly="readonly"/>
            <%if (command == 2) {%>
            <p class="input-group-text input-group-append"><fmt:formatDate value="${board_detail.getRegdate()}" pattern="yyyy-MM-dd"/></p>
            <%}%>

            <%--</div>--%>
        </div>

        <%--에디터--%>
        <div class="form-group">
            <div class="editor-container" style="maw-width:100%" id="test"></div>
            <input type="hidden" class="content" name="content" value="">
        </div>

        <%--파일--%>
        <div class="form-group input-group mb-3" style="clear:both">
            <div class="custom-file" style="float:left">
                <input type="file" class="filechk custom-file-input" name="file"
                       id="inputGroupFile04" <%=command==2?"disabled":""%>>
                <%if (command == 3 && file_edit != null) {%>
                <input type="hidden" class="filedelete" name="filedelete" value="false"/>
                <%}%>
                <label class="custom-file-label fileN"
                       for="inputGroupFile04"
                       aria-describedby="inputGroupFileAddon04">
                    <%if (command == 2) {%>
                    <%=fileDto != null ? fileDto.getOrigin_fname() : "UPLOAD"%>
                    <%} else if (command == 3) {%>
                    <%=file_edit != null ? file_edit.getOrigin_fname() : "UPLOAD"%>
                    <%}%>

                </label>
            </div>
            <div class="text-right submitB" style="margin-left:7px;float:right">
                <%if (command != 2) {%>
                <input class="btn btn-primary submitbtn" type="submit" value="확인">
                <%} else if (command == 2) {%>
                <%if (fileDto != null) {%>
                <input type="button" onclick="fileDownload()" class="btn" value="다운로드">
                <%}%>
                <% if (service_id.equalsIgnoreCase(board_detail.getService_id())||service_type.equalsIgnoreCase("M")) {%>
                <input class="btn btn-primary" type="button" onclick="edit()" value="수정"/>
                <input class="btn btn-primary" type="button" onclick="del()" value="삭제"/>
                <%}%>
                <%}if (command == 3 && file_edit != null||command == 3 && file_edit != null&&service_type.equalsIgnoreCase("M")) {%>
                <input class="btn btn-outline-secondary" type="button" onclick="deletF()" value="파일삭제"
                       id="inputGroupFileAddon04">
                <%}%>
                <input class="btn" value="뒤로가기" onclick="back()" type="button"/>
            </div>
        </div>

        <%--<div class="form-group text-right submitB" style="margin-top:10px">--%>

        <%--</div>--%>
    </form>

    <%=board_reply%>
<br>
    <hr>
    <%--<%if (service_type.equalsIgnoreCase("M")){%>--%>
    <%if (command==2){%>
    <form action="/board/<%=board_detail.getBoard_seq()%>/reply" method="post" class="form-group">

        <div class="input-group input-group-lg">
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-lg">답변</span>
            </div>
            <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" name="content"
                   <%if (board_reply!=null){%>value="<%=board_reply.getContent()%>" <%}else{%>value=""<%}%>>
            <%--<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" name="content" value="">--%>

            <%--<%if (board_reply==null)%>--%>
            <input type="submit" class="input-group-append btn btn-primary" value="답변달기">
            <%--<%}%>--%>
            <%--<input type="submit" class="input-group-append btn btn-primary" value="답변수정">--%>
        </div>
    </form>
    <%}%>
    <%--<%}%>--%>


</div>
<script>


    var quill = new Quill(".editor-container", {
        theme: "snow"
    });

    document.querySelector(".ql-container").style.height = "130px";
    <% if (command==2){%>
    document.querySelector(".ql-toolbar").style.display = "none";
    document.querySelector(".ql-editor").style.borderTop = "1px solid #ccc";
    document.querySelector(".ql-blank").contenteditable = "false";
    document.querySelector(".editor-container > div").contenteditable = "false";
    document.querySelector("#test > div").setAttribute("contenteditable", "false");
    document.querySelector("#test > div").innerHTML = "<%=board_detail.getContent()%>";
    <%}%>
    <%if (command==3){%>
    document.querySelector("#test > div").innerHTML = "<%=board_edit.getContent()%>";
    <%}%>

    function edit() {
        var form = document.forms[0];
        form.action = "/board/${board_detail.board_seq}/edit";
        form.method = "get";
        form.submit();
    }

    function fileDownload() {
        var form = document.forms[0];
        form.action = "/board/${board_detail.board_seq}/download";
        form.method = "POST";
        form.enctype = "multipart/form-data";
        form.submit();
    }

    function del() {
        var form = document.forms[0];
        form.action = "/board/${board_detail.board_seq}/delete";
        form.method = "post";
        form.submit();
    }

    function back() {
        location.href = document.referrer;
    }

    function deletF() {
        document.querySelector(".fileN").innerText = "UPLOAD";
        document.querySelector(".filedelete").setAttribute("value", "true");
    }

    function sizeChk() {

        //content 담기
        var content = document.querySelector("#test > div").innerHTML;
        document.querySelector(".content").value = content;

        //파일 사이즈체크
        var maxSize = 2 * 1024 * 1024;
        if (document.querySelector(".filechk").files[0] !== undefined) {
            var fileSize = document.querySelector(".filechk").files[0].size;
            alert("fileSize =" + fileSize);
            if (fileSize > maxSize) {
                alert("2MB이하의 파일을 선택해주세요");
                return false;
            } else {
                alert("적당한 사이즈네요");
                return true;
            }
        }
    }

    function submitbtn() {

        var form = document.forms[0];

        <% if (command == 1) {%>
        form.action = "/board";
        form.method = "post";
        <%}%>

        <% if (command==3) {%>
        form.action = "/board/<%=board_edit.getBoard_seq()%>/edit";
        form.method = "post";
        <%}%>

        return sizeChk();

    }

</script>