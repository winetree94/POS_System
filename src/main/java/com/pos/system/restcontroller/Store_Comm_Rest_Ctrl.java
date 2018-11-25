package com.pos.system.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/pos")
public class Store_Comm_Rest_Ctrl {
	
	@GetMapping("/dflkj")
	public String getPos() {
		
		return "";
	}
	
}
