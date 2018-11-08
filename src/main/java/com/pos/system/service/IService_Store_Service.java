package com.pos.system.service;

import com.pos.system.dto.Service_Store_DTO;

import java.util.List;

public interface IService_Store_Service {
	
	/**
	 * 매장을 생성하고 생성된 매장을 다시 보여주는 기능
	 * 반환값이 1이면 성공 0이면 실패
	 * @param dto 매장정보
	 * @return int
	 */
	int createStore(Service_Store_DTO dto);
	
	/**
	 * 서비스 계정의 매장의 정보를 수정하는 기능
	 * dto의 매장 고유 번호의 값으로 매장을 찾아서
	 * 나머지 값으로 매장의 정보를 변경합니다.
	 * 변경에 실패하면 null 을 반환합니다.
	 * @param dto
	 * @return int
	 */
	int modifyStore(Service_Store_DTO dto);
	
	/**
	 * 서비스 계정의 매장 목록을 반환하는 기능
	 * @Param String service_id 서비스 계정 아이디
	 * @return &lt;Service_Store_DTO&gt; 매장의 리스트
	 */
	List<Service_Store_DTO> selectAllStore(String service_id);
	
	/**
	 * 서비스 계정에서 한개의 매장의 세부정보를 반환하는 기능
	 * @param store_seq 매장의 고유 번호
	 * @return Service_Store_DTO 매장의 상세 정보
	 */
	Service_Store_DTO selectStore(int store_seq);
	
	/**
	 * 서비스 계정의 매장 한개를 삭제하는 기능
	 * 실제로 데이터베이스에서 삭제하지는 않습니다.
	 * @param int 매장의 고유 번호
	 * @return int 성공시 1, 실패시 0
	 */
	int deleteStore(int store_seq);
	
}
