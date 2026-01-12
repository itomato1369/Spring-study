package com.yedam.app.lombok;

import java.util.Date;

public class LombokExample {

	public static void main(String[] args) {
		User first = new User();
		// User에 Constructor 없는데 Lombok이 알아서 만들어줌
		first.setId("22");
		first.setName("dddd");
		first.setBirthday(new Date());
		
		System.out.println(first);
		
		
		Customer second = new Customer(100, "ABC");
		System.out.println(second.getNo());
		System.out.println(second.getName());
		
		
		
		
		
		
		
		
		
		

	}

}
