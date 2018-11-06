package com.pos.system.mapper;

import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Service_Account_Mapper {

	// 아이디 중복검사
	@Select(" SELECT COUNT(*) FROM SERVICE_ACCOUNT WHERE SERVICE_ID = #{id} ")
	int idDuplicate(String id);

	// 전체 회원정보 조회
	@Select(" SELECT * FROM SERVICE_ACCOUNT ")
	List<Service_Account_DTO> selectAll();

	// 가입 상세정보
	@Select(" SELECT * FROM SERVICE_ACCOUNT WHERE ID = #{service_id} ")
	Service_Account_DTO selectOne(Service_Account_DTO dto);

	//회원가입
	@Insert("INSERT SERVICE_ACCOUNT VALUES(#{service_id},#{service_email},#{service_pw},'U',NOW(),'N'")
	int signUp(Service_Account_DTO dto);

	//회원수정
	@Update("UPDATE SERVICE_ACCOUNT SET SERVICE_EMAIL=#{service_email} , SERVICE_PW=#{service_pw} WHERE SERVICE_ID=#{service_id}")
	int modify(Service_Account_DTO dto);

	//로그인
	@Select("SELECT SERVICE_ID,SERVICE_PW FROM SERVICE_ACCOUN WHERE SERVICE_ID=#{service_id} AND SERVICE_PW=#{service_pw}")
	Service_Account_DTO login(Service_Account_DTO dto);

	//회원탈퇴
	@Update("UPDATE SERVICE_ACCOUNT SET DELFLAG='Y' WHERE SERVICE_ID=#{service+id} AND SERVICE_PW={service_pw}")
	int signOut(Service_Account_DTO dto);






}