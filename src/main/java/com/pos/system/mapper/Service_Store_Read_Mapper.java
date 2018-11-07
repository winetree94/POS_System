package com.pos.system.mapper;

import com.pos.system.dto.Service_Store_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Service_Store_Read_Mapper {
	
	/**
	 * 관리자 권한의 모든 매장 조회 기능입니다.
	 * 모든 계정의 매장 정보가 전부 조회됩니다.
	 * @return List&lt;Service_Store_DTO&gt;
	 */
	@Select(" SELECT STORE_SEQ, SERVICE_ID, STORE_NAME, STORE_DETAIL, STORE_TYPE, STORE_ADDRESS, STORE_TEL, STORE_HOUR, DELFLAG, REGDATE FROM SERVICE_STORE ")
	List<Service_Store_DTO> selectAllStoreAdmin();
	
	/**
	 * 서비스 사용자 자신의 모든 매장을 조회하는 기능입니다.
	 * 삭제한 매장은 조회되지 않습니다.
	 * @Param String ID 회원의 아이디
	 * @return List&lt;Service_Store_DTO&gt;
	 */
	@Select(" SELECT STORE_SEQ, SERVICE_ID, STORE_NAME, STORE_DETAIL, STORE_TYPE, STORE_ADDRESS, STORE_TEL, STORE_HOUR, DELFLAG, REGDATE FROM SERVICE_STORE WHERE DELFLAG = 'N' AND SERVICE_ID = #{service_id} ")
	List<Service_Store_DTO> selectAllStore(@Param("service_id") String id);
	
	/**
	 * 매장 상세보기
	 * @Param int 매장의 고유 번호
	 * @return Service_Store_DTO
	 */
	@Select(" SELECT STORE_SEQ, SERVICE_ID, STORE_NAME, STORE_DETAIL, STORE_TYPE, STORE_ADDRESS, STORE_TEL, STORE_HOUR, DELFLAG, REGDATE FROM SERVICE_STORE WHERE DELFLAG = 'N' AND STORE_SEQ = #{store_seq} ")
	Service_Store_DTO selectOneStore(@Param("store_seq") int store_seq);

}
