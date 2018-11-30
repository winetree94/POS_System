package com.pos.system.restcontroller;


import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.dto.Store_Category_DTO;
import com.pos.system.service.IStore_Category_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Store_Category_Rest Controller
 * REST Design Pattern 적용
 * @author DEADxFOOL
 */
@RestController
@RequestMapping("/api")
public class Store_Category_Rest_Ctrl {

    private IStore_Category_Service service;

    @Autowired
    public Store_Category_Rest_Ctrl(IStore_Category_Service service) {
        this.service = service;
    }

    @GetMapping("/menu")
    public List<HashMap<String, Object>> categ(HttpSession session){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");

        return service.categList(store.getStore_seq());
    }

    /**
     * 모든 메뉴를 출력하는 기능
     * @param \store_seq 매장의 고유번호
     * @return JSON 형태의 모든 메뉴의 세부 정보.
     */
    @GetMapping("/menu1")
    public List<HashMap<String, Object>> menu(HttpSession session){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");

        return service.selectAll(store.getStore_seq());
       }

    /**
     * 메뉴를 생성하는 기능
     * @param \store_seq:매장번호, menu_name:메뉴이름, categ_name:카테고리 이름, menu_info메뉴정보, origin_fname:원본파일이름,
     *        \stored_fname:저장된파일이름, menu_price:메뉴가격
     * @return int 1이면 메뉴생성성공, 0이면 실패
     */
    @PostMapping("/menu")
    public int createMenu(HttpSession session,
                          @RequestParam("menu_name") String menu_name,
                          @RequestParam("categ_name") String categ_name,
                          @RequestParam("menu_info") String menu_info,
                          @RequestParam("origin_fname") String origin_fname,
                          @RequestParam("stored_fname") String stored_fname,
                          @RequestParam("menu_price") String menu_price
                          ){

        Store_Category_DTO dto = new Store_Category_DTO();
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        dto.setStore_seq(store.getStore_seq());
        dto.setMenu_name(menu_name);
        dto.setCateg_name(categ_name);
        dto.setMenu_info(menu_info);
        dto.setOrigin_fname(origin_fname);
        dto.setStored_fname(stored_fname);
        dto.setMenu_price(Integer.parseInt(menu_price));
        //store_seq},#{menu_name},#{categ_name},#{menu_info},#{origin_fname},#{stored_fname},#{menu_price}

        return service.createMenu(dto);
    }


    /**
     * 메뉴를 수정하는 기능
     * @param \store_seq:매장고유번호, menu_name:메뉴이름, categ_name:카테고리 이름, menu_info메뉴정보, origin_fname:원본파일이름,
     *        \stored_fname:저장된파일이름, menu_price:메뉴가격
     * @return JSON형태의 수정된 메뉴 세부정보
     */
    @PutMapping("/menu/{menu_seq}")
    public Store_Category_DTO modifyMenu(HttpSession session,
                                     @PathVariable("menu_seq") String menu_seq,
                                     @RequestParam("menu_name") String menu_name,
                                     @RequestParam("categ_name") String categ_name,
                                     @RequestParam("menu_info") String menu_info,
                                     @RequestParam("origin_fname") String origin_fname,
                                     @RequestParam("stored_fname") String stored_fname,
                                     @RequestParam("menu_price") String menu_price){

        Store_Category_DTO dto = new Store_Category_DTO();
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        dto.setStore_seq(store.getStore_seq());
        dto.setMenu_seq(Integer.parseInt(menu_seq));
        System.out.println("작동");
        System.out.println(dto);


        //MENU_NAME=#{menu_name},CATEG_NAME=#{categ_name},MENU_INFO=#{menu_info},ORIGIN_FNAME=#{origin_fname},STORED_FNAME=#{stored_fname}, MENU_PRICE=#{menu_price}
        dto.setMenu_name(menu_name);
        dto.setCateg_name(categ_name);
        dto.setMenu_info(menu_info);
        dto.setOrigin_fname(origin_fname);
        dto.setStored_fname(stored_fname);
        dto.setMenu_price(Integer.parseInt(menu_price));
        return service.modifyMenu(dto);
    }

