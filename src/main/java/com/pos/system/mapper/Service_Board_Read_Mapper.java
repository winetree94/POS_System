package com.pos.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.pos.system.dto.Service_Board_DTO;

@Mapper
@Repository
public interface Service_Board_Read_Mapper {

	
	/**
	 * 모든 게시물 조회 
	 * @return List<Service_Board_DTO> 
	 */
	@Select(" SELECT BOARD_SEQ, SERVICE_ID ,READCOUNT, REGDATE, TITLE, CONTENT, REF, STEP, DEPTH, TYPE, DELFLAG FROM SERVICE_BOARD WHERE DELFLAG = 'N' ORDER BY BOARD_SEQ DESC")
	List<Service_Board_DTO> selectAllBoard();
	
	/**
	 * 공지게시글 조회
	 * @param type
	 * @return List<Service_Board_DTO>
	 */
	@Select(" SELECT BOARD_SEQ, SERVICE_ID ,READCOUNT, REGDATE, TITLE, CONTENT, REF, STEP, DEPTH, TYPE, DELFLAG FROM SERVICE_BOARD WHERE TYPE = #{type} ")
	List<Service_Board_DTO> selectNotice(String type);
	  
	/**
	 * 특정 게시글 상세조회
	 * @param board_seq
	 * @return Service_Board_DTO
	 */
	@Select(" SELECT BOARD_SEQ, SERVICE_ID ,READCOUNT, REGDATE, TITLE, CONTENT, REF, STEP, DEPTH, TYPE, DELFLAG FROM SERVICE_BOARD WHERE BOARD_SEQ = #{board_seq} ")
	Service_Board_DTO selectOneBoard(int board_seq);


	/**
	 * 최근 게시글의 seq 조회
	 * @return board_seq
	 */
	@Select(" SELECT MAX(BOARD_SEQ) FROM SERVICE_BOARD ")
	int selectRecentBoard();


}
