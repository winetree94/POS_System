package com.pos.system.restcontroller;

import com.pos.system.dto.Store_Cashbook_DTO;
import com.pos.system.service.IStore_Cashbook_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/pos")
public class Store_Cashbook_Rest_Ctrl {
	
	private final IStore_Cashbook_Service service;
	
	@Autowired
	public Store_Cashbook_Rest_Ctrl(IStore_Cashbook_Service service) {
		this.service = service;
	}
	
	@GetMapping("/{store_seq}/cashbook")
	public String test(
		HttpServletRequest request,
		HttpServletResponse response,
		HttpSession session,
		@PathVariable("store_seq") String store_seq
	) {
		
		Store_Cashbook_DTO dto = new Store_Cashbook_DTO();
		
		dto.setCash_deposit(3000);
		dto.setStore_seq(Integer.parseInt(store_seq));
		
		System.out.println(dto);
		
		service.insertCashbook(dto);
		List<Store_Cashbook_DTO> lists = service.selectCashbook(Integer.parseInt(store_seq));
		
		System.out.println(lists);
		
		return null;
	}
	
	
}
