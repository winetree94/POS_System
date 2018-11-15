<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script type="text/javascript" src="./src/js/script.js"></script>
<link rel="stylesheet" href="./src/css/style.css">
<div>
<div id="main">
	<h1>POS SYSTEM</h1>
</div>
<c:if test="${(user.service_id)!=null}">

		<nav id="header">
			<ul>
				<li>
					<a href="./">홈</a>
				</li>

				<li>
					<a href="./board">게시판</a>
				</li>

				<li>
					<a href="./stores">대시보드 </a>
				</li>

				<li>
					<a href="./account/${user.service_id}"> ${user.service_id}</a>
				</li>
				
				<li>
					<a href="./account/logout">로그아웃 </a>
				</li>

			</ul>
		</nav>
	</div>
</c:if>

<c:if test="${(user.service_id)==null}">

	<nav>
		<ul>
			<li>
				<a href="./">홈</a>
			</li>

			<li>
				<a href="./board">게시판</a>
			</li>

			<li>
				<a href="./stores">로그인 </a>
			</li>

			<li>
				<a href="./account/signupform">회원가입 </a>
			</li>

		</ul>
	</nav>
	</div>
</c:if>

