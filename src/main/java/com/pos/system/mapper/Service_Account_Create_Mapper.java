package com.pos.system.mapper;

import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.dto.Service_Email_DTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Service_Account_Create_Mapper {

    /**
     * 사용자가 회원 가입 하는 기능입니다.
     * 사용자가 아이디,이메일,비밀번호를 입력하여 성공하면 리턴값을 1, 실패하면 0을 리턴한다.
     * @Param Service_Account_DTO
     * @return int
     */
    @Insert(" INSERT INTO SERVICE_ACCOUNT(SERVICE_ID,SERVICE_EMAIL,SERVICE_PW,SERVICE_TYPE,REGDATE, DELFLAG) VALUES(#{service_id},#{service_email},#{service_pw},'U',NOW(),'N') ")
    int signUp(Service_Account_DTO dto);


    @Insert(" INSERT INTO AUTH(AUTH_KEY,AUTHSTATUS,SERVICE_EMAIL) VALUES(#{auth_key},'N',#{service_email}) ")
    int insertAuthKey(Service_Email_DTO dto);


}
