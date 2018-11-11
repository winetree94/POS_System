package com.pos.system.dao;

import com.pos.system.dto.Store_Order_DTO;

public interface Store_Order_Create_DAO {
	
	int addOrder(Store_Order_DTO dto);
	
}
