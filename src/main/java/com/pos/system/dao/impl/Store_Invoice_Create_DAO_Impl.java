package com.pos.system.dao.impl;

import com.pos.system.dao.Store_Cashbook_Create_DAO;
import com.pos.system.dao.Store_Invoice_Create_DAO;
import com.pos.system.dto.Store_Cashbook_DTO;
import com.pos.system.dto.Store_Invoice_DTO;
import com.pos.system.dto.Store_Order_DTO;
import com.pos.system.util.SqlSessionTemplate_Comm;
import org.springframework.stereotype.Repository;

@Repository
public class Store_Invoice_Create_DAO_Impl extends SqlSessionTemplate_Comm implements Store_Invoice_Create_DAO {
	
	@Override
	public int payment(Store_Invoice_DTO dto){
		return session.insert("mybatis.mapper.Store_Invoice.payment", dto);
	}
	

}