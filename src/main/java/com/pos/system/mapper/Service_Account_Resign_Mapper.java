package com.pos.system.mapper;
import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Service_Account_Resign_Mapper {

    //회원탈퇴
    @Update(" UPDATE SERVICE_ACCOUNT SET DELFLAG='Y' WHERE SERVICE_ID=#{service_id} AND SERVICE_PW=#{service_pw} ")
    int resign(Service_Account_DTO dto);
}
