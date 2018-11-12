package com.pos.system.restcontroller;

import com.pos.system.dto.Store_Table_DTO;
import com.pos.system.service.IStore_Table_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/pos")
public class Store_Table_Rest_Ctrl {

    private IStore_Table_Service service;

    @Autowired
    public Store_Table_Rest_Ctrl(IStore_Table_Service service) {
        this.service = service;
    }

    @GetMapping("/{store_seq}/table")
    public String test(	HttpServletRequest request,
                           HttpServletResponse response,
                           HttpSession session,
                           @PathVariable("store_seq") String store_seq){

        Store_Table_DTO dto = new Store_Table_DTO();
        dto.setStore_seq(Integer.parseInt(store_seq));
        dto.setTable_name("1번테이블");
        dto.setReservation("Y");
        dto.setMin_people(4);
        dto.setMax_people(10);

        System.out.println("테이블 만들기 리턴값 : " + service.createTable(dto));
        System.out.println("모든테이블 조회 리턴값 : " + service.selectAll(Integer.parseInt(store_seq)));
        System.out.println("테이블 상세 조회 리턴값 : " + service.selectOne(2));
        Store_Table_DTO hdto = new Store_Table_DTO();
        hdto = service.selectOne(1);
        hdto.setMax_people(200);
        hdto.setMin_people(10);
        System.out.println("테이블 수정 리턴값 : " + service.modifyTable(hdto));
        System.out.println("테이블 삭제 리턴값 : " + service.deleteTable(3));







        //(#{store_seq},#{table_name},#{reservation},#{min_people},#{max_people})

        return null;
    }



}
