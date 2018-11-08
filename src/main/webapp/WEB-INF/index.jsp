<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>

	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>

	<script type="text/javascript" src="./src/js/script.js"></script>
	<link rel="stylesheet" href="./src/css/style.css">


</head>
<body>

<h1>Hello World!</h1>

<script type="text/javascript">
	var form_action = "/data"; // form 의 action 위치
	var form_class = ""; // form 의 클래스 선언
	var form_method = "post"; // form request 방식
	var form_enctype = "multipart/form-data"; // form 의 enctype 방식
	var use_file = true; // 파일 업로드 기능 사용 여부
</script>

<jsp:include page="view/util/editor.jsp"/>

</body>
</html>