package com.pos.system.service;

import com.pos.system.dao.IService_Account_DAO;
import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.mapper.Service_Account_Login_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IService_Account_Service_Impl implements IService_Account_Service {
	
	private IService_Account_DAO iService_Account_DAO;
	private Service_Account_Login_Mapper service_Account_Mapper;
	
	@Autowired
	public IService_Account_Service_Impl(IService_Account_DAO iService_Account_DAO, Service_Account_Login_Mapper service_Account_Mapper) {
		this.iService_Account_DAO = iService_Account_DAO;
		this.service_Account_Mapper = service_Account_Mapper;
	}
	
	public List<Service_Account_DTO> selectAll() {
		return service_Account_Mapper.selectAll();
	}
}
