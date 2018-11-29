package com.pos.system.service.impl;

import com.pos.system.dao.Store_Order_Create_DAO;
import com.pos.system.dao.Store_Order_Delete_DAO;
import com.pos.system.dao.Store_Order_Read_DAO;
import com.pos.system.dao.Store_Order_Update_DAO;
import com.pos.system.dto.Store_Order_DTO;
import com.pos.system.mapper.Store_Order_Create_Mapper;
import com.pos.system.mapper.Store_Order_Delete_Mapper;
import com.pos.system.mapper.Store_Order_Read_Mapper;
import com.pos.system.mapper.Store_Order_Update_Mapper;
import com.pos.system.service.IStore_Order_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class IStore_Order_Service_Impl implements IStore_Order_Service {
	
	private final Store_Order_Create_DAO dao_Create;
	private final Store_Order_Read_DAO dao_Read;
	private final Store_Order_Update_DAO dao_Update;
	private final Store_Order_Delete_DAO dao_Delete;
	
	private final Store_Order_Create_Mapper mapper_Create;
	private final Store_Order_Read_Mapper mapper_Read;
	private final Store_Order_Update_Mapper mapper_Update;
	private final Store_Order_Delete_Mapper mapper_Delete;
	
	@Autowired
	public IStore_Order_Service_Impl(Store_Order_Create_DAO dao_Create, Store_Order_Read_DAO dao_Read, Store_Order_Update_DAO dao_Update, Store_Order_Delete_DAO dao_Delete, Store_Order_Create_Mapper mapper_Create, Store_Order_Read_Mapper mapper_Read, Store_Order_Update_Mapper mapper_Update, Store_Order_Delete_Mapper mapper_Delete) {
		this.dao_Create = dao_Create;
		this.dao_Read = dao_Read;
		this.dao_Update = dao_Update;
		this.dao_Delete = dao_Delete;
		this.mapper_Create = mapper_Create;
		this.mapper_Read = mapper_Read;
		this.mapper_Update = mapper_Update;
		this.mapper_Delete = mapper_Delete;
	}
	
	@Override
	public int addOrder(Store_Order_DTO dto){
		return dao_Create.addOrder(dto);
	}
	
	@Override
	public List<Store_Order_DTO> orderListAll(Store_Order_DTO dto){
		return dao_Read.orderListAll(dto);
	}
	
	@Override
	public Store_Order_DTO orderOne(int order_seq){
		return dao_Read.orderOne(order_seq);
	}
	
	@Override
	public int deleteOrder(int order_seq) {
		return mapper_Delete.deleteOrder(order_seq);
	}
	
	@Override
	public int sumOrder(int ref) {
		return mapper_Read.sumOrder(ref);
	}
	
	@Override
	public List<HashMap<String, Object>> getInvoiceOrder(int ref) {return mapper_Read.getInvoiceOrder(ref);}
	
	@Override
	public List<HashMap<String, Object>> getTableOrder(int store_seq, int table_seq){return mapper_Read.getTableOrder(table_seq, store_seq);}
	
}
