

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
