<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <script type="text/javascript" src="/src/js/script.js"></script>
    <script type="text/javascript" src="/src/js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="/src/css/style.css">


</head>
<script type="text/javascript">
    function check() {
        var service_pw = document.getElementById("service_pw").value;
        var passOk = document.getElementById("passOk").value;
// 	alert(pw + ":::" + passOk);
        var frm = document.forms[0];
        var chk = document.getElementById("chkval").value;		//아이디 검수 중복// 유효값

        if(service_pw != passOk) {
            alert("회원가입 오류 비밀번호를 확인해주세요");
            return false;
        } else if(chk=="0") {			//화면에서 다 긁어오면 text 이다
            alert("회원가입 오류 아이디 중복 체크를 해주세요");
            return false;
        } else {
            return true;
        }

    }



    $(document).ready(function(){
        $("#service_id").keyup(function(){
            var inputLength = $(this).val().length;
            $("#result").html("");
            var service_id = "";
            service_id = $(this).val();


            //공백이면은 -1 이 나온다
            if(service_id.indexOf(" ")!=-1) {
                $("#result").css("color","red");
                $("#result").html("공백이 포함된 아이디는 사용할 수 없습니다.");

                document.getElementById("chkval").value=0;

            } else if(inputLength >= 5) {
// 			alert("agkgalkengkolraen");
                $.ajax({
                    type: "post",
                    url: "/account/idduplicate",
                    data: "service_id="+$(this).val(),
                    //비동기식을 걸어주면 좋다. 동기식을 입력하면은
                    //다른 정보들이 들어올 때 까지 기다려야한다.
                    async:true,
                    success:function(msg) {
                        console.log(msg);
                        $("#result").html(msg);
                        if(msg == "사용가능한 아이디") {
                            console.log("사용가능한 아이디");
// 						alert("확인");
                            //chkval 은 이중체크를 하기 위한 변수.
//						1이면은 아이디와 중복검사가 다 됨
                            document.getElementById("chkval").value = "1";
                            $("#result").css("color", "blue");
                        } else {
                            document.getElementById("chkval").value = "0";
                            $("#result").css("color", "red");
                        }
                    }
                });
            } else {
                //5자리 전까지는 ajax 처리 나머지는 java에서 처리 해서 속도가 빠르다.
                $("#result").css("color", "red");
                $("#result").html("다섯자 이상만 사용가능합니다.");
                document.getElementById("chkval").value = "0";
            }
        });
    });
</script>
<body>
<h1>SIGNUP</h1>
<div id="container">


    <input type="hidden" id="chkval" value="0">

    <form action="/account/register" method="post" id="frm" onsubmit="return check()">
        <div id="info">
            <div id="leftinfo"></div>

            <div id="centerinfo">
                <input type="text" id="service_email" name="service_email" placeholder="이메일" required="required"> <br/>
                <input type="text" id="service_id" name="service_id" placeholder="아이디" required="required"><br/>

                <span id="result"></span><br/>
                <input type="password" id="service_pw"name="service_pw" placeholder="비밀번호" required="required">

                <div>
                    <input id="passOk" type="password" required="required"
                           placeholder="비밀번호 확인" />
                </div>

            </div>
            <div id="rightinfo"></div>
        </div> 		<!-- id="info" -->

        <div id="line"></div>


        <div id="bottom">
            <br>
            *만 14세 미만은 법정대리인의 동의 후에 회원 서비스 이용이 가능합니다.<br>
            *동의하지 않으시면 뒤로가기 눌러주세요<br>
            <strong id="bottomstrong">
                약관과 개인정보 수집에 대해서 확인하였으며 이에 동의하십니까?
            </strong><br>

            <div id="button">
                <input class="btn btn-success" type="submit" value="동의하고 회원가입"/>
                <input class="btn btn-sm btn-primary btn-center" type="button" value="돌아가기" onclick="javascript:history.back(-1);"/>
            </div>

        </div>

    </form>
</div>
</body>

</body>
</html>