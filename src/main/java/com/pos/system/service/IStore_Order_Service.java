package com.pos.system.service;

import com.pos.system.dto.Store_Order_DTO;

import java.util.HashMap;
import java.util.List;

public interface IStore_Order_Service {
	
	public int addOrder(Store_Order_DTO dto);
	
	/**
	 * make 값이 null 이 아니면 해당 조건으로 검색, 없으면 make와 관계없이 검색
	 * delflag 가 null 이라면 'N' 인 것들만 가져오고 있다면 해당 조건으로 검색
	 * @param dto
	 * @return
	 */
	List<Store_Order_DTO> orderListAll(Store_Order_DTO dto);
	
	
	Store_Order_DTO orderOne(int order_seq);
	
	int deleteOrder(int menu_seq, int table_seq);
	
	int sumOrder(int ref);
	
	List<HashMap<String, Object>> getInvoiceOrder(int ref);
	
	List<HashMap<String, Object>> getTableOrder(int store_seq, int table_seq);
	
	HashMap<String, Object> getRef(HashMap<String, Object> map);
	
	String payment(int ref);
}
