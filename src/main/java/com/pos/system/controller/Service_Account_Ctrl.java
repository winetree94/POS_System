package com.pos.system.controller;

import com.pos.system.dao.IService_Account_DAO;
import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.service.IService_Account_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Service_Account_Ctrl {
	
	private final IService_Account_DAO service_Account_Dao;
	private final IService_Account_Service service_Account_Service;

	@Autowired
	public Service_Account_Ctrl(IService_Account_DAO service_Account_Dao, IService_Account_Service service_Account_Service) {
		this.service_Account_Dao = service_Account_Dao;
		this.service_Account_Service = service_Account_Service;
	}

	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public String home() {
		Service_Account_DTO dto2 = new Service_Account_DTO();
		dto2.setService_id("3321123");
		dto2.setService_email("2j2@naver.com");
		dto2.setService_pw("4321");
		System.out.println(service_Account_Service.signUp(dto2));
		System.out.println(service_Account_Service.idDuplicate("Alan"));
		System.out.println(service_Account_Service.login(dto2));
		System.out.println(service_Account_Service.selectAll());
		System.out.println(service_Account_Service.modify(dto2));
		System.out.println(service_Account_Service.resign(dto2));
		
		return "index";
	}

}
