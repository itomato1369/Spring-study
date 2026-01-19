package com.practice.java;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.java.department.DepartmentVO;
import com.practice.java.department.mapper.DepartmentMapper;

@SpringBootTest
class DemoApplicationTests {
	
	/* */
	@Autowired
	private DepartmentMapper deptMapper;
	
	@Test
	void testGetDepartmentList() {
		assertNotNull(deptMapper);
		List<DepartmentVO> list = deptMapper.selectAllDepartments();
		
		assertNotNull(list);
		assertFalse(list.isEmpty());
		
	}

//	@Test


}
