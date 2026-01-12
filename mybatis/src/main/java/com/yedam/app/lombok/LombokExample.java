package com.yedam.app.lombok;

import java.util.Date;

public class LombokExample {

	public static void main(String[] args) {
		User first = new User();
		first.setId("0100");
		first.setName("Hong");
		first.setBirthday(new Date());
		System.out.println(first);
		System.out.println();
		
		Customer second = new Customer(200, "Kang");
		System.out.println("고객번호 : " + second.getNo());
		System.out.println(second);
		
		
	}

}
