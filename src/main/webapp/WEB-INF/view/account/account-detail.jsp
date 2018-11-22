<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page import="com.pos.system.dto.Store_Account_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="../comm/header.jsp"/>


<%
	Service_Account_DTO userDetail = (Service_Account_DTO) request.getAttribute("userDetail");
%>

<div class="container">
	<div id="accountdiv">
		<h2>ACCOUNT DETAIL</h2>
		<b>아이디</b> : ${userDetail.service_id}<br>
		<b>유저 타입</b> : ${userDetail.service_type}<br>
		<b>이메일 주소</b> : ${userDetail.service_email}<br>
		<b>가입일</b> : ${userDetail.regdate}<br>
		<br>
		<form method="post">
			<input type="button" value="회원정보수정" onclick="modifyAccount()"/>
		</form>
	</div>
</div>

<script>
	var service_id = "<%=userDetail.getService_id()%>";
</script>
<jsp:include page="../comm/footer.jsp"/>