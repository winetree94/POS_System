<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>

<div class="jumbotron">
    <div class="container">
        <h1 class="display-4 text-center">비밀번호 찾기</h1>
    </div>
</div>

<div class='container' style="max-width: 500px">

                <form method="post">

                    <div class="form-group">
                        <label for="inputemail">이메일</label>
                            <input class="form-control" type="text" id="inputemail" name="inputemail" required="required" placeholder="이메일 주소">
                        <p class="p-2"><span id="pwfindresult"></span></p>
                    </div>


                    <div class="form-group">

                        <input class="btn btn-primary" style="display: none" type="button" value="확인" id="pwfindconfirm" onclick="history.go(-1);"/>
                        <input class="btn btn-primary" style="display: inline" type="button" value="이메일로 비밀번호 전송" id="pwfind" onclick="pwFind()"/>
                            <button id="cancel2" class="btn btn-primary" style="display: inline" type="button" onclick="history.go(-1);">Cancel</button>
                    </div>
                </form>


        </div>





<jsp:include page="../comm/footer.jsp"/>