package com.pos.system.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pos.system.dto.Service_File_DTO;
import com.pos.system.service.IService_File_Service;
import com.pos.system.util.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.pos.system.dto.Service_Board_DTO;
import com.pos.system.service.IService_Board_Service;

@RequestMapping("/board")
@Controller
public class Service_Board_Ctrl {

    private final IService_Board_Service service_Board;
    private final IService_File_Service service_File;
    private final FileManager fileManager;

    @Autowired
    public Service_Board_Ctrl(IService_Board_Service service_Board, IService_File_Service service_File, FileManager fileManager) {
        this.service_Board = service_Board;
        this.service_File = service_File;
        this.fileManager = fileManager;
    }

    /**
     * 게시판 목록 출력
     *
     * @param request
     * @param response
     * @param session
     * @return
     */
    @GetMapping("")
    public String board_List(HttpServletRequest request, HttpServletResponse response, HttpSession session, MultipartFile image) {
        //String service_id = (String) session.getAttribute("id"); service_id 필요성에 의문20181110
        List<Service_Board_DTO> board_list = (List<Service_Board_DTO>) service_Board.selectAllBoard();
        request.setAttribute("board_list", board_list);

        return "/WEB-INF/view/board/board-list.jsp";
    }


    /**
     *
     * @return
     */
    @GetMapping("/new")
    public String uploadForm(
    ) {
        return "/WEB-INF/view/board/board-new.jsp";
    }


    /**
     * 새글 등록 기능
     * @param request
     * @param response
     * @param session
     * @param
     * @return
     */
    @PostMapping("")
    public String upload(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            MultipartFile file
    ) {
        session.setAttribute("id", "winetree"); // for test

        String writer = (String)session.getAttribute("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Service_Board_DTO dto = new Service_Board_DTO();


        dto.setService_id(writer);
        dto.setTitle(title);
        dto.setContent(content);

        service_Board.insertBoard(dto);

        int seq = service_Board.selectRecentBoard();

        if(!file.isEmpty()) {

            //test 절대경로
            fileManager.upload(file);

            //상대경로 사용시
//            fileManager.upload(file,request);

        }

        return "redirect:/board";
    }


    /**
     * 특정 글 상세 조회 기능
     * @param seq/ 게시글 고유 번호
     * @param request
     * @param response
     * @param session
     * @return
     */
    @GetMapping("/{board_seq}")
    public String boardDetail(
            @PathVariable("board_seq") String seq,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            MultipartFile file

    ){
        Service_Board_DTO board_detail;

        int board_seq = Integer.parseInt(seq);

        board_detail = service_Board.selectOneBoard(board_seq);

        request.setAttribute("board_detail", board_detail);

        Service_File_DTO file_dto;
        file_dto = service_File.selectOneFile(board_seq);

        if (file_dto!=null){
            Service_File_DTO fileDto = service_File.selectOneFile(board_seq);

            request.setAttribute("fileDto",fileDto);

            System.out.println(file_dto);

        }

        return "/WEB-INF/view/board/board-detail.jsp";
    }


    /**
     * 특정 게시글 삭제
     * @param seq
     * @param request
     * @param response
     * @param session
     * @param file
     * @return
     */
    @PostMapping("/{board_seq}/delete")
    public String boardDelete(
            @PathVariable("board_seq") String seq,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            MultipartFile file
    ){

        int board_seq = Integer.parseInt(seq);
        int board_delete = service_Board.deleteOneBoard(board_seq);

        request.setAttribute("board_delete",board_delete);

        if (board_delete == 0){
            System.out.println("no");
        }else{
            System.out.println("게시글 삭제 성공");

            Service_File_DTO fileDto = service_File.selectOneFile(board_seq);

            if (fileDto != null){

                service_File.deleteFile(board_seq);
                System.out.println("파일 삭제 성공");

            }

        }


        return "redirect:/board";
    }


    /**
     * 게시글 수정 GetMapping
     * @param seq
     * @param request
     * @param response
     * @param session
     * @return
     */
    @GetMapping("/{board_seq}/edit")
    public String boardEditForm(
            @PathVariable("board_seq") String seq,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            MultipartFile file
            ){

        int board_seq = Integer.parseInt(seq);

        Service_Board_DTO board_edit = service_Board.selectOneBoard(board_seq);


        Service_File_DTO file_edit = service_File.selectOneFile(board_seq);

        request.setAttribute("board_edit",board_edit);

        if (file_edit != null){

            request.setAttribute("file_edit", file_edit);

            System.out.println(file_edit.getOrigin_fname());
        }
        return "/WEB-INF/view/board/board-edit.jsp";
    }

    /**
     * 게시글 수정 PostMapping
     * @param seq
     * @param request
     * @param response
     * @param session
     * @param file
     * @return
     */
    @PostMapping("/{board_seq}/edit")
    public String boardEdit(
            @PathVariable("board_seq") String seq,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            MultipartFile file
    ){

        int board_seq = Integer.parseInt(seq);
        Service_Board_DTO dto = service_Board.selectOneBoard(board_seq);

        session.setAttribute("id", "winetree"); // for test

        String writer = (String)session.getAttribute("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        dto.setService_id(writer);
        dto.setTitle(title);
        dto.setContent(content);


        int result = service_Board.modifyBoard(dto);

        if (!file.isEmpty()){

            fileManager.fileEdit(file,board_seq);

        }

        if (result > 0){



            return "redirect:/board";
        }else{
            return "/WEB-INF/view/comm/error.jsp";
        }


    }


    /**
     * 파일 다운로드 기능
     * @param seq
     * @param request
     * @param response
     * @param session
     * @param file
     * @return
     */
    @PostMapping("/{board_seq}/download")
    public String download(
            @PathVariable("board_seq") String seq,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            MultipartFile file){

        int board_seq = Integer.parseInt(seq);

        response = fileManager.download(board_seq, response);

        return "";
    }



}
