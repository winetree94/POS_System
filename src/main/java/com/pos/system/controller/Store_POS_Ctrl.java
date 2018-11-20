package com.pos.system.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
public class Store_POS_Ctrl {

	@GetMapping("/pos")
	public String home() {
		System.out.println("pos connected");
		return "index.html";
	}

}
