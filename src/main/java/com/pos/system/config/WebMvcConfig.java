package com.pos.system.config;

import com.pos.system.interceptor.Service_Interceptor;
import com.pos.system.interceptor.Service_Store_Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	private final Service_Interceptor service_Interceptor;
	private final Service_Store_Interceptor service_Store_interceptor;
	
	@Autowired
	public WebMvcConfig(Service_Interceptor service_Interceptor, Service_Store_Interceptor service_Store_interceptor) {
		this.service_Interceptor = service_Interceptor;
		this.service_Store_interceptor = service_Store_interceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(service_Interceptor)
			.addPathPatterns("/sdaf");
		
		
		registry.addInterceptor(service_Store_interceptor)
			.addPathPatterns("/pos/*");
	}
	
}
