package com.pos.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Order_Delete_Mapper {
	
	@Update(" UPDATE STORE_ORDER\n" +
		"SET DELFLAG = 'Y'\n" +
		"WHERE  ORDER_SEQ = (\n" +
		"  SELECT ORDER_SEQ FROM (\n" +
		"  SELECT MAX(ORDER_SEQ) ORDER_SEQ\n" +
		"\tFROM STORE_ORDER\n" +
		"\tWHERE MENU_SEQ = #{menu_seq} AND DELFLAG = 'N' AND PAYED = 'N' AND REF = (SELECT MAX(REF) FROM STORE_ORDER WHERE TABLE_SEQ = #{table_seq})) OS) ")
	int deleteOrder(@Param("table_seq") int table_seq, @Param("menu_seq") int menu_seq);
}
