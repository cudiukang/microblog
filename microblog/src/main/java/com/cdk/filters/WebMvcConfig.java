package com.cdk.filters;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		InterceptorRegistration ir = 
				registry.addInterceptor(new LoginInterceptor());
		ir.addPathPatterns("/profile");
		ir.addPathPatterns("/publish");
//		ir.excludePathPatterns("/");
//		ir.excludePathPatterns("/login");
//		ir.excludePathPatterns("/quit");
//		ir.excludePathPatterns("/bootstrap/**");
//		ir.excludePathPatterns("/js/**");
	}
	
}
