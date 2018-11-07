package com.pos.system.service;

import com.pos.system.dto.Store_Category_DTO;

import java.util.List;

public interface IStore_Category_Service {

    //전체 메뉴를 조회하는 기능
    public List<Store_Category_DTO> selectAll();

    //카테고리별 메뉴의 목록을 조회하는 기능
    public List<Store_Category_DTO> categSelect(String categ_name);

    //새로운 메뉴 추가하는 기능
    public int createMenu(Store_Category_DTO dto);

    //메뉴를 상세정보를 조회하는 기능
    public Store_Category_DTO selectOne(String menu_name);

    // 메뉴를 수정하는 기능
    public int modify(Store_Category_DTO dto);

    //메뉴 삭제 기능
    public int deleteMenu(Store_Category_DTO dto);


}
