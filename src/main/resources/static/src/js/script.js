

window.onload = function() {
	console.log("Hello World!");
}


function loginForm(){
 var frm = document.forms[0];
 frm.action = './account';
 frm.submit();
}

function boardList(){
    var frm = document.forms[0];
    frm.action = './board';
    frm.submit();
}

function dashboard() {
    var frm = document.forms[0];
    frm.action = './stores';
    frm.submit();
}

function modifyAccount() {
    var frm = document.forms[0];
    frm.action = './'+ service_id +'/pwpage';
    frm.submit();
}

function pwCheck(){
    var frm = document.forms[0];
    var service_pw = document.getElementById("inputPw").value;
    frm.action='./edit';
    if(service_pw==null || service_pw=="") {
        alert("비밀번호를 입력해주세요");
    } else {
        $.ajax({
           type:'POST',
            url:'./passwordcheck',
            data:"service_pw="+service_pw,
            success: function(msg){
                var result= msg;
               if(result=="성공"){
                   frm.submit();
               }else{
                   alert("비밀번호를 다시 확인해주세요");
               }
            }
        });

    }
}

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
                //alert(msg);

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
                    //alert(temp1);
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


function editEmail(){
    var frm = document.forms[0];
    var service_email = document.getElementById("inputEmail").value;
    var no_text = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
    frm.action='./edit';

    if(no_text.test(inputEmail)==false){
        alert("이 메일형식이 올바르지 않습니다.");
        document.addjoin.inputEmail.focus();
        return false;
    }

}