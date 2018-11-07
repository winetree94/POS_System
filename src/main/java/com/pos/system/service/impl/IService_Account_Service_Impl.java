package com.pos.system.service.impl;

import com.pos.system.dao.IService_Account_DAO;
import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.mapper.*;
import com.pos.system.service.IService_Account_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IService_Account_Service_Impl implements IService_Account_Service {

	private Service_Account_Create_Mapper service_Account_Create_Mapper;
	private Service_Account_Read_Mapper service_Account_Read_Mapper;
	private Service_Account_Update_Mapper service_Account_Update_Mapper;
	private Service_Account_Delete_Mapper service_Account_Delete_Mapper;

	@Autowired
	public IService_Account_Service_Impl(Service_Account_Create_Mapper service_Account_Create_Mapper, Service_Account_Read_Mapper service_Account_Read_Mapper, Service_Account_Update_Mapper service_Account_Update_Mapper, Service_Account_Delete_Mapper service_Account_Delete_Mapper) {
		this.service_Account_Create_Mapper = service_Account_Create_Mapper;
		this.service_Account_Read_Mapper = service_Account_Read_Mapper;
		this.service_Account_Update_Mapper = service_Account_Update_Mapper;
		this.service_Account_Delete_Mapper = service_Account_Delete_Mapper;
	}

	public List<Service_Account_DTO> selectAll() {
		return service_Account_Read_Mapper.selectAll();
	}

	public Service_Account_DTO selectOne(Service_Account_DTO dto){
		return service_Account_Read_Mapper.selectOne(dto);
	}

	public int idDuplicate(String id){
		return service_Account_Read_Mapper.idDuplicate(id);
	}

	public Service_Account_DTO login(Service_Account_DTO dto){
		return service_Account_Read_Mapper.login(dto);
	}

	public  int modify(Service_Account_DTO dto){
		return service_Account_Update_Mapper.modify(dto);
	}

	public int signUp(Service_Account_DTO dto){
		return service_Account_Create_Mapper.signUp(dto);
	}

	public int resign(Service_Account_DTO dto){
		return service_Account_Delete_Mapper.resign(dto);
	}
}
