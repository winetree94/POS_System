<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page import="com.pos.system.dto.Store_Account_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="../comm/header.jsp"/>




<%
    Service_Account_DTO userDetail =(Service_Account_DTO)request.getAttribute("userDetail");
%>

<h2>ACCOUNT DETAIL</h2>
   아이디 : ${userDetail.service_id}
   유저 타입 :  ${userDetail.service_type}
   이메일 주소 : ${userDetail.service_email}
   가입일 :  ${userDetail.regdate}
<br>
<form method="post">
<input type="button" value="회원정보수정" onclick="modifyAccount()"/>
</form>
<script>
    var service_id = "<%=userDetail.getService_id()%>";
</script>
<jsp:include page="../comm/footer.jsp"/>