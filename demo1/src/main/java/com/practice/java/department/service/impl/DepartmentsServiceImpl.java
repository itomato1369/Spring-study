package com.practice.java.department.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.practice.java.department.DepartmentVO;
import com.practice.java.department.mapper.DepartmentMapper;
import com.practice.java.department.service.DepartmentService;

import lombok.RequiredArgsConstructor;

//business bean 생성 AOP를 적용
@Service
//Construcotr 생성자 주입
@RequiredArgsConstructor
public class DepartmentsServiceImpl implements DepartmentService {
	/*
	 *  mapper호출 그래야 department-map.xml의 id가 selectAllDepartments인 쿼리문 실행해서
	 *  DepartmentMapper에게 주고 Service 구현 하는 객체인 DepartmentsServiceImpl에게 전달
	 *  mapper에 있는 Method를 사용하니까
	 */
	 private final DepartmentMapper deptMapper;
    
	 // 전체조회
	@Override
	public List<DepartmentVO> selectAllDepartments() {
		return deptMapper.selectAllDepartments();
	}
    
	// 단건조회
	@Override
	public DepartmentVO findByDepartmentId(DepartmentVO deptVO) {
		/*
		 * deptId를 받아야 하니까 매개변수 deptVO를 받음
		 * 실행하는 기능
		 */
		return deptMapper.selectDepartment(deptVO);
	}

	// INSERT
	@Override
	public int registerDepartment(DepartmentVO deptVO) {
		// ?? 
		return ;
	}

	// UPDATE
	@Override
	public Map<String, Object> modifyDepartment(DepartmentVO deptVO) {
	
		return ;
	}

	// DELETE
	@Override
	public Map<String, Object> removeDepartment(int deptId) {
	
		return ;
	}

}
