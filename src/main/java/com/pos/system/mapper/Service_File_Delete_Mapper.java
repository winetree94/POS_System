package com.pos.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Service_File_Delete_Mapper {

	/**
	 * 업로드 된 파일 삭제
	 * @param board_seq
	 * @return int
	 */
	@Update(" UPDATE SERVICE_FILE SET DELFLAG = 'Y' WHERE BOARD_SEQ = #{board_seq} ")
	int deleteFile(int board_seq);
	
}
