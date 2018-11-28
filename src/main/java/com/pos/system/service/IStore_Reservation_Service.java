package com.pos.system.service;

import com.pos.system.dto.Store_Reservation_DTO;

import java.util.List;

public interface IStore_Reservation_Service {


    /**
     * 매장의 모든 예약을 조회하는 기능입니다
     * @Param int store_seq 매장의 고유번호
     * @return &lt;Store_Reservation_DTO&gt; 예약 DTO 리스트
     */
    public List<Store_Reservation_DTO> selectAll(int store_seq);

    /**
     * 예약 상세정보를 반환하는 기능
     * @Param dto
     * @return Store_Reservation_DTO
     */
    public Store_Reservation_DTO selectOne(Store_Reservation_DTO dto);

    /**
     * 새로운 예약을 생성하는 기능
     * 반환값이 1이면 성공 0이면 실패
     * @param dto 예약정보
     * @return int
     */
    public int createReserv(Store_Reservation_DTO dto);

    /**
     * 예약 상세 정보를 수정하는 기능
     * dto의 예약 고유 번호로 테이블을 찾아서
     * 나머지 값으로 테이블의 정보를 변경합니다.
     * 변경에 실패하면 null 을 반환합니다.
     * @param dto
     * @return Store_Reservation_DTO
     */
    public Store_Reservation_DTO modifyReserv(Store_Reservation_DTO dto);

    /**
     * 예약 정보를 삭제하는 기능
     * 실제로 데이터베이스에서 삭제하지는 않습니다.
     * @param \dto
     * @return int 성공시 1, 실패시 0
     */
    public int deleteReserv(Store_Reservation_DTO dto);


}
