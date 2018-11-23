<%@ page import="com.pos.system.dto.Service_Account_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>


<%
    Service_Account_DTO userDetail =(Service_Account_DTO)request.getAttribute("userDetail");

%>

<div class="jumbotron">
    <div class="container">
        <h1 class="display-4 text-center"> 계정 정보 수정 </h1>
        <p class="p-2 text-center">계정의 상세정보 수정 페이지입니다.</p>
    </div>
</div>


<div class="container" style="max-width: 600px;">

    <form method="post">

            <p class="p-2 text-center"><h4 class="display-4 text-center" style="font-size: 40px"> 이메일 변경</h4></p>
    <div class="row">
        <div class="col">
            <p class="p-2 text-right"><b>현재 이메일 주소</b> :</p>
        </div>
        <div class="col">
            <p class="p-2 text-left">${userDetail.service_email}</p>
        </div>
    </div>
        <div class="row">
        <div class="col">
            <p class="p-2 text-right"><b>변경할 이메일 주소:</b> :</p>
        </div>
        <div class="col">
            <p class="p-2 text-left"><input type="email" id="service_email" name="service_email"></p>
        </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="p-2 text-center"> <span id="result"></span></p>
            </div>
        </div>
        <div class="row">
        <div class="col">
            <p class="p-2 text-center"> <input class="btn btn-primary" type="button" value="이메일변경" onclick="editEmail()"></p>
        </div>
            </div>



        <p class="p-2 text-center"><h4 class="display-4 text-center" style="font-size: 40px"> 비밀번호 변경</h4></p>
        <div class="row">
            <div class="col">
                <p class="p-2 text-right"><b>변경할 비밀번호 : </b> </p>
            </div>
            <div class="col">
                <p class="p-2 text-left">  <input type="password" id="new_pw" name="new_pw"></p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="p-2 text-right"><b>비밀번호 재확인 : </b> </p>
            </div>
            <div class="col">
                <p class="p-2 text-left"><input type="password" id="re_pw" name="re_pw"></p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="p-2 text-center"> <span id="resultPw"></span></p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="p-2 text-center"> <input class="btn btn-primary" type="button" value="비밀번호변경" onclick="editPw()"></p>
            </div>
        </div>





</form>






<jsp:include page="../comm/footer.jsp"/>