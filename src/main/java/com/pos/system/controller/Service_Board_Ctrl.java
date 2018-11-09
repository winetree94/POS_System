package com.pos.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.pos.system.dto.Service_Board_DTO;
import com.pos.system.dto.Service_File_DTO;
import com.pos.system.mapper.*;

@Controller
public class Service_Board_Ctrl {
	
	private Service_Board_Update_Mapper mapper_Update;
	private Service_Board_Create_Mapper mapper_Create;
	private Service_Board_Read_Mapper mapper_Read;
	private Service_Board_Delete_Mapper mapper_Delete;
	
	@Autowired
	public Service_Board_Ctrl(Service_Board_Update_Mapper mapper_Update, Service_Board_Create_Mapper mapper_Create,
			Service_Board_Read_Mapper mapper_Read, Service_Board_Delete_Mapper mapper_Delete) {
		this.mapper_Update = mapper_Update;
		this.mapper_Create = mapper_Create;
		this.mapper_Read = mapper_Read;
		this.mapper_Delete = mapper_Delete;
	}

	@GetMapping("/board/new")
	public String home(MultipartFile file) {
		System.out.println("------------------재이 테스트-------------------------");

	//	mapper.uploadFile(fdto);
		Service_File_DTO fDto = new Service_File_DTO();
		fDto.setOrigin_fname("originfname");
		fDto.setStored_fname("storedfname");
		fDto.setFile_size(200);
		Service_File_DTO n = fDto;
		System.out.println(n);
		
		System.out.println("----------------------재이 테스트--------------------------");
		return "./view/board/board-new";
	}
	
	@PostMapping("/board/new")
	public String upload(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			MultipartFile image
			) {
		
		String filename = image.getOriginalFilename();
		System.out.println(filename);
		
		return "redirect:/board/new";
	}

	
	
	
}
