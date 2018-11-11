package com.pos.system.mapper;

import com.pos.system.dto.Store_Cashbook_DTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Store_Cashbook_Create_Mapper {
	
	/**
	 * 현금출납부에 기록을 추가하는 기능입니다.
	 * 반드시 예전 기록의 잔고를 가지고 와야합니다.
	 * 쿼리 성공시 1 실패시 0을 반환합니다.
	 * @return int
	 */
	@Insert("  INSERT INTO STORE_CASHBOOK(STORE_SEQ, CASH_DATE, CASH_DEPOSIT, CASH_WITHDRAW, CASH_BALANCE) VALUES ( 1, NOW(), 50000, 0, IFNULL((SELECT CASH_BALANCE FROM STORE_CASHBOOK A WHERE CASH_SEQ = (SELECT MAX(CASH_SEQ) FROM STORE_CASHBOOK B WHERE STORE_SEQ = 1)), 0) + 50000) ")
	int insertCash(Store_Cashbook_DTO dto);
	
}
