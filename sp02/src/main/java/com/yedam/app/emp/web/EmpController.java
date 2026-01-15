package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;
// Lombok final Field를 활용한 생성자 
@RequiredArgsConstructor
// Router 역할을 하는 객체
@Controller 
public class EmpController {
	private final EmpService empService;
	
	// endpoint  URI가 empList   GET Method
	// endpoint
	@GetMapping("/empList")
	public String empList(Model model) {
		// service
		List<EmpVO> list = empService.findAll();
		// return routing
		model.addAttribute("emps", list);
		return "empList";
	}
	
	

}
