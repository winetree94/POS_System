package com.pos.system.restcontroller;

import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.dto.Store_Table_DTO;
import com.pos.system.service.IStore_Table_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Store_Table_Rest Controller
 * REST Design Pattern 적용
 * @author DEADxFOOL
 */
@RestController
@RequestMapping("/api")
public class Store_Table_Rest_Ctrl {

    private IStore_Table_Service service;

    @Autowired
    public Store_Table_Rest_Ctrl(IStore_Table_Service service) {
        this.service = service;
    }

    /**
     * 모든 테이블 정보를 출력하는 기능
     * @param \store_seq 매장의 고유번호
     * @return JSON 형태의 모든 테이블의 세부 정보.
     */
    @GetMapping("/table")
    public List<Store_Table_DTO> table(	HttpSession session){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        return service.selectAll(store.getStore_seq());
    }

    /**
     * 테이블을 생성하는 기능
     * @param \store_seq:매장번호, table_name:테이블 이름, reservation:예약여부, min_people:가용 최소인원, max_people:가용 최대인원
     * @return int 1이면 테이블 생성성공, 0이면 실패
     */
    @PostMapping("/table")
    public int createTable(HttpSession session,
                           @RequestParam("table_name")String table_name,
                           @RequestParam("reservation")String reservation,
                           @RequestParam("min_people")String min_people,
                           @RequestParam("max_people")String max_people

                        ){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        Store_Table_DTO dto = new Store_Table_DTO();
        dto.setStore_seq(store.getStore_seq());
        dto.setTable_name(table_name);
        dto.setReservation(reservation);
        dto.setMin_people(Integer.parseInt(min_people));
        dto.setMax_people(Integer.parseInt(max_people));
       // store_seq},#{table_name},#{reservation},#{min_people},#{max_people
         return service.createTable(dto);
    }

    /**
     * 테이블의 세부정보를 수정하는 기능
     * @param \store_seq:매장번호, table_seq:테이블 번호, table_name:테이블 이름, reservation:예약여부, min_people:가용 최소인원, max_people:가용 최대인원
     * @return JSON형태의 수정된 테이블 세부정보
     */
    @PutMapping("/table/{table_seq}")
    public Store_Table_DTO modifyTable(
            HttpSession session,
            @PathVariable("table_seq") String table_seq,
            @RequestParam("table_name") String table_name,
            @RequestParam("reservation") String reservation,
            @RequestParam("min_people") String min_people,
            @RequestParam("max_people") String max_people

            //table_name},RESERVATION=#{reservation}, MIN_PEOPLE=#{min_people},MAX_PEOPLE=#{max_people}
    ){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        Store_Table_DTO dto = new Store_Table_DTO();
        dto.setStore_seq(store.getStore_seq());
        dto.setTable_seq(Integer.parseInt(table_seq));
        dto =service.selectOne(dto);

        dto.setMax_people(Integer.parseInt(max_people));
        dto.setMin_people(Integer.parseInt(min_people));
        dto.setTable_name(table_name);
        dto.setReservation(reservation);
        dto.setTable_seq(Integer.parseInt(table_seq));

        return service.modifyTable(dto);
    }



    /**
     * 테이블 상세정보를 조회하는 기능
     * @param \store_seq:매장고유번호, table_seq:예약고유번호
     * @return JSON형태의 테이블 세부정보
     */
    @GetMapping("/table/{table_seq}")
    public Store_Table_DTO tableDetail(
            HttpSession session,
            @PathVariable("table_seq") String table_seq
    ) {
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        Store_Table_DTO dto = new Store_Table_DTO();
        dto.setStore_seq(store.getStore_seq());
        dto.setTable_seq(Integer.parseInt(table_seq));

        return service.selectOne(dto);
    }



    /**
     * 테이블을 삭제하는 기능.
     * 테이블을 데이터베이스에서 삭제하는게 아닌 DELFLAG 칼럼의 값을 'N'에서 'Y'로 변환하는 기능
     * @param \store_seq:매장 고유번호, table_seq:테이블 고유번호
     * @return int 1이면 삭제성공, 0이면 실패.
     */
    @DeleteMapping("/table/{table_seq}")
    public int deleteTable( HttpSession session,
                             @PathVariable("table_seq") String table_seq){

        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        Store_Table_DTO dto = new Store_Table_DTO();
        dto.setStore_seq(store.getStore_seq());
        dto.setTable_seq(Integer.parseInt(table_seq));
        return service.deleteTable(dto);
    }




//
//    @GetMapping("/{store_seq}/table")
//    public String test(	HttpServletRequest request,
//                           HttpServletResponse response,
//                           HttpSession session,
//                           @PathVariable("store_seq") String store_seq){
//
//        Store_Table_DTO dto = new Store_Table_DTO();
//        dto.setStore_seq(Integer.parseInt(store_seq));
//        dto.setTable_name("1번테이블");
//        dto.setReservation("Y");
//        dto.setMin_people(4);
//        dto.setMax_people(10);
//
//        System.out.println("테이블 만들기 리턴값 : " + service.createTable(dto));
//        System.out.println("모든테이블 조회 리턴값 : " + service.selectAll(Integer.parseInt(store_seq)));
//        System.out.println("테이블 상세 조회 리턴값 : " + service.selectOne(2));
//        Store_Table_DTO hdto = new Store_Table_DTO();
//        hdto = service.selectOne(1);
//        hdto.setMax_people(200);
//        hdto.setMin_people(10);
//        System.out.println("테이블 수정 리턴값 : " + service.modifyTable(hdto));
//        System.out.println("테이블 삭제 리턴값 : " + service.deleteTable(3));
//
//        //(#{store_seq},#{table_name},#{reservation},#{min_people},#{max_people})
//
//        return null;
//    }



}
