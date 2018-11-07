package com.pos.system.service.impl;

import com.pos.system.dao.IService_Account_DAO;
import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.mapper.*;
import com.pos.system.service.IService_Account_Service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IService_Account_Service_Impl implements IService_Account_Service {


	private IService_Account_DAO iService_Account_DAO;
	private Service_Account_Check_Mapper service_Account_Check_Mapper;
	private Service_Account_Duplicate_Mapper service_Account_Duplicate_Mapper;
	private Service_Account_Login_Mapper service_Account_Login_Mapper;
	private Service_Account_Modify_Mapper service_Account_Modify_Mapper;
	private Service_Account_SignUp_Mapper service_account_SignUp_Mapper;
	private Service_Account_Resign_Mapper service_Account_Resign_Mapper;

	public IService_Account_Service_Impl(IService_Account_DAO iService_Account_DAO, Service_Account_Check_Mapper service_Account_Check_Mapper, Service_Account_Duplicate_Mapper service_Account_Duplicate_Mapper, Service_Account_Login_Mapper service_Account_Login_Mapper, Service_Account_Modify_Mapper service_Account_Modify_Mapper, Service_Account_SignUp_Mapper service_account_SignUp_Mapper, Service_Account_Resign_Mapper service_Account_Resign_Mapper) {
		this.iService_Account_DAO = iService_Account_DAO;
		this.service_Account_Check_Mapper = service_Account_Check_Mapper;
		this.service_Account_Duplicate_Mapper = service_Account_Duplicate_Mapper;
		this.service_Account_Login_Mapper = service_Account_Login_Mapper;
		this.service_Account_Modify_Mapper = service_Account_Modify_Mapper;
		this.service_account_SignUp_Mapper = service_account_SignUp_Mapper;
		this.service_Account_Resign_Mapper = service_Account_Resign_Mapper;
	}

	public List<Service_Account_DTO> selectAll() {
		return service_Account_Check_Mapper.selectAll();
	}

	public Service_Account_DTO selectOne(Service_Account_DTO dto){
		return service_Account_Check_Mapper.selectOne(dto);
	}

	public int idDuplicate(String id){
		return service_Account_Duplicate_Mapper.idDuplicate(id);
	}

	public Service_Account_DTO login(Service_Account_DTO dto){
		return service_Account_Login_Mapper.login(dto);
	}

	public  int modify(Service_Account_DTO dto){
		return service_Account_Modify_Mapper.modify(dto);
	}

	public int signUp(Service_Account_DTO dto){
		return service_account_SignUp_Mapper.signUp(dto);
	}

	public int resign(Service_Account_DTO dto){
		return service_Account_Resign_Mapper.resign(dto);
	}
}
