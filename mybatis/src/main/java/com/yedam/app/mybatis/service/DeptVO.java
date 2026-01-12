package com.yedam.app.mybatis.service;

import lombok.Data;
// getter setter 안써도 됨
@Data
public class DeptVO {
	// 실제 DB의 department테이블의 column
	private Integer departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}
