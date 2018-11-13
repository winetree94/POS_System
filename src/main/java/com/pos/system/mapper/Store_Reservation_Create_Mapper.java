package com.pos.system.mapper;

import com.pos.system.dto.Store_Reservation_DTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Reservation_Create_Mapper {

    /**
     * 새로운 예약을 하는 기능입니다.
     * Service_Account에 존재하는 Service_id 가 있어야 생성할 수 있습니다.
     * @param dto
     * @return int 성공시 1, 실패시 0을 반환
     */
    @Insert(" INSERT STORE_RESERVATION(STORE_SEQ, TABLE_SEQ, USER_ID, RESERV_TIME, RESERV_PEOPLE, DELFLAG ) VALUES(#{store_seq},#{table_seq},#{user_id},#{reserv_time},#{reserv_people},'N') ")
    int createReserv(Store_Reservation_DTO dto);



}
