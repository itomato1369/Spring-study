package com.yedam.app.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Java-based configuration (설정파일)
@Configuration
public class JavaConfig {
	// Spring이 관리할 Bean등록 Method에 등록
	// Chef를 Bean으로 등록하겠다
	@Bean
	public Chef chef() {
		return new Chef();
	}
	
	@Bean
	public Restaurant restaurant (Chef chef) {
		// 생성자 Injection
		Restaurant res = new Restaurant(chef);
		return res;
	}
	
	
	
	
	
}
