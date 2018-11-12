package com.pos.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.pos.system.dto.Service_Board_DTO;
import com.pos.system.dto.Service_File_DTO;
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

	
	@GetMapping("/new")
	public String upload(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			MultipartFile image
			) {
		
		return "./view/board/board-new";
	}
	
	
	/**
	 * 게시판 목록 출력
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@GetMapping("")
	public String board_List(HttpServletRequest request, HttpServletResponse response, HttpSession session){
	
		//String service_id = (String) session.getAttribute("id"); service_id 필요성에 의문20181110
		List<Service_Board_DTO> board_list = service.selectAllBoard();
		request.setAttribute("board_list", board_list);
	
	
	
	return "./view/board/board-list";
	}
	
	@GetMapping("write")
	public String insertBoard() {
		return "./view/board/insertBoard";
	}
	
}
