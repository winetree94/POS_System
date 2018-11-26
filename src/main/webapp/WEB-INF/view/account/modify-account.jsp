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


<form method="post">
<div class="container" style="max-width: 1200px" >

      <div class="row">



        <div class="col" style="min-width: 450px; max-width: 600px; margin:  0px auto;" >
            <table class="table table table-bordered shadow">
                <thead>
                <tr>
                    <th class="table-default " scope="col" colspan="2"> <p class="h4 display-4 text-center font-weight-light" style="font-size: 40px">이메일 변경</p></th>
                </tr>
                </thead>
                <tbody>
                <tr>
            <td class="table-light " scope="row" class="table-active"><p class=" text-center">현재 이메일 주소 :</p></td>
            <td class="table-light " scope="row" class="table-active"><p class=" text-left"> <input class="form-control" readonly="readonly" type="text" value="${userDetail.service_email}"></p></td>
                </tr>
                <tr>
                    <td class="table-light " scope="row" class="table-active"><p class=" text-center">변경할 이메일 주소 :</p></td>
                    <td class="table-light " scope="row" class="table-active"><p class="text-center"><input class="form-control" type="email" id="service_email" name="service_email" placeholder="이메일을 입력해주세요" ></p></td>
                </tr>
                </tbody>
            </table>

             <div class="row">
            <div class="col">
                <p class="text-center"> <span id="result"></span></p>
            </div>
        </div>
            <div class="row">
                <div class="col">
                    <p class="text-center"> <input class="btn btn-primary" type="button" value="이메일변경" onclick="editEmail()"></p>
                </div>
            </div>
        </div>


        <div class="col" style="min-width: 450px; max-width: 600px; margin: 0px auto;">
              <table class="table table table-bordered shadow">
                  <thead>
                  <tr>
                      <th class="table-default " scope="col" colspan="2"> <p class="h4 display-4 text-center font-weight-light" style="font-size: 40px">비밀번호 변경</p></th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                      <td class="table-light " scope="row" class="table-active"><p class=" text-center">변경할 비밀번호 :</p></td>
                      <td class="table-light " scope="row" class="table-active">   <p class="text-center">  <input class="form-control" type="password" id="new_pw" name="new_pw" placeholder="비밀번호를 입력해주세요"></p></td>
                  </tr>
                  <tr>
                      <td class="table-light " scope="row" class="table-active"><p class=" text-center">비밀번호 재입력 :</p></td>
                      <td class="table-light " scope="row" class="table-active"> <p class="text-center"><input class="form-control" type="password" id="re_pw" name="re_pw" placeholder="비밀번호를 재입력해주세요"></p></td>
                  </tr>
                  </tbody>
              </table>

              <div class="row">
                  <div class="col">
                      <p class="text-center"> <span id="resultPw"></span></p>
                  </div>
              </div>
              <div class="row">
                  <div class="col">
                      <p class="text-center"> <input class="btn btn-primary" type="button" value="비밀번호변경" onclick="editPw()"></p>
                  </div>
              </div>



          </div>


        </div>
    </div>

</form>










<jsp:include page="../comm/footer.jsp"/>