package com.pos.system.service.impl;

import com.pos.system.dto.Store_Category_DTO;
import com.pos.system.mapper.Store_Category_Create_Mapper;
import com.pos.system.mapper.Store_Category_Delete_Mapper;
import com.pos.system.mapper.Store_Category_Read_Mapper;
import com.pos.system.mapper.Store_Category_Update_Mapper;
import com.pos.system.service.IStore_Category_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStore_Category_Service_Impl implements IStore_Category_Service {

    private Store_Category_Create_Mapper mapper_Create;
    private Store_Category_Read_Mapper mapper_Read;
    private Store_Category_Update_Mapper mapper_Update;
    private Store_Category_Delete_Mapper mapper_Delete;

    public IStore_Category_Service_Impl(Store_Category_Create_Mapper mapper_Create, Store_Category_Read_Mapper mapper_Read, Store_Category_Update_Mapper mapper_Update, Store_Category_Delete_Mapper mapper_Delete) {
        this.mapper_Create = mapper_Create;
        this.mapper_Read = mapper_Read;
        this.mapper_Update = mapper_Update;
        this.mapper_Delete = mapper_Delete;
    }

    //전체 메뉴를 조회하는 기능
    public List<Store_Category_DTO> selectAll(){
        return mapper_Read.selectAll();
    }

    //카테고리별 메뉴의 목록을 조회하는 기능
    public List<Store_Category_DTO> categSelect(String categ_name){
        return mapper_Read.categSelect(categ_name);
    }


    //새로운 메뉴 추가하는 기능
    public int createMenu(Store_Category_DTO dto){
        return mapper_Create.createMenu(dto);
    }

    //메뉴를 상세정보를 조회하는 기능
    public Store_Category_DTO selectOne(String menu_name){
        return mapper_Read.selectOne(menu_name);
    }

    // 메뉴를 수정하는 기능
    public int modify(Store_Category_DTO dto){
        return mapper_Update.modify(dto);
    }

    //메뉴 삭제 기능
    public int deleteMenu(Store_Category_DTO dto){
        return mapper_Delete.deleteMenu(dto);
    }



}
