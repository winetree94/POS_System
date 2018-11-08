package com.pos.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Service_Comm_Ctrl {
	
	@RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST})
	public String error(){
		return "./view/comm/error";
	}
}
