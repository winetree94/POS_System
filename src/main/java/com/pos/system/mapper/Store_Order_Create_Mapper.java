package com.pos.system.mapper;

import com.pos.system.dto.Store_Order_DTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Order_Create_Mapper {
	
	/**
	 * 주문을 추가하는 기능
	 * dto에 매장의 seq, 메뉴의 seq, 테이블의 seq 값이 필요합니다.
	 * @param dto
	 * @return int
	 */
	@Insert(" INSERT INTO STORE_ORDER(STORE_SEQ, TABLE_SEQ, MENU_SEQ, REF, MAKE, ORDER_DATE, MENU_PRICE, DELFLAG) VALUES(#{store_seq}, #{table_seq}, #{menu_seq},  (SELECT MAX(REF) FROM STORE_ORDER B) + 1,'N', NOW(), (SELECT MENU_PRICE FROM STORE_CATEGORY WHERE MENU_SEQ = #{menu_seq}), 'N') ")
	int order(Store_Order_DTO dto);
	
}
