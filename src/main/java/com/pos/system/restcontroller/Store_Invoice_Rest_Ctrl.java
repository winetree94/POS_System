package com.pos.system.restcontroller;

import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.dto.Store_Invoice_DTO;
import com.pos.system.service.IStore_Invoice_Service;
import com.pos.system.service.IStore_Order_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Store_Invoice_Rest_Ctrl {
	
	private final IStore_Order_Service service_Order;
	private final IStore_Invoice_Service service_Invoice;
	
	@Autowired
	public Store_Invoice_Rest_Ctrl(IStore_Order_Service service_Order, IStore_Invoice_Service service_Invoice) {
		this.service_Order = service_Order;
		this.service_Invoice = service_Invoice;
	}
	
	@GetMapping("/invoice")
	public List<Store_Invoice_DTO> test(
		HttpSession session
	){
		Service_Store_DTO store = (Service_Store_DTO) session.getAttribute("store");
		return service_Invoice.invoiceList(store.getStore_seq());
	}
	
	/**
	 * 영수증 출력 기능
	 * @param store_seq / 매장 고유 번호
	 * @param table_seq /
	 * @param discount_amount /
	 * @param ref /
	 * @return
	 */
	@PostMapping("/invoice")
	public int payment(
		HttpSession session,
		@RequestParam("table_seq") String table_seq,
		@RequestParam(value = "discount_amount", required = false) String discount_amount,
		@RequestParam("ref") String ref
	){
		Service_Store_DTO store = (Service_Store_DTO) session.getAttribute("store");
		int sumorder = service_Order.sumOrder(Integer.parseInt(ref));
		
		Store_Invoice_DTO dto = new Store_Invoice_DTO();
		
		dto.setStore_seq(store.getStore_seq());
		dto.setTable_seq(Integer.parseInt(table_seq));
		dto.setRef(Integer.parseInt(ref));
		dto.setSumorder(sumorder);
		dto.setDiscount_amount(Integer.parseInt(discount_amount));

		return service_Invoice.payment(dto);
	}
	
	@GetMapping("/invoice/order/{ref}")
	public List<HashMap<String, Object>> getInvoiceOrder(
		@PathVariable("ref") String ref
	) {
		return service_Order.getInvoiceOrder(Integer.parseInt(ref));
	}
	
	
	
}
