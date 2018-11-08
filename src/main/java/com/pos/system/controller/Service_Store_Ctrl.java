package com.pos.system.controller;

import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.service.IService_Store_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Service_Store Controller
 * REST Design Pattern 적용
 * @author windtree
 */
@Controller(value = "stores")
public class Service_Store_Ctrl {

	private final IService_Store_Service service;
	
	@Autowired
	public Service_Store_Ctrl(IService_Store_Service service) {
		this.service = service;
	}
	
	
	/**
	 * 매장 목록 출력
	 * @param req
	 * @return
	 */
	@GetMapping("/stores")
	public String store_List(WebRequest req, HttpSession session){
		System.out.println("store_list form");
		
		// 실제로는 세션에서 아이디를 가져와서 처리함.
		// String service_id = (String)session.getAttribute("id");
		session.setAttribute("id", "winetree");
		String service_id = "winetree"; //테스트
		List<Service_Store_DTO> stores_list = service.selectAllStore(service_id);
		req.setAttribute("stores_list", stores_list, req.SCOPE_REQUEST);
		
		System.out.println("g");
		
		return "./view/stores/stores-list";
	}
	
	/**
	 * 매장 추가 화면
	 * @param
	 * @param
	 * @return
	 */
	@GetMapping("/stores/new")
	public String store_new_form(){
		System.out.println("Stores_new_Form");
		return "./view/stores/stores-new";
	}
	
	/**
	 * 매장 등록 처리
	 * @param req
	 * @return
	 */
	@PostMapping("/stores")
	public String store_new(HttpServletRequest request, HttpSession session){
		System.out.println("Stores_New_Logic");

		Service_Store_DTO dto = new Service_Store_DTO();
		
		String service_id = (String)session.getAttribute("id");
		String store_name = request.getParameter("store_name");
		String store_detail = request.getParameter("store_detail");
		String store_type = request.getParameter("store_type");
		String store_address = request.getParameter("store_address");
		String store_tel = request.getParameter("store_tel");
		String store_hour = request.getParameter("store_hour");
		
		dto.setService_id(service_id);
		dto.setStore_name(store_name);
		dto.setStore_detail(store_detail);
		dto.setStore_type(store_type);
		dto.setStore_address(store_address);
		dto.setStore_tel(store_tel);
		dto.setStore_hour(store_hour);
		try {
			service.createStore(dto);
		} catch(Exception e){
			e.printStackTrace();
			return "./view/comm/error";
		}
		return "./view/stores/stores-list";
	}
	
	/**
	 * 매장 세부정보 화면
	 * @param id
	 * @return
	 */
	@GetMapping("/stores/{id}")
	public String store_detail(@PathVariable("id") String id){
		
		
		
		
		
		
		return "./view/stores/stores-detail";
	}
	
	/**
	 * 매장 정보 수정 화면
	 * @param id
	 * @return
	 */
	@GetMapping("/stores/{id}/edit")
	public String store_edit(@PathVariable("id") String id){
		
		
		
		
		
		
		return "./view/stores/stores-new";
	}
	
	/**
	 * 매장 정보 수정 처리
	 * @param id
	 * @return
	 */
	@PutMapping("/stores/{id}")
	public String store_edit_confirm(@PathVariable("id") String id) {
		
		
		
		
		
		
		return "redirect:/stores/"+id;
	}
	
	/**
	 * 매장 삭제 처리
	 * @param id
	 * @return
	 */
	@DeleteMapping("/stores/{id}")
	public String store_delete(@PathVariable("id") String id){
		
		
		
		
		
		
		
		return "redirect:/stores";
	}
	
}