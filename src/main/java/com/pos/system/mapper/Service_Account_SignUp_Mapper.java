package com.pos.system.mapper;
import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Service_Account_SignUp_Mapper {

    //회원가입
    @Insert(" INSERT INTO SERVICE_ACCOUNT(SERVICE_ID,SERVICE_EMAIL,SERVICE_PW,SERVICE_TYPE,REGDATE, DELFLAG) VALUES(#{service_id},#{service_email},#{service_pw},'U',NOW(),'N') ")
    int signUp(Service_Account_DTO dto);

}
