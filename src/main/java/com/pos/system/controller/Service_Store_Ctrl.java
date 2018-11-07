package com.pos.system.controller;

import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.mapper.Service_Store_Read_Mapper;
import com.pos.system.mapper.Service_Store_Create_Mapper;
import com.pos.system.mapper.Service_Store_Update_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Service_Store_Ctrl {
	
	private final Service_Store_Read_Mapper mapper;
	private final Service_Store_Update_Mapper mapperm;
	private final Service_Store_Create_Mapper mapperc;
	
	@Autowired
	public Service_Store_Ctrl(Service_Store_Read_Mapper mapper, Service_Store_Update_Mapper mapperm, Service_Store_Create_Mapper mapperc) {
		this.mapper = mapper;
		this.mapperm = mapperm;
		this.mapperc = mapperc;
	}
	
	@GetMapping("/store")
	public String store_List(){
		
		System.out.println("--------한솔이테스트---------");
		
		List<Service_Store_DTO> lists01 = mapper.selectAllStore("winetree");
		List<Service_Store_DTO> lists02 = mapper.selectAllStoreAdmin();
		Service_Store_DTO dto01 = mapper.selectOneStore(1);

		int n = mapperm.updateStoreInfo(dto01);
		int n2 = mapperc.createStore(dto01);
		
		System.out.println(lists01);
		System.out.println(lists02);
		System.out.println(dto01);
		System.out.println(n);
		System.out.println(n2);
		
		return "./store/store-list";
	}
	
}