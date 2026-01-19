package com.practice.java.department;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/* Lombok이 get set 대신 함*/
@Data
public class DepartmentVO {
	/*
	 *  departments 테이블 
	 *  DB의 정보를 추상화하는 것이 먼저
	 */
	private Integer deptId; // PRIMARY KEY
	private String deptName;
	private int parentDeptId; // FOREIGN KEY 
	private String phoneNumber;
	// 날짜 Type 중요함   java.util.Date 는 이것만 알고 있음 yy/MM/dd
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	private String isLocation;

}
