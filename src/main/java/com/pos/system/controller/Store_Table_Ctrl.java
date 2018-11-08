package com.pos.system.controller;


import com.pos.system.dto.Store_Table_DTO;
import com.pos.system.service.IStore_Table_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Store_Table_Ctrl {

    private final IStore_Table_Service service;

    @Autowired
    public Store_Table_Ctrl(IStore_Table_Service service) {
        this.service = service;
    }





    @RequestMapping(value = "/table", method = {RequestMethod.GET,RequestMethod.POST})
    public String home(){
    System.out.println(" 전체조회 리턴값 :  " + service.selectAll(1));
    System.out.println(" 세부사항 조회 리턴값 :  " + service.selectOne(1));
        Store_Table_DTO dto = new Store_Table_DTO();
        dto.setTable_name("1번");
        dto.setMax_people(5);
        dto.setMin_people(2);
        dto.setReservation("N");
        dto.setStore_seq(1);
    System.out.println(" 테이블 생성 리턴값 :  " + service.createTable(dto));

        dto.setTable_name("바뀐것");
        dto.setReservation("Y");
        dto.setMax_people(2000);
        dto.setMin_people(1000);

    System.out.println(" 테이블 수정 리턴값 :  " + service.modifyTable(dto));

    System.out.println(" 테이블 삭제 리턴값 :  " + service.deleteTable(1));









        System.out.println("-----------------------------성현이 테스트-----------------------------");
        return "index";

    }


}
