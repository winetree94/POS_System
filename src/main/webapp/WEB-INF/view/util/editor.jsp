<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <%response.setContentType("text/html; charset=UTF-8"); %>

<link href="https://cdn.quilljs.com/1.2.2/quill.snow.css"
	rel="stylesheet">
<script src="https://cdn.quilljs.com/1.2.2/quill.js"></script>

<form id="editor-form" onsubmit="return sizeChk()">
	<div>
		<input type="text" class="writer" name="writer" placeholder="writer">
		<input type="text" class="title" name="title" placeholder="title">
		<input type="date" class="date" name="date" placeholder="date">
		<div id="editor-container"></div>
		<input type="hidden" class="content" name="content" value="">
		<div class="file"></div>
		<input type="submit" value="submit">
	</div>
</form>

<script>
	window.onload = function() {
		var quill = new Quill('#editor-container', {
			theme : 'snow'
		});
        document.querySelector(".ql-container").style.height = "300px";
        document.querySelector("#editor-form > div").style.width = "500px";

		var form = document.querySelector('#editor-form');
		form.setAttribute("action", form_action);
		form.setAttribute("class", form_class);
		form.setAttribute("method", form_method);
		form.setAttribute("enctype", form_enctype);
		form.setAttribute("use_file",use_file);

		if (use_file) {
			document.querySelector('div.file').innerHTML = "<input type='file' id='filechk' name='file'>";

		}

        if(title != null && title != undefined) {
            document.querySelector(".writer").value = writer;
            document.querySelector(".title").value = title;
            document.querySelector(".ql-editor").innerHTML = content;
            document.querySelector(".content").value = content;
        }

        if(file != null || file != "") {
            document.querySelector("div.file").innerHTML += "<p>"+file+"</p>";
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

		if (document.getElementById('filechk').files[0] != undefined){
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