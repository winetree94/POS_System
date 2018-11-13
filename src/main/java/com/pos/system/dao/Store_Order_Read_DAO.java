package com.pos.system.dao;

import com.pos.system.dto.Store_Order_DTO;

import java.util.List;

public interface Store_Order_Read_DAO {
	
	List<Store_Order_DTO> orderListAll(Store_Order_DTO dto);
	
	Store_Order_DTO orderOne(int order_seq);
}
