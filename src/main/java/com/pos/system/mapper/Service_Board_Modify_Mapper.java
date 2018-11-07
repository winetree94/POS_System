package com.pos.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.pos.system.dto.Service_Board_DTO;

@Mapper
public interface Service_Board_Modify_Mapper {
	
	
	/**
	 * 게시글 수정
	 * @param dto
	 * @return int
	 */
	@Update(" UPDATE SERVICE_BOARD SET TITLE = #{title}, CONTENT = #{content} WHERE BOARD_SEQ = #{seq} ")
	int modifyBoard(Service_Board_DTO dto);
	
	
}
