package com.yedam.app.java;

public class Restaurant {
	// field
	private Chef chef;
	
	// constructor
	public Restaurant(Chef chef) {
		this.chef = chef;
	}
	
	// 기본 생성자
	public Restaurant() {}
	
	
	// method
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}

}
