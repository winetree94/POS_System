package com.pos.system.controller;

import com.pos.system.service.IService_Store_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Service_Store Controller
 * REST Design Pattern 적용
 * @author windtree
 */
@Controller
public class Service_Store_Ctrl {

	IService_Store_Service service;
	
	/**
	 * 매장 목록 출력
	 * @param req
	 * @return
	 */
	@GetMapping("/stores")
	public String store_List(HttpServletRequest req){
		
		
		
		return "./store/store-list-form";
	}

	
	@GetMapping("/stores/new")
	public String store_new_form(){
		
		
		
		
		
		
		return "./store/new/new";
	}
	
	@PostMapping("/stores")
	public String store_new(WebRequest req){
		
		
		
		
		
		
		return "redirect:/store";
	}
	
	@GetMapping("/stores/{id}")
	public String store_detail(@PathVariable("id") String id){
		
		
		
		
		
		return "";
	}
	
	@GetMapping("/stores/{id}/edit")
	public String store_edit(@PathVariable("id") String id){
		
		
		
		return "";
	}
	
	@PutMapping("/stores/{id}")
	public String store_edit_confirm(@PathVariable("id") String id) {
		
		
		
		
		return "";
	}
	
	
	@DeleteMapping("/stores/{id}")
	public String store_delete(@PathVariable("id") String id){
		
		
		
		
		return "";
	}
	
}