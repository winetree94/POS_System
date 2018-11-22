package com.pos.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class Store_POS_Ctrl {
	
	@GetMapping("/pos")
	public String home(
		HttpServletRequest request,
		HttpServletResponse response,
		HttpSession session
	) {
		
		System.out.println("pos connected");
		return "index.html";
	}
	

}
