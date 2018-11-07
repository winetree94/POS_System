package com.pos.system.mapper;
import com.pos.system.dto.Store_Category_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Category_Delete_Mapper {

    @Update(" UPDATE STORE_CATEGORY SET DELFLAG = 'Y' WHERE MENU_SEQ = #{menu_seq} ")
    public int deleteMenu(Store_Category_DTO dto);

}
