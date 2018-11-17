<%@ page import="java.util.List" %>
<%@ page import="com.pos.system.dto.Service_Store_DTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>
<%
	List<Service_Store_DTO> stores_list = (List<Service_Store_DTO>)request.getAttribute("stores_list");
%>
<h2>store list</h2>

<% for (int i = 0; i < stores_list.size(); i++) { %>
	<li><%=stores_list.get(i)%></li>
<% } %>

<jsp:include page="../comm/footer.jsp"/>