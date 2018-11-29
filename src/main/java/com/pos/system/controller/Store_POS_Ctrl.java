package com.pos.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.service.IService_Store_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/pos")
@Controller
public class Store_POS_Ctrl {
	
	private final IService_Store_Service service_Store;
	
	@Autowired
	public Store_POS_Ctrl(IService_Store_Service service_Store) {
		this.service_Store = service_Store;
	}
	
	@PostMapping("")
	public String getPOS(
		HttpServletRequest request,
		HttpSession session
	) {
		String store_seq = request.getParameter("store_seq");
		
		Service_Store_DTO store = service_Store.selectStore(Integer.parseInt(store_seq));
		
		session.removeAttribute("store");
		session.setAttribute("store", store);
		
		return "redirect:/pos";
	}
	
	@RequestMapping(value = {"", "/sale"})
	public String goPOS(
		HttpServletRequest request,
		HttpSession session
	) {
		return "/pos/index.html";
	}
	
}
