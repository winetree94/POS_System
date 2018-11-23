<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>

<link href="https://cdn.quilljs.com/1.2.2/quill.snow.css"
      rel="stylesheet">
<script src="https://cdn.quilljs.com/1.2.2/quill.js"></script>
<div class="wrap">
    <form id="editor-form" onsubmit="return sizeChk()" class="container text-center">
        <div class="form-group">
            <input type="text" class="writer form-control" name="writer" placeholder="writer">
            <input type="text" class="title form-control" name="title" placeholder="title">
            <input type="date" class="date form-control" name="date" placeholder="date">
            <div id="editor-container" class="form-group"></div>
            <input type="hidden" class="content" name="content" value="">
            <div class="file form-control-file"></div>
            <input class="btn btn-primary" type="submit" value="submit" class="btn btn-primary">
        </div>
    </form>
</div>
<script>
    window.onload = function () {
        var quill = new Quill('#editor-container', {
            theme: 'snow'
        });
        document.querySelector(".ql-container").style.height = "300px";
        document.querySelector("#editor-form > div").style.width = "500px";
        document.querySelector("#editor-form > div").style.margin = "30px auto 0";

        var form = document.querySelector('#editor-form');
        form.setAttribute("action", form_action);
        form.setAttribute("class", form_class);
        form.setAttribute("method", form_method);
        form.setAttribute("enctype", form_enctype);
        form.setAttribute("use_file", use_file);

        if (use_file) {
            document.querySelector('div.file').innerHTML = "<input type='file' id='filechk' name='file'>";

        }

        if (title != null && title != undefined) {
            document.querySelector(".writer").value = writer;
            document.querySelector(".title").value = title;
            document.querySelector(".ql-editor").innerHTML = content;
            document.querySelector(".content").value = content;
        }

        if (file != null || file != "") {
            document.querySelector("div.file").innerHTML += "<p>" + file + "</p>";


            var createBtn = document.createElement('input');
            document.querySelector("div.file p").appendChild(createBtn);

            document.querySelector("div.file p input").setAttribute("class", "deleteFile");
            document.querySelector(".deleteFile").setAttribute("type", "submit");
            // document.querySelector(".deleteFile").setAttribute("type","submit");
            //폼태그 만들어서 파일삭제 기능 만들기 20181121 22:52

        }

    }


    /*   if(file != null	){
           document.querySelector(".file > input").value = file;
       }*/

    function sizeChk() {
        //		if (document.getElementById("filechk").value != "") {
        // var fileSize = document.querySelector('input[type=file]').files[0].size;

        var data = document.querySelector('.ql-editor').innerHTML;
        document.querySelector('.content').value = data;
        var maxSize = 2 * 1024 * 1024;

        if (document.getElementById('filechk').files[0] != undefined) {
            var fileSize = document.getElementById('filechk').files[0].size;
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