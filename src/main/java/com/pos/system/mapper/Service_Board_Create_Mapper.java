package com.pos.system.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pos.system.dto.Service_Board_DTO;

@Mapper
@Repository
public interface Service_Board_Create_Mapper {

	/**
	 * 새로운 게시글 추가
	 * @param dto
	 * @return int
	 */
	@Insert(" INSERT INTO SERVICE_BOARD(SERVICE_ID, TITLE, CONTENT, READCOUNT, REGDATE, REF, STEP, DEPTH, TYPE,  DELFLAG)VALUES (#{service_id}, #{title}, #{content}, 0, NOW(), (SELECT IFNULL(MAX(REF), 0) + 1 FROM SERVICE_BOARD B), 0, 0, 'U', 'N') ")
	int insertBoard(Service_Board_DTO dto);
	
}
