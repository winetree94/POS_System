package com.pos.system.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Invoice_Create_Mapper {
	
	@Insert(" INSERT INTO STORE_INVOICE ")
	int insertOrder();
	
	
}
