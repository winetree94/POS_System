package com.pos.system.mapper;

import com.pos.system.dto.Store_Invoice_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Store_Invoice_Read_Mapper {
	
	@Select(" SELECT INVOICE_SEQ, STORE_SEQ, TABLE_SEQ, REF, MENU_AMOUNT, TAX_AMOUNT, TOTAL_AMOUNT, DISCOUNT_AMOUNT, FINAL_AMOUNT, PAID_DATE, PAYMENT_METHOD, DELFLAG FROM STORE_INVOICE WHERE STORE_SEQ = #{store_seq} AND DELFLAG ='N' ORDER BY PAID_DATE DESC ")
	List<Store_Invoice_DTO> invoiceList(@Param("store_seq") int store_seq);
}
