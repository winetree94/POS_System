package com.pos.system.mapper;

import com.pos.system.dto.Service_Store_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Service_Store_Update_Mapper {

	/**
	 * 매장의 상세 정보를 수정하는 기능
	 * Param DTO 에 들어있는 seq 값으로 매장을 찾아서
	 * 해당 row의 데이터를 dto의 값으로 바꿈
	 * @param dto
	 * @return int 0이면 실패를 의미, 1이면 성공
	 */
	@Update(" UPDATE SERVICE_STORE SET STORE_NAME = #{store_name}, STORE_DETAIL = #{store_detail}, STORE_TYPE = #{store_type}, STORE_ADDRESS = #{store_address}, STORE_TEL = #{store_tel}, STORE_HOUR = store_hour WHERE STORE_SEQ = #{store_seq} ")
	int updateStoreInfo(Service_Store_DTO dto);

}
