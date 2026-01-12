package com.yedam.app.xml;

public class Restaurant {
	// field
	private Chef chef;
	
	// constructor
	public Restaurant(Chef chef) {
		this.chef = chef;
	}
	
	// 기본 생성자가 있어야 setter injection
	public Restaurant() {}
	
	
	// method
	public void setChef(Chef chef) {
		System.out.println("setter injection");
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}

}
