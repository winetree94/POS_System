package com.pos.system.mapper;
import com.pos.system.dto.Store_Table_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Table_Update_Mapper {

    //테이블 수정
    //TABLE_SEQ , STORE_SEQ, TABLE_NAME, RESERVATION, MIN_PEOPLE, MAX_PEOPLE, DELFLAG
    @Update(" UPDATE STORE_TABLE SET TABLE_NAME=#{table_name},RESERVATION=#{reservation}, MIN_PEOPLE=#{min_people},MAX_PEOPLE=#{max_people} WHERE TABLE_SEQ=#{table_seq} ")
    public int modifyTable(Store_Table_DTO dto);
}
