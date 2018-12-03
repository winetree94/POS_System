package com.pos.system.mapper;

import com.pos.system.dto.Store_Cashbook_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface Store_Cashbook_Read_Mapper {
	
	/**
	 * 자신의 매장 현금출납부 내역을 출력하는 기능입니다.
	 * @return List&lt;Store_Cashbook_DTO&gt;
	 */
	@Select(" SELECT CASH_SEQ, STORE_SEQ, CASH_DATE, CASH_DEPOSIT, CASH_WITHDRAW, CASH_BALANCE FROM STORE_CASHBOOK WHERE STORE_SEQ = #{store_seq} ")
	List<Store_Cashbook_DTO> myCashbook();
	
	@Select(" SELECT A.CASH_SEQ cash_seq, B.DATE cash_date, A.CASH_BALANCE cash_balance FROM STORE_CASHBOOK A,\n" +
		"(SELECT MAX(CASH_SEQ) CASH_SEQ, MID(CASH_DATE, 1, 10) DATE FROM STORE_CASHBOOK WHERE STORE_SEQ = #{store_seq} GROUP BY MID(CASH_DATE, 1, 10)) B WHERE A.CASH_SEQ = B.CASH_SEQ ORDER BY B.DATE DESC ")
	List<HashMap<String, Object>> getDayCal(@Param("store_seq") String store_seq);
	
}
