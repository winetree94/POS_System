package com.pos.system.service;

import com.pos.system.dto.Store_Cashbook_DTO;

import java.util.HashMap;
import java.util.List;

public interface IStore_Cashbook_Service {
	
	/**
	 * 자신의 현금출납부에 현금을 입출금 하는 기능입니다.
	 * dto 에는 store_seq, cash_deposit 을 필수로 요구합니다.
	 * 성공하면 캐시북 리스트를, 실패시 null을 반환
	 * @param dto
	 * @return
	 */
	List<Store_Cashbook_DTO> insertCashbook(Store_Cashbook_DTO dto);
	
	
	/**
	 * 자신의 현금출납부를 반환해 주는 메소드 입니다.
	 * 매장 고유 번호를 parameter 값으로 요구합니다.
	 * @param store_seq
	 * @return
	 */
	List<Store_Cashbook_DTO> selectCashbook(int store_seq);
	
	List<HashMap<String, Object>> getDayCal(String store_seq);
}
