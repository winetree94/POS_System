package com.pos.system.controller;

import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.dto.Service_Store_DTO;
import com.pos.system.service.IService_Store_Service;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Service_Store Controller
 * REST Design Pattern 적용
 * @author winetree
 */
@RequestMapping("/stores")
@Controller
public class Service_Store_Ctrl {
	
	private final IService_Store_Service service;
	
	@Autowired
	public Service_Store_Ctrl(IService_Store_Service service) {
		this.service = service;
	}
	
	/**
	 * 매장 목록 출력
	 * @param \req
	 * @return
	 */
	@GetMapping("")
	public String store_List(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		
		Service_Account_DTO user = (Service_Account_DTO)session.getAttribute("user");
		List<Service_Store_DTO> stores_list = service.selectAllStore(user.getService_id());
		request.setAttribute("stores_list", stores_list);

		return "/WEB-INF/view/stores/stores-list.jsp";
	}
	
	
	

	
	
	
	
	/**
	 * 매장 추가 화면
	 * @param
	 * @param
	 * @return
	 */
	@GetMapping("new")
	public String store_new_form(){
		System.out.println("Stores_new_Form");
		return "/WEB-INF/view/stores/stores-new.jsp";
	}
	
	
	
	
	
	/**
	 * 매장 등록 처리
	 * @param \req\
	 * @return
	 */
	@PostMapping("")
	public String store_new(
		HttpServletRequest request, HttpServletResponse response, HttpSession session
	){
		System.out.println("---------------------------store_new_logic------------------------------");
		
		Service_Account_DTO user = (Service_Account_DTO)session.getAttribute("user");
		Service_Store_DTO dto = new Service_Store_DTO();
		
		String service_id = user.getService_id();
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
		
		System.out.println(dto);
		
		try {
			service.createStore(dto);
		} catch(Exception e){
			e.printStackTrace();
			return "redirect:/errorpage";
		}
		
		return "redirect:/stores";
	}
	
	
	
	
	
	
	
	
	/**
	 * 매장 세부정보 화면
	 * @param \id
	 * @return
	 */
	@GetMapping("{store_seq}")
	public String store_detail(
		HttpServletRequest request,
		HttpServletResponse response,
		HttpSession session,
		@PathVariable("store_seq") String store_seq
	){
		System.out.println("---------------------------store_detail form------------------------------");
		
		String service_id = (String)session.getAttribute("id");
		
		Service_Store_DTO stores_detail = service.selectStore(Integer.parseInt(store_seq));
		
		if(!stores_detail.getService_id().equalsIgnoreCase(service_id)) {
			return "redirect:/errorpage";
		} else {
			request.setAttribute("stores_detail", stores_detail);
		}
		
		return "/WEB-INF/view/stores/stores-detail.jsp";
	}
	
	
	
	
	
	
	
	
	@GetMapping("{store_seq}/edit")
	public String store_edit(
		HttpServletRequest request,
		HttpServletResponse response,
		HttpSession session,
		@PathVariable("store_seq") String store_seq
	){
		System.out.println("---------------------------store_edit form------------------------------");
		
		Service_Store_DTO stores_detail = service.selectStore(Integer.parseInt(store_seq));
		
		request.setAttribute("store", stores_detail);
		
		return "/WEB-INF/view/stores/stores-new.jsp";
	}
	
	
	
	
	
	
	
	
	/**
	 * 매장 정보 수정 처리
	 * @param \id
	 * @return
	 */
	@PostMapping("{store_seq}")
	public String store_edit_confirm(
		HttpServletRequest request,
		HttpServletResponse response,
		HttpSession session,
		@PathVariable("store_seq") String store_seq
	) {
		Service_Store_DTO stores_detail = new Service_Store_DTO();
		
		stores_detail.setStore_seq(Integer.parseInt(store_seq));
		
		stores_detail.setStore_name(request.getParameter("store_name"));
		stores_detail.setStore_detail(request.getParameter("store_detail"));
		stores_detail.setStore_type(request.getParameter("store_type"));
		stores_detail.setStore_address(request.getParameter("store_address"));
		stores_detail.setStore_tel(request.getParameter("store_tel"));
		stores_detail.setStore_hour(request.getParameter("store_hour"));
		
		System.out.println("sdflsdkfjsdklffsdfsdfsdfsdfsd");
		System.out.println(stores_detail);
		
		int result = service.modifyStore(stores_detail);
		System.out.println(result);
		
		return result>0?"redirect:/stores/"+store_seq+"/edit":"redirect:/errorpage";
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 매장 삭제 처리
	 * @param \id
	 * @return
	 */
	@PostMapping("{store_seq}/delete")
	public String store_delete(@PathVariable("store_seq") String store_seq){
		System.out.println("---------------------------store_delete_logic------------------------------");
		int result = service.deleteStore(Integer.parseInt(store_seq));
		if(result>0) {
			return "redirect:/stores";
		} else {
			return "redirect:/errorpage";
		}
	}
	
}