package com.pos.system.service.impl;

import com.pos.system.dto.Store_Table_DTO;
import com.pos.system.mapper.Store_Table_Create_Mapper;
import com.pos.system.mapper.Store_Table_Delete_Mapper;
import com.pos.system.mapper.Store_Table_Read_Mapper;
import com.pos.system.mapper.Store_Table_Update_Mapper;
import com.pos.system.service.IStore_Table_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStore_Table_Service_Impl implements IStore_Table_Service {

    private Store_Table_Create_Mapper mapper_Create;
    private Store_Table_Read_Mapper mapper_Read;
    private Store_Table_Update_Mapper mapper_Update;
    private Store_Table_Delete_Mapper mapper_Delete;

    @Autowired
    public IStore_Table_Service_Impl(Store_Table_Create_Mapper mapper_Create, Store_Table_Read_Mapper mapper_Read, Store_Table_Update_Mapper mapper_Update, Store_Table_Delete_Mapper mapper_Delete) {
        this.mapper_Create = mapper_Create;
        this.mapper_Read = mapper_Read;
        this.mapper_Update = mapper_Update;
        this.mapper_Delete = mapper_Delete;
    }

    //전체조회
    public List<Store_Table_DTO> selectAll(int store_seq){
        return mapper_Read.selectAll(store_seq);
    }

    // 세부 조회
    public Store_Table_DTO selectOne(int table_seq){
        return mapper_Read.selectOne(table_seq) ;
    }

    //테이블 생성
    public int createTable(Store_Table_DTO dto){

        return mapper_Create.createTable(dto);
    }

    //테이블 수정

    public Store_Table_DTO modifyTable(Store_Table_DTO dto){
        int n = mapper_Update.modifyTable(dto);
        if(n>0){
            return mapper_Read.selectOne(dto.getTable_seq());
        }
        return null;
    }
    // 테이블 삭제
    public int deleteTable(int table_seq){
        return mapper_Delete.deleteTable(table_seq);
    }





}
