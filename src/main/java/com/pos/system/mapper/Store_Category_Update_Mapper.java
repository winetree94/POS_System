package com.pos.system.mapper;
import com.pos.system.dto.Store_Category_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Category_Update_Mapper {

    /**
     * 메뉴의 상세 정보를 수정하는 기능
     * 메뉴의  seq값으로 해당 row의 데이터를 dto의 값으로 바꿈
     * @param dto
     * @return int 0이면 실패를 의미, 1이면 성공
     */
    @Update("UPDATE STORE_CATEGORY SET MENU_NAME=#{menu_name},CATEG_NAME=#{categ_name},MENU_INFO=#{menu_info},ORIGIN_FNAME=#{origin_fname},STORED_FNAME=#{stored_fname}, MENU_PRICE=#{menu_price} WHERE STORE_SEQ =#{store_seq} AND MENU_SEQ =#{menu_seq} ")
    public int modifyMenu(Store_Category_DTO dto);
}
