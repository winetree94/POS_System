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
    <script type="text/javascript" src="/src/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="./src/js/script.js"></script>
    <link rel="stylesheet" href="./src/css/style.css">


</head>
<style type="text/css">
    a{
        text-decoration: none;
    }

</style>

<script type="text/javascript">
    function signUp() {
        var frm = document.forms[1];
        frm.action = '/account/signupform';
        frm.submit();
    }

    //로그인을 ajax를 통해 처리함
    function loginCheck() {
        var service_id = document.getElementById("inputId").value;//$("#inputId").val()과 똑같다.
        var service_pw = document.getElementById("inputPw").value;
  	//alert(service_id+":"+service_pw);
// 	alert($("#inputId").val() + ":" + $("#inputPw").val());

        var frm = document.forms[0];
        frm.action = "/account";

        var result = "";

        //버튼으로 ajax처리하고 넘김
        if(service_id==null || service_id=="") {
            alert("로그인 아이디를 입력해주세요");
        } else if(service_pw==null || service_pw=="") {
            alert("로그인 비밀번호를 입력해주세요");
        } else {

            $.ajax({

                type:"POST",
                url: "/account/logincheck",
                data: "service_id="+service_id+"&"+"service_pw="+service_pw,
                success: function(msg) {
 				alert(msg);

                    var temp = "";
                    var temp1 = "";
                    temp = msg;
                    temp1 = msg;

                    //성공, 실패 단어들만 가지고 나옴
                    temp = temp.slice(0,2);
                    result = temp;

                    //성공이라는 단어만 잘라낸다
// 				alert(result);

                    if(result=="성공") {
// 					alert("성공");
                        temp1 = temp1.split("/")[1];
                        alert(temp1);
                        document.getElementById("loginChk").value = temp1;
                        frm.submit();

                    } else {
                        alert("로그인 실패: 아이디나 비밀번호를 확인해주세요");
                    }

                }
            });
        }
    }

    function idSearch() {
        alert( '준비중입니다.');
    }

    function pwSearch() {
        alert( '준비중입니다.');
    }

</script>

<body>
<h1>POS LOG-IN PAGE </h1>
<!-- ajax -->
<!-- ajax처리떄문에 one quotation으로 처리해준다. -->
<div id='container'>

    <div id='title'>POS 로그인 페이지</div>
    <div id='id'>아이디</div>

    <form method='post' id='frm'>
        <input type='hidden' id='loginChk' name='service_type' value='0'/>
        <input type='text' name='service_id' id='inputId' required='required'>
        <br/>
        <div id='pw'>비밀번호</div>

        <input type='password' name='service_pw' id='inputPw' required='required'>
        <br/>
        <input type='button' id='login' name='login' value='로그인' onclick='loginCheck()'/>
        <br/>

        <div id='bottom'>

            <a href='#' onclick='signUp()'>
                <input type='button' id='SignUp' name='signup' value='회원가입'/>
            </a>


        </div>

    </form>

    <form method="get">
    <input type='button' id='SearchId' name='SearchId' value='FIND ID' onclick='idSearch()' />
    <input type='button' id='SearchPw' name='SearchPw' value='FIND PW' onclick='pwSearch()' />
    </form>

</div>


</body>
</html>