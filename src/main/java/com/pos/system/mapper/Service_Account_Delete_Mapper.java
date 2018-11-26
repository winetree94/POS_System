package com.pos.system.mapper;
import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.dto.Service_Email_DTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Service_Account_Delete_Mapper {

    /**
     * 사용자가 회원 탈퇴하는 기능입니다.
     * 서비스 사용자 테이블의 DELFLAG를 'N' 에서 'Y'로 변환하는 작업입니다.
     * 사용자의 아이디와 비밀번호를 입력하여 맞으면 리턴값으로 1, 실패하면 0을 리턴합니다.
     * @Param Service_Account_DTO
     * @return int
     */
    @Update(" UPDATE SERVICE_ACCOUNT SET DELFLAG='Y' WHERE SERVICE_ID=#{service_id} AND SERVICE_PW=#{service_pw} ")
    int resign(Service_Account_DTO dto);

    @Delete(" DELETE FROM AUTH WHERE (AUTH_KEY=#{auth_key} AND SERVICE_EMAIL=#{service_email}) OR REGDATE < (NOW()-1) ")
    int deleteAuth(Service_Email_DTO dto);

}
