package com.pos.system.service;

import com.pos.system.dto.Service_Account_DTO;

import java.util.List;

public interface IService_Account_Service {

	public List<Service_Account_DTO> selectAll();
	public Service_Account_DTO selectOne(Service_Account_DTO dto);
	public int idDuplicate(String id);
	public Service_Account_DTO login(Service_Account_DTO dto);
	public int modify(Service_Account_DTO dto);
	public int signUp(Service_Account_DTO dto);
	public int resign(Service_Account_DTO dto);
}
