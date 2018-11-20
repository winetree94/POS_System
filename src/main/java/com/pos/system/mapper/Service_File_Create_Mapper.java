package com.pos.system.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pos.system.dto.Service_File_DTO;

@Mapper
@Repository
public interface Service_File_Create_Mapper {

	
	/**
	 * 파일 업로드
	 * @param dto
	 * @return int
	 */
	@Insert(" INSERT INTO SERVICE_FILE(BOARD_SEQ, ORIGIN_FNAME, STORED_FNAME, FILE_SIZE, DELFLAG, REGDATE) VALUES(#{board_seq}, #{origin_fname}, #{stored_fname}, #{file_size}, 'N', NOW() ) ")
	int uploadFile(Service_File_DTO dto);
	
	
}