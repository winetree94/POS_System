package com.pos.system.service.impl;

import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.mapper.*;
import com.pos.system.service.IService_Account_Service;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IService_Account_Service_Impl implements IService_Account_Service {

	private Service_Account_Create_Mapper mapper_Create;
	private Service_Account_Read_Mapper mapper_Read;
	private Service_Account_Update_Mapper mapper_Update;
	private Service_Account_Delete_Mapper mapper_Delete;

	public IService_Account_Service_Impl(Service_Account_Create_Mapper mapper_Create, Service_Account_Read_Mapper mapper_Read, Service_Account_Update_Mapper mapper_Update, Service_Account_Delete_Mapper mapper_Delete) {
		this.mapper_Create = mapper_Create;
		this.mapper_Read = mapper_Read;
		this.mapper_Update = mapper_Update;
		this.mapper_Delete = mapper_Delete;
	}

	public List<Service_Account_DTO> selectAll() {
		return mapper_Read.selectAll();
	}

	public Service_Account_DTO selectOne(Service_Account_DTO dto){
		return mapper_Read.selectOne(dto);
	}

	public int idDuplicate(String id){
		return mapper_Read.idDuplicate(id);
	}

	public int emailDuplicate(String service_email){
		return mapper_Read.emailDuplicate(service_email);
	}

	public Service_Account_DTO login(Service_Account_DTO dto){
		return mapper_Read.login(dto);
	}

	public  int modifyEmail(Service_Account_DTO dto){
		return mapper_Update.modifyEmail(dto);
	}

	public int modifyPw(Service_Account_DTO dto){ return mapper_Update.modifyPw(dto);}

	public Service_Account_DTO signUp(Service_Account_DTO dto){
		int n  = mapper_Create.signUp(dto);
		if(n>0) {
			return mapper_Read.selectOne(dto);
		}
		return null;
	}

	public int resign(Service_Account_DTO dto){
		return mapper_Delete.resign(dto);
	}


	public Service_Account_DTO accountDetail(String service_id){

		return mapper_Read.accountDetail(service_id);
	};

	public String pwCheck(@Param("service_id")String service_id, @Param("service_pw")String service_pw){
		return mapper_Read.pwCheck(service_id,service_pw);
	}

}
