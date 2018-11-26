package com.pos.system.restcontroller;

import com.pos.system.dto.Store_Order_DTO;
import com.pos.system.service.IStore_Order_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
	 * @param store_seq / 매장 고유 번호
	 * @param make / 생산 여부
	 * @param ref / 주문 묶음 고유 번호
	 * @param delflag / 삭제 여부
	 * @return
	 */
	@GetMapping("/{store_seq}/order")
	public List<Store_Order_DTO> orderList(
		@PathVariable("store_seq") String store_seq,
		@RequestParam(value = "make", required = false) String make,
		@RequestParam(value = "ref", required = false) String ref,
		@RequestParam(value = "delflag", required = false) String delflag
	) {
		Store_Order_DTO dto = new Store_Order_DTO();
		dto.setStore_seq(Integer.parseInt(store_seq));
		
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
	 * @param store_seq / 매장 고유번호
	 * @param table_seq / 테이블 고유번호
	 * @param menu_seq / 메뉴의 고유번호
	 * @param ref / 주문의 묶음 고유번호
	 * @return
	 */
	@PostMapping("/{store_seq}/order")
	public int addOrder(
		@PathVariable("store_seq") String store_seq,
		@RequestParam("table_seq") String table_seq,
		@RequestParam("menu_seq") String menu_seq,
		@RequestParam(value = "ref", required = false) String ref
	) {
		Store_Order_DTO dto = new Store_Order_DTO();
		dto.setStore_seq(Integer.parseInt(store_seq));
		dto.setTable_seq(Integer.parseInt(table_seq));
		dto.setMenu_seq(Integer.parseInt(menu_seq));
		
		if(ref != null) {
			dto.setRef(ref);
		}
		return service.addOrder(dto);
	}
	
	/**
	 * 주문 세부정보 반환
	 * @param store_seq / 매장 고유 번호
	 * @param order_seq / 주문 고유 번호
	 * @return Store_Order_DTO
	 */
	@GetMapping("/{store_seq}/order/{order_seq}")
	public Store_Order_DTO orderDetail(
		@PathVariable("store_seq") String store_seq,
		@PathVariable("order_seq") String order_seq
	){
		return service.orderOne(Integer.parseInt(order_seq));
	}
	
	/**
	 * 주문 삭제 메소드
	 * @param order_seq / 주문 고유 번호
	 * @return
	 */
	@PostMapping("/{store_seq}/order/{order_seq}")
	public int orderUpdate(
		@PathVariable("order_seq") String order_seq
	){
		return service.deleteOrder(Integer.parseInt(order_seq));
	}
	
}
