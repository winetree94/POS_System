package com.pos.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 스프링 부트 애플리케이션 선언
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	/**
	 * 스프링 애플리케이션 실행
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
