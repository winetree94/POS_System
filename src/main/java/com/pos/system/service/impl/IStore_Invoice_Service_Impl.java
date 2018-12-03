package com.pos.system.service.impl;

import com.pos.system.dao.Store_Invoice_Create_DAO;
import com.pos.system.dao.Store_Invoice_Delete_DAO;
import com.pos.system.dao.Store_Invoice_Read_DAO;
import com.pos.system.dao.Store_Invoice_Update_DAO;
import com.pos.system.dto.Store_Invoice_DTO;
import com.pos.system.mapper.Store_Invoice_Create_Mapper;
import com.pos.system.mapper.Store_Invoice_Delete_Mapper;
import com.pos.system.mapper.Store_Invoice_Read_Mapper;
import com.pos.system.mapper.Store_Invoice_Update_Mapper;
import com.pos.system.service.IStore_Invoice_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class IStore_Invoice_Service_Impl implements IStore_Invoice_Service {
	
	private final Store_Invoice_Create_Mapper mapper_Create;
	private final Store_Invoice_Read_Mapper mapper_Read;
	private final Store_Invoice_Update_Mapper mapper_Update;
	private final Store_Invoice_Delete_Mapper mapper_Delete;
	
	private final Store_Invoice_Create_DAO dao_Create;
	private final Store_Invoice_Read_DAO dao_Read;
	private final Store_Invoice_Update_DAO dao_Update;
	private final Store_Invoice_Delete_DAO dao_Delete;
	
	@Autowired
	public IStore_Invoice_Service_Impl(Store_Invoice_Create_Mapper mapper_Create, Store_Invoice_Read_Mapper mapper_Read, Store_Invoice_Update_Mapper mapper_Update, Store_Invoice_Delete_Mapper mapper_Delete, Store_Invoice_Create_DAO dao_Create, Store_Invoice_Read_DAO dao_Read, Store_Invoice_Update_DAO dao_Update, Store_Invoice_Delete_DAO dao_Delete) {
		this.mapper_Create = mapper_Create;
		this.mapper_Read = mapper_Read;
		this.mapper_Update = mapper_Update;
		this.mapper_Delete = mapper_Delete;
		this.dao_Create = dao_Create;
		this.dao_Read = dao_Read;
		this.dao_Update = dao_Update;
		this.dao_Delete = dao_Delete;
	}
	
	@Override
	public int payment(Store_Invoice_DTO dto) {
		return dao_Create.payment(dto);
	}
	
	@Override
	public List<Store_Invoice_DTO> invoiceList(int store_seq){return mapper_Read.invoiceList(store_seq);}
	
	@Override
	public int refund(String ref) {
		
		mapper_Delete.refund(ref);
		HashMap<String, Object> invoice = mapper_Read.selectInvoice(ref);
		int final_amount = (int)invoice.get("final_amount");
		
		return final_amount;
	}
	
	
}
