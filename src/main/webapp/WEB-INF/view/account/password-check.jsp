<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>
<%
    Service_Account_DTO user =(Service_Account_DTO)session.getAttribute("user");

%>
<div id="accountdiv">
<h2>Password Check</h2>
<form method="post">
<input type='password' name='service_pw' id='inputPw' required='required'/>
    <input type='button' id='login' name='login' value='비밀번호 확인' onclick='pwCheck()'/>
</form>
</div>
<script>
    var service_id = "<%=user.getService_id()%>";
</script>
<jsp:include page="../comm/footer.jsp"/>