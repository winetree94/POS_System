package com.pos.system.service;

<<<<<<< HEAD
public interface IService_Board_Service {
=======
import java.util.List;

import com.pos.system.dto.Service_Board_DTO;

public interface IService_Board_Service {

	
	/**
	 * 새로운 게시글 추가
	 * @param dto
	 * @return int
	 */
	int InsertBoard(Service_Board_DTO dto);

	/**
	 * 특정 게시글 삭제
	 * @param board_seq
	 * @return int
	 */
	int delteOneBoard(int board_seq);

	/**
	 * 모든 게시물 조회
	 * @return List<Service_Board_Dto>
	 */
	List<Service_Board_DTO> selectAllBoard();
	
	
	/**
	 * 공지 게시글 조회
	 * @param type
	 * @return List<Service_Board_DTO>
	 */
	List<Service_Board_DTO> selectNotice(String type);
	
	
	/**
	 * 특정 게시글 상세 조회
	 * @param board_seq
	 * @return Service_Board_DTO
	 */
	Service_Board_DTO selectOneBoard(int board_seq);
	
	/**
	 * 게시글 수정
	 * @param dto
	 * @return int 
	 */
	int modifyBoard(Service_Board_DTO dto);
	
	/**
	 * 조회수 자동 증가
	 * @param board_seq
	 * @return int
	 */
	int readcountBoard(int board_seq);
	
>>>>>>> aba54a5be226caa57080a464eb733bde48bd9dd9
}
