package com.pos.system.controller;

import com.pos.system.dto.Store_Category_DTO;
import com.pos.system.service.IStore_Category_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class Store_Category_Ctrl {

    private final IStore_Category_Service service;

    @Autowired
    public Store_Category_Ctrl(IStore_Category_Service service) {
        this.service = service;
    }

    @RequestMapping(value = "/category", method ={ RequestMethod.POST,RequestMethod.GET})
    public String home(){
        System.out.println("-----------------------------성현이 테스트-----------------------------");

        System.out.println("모든 메뉴 조회 리턴값 : "+service.selectAll(1));
        Store_Category_DTO dto = new Store_Category_DTO();
        dto.setCateg_name("커피");
        dto.setStore_seq(1);
        System.out.println("카테고리별 조회 리턴값 : "+service.categSelect(dto));
//        Store_Category_DTO dto = new Store_Category_DTO();
//        dto.setStore_seq(6);
//        dto.setCateg_name("쥬스");
//        dto.setMenu_info("꿀맛");
//        dto.setMenu_name("오륀지 쥬스");
//        dto.setMenu_price(20000);
//        dto.setOrigin_fname("123jpg");
//        dto.setStored_fname("12321jpg");
//        System.out.println("메뉴 생성 리턴값 : "+service.createMenu(dto));

        System.out.println("메뉴 상세정보보기 리턴값 : "+ service.selectOne(1));
//        Store_Category_DTO dto = new Store_Category_DTO();
//        dto.setMenu_seq(1);
//        dto.setMenu_name("카푸치노");
//        dto.setStored_fname("바뀐이름");
//        dto.setOrigin_fname("기존이름");
//        dto.setMenu_price(20000);
//        dto.setMenu_info("바뀐 설정");
//        dto.setCateg_name("바뀐카테고리");
//        //#{menu_name},CATEG_NAME=#{categ_name},MENU_INFO=#{menu_info},ORIGIN_FNAME=#{origin_fname},STORED_FNAME=#{stored_fname}, MENU_PRICE=#{menu_price} ")
//        System.out.println("메뉴 수정하기 리턴값 : "+ service.modify(dto));

//         Store_Category_DTO dto = new Store_Category_DTO();
//         dto.setMenu_seq(4);
//         System.out.println("메뉴 삭제하기 리턴값 : "+ service.deleteMenu(dto));

        System.out.println("-----------------------------성현이 테스트-----------------------------");

        return "index";
    }


}
