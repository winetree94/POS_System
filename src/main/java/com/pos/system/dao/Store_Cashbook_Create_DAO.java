package com.pos.system.dao;

import com.pos.system.dto.Store_Cashbook_DTO;

public interface Store_Cashbook_Create_DAO {
	
	/**
	 * 매장에 현금 출납을 등록
	 * dto에는 cash_deposit(출납 금액 +- 사용 가능), store_seq(매장 고유 번호) 가 필수입니다.
	 * 성공여부를 int로 반환
	 * @param dto
	 * @return
	 */
	int insert(Store_Cashbook_DTO dto);

}
