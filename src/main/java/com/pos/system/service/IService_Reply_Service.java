package com.pos.system.service;

import com.pos.system.dto.Service_Board_DTO;

public interface IService_Reply_Service {


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
