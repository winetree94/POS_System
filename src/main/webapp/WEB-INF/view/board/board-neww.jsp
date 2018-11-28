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
<jsp:include page="../comm/header.jsp"/>
<%

    Service_Board_DTO board = new Service_Board_DTO();
    Service_Account_DTO user = (Service_Account_DTO) session.getAttribute("user");

    int a = (int) request.getAttribute("command");
    // 글 새로만드는애는 1 수정 2

    String service_id = "";
    String service_type = "";

    if (user != null) {
        service_id = user.getService_id();
        service_type = user.getService_type();
    }

    String board_service_id = "";
    String title = "";
    String content = "";
    Date regdate = new Date();

//    if (board != null) {
//        board_service_id = board.getService_id();
//        title = board.getTitle();
//        content = board.getContent();
//        regdate = board.getRegdate();
//    }


    System.out.println(service_id);

%>


<div class="jumbotron jumbotron-fluid" style="margin-top:56px">
    <div class="container">

        <h2 class="display-4 text-center">게시판</h2>
        <hr class="my-4">
        <%=a == 1 ? "" : ""%>

    </div>
</div>
<div class="container">
    <form class="editor-form" onsubmit="return sizeChk()" style="margin-bottom:14px"
          action=<%=a==1?"/board":null%> class="" method=<%=a==1?"post":null%> enctype="multipart/form-data"
          use_file="true">

        <%-- 제목, 글쓴이 --%>
        <div class="form-group input-group mb-3" style="margin-bottom: 0">
            <%--<div class="input-group mb-3">--%>
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">제목</span>
            </div>

            <input type="text" class="title form-control" name="title" aria-describedby="basic-addon1"
                   value="<%=board!=null?board.getTitle():""%>"><%--title--%>

            <div class="input-group-append">
                <input type="text" class="writer input-group-text" id="basic-addon2" name="writer"
                       placeholder="<%=user.getService_id()%>" readonly/><%--Writer Area--%>
                <%--Regdate Area--%>
                <%if (a != 1) {%>
                <span class="input-group-text"><%=board.getRegdate()%></span>
                <% } %>

                <%--<span class="input-group-text"><fmt:formatDate value="${board_detail.getRegdate()}" pattern="yyyy-MM-dd"/></span>--%>
            </div>
        </div>

        <%--에디터--%>
        <div class="form-group">
            <%--.input-group-append End--%>
            <%--content Area--%>
            <%--<div class="container" style="padding:0">--%>

            <div class="editor-container" style="maw-width:100%"></div>
            <input type="hidden" class="content" name="content" value="">

            <%--<div class="input-group-text editor-container"></div>--%>
            <%--<div class="form-control" aria-label="With textarea">${board_detail.getService_id()}</div>--%>
            <%--</div>--%>
        </div>


        <div class="form-group input-group mb-3" style="width:70%">
            <%--</div>--%>
            <%--.input-group mb-3 End--%>
            <%--파일--%>
            <%--<div class="input-group mb-3" style="width:70%">--%>
                <div class="custom-file">
                    <input type="file" class="filechk custom-file-input" name="file" id="inputGroupFile02">
                    <label class="custom-file-label" for="inputGroupFile02"
                           aria-describedby="inputGroupFileAddon02"><span class='fileN'>여기다가 파일명</span></label>
                    <%--<input type='hidden' class='filedelete' name='filedelete' value='false' />--%>
                </div>
                <%--<div class="input-group-append">--%>
                <%--<input type='file' class='filechk' name='file' ><input type='hidden' class='filedelete' name='filedelete' value='false' />--%>
                <%--<span class="input-group-text" id="inputGroupFileAddon02">Upload</span>--%>
                <%--<button onclick='deletF()' id="inputGroupFileAddon02" class='input-group-text pointer'>파일삭제</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>


        <div>
            <div class="container text-right submitB" style="margin-top:10px">
                <input class="btn btn-primary submitbtn" type="submit" value="submit">
                <input onclick="back()" class="btn" value="뒤로가기" type="button"/>
                <script type="text/javascript">function back() {
                    history.back();
                }</script>
            </div>
        </div>
        <%--.form-group End--%>
    </form>
    <%--form End--%>
</div>
<script>
    window.onload = function () {


        var quill = new Quill('.editor-container', {
            theme: 'snow'
        });

        document.querySelector(".ql-container").style.height = "130px";


        var title;
        console.log(title);

        function deletF() {

            document.querySelector(".fileN").innerText = "";
            document.querySelector(".filedelete").value = "true";
            // alert(file);

        }

        var use_file = true; // 파일 업로드 기능 사용 여부
        // if (use_file) {
        //     document.querySelector('div.file').innerHTML = "<input type='hidden' class='filedelete' name='filedelete' value='false' />";
        //
        // }
        // if (file != null || file != "") {
        //     document.querySelector(".fileN").innerHTML +=  file;
        //
        //     var fileP = document.querySelector(".fileN");
        //     fileP.innerHTML += "&nbsp;&nbsp;<input type='button' onclick='deletF()' value='파일삭제' class='btn btn-sm btn-dark' />";
        //
        // }
        // function sizeChk() {
        //
        //     var data = document.querySelector('.ql-editor').innerHTML;
        //     document.querySelector('.content').value = data;
        //     var maxSize = 2 * 1024 * 1024;
        //
        //     if (document.querySelector('.filechk').files[0] !== undefined) {
        //         var fileSize = document.querySelector('.filechk').files[0].size;
        //         if (fileSize > maxSize) {
        //             alert("2MB이하의 파일을 선택해주세요");
        //             return false;
        //         } else {
        //             // alert("적당한 사이즈네요");
        //             return true;
        //         }
        //     }
        //
        //     return true;
        // }

    }
</script>