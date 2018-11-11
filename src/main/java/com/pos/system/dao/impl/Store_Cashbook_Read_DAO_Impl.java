package com.pos.system.dao.impl;

import com.pos.system.dao.Store_Cashbook_Read_DAO;
import com.pos.system.dto.Store_Cashbook_DTO;
import com.pos.system.util.SqlSessionTemplate_Comm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Store_Cashbook_Read_DAO_Impl extends SqlSessionTemplate_Comm implements Store_Cashbook_Read_DAO {
	
	public List<Store_Cashbook_DTO> selectCashbook(int store_seq) {
		return session.selectList("mybatis.mapper.Store_Cashbook.selectCashbook", store_seq);
	}
}
