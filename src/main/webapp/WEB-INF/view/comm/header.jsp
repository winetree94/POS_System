<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script type="text/javascript" src="/src/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="/src/js/bootstrap-4.1.3.js"></script>
    <script type="text/javascript" src="/src/js/script.js"></script>
    <link rel="stylesheet" href="/src/css/bootstrap-4.1.3.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link rel="stylesheet" href="/src/css/style.css">

</head>
<body>

<c:if test="${(user.service_id)!=null}">

    <div class="headerWrap">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div style="width:1080px;margin:0 auto">
                <a class="navbar-brand">POS SYSTEM</a>

                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">

                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/">홈</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/board">게시판</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/stores">대시보드 </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/account/${user.service_id}"> ${user.service_id}</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/account/logout">로그아웃 </a>
                        </li>

                    </ul>

                </div>
            </div>
        </nav>

    </div>
</c:if>

<c:if test="${(user.service_id)==null}">

    <div class="headerWrap">
        <nav class="navbar navbar-expand-lg navbar-light bg-light" style="width:76%;margin:0 auto">

            <%--<div style="width:1080px;margin:0 auto">--%>

                <a class="navbar-brand">POS SYSTEM</a>

                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left:56%">

                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/">홈</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/board">게시판</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/account">로그인 </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/account/signupform">회원가입 </a>
                        </li>
                    </ul>
                </div>
            <%--</div>--%>
        </nav>
    </div>
</c:if>
</body>
</html>