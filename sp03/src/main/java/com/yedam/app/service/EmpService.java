package com.yedam.app.service;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.EmpVO;

public interface EmpService {
	// mapper 에서 만들 이름이랑 다름
	// 사원전체 조회
	public List<EmpVO> selectAll();
	
	// 상세조회
	public EmpVO findByEmployeeId(EmpVO empVO);
	
	// 사원등록
	public int addEmpInfo(EmpVO empVO);
	
	// 사원수정
	public Map<String, Object> modify(EmpVO empVO);
	
	// 사원삭제
	public Map<String, Object> remove(int empId);

}
