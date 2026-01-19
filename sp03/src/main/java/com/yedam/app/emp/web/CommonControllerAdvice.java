package com.yedam.app.emp.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

/*
 *  Thymeleaf에서 요구하는 방식
 *  모든 controller에 공통으로 적용
 *  AOP기능을 하는 Advice
 */
@ControllerAdvice
public class CommonControllerAdvice {
	/*
	 *  모든 page 공통적으로 사용하는 변수
	 *  AJAX쓰거나 하는 경우에 필요함
	 */
	@ModelAttribute("contextPath")
	public String contextPath(HttpServletRequest req) {
		return req.getContextPath() ;
		// server가 가지고 있는 contextPath는 HttpServletRequest의 request객체가 가짐
	}

	
}
