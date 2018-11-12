package com.pos.system.restcontroller;

import com.pos.system.dto.Store_Reservation_DTO;
import com.pos.system.service.IStore_Reservation_Service;
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
public class Store_Reservation_Rest_Ctrl {
    private IStore_Reservation_Service service;

    @Autowired
    public Store_Reservation_Rest_Ctrl(IStore_Reservation_Service service) {
        this.service = service;
    }

    @GetMapping("/{store_seq}/reservation")
    public String test(	HttpServletRequest request,
                           HttpServletResponse response,
                           HttpSession session,
                           @PathVariable("store_seq") String store_seq) {

        Store_Reservation_DTO dto = new Store_Reservation_DTO();


             dto.setStore_seq(Integer.parseInt(store_seq));
             dto.setReserv_people(100);
             dto.setTable_seq(3);
             dto.setUser_id("hansol");
             dto.setReserv_time("2020-11-12 14:09:03");
            System.out.println(" 새로운 예약 생성 리턴값 : " + service.createReserv(dto));
//        System.out.println(" 예약 상세정보 보기 리턴값 : " + service.selectOne(2));
//
//        dto = service.selectOne(3);
//        dto.setReserv_people(40);
//        System.out.println(" 예약 수정 리턴값 : " + service.modifyReserv(dto));
//        System.out.println("모든 예약정보 조회 리턴값 : " + service.selectAll(1));
//        System.out.println("예약정보 삭제 리턴값 : " + service.deleteReserv(2));


        //모든 예약조회,예약상세정보,새로운 예약 생성, 예약상세정보수정, 예약정보 삭제.
        //{store_Seq},#{table_Seq},#{user_id},NOW(),#{reserv_people},'N'


        return null;
    }




    }
