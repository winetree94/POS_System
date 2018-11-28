package com.pos.system.mapper;

import com.pos.system.dto.Service_Board_DTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Service_Reply_Create_Mapper {

    /**
     * 답글달기 쿼리 update문
     * @param board_seq
     * @return int
     */
    @Update(" UPDATE SERVICE_BOARD SET STEP = STEP + 1 WHERE (STEP > (SELECT * FROM (SELECT STEP FROM SERVICE_BOARD WHERE BOARD_SEQ = #{board_seq} )AS X) ) AND (REF =(SELECT * FROM (SELECT REF FROM SERVICE_BOARD WHERE BOARD_SEQ = #{board_seq}) AS Y)) ")
    int updateReply(int board_seq);

    /**
     * 답글달기 쿼리 insert 문
     * @param dto
     * @return int
     */
    @Insert(" INSERT INTO SERVICE_BOARD(SERVICE_ID,READCOUNT,REGDATE,TITLE,CONTENT,REF,STEP,DEPTH,TYPE,DELFLAG) VALUES (#{service_id}, 0, now(),#{title},#{content}, (SELECT REF FROM (SELECT REF FROM SERVICE_BOARD WHERE BOARD_SEQ = #{board_seq}) AS AA), (SELECT STEP FROM (SELECT STEP FROM SERVICE_BOARD WHERE BOARD_SEQ = #{board_seq}) AS BB)+1, (SELECT DEPTH FROM (SELECT DEPTH FROM SERVICE_BOARD WHERE BOARD_SEQ = #{board_seq}) AS CC)+1,'U','N') ")
    int insertReply(Service_Board_DTO dto);
}
