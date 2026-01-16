package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.EmpVO;
import com.yedam.app.service.EmpService;

import lombok.RequiredArgsConstructor;

/*
 * Web과 관련된 bean을 등록
 * Route 정보 endpoint(HTTP Method + URI) 목표지점
 * + Service 
 * + Return Type (view or data)
 */
@Controller
@RequiredArgsConstructor
/*
 * @RequiredArgsConstructor는 Lombok 라이브러리에서 제공하는 어노테이션으로, 
 * final 필드들을 초기화하는 Constructor를 자동으로 생성해 줍니다.
 */
public class ThymeleafController {
	/* final 했을 때 초기값 주는 법
	  1) new 연산자로 하거나
	  2) 생성자로 하거나
	  생성자가 하나 뿐이랑 @Autowierd 안해도 됨 
	  매개변수가 없으면 Constructor가 기능안함
	  Constrctor가 1개면 자동으로 Dependency Injection
	*/
	private final EmpService empService;

	
	@GetMapping("thymeleaf")
	public String thymeleaf(Model model) {
		List<EmpVO> list = empService.selectAll();
		// model에 담긴 대상만 사용가능 "list"는 변수명 .html에서 사용할 변수명
		model.addAttribute("list", list);
		
		
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		EmpVO findVO = empService.findByEmployeeId(empVO);
		// model에 담긴 대상만 사용가능 "info"는 변수명
		model.addAttribute("info", findVO);
		return "common";
	}
}
