package com.pos.system.controller;

import com.pos.system.dao.IService_Account_DAO;
import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.mapper.Service_Account_Login_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Service_Account_Ctrl {
	
	private final IService_Account_DAO service_Account_Dao;
	private final Service_Account_Login_Mapper mapper;

	@Autowired
	public Service_Account_Ctrl(IService_Account_DAO service_Account_Dao, Service_Account_Login_Mapper mapper) {
		this.service_Account_Dao = service_Account_Dao;
		this.mapper = mapper;
	}
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public String home() {
		Service_Account_DTO dto = new Service_Account_DTO();
		dto.setService_id("hansol");
		dto.setService_email("1234@naver.com");
		dto.setService_pw("1234");

		
		System.out.println(service_Account_Dao.selectAll());
		System.out.println(mapper.signUp(dto));

		return "index";
	}

}
