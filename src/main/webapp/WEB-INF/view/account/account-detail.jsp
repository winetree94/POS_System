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




<div class="container" style="min-width: 450px; max-width: 450px;">
	<table class="table table table-bordered shadow">
		<tbody>
		<tr>
			<td class="table-default " scope="col" colspan="2"> <p class="h4 display-4 text-center font-weight-light" style="font-size: 40px">${userDetail.service_id}님의 상세정보</p></td>
		</tr>
		</tbody>
		<tbody>
		<tr>
			<td class="table-light " scope="row" class="table-active"><p class=" text-center">아이디 :</p></td>
			<td class="table-light"><p class=" text-center">${userDetail.service_id}</p></td>
		</tr>
		<tr>
			<td class="table-light" scope="row"><p class=" text-center">계정 타입 : </p></td>
			<td class="table-light"><p class=" text-center">${userDetail.service_type}</p></td>
		</tr>
		<tr>
			<td class="table-light" scope="row"><p class=" text-center">이메일 주소 : </p></td>
			<td class="table-light"><p class=" text-center">${userDetail.service_email}</p></td>
		</tr>
		<tr>
			<td class="table-light" scope="row"><p class=" text-center">가입일 : </p></td>
			<td class="table-light"><p class=" text-center">${userDetail.regdate}</p></td>
		</tr>
		</tbody>
	</table>
</div>


		<form method="post" class="text-center">
			<p class="p-1"></p>
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