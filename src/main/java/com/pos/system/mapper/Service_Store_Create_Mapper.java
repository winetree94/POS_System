package com.pos.system.mapper;

import com.pos.system.dto.Service_Store_DTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Service_Store_Create_Mapper {
	
	/**
	 * 새로운 매장을 생성하는 기능입니다.
	 * Service_Account에 존재하는 Service_id 가 있어야 생성할 수 있습니다.
	 * @param dto
	 * @return int 성공시 1, 실패시 0을 반환
	 */
	@Insert(" INSERT INTO SERVICE_STORE(SERVICE_ID, STORE_NAME, STORE_DETAIL, STORE_TYPE, STORE_ADDRESS, STORE_TEL, STORE_HOUR, DELFLAG) VALUES(#{service_id}, #{store_name}, #{store_detail}, #{store_type}, #{store_address}, #{store_tel}, #{store_hour}, 'N') ")
	int createStore(Service_Store_DTO dto);

}
