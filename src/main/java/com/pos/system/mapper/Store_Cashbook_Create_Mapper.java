package com.pos.system.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Store_Cashbook_Create_Mapper {
	
	@Insert(" INSERT INTO STORE_CASHBOOK(CASH_SEQ, STORE_SEQ, CASH_DATE, CASH_DEPOSIT, CASH_WITHDRAW, CASH_BALANCE) VALUES() ")
	int depositCash();
	
	
	
	

}
