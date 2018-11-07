package com.pos.system.mapper;

import com.pos.system.dto.Store_Cashbook_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
	
}
