package com.pos.system.service;

import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IService_Account_Service {

	/**
	 * 모든 사용자의 정보를 조회하는 기능
	 * @Param 없음
	 * @return List&lt;Service_Account_DTO&gt;
	 */
	public List<Service_Account_DTO> selectAll();

	/**
	 * 사용자의 세부정보를 조회하는 기능
	 * @Param Service_Account_DTO
	 * @return Service_Account_DTO
	 */
	public Service_Account_DTO selectOne(Service_Account_DTO dto);

	/**
	 * 아이디 중복검사하는 기능
	 * @Param String
	 * @return int
	 */
	public int idDuplicate(String id);

	//이메일 중복확인
	public int emailDuplicate(String service_email);

	/**
	 * 사용자가 로그인하는 기능
	 * @Param Service_Account_DTO
	 * @return Service_Account_DTO
	 */
	public Service_Account_DTO login(Service_Account_DTO dto);

	/**
	 * 사용자의 이메일을 변경하는 기능
	 * @Param Service_Account_DTO
	 * @return int
	 */
	public int modifyEmail(Service_Account_DTO dto);

	/**
	 * 사용자의 비밀번호을 변경하는 기능
	 * @Param Service_Account_DTO
	 * @return int
	 */
	public int modifyPw(Service_Account_DTO dto);

	/**
	 * 회원가입하는 기능
	 * @Param Service_Account_DTO
	 * @return Service_Account_DTO
	 */
	public Service_Account_DTO signUp(Service_Account_DTO dto);

	/**
	 * 회원탈퇴하는 기능
	 * @Param Service_Account_DTO
	 * @return int
	 */
	public int resign(Service_Account_DTO dto);

	//회원상세정보
	public Service_Account_DTO accountDetail(String service_id);

	//비밀번호 체크
	public String pwCheck(@Param("service_id")String service_id, @Param("service_pw")String service_pw);

}
