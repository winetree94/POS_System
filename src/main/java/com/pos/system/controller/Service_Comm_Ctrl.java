package com.pos.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class Service_Comm_Ctrl {
	
	
	@GetMapping("/")
	public String home(HttpSession session){
		System.out.println("index 리다이렉트");
		
		// 개발용 세션 저장
		session.setAttribute("id", "winetree");
		
		return "/WEB-INF/index.jsp";
	}
	
	@GetMapping("/errorpage")
	public String errorPage(){
		System.out.println("error 페이지 redirect");
		
		return "/WEB-INF/view/comm/error.jsp";
	}
}
