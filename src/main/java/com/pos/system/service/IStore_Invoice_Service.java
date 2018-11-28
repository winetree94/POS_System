package com.pos.system.service;

import com.pos.system.dto.Store_Invoice_DTO;

import java.util.List;

public interface IStore_Invoice_Service {
	int payment(Store_Invoice_DTO dto);
	
	List<Store_Invoice_DTO> invoiceList(int store_seq);
}
