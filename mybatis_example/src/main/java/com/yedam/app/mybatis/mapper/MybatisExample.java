package com.yedam.app.mybatis.mapper;

import java.util.List;

public class MybatisExample {
    private EmpMapper empMap = new EmpMapperImpl();
	public static void main(String[] args) {
		selectAll();
		
		

	}
	public static void selectAll() {
		List<EmpV> list = empMap.selectAll();
		for (Empv emp : list) {
			System.out.println(emp);
		}
	}

}
