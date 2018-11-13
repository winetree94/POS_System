package com.pos.system.service.impl;

import com.pos.system.dao.Store_Cashbook_Create_DAO;
import com.pos.system.dao.Store_Cashbook_Delete_DAO;
import com.pos.system.dao.Store_Cashbook_Read_DAO;
import com.pos.system.dao.Store_Cashbook_Update_DAO;
import com.pos.system.dto.Store_Cashbook_DTO;
import com.pos.system.mapper.Store_Cashbook_Create_Mapper;
import com.pos.system.mapper.Store_Cashbook_Delete_Mapper;
import com.pos.system.mapper.Store_Cashbook_Read_Mapper;
import com.pos.system.mapper.Store_Cashbook_Update_Mapper;
import com.pos.system.service.IStore_Cashbook_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStore_Cashbook_Service_Impl implements IStore_Cashbook_Service {

	private final Store_Cashbook_Create_DAO dao_Create;
	private final Store_Cashbook_Read_DAO dao_Read;
	private final Store_Cashbook_Update_DAO dao_Update;
	private final Store_Cashbook_Delete_DAO dao_Delete;
	
	private final Store_Cashbook_Create_Mapper mapper_Create;
	private final Store_Cashbook_Read_Mapper mapper_Read;
	private final Store_Cashbook_Update_Mapper mapper_Update;
	private final Store_Cashbook_Delete_Mapper mapper_Delete;
	
	@Autowired
	public IStore_Cashbook_Service_Impl(Store_Cashbook_Create_DAO dao_Create, Store_Cashbook_Read_DAO dao_Read, Store_Cashbook_Update_DAO dao_Update, Store_Cashbook_Delete_DAO dao_Delete, Store_Cashbook_Create_Mapper mapper_Create, Store_Cashbook_Read_Mapper mapper_Read, Store_Cashbook_Update_Mapper mapper_Update, Store_Cashbook_Delete_Mapper mapper_Delete) {
		this.dao_Create = dao_Create;
		this.dao_Read = dao_Read;
		this.dao_Update = dao_Update;
		this.dao_Delete = dao_Delete;
		this.mapper_Create = mapper_Create;
		this.mapper_Read = mapper_Read;
		this.mapper_Update = mapper_Update;
		this.mapper_Delete = mapper_Delete;
	}
	
	/**
	 *
	 * @param dto
	 * @return
	 */
	@Override
	public List<Store_Cashbook_DTO> insertCashbook(Store_Cashbook_DTO dto) {
		int result = dao_Create.insert(dto);
		return result>0?dao_Read.selectCashbook(dto.getStore_seq()):null;
	}
	
	@Override
	public List<Store_Cashbook_DTO> selectCashbook(int store_seq) {
		return dao_Read.selectCashbook(store_seq);
	}
}
