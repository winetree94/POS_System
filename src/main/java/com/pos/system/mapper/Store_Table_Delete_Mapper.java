package com.pos.system.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Table_Delete_Mapper {

    //테이블 삭제
    @Update(" UPDATE STORE_TABLE SET DELFLAG ='Y' WHERE TABLE_SEQ=#{table_seq} ")
    public int deleteTable(int table_seq);

}
