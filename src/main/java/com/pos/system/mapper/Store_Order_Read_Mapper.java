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
	
	@Select(" SELECT SUM(MENU_PRICE) FROM STORE_ORDER WHERE REF = #{ref} AND DELFLAG = 'N' AND PAYED = 'N' ")
	int sumOrder(@Param("ref") int ref);
	
	@Select(" SELECT MENU_SEQ menu_seq, MENU_NAME menu_name, COUNT(*) count, (SUM(MENU_PRICE) / COUNT(*)) price, SUM(MENU_PRICE) sum FROM (SELECT SC.MENU_SEQ, SO.MENU_PRICE, MENU_NAME FROM STORE_ORDER SO JOIN STORE_CATEGORY SC on SO.MENU_SEQ = SC.MENU_SEQ WHERE SO.DELFLAG = 'N' AND SO.REF = #{ref}) SO GROUP BY SO.MENU_SEQ ")
	List<HashMap<String, Object>> getInvoiceOrder(@Param("ref") int ref);
	
	@Select(" SELECT MENU_SEQ menu_seq, MENU_NAME menu_name,\n" +
		"       COUNT(*)  count, (SUM(MENU_PRICE)/COUNT(*)) price,SUM(MENU_PRICE) sum\n" +
		"FROM (SELECT SC.MENU_SEQ,\n" +
		"             SO.MENU_PRICE,\n" +
		"             MENU_NAME\n" +
		"      FROM STORE_ORDER SO\n" +
		"\t           JOIN STORE_CATEGORY SC on SO.MENU_SEQ = SC.MENU_SEQ\n" +
		"      WHERE SC.STORE_SEQ = #{store_seq}\n" +
		"\t\t    AND SO.DELFLAG = 'N'\n" +
		"\t\t    AND SO.REF = (SELECT MAX(REF) FROM STORE_ORDER WHERE TABLE_SEQ = #{table_seq} AND PAYED = 'N' AND DELFLAG = 'N')) SO\n" +
		"GROUP BY SO.MENU_SEQ ")
	List<HashMap<String, Object>> getTableOrder(@Param("table_seq") int table_seq, @Param("store_seq") int store_seq);
	
	@Select(" SELECT IFNULL(MAX(REF), 0) ref FROM STORE_ORDER WHERE STORE_SEQ = #{store_seq} AND TABLE_SEQ = #{table_seq} AND DELFLAG ='N' AND PAYED = 'N' ")
	HashMap<String, Object> getRef(HashMap<String, Object> map);

}
