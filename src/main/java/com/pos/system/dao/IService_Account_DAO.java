package com.pos.system.dao;

import com.pos.system.dto.Service_Account_DTO;

import java.util.List;


public interface IService_Account_DAO {
	
	public List<Service_Account_DTO> selectAll();
	
}
