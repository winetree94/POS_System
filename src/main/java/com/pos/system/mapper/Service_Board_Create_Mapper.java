package com.pos.system.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pos.system.dto.Service_Board_DTO;

@Mapper
@Repository
public interface Service_Board_Create_Mapper {

	/**
	 * 질문 게시글 추가 type = Q
	 * @param dto
	 * @return int
	 */
	@Insert(" INSERT INTO SERVICE_BOARD(SERVICE_ID, TITLE, CONTENT, READCOUNT, REGDATE, REF, STEP, DEPTH, TYPE,  DELFLAG) VALUES (#{service_id}, #{title}, #{content}, 0, NOW(), (SELECT IFNULL(MAX(REF), 0) + 1 FROM SERVICE_BOARD B), 0, 0, 'Q', 'N') ")
	int insertBoard(Service_Board_DTO dto);

    /**
     * 공지글 추가 type = N
     * @param dto
     * @return
     */
	@Insert(" INSERT INTO SERVICE_BOARD(SERVICE_ID, TITLE, CONTENT, READCOUNT, REGDATE, REF, STEP, DEPTH, TYPE,  DELFLAG) VALUES (#{service_id}, #{title}, #{content}, 0, NOW(), (SELECT IFNULL(MAX(REF), 0) + 1 FROM SERVICE_BOARD B), 0, 0, 'N', 'N') ")
	int insertNoticeBoard(Service_Board_DTO dto);

	/**
	 * 답글달기 쿼리 insert 문 type = A
	 * @param dto
	 * @return int
	 */
	@Insert(" INSERT INTO SERVICE_BOARD(SERVICE_ID, TITLE, CONTENT, REF, STEP, DEPTH, TYPE, REGDATE, DELFLAG) VALUES (#{service_id}, #{title}, #{content}, (SELECT REF FROM (SELECT REF FROM SERVICE_BOARD WHERE BOARD_SEQ = #{board_seq}) AS AA), (SELECT STEP FROM (SELECT STEP FROM SERVICE_BOARD WHERE BOARD_SEQ = #{board_seq}) AS BB)+1, (SELECT DEPTH FROM (SELECT DEPTH FROM SERVICE_BOARD WHERE BOARD_SEQ = #{board_seq}) AS CC)+1, 'A' , NOW(), 'N') ")
	int insertReply(Service_Board_DTO dto);
}
