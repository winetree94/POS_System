package com.pos.system.mapper;

import com.pos.system.dto.Store_Table_DTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Table_Create_Mapper {

    /**
     * 새로운 테이블을 생성하는 기능입니다.
     * Service_Store에 존재하는 Store_Seq 가 있어야 생성할 수 있습니다.
     * @param dto
     * @return int 성공시 1, 실패시 0을 반환
     */
    @Insert(" INSERT INTO STORE_TABLE (STORE_SEQ, TABLE_NAME, RESERVATION, MIN_PEOPLE, MAX_PEOPLE) VALUES (#{store_seq},#{table_name},#{reservation},#{min_people},#{max_people}) ")
    public int createTable(Store_Table_DTO dto);

    //TABLE_SEQ , STORE_SEQ, TABLE_NAME, RESERVATION, MIN_PEOPLE, MAX_PEOPLE, DELFLAG
}
