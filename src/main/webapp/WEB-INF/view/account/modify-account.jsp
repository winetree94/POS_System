<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>


<%
    Service_Account_DTO userDetail =(Service_Account_DTO)request.getAttribute("userDetail");

%>

<h2>MODIFY ACCOUNT</h2>

이메일변경
<form method="post">
    현재 이메일 주소: ${userDetail.service_email}<br>
    변경할 이메일 주소: <input type="email" id="inputEmail" name="inputEmail"><br>
    <span id="result"></span><br/>
    <input type="button" value="이메일변경" onclick="editEmail()"><br>
</form>

비밀번호변경<br>
변경할 비밀번호 : <input type="password"><br>
비밀번호 재확인 : <input type="password"><br>
<input type="button" value="비밀번호변경"><br>







<jsp:include page="../comm/footer.jsp"/>