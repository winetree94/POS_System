package com.pos.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Invoice_Delete_Mapper {
	
	@Update(" UPDATE STORE_INVOICE SET DELFLAG = 'Y' WHERE REF = #{ref}")
	int refund(@Param("ref") String ref);
	
}
