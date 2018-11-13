package com.pos.system.dao;

import com.pos.system.dto.Store_Invoice_DTO;
import com.pos.system.dto.Store_Order_DTO;

public interface Store_Invoice_Create_DAO {
	int payment(Store_Invoice_DTO dto);
}
