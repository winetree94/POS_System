<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../comm/header.jsp"/>

<div class="jumbotron">
	<div class="container">
		<h1 class="display-4 text-center">로그인</h1>
	</div>
</div>

<div class='container' style="max-width: 500px">

	<form method='post' id='frm'>

		<div class='form-group'>
			<label for="inputId">아이디</label>
			<input type='hidden' id='loginChk' name='service_type' value='0'/>
			<input class='form-control' type='text' name='service_id' id='inputId' required='required'>
		</div>

		<div class="form-group">
			<label id='pw'>비밀번호</label>
			<input class='form-control' type='password' name='service_pw' id='inputPw' required='required'>
		</div>


		<div class="form-group">
		<input class='btn btn-primary' type='button' id='login' name='login' value='로그인'
		       onclick='loginCheck()'/>
		</div>
	</form>
			<form>

			<input class='btn btn-secondary' type='button' id='SignUp' name='signup' value='회원가입' onclick='signUp()'/>
			<input class='btn btn-secondary' type='button' id='IdFind' name='idfind' value='아이디찾기' onclick='idFindForm()'/>


	</form>

<%--
<div class="container">
	<form method='get'>
		<input class='btn btn-primary' type='button' id='SearchId' name='SearchId' value='FIND ID'
		       onclick='idSearch()'/>
		<input class='btn btn-primary' type='button' id='SearchPw' name='SearchPw' value='FIND PW'
		       onclick='pwSearch()'/>
	</form>
</div>
--%>


</div>

<jsp:include page="../comm/footer.jsp"/>