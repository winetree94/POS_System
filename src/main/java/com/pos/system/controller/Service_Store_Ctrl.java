package com.pos.system.controller;

import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.mapper.Service_Store_Check_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Service_Store_Ctrl {
	
	private Service_Store_Check_Mapper mapper;
	
	@Autowired
	public Service_Store_Ctrl(Service_Store_Check_Mapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/store")
	public String store_List(){
		
		System.out.println("--------한솔이테스트---------");
		
		List<Service_Store_DTO> lists = mapper.selectAllStore("winetree");
		
		System.out.println(lists);
		
		return "./store/store-list";
	}
	
}