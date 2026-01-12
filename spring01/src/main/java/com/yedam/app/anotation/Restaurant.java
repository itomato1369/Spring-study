package com.yedam.app.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	// field
	private Chef chef;
	
	// constructor
	// DI 주입
	@Autowired
	public Restaurant(Chef chef) {
		System.out.println("생성자 Injection");
		this.chef = chef;
	}
	
	// 기본 생성자
	public Restaurant() {}
	
	
	// method
	public void setChef(Chef chef) {
		System.out.println("setter Injection");
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}

}
