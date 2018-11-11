package com.pos.system.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Table_Delete_Mapper {

    /**
     * 매장의 테이블을 삭제 기능입니다.
     * 삭제할 Table_Seq 테이블의 고유 번호를 파라미터 값으로 요구합니다.
     * 삭제가 성공하면 1, 실패하면 0을 반환합니다.
     * 실제로 데이터베이스에서 삭제하지 않고, DELFLAG를 Y로 바꿉니다.
     * @param table_seq
     * @return int
     */
    @Update(" UPDATE STORE_TABLE SET DELFLAG ='Y' WHERE TABLE_SEQ=#{table_seq} ")
    public int deleteTable(int table_seq);

}
