package com.pos.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Order_Delete_Mapper {
	
	@Update(" UPDATE STORE_ORDER SET DELFLAG = 'Y' WHERE ORDER_SEQ = #{value} ")
	int deleteOrder(int order_seq);
}
