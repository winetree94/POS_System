package com.pos.system.restcontroller;

import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.dto.Store_Order_DTO;
import com.pos.system.service.IStore_Order_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Store_Order_Rest_Ctrl {
	
	private final IStore_Order_Service service;
	
	@Autowired
	public Store_Order_Rest_Ctrl(IStore_Order_Service service) {
		this.service = service;
	}
	
	/**
	 * 매장의 주문정보 전체 반환
	 *
	 * @param /       매장 고유 번호
	 * @param make    / 생산 여부
	 * @param ref     / 주문 묶음 고유 번호
	 * @param delflag / 삭제 여부
	 * @return
	 */
	@GetMapping("/order")
	public List<Store_Order_DTO> orderList(
		HttpSession session,
		@RequestParam(value = "make", required = false) String make,
		@RequestParam(value = "ref", required = false) String ref,
		@RequestParam(value = "delflag", required = false) String delflag
	) {
		Service_Store_DTO store = (Service_Store_DTO) session.getAttribute("store");
		Store_Order_DTO dto = new Store_Order_DTO();
		dto.setStore_seq(store.getStore_seq());
		
		if (make != null) {
			dto.setMake(make);
		}
		if (ref != null) {
			dto.setRef(ref);
		}
		if (delflag != null) {
			dto.setDelflag(delflag);
		}
		
		return service.orderListAll(dto);
	}
	
	/**
	 * 매장 주문 등록
	 * ref가 null 이면 새로운 테이블의 첫 주문으로 인식함
	 * 추가 주문일 경우 ref를 테이블의 ref 값으로 넣을 것
	 *
	 * @param table_seq / 테이블 고유번호
	 * @param menu_seq  / 메뉴의 고유번호
	 * @param ref       / 주문의 묶음 고유번호
	 * @return
	 */
	@PostMapping("/order")
	public int addOrder(
		HttpSession session,
		@RequestParam("table_seq") String table_seq,
		@RequestParam("menu_seq") String menu_seq,
		@RequestParam(value = "ref", required = false) int ref
	) {
		Service_Store_DTO store = (Service_Store_DTO) session.getAttribute("store");
		
		System.out.println(store.getStore_seq() + " / " + table_seq + " / " + menu_seq + " / " + ref);
		
		Store_Order_DTO dto = new Store_Order_DTO();
		
		dto.setStore_seq(store.getStore_seq());
		dto.setTable_seq(Integer.parseInt(table_seq));
		dto.setMenu_seq(Integer.parseInt(menu_seq));
		
		if (ref != 0) {
			dto.setRef(String.valueOf(ref));
		}
		return service.addOrder(dto);
	}
	
	/**
	 * @return Store_Order_DTOΩ
	 */
	@GetMapping("/order/{table_seq}")
	public List<HashMap<String, Object>> orderDetail(
		HttpSession session,
		@PathVariable("table_seq") int table_seq
	) {
		Service_Store_DTO store = (Service_Store_DTO) session.getAttribute("store");
		return service.getTableOrder(store.getStore_seq(), table_seq);
	}
	
	@GetMapping("/order/{table_seq}/ref")
	public HashMap<String, Object> getLastRef(
		@PathVariable("table_seq") String table_seq,
		HttpSession session
	) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Service_Store_DTO store = (Service_Store_DTO) session.getAttribute("store");
		
		map.put("table_seq", table_seq);
		map.put("store_seq", store.getStore_seq());
		
		return service.getRef(map);
	}
	
	;
	
	/**
	 * 주문 삭제 메소드
	 *
	 * @param / 주문 고유 번호
	 * @return
	 */
	@DeleteMapping("/order/{table_seq}/{menu_seq}")
	public int orderUpdate(
		HttpSession session,
		@PathVariable("table_seq") int table_seq,
		@PathVariable("menu_seq") int menu_seq
	) {
		System.out.println("table_seq : " + table_seq + "menu_seq : " + menu_seq);
		return service.deleteOrder(table_seq, menu_seq);
	}
	
}
