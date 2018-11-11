package com.pos.system.service.impl;

import com.pos.system.mapper.Service_Board_Create_Mapper;
import com.pos.system.mapper.Service_Board_Delete_Mapper;
import com.pos.system.mapper.Service_Board_Read_Mapper;
import com.pos.system.mapper.Service_Board_Update_Mapper;
import com.pos.system.service.IService_Board_Service;
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
	
}
