package com.yedam.app.emp;

//  yyyy/MM/dd
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	/*
	 * Value Object  값 자체를 표현하는 불변(Read-Only) 객체
	 * Field는 DB의 Column을 기준을 그리고 camelCase로 
	 * 
	 * 
	 *  이용자가 보낼 수도 아닐 수도 있는 값이 있을 수 있으니
	 *  값이 있든 없든 setter호출
	 */
	
	private Integer employeeId; // Primary Key
	private String firstName;
	private String lastName; // NOT NULL
	private String email; // NOT NULL Unique
	private String phoneNumber;
	// 날짜 Type 중요함   java.util.Date 는 이것만 알고 있음 yy/MM/dd
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate; // NOT NULL
	private String jobId; // NOT NULL Foreign Key
	private double salary;
	private double commissionPct;
	private int managerId; // Foreign Key
	private int departmentId; // Foreign Key
	

}
