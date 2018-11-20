<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="com.pos.system.dto.Service_File_DTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>

<%
    //Service_Board_DTO board-edit = request.getAttribute("board_list");
    Object obj = request.getAttribute("board_edit");
    Service_Board_DTO board_edit = (Service_Board_DTO) obj;
    Object objF = request.getAttribute("file_edit");
    Service_File_DTO file_edit = (Service_File_DTO)objF;
    System.out.println(file_edit);
%>

<h2>board-edit</h2>
<script type="text/javascript">
    var form_action = "/board/<%=board_edit.getBoard_seq()%>/edit"; // form 의 action 위치
    var form_class = ""; // form 의 클래스 선언
    var form_method = "post"; // form request 방식
    var form_enctype = "multipart/form-data"; // form 의 enctype 방식
    var use_file = true; // 파일 업로드 기능 사용 여부


    //게시글 수정 시 수정전 내용, 제목, 아이디 값 받기
    <% if(request.getAttribute("board_edit") != null){ %>
        var content = "<%=board_edit.getContent()%>";
        var writer = "<%=board_edit.getService_id()%>";
        var title = "<%=board_edit.getTitle()%>";
    <% } %>

    <% if (request.getAttribute("file_edit") != null){ %>
        var file = "<%=file_edit.getOrigin_fname()%>";
    <%
        }
    %>
    console.log(file);
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