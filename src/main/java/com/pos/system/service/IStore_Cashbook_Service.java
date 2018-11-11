package com.pos.system.service;

import com.pos.system.dto.Store_Cashbook_DTO;

import java.util.List;

public interface IStore_Cashbook_Service {

	int insertCashbook(Store_Cashbook_DTO dto);
	List<Store_Cashbook_DTO> selectCashbook(int store_seq);

}
