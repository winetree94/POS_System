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

		var idchk = document.querySelector("#idchk").value;
		var emailchk = document.querySelector("#emailchk").value;

		if (service_pw != passOk) {
			alert("회원가입 오류 비밀번호를 확인해주세요");
			return false;
		} else if (chk == "0") {			//화면에서 다 긁어오면 text 이다
			alert("회원가입 오류 아이디 중복 체크를 해주세요");
			return false;
		} else if (idchk != "true" || emailchk != "true") {
			return false;
		} else if (grecaptcha.getResponse() == ""){ alert("리캡챠를 체크해야 합니다."); return false; } else { return true; }

	}

	var btn = false;

	$(document).ready(function () {
		$("#service_email").keyup(function () {
			$("#resultemail").html("");
			var service_email = "";
			service_email = $(this).val();

			if (service_email == '' || service_email == 'undefined') {
				$("#resultemail").text('이메일 주소를 입력해주세요');
                document.querySelector("#emailchk").value = "false";
                document.querySelector("#email_auth").style = "display : none";
                document.querySelector("#auth_key").style = "display : none";
                document.querySelector("#auth_confirm").style = "display : none";
                document.querySelector("#auth_result").style = "display : none";
                document.querySelector("#reEmail1").style = "display : none";

                return;
			}

			// valid check
			if (!email_check(service_email)) {
				$("#resultemail").text('부적합한 이메일 주소 양식입니다.');
				document.querySelector("#emailchk").value = "false";
                document.querySelector("#email_auth").style = "display : none";
                document.querySelector("#auth_key").style = "display : none";
                document.querySelector("#auth_confirm").style = "display : none";
                document.querySelector("#auth_result").style = "display : none";
                document.querySelector("#reEmail1").style = "display : none";

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
                            document.querySelector("#email_auth").style = "display : inline";
                            document.querySelector("#auth_key").style = "display : block";
                            document.querySelector("#auth_confirm").style = "display : block";
                            document.querySelector("#auth_result").style = "display : block";
                            document.querySelector("#reEmail1").style = "display : inline";


                        } else {
							$("#resultemail").text('중복된 이메일 주소입니다.');
							console.log("failed");
							document.querySelector("#emailchk").value = "false";
                            document.querySelector("#email_auth").style = "display : none";
                            document.querySelector("#auth_key").style = "display : none";
                            document.querySelector("#auth_confirm").style = "display : none";
                            document.querySelector("#auth_result").style = "display : none";
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



        $("#service_pw").keyup(function () {
            var inputLength = $(this).val().length;
            $("#pass_result").html("");
// 		alert(inputLength);
            var service_pw = "";
            service_pw = $(this).val();

            //이미 while문처럼 돌아가서 while을 쓰면 안된다.
            //그래서 while을 쓰면은 무한루프처럼 돌아간다. 그래서 if로 벗어나는 코드 작성
            //공백이면은 -1 이 나온다

            if(inputLength<8) {
                $("#pass_result").html("비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요.");

                return false;

            }



            if(!service_pw.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-])|([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])/)) {
                    $("#pass_result").html("비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요");


                return false;

            }

            $("#pass_result").html("올바른 비밀번호입니다.");


            return true;

        });













    });
</script>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1 class="display-4 text-center">회원가입</h1>
	</div>
</div>


<div class="container" style="max-width: 500px;">
	<form action="/account/register" method="post" id="frm" onsubmit="return check()">
		<div id="centerinfo">
			<input type="hidden" id="chkval" value="0">

			<div class="form-group">
				<label for="service_id">사용할 아이디를 입력하세요.</label>
				<input class="form-control" type="text" id="service_id" name="service_id" placeholder="아이디"
				       required="required">

				<input type="hidden" id="idchk" value="false">
				<p class="p-2" id="result"></p>
			</div>

			<div class="form-group">
				<label for="service_email">이메일을 입력하세요.</label>
				<input class="form-control" type="text" id="service_email" name="service_email" placeholder="이메일"
				       required="required">
				<input type="hidden" id="emailchk" value="false">
			</div>
			<div class="form-group">
				<p class="p-2" id="resultemail"></p>
				<p><input  id="email_auth" name="email_auth" class="btn btn-primary btn-center" type="button" value="이메일 인증"
					   onclick="sendEmail()" style="display: none" />
					<input  id="reEmail1" name="email_auth" class="btn btn-primary btn-center" type="button" value="이메일 재입력"
							onclick="reTypeEmail()" style="display: none" />
				</p>

			</div>
			<div class="form-group">
				<input class="form-control" type="text" id="auth_key" name="auth_key" placeholder="인증번호"
					   required="required" style="display: none">
				</div>
				<div class="form-group">
				<p><input class="btn btn-primary btn-center" id="auth_confirm" name="auth_confirm" type="button" value="인증확인"
						  onclick="confirmAuth()" style="display: none"/></p>
				<p class="p-2" id="auth_result" name="auth_result" style="display: none"></p>
			</div>


			<div class="form-group">
				<label for="service_pw">비밀번호를 입력하세요.</label>
				<input class="form-control" type="password" id="service_pw" name="service_pw" placeholder="비밀번호"
				       required="required">
				<p class="p-2" id="pass_result" name="pass_result"></p>
				<input class="form-control" id="passOk" type="password" required="required"
				       placeholder="비밀번호 확인"/>

			</div>

			<div class="form-group">
				<p class="p-2">* 만 14세 미만은 법정대리인의 동의 후에 회원 서비스 이용이 가능합니다. 약관과 개인정보 수집에 대해서 확인하였으며 이에 동의하십니까?</p>
			</div>

		</div>


		<div class="g-recaptcha form-group"
		     data-sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI">
		</div>

		<div id="button" class="form-group">
			<input class="btn btn-success" type="submit" value="동의하고 회원가입"/>
			<input class="btn btn-primary btn-center" type="button" value="돌아가기"
			       onclick="javascript:history.back(-1);"/>
		</div>


	</form>
</div>

<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<jsp:include page="../comm/footer.jsp"/>
