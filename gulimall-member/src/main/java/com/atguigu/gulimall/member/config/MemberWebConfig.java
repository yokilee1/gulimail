package com.atguigu.gulimall.member.config;

import com.atguigu.gulimall.member.interceptor.LoginUserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * <p>Title: MemberWebConfig</p>
 * Description：
 */
@Configuration
public class MemberWebConfig implements WebMvcConfigurer {

	@Autowired
	private LoginUserInterceptor loginUserInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginUserInterceptor).addPathPatterns("/**").excludePathPatterns(Arrays.asList("/login","/member/member/login"));
	}
}
