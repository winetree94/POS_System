package com.pos.system.test;

import com.github.javafaker.Faker;
import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.dto.Service_Board_DTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Dummy_Data {

	Faker faker = new Faker();
	
	String name = faker.name().firstName();
	
	{
		System.out.println(name);
	}
	
	public List<Service_Account_DTO> Generate_Service_Account() {
		List<Service_Account_DTO> lists = new ArrayList<Service_Account_DTO>();
		for (int i = 0; i < 100; i++) {
			Service_Account_DTO dto = new Service_Account_DTO();
			
			dto.setService_id(faker.name().firstName());
			dto.setService_pw(faker.name().firstName());
			dto.setService_type("A");
			dto.setService_email(faker.internet().emailAddress());
			dto.setDelflag("N");
			
			lists.add(dto);
		}
		return lists;
	}
	
}
