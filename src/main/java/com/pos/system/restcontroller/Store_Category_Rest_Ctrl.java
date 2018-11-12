package com.pos.system.restcontroller;


import com.pos.system.dto.Store_Category_DTO;
import com.pos.system.service.IStore_Category_Service;
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
public class Store_Category_Rest_Ctrl {

    private IStore_Category_Service service;

    @Autowired
    public Store_Category_Rest_Ctrl(IStore_Category_Service service) {
        this.service = service;
    }



    @GetMapping("/{store_seq}/category")
    public String test(	HttpServletRequest request,
                           HttpServletResponse response,
                           HttpSession session,
                           @PathVariable("store_seq") String store_seq) {


       //  #{store_seq},#{menu_name},#{categ_name},#{menu_info},#{origin_fname},#{stored_fname},#{menu_price

            Store_Category_DTO dto = new Store_Category_DTO();
            dto.setStore_seq(Integer.parseInt(store_seq));
            dto.setMenu_name("김밥");
            dto.setCateg_name("요리");
            dto.setMenu_info("유기농 야채로 만든 꿀김밥");
            dto.setOrigin_fname("오리지날파일");
            dto.setStored_fname("저장된파일");
            dto.setMenu_price(2000);

            System.out.println("메뉴 카테고리 전체 조회 리턴값 :  "+  service.selectAll(1));
            System.out.println("메뉴 카테고리 상세 조회 리턴값 :  "+  service.selectOne(1));
            System.out.println("메뉴 생성 리턴값 :  "+  service.createMenu(dto));

            Store_Category_DTO hdto = new Store_Category_DTO();
            hdto = service.selectOne(2);
            hdto.setMenu_price(50000);
            hdto.setMenu_info("최고급재료로인해 가격이 상승되었습니다.");
            System.out.println("메뉴 카테고리 수정 리턴값 :  "+  service.modify(hdto));
            System.out.println("메뉴 삭제 리턴값 : " + service.deleteMenu(3));







        return null;
    }

}
