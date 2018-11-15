<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
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

<%
    Service_Account_DTO userDetail =(Service_Account_DTO)request.getAttribute("userDetail");

%>

<h1>ACCOUNT DETAIL</h1>
   아이디 : ${userDetail.service_id}
   유저 타입 :  ${userDetail.service_type}
   이메일 주소 : ${userDetail.service_email}
   가입일 :  ${userDetail.regdate}

</body>
</html>