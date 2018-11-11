package com.pos.system.service;

import com.pos.system.dto.Store_Table_DTO;

import java.util.List;

public interface IStore_Table_Service {


    /**
     * 서비스매장의 모든 테이블 목록을 반환하는 기능
     * @Param int store_seq 매장의 고유번호
     * @return List&lt;Store_Table_DTO&gt; 테이블의 리스트
     */
    public List<Store_Table_DTO> selectAll(int store_seq);

    /**
     * 테이블의 상제정보를 반환하는 기능
     * @Param table_seq 테이블의 고유번호
     * @return Store_Table_DTO
     */
    public Store_Table_DTO selectOne(int table_seq);

    /**
     * 테이블을 생성하는 기능
     * 반환값이 1이면 성공 0이면 실패
     * @param dto 매장정보
     * @return int
     */
    public int createTable(Store_Table_DTO dto);

    /**
     * 서비스매장의 테이블의 상세 정보를 수정하는 기능
     * dto의 매장 고유 번호의 값으로 테이블을 찾아서
     * 나머지 값으로 테이블의 정보를 변경합니다.
     * 변경에 실패하면 null 을 반환합니다.
     * @param dto
     * @return Store_Table_DTO
     */
    public Store_Table_DTO modifyTable(Store_Table_DTO dto);

    /**
     * 서비스 매장의 테이블 하나를 삭제하는 기능
     * 실제로 데이터베이스에서 삭제하지는 않습니다.
     * @param int 테이블의 고유번호
     * @return int 성공시 1, 실패시 0
     */
    public int deleteTable(int table_seq);

}