    /**
     * 메뉴의 상세정보를 조회하는 기능
     * @param \store_seq:매장고유번호, menu_seq:메뉴고유번호
     * @return JSON형태의 메뉴의 세부정보
     */
    @GetMapping("/menu/{menu_seq}")
    public Store_Category_DTO menuDetail(@PathVariable("menu_seq") String menu_seq, HttpSession session){
        Store_Category_DTO dto = new Store_Category_DTO();
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        dto.setStore_seq(store.getStore_seq());
        dto.setMenu_seq(Integer.parseInt(menu_seq));
        dto = service.selectOne(dto);


        return service.selectOne(dto);
    }

    /**
     * 카테고리별 메뉴의 정보를 조회하는 기능
     * @param \store_seq:매장고유번호, menu_seq:메뉴고유번호
     * @return JSON형태의 카테고리별 메뉴의 세부정보
     */
    @GetMapping("/category/menulists/{categ_name}")
    public List<Store_Category_DTO> category1(HttpSession session,
                                             @PathVariable("categ_name") String categ_name){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        Store_Category_DTO dto = new Store_Category_DTO();
        dto.setStore_seq(store.getStore_seq());
        dto.setCateg_name(categ_name);
        return service.categSelect(dto);
    }

    /**
     * 메뉴를 삭제하는 기능.
     * 메뉴를 데이터베이스에서 삭제하는게 아닌 DELFLAG 칼럼의 값을 'N'에서 'Y'로 변환하는 기능
     * @param \store_seq:매장고유번호, menu_seq:메뉴고유번호
     * @return int 1이면 삭제성공, 0이면 실패.
     */
    @DeleteMapping("/menu/{menu_seq}")
    public int deleteMenu(@PathVariable("menu_seq") String menu_seq , HttpSession session){
        Service_Store_DTO store = (Service_Store_DTO)session.getAttribute("store");
        Store_Category_DTO dto = new Store_Category_DTO();
        dto.setMenu_seq(Integer.parseInt(menu_seq));
        dto.setStore_seq(store.getStore_seq());

        return service.deleteMenu(dto);
    }


//    @GetMapping("/{store_seq}/category")
//    public String test(	HttpServletRequest request,
//                           HttpServletResponse response,
//                           HttpSession session,
//                           @PathVariable("store_seq") String store_seq) {
//
//
//       //  #{store_seq},#{menu_name},#{categ_name},#{menu_info},#{origin_fname},#{stored_fname},#{menu_price
//
//            Store_Category_DTO dto = new Store_Category_DTO();
//            dto.setStore_seq(Integer.parseInt(store_seq));
//            dto.setMenu_name("김밥");
//            dto.setCateg_name("요리");
//            dto.setMenu_info("유기농 야채로 만든 꿀김밥");
//            dto.setOrigin_fname("오리지날파일");
//            dto.setStored_fname("저장된파일");
//            dto.setMenu_price(2000);
//
//            System.out.println("메뉴 카테고리 전체 조회 리턴값 :  "+  service.selectAll(1));
//            System.out.println("메뉴 카테고리 상세 조회 리턴값 :  "+  service.selectOne(1));
//            System.out.println("메뉴 생성 리턴값 :  "+  service.createMenu(dto));
//
//            Store_Category_DTO hdto = new Store_Category_DTO();
//            hdto = service.selectOne(2);
//            hdto.setMenu_price(50000);
//            hdto.setMenu_info("최고급재료로인해 가격이 상승되었습니다.");
//            System.out.println("메뉴 카테고리 수정 리턴값 :  "+  service.modify(hdto));
//            System.out.println("메뉴 삭제 리턴값 : " + service.deleteMenu(3));
//
//
//
//
//
//
//
//        return null;
//    }

}
