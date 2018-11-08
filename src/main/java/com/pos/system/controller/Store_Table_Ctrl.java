package com.pos.system.controller;


import com.pos.system.dto.Store_Table_DTO;
import com.pos.system.mapper.Store_Table_Create_Mapper;
import com.pos.system.mapper.Store_Table_Delete_Mapper;
import com.pos.system.mapper.Store_Table_Read_Mapper;
import com.pos.system.mapper.Store_Table_Update_Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Store_Table_Ctrl {



    private final Store_Table_Create_Mapper mapper_Create;
    private final Store_Table_Read_Mapper mapper_Read;
    private final Store_Table_Update_Mapper mapper_Update;
    private final Store_Table_Delete_Mapper mapper_Delete;

    @Autowired
    public Store_Table_Ctrl(Store_Table_Create_Mapper mapper_Create, Store_Table_Read_Mapper mapper_Read, Store_Table_Update_Mapper mapper_Update, Store_Table_Delete_Mapper mapper_Delete) {
        this.mapper_Create = mapper_Create;
        this.mapper_Read = mapper_Read;
        this.mapper_Update = mapper_Update;
        this.mapper_Delete = mapper_Delete;
    }



    @RequestMapping(value = "/table", method = {RequestMethod.GET,RequestMethod.POST})
    public String home(){

        System.out.println("-----------------------------성현이 테스트-----------------------------");
            System.out.println("모든 테이블 조회 리턴값 : "+ mapper_Read.selectAll(1));
            System.out.println("모든 테이블 조회 리턴값 : "+ mapper_Read.selectOne(1));
            System.out.println("테이블 삭제 리턴값: "+ mapper_Delete.deleteTable(1) );

            Store_Table_DTO dto = new Store_Table_DTO();
            dto.setStore_seq(3);
            dto.setTable_name("4번");
            dto.setReservation("N");
            dto.setMax_people(70);
            dto.setMin_people(20);

            System.out.println("테이블 생성 리턴값: "+ mapper_Create.createTable(dto) );

            dto.setMax_people(10);
            dto.setMin_people(5);
            dto.setTable_name("5번테이블로");
            dto.setReservation("Y");
            dto.setTable_seq(4);
            System.out.println("테이블 수정 리턴값: "+ mapper_Update.modifyTable(dto));







        System.out.println("-----------------------------성현이 테스트-----------------------------");
        return "index";

    }


}
