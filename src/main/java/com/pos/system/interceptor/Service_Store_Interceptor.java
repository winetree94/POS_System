package com.pos.system.interceptor;

import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.dto.Service_Store_DTO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class Service_Store_Interceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("접속 차단");
		
		HttpSession session = request.getSession();
		
		Service_Store_DTO store =  (Service_Store_DTO)session.getAttribute("store");
		Service_Account_DTO user = (Service_Account_DTO)session.getAttribute("user");
		
		if(store == null || user == null) {
			return false;
		}
		
		if(
			store.getService_id().equalsIgnoreCase(user.getService_id())
		)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
