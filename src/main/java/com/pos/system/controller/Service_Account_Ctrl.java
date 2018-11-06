package com.pos.system.controller;

import com.pos.system.dao.Service_Account_DAO;
import com.pos.system.mapper.Service_Account_Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Service_Account_Ctrl {
	
	private final Service_Account_DAO service_Account_Dao;
	private final Service_Account_Mapper mapper;
	
	public Service_Account_Ctrl(Service_Account_DAO service_Account_Dao, Service_Account_Mapper mapper) {
		this.service_Account_Dao = service_Account_Dao;
		this.mapper = mapper;
	}
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public String home() {
		
		System.out.println(mapper.selectAll());
		System.out.println(service_Account_Dao.selectAll());
		
		return "index";
	}

}