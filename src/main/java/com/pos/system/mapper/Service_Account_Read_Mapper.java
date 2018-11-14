package com.pos.system.mapper;

import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Service_Account_Read_Mapper {

    /**
     * 모든 서비스 사용자를 조회하는 기능입니다.
     * 삭제한 사용자는 조회되지 않습니다.
     * @Param 없음
     * @return List&lt;Service_Account_DTO&gt;
     */
    @Select(" SELECT * FROM SERVICE_ACCOUNT WHERE DELFLAG='N' ")
    List<Service_Account_DTO> selectAll();



    /**
     * 서비스 사용자의 상세 정보를 조회합니다.
     * @Param String service_id
     * @return Service_Account_DTO
     */
    @Select(" SELECT SERVICE_ID, SERVICE_PW, SERVICE_EMAIL,SERVICE_TYPE,REGDATE, DELFLAG FROM SERVICE_ACCOUNT WHERE SERVICE_ID = #{service_id} AND SERVICE_PW= #{service_pw} ")
    Service_Account_DTO selectOne(Service_Account_DTO dto);


    /**
     * 회원 가입시 사용자가 조회할 아이디를 입력하여 아이디 중복검사를 하는 기능입니다
     * 결과값은 중복되는 숫자로서 0이면 아이디 사용 가능, 1이상이면 아이디 중복을 의미합니다.
     * @Param String
     * @return int
     */
    @Select(" SELECT COUNT(*) FROM SERVICE_ACCOUNT WHERE SERVICE_ID = #{id} ")
    int idDuplicate(String id);


    /**
     * 회원 가입 완료한 사용자가 로그인 하는 기능입니다.
     * 사용자가 아이디와 비밀번호를 입력하여 리턴 Service_Account_DTO의 아이디가 null이면 로그인 실패, 아이디가 있으면 로그인 성공.
     * @Param Service_Account_DTO
     * @return Service_Account_DTO
     */
    @Select(" SELECT SERVICE_ID,SERVICE_TYPE FROM SERVICE_ACCOUNT WHERE SERVICE_ID=#{service_id} AND SERVICE_PW=#{service_pw} ")
    Service_Account_DTO login(Service_Account_DTO dto);

    //아이디 상세정보.
    @Select(" SELECT SERVICE_ID, SERVICE_EMAIL,SERVICE_TYPE, REGDATE, DELFLAG FROM SERVICE_ACCOUNT WHERE SERVICE_ID=#{service_id}")
    Service_Account_DTO accountDetail(String service_id);


}
