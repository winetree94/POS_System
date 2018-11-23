<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page import="com.pos.system.dto.Store_Account_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="../comm/header.jsp"/>


<%
	Service_Account_DTO userDetail = (Service_Account_DTO) request.getAttribute("userDetail");
%>

<div class="jumbotron">
	<div class="container">
		<h1 class="display-4 text-center"> 계정 정보 </h1>
		<p class="p-2 text-center">계정의 상세정보 페이지입니다.</p>
	</div>
</div>

<div class="container" style="max-width: 500px;">
	<div id="accountdiv">

		<div class="row">
			<div class="col">
				<p class="p-2 text-right"><b>아이디</b> :</p>
			</div>
			<div class="col">
				<p class="p-2 text-left">${userDetail.service_id}</p>
			</div>
		</div>

		<div class="row">


			<div class="col">
				<p class="p-2 text-right"><b>유저 타입</b> : </p>
			</div>
			<div class="col">
				<p class="p-2 text-left">${userDetail.service_type}</p>
			</div>
		</div>

		<div class="row">
			<div class="col">
		<p class="p-2 text-right"><b>이메일 주소</b> : </p>
			</div>
			<div class="col">
				<p class="p-2 text-left">${userDetail.service_email}</p>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<p class="p-2 text-right"><b>가입일</b> : </p>
			</div>
			<div class="col">
				<p class="p-2 text-left">${userDetail.regdate}</p>
			</div>
		</div>

		<form method="post" class="text-center">
			<div class="form-group">
				<input class="btn btn-primary" type="button" value="회원정보수정" onclick="modifyAccount()"/>
			</div>
		</form>
	</div>
</div>

<script>
	var service_id = "<%=userDetail.getService_id()%>";
</script>
<jsp:include page="../comm/footer.jsp"/>