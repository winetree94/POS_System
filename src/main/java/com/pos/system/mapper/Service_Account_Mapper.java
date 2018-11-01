package com.pos.system.mapper;

import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Service_Account_Mapper {
	
	@Select(" SELECT SERVICE_ID FROM SERVICE_ACCOUNT ")
	List<Service_Account_DTO> selectAll();

}
