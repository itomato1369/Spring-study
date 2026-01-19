package com.practice.java.department.service;

import java.util.List;
import java.util.Map;

import com.practice.java.department.DepartmentVO;

public interface DepartmentService {
	     /* mapper 에서 만든 이름이랑 다름 
	      * 왜 다르지? 여기서도 껍데기만 만들었음
	      * 
	      * */
	
		// departments 전체 조회
		public List<DepartmentVO> selectAllDepartments();
		
		// 상세조회
		public DepartmentVO findByDepartmentId(DepartmentVO deptVO);
		
		// INSERT departments
		public int registerDepartment(DepartmentVO deptVO);
		
		// UPDATE departments
		public Map<String, Object> modifyDepartment(DepartmentVO deptVO);
		
		// DELETE departments
		public Map<String, Object> removeDepartment(int deptId);

}
