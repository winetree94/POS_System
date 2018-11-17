<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>
<script type="text/javascript">
    var frm = document.forms[0];

    function check() {
        var service_pw = document.getElementById("service_pw").value;
        var passOk = document.getElementById("passOk").value;
// 	alert(pw + ":::" + passOk);
        var chk = document.getElementById("chkval").value;		//아이디 검수 중복// 유효값

        var idchk =  document.querySelector("#idchk").value;
        var emailchk = document.querySelector("#emailchk").value;

        if (service_pw != passOk) {
            alert("회원가입 오류 비밀번호를 확인해주세요");
            return false;
        } else if (chk == "0") {			//화면에서 다 긁어오면 text 이다
            alert("회원가입 오류 아이디 중복 체크를 해주세요");
            return false;
        } else if (idchk != "true" || emailchk != "true"){
            return false;
        } else {
            return true;
        }

    }

    var btn = false;

    $(document).ready(function () {
        $("#service_email").keyup(function () {
            $("#resultemail").html("");
            var service_email = "";
            service_email = $(this).val();

            if (service_email == '' || service_email == 'undefined') {
                $("#resultemail").text('이메일 주소를 입력해주세요');
                return;
            }

            // valid check
            if (!email_check(service_email)) {
                $("#resultemail").text('부적합한 이메일 주소 양식입니다.');
                document.querySelector("#emailchk").value = "false";
                service_email.focus();
                return false;
            }
            else {
                $.ajax({
                    type: 'POST',
                    url: "/account/emailduplicate",
                    data: "service_email=" + service_email,
                    success: function (msg) {
                        console.log(msg);
                        if (msg == "가능") {
                            $("#resultemail").text('가능한 이메일 주소입니다.');
                            console.log("success");
                            document.querySelector("#emailchk").value = "true";
                        } else {
                            $("#resultemail").text('중복된 이메일 주소입니다.');
                            console.log("failed");
                            document.querySelector("#emailchk").value = "false";
                        }


                    }


                });
            }


        });


        $("#service_id").keyup(function () {
            var inputLength = $(this).val().length;
            $("#result").html("");
// 		alert(inputLength);
            var service_id = "";
            service_id = $(this).val();

            //이미 while문처럼 돌아가서 while을 쓰면 안된다.
            //그래서 while을 쓰면은 무한루프처럼 돌아간다. 그래서 if로 벗어나는 코드 작성
            //공백이면은 -1 이 나온다


            if (service_id.indexOf(" ") != -1) {
                $("#result").css("color", "red");
                $("#result").html("공백이 포함된 아이디는 사용할 수 없습니다.");

                document.getElementById("chkval").value = 0;

            } else if (inputLength >= 5) {
                $.ajax({
                    type: "post",
                    url: "/account/idduplicate",
                    data: "service_id=" + $(this).val(),
                    //비동기식을 걸어주면 좋다. 동기식을 입력하면은
                    //다른 정보들이 들어올 때 까지 기다려야한다.
                    async: true,
                    success: function (msg) {
                        console.log(msg);
                        $("#result").html(msg);
                        if (msg == "사용가능한 아이디") {
                            console.log("사용가능한 아이디");
// 						alert("확인");
                            //chkval 은 이중체크를 하기 위한 변수.
//						1이면은 아이디와 중복검사가 다 됨
                            document.getElementById("chkval").value = "1";
                            $("#result").css("color", "blue");
                            document.querySelector("#idchk").value = "true";
                        } else {
                            document.getElementById("chkval").value = "0";
                            $("#result").css("color", "red");
                            document.querySelector("#idchk").value = "false";
                        }
                    }
                });
            } else {
                //5자리 전까지는 ajax 처리 나머지는 java에서 처리 해서 속도가 빠르다.
                $("#result").css("color", "red");
                $("#result").html("다섯자 이상만 사용가능합니다.");
                document.getElementById("chkval").value = "0";
                document.querySelector("#idchk").value = "false";
            }
        });
    });
</script>
<body>
<h2>회원가입 페이지</h2>
<div id="container">

    <!-- 이번에는 onsubmit -->
    <input type="hidden" id="chkval" value="0">

    <form action="/account/register" method="post" id="frm" onsubmit="return check()">
        <div id="info">
            <div id="leftinfo">정보입력</div>

            <div id="centerinfo">
                <input type="text" id="service_id" name="service_id" placeholder="아이디" required="required"><br/>
                <input type="hidden" id="idchk" value="false">
                <span id="result"></span><br/>
                <input type="text" id="service_email" name="service_email" placeholder="이메일" required="required"> <br/>
                <input type="hidden" id="emailchk" value="false">
                <span id="resultemail"></span><br/>
                <input type="password" id="service_pw" name="service_pw" placeholder="비밀번호" required="required">

                <div>
                    <input id="passOk" type="password" required="required"
                           placeholder="비밀번호 확인"/>
                </div>

            </div>
            <div id="rightinfo"></div>
        </div>        <!-- id="info" -->

        <div id="line"></div>


        <div id="bottom">        <!-- 약관사항 넣을 것 -->
            <br>
            *만 14세 미만은 법정대리인의 동의 후에 회원 서비스 이용이 가능합니다.<br>

            <strong id="bottomstrong">
                약관과 개인정보 수집에 대해서 확인하였으며 이에 동의하십니까?
            </strong><br>

            <div id="button">
                <input class="btn btn-success" type="submit" value="동의하고 회원가입"/>
                <input class="btn btn-sm btn-primary btn-center" type="button" value="돌아가기"
                       onclick="javascript:history.back(-1);"/>
            </div>

        </div>

    </form>
</div>

<jsp:include page="../comm/footer.jsp"/>
