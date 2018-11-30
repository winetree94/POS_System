package com.pos.system.mapper;
import com.pos.system.dto.Store_Category_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface Store_Category_Read_Mapper {

    @Select(" SELECT DISTINCT CATEG_NAME FROM STORE_CATEGORY WHERE STORE_SEQ=#{store_seq} AND DELFLAG='N' ")
    public List<HashMap<String, Object>> categList(int store_seq);


    /**
     * 매장의 모든 메뉴를 조회 기능입니다.
     * @param \store_seq\
     * @return List&lt;Store_Category_DTO&gt;
     */
   @Select(" SELECT MENU_SEQ,STORE_SEQ, MENU_NAME, CATEG_NAME, MENU_INFO, ORIGIN_FNAME, STORED_FNAME, MENU_PRICE FROM STORE_CATEGORY WHERE STORE_SEQ=#{store_seq} ")
   List<HashMap<String, Object>> selectAll(int store_seq);


    /**
     * 매장의 카테고리별 메뉴의 목록을 조회합니
     * @param \Store_Category_DTO\
     * @return List&lt;Store_Category_DTO&gt;
     */
     @Select(" SELECT MENU_SEQ,STORE_SEQ, MENU_NAME, CATEG_NAME, MENU_INFO,ORIGIN_FNAME, STORED_FNAME, MENU_PRICE, DELFLAG FROM STORE_CATEGORY WHERE CATEG_NAME=#{categ_name} AND STORE_SEQ=#{store_seq} AND DELFLAG='N' ")
    public List<Store_Category_DTO> categSelect(Store_Category_DTO dto);

    /**
     * 메뉴의 상세정보를 볼 수 있는 기능.
     * @param \store_Category_DTO menu_seq 메뉴의 고유번호
     * @return \Store_Category_DTO\
     */
    @Select(" SELECT MENU_SEQ,STORE_SEQ, MENU_NAME, CATEG_NAME, MENU_INFO,ORIGIN_FNAME, STORED_FNAME, MENU_PRICE, DELFLAG FROM STORE_CATEGORY WHERE MENU_SEQ=#{menu_seq} AND STORE_SEQ=#{store_seq} ")
    public Store_Category_DTO selectOne(Store_Category_DTO dto);
}
