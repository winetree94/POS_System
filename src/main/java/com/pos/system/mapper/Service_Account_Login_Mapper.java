package com.pos.system.mapper;

import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface Service_Account_Login_Mapper {

	//로그인
	@Select(" SELECT SERVICE_ID,SERVICE_PW FROM SERVICE_ACCOUNT WHERE SERVICE_ID=#{service_id} AND SERVICE_PW=#{service_pw} ")
	Service_Account_DTO login(Service_Account_DTO dto);



}