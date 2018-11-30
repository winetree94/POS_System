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

    Object objE = request.getAttribute("board_edit");
    Object objD = request.getAttribute("board_detail");

    Service_Board_DTO board_edit = (Service_Board_DTO) objE;
    Service_Board_DTO board_detail = (Service_Board_DTO) objD;


    Object objF = request.getAttribute("fileDto");
    Object objEF = request.getAttribute("file_edit");
    Service_File_DTO fileDto = (Service_File_DTO) objF;
    Service_File_DTO file_edit = (Service_File_DTO) objEF;

    int command = (int) request.getAttribute("command");//board-new:1 board-detail:2

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
    <form class="editor-form" onsubmit="return sizeChk()" style="margin-bottom:14px"
          action=<%=command!=2?"/board":null%> class="" method=<%=command!=2?"post":null%> enctype="multipart/form-data"
          use_file="true">

        <%-- 제목, 글쓴이 --%>
        <div class="form-group input-group mb-3" style="margin-bottom: 0!important;">
            <%--<div class="input-group mb-3">--%>
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">제목</span>
            </div>

            <input type="text" class="title form-control" name="title" aria-describedby="basic-addon1"
                   value="<%=command==2?board_detail.getTitle():""%>" <%if (command!=1){%>disabled<%}%>><%--title--%>

            <div class="input-group-append">
                <input type="text" class="writer input-group-text" id="basic-addon2" name="writer"
                       placeholder="<% if (command==1){%><%=service_id%> <%}else if(command==2){%><%=board_detail.getService_id()%><%}else{%><%=board_edit.getService_id()%><%}%>"
                       readonly="readonly"/>
                <%if (command == 2) {%>
                <span class="input-group-text"><fmt:formatDate value="${board_detail.getRegdate()}"
                                                               pattern="yyyy-MM-dd"/></span>
                <%}%>

            </div>
        </div>

        <%--에디터--%>
        <div class="form-group">
            <div class="editor-container" style="maw-width:100%"id="test"></div>
            <input type="hidden" class="content" name="content" value="">
        </div>

            <%--파일--%>
        <div class="form-group input-group mb-3" style="width:70%">

            <div class="custom-file">
                <input type="file" class="filechk custom-file-input" name="file" id="inputGroupFile04" <%=command!=1?"disabled":""%>>
                <label class="custom-file-label fileN" for="inputGroupFile04"
                       aria-describedby="inputGroupFileAddon04">
                   <%--<span class='fileN'></span>--%>
                    <%=fileDto!=null?fileDto.getOrigin_fname():"UPLOAD"%>
                </label>

            </div>



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
    <div class="input-group-append">
        <%if(command!=2){%>
        <input type='hidden' class='filedelete' name='filedelete' value='false' />
        <input type='button' onclick='deletF()' value='파일삭제' class="btn btn-outline-secondary" id="inputGroupFileAddon04" />
        <%}else if(command==2 && fileDto!=null) {%>
        <form action="./${board_detail.board_seq}/download" method="POST"  enctype="multipart/form-data">
            <%--<input type="button" onclick="editFile()" value="파일수정">--%>
            <%--<input type="button" onclick="delFile()" value="파일삭제">--%>
            <input type="submit" value="다운로드" class="input-group-text">
        </form>
        <%}%>
        <%--%=fileDto.getOrigin_fname()%>--%>
        <%--<form action="./${board_detail.board_seq}/download" method="POST" class="fileChk"--%>
        <%--enctype="multipart/form-data">--%>
        <%--&lt;%&ndash;<input type="button" onclick="editFile()" value="파일수정">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="button" onclick="delFile()" value="파일삭제">&ndash;%&gt;--%>
        <%--<input type="submit" value="다운로드">--%>
        <%--</form>--%>


    </div>
    <%--form End--%>
</div>
<script>

        // document.querySelector(".ql-snow").style.display = "none";
        // document.querySelector(".ql-toolbar").style.display = "none";


        var quill = new Quill('.editor-container', {
            theme: 'snow'
        });

        document.querySelector(".ql-container").style.height = "130px";

        <% if (command==2){%>

        document.querySelector(".ql-toolbar").style.display = "none";
        document.querySelector(".ql-editor").style.borderTop= "1px solid #ccc";
        document.querySelector(".ql-blank").contenteditable="false";
        document.querySelector(".editor-container > div").contenteditable="false";
        document.querySelector("#test > div").setAttribute("contenteditable","false");
        document.querySelector("#test > div").innerHTML = "<%=board_detail.getContent()%>";

        <%}%>






        function deletF() {

            document.querySelector(".fileN").innerText = "UPLOAD";
            document.querySelector(".filedelete").value = "true";
            // alert(file);

        }

        <%--var use_file = true; // 파일 업로드 기능 사용 여부--%>
        <%--if (use_file) {--%>
            <%--document.querySelector('div.file').innerHTML = "<input type='hidden' class='filedelete' name='filedelete' value='false' />";--%>
        <%--}--%>

        function sizeChk() {

            //content 담기
            var content = document.querySelector("#test > div").innerHTML;
            document.querySelector(".content").value = content;
            console.log(content);


            //파일 사이즈체크
            var maxSize = 2 * 1024 * 1024;
            //
            if (document.querySelector(".filechk").files[0] !== undefined) {
                var fileSize = document.querySelector(".filechk").files[0].size;
                // alert(fileSize);
                if (fileSize > maxSize) {
                    alert("2MB이하의 파일을 선택해주세요");
                    return false;
                } else {
                    alert("적당한 사이즈네요");
                    return true;
                }
            }

            // return true;
        }


</script>