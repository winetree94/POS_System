package com.pos.system.mapper;
import com.pos.system.dto.Store_Table_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Store_Table_Read_Mapper {

    /**
     * 매장의 모든 테이블을 조회하는 기능입니다.
     * 삭제한 매장은 조회되지 않습니다.
     * @Param int store_seq 매장의 고유 번호
     * @return List&lt;Store_Table_DTO&gt;
     */
    @Select(" SELECT TABLE_SEQ, STORE_SEQ, TABLE_NAME, RESERVATION, MIN_PEOPLE, MAX_PEOPLE FROM STORE_TABLE WHERE STORE_SEQ=#{store_seq} AND DELFLAG='N' ")
    public List<Store_Table_DTO> selectAll(int store_seq);



    /**
     * 테이블 상세보기
     * @Param dto
     * @return Store_Table_DTO
     */
    @Select(" SELECT TABLE_SEQ, STORE_SEQ, TABLE_NAME, RESERVATION, MIN_PEOPLE, MAX_PEOPLE, DELFLAG FROM STORE_TABLE WHERE TABLE_SEQ=#{table_seq} AND STORE_SEQ=#{store_seq}")
    public Store_Table_DTO selectOne(Store_Table_DTO dto);


}
