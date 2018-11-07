package com.pos.system.mapper;

import com.pos.system.dto.Store_Category_DTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Category_Create_Mapper {

    @Insert(" INSERT INTO STORE_CATEGORY (STORE_SEQ,MENU_NAME, CATEG_NAME, MENU_INFO, ORIGIN_FNAME, STORED_FNAME, MENU_PRICE, DELFLAG) VALUES (#{store_seq},#{menu_name},#{categ_name},#{menu_info},#{origin_fname},#{stored_fname},#{menu_price},'N' ) ")
    public int createMenu(Store_Category_DTO dto);
}
