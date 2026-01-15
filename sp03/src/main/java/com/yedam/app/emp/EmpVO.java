package com.yedam.app.emp;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	/*
	 * Value Object  값 자체를 표현하는 불변(Read-Only) 객체
	 * Field는 DB의 Column을 기준을 그리고 camelCase로 
	 */
	
	private Integer employeeId; // Primary Key
	private String firstName;
	private String lastName; // NOT NULL
	private String email; // NOT NULL Unique
	private String phoneNumber;
	// 날짜 Type 중요함
	private Date hireDate; // NOT NULL
	private String jobId; // NOT NULL Foreign Key
	private double salary;
	private double commissionPct;
	private int managerId; // Foreign Key
	private int departmentId; // Foreign Key
	

}
