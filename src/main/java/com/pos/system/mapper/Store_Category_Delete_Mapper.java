package com.pos.system.mapper;
import com.pos.system.dto.Store_Category_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Store_Category_Delete_Mapper {

    /**
     * 메뉴를 삭제하는 기능입니다
     * 메뉴 고유의 번호 menu_seq 값이 파라미터입니다.
     * 삭제가 성공하면 1, 실패하면 0을 반환합니다.
     * 실제로 데이터베이스에서 삭제하지 않고, DELFLAG를 N으로 바꿉니다.
     * @param menu_seq
     * @return int
     */
    @Update(" UPDATE STORE_CATEGORY SET DELFLAG = 'Y' WHERE MENU_SEQ = #{menu_seq} ")
    public int deleteMenu(int menu_seq);

}
