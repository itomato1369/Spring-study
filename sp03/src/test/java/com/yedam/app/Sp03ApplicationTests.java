package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.EmpVO;
import com.yedam.app.emp.mapper.EmpMapper;

//　jUnit 環境でも IoC container使用可能 
@SpringBootTest
class Sp03ApplicationTests {
	// Springフレームワークにおいて依存性注入（DI）を行うためのアノテーション
	// Field 依存性注入DI 　test 環境だけ
	@Autowired
	private EmpMapper empMapper;

//	@Test
//	void contextLoads() {
//		assertNotNull(empMapper);
//	}
	
//	@Test
	void selectAll() {
		/*
		 *  List타입은 instance 먼저 만듦  
		 *  class를 만들어요 ResultSet
		 */
		List<EmpVO> list = empMapper.selectEmpAll();
		for (EmpVO emp : list) {
			System.out.println(emp);
		}
		// 二重否定 내부가 비어있는지 아닌지
		assertFalse(list.isEmpty());
	}
	
//	@Test
	void selectEmp() {
		// 조건을 담을 객체가 필요함
		EmpVO empVO = new EmpVO();
		/* EmpVO 클래스 new 연산자로 변수명 empVO에 담겠다
		 * 그리고 empVO에서 Field명 employeeId를 100으로 set
		 */
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmp(empVO);
		/*
		 * EmpMapper 클래스안의 Method selectEmp를 가져와서 findVO에 담아준다 
		 * empVO의 Field명 employee_id에 set되어있는 100이라는 값을 가져온다
		 * DB에서
		 */
		
		System.out.println(findVO);
		/*
		 * console 창에 selectEmp의 결과값을 출력한다
		 */
		
		//               예상, 실제
		assertEquals("King", findVO.getLastName());
		/*
		 * assertEquals 내가 예상한 건 findVO.getLastName()실제 이 Method를 실행 시키면 "King"이라는 
		 * empVO의 Field명 lastName의 값을 가져온다
		 */
	}
	
	@Test
	void insertEmp() {
		/*
		 * new 연산자를 이용해서 새로운 EmpVO객체를 만든다
		 */
		EmpVO empVO = new EmpVO();
		/*
		 * set Method를 이용해서 empVO의 Field 값을 넣어줌
		 */
		empVO.setLastName("Steve");
		empVO.setEmail("samsung@naver.com");;
		empVO.setHireDate(new Date());
		empVO.setJobId("SH_CLERK");
		/*
		 * Dynamic SQL mybatis를 이용해서 실행 제어
		 * if 조건 1개만
		 * 
		 * choose
		 *   when
		 *   when   
		 *     otherwise 
		 * 
		 * empMapper 안의 insertEmp Method를 가져옴
		 */
		
		int result = empMapper.insertEmp(empVO);
		
		assertEquals(1, result);
		
		
	}
	
//	@Test
	void updateEmp() {
	
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Bill");
		empVO.setHireDate(new Date());
		
		

		int result = empMapper.updateEmp(214, empVO);
		
		assertEquals(1, result);
		
	}
	
//	@Test
	void deleteEmp() {
		int result = empMapper.deleteEmp(214);
		assertEquals(1, result);
	}
	
	
	
	
	
	
	
	
	
	
	

}
