package com.pos.system.controller;

import com.pos.system.dao.Service_Account_DAO;
import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.mapper.Service_Account_Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String home(Model model) {
		System.out.println("Controller");

		List<Service_Account_DTO> lists;
		lists = service_Account_Dao.selectAll();
		lists = mapper.selectAll();
		System.out.println(lists);

		model.addAttribute("lists", lists);

		return "index";
	}

}
