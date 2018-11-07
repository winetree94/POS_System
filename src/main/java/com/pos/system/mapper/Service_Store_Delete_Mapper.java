package com.pos.system.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Service_Store_Delete_Mapper {
	
	/**
	 * 사용자의 매장 삭제 기능입니다.
	 * 삭제할 STORE_SEQ 매장 고유 번호를 파라미터 값으로 요구합니다.
	 * 삭제가 성공하면 1, 실패하면 0을 반환합니다.
	 * 실제로 데이터베이스에서 삭제하지 않고, DELFLAG를 N으로 바꿉니다.
	 * @param store_seq
	 * @return int
	 */
	@Update(" UPDATE SERVICE_STORE SET DELFLAG = 'Y' WHERE STORE_SEQ = #{store_seq} ")
	int deleteStore(@Param("store_seq") int store_seq);
	
	/**
	 * 관리자의 매장 삭제 기능입니다.
	 * 실제로 데이터베이스에서 행을 삭제합니다.
	 * 삭제가 성공하면 1, 실패하면 0을 반환합니다.
	 * @param store_seq
	 * @return int
	 */
	@Delete(" DELETE FROM SERVICE_STORE WHERE STORE_SEQ = #{store_seq} ")
	int wipeStore(@Param("store_seq") int store_seq);
	
	/**
	 * 관리자의 모든 매장의 삭제 기능입니다.
	 * 테이블 내의 모든 데이터를 삭제합니다.
	 * 성공하면 1, 실패하면 0을 반환합니다.
	 * @return int
	 */
	@Delete(" DELETE FROM SERVICE_STORE ")
	int wipeStoreAll();
}
