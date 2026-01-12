package com.yedam.app.lombok;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Customer {
	// Integer 클래스의 특징 및 용도 상수 제공, 
	// Wrapper Class 사용하는 이유 통신을 위해 int는 공백을 모르니까 
	private final Integer no;
	private final String name;
	private String phone;
	private String address;

}
