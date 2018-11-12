package com.pos.system.mapper;

import org.apache.ibatis.annotations.Update;

public interface Service_File_Delete_Mapper {

	/**
	 * 업로드 된 파일 삭제
	 * @param file_seq
	 * @return int
	 */
	@Update(" UPDATE SERVICE_FILE SET DELFLAG = 'Y' WHERE FILE_SEQ = #{file_seq} ")
	int deleteFile(int file_seq);
	
}
