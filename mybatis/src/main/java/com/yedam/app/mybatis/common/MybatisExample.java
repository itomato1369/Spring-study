package com.yedam.app.mybatis.common;

import java.util.List;

import com.yedam.app.mybatis.mapper.EmpMapper;
import com.yedam.app.mybatis.mapper.EmpMapperImpl;
import com.yedam.app.mybatis.service.EmpVO;

public class MybatisExample {
	private static EmpMapper empMap = new EmpMapperImpl();
	
	public static void main(String[] args) {
		//selectAll();
		//selectInfo();
		//insertInfo();
		//updateInfo();
		deleteInfo();

	}
	public static void selectAll() {
		List<EmpVO> list = empMap.selectAll();
        for(EmpVO emp : list) {
            System.out.println(emp);
        }
	}
	
	public static void selectInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(100);
		
		EmpVO findVO = empMap.selectInfo(emp);
		System.out.println(findVO);
	}
	public static void insertInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("di");
		empVO.setEmail("dd@naver.com");
//		FK값
		empVO.setJobId("IT_PROG");
		
		int result =  empMap.insertInfo(empVO);
		System.out.println(result);
	}
	public static void updateInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(212);
		empVO.setFirstName("Steven");
		empVO.setSalary(10000);
		
		int result =  empMap.updateInfo(empVO);
		System.out.println(result);
	}
	public static void deleteInfo() {
		int result = empMap.deleteInfo(212);
		System.out.println(result);
		
	}
	
	
	
}
