package com.pos.system.restcontroller;

import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.dto.Store_Reservation_DTO;
import com.pos.system.service.IStore_Reservation_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Store_Reservation_Rest Controller
 * REST Design Pattern 적용
 * @author DEADxFOOL
 */
@RestController
@RequestMapping("/api")
public class Store_Reservation_Rest_Ctrl {
    private IStore_Reservation_Service service;

    @Autowired
    public Store_Reservation_Rest_Ctrl(IStore_Reservation_Service service) {
        this.service = service;
    }

    /**
     * 모든 예약 정보를 출력하는 기능
     * @param \store_seq 매장의 고유번호
     * @return JSON 형태의 모든 예약의 세부 정보.
     */
    @GetMapping("/reservation")
    public List<Store_Reservation_DTO> reservation(HttpSession session){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");

        return service.selectAll(store.getStore_seq());
    }

    /**
     * 예약을 생성하는 기능
     * @param \store_seq:매장번호, table_seq:테이블번호, user_id:예약하는 사용자아이디, reserv_time:예약 시간, reserv_people:예약인원
     * @return int 1이면 메뉴생성성공, 0이면 실패
     */
    @PostMapping("/reservation")
    public int createReserv(HttpSession session,
                            @RequestParam("table_seq") String table_seq,
                            @RequestParam("user_id") String user_id,
                            @RequestParam("reserv_time") String reserv_time,
                            @RequestParam("reserv_people") String reserv_people
                            ){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        Store_Reservation_DTO dto = new Store_Reservation_DTO();
        dto.setStore_seq(store.getStore_seq());
        dto.setTable_seq(Integer.parseInt(table_seq));
        dto.setUser_id(user_id);
        dto.setReserv_time(reserv_time);
        dto.setReserv_people(Integer.parseInt(reserv_people));

        //store_seq},#{table_seq},#{user_id},#{reserv_time},#{reserv_people
        return service.createReserv(dto);
    }


    /**
     * 예약의 세부정보를 수정하는 기능
     * @param \store_seq:매장번호, reserv_seq:예약번호 table_seq:테이블번호, user_id:예약하는 사용자아이디, reserv_time:예약 시간, reserv_people:예약인원
     * @return JSON형태의 수정된 예약 세부정보
     */
    @PutMapping("/reservation/{reserv_seq}")
    public Store_Reservation_DTO modifyReservation(HttpSession session,
                                                   @PathVariable("reserv_seq") String reserv_seq,
                                                   @RequestParam("table_seq") String table_seq,
                                                   @RequestParam("reserv_time") String reserv_time,
                                                   @RequestParam("reserv_people") String reserv_people){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        Store_Reservation_DTO dto = new Store_Reservation_DTO();
        dto.setStore_seq(store.getStore_seq());
        dto.setReserv_seq(Integer.parseInt(reserv_seq));
        dto = service.selectOne(dto);

        dto.setTable_seq(Integer.parseInt(table_seq));
        dto.setReserv_time(reserv_time);
        dto.setReserv_people(Integer.parseInt(reserv_people));
        //#{table_seq},RESERV_TIME=#{reserv_time}, RESERV_PEOPLE=#{reserv_people}

        return service.modifyReserv(dto);
    }

    /**
     * 예약 상세정보를 조회하는 기능
     * @param \store_seq:매장고유번호, reserv_seq:예약고유번호
     * @return JSON형태의 예약 세부정보
     */
    @GetMapping("/reservation/{reserv_seq}")
    public Store_Reservation_DTO reservDetail(HttpSession session,
                                              @PathVariable("reserv_seq") String reserv_seq
                                           ){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        Store_Reservation_DTO dto = new Store_Reservation_DTO();
        dto.setStore_seq(store.getStore_seq());
        dto.setReserv_seq(Integer.parseInt(reserv_seq));
        return service.selectOne(dto);
    }

    /**
     * 예약을 삭제하는 기능.
     * 예약을 데이터베이스에서 삭제하는게 아닌 DELFLAG 칼럼의 값을 'N'에서 'Y'로 변환하는 기능
     * @param \store_seq:매장 고유번호, reserv_seq:예약 고유번호
     * @return int 1이면 삭제성공, 0이면 실패.
     */
    @DeleteMapping("/reservation/{reserv_seq}")
    public int deleteReserv(@PathVariable("reserv_seq") String reserv_seq, HttpSession session){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        Store_Reservation_DTO dto = new Store_Reservation_DTO();
        dto.setStore_seq(store.getStore_seq());
        dto.setReserv_seq(Integer.parseInt(reserv_seq));
        return service.deleteReserv(dto);
    }



//    @GetMapping("/{store_seq}/reservation")
//    public String test(	HttpServletRequest request,
//                           HttpServletResponse response,
//                           HttpSession session,
//                           @PathVariable("store_seq") String store_seq) {
//
//        Store_Reservation_DTO dto = new Store_Reservation_DTO();
//
//
//             dto.setStore_seq(Integer.parseInt(store_seq));
//             dto.setReserv_people(100);
//             dto.setTable_seq(3);
//             dto.setUser_id("hansol");
//             dto.setReserv_time("2020-11-12 14:09:03");
//            System.out.println(" 새로운 예약 생성 리턴값 : " + service.createReserv(dto));
////        System.out.println(" 예약 상세정보 보기 리턴값 : " + service.selectOne(2));
////
////        dto = service.selectOne(3);
////        dto.setReserv_people(40);
////        System.out.println(" 예약 수정 리턴값 : " + service.modifyReserv(dto));
////        System.out.println("모든 예약정보 조회 리턴값 : " + service.selectAll(1));
////        System.out.println("예약정보 삭제 리턴값 : " + service.deleteReserv(2));
//
//
//        //모든 예약조회,예약상세정보,새로운 예약 생성, 예약상세정보수정, 예약정보 삭제.
//        //{store_Seq},#{table_Seq},#{user_id},NOW(),#{reserv_people},'N'
//
//
//        return null;
//    }




    }
