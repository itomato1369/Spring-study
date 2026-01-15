package com.yedam.app.common.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.service.UserVO;

import lombok.extern.slf4j.Slf4j;

// Log를 남기는 bean
@Slf4j
@Controller
public class ParameterController {
	/*
	 * content-type으로 구분
	 * QueryStirng
	 * format : key=value&key=value&...&key=value
	 * Content-type : application/x-www-format(form tag)-urlencoded(get방식)
	 * HTTP Method 다 쓸 수 있음
	 */
	
	// Command Object : @사용안함 Object
	@RequestMapping("comobj")
	@ResponseBody
	public String commandObject(UserVO user) {
		/* HandlerAdapter
		 new 연산자로 Instance 생성 
		 parsing한 값을 setter이용해서 집어넣음
		 매개변수가 먼저 만들어지고나서 parsing한 data 하나씩 집어넣음
		 없는거 넣으면 pasing할 때 버림 UserVO의 Field명과 같아야함
		*/
		
		log.info("path : /comobj");
		// 이거 log 소문자l임 변수명은 lower
		log.info("= name : " + user.getName());
		log.info("= age : " + user.getAge());
		log.info(user.toString());
	    	
		return "home";
	}
	
	/*
	 * @RequestParam : @ 있음   기본 데이터형 object 단일 값 처리 Wrapper Class 
	 * 
	 */
	@RequestMapping("reqparam")
	@ResponseBody
	public String reqparam(@RequestParam String name
										, Integer age
										, @RequestParam(defaultValue = "No message", name = "msg") 
										  String message) {
		/* @RequestParam 붙으면 필수값
		 * defaultValue를 해주면 값이 안들어왔을 때 
		 * name = "msg" 이걸로 받아야함 
		 */
		
		
		log.info("path : /reqparam");
		/* 단일값으로 받아야함 
		   Error 400 : Bad request 필수값 누락 혹은 data format이 안 맞음 
		   숫자값을 문자로 받았거나 
		   QueryString
		*/
		log.info("= name : " + name);
		log.info("= age : " + age);
	    log.info("= message : " + message);
		return "home";
	}
	
	/*
	 * @PathVariable은 URI 경로에 값이 포함
	 * 보안이 좋다  
	 * key가 없음  
	 * format 없음         기본 data형(단일값)
	 * content-type 없음
	 * {} 안의 이름의 매개변수에 담아줌
	 * 모든 HTTP Method  가능
	 * content-type : 모든 경우 가능
	 * 
	 */
	
	@RequestMapping("pathVal/{name}")
	@ResponseBody
	public String pathVariable(@PathVariable String name) {
		// 경로를 통해서 값을 받겠습니다 
		log.info("path : /path/{name}");
		log.info("= name : " + name);
		return "home";
	}
	
	
	/*
	 * @RequestBody
	 * 
	 * fetch('/users', {
	 * 			headers : {
	 * 				'context-type' : 'application/json',
	 * 			},
	 * 		     body : JSON.stringify({ name: 'dddd'})
	 *  })
	 *  .then(res => res.json())
	 *  .then(result => console.log(result))
	 *  .catch(err => console.log(err));
	 *  
	 *  format : { "key" : "value" }  혹은 [ {}, {}, {}... ]
	 *  name : JSON (JavaScript Object Notation)  xml대체를 위한 data format
	 *  
	 *  JSON
	 *  format : { "key" : "value", "key" : "value" , ... } 
	 *           [ {}, {}, {} ... ]
	 *  content-type : application/json
	 *  HTTP Method : POST, PUT 이 둘은 body를 사용하는 Method (get delete로는 JSON 못넘김)
	 *  @RequestBody : @사용 object, List포함 배열 
	 */
	// POST
	@PostMapping("resbody")
	//  ResponseBody + Map<>    application/json        map은 통신할 때 임시로 담을 때 사용
	@ResponseBody // AJAX용
	public Map<String, Object> requestBody(@RequestBody UserVO user) {
		Map<String, Object> map = new HashMap<>();
		map.put("path", "resbody");
		map.put("data", user);
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
