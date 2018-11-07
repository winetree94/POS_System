package com.pos.system.mapper;

import com.pos.system.dto.Service_Store_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Service_Store_Check_Mapper {
	
	/**
	 * 관리자 권한의 모든 매장 조회 기능입니다.
	 * 모든 계정의 매장 정보가 전부 조회됩니다.
	 * @return List&lt;Service_Store_DTO&gt;
	 */
	@Select(" SELECT SERVICE_ID, STORE_NAME, STORE_DETAIL, STORE_TYPE, STORE_ADDRESS, STORE_TEL, STORE_HOUR, DELFLAG FROM SERVICE_STORE ")
	List<Service_Store_DTO> selectAllStoreAdmin();
	
	/**
	 * 서비스 사용자 자신의 모든 매장을 조회하는 기능입니다.
	 * 삭제한 매장은 조회되지 않습니다.
	 * @Param String ID 회원의 아이디
	 * @return List&lt;Service_Store_DTO&gt;
	 */
	@Select(" SELECT SERVICE_ID, STORE_NAME, STORE_DETAIL, STORE_TYPE, STORE_ADDRESS, STORE_TEL, STORE_HOUR, DELFLAG FROM SERVICE_STORE WHERE DELFLAG = 'N' AND SERVICE_ID = #{service_id} ")
	List<Service_Store_DTO> selectAllStore(@Param("service_id") String id);
	
	
	
	



}
