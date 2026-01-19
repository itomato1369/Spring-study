package com.practice.java.department.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.java.department.DepartmentVO;
import com.practice.java.department.service.DepartmentService;

@Controller
public class DepartmentController {
	/* final 했을 때 초기값 주는 법
	  1) new 연산자로 하거나
	  2) 생성자로 하거나
	  생성자가 하나 뿐이라 @Autowierd 안해도 됨 
	  매개변수가 없으면 Constructor가 기능안함
	  Constrctor가 1개면 자동으로 의존성 주입함
	*/
	private final DepartmentService deptService;
	
	public DepartmentController (DepartmentService deptService) {
		this.deptService = deptService;
	}
	/*
	 * page를 생성하는 server
	 * GET  : page조회 단순 조회는 권한 없어도 됨 body가 없다
	 * POST : 데이터 조작 INSERT UPDATE DELETE (body를 사용) 
	 */
	
	// 전체조회
	@GetMapping("deptList")
	public String deptList(Model model) {
		/*
		 *  deptList URI로 제공할 서비스 
		 *  selectAllDepartments이거 실행한 값을 page에다 
		 */
		List<DepartmentVO> list = deptService.selectAllDepartments();
		/*DepartmentService Interface에서 선언한 함수 쓴다
		 * DepartmentsServiceImpl 에서 @Override한 
		 * selectAllDepartments이 함수의 return은
		 * DepartmentMapper의 selectAllDepartments임
		 * 
		 * properties파일에 mybatis.mapper-locations=classpath:mapper/*.xml
		 * 그러면 resources/mapper/*.xml파일 찾아감
		 * 
		 * 그 파일에는 <mapper namespace="com.practice.java.department.mapper.DepartmentMapper">
		 * 가 있어서 찾아감
		 * 
		 * @MapperScan(basePackages = "com.practice.java.**.mapper")
		 * 이게 있어서 잘 찾아감 
		 * 
		 * <select id="selectAllDepartments" resultType="DepartmentVO">
		 * id는 DepartmentMapper의  selectAllDepartments찾아감 
		 * 
		 * resultType은 mybatis.type-aliases-package=com.practice.java 지정해서
		 * class이름 찾아감
		 * 
		 */
		model.addAttribute("dept", list);
		/*
		 *  Model = req + res  .addAttribute는 
		 *  위에서 실행한 Method의 값을 list에 담았지 그걸 이름"dept"로 쓰겠다
		 *  html 파일에서  th:object="${dept}" 로 사용 해서 전달
		 */	
		return "dept/list";
		/*
		 * 꼭 return은 page를 줘야함
		 *  dept아래 list라는 이름의 .html
		 *  prefix = classpath:/templates/dept/list
		     suffix = .html
		 *  
		 *   END OF deptList
		 */
	}
	
	// 단건 조회 QueryString
	@GetMapping("deptInfo")
	public String deptInfo(DepartmentVO deptVO, Model model) {
		/*
		 *  매개변수 받아야함 deptId를 가져와야하니까
		 *  URI deptInfo를 통해 제공할 서비스는 이용자가 입력한
		 *  정보의 body에서 deptId를 가져온다?
		 *  
		 *   department-map.xml의 id="findByDepartmentId"
		 *   그거를 DepartmentServiceImpl의 findByDepartmentId Method 실행
		 *   findByDepartmentId의 매개변수  타입은 DepartmentVO
		 *   
		 *   그 안의 DepartmentMapper의 selectDepartment 실행
		 *   
		 *   DB조회한 값을 findVO변수에 담는다
		 *  
		 */
		
		DepartmentVO findVO = deptService.findByDepartmentId(deptVO);	
		
		/*
		 * model이라는 req + res 객체에 담아서 dept라는 name으로 html파일에 사용
		 * findVO의 값을 담아서 전달
		 */
		model.addAttribute("dept", findVO);
		/*
		 * controller는 return을 꼭 page를 준다
		 */
		
		return "dept/info";
	}
	
	// INSERT 페이지
	@GetMapping("deptInsert")
	
	// INSERT 기능 처리
	@PostMapping("deptInsert")
	

	// UPDATE 페이지 는 URL에서  https://localhost8080/dept/deptUpdate?deptId=입력 로 찾아감
	@GetMapping("deptUpdate")
	
	// UPDATE 기능 처리
	@PostMapping("deptUpdate")
	
	// DELETE 페이지
	@GetMapping("deptDelete")
	
	// DELETE 기능 처리
	@PostMapping("deptDelete")
	
	
	
	
	
	
	
	
	

}
