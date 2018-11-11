package com.pos.system.dao;

import com.pos.system.dto.Store_Cashbook_DTO;

import java.util.List;

public interface Store_Cashbook_Read_DAO {
	
	/**
	 * 매장 번호를 입력하면 현금출납부를 날짜 순으로 반환
	 * @param store_seq
	 * @return
	 */
	public List<Store_Cashbook_DTO> selectCashbook(int store_seq);
	
}
