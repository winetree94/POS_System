<%@ page import="com.pos.system.dto.Service_Store_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>
<%

	Service_Store_DTO store = (Service_Store_DTO) request.getAttribute("store");

%>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1 class="display-3 text-center"><%=store != null ? "수정할 내용을 입력하세요." : "새로운 매장을 생성합니다."%>
		</h1>
	</div>
</div>

<div class="container">
	<form action="<%=store!=null?"/stores/"+store.getStore_seq():"/stores"%>" method="post">
		<div class="form-group">
			<label for="store_name">매장의 이름을 입력하세요.</label>
			<input id="store_name" class="form-control" type="text" name="store_name" placeholder="예) 슈퍼자장면"
			       value="<%=store!=null?store.getStore_name():""%>" <%=store!=null?"readonly":""%>>
			<small class="form-text text-muted">고객이 처음 마주하게될 매장의 이름입니다. 이후 변경할 수 없습니다.</small>
		</div>

		<div class="form-group">
			<label for="store_detail">매장의 설명을 입력하세요.</label>
			<input id="store_detail" class="form-control" type="text" name="store_detail"
			       value="<%=store!=null?store.getStore_detail():""%>"
			       placeholder="예) 저희 매장은 30년 전통의 수타 자장면 전문점입니다.....">
		</div>
		<div class="form-group">
			<label for="store_type">업종을 입력하세요.</label>
			<input id="store_type" class="form-control" type="text" name="store_type" placeholder="예) 중화요리 전문점"
			       value="<%=store!=null?store.getStore_type():""%>">
		</div>
		<div class="form-group">
			<label for="store_address">매장의 주소를 입력하세요.</label>
			<input type="text" class="form-control" id="store_address" name="store_address"
			       value="<%=store!=null?store.getStore_address():""%>"
			       placeholder="예) 경기도 부천시 범안로 96번길 23, ....">
		</div>

		<div class="form-group">
			<label for="store_tel">매장의 전화번호를 입력하세요.</label>
			<input id="store_tel" class="form-control" type="text" name="store_tel" placeholder="예) 0000-00000-0000"
			       value="<%=store!=null?store.getStore_tel():""%>">
		</div>

		<div class="form-group">
			<label for="store_hour">영업시간을 입력하세요.</label>
			<input id="store_hour" class="form-control" type="text" name="store_hour" placeholder="예) 오전 9:00 ~ 오후 9:00 연중무휴"
			       value="<%=store!=null?store.getStore_hour():""%>">
		</div>
		<button type="submit" class="btn btn-primary">확인</button>
		<button type="button" class="btn btn-secondary">취소</button>
		<% if (store != null) { %>
		<button type="button" class="btn btn-danger" onclick="deleteStore()">삭제</button>
		<script defer type="text/javascript">
			function deleteStore() {
				var form = document.forms[0];
				form.action = "/stores/<%=store.getStore_seq()%>/delete";
				form.submit();
			}
		</script>
		<% } %>
	</form>
</div>

<jsp:include page="../comm/footer.jsp"/>