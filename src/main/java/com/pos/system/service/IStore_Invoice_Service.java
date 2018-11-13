package com.pos.system.service;

import com.pos.system.dto.Store_Invoice_DTO;

public interface IStore_Invoice_Service {
	int payment(Store_Invoice_DTO dto);
}
