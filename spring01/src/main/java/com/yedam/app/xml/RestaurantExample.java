package com.yedam.app.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RestaurantExample {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:xmlApplicationContext.xml");
		
		Restaurant res = ctx.getBean(Restaurant.class);
		res.run();
      
		/* 생성자 injection을 권장 생성자를 통해 DI이후 Bean을 교체할 수 없음 
		 * setter injection은 교체가능 */
		res.setChef(new Chef());
		res.run();
		
		
		
	}

}
