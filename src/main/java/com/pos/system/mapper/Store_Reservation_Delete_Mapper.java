package com.pos.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Reservation_Delete_Mapper {

    /**
     * 예약을 삭제하는 기능입니다.
     * 삭제할 예약 고유 번호를 파라미터 값으로 요구합니다.
     * 삭제가 성공하면 1, 실패하면 0을 반환합니다.
     * @param \reserv_seq\
     * @return int
     */
    @Update(" UPDATE STORE_RESERVATION SET DELFLAG ='Y' WHERE RESERV_SEQ=#{reserv_seq} ")
    public int deleteReserv(int reserv_seq);

}
