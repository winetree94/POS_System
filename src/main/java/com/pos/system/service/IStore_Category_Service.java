package com.pos.system.service;

import com.pos.system.dto.Store_Category_DTO;

import java.util.List;

public interface IStore_Category_Service {

    /**
     * 특정 매장의 고유번호로 그 매장의 전체 메뉴 목록을 반환하는 기능
     * @Param int 매장 고유번호
     * @return &lt;Service_Store_DTO&gt; 메뉴의 리스트
     */
    public List<Store_Category_DTO> selectAll(int store_seq);

    /**
     * 특정 매장의 카테고리별 메뉴를 조회하는 기능
     * @Param dto 매장 seq 번호와 카테고리 이름
     * @return List&lt;Store_Category_DTO&gt; 메뉴의 리스트
     */
    public List<Store_Category_DTO> categSelect(Store_Category_DTO dto);

    /**
     * 메뉴를 생성하고 생성된 메뉴를 보여주는 기능
     * 반환값이 1이면 성공 0이면 실패
     * @param dto 매장정보
     * @return int
     */
    public int createMenu(Store_Category_DTO dto);

    /**
     * 메뉴의 상세정보를 조회하는 기능
     * @param menu_name 메뉴 이름
     * @return Store_Category_DTO 메뉴의 상세 정보
     */
    public Store_Category_DTO selectOne(int menu_seq);

    /**
     * 메뉴의 정보를 수정하는 기능
     * dto의 메뉴고유 번호의 값으로 메뉴을 찾아서
     * 나머지 값으로 메뉴의 정보를 변경합니다.
     * 변경에 실패하면 0 을 반환합니다.
     * @param dto
     * @return int
     */
    public Store_Category_DTO modifyMenu(Store_Category_DTO dto);

    /**
     * 메뉴를 삭제하는 기능
     * 메뉴seq의 값을 입력하여 메뉴 테이블의 delflag를 Y로 변환합니다.
     * 삭제 실패하면 0 을 반환합니다.
     * @param dto
     * @return int
     */
    public int deleteMenu(int menu_seq);


}
