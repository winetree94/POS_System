package com.pos.system.controller;

import com.pos.system.dao.Service_Account_DAO;
import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.mapper.Service_Account_Mapper;
import com.pos.system.test.Dummy_Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class Service_Controller {
	
	private final Service_Account_DAO service_Account_Dao;
	private final Service_Account_Mapper mapper;
	
	public Service_Controller(Service_Account_DAO service_Account_Dao, Service_Account_Mapper mapper) {
		this.service_Account_Dao = service_Account_Dao;
		this.mapper = mapper;
	}
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public String home() {
		return "index";
	}

}
