

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