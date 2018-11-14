package com.pos.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.pos.system.dto.Service_Board_DTO;

@Mapper
@Repository
public interface Service_Board_Update_Mapper {
	
	
	/**
	 * 게시글 수정
	 * @param dto
	 * @return int
	 */
	@Update(" UPDATE SERVICE_BOARD SET TITLE = #{title}, CONTENT = #{content} WHERE BOARD_SEQ = #{board_seq} ")
	int modifyBoard(Service_Board_DTO dto);
	
	
	/**
	 * 조회수 자동 증가
	 * @param board_seq
	 * @return int
	 */
	@Update(" UPDATE SERVICE_BOARD SET READCOUNT=READCOUNT+1 WHERE BOARD_SEQ=#{board_seq} ")
	int readcountBoard(int board_seq);
	
}
