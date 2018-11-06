package com.pos.system.mapper;

import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface Service_Account_Mapper {
	
	@Select(" SELECT * FROM SERVICE_ACCOUNT ")
	List<Service_Account_DTO> selectAll();
	
	@Select(" SELECT SERVICE_ID FROM SERVICE_ACCOUNT WHERE ID = #{service_id} ")
	Service_Account_DTO selectOne(Service_Account_DTO dto);
	
}