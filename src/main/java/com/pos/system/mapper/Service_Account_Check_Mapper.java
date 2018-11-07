package com.pos.system.mapper;

import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Service_Account_Check_Mapper {

    // 전체 회원정보 조회
    @Select(" SELECT * FROM SERVICE_ACCOUNT ")
    List<Service_Account_DTO> selectAll();

    // 회원 상세정보
    @Select(" SELECT * FROM SERVICE_ACCOUNT WHERE SERVICE_ID = #{service_id} ")
    Service_Account_DTO selectOne(Service_Account_DTO dto);


}
