package com.icrypt.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import com.icrypt.app.tenantcontext.ClientDatabase;
import com.icrypt.app.tenantcontext.CustomerContextHolder;
@Configuration
public class DataSourceIntercepter implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String branch = request.getHeader("client");
		if (ClientDatabase.CLIENT_A.toString().equalsIgnoreCase(branch))
			CustomerContextHolder.set(ClientDatabase.CLIENT_A);
		else
			CustomerContextHolder.set(ClientDatabase.CLIENT_B);
		
		return true;
	}
}
