package com.yedam.app.mybatis.common;

import java.util.List;

import com.yedam.app.mybatis.mapper.DeptMapper;
import com.yedam.app.mybatis.mapper.DeptMapperImpl;
import com.yedam.app.mybatis.service.DeptVO;

public class MybatisDeptExample {
	// DeptMapperImpl 를 import
	
	private static DeptMapper deptMap = new DeptMapperImpl();

	public static void main(String[] args) {
		//selectAll();
		//selectInfo();
		insertInfo();
		//updateInfo();
		//deleteInfo();
	}
	public static void selectAll() {
		/* generic type DeptVO에 
		 collection framework List
		list라는 변수명으로 배열로 
		new 연산자로 DeptMapperImpl 생성하여 
		deptMap에 있는 Method를 가져와서 저장 후
		향상된 for문으로 dept에 다시 반복해서 집어넣는다 */
		List<DeptVO> list = deptMap.selectAll();
		for(DeptVO dept : list) {
			System.out.println(dept);
		}
	}
	public static void insertInfo() {
		// DeptVO에 lombok @Data 해놓았으니 getter setter알아서 다 되어있음
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(300);
		deptVO.setDepartmentName("Media");
		deptVO.setManagerId(420);
		deptVO.setLocationId(1800);
		
		// set으로 Field값을 바꾼걸 결과 result에 담는데 바뀐column은 1
		// DB가 
		int result = deptMap.insertInfo(deptVO);
		System.out.println(result);
	}
	
	
	
	
	
	
	
	

}
