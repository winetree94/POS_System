package com.pos.system.mapper;

import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Service_Account_Mapper {
	
	@Select(" SELECT SERVICE_ID FROM SERVICE_ACCOUNT ")
	List<Service_Account_DTO> selectAll();
	
	@Insert(" INSERT INTO SERVICE_ACCOUNT(SERVICE_ID, SERVICE_EMAIL, SERVICE_PW, SERVICE_TYPE, REGDATE, DELFLAG) VALUES(" +
		"#{service_id}, #{service_email}, #{service_pw}, #{service_type}, NOW(), #{delflag}) ")
	int insert(Service_Account_DTO dto);
	
	@Select(" SELECT ID FROM SERVICE_ACCOUNT WHERE ID = #{id} ")
	Service_Account_DTO selectOne(@Param("id") String id);
	
}