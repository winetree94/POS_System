package com.pos.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pos.system.dto.Service_Board_DTO;
import com.pos.system.mapper.Service_Board_Check_Mapper;
import com.pos.system.mapper.Service_Board_Delete_Mapper;

@Controller
public class Service_Board_Ctrl {
	
	@Autowired
	private Service_Board_Delete_Mapper mapper;
	
	@GetMapping("/board")
	public String home() {
		int list = 0;
	//	List<Service_Board_DTO> lists = mapper.selectNotice("Q");
		list = mapper.delteOneBoard(1);
//		
		System.out.println(list);
		
		return "./board/boardlist";
	}
	
}
