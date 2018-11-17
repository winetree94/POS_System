package com.pos.system.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pos.system.dto.Service_File_DTO;
import com.pos.system.service.IService_File_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.pos.system.dto.Service_Board_DTO;
import com.pos.system.mapper.*;
import com.pos.system.service.IService_Board_Service;

@RequestMapping("/board")
@Controller
public class Service_Board_Ctrl {

    private final IService_Board_Service service;




    @Autowired
    public Service_Board_Ctrl(IService_Board_Service service) {
        this.service = service;
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
        List<Service_Board_DTO> board_list = (List<Service_Board_DTO>) service.selectAllBoard();
        request.setAttribute("board_list", board_list);

        return "./view/board/board-list";
    }


    /**
     *
     * @return
     */
    @GetMapping("/new")
    public String uploadForm(
    ) {
        return "./view/board/board-new";
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
            @RequestParam("file") MultipartFile file
    ) {
        session.setAttribute("id", "winetree"); // for test

        String writer = (String)session.getAttribute("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Service_Board_DTO dto = new Service_Board_DTO();
        //Service_File_DTO fdto = new Service_File_DTO();

        dto.setService_id(writer);
        dto.setTitle(title);
        dto.setContent(content);

        service.insertBoard(dto);

        int seq = service.selectRecentBoard();
        System.out.println(seq);



        if(!file.isEmpty()) {
            //String filename = file.getOriginalFilename();

//            System.out.println(filename);
        }

        return "redirect:/board";
    }


    /**
     * 특정 글 상세 조회 기능
     * @param board_seq / 게시글 고유 번호
     * @param request
     * @param response
     * @param session
     * @param file
     * @return
     */
    @GetMapping("/{board_seq}")
    public String boardDetail(
            @PathVariable("board_seq") String board_seq,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            MultipartFile file
    ){

        Service_Board_DTO board_detail;
        board_detail = service.selectOneBoard(Integer.parseInt(board_seq));

        request.setAttribute("board_detail", board_detail);

        System.out.println(board_seq);

        return "./view/board/board-detail";
    }


    /**
     * 특정 게시글 삭제
     * @param board_seq
     * @param request
     * @param response
     * @param session
     * @param file
     * @return
     */
    @PostMapping("/{board_seq}/delete")
    public String boardDelete(
            @PathVariable("board_seq") String board_seq,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            MultipartFile file
    ){
        int board_delete = service.deleteOneBoard(Integer.parseInt(board_seq));

        if (board_delete == 0){
            System.out.println("no");
        }else{
            System.out.println("성공");
        }
        request.setAttribute("board_delete",board_delete);


        return "redirect:/board";
    }


    /**
     * 게시글 수정 GetMapping
     * @param board_seq
     * @param request
     * @param response
     * @param session
     * @param file
     * @return
     */
    @GetMapping("/{board_seq}/edit")
    public String boardEditForm(
            @PathVariable("board_seq") String board_seq,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            MultipartFile file){

        Service_Board_DTO board_edit = service.selectOneBoard(Integer.parseInt(board_seq));

        request.setAttribute("board_edit",board_edit);

        return "./view/board/board-edit";
    }

    /**
     * 게시글 수정 PostMapping
     * @param board_seq
     * @param request
     * @param response
     * @param session
     * @param file
     * @return
     */
    @PostMapping("/{board_seq}/edit")
    public String boardEdit(
            @PathVariable("board_seq") String board_seq,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            MultipartFile file
    ){

        Service_Board_DTO dto = service.selectOneBoard(Integer.parseInt(board_seq));

        session.setAttribute("id", "winetree"); // for test

        String writer = (String)session.getAttribute("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        dto.setService_id(writer);
        dto.setTitle(title);
        dto.setContent(content);


        int result = service.modifyBoard(dto);

        if (result > 0){
            return "redirect:/board";
        }else{
            return "./view/comm/error";
        }


    }



}
