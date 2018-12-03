package com.pos.system.restcontroller;

import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.dto.Store_Cashbook_DTO;
import com.pos.system.service.IStore_Cashbook_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Store_Cashbook_Rest_Ctrl {

	private final IStore_Cashbook_Service service;

	@Autowired
	public Store_Cashbook_Rest_Ctrl(IStore_Cashbook_Service service) {
		this.service = service;
	}

	@GetMapping("/cashbook")
	public List<Store_Cashbook_DTO> cashbook(
			HttpSession session
	) {
		Service_Store_DTO store = (Service_Store_DTO) session.getAttribute("store");
		return service.selectCashbook(store.getStore_seq());
	}

	@PostMapping("/cashbook")
	public List<Store_Cashbook_DTO> cashbookInsert(
			HttpSession session,
			@RequestParam("cash_deposit") String cash_deposit
	){
		Service_Store_DTO store = (Service_Store_DTO) session.getAttribute("store");
		Store_Cashbook_DTO dto = new Store_Cashbook_DTO();
		dto.setStore_seq(store.getStore_seq());
		dto.setCash_deposit(Integer.parseInt(cash_deposit));
		return service.insertCashbook(dto);
	}
	
	@GetMapping("/cashbook/day")
	public List<HashMap<String, Object>> getDayCal(
		HttpSession session
	) {
		Service_Store_DTO store = (Service_Store_DTO) session.getAttribute("store");
		return service.getDayCal(String.valueOf(store.getStore_seq()));
	}

}