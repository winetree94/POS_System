package com.pos.system.mapper;
import com.pos.system.dto.Store_Table_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Table_Update_Mapper {

    /**
     * 테이블의 상세 정보를 수정하는 기능
     * Param DTO 에 들어있는 seq 값으로 테이블을 찾아서
     * 해당 row의 데이터를 dto의 값으로 바꿈
     * @param dto
     * @return int 0이면 실패를 의미, 1이면 성공
     */
    @Update(" UPDATE STORE_TABLE SET TABLE_NAME=#{table_name},RESERVATION=#{reservation}, MIN_PEOPLE=#{min_people},MAX_PEOPLE=#{max_people} WHERE TABLE_SEQ=#{table_seq} ")
    public int modifyTable(Store_Table_DTO dto);
}
