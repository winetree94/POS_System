package com.pos.system.restcontroller;

import com.pos.system.dto.Pos_Auth_DTO;
import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.dto.Service_Store_DTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Store_Comm_Rest_Ctrl {
	
	@GetMapping("/auth")
	public Pos_Auth_DTO getPos(
		HttpServletRequest request,
		HttpServletResponse response,
		HttpSession session
	) {
		
		Service_Account_DTO user = (Service_Account_DTO) session.getAttribute("user");
		Service_Store_DTO store = (Service_Store_DTO) session.getAttribute("store");
		
		System.out.println(user);
		System.out.println(store);
		
		if(
					user != null &&
					store != null &&
					user.getService_id().equalsIgnoreCase(store.getService_id())
		){
			
			return new Pos_Auth_DTO(user.getService_id(), String.valueOf(store.getStore_seq()));
		} else {
			return null;
		}
	}
	
}
