package com.pos.system.mapper;

import com.pos.system.dto.Store_Reservation_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Reservation_Update_Mapper {

    /**
     * 매장의 상세 정보를 수정하는 기능
     * Store_reservation_DTO 에 들어있는 seq 값으로 매장을 찾아서
     * 해당 row의 데이터를 dto의 값으로 바꿈
     * @param dto
     * @return int 0이면 실패를 의미, 1이면 성공
     */
    @Update(" UPDATE STORE_RESERVATION SET TABLE_SEQ=#{table_seq},RESERV_TIME=#{reserv_time}, RESERV_PEOPLE=#{reserv_people} WHERE RESERV_SEQ=#{reserv_seq} ")
    int updateReserv(Store_Reservation_DTO dto);

}
