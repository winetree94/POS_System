package com.pos.system.config;

import com.pos.system.interceptor.Service_Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	private final Service_Interceptor service_Interceptor;
	
	@Autowired
	public WebMvcConfig(Service_Interceptor interceptor){
		this.service_Interceptor = interceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(service_Interceptor)
			.addPathPatterns("/stores");
	}
	
}
