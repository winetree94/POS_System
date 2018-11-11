package com.pos.system.mapper;

import com.pos.system.dto.Store_Order_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Store_Order_Read_Mapper {
	
	/**
	 * 현재 만들어야 하는 주문 목록을 출력하는 기능
	 * @param int store_seq
	 * @return List Store_Order_Dto
	 */
	@Select(" SELECT ORDER_SEQ, STORE_SEQ, TABLE_SEQ, MENU_SEQ, MAKE, ORDER_DATE, MENU_PRICE, DELFLAG FROM STORE_ORDER WHERE STORE_SEQ = #{store_seq} AND MAKE = 'N' ")
	List<Store_Order_DTO> getOrder(@Param("store_seq") int store_seq);

}
