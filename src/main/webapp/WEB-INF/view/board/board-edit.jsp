<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>

<%
    //Service_Board_DTO board-edit = request.getAttribute("board_list");
    Object obj = request.getAttribute("board_edit");
    Service_Board_DTO board_edit = (Service_Board_DTO) obj;
%>

<h2>board-edit</h2>
<script type="text/javascript">
    var form_action = "/board/<%=board_edit.getBoard_seq()%>/edit"; // form 의 action 위치
    var form_class = ""; // form 의 클래스 선언
    var form_method = "post"; // form request 방식
    var form_enctype = "multipart/form-data"; // form 의 enctype 방식
    var use_file = true; // 파일 업로드 기능 사용 여부

    <% if(request.getAttribute("board_edit") != null){ %>
        var content = "<%=board_edit.getContent()%>";
        var writer = "<%=board_edit.getService_id()%>";
        var title = "<%=board_edit.getTitle()%>";
    <% } %>

</script>

<jsp:include page="../util/editor.jsp"/>

<script>

        document.querySelector("#editor-form").innerHTML += "<input onclick=\"back()\" value=\"취소\"type=\"button\"/>"

        function back(){
            history.back();
        }

        var read = document.querySelector(".writer");
        read.readOnly = true;

        var inputObj = document.getElementsByTagName("input");

        for(var i = 0; i < inputObj.length; i++) {
          inputObj[i].removeAttribute("placeholder");
        };

</script>