package com.pos.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Order_Read_Mapper {
	
	@Select(" SELECT SUM(MENU_PRICE) FROM STORE_ORDER WHERE REF = #{ref} ")
	int sumOrder(@Param("ref") int ref);

}
