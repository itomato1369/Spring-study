package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.EmpVO;
import com.yedam.app.service.EmpService;

// DispacherServlet이 인식하도록
@Controller
public class EmpController {
	/* final 했을 때 초기값 주는 법
	  1) new 연산자로 하거나
	  2) 생성자로 하거나
	  생성자가 하나 뿐이랑 @Autowierd 안해도 됨 
	  매개변수가 없으면 Constructor가 기능안함
	  Constrctor가 1개면 자동으로 DI
	*/
	private final EmpService empService;
	
	public EmpController (EmpService empService) {
		this.empService = empService;
	}
	
	/*
	 * page를 생성하는 server
	 * GET  : 빈page, 조회 단순 조회는 권한 없어도 됨 body가 없다
	 * POST : 데이터 조작 INSERT UPDATE DELETE (body를 사용) 
	 */
	
	// 전체조회              Model = req + res
	@GetMapping("empList")
	public String empList(Model model) {
		// 제공할 service 
		List<EmpVO> list = empService.selectAll();
		// 데이터 담기 "key" : "value"  형태로 "이름"이랑 "실제 데이터"
 		model.addAttribute("emp", list);
		
		// 데이터 담아서 보여줄 page 선택
		return "emp/list";
		// page 이름은 / 시작 하면 안됨
		// prefix = classpath:/templates/
		// subfix = .html
	}
	// 단건조회 QueryString command object or @RequestParam
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		// 제공할 service 
		EmpVO findVO = empService.findByEmployeeId(empVO);
		// 데이터 담기 "key" : "value"  형태로 "emp"이랑 "findVO"
		model.addAttribute("emp", findVO);
		return "emp/info";
	}
	
	// 등록 - 페이지
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	// -처리  Model -> page 통신
	@PostMapping("empInsert") // <form> QueryString page가 바뀌어야함
	public String empInsertProcess(EmpVO empVO) {
		// Service 제공
		int employeeId = empService.addEmpInfo(empVO);
		/* DispacherServlet이 검사       재요청
		 * 어떨때는 페이지만 어떨때는 등록
		 */
		return "redirect:empInfo?employeeId=" + employeeId ;
	}
	
	// 수정 -  페이지 단건조회
	@GetMapping("empUpdate")
	public String empUpdate(EmpVO empVO, Model model) {
		// 제공할 service 
		EmpVO findVO = empService.findByEmployeeId(empVO);
		// 데이터 담기 "key" : "value"  형태로 "emp"이랑 "findVO"
		model.addAttribute("emp", findVO);
		// 보여주는 page는 다름
		return "emp/update";
	}
	// -처리   등록을 처리와 비슷
	@PostMapping("empUpdate")
	@ResponseBody // AJAX 데이터만 반환 AJAX호출하는 함수가 필요함        JSON을 활용
	public Map<String, Object> empUdateProcess(@RequestBody EmpVO empVO) {
		return empService.modify(empVO);
	}
	
	
	//  단건삭제 GET 다중삭제 POST 
	@GetMapping("empDelete")
	// 매개변수가 key
	public String empDelete(int empId) {
		// @RequestParm이 생략
		empService.remove(empId);
		return "redirect:empList";
	}
	
	
	

}
