package com.pos.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface Store_Order_Read_Mapper {
	
	@Select(" SELECT SUM(MENU_PRICE) FROM STORE_ORDER WHERE REF = #{ref} ")
	int sumOrder(@Param("ref") int ref);
	
	@Select(" SELECT MENU_SEQ menu_seq, MENU_NAME menu_name, COUNT(*) count, (SUM(MENU_PRICE) / COUNT(*)) price, SUM(MENU_PRICE) sum FROM (SELECT SC.MENU_SEQ, SO.MENU_PRICE, MENU_NAME FROM STORE_ORDER SO JOIN STORE_CATEGORY SC on SO.MENU_SEQ = SC.MENU_SEQ WHERE SO.DELFLAG = 'N' AND SO.REF = #{ref}) SO GROUP BY SO.MENU_SEQ ")
	List<HashMap<String, Object>> getInvoiceOrder(@Param("ref") int ref);

}
