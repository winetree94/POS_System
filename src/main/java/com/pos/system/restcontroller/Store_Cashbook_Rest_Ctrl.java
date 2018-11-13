package com.pos.system.restcontroller;

import com.pos.system.dto.Store_Cashbook_DTO;
import com.pos.system.service.IStore_Cashbook_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
	
	@PostMapping("/{store_seq}/cashbook")
	public List<Store_Cashbook_DTO> cashbookInsert(
		@PathVariable("store_seq") String store_seq,
		@RequestParam("cash_deposit") String cash_deposit
	){
		Store_Cashbook_DTO dto = new Store_Cashbook_DTO();
		dto.setStore_seq(Integer.parseInt(store_seq));
		dto.setCash_deposit(Integer.parseInt(cash_deposit));
		return service.insertCashbook(dto);
	}
	
}
