package com.pos.system.service;

import java.util.List;


import com.pos.system.dto.Service_Board_DTO;

public interface IService_Board_Service {

	
	/**
	 * 새로운 게시글 추가
	 * dto에 title, content 필수값,
	 * service_id는 session에 담김
	 * file은 선택
	 *
	 * @param dto
	 * @return int
	 */
	int insertBoard(Service_Board_DTO dto);

	/**
	 * 특정 게시글 삭제
	 * @param board_seq
	 * @return int
	 */
	int deleteOneBoard(int board_seq);

	/**
	 * 모든 게시물 조회
	 * @return List<Service_Board_Dto>
	 */
	List<Service_Board_DTO> selectAllBoard();
	
	
	/**
	 * 공지 게시글 조회
	 * @return List<Service_Board_DTO>
	 */
	List<Service_Board_DTO> selectNoticeBoard();
	
	
	/**
	 * 특정 게시글 상세 조회
	 * @param board_seq
	 * @return Service_Board_DTO
	 */
	Service_Board_DTO selectOneBoard(int board_seq);
	
	/**
	 * 게시글 수정
	 * dto에는 service_id, title, content 필수 값으로 들어가야함
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

	/**
	 * 가장 최근 게시글 조회
	 * @param
	 * @return Service_Baord_DTO
	 */
	int selectRecentBoard();


	/**
	 * 특정 게시글의 답변 조회
	 * @param board_seq
	 * @return Service_Board_Dto
	 */
	Service_Board_DTO selectReplyBoard(int board_seq);

//	/**
//	 * 답변글 추가 type = A
//	 * @param dto
//	 * @return
//	 */
//	int insertReplyBoard(Service_Board_DTO dto);

	/**
	 * 공지글 추가 type = N
	 * @param dto
	 * @return
	 */
	int insertNoticeBoard(Service_Board_DTO dto);

	/**
	 * 답글달기 쿼리 update문
	 * @param board_seq
	 * @return int
	 */
	int updateReply(int board_seq);

	/**
	 * 답글달기 쿼리 insert문
	 * @param dto
	 * @return int
	 */
	int insertReply(Service_Board_DTO dto);
}
