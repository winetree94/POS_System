package com.pos.system.controller;

import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.service.IService_Store_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class Store_POS_Ctrl {
	
	private final IService_Store_Service service_Store;
	
	@Autowired
	public Store_POS_Ctrl(IService_Store_Service service_Store) {
		this.service_Store = service_Store;
	}
	
	@GetMapping("/pos")
	public String home(
		HttpServletRequest request,
		HttpServletResponse response,
		HttpSession session
	) {
		Service_Account_DTO user = (Service_Account_DTO) session.getAttribute("user");
		String store_seq = request.getParameter("store_seq");
		
		Service_Store_DTO store = service_Store.selectStore(Integer.parseInt(store_seq));
		
		session.setAttribute("store", store);
		
		return "redirect:/pos/" + store_seq;
	}
	
	@GetMapping("/pos/{store_seq}")
	public String getPos(
		@PathVariable("store_seq") String store_seq,
		HttpServletRequest request,
		HttpServletResponse response,
		HttpSession session
	) {
		
		Service_Store_DTO store = (Service_Store_DTO) session.getAttribute("store");
		Service_Account_DTO user = (Service_Account_DTO) session.getAttribute("user");
		
		if (
				Integer.parseInt(store_seq) == store.getStore_seq() &&
				store.getService_id().equalsIgnoreCase(user.getService_id())
		) {
			System.out.println("수정됨");
			return "/index.html";
		} else {
			return "redirect:/errorpage";
		}
	}
	
}
