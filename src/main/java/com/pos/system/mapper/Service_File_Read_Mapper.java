package com.pos.system.mapper;

import com.pos.system.dto.Service_File_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface Service_File_Read_Mapper {


    /**
     * 파일 정보 가져오기
     * 특정게시글에 업로드된 파일 정보 보기
     * @param board_seq
     * @return Service_File_DTO
     */
    @Select(" SELECT FILE_SEQ, BOARD_SEQ, ORIGIN_FNAME, STORED_FNAME, FILE_SIZE, REGDATE, DELFLAG FROM SERVICE_FILE WHERE FILE_SEQ = (SELECT MAX(FILE_SEQ) FROM SERVICE_FILE WHERE BOARD_SEQ= #{board_seq} AND DELFLAG ='N') ")
    Service_File_DTO selectOneFile(int board_seq);
}
