package com.yedam.app.common;

public class RestaurantExample {

	public static void main(String[] args) {
		Chef chef = new Chef();
		// new 연산자 생성자를 이용해서 
		Restaurant res = new Restaurant(chef);
		res.run();
		
		Restaurant sec = new Restaurant();
		sec.setChef(chef);
		res.run();
		
		
		
		
		
		

	}

}
