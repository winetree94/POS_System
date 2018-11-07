package com.pos.system.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Service_Account_Duplicate_Mapper {

    // 아이디 중복검사
    @Select(" SELECT COUNT(*) FROM SERVICE_ACCOUNT WHERE SERVICE_ID = #{id} ")
    int idDuplicate(String id);
}
