package com.pos.system.restcontroller;

import com.pos.system.dto.Store_Invoice_DTO;
import com.pos.system.service.IStore_Invoice_Service;
import com.pos.system.service.IStore_Order_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pos")
public class Store_Invoice_Rest_Ctrl {
	
	private final IStore_Order_Service service_Order;
	private final IStore_Invoice_Service service_Invoice;
	
	@Autowired
	public Store_Invoice_Rest_Ctrl(IStore_Order_Service service_Order, IStore_Invoice_Service service_Invoice) {
		this.service_Order = service_Order;
		this.service_Invoice = service_Invoice;
	}
	
	@GetMapping("/{store_seq}/invoice")
	public String test(){
		return "hello world";
	}
	
	
	/**
	 * 영수증 출력 기능
	 * @param store_seq / 매장 고유 번호
	 * @param table_seq /
	 * @param discount_amount
	 * @param ref
	 * @return
	 */
	@PostMapping("/{store_seq}/invoice")
	public int payment(
		@PathVariable("store_seq") String store_seq,
		@RequestParam("table_seq") String table_seq,
		@RequestParam(value = "discount_amount", required = false) String discount_amount,
		@RequestParam("ref") String ref
	){
		int sumorder = service_Order.sumOrder(Integer.parseInt(ref));
		
		Store_Invoice_DTO dto = new Store_Invoice_DTO();
		
		dto.setStore_seq(Integer.parseInt(store_seq));
		dto.setTable_seq(Integer.parseInt(table_seq));
		dto.setRef(Integer.parseInt(ref));
		dto.setSumorder(sumorder);
		dto.setDiscount_amount(Integer.parseInt(discount_amount));

		return service_Invoice.payment(dto);
	}

}
