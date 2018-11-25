<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>

<div class="jumbotron">
    <div class="container">
        <h1 class="display-4 text-center">아이디 찾기</h1>
    </div>
</div>

<div class='container' style="max-width: 500px">



           <div>
                <form method="post">
                    <div >
                        <h3>비밀번호 찾기</h3>
                    </div>
                    <div>

                            <label>Email</label>
                            <input type="text" id="inputemail" name="inputemail" required="required">
                        </p>
                     <span id="pwfindresult"></span>

                        <p>
                         <input type="button" value="이메일로 비밀번호 전송." id="pwfind" onclick="pwFind()">
                            <button type="button" onclick="history.go(-1);">Cancel</button>
                        </p>
                    </div>
                </form>
            </div>

        </div>





<jsp:include page="../comm/footer.jsp"/>