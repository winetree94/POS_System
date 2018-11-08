package com.pos.system.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Service_Board_Delete_Mapper {

	/**
	 * 특정 게시글 삭제
	 * @param seq
	 * @return int
	 */
	@Update(" UPDATE SERVICE_BOARD SET DELFLAG = 'Y' WHERE BOARD_SEQ = #{seq} ")
	int delteOneBoard(int board_seq);
	
	
}
