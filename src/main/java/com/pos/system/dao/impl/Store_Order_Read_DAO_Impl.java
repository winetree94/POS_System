package com.pos.system.dao.impl;

import com.pos.system.dao.Store_Order_Read_DAO;
import com.pos.system.dto.Store_Order_DTO;
import com.pos.system.util.SqlSessionTemplate_Comm;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Store_Order_Read_DAO_Impl extends SqlSessionTemplate_Comm implements Store_Order_Read_DAO {

	@Override
	public List<Store_Order_DTO> orderListAll(Store_Order_DTO dto) {
		return session.selectList("mybatis.mapper.Store_Order.orderList", dto);
	}
	
	@Override
	public Store_Order_DTO orderOne(int order_seq) {
		return session.selectOne("mybatis.mapper.Store_Order.orderOne", order_seq);
	}
	@Override
	public List<HashMap<String,Object>> tableOrder(HashMap<String, Object> map) {
		return session.selectOne("mybatis.mapper.Store_Order.tableOrder", map);
	}
	
}
