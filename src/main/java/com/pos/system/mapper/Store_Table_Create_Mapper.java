package com.pos.system.mapper;

import com.pos.system.dto.Store_Table_DTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Table_Create_Mapper {

    //테이블 생성
    @Insert(" INSERT INTO STORE_TABLE (STORE_SEQ, TABLE_NAME, RESERVATION, MIN_PEOPLE, MAX_PEOPLE) VALUES (#{store_seq},#{table_name},#{reservation},#{min_people},#{max_people}) ")
    public int createTable(Store_Table_DTO dto);

    //TABLE_SEQ , STORE_SEQ, TABLE_NAME, RESERVATION, MIN_PEOPLE, MAX_PEOPLE, DELFLAG
}
