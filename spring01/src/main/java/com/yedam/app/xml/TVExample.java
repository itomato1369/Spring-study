package com.yedam.app.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVExample {

	public static void main(String[] args) {
		// IoC Container를 관리하는 Interface
		ApplicationContext ctx = 
				// xml 파일을 읽을 때 
				new GenericXmlApplicationContext("classpath:xmlApplicationContext.xml");
		
		// TV.class 해당 class 의 정보를 넘김
		TV tv = ctx.getBean(TV.class);
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		       

	}

}
