package com.pos.system.controller;


import com.pos.system.dao.IService_Account_DAO;
import com.pos.system.mapper.Service_Account_Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.pos.system.service.IService_Account_Service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Service_Account_Ctrl {


	private final IService_Account_DAO service_Account_Dao;
	private final Service_Account_Mapper mapper;

	@Autowired
	public Service_Account_Ctrl(IService_Account_DAO service_Account_Dao, Service_Account_Mapper mapper) {
		this.service_Account_Dao = service_Account_Dao;
		this.mapper = mapper;
	}

	private IService_Account_Service service;
	
	public Service_Account_Ctrl(IService_Account_Service service) {
		this.service = service;

	}
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public String home() {
		

		System.out.println(mapper.selectAll());
		System.out.println(service_Account_Dao.selectAll());
		System.out.println(mapper.idDuplicate("Alan"));

		System.out.println(service.selectAll());
		
		return "index";
	}

}
