<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>


<%
    Service_Account_DTO userDetail =(Service_Account_DTO)request.getAttribute("userDetail");

%>
<div id="modifyaccountdiv">
<h2>MODIFY ACCOUNT</h2>

<b>이메일변경</b>
<form method="post">
    현재 이메일 주소: ${userDetail.service_email}<br>
    변경할 이메일 주소: <input type="email" id="service_email" name="service_email"><br>
    <input type="button" value="이메일변경" onclick="editEmail()"><br>
    <span id="result"></span><br/>


<b>비밀번호변경</b><br>

변경할 비밀번호 : <input type="password" id="new_pw" name="new_pw"><br>
비밀번호 재확인 : <input type="password" id="re_pw" name="re_pw"><br>
<input type="button" value="비밀번호변경" onclick="editPw()"><br>
    <span id="resultPw"></span><br/>
</form>
</div>





<jsp:include page="../comm/footer.jsp"/>