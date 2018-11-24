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
                        <h3>아이디 찾기</h3>
                    </div>
                    <div>
                        <p>
                            <label>Email</label>
                            <input type="text" id="email" name="email" required="required">
                        </p>
                     <span id="idfindresult"></span>

                        <p>
                         <input type="button" value="아이디찾기" id="idfind" onclick="idFind()">
                            <button type="button" onclick="history.go(-1);">Cancel</button>
                        </p>
                    </div>
                </form>
            </div>

        </div>





<jsp:include page="../comm/footer.jsp"/>