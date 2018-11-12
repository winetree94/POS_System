package com.pos.system.service.impl;

<<<<<<< HEAD
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.system.dto.Service_Board_DTO;
>>>>>>> aba54a5be226caa57080a464eb733bde48bd9dd9
import com.pos.system.mapper.Service_Board_Create_Mapper;
import com.pos.system.mapper.Service_Board_Delete_Mapper;
import com.pos.system.mapper.Service_Board_Read_Mapper;
import com.pos.system.mapper.Service_Board_Update_Mapper;
import com.pos.system.service.IService_Board_Service;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IService_Board_Service_Impl implements IService_Board_Service {
	
	private final Service_Board_Create_Mapper mapper_Create;
	private final Service_Board_Read_Mapper mapper_Read;
	private final Service_Board_Update_Mapper mapper_Update;
	private final Service_Board_Delete_Mapper mapper_Delete;
	
	@Autowired
	public IService_Board_Service_Impl(Service_Board_Create_Mapper mapper_Create, Service_Board_Read_Mapper mapper_Read, Service_Board_Update_Mapper mapper_Update, Service_Board_Delete_Mapper mapper_Delete) {
		this.mapper_Create = mapper_Create;
		this.mapper_Read = mapper_Read;
		this.mapper_Update = mapper_Update;
		this.mapper_Delete = mapper_Delete;
	}
	
=======

@Service
public class IService_Board_Service_Impl implements IService_Board_Service {

	
	private final Service_Board_Update_Mapper mapper_Update;
	private final Service_Board_Create_Mapper mapper_Create;
	private final Service_Board_Read_Mapper mapper_Read;
	private final Service_Board_Delete_Mapper mapper_Delete;
	
	@Autowired
	public IService_Board_Service_Impl(
			Service_Board_Update_Mapper mapper_Update,
			Service_Board_Create_Mapper mapper_Create, 
			Service_Board_Read_Mapper mapper_Read,
			Service_Board_Delete_Mapper mapper_Delete) {
		this.mapper_Update = mapper_Update;
		this.mapper_Create = mapper_Create;
		this.mapper_Read = mapper_Read;
		this.mapper_Delete = mapper_Delete;
	}
	
	@Override
	public int InsertBoard(Service_Board_DTO dto) {
		return mapper_Create.insertBoard(dto);
	}

	@Override
	public int delteOneBoard(int board_seq) {
		// TODO Auto-generated method stub
		return mapper_Delete.delteOneBoard(board_seq);
	}

	@Override
	public List<Service_Board_DTO> selectAllBoard() {
		// TODO Auto-generated method stub
		return mapper_Read.selectAllBoard();
	}

	@Override
	public List<Service_Board_DTO> selectNotice(String type) {
		// TODO Auto-generated method stub
		return mapper_Read.selectNotice(type);
	}

	@Override
	public Service_Board_DTO selectOneBoard(int board_seq) {
		// TODO Auto-generated method stub
		return mapper_Read.selectOneBoard(board_seq);
	}

	@Override
	public int modifyBoard(Service_Board_DTO dto) {
		// TODO Auto-generated method stub
		return mapper_Update.modifyBoard(dto);
	}

	@Override
	public int readcountBoard(int board_seq) {
		// TODO Auto-generated method stub
		return mapper_Update.readcountBoard(board_seq);
	}
	

	
	
	
>>>>>>> aba54a5be226caa57080a464eb733bde48bd9dd9
}
