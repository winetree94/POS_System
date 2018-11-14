<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>




<c:if test="${(user.service_id)!=null}">
		<div>
			<ul>
				<li>
					<a href="./board">게시판</a>
				</li>

				<li>
					<a href="./stores">대시보드 </a>
				</li>

				<li>
					<a href="./account/${user.service_id}"> ${user.service_id}님의 회원정보</a>
				</li>
				
				<li>
					<a href="./account/logout">로그아웃 </a>
				</li>

			</ul>
		</div>
</c:if>

<c:if test="${(user.service_id)==null}">
	<div>
		<ul>
			<li>
				<a href="./board">게시판</a>
			</li>

			<li>
				<a href="./stores">로그인 </a>
			</li>
		</ul>
	</div>
</c:if>


