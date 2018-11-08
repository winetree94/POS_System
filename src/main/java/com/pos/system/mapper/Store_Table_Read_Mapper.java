package com.pos.system.mapper;
import com.pos.system.dto.Store_Table_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Store_Table_Read_Mapper {

    //매장에 있는 모든 테이블 조회
    //TABLE_SEQ , STORE_SEQ, TABLE_NAME, RESERVATION, MIN_PEOPLE, MAX_PEOPLE, DELFLAG
    @Select(" SELECT TABLE_SEQ, STORE_SEQ, TABLE_NAME, RESERVATION, MIN_PEOPLE, MAX_PEOPLE, DELFLAG FROM STORE_TABLE WHERE STORE_SEQ=#{store_seq} ")
    public List<Store_Table_DTO> selectAll(int store_seq);


    //테이블 세부 조회
    @Select(" SELECT TABLE_SEQ, STORE_SEQ, TABLE_NAME, RESERVATION, MIN_PEOPLE, MAX_PEOPLE, DELFLAG FROM STORE_TABLE WHERE TABLE_SEQ=#{table_seq} ")
    public Store_Table_DTO selectOne(int table_seq);


}
