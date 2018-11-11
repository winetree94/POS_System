package com.pos.system.mapper;

import com.pos.system.dto.Store_Reservation_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Store_Reservation_Read_Mapper {

    /**
     *  전체 예약 보기.
     * @return List&lt;Store_Reservation_DTO&gt;
     */
    @Select(" SELECT RESERV_SEQ, STORE_SEQ, TABLE_SEQ, USER_ID, RESERV_TIME, RESERV_PEOPLE, DELFLAG FROM STORE_RESERVATION WHERE STORE_SEQ=#{store_seq}  ")
    public List<Store_Reservation_DTO> selectAll(int store_seq);

    /**
     * 매장 상세보기
     * @Param int 예약 고유번호
     * @return Store_Reservation_DTO
     */
    @Select(" SELECT RESERV_SEQ, STORE_SEQ, TABLE_SEQ, USER_ID, RESERV_TIME, RESERV_PEOPLE,DELFLAG FROM STORE_RESERVATION WHERE RESERV_SEQ=#{RESERV_SEQ} ")
    public Store_Reservation_DTO selectone(int reserv_seq);

}
