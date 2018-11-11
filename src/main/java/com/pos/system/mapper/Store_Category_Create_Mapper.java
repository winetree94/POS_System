package com.pos.system.mapper;

import com.pos.system.dto.Store_Category_DTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Category_Create_Mapper {

    /**
     * 새로운 메뉴를 생성하는 기능입니다
     * Service_Store에 존재하는 store_seq 가 있어야 생성할 수 있습니다.
     * @param dto
     * @return int 성공시 1, 실패시 0을 반환
     */
    @Insert(" INSERT INTO STORE_CATEGORY (STORE_SEQ,MENU_NAME, CATEG_NAME, MENU_INFO, ORIGIN_FNAME, STORED_FNAME, MENU_PRICE, DELFLAG) VALUES (#{store_seq},#{menu_name},#{categ_name},#{menu_info},#{origin_fname},#{stored_fname},#{menu_price},'N' ) ")
    public int createMenu(Store_Category_DTO dto);
}
