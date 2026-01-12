package com.yedam.app.anotation;

import org.springframework.stereotype.Component;

// Bean으로 등록할 Class임
@Component
public class Chef {
	public void cooking() {
		System.out.println("나폴리맛피아");
	}

}
