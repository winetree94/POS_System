<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <%response.setContentType("text/html; charset=UTF-8"); %>

	<jsp:include page="../comm/header.jsp"/>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h4 class="display-4 text-center">게시판</h4>
		<hr class="my-4">
		<p class="lead small text-right">Q&A 게시판입니다. 욕설/비방 글은 삭제될 수 있습니다.</p>
	</div>
</div>
	<script type="text/javascript">
		var form_action = "/board"; // form 의 action 위치
		var form_class = ""; // form 의 클래스 선언
		var form_method = "post"; // form request 방식
		var form_enctype = "multipart/form-data"; // form 의 enctype 방식
		var use_file = true; // 파일 업로드 기능 사용 여부
		var title;
	</script>

<jsp:include page="../util/editor.jsp"/>
<script type="text/javascript">

    document.querySelector("#submitB").innerHTML += "<input onclick=\"back()\" class=\"btn\" value=\"취소\"type=\"button\"/>"

    function back() {
        history.back();
    }

</script>

<jsp:include page="../comm/footer.jsp"/>