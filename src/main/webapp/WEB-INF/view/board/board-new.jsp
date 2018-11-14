<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
	<script type="text/javascript">
		var form_action = "/board"; // form 의 action 위치
		var form_class = ""; // form 의 클래스 선언
		var form_method = "post"; // form request 방식
		var form_enctype = "multipart/form-data"; // form 의 enctype 방식
		var use_file = true; // 파일 업로드 기능 사용 여부
	</script>

<jsp:include page="../util/editor.jsp"/>
		
	</body>
</html>