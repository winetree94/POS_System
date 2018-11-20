<%@ page import="com.pos.system.dto.Service_Board_DTO" %>
<%@ page import="com.pos.system.dto.Service_File_DTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <%response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>

    <%
        //Service_Board_DTO board_detail = request.getAttribute("board_list");
        Object obj = request.getAttribute("board_detail");
        Object objF = request.getAttribute("fileDto");
        Service_Board_DTO board_detail = (Service_Board_DTO)obj;
        Service_File_DTO fileDto = (Service_File_DTO)objF;

    %>
		<h2>board-detail</h2>
        <table border="1">
            <tr>
                <td>글번호</td>
                <td>작성자</td>
                <td>제목</td>
                <td>내용</td>
                <td>작성일</td>
                <td>조회수</td>
                <td>파일</td>
            </tr>
                <tr>
                    <td>${board_detail.getBoard_seq()}</td>
                    <td>${board_detail.getService_id()}</td>
                    <td>${board_detail.getTitle()}</td>
                    <td>${board_detail.getContent()}</td>
                    <td>${board_detail.getRegdate()}</td>
                    <td>${board_detail.getReadcount()}</td>
                    <td><%
                        if (fileDto != null){
                            %>
                        <%=fileDto.getOrigin_fname()%>
                        <form action="./${board_detail.board_seq}/download" method="POST" id="fileChk" enctype="multipart/form-data">
                            <%--<input type="button" onclick="editFile()" value="파일수정">--%>
                            <%--<input type="button" onclick="delFile()" value="파일삭제">--%>
                            <input type="submit" value="다운로드">
                        </form>
                        <script type="text/javascript">

                            <%--function editFile(){--%>
                                <%--var editF = document.querySelector("#fileChk")--%>
                                <%--editF.action =  "./${board_detail.board_seq}/edit/file";--%>
                                <%--editF.method = ""--%>
                            <%--}--%>

                        </script>

                            <%
                        }else{
                            %>
                            첨부파일 없음
                        <%
                        }
                            %>
                    </td>
                </tr>

        </table>

        <form action="" method="" id="boardChk">
            <input type="button" onclick="edit()" value="수정"/>
            <input type="button" onclick="del()" value="삭제"/>
            <input type="button" onclick="back()" value="뒤로가기">

        </form>

        <script type="text/javascript">

           function edit(){

               // var edit = document.forms[0];
               var edit = document.querySelector("#boardChk");
               edit.action = "./${board_detail.board_seq}/edit";
               edit.method = "get";
               edit.submit();



           }
           function del(){
               var del = document.querySelector("#boardChk");
               del.action = "./${board_detail.board_seq}/delete";
               del.method = "post";
               del.submit();
               //alert("del");

           }

           function back(){
               history.back();
           }



        </script>
	</body>
</html>