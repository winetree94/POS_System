package com.pos.system.service;

import com.pos.system.dto.Service_File_DTO;

public interface IService_File_Service {

    /**
     * 파일 업로드
     * @param dto
     * 파일 번호, 게시글 번호, 파일명, 저장된 파일명, 파일 사이즈
     * @return int
     * 성공할시 int로 반환
     */
    int uploadFile(Service_File_DTO dto);


    /**
     * 파일 삭제
     * 파일번호로 delflag를 y로 update
     * 성공시 int로 반환
     * @param board_seq
     * @return int
     */
    int deleteFile(int board_seq);


    /**
     * 업로드된 파일 정보 보기
     * @param board_seq
     * @return Service_File_DTO
     */
    Service_File_DTO selectOneFile(int board_seq);
}
