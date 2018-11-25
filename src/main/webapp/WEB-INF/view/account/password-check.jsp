<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>
<%
	Service_Account_DTO user = (Service_Account_DTO) session.getAttribute("user");

%>
<div class="jumbotron">
	<div class="container">
		<h1 class="display-4 text-center">기존 비밀번호를 확인해 주세요.</h1>
	</div>
</div>

<div class="container" style="max-width: 500px;">
	<form method="post">
		<div class="form-group">
			<label for="inputPw"> 비밀번호를 입력하세요.</label>
			<input class="form-control" type='password' name='service_pw' id='inputPw' required='required' placeholder="비밀번호"/>
		</div>
		<div class="form-group">
			<input class="btn btn-primary" type='button' id='login' name='login' value='확인' onclick='pwCheck()'/>
		</div>
	</form>
</div>
<script>
	var service_id = "<%=user.getService_id()%>";
</script>
<jsp:include page="../comm/footer.jsp"/>