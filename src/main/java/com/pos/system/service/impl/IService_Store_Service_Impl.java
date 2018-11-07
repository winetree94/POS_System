package com.pos.system.service.impl;

import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.mapper.*;
import com.pos.system.service.IService_Store_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IService_Store_Service_Impl implements IService_Store_Service {

	private final Service_Store_Create_Mapper mapper_Create;
	private final Service_Store_Read_Mapper mapper_Read;
	private final Service_Store_Update_Mapper mapper_Update;
	private final Service_Store_Delete_Mapper mapper_Delete;
	
	@Autowired
	public IService_Store_Service_Impl(Service_Store_Create_Mapper mapper_Create, Service_Store_Read_Mapper mapper_Read, Service_Store_Update_Mapper mapper_Update, Service_Store_Delete_Mapper mapper_Delete) {
		this.mapper_Create = mapper_Create;
		this.mapper_Read = mapper_Read;
		this.mapper_Update = mapper_Update;
		this.mapper_Delete = mapper_Delete;
	}
	
	@Override
	public int createStore(Service_Store_DTO dto) {
		return mapper_Create.createStore(dto);
	}
	
	@Override
	public Service_Store_DTO modifyStore(Service_Store_DTO dto) {
		int n = mapper_Update.updateStoreInfo(dto);
		if(n > 0) {
			return mapper_Read.selectOneStore(dto.getStore_seq());
		}
		return null;
	}
	
	@Override
	public List<Service_Store_DTO> selectAllStore(String service_id) {
		return mapper_Read.selectAllStore(service_id);
	}
	
	@Override
	public Service_Store_DTO selectStore(int store_seq) {
		return mapper_Read.selectOneStore(store_seq);
	}
	
	@Override
	public int deleteStore(int store_seq) {
		return mapper_Delete.deleteStore(store_seq);
	}
}
