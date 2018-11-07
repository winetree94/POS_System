package com.pos.system.mapper;
import com.pos.system.dto.Store_Category_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Category_Update_Mapper {

    @Update("UPDATE STORE_CATEGORY SET MENU_NAME=#{menu_name},CATEG_NAME=#{categ_name},MENU_INFO=#{menu_info},ORIGIN_FNAME=#{origin_fname},STORED_FNAME=#{stored_fname}, MENU_PRICE=#{menu_price} WHERE MENU_SEQ =#{menu_seq} ")
    public int modify(Store_Category_DTO dto);
}
