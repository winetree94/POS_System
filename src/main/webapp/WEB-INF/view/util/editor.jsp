<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%

    Service_Account_DTO user = (Service_Account_DTO) session.getAttribute("user");
    String service_id = "";
    if (user != null) {
        service_id = user.getService_id();
    }

%>
<link href="https://cdn.quilljs.com/1.2.2/quill.snow.css"
      rel="stylesheet">
<script src="https://cdn.quilljs.com/1.2.2/quill.js"></script>

<div class="container text-center">
    <form class="editor-form" onsubmit="return sizeChk()" style="margin-bottom:14px">
        <div class="form-group">
            <input type="text" class="writer form-control" name="writer" placeholder="<%=service_id%>" readonly>
            <input type="text" class="title form-control" name="title" placeholder="title">
            <%--<input type="date" class="date form-control" name="date" placeholder="date">--%>
            <div class="editor-container form-group"></div>


            <input type="hidden" class="content" name="content" value="">


            <div class="container text-left file form-control-file"
                 style='height:27px;margin-bottom:12px;margin-top:6px'>

                <input type='file' class='filechk' name='file'>
                <input type='hidden' class='filedelete' name='filedelete' value='false'/>

            </div>


            <div class="container text-right submitB" style="margin-top:10px">
                <input class="btn btn-primary submitbtn" type="submit" value="submit">
            </div>
        </div>
    </form>
</div>
<script>
    window.onload = function () {


        var quill = new Quill('.editor-container', {
            theme: 'snow'
        });
        document.querySelector(".ql-container").style.height = "300px";
        document.querySelector(".editor-form > div").style.maxWidth = "500px";
        document.querySelector(".editor-form > div").style.margin = "0 auto";

        var form = document.querySelector('.editor-form');
        form.setAttribute("action", form_action);
        form.setAttribute("class", form_class);
        form.setAttribute("method", form_method);
        form.setAttribute("enctype", form_enctype);
        form.setAttribute("use_file", use_file);

        if (use_file) {
            document.querySelector('div.file').innerHTML = "<input type='file' class='filechk' name='file' ><input type='hidden' class='filedelete' name='filedelete' value='false' />";

        }
    }
</script>
<div class="container text-left file form-control-file" style='height:27px;margin-bottom:12px;margin-top:6px'></div>

<div class="container text-right submitB" style="margin-top:10px">

    <input class="btn btn-primary submitbtn" type="submit" value="submit">

</div>
<script type="text/javascript">
    if (title != null && title != undefined) {
        document.querySelector(".writer").value = writer;
        document.querySelector(".title").value = title;
        document.querySelector(".ql-editor").innerHTML = content;
        document.querySelector(".content").value = content;
    }

    if (file != null || file != "") {
        document.querySelector("div.file").innerHTML += ("<span class='fileN'>" + file + "</span>");

        var fileP = document.querySelector(".fileN");
        fileP.innerHTML += "&nbsp;&nbsp;<input type='button' onclick='deletF()' value='파일삭제' class='btn btn-sm btn-dark' />";

    }


    }

    function deletF() {

        document.querySelector(".fileN").innerText = "";
        document.querySelector(".filedelete").value = "true";

    }


    function sizeChk() {

        var data = document.querySelector('.ql-editor').innerHTML;
        document.querySelector('.content').value = data;
        var maxSize = 2 * 1024 * 1024;

        if (document.querySelector('.filechk').files[0] !== undefined) {
            var fileSize = document.querySelector('.filechk').files[0].size;
            if (fileSize > maxSize) {
                alert("사이즈가 너무 커요");
                return false;
            } else {
                alert("적당한 사이즈네요");
                return true;
            }
        }

        return true;
    }

</script>