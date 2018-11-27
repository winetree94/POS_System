<%@ page import="java.util.List" %>
<%@ page import="com.pos.system.dto.Service_Store_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>

<%
	List<Service_Store_DTO> stores_list = (List<Service_Store_DTO>) request.getAttribute("stores_list");
%>

<div class="jumbotron">
	<div class="container">
		<h1 class="display-4 text-center">대시보드</h1>
		<a class="btn btn-primary" href="/stores/new">매장 생성하기</a>
	</div>
</div>
<div class="container">
	<div class="row">
		<% for (int i = 1; i < stores_list.size() + 1; i++) { %>
		<div class="col-sm">
			<div class="card bg-light mb-3">
				<div class="card-header"><%=stores_list.get(i - 1).getStore_name()%>
				</div>
				<div class="card-body">
					<p class="card-text"><%=stores_list.get(i - 1).getStore_detail()%>
					</p>

					<form id="id" action="/pos" method="post">
						<div class="form-group">
							<input type="hidden" name="store_seq" value="<%=stores_list.get(i - 1).getStore_seq()%>">
							<input class="btn btn-primary btn-sm" type="submit" value="접속">
						</div>
					</form>
							<a href="/stores/<%=stores_list.get(i - 1).getStore_seq()%>/edit" class="btn btn-secondary btn-sm">수정</a>

				</div>
			</div>
		</div>
		<% if (i % 3 == 0) { %>
	</div>
	<div class="row">
		<% } %>
		<% } %>
	</div>

<jsp:include page="../comm/footer.jsp"/>