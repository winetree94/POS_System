<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../comm/header.jsp"/>
<h2>POS LOGIN PAGE </h2>
<!-- ajax -->
<!-- ajax처리떄문에 one quotation으로 처리해준다. -->
<div id='container'>

    <div id='id'>아이디</div>

    <form method='post' id='frm'>
        <input type='hidden' id='loginChk' name='service_type' value='0'/>
        <input type='text' name='service_id' id='inputId' required='required'>
        <br/>
        <br/>
        <div id='pw'>비밀번호</div>

        <input type='password' name='service_pw' id='inputPw' required='required'>
        <br/>
        <br/>
        <input type='button' id='login' name='login' value='로그인' onclick='loginCheck()'/>

            <a href='#' onclick='signUp()'>
                <input type='button' id='SignUp' name='signup' value='회원가입'/>
            </a>


    </form>

    <form method="get">
    <input type='button' id='SearchId' name='SearchId' value='FIND ID' onclick='idSearch()' />
    <input type='button' id='SearchPw' name='SearchPw' value='FIND PW' onclick='pwSearch()' />
    </form>

</div>

<jsp:include page="../comm/footer.jsp"/>