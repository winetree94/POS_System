package com.pos.system.mapper;
import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Service_Account_Modify_Mapper {

    //회원수정
    @Update(" UPDATE SERVICE_ACCOUNT SET SERVICE_EMAIL=#{service_email} , SERVICE_PW=#{service_pw} WHERE SERVICE_ID=#{service_id} ")
    int modify(Service_Account_DTO dto);

}
