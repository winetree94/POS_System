package com.pos.system.restcontroller;

import com.pos.system.dto.Store_Cashbook_DTO;
import com.pos.system.service.IStore_Cashbook_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	public List<Store_Cashbook_DTO> cashbook(
		@PathVariable("store_seq") String store_seq
	) {
		return service.selectCashbook(Integer.parseInt(store_seq));
	}
	
	
}
