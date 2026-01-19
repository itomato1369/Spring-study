package com.practice.java.department.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.practice.java.department.DepartmentVO;


/*"com.practice.java.**.mapper" 
 * @MapperScan(basePackages = "com.practice.java.**.mapper") 
 * @Param mybatis꺼임
 * 왜  class가 아닌 interface임?
 * 
 *  DepartmentServiceImpl에서 다시 실제로 어떤 기능을 할지 구현을 함
 */
public interface DepartmentMapper {
	    /*
	     *  Method 선언 껍데기임 
	     */
	   // departments 전체조회
		public List<DepartmentVO> selectAllDepartments();
		
		// 단건조회
		public DepartmentVO selectDepartment(DepartmentVO departmentVO);
		
		// INSERT
		public int insertDepartment(DepartmentVO departmentVO);
		
		// UPDATE
		/*
		 *  public int updateEmp(@Param("eid")int employeeId,
	                     @Param("emp")EmpVO empVO); 이해안됨
		 */
		public int updateDepartment(DepartmentVO departmentVO);
		
		// DELETE
		public int deleteDepartment(int deptId);

}
