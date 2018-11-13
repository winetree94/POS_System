package com.pos.system.restcontroller;

import com.pos.system.dto.Store_Order_DTO;
import com.pos.system.service.IStore_Order_Service;
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
public class Store_Order_Rest_Ctrl {
	
	private final IStore_Order_Service service;
	
	@Autowired
	public Store_Order_Rest_Ctrl(IStore_Order_Service service) {
		this.service = service;
	}
	
	@GetMapping("/{store_seq}/order")
	public String test(
		@PathVariable("store_seq") String store_seq
	){
		System.out.println("start");
		
		Store_Order_DTO dto = new Store_Order_DTO();
		
		// 매장번호 url번 테이블 번호 1번의 신규 테이블에서 메뉴 1번 주문
		dto.setStore_seq(Integer.parseInt(store_seq));
		dto.setTable_seq(1);
		dto.setMenu_seq(1);
		
		System.out.println(dto.getRef());
		
		service.addOrder(dto);
		
		Store_Order_DTO dto2 = new Store_Order_DTO();
		
		dto2.setStore_seq(1);
		dto2.setMake("N");
		dto2.setRef("1");
		
		List<Store_Order_DTO> lists = service.orderListAll(dto2);
		
		System.out.println(lists);
		
		return "good";
	}
	
}
