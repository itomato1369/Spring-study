package com.yedam.app.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
// business 로직에 해당하는 객체 처리하는 class
// AOP를 적용하는 객체
@Service
public class EmpServiceImpl implements EmpService {

	// 전체 사원조회 DB에 접속하는 mapper가 필요함
	private EmpMapper empMapper;
	
	// 의존성 주입 injection 생성자가 하나일 경우 무조건 생성자 주입
	@Autowired 
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}
	public EmpServiceImpl() {}
	
	@Override
	public List<EmpVO> findAll() {	
		return empMapper.selectAll();
	}
	
	
	
	
	
	
	

}
