package com.yedam.app.lombok;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Customer {
	private final Integer no;
	private final String name;
	private String phone;
	private String address;
}
