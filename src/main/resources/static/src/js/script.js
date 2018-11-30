

window.onload = function() {
    console.log("Hello World!");
}


function loginForm(){
    var frm = document.forms[0];
    frm.action = '/account';
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

function idFindForm() {
    var frm = document.forms[1];
    frm.action = '/account/idfindform';
    frm.submit();
}

function pwFindForm(){
    var frm = document.forms[1];
    frm.action = '/account/pwfindform';
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



// email check function
function email_check( service_email ) {
    var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    return (service_email != '' && service_email != 'undefined' && regex.test(service_email));
}

function idFind(){
    var service_email = document.getElementById("email").value;

    $.ajax({
        type: 'POST' ,
        url: "/account/idfind",
        data: "service_email=" + service_email,
        success: function(msg) {
            console.log(msg);
            if(msg=="실패"){
                $("#idfindresult").text('아이디가 없습니다. 이메일을 다시 확인해주세요');

            }else{
                document.querySelector("#idfindconfirm").style = "display : inline";
                document.querySelector("#idfind").style = "display : none";
                document.querySelector("#cancel").style = "display : none";
                $("#idfindresult").text(" 찾으시는 아이디 : "+ msg);


            }


        }


    });


}
function pwFind(){
    var service_email = document.getElementById("inputemail").value;
    var frm = document.forms[0];
    document.getElementById("pwfind").onclick=null;

    $.ajax({
        type:"post",
        url:"/email/pwfindcheck",
        data:"service_email="+service_email,
        async:true,
        success: function(msg){
            if(msg=="없음") {

                $("#pwfindresult").text('선택하신 이메일이 존재하지 않습니다');
                document.getElementById("pwfind").onclick=pwFind;
            }else if ("성공"){
                $("#pwfindresult").text('선택하신 이메일로 새로운 비밀번호를 보냈습니다');
                document.querySelector("#pwfindconfirm").style ="display : inline";
                document.querySelector("#pwfind").style ="display : none";
                document.querySelector("#cancel2").style ="display : none";


            }else{
                $("#pwfindresult").text('이메일 전송이 실패했습니다. 다시 확인해주세요.');
                document.getElementById("pwfind").onclick=pwFind;
            }
        }
    });

}






// check when email input lost foucus
function editEmailDuplicate() {
    var service_email = document.getElementById("service_email").value;


    if (service_email == '' || service_email == 'undefined') {
        $("#result").text('이메일 주소를 입력해주세요');
        return;
    }

    // valid check
    if (!email_check(service_email)) {
        $("#result").text('부적합한 이메일 주소 양식입니다.');
        return false;
    }
    else {

        $.ajax({
            type: 'POST' ,
            url: "/account/emailduplicate",
            data: "service_email=" + service_email,
            success: function(msg) {
                console.log(msg);
                if(msg=="가능"){
                    $("#result").text('사용가능한 이메일 주소입니다.');
                    document.querySelector("#email_auth2").style = "display : inline";
                    document.querySelector("#emailDupBtn").style = "display : none";
                    document.querySelector("#service_email").setAttribute("readonly", "readonly");
                    document.querySelector("#reEmail").style = "display : inline";

                }else{
                    $("#result").text('중복된 이메일 주소입니다.');

                }


            }


        });
    }
}

function editSendEmail(){
    var service_email = document.getElementById("service_email").value;
    document.getElementById("email_auth2").onclick = null;
    $("#result").text('이메일로 인증번호를 보내는 중입니다.');
    document.querySelector("#reEmail").style = "display : none";
    $.ajax({
        type:"post",
        url:"/email/sendemail",
        data:"service_email="+service_email,
        async:true,
        success: function(msg){
            $("#result").text('이메일로 인증번호를 보냈습니다. 확인해주세요');
            document.querySelector("#email_auth2").style = "display : none";
            document.querySelector("#auth_key2").style = "display : block";
            document.querySelector("#auth_confirm2").style = "display : inline";
            document.querySelector("#email_auth2").setAttribute("onclick","false");
            document.querySelector("#email_auth2").removeAttribute("onclick");
            document.querySelector("#reEmail").style = "display : none";


            // document.querySelector("#email_auth").style = "display : none";

        }
    });
};

function editReEmail(){
    document.querySelector("#service_email").removeAttribute("readonly");
    document.querySelector("#emailDupBtn").style = "display : inline";
    document.querySelector("#reEmail").style = "display : none";
    document.querySelector("#email_auth2").style = "display : none";

}

function reTypeEmail(){
    document.querySelector("#service_email").value="";
    document.querySelector("#service_email").removeAttribute("readonly");
    document.querySelector("#emailchk").value = "false";
    document.querySelector("#email_auth").style = "display : none";
    document.querySelector("#auth_key").style = "display : none";
    document.querySelector("#auth_confirm").style = "display : none";
    document.querySelector("#auth_result").style = "display : none";
    document.querySelector("#reEmail1").style = "display : none";
    $("#resultemail").text('이메일 주소를 다시 입력해주세요');


}




function editConfirmAuth(){
    var auth_key = document.getElementById("auth_key2").value;
    var service_email = document.getElementById("service_email").value;
    var frm = document.forms[0];
    frm.action = './edit/email';
    $.ajax({
        type:"post",
        url:"/email/confirmemail",
        data:"auth_key="+auth_key+"&"+"service_email="+service_email,

        async:true,
        success: function(msg){
            if(msg=="실패"){
                $("#result").text('인증실패, 다시 시도해주세요.');
            }else {
                frm.submit();

            }
        }

    });
}





function editPw() {
    var service_pw = document.getElementById("new_pw").value;
    var re_pw = document.getElementById("re_pw").value;
    var frm = document.forms[0];


    if (service_pw != re_pw) {
        $("#resultPw").text('입력한 비밀번호가 맞지 않습니다');
    } else if (service_pw == "" || re_pw == "" || service_pw == "" && re_pw == "") {
        $("#resultPw").text('비밀번호를 입력해주세요');

        return
    } else {
        frm.action = './edit/pw';
        frm.submit();

    }
}


function sendEmail(){
    var service_email = document.getElementById("service_email").value;
    document.querySelector("#service_email").setAttribute("readonly", "readonly");
    document.getElementById("email_auth").onclick = null;
    document.getElementById("reEmail1").onclick = null;
    document.querySelector("#reEmail1").style = "display : none";
    $("#resultemail").text('이메일로 인증키를 보내는 중입니다.');

    $.ajax({
        type:"post",
        url:"/email/sendemail",
        data:"service_email="+service_email,
        async:true,
        success: function(msg){
            $("#resultemail").text('이메일 보냈어요 확인해주세요');
            document.querySelector("#email_auth").setAttribute("onclick","false");

            document.querySelector("#email_auth").removeAttribute("onclick");

            // document.querySelector("#email_auth").style = "display : none";

        }
    });
};

function confirmAuth(){
    var auth_key = document.getElementById("auth_key").value;
    var service_email = document.getElementById("service_email").value;
    $.ajax({
        type:"post",
        url:"/email/confirmemail",
        data:"auth_key="+auth_key+"&"+"service_email="+service_email,

        async:true,
        success: function(msg){
            if(msg=="실패"){
                $("#auth_result").text('인증실패, 다시 시도해주세요.');
            }else {
                $("#auth_result").text('인증완료');
                document.querySelector("#auth_key").setAttribute("readonly", "readonly");
                document.querySelector("#auth_confirm").removeAttribute("onclick");

            }
        }

    });
}






