package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Web과 관련된 bean을 등록
 * Route 정보 endpoint(HTTP Method + URI) 목표지점
 * + Service 
 * + Return Type (view or data)
 */
@Controller
public class URLController {
//  @RequestMapping(path="get", method=RequestMethod.GET)
	@GetMapping("get")
	@ResponseBody // AJAX
    public String getMapping(String keyword) {
    	return "GET Method : keyword is  " + keyword;
    }
	
//	@RequestMapping(path="post", method=RequestMethod.POST)
	@PostMapping("post")
	@ResponseBody
	public String postMapping(String keyword) {
		return "POST Method : keyword is " + keyword;
	}
	
	
	
	
	
	
	
}
