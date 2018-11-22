<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../comm/header.jsp"/>
<div class='wrap container' style="width: 400px;">
    <h4 class='text-center'>POS LOGIN PAGE </h4>
    <!-- ajax -->
    <!-- ajax처리떄문에 one quotation으로 처리해준다. -->


        <form method='post' id='frm'>

            <div class='form-group'>

                <input type='hidden' id='loginChk' name='service_type' value='0'/>


                <label id='id'>아이디</label>

                <input class='form-control' type='text' name='service_id' id='inputId' required='required'>

            </div>


            <%--<div class='form-group'>--%>
                <label id='pw'>비밀번호</label>

                <input class='form-control marginB' type='password' name='service_pw' id='inputPw' required='required'>

            <%--</div>--%>


            <input class='btn btn-primary marginR marginLo' type='button' id='login' name='login' value='로그인' onclick='loginCheck()'/>


            <a href='#' onclick='signUp()'>
                <input class='btn btn-primary marginR' type='button' id='SignUp' name='signup' value='회원가입'/>
            </a>

        </form>

        <form method='get'>
            <%--<div class='form-group'>--%>
                <input class='btn btn-primary marginR' type='button' id='SearchId' name='SearchId' value='FIND ID'
                       onclick='idSearch()'/>
                <input class='btn btn-primary marginR' type='button' id='SearchPw' name='SearchPw' value='FIND PW'
                       onclick='pwSearch()'/>
            <%--</div>--%>
        </form>


</div>

<jsp:include page="../comm/footer.jsp"/>