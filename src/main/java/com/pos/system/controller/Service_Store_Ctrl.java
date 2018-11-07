package com.pos.system.controller;

import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.mapper.Service_Store_Read_Mapper;
import com.pos.system.mapper.Service_Store_Create_Mapper;
import com.pos.system.mapper.Service_Store_Update_Mapper;
import com.pos.system.service.IService_Store_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Service_Store_Ctrl {

	IService_Store_Service service;
	
	@GetMapping("/store")
	public String store_List(){
		System.out.println("----------------------------------------한솔이테스트---------------------------------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("----------------------------------------한솔이테스트---------------------------------------------");
		return "./store/store-list";
	}
	
}