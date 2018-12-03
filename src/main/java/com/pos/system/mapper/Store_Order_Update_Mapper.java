package com.pos.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Order_Update_Mapper {
	
	@Select(" UPDATE STORE_ORDER SET PAYED = 'Y' WHERE REF = #{ref} ")
	String paymemt(@Param("ref") int ref);
	
	
}
