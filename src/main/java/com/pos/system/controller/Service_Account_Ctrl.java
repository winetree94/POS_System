package com.pos.system.controller;

import com.pos.system.service.IService_Account_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Service_Account_Ctrl {
	
	private IService_Account_Service service;
	
	public Service_Account_Ctrl(IService_Account_Service service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public String home() {
		
		System.out.println(service.selectAll());
		
		return "index";
	}

}
